//////////*******Root.js******//////

/////Ce module definier les routes du logiciels 
///Author : TIGHILT Massinissa
//Version : 0.1
//Date dernier mise a jours : 01/05/2021


////******Les imports********////
//module utilisateur
var utilisateur = require('../modules/Utilisateur.js');
//importer expresse 
const express = require('express');
const router = express.Router();


///La page d'authentification 
router.get('/', function(req, res){
	res.render('./pages/authentification.ejs', {pseudo : '', password : ''});
});

///Le login 
router.post('/login', async function(req, res){
	/////cree l'objet utilisateur 
	let user = new utilisateur(req.body.pseudo, req.body.password); 
	///verifier si l'utilisateur existe 
	let resultat = await user.authentification();

	if(resultat.test == false){
		//Returner la page d'authentification avec l'erreur 
		res.render('./pages/authentification.ejs', {pseudo: resultat.message.pseudo, password: resultat.message.password});
	}else{
	///initialiser l'id de l'utilisateur au format json pour l'envoyer au client		
		let id = JSON.stringify(resultat.id);
		let type = JSON.stringify(resultat.type);
		//envoyer la page principale avec l'id 
			//res.render('./pages/principale.ejs', {id : id});
			res.redirect('/principale/'+resultat.id);

	}
});

//Manipulation du robot
router.get('/manipulation/:id', function(req, res){
			
	let id = JSON.stringify(req.params.id);
	res.render('./pages/manipulation.ejs', {id: id, type: 1});
});


///la page principale
router.get('/principale/:id', function(req, res){
	
	let id = JSON.stringify(req.params.id);
	res.render('./pages/principale.ejs', {id : id});
});

/*Gestion des comptes*/
router.get('/comptes/:id', async function(req, res){
	
	/////cree l'objet utilisateur 
	let user = new utilisateur();
	let profil =  await user.chercherUser(req.params.id);
	let userActuel = {
		id : req.params.id,
		type : profil[0].type
	};
	if(profil[0].type==1){
		//// initialiser le array qui va contenir tout les utilisateur  au format json pour l'envoyer au client	
	let users = JSON.stringify(await user.readUsers());
	let mes = "";
	mes = JSON.stringify(mes);
	userActuel = JSON.stringify(userActuel);
	//envoyer la page gestion des compte avec la liste des utilisateur , message d'erreur et l'utilisateur actuel 
	res.render('./pages/gestion compte.ejs', {users : users, messages : mes, userActuel: userActuel});
	}else{
		res.redirect('/principale/'+userActuel.id);
	}
	
});
///////ajouter un compte utilisateur
	router.post('/nouveauUtilisateur', async function(req, res){
	/////cree l'objet utilisateur 
	let user = new utilisateur()
	///insertion d'un utilisateur et initialiser le message d'erreur(si il ya une erreure ) au format json pour l'envoyer au client	
	let reponse = JSON.stringify(await user.insertUser(req.body));
	//// initialiser le nouveau arary qui va contenir tout les utilisateur  au format json pour l'envoyer au client	
	let users = JSON.stringify(await user.readUsers());

	let userActuel = {
		id : req.body.idActuel,
		type : 1
	};
	userActuel = JSON.stringify(userActuel);
	//envoyer la page gestion des compte avec la liste des utilisateur , message d'erreur et l'utilisateur actuel 
	res.render('./pages/gestion compte.ejs', {users : users, messages: reponse, userActuel: userActuel});

});
///supprimer un compte utilisateur 
router.get('/supprimerUtilisateur/:id/:idActuel', async function(req, res){
	/////cree l'objet utilisateur 
	let user = new utilisateur();
	///suppression d'un utilisateur et initialiser le message d'erreur(si il ya une erreure ) au format json pour l'envoyer au client	
		let reponse  = await user.deleteUser(req.params.id,req.params.idActuel);
	
	//// initialiser le arary qui va contenir tout les utilisateur  au format json pour l'envoyer au client	
	let users = JSON.stringify(await user.readUsers());
	//initialer 
	reponse = JSON.stringify(reponse);

	let userActuel = {
		id : req.params.idActuel,
		type : 1
	};

	userActuel = JSON.stringify(userActuel);
	//envoyer la page gestion des compte avec la liste des utilisateur , message d'erreur et l'utilisateur actuel 
	res.render('./pages/gestion compte.ejs', {users : users, messages: reponse, userActuel: userActuel});
	
});
///modifier un compte utilisateur 
router.post('/modifierCompte', async function(req, res){

	let userActuel = {
		id : req.body.idActuel,
		type : 1
	};
	////cree l'objet utilisateur 
	let user = new utilisateur();

	///Modification de l'element et recuperation du message d'erreure 
	let reponse = await user.modifieUser(req.body);
	let users = await user.readUsers();
	users = JSON.stringify(users);
	reponse = JSON.stringify(reponse);
	userActuel = JSON.stringify(userActuel);
	//envoyer la page gestion des compte avec la liste des utilisateur , message d'erreur et l'utilisateur actuel 
	res.render('./pages/gestion compte.ejs', {users : users, messages: reponse, userActuel: userActuel});
});
/*Gestion de profil*/
router.get('/profil/:id', async function(req, res){
	////cree l'objet utilisateur 
	let user = new utilisateur();
	//rechercher le profil a modifier 
	let profil = await user.chercherUser(req.params.id);

	profil = JSON.stringify(profil[0]);

	let message = "";
	message = JSON.stringify(message);
	/*Gestion du profile*/
	res.render('./pages/profil.ejs', {user : profil, message : message});

});
router.post("/updateUser", async function(req, res){

	let user = new utilisateur();
	let reponse = await user.modifierProfil(req.body);

	if(reponse == "true"){
		let id = JSON.stringify(req.body.id);
		res.redirect('/principale/'+req.body.id);
	}else{
		let profil = await user.chercherUser(req.body.id);

		profil = JSON.stringify(profil[0]);
		reponse = JSON.stringify(reponse);
		res.render('./pages/profil.ejs', {user : profil,message : reponse});
	}
});

///La page du robot 
router.get('/robot', function(req, res){
	res.render('./pages/robot.ejs');
});


module.exports = router;
