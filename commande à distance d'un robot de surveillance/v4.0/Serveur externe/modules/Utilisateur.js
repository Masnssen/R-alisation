///Les imports
////Importer le module mysql 

const mysql = require('mysql');

///Initialiser les donnees de connection a la base de donnee 
mysqldata = {
	host: "localhost",
	user : "massi",
	password : "massi",
	database : "cdta"
};

class Utilisateur {
	
	
	//ce contructeur sert a cree un utilisateur avant authententification 
	constructor(pseudo, motDepasse){

		this.pseudo = pseudo;
		this.password = motDepasse;
	}


	//methode qui sert a verfier si l'utilisateur existe, et returne un resultat 
	authentification(){

		let reponse = {
			test : false,  //true si utilisateur existe , false sinon
			message : { //message d'erreur 
				pseudo : "", 
				password : ""
			},
			id : '' ,//l'id de l'utilisateur si il existe 
		};

		///Initialiser pseudo et password a utiliser dans la promise
		let pseudo = this.pseudo;
		let password = this.password;

		return new Promise(function(resolve, reject){  // fonction qui return un resultat avec resolve et error avec reject
			//create connection
			let db = mysql.createConnection(mysqldata);
			//connection 
			db.connect(function(err){

				if(err){throw err;}
				/// La requete SQL
				let sql = 'SELECT * FROM Utilisateur WHERE pseudo = ?'
				//executer la requete SQL
				db.query(sql, [pseudo], function(err, result , field){

					if(err) throw err;

					///Verifier si aucun utilisateur existe
					if(result.length == 0){
						///Affecter le message d'erreur
						reponse.message.pseudo = "pseudonyme incorrect";
						resolve(reponse);

					}else if(password == result[0].password){   ///mot de passe correcte alors connection
						reponse.test = true;
						reponse.id = result[0].idUtilisateur;
						resolve(reponse);
					}else{///Mot de passe faux 
						reponse.message.password = "Mot de passe incorrect";
						resolve(reponse); 
					}
				});
			});
		});
	}

	///**Fonction qui compare les priviliges d'un utilisateur a avec un utilisateur b**//
	/////On lui donne l'id des deux utilisateur 
	////// - utilisateur a qui est plus previliger que b elle return true sinon false
	///Si erreur elle return un messsage d'erreur

	static  gestionPrivilege(idA, idB){

		return new Promise(async function(resolve, reject){

			///sauvegarder les privilege
			let privA; 
			let privB;

			//cree la requete
			let sql = 'SELECT privilege FROM Utilisateur WHERE idUtilisateur = ?';
			
			//Cree la connection
			let db =  mysql.createConnection(mysqldata);

			
			//connection
		    db.connect(function(err){
				if(err) throw err;
				
				//executer la requete sql pour recuperer privilege de utilisateur a
				db.query(sql, [idA], function(err, result, field){
					console.log("requete 1");
					if(err) throw err;
					//Verifier si aucun resultat est returner
					if(result.length == 0){
						resolve(false);
					}else{
						privA = result[0].privilege;
					}
				});

				//executer la requete sql pour recuperer privilege de utilisateur b
				db.query(sql, [idB], function(err, result, field){
					console.log("requete 2");
					if(err) throw err;
					//Verifier si aucun resultat est returner
					if(result.length == 0){
						resolve(false);
					}else{
						privB = result[0].privilege;
					}
					console.log(privA, " ", privB);
					if(privA < privB){
						console.log("Utilisateur", false);
						resolve(false);
					}
					else{
						console.log("Utilisateur", true);
						resolve(true);
					} 
				}); 
			});	
		});
	}
	// inserer un user 
	insertUser(user){
		return new Promise(function(resolve, reject){// fonction qui return un resultat avec resolve et error avec reject
			//requete de verification si le user inserer existe deja  
			let sqlVerifie = "SELECT * FROM Utilisateur WHERE pseudo = ? AND idUtilisateur != ?";
			//requete sql d'ajout du new utilisateur 
			let sql = "INSERT INTO Utilisateur (idUtilisateur, pseudo, password, nom, prenom, sexe, dateNaissance, type,privilege) VALUE ( ?,?,?, ?, ?, ?, ?, ?, ? )";
			////create connection
			let db  = mysql.createConnection(mysqldata);
			//connexion 
			db.connect(function(err){
				if(err) throw err;
				//execution de la requete de verification 
				db.query(sqlVerifie, [user.pseudo, user.id], function(err, result, fields){
					if(err) throw err;
					///le user existe deja retourner le message d'erreur
					if(result.length > 0){
						resolve("Pseudo existe deja");						
					}else{//le new user n'existe pas deja 
						//executer la requete SQL
						db.query(sql, [user.id, user.pseudo, user.password, user.nom, user.prenom, user.sexe, user.dateNaissance, user.type,user.privilege], function(err, result){
							if(err) throw err;
							///l'insertion est reussis
							if(result.affectedRows == 1){
								resolve("Insertion reussite");
							}else{//sinon
								resolve("Erreur lors de l'insertion de l'utilisateurs");
							}	
						});
					}
				}); 
			});
		});
		
	}
	///suppression d'un utilisateur 
	deleteUser(id,idActuel){

	return new Promise(function(resolve, reject){// fonction qui return un resultat avec resolve et error avec reject
		if(id==idActuel){
			resolve("Utilisateur connecter");
		}else{
			///la requete sql de supression 
		let sql = 'DELETE FROM Utilisateur WHERE idUtilisateur = ?';
		//////create connection
		let db = mysql.createConnection(mysqldata);
		///connexion 
		db.connect(function(err){
			if(err) throw err;
			//execution de la requete sql
			db.query(sql, [id], function(err, result){
				if(err) throw err;
				///verification de la suppresion 
				if(result.affectedRows == 1){
					resolve("Suppression reussite");
				}else{
					resolve("Erreur lors de la suppression");
				}
			});
		});
		}
		
	});
	}
	////modification d'utilisateur 
	modifieUser(user){
		return new Promise(function(resolve, reject){// fonction qui return un resultat avec resolve et error avec reject
			///requete sql de verification du new user inserer si il existe deja 
			let sqlVerifie = "SELECT * FROM Utilisateur WHERE pseudo = ? AND idUtilisateur != ?";
			////requete sql de modification 
			let sql = "UPDATE Utilisateur set pseudo = ?, password = ?, nom = ?, prenom = ?, sexe = ?, dateNaissance = ?,type = ?,privilege = ? WHERE idUtilisateur = ?";
			///creation de connexion 
			let db  = mysql.createConnection(mysqldata);
			///connexion 
			db.connect(function(err){
				if(err) throw err;
				///execution de la requete de verification  
				db.query(sqlVerifie, [user.pseudo, user.id], function(err, result, fields){
					if(err) throw err;
					///renvoi du message d'erreur si le user existe deja 
					if(result.length > 0){
						resolve("Pseudo existe deja");
					}else{///sinon
						///execution de la requete de modification 
						db.query(sql, [user.pseudo, user.password, user.nom, user.prenom, user.sexe, user.dateNaissance,user.type,user.privilege ,user.id], function(err, result){
							if(err) throw err;
	
							resolve("true");
						
						});
					}
	
					
	
				}); 
			});
		});
	}		
////modification d'utilisateur 
modifierProfil(user){
	return new Promise(function(resolve, reject){// fonction qui return un resultat avec resolve et error avec reject
		///requete sql de verification du new user inserer si il existe deja 
		let sqlVerifie = "SELECT * FROM Utilisateur WHERE pseudo = ? AND idUtilisateur != ?";
		////requete sql de modification 
		let sql = "UPDATE Utilisateur set pseudo = ?, password = ?, nom = ?, prenom = ?, sexe = ?, dateNaissance = ?, email = ?, tel = ?  WHERE idUtilisateur = ?";
		///creation de connexion 
		let db  = mysql.createConnection(mysqldata);
		///connexion 
		db.connect(function(err){
			if(err) throw err;
			///execution de la requete de verification  
			db.query(sqlVerifie, [user.pseudo, user.id], function(err, result, fields){
				if(err) throw err;
				///renvoi du message d'erreur si le user existe deja 
				if(result.length > 0){
					resolve("Pseudo existe deja");
				}else{///sinon
					///execution de la requete de modification 
					db.query(sql, [user.pseudo, user.password, user.nom, user.prenom, user.sexe, user.dateNaissance, user.email, user.tel,user.id], function(err, result){
						if(err) throw err;

						resolve("true");
					
					});
				}

				

			}); 
		});
	});
	}		
	//////rechercher un utilisateur grace un id 
	chercherUser(id){
		////requete de recherche 
		var sql1 = 'SELECT * FROM Utilisateur WHERE idUtilisateur = ?';
	
		return new Promise(function(resolve, reject){// fonction qui return un resultat avec resolve et error avec reject
			///creation de connexion 
		let db = mysql.createConnection(mysqldata);
			///connexion 
		db.connect(function(err){

			if (err) {throw err;}
			////execution de la requete 
				db.query(sql1, [id], function(err, result, field){

					if(err) {throw err;};
					///renvoi du message d'erreur si aucun utilisateur existe avec l'id entrer 
					if(result.length == 0){
						reject("No elements");
					}else{///sinon renvoi de l'utilisateur trouver 
						
						resolve(result);
					}
					
				});
		})
	});	

}
///// renvoi tout les utilisateur de la base de donnée 
	readUsers(){
		////requete sql
			var sql2 = 'SELECT * FROM Utilisateur';
		
		return new Promise(function(resolve, reject){/// fonction qui return un resultat avec resolve et error avec reject
			///creation connexion 
			let db = mysql.createConnection(mysqldata);
			////connexion 
			db.connect(function(err){
	
				if (err) {throw err;}
				///execution de la requete 
					db.query(sql2, function(err, result, field){
	
						if(err){throw err;}
						///renvoi des utilisateur 
						resolve(result);
					});
				
	
			})
		});	
	
	}

}


module.exports = Utilisateur;