/*Initialisation des variable*/


var index = -1; //L'index de l'utilisateur selectionner

var remarque = { //Sauvegarder les erreurs du formulaire si elle existe 
	test : true,
	nom : "",
	prenom : "",
	sexe :"",
	pseudo : "",
	password : "",
	date : "",
	type : "",
	privilege:""
};  

var tab = document.getElementById('tableaux'); //le tableau des utilisateur

var formulaire = document.getElementById('form'); //Le formulaire

var nouveau = document.getElementById('nouveau');//Le button pour cree un nouveau elements
nouveau.addEventListener('click', reinitialiser);

var supprimer = document.getElementById('supprimer'); //button supprimer 


document.getElementById('idActuel').value = userActuel.id;
document.getElementById('idActuel').style.display = "none";


//Pour reinitialiser les champs
function reinitialiser(){
	formulaire.reset();
	document.getElementById('idActuel').value = userActuel.id;

	formulaire.elements.id.disabled = true;
	formulaire.elements.enregistrer.value = "Enregistrer";	
	index = -1;
	
	var x = document.getElementById("privilege");
	for (let i = x.length - 1; i >= 0; i--) {
		x.remove(i);
	}
	for (let i = 1; i <=users.length+1; i++) {
		var option = document.createElement("option");
		option.text = i;
		x.add(option)
	}
	
}
reinitialiser();

/*Message d'indication*/
if(message != ""){
	afficheErreur(message);
}


/*Remplissage du tableau*/

for(let i = 0; i < users.length ; i++){
	//creation d'une ligne
	let ligne = document.createElement('tr');
	
	//creation d'une colone et l'initialiser a l'id 
	column = document.createElement('td');
	column.textContent = users[i].idUtilisateur;
	ligne.appendChild(column);
//creation d'une colone et l'initialiser au nom
	column = document.createElement('td');
	column.textContent = users[i].nom;
	ligne.appendChild(column);
//creation d'une colone et l'initialiser au prenom 
	column = document.createElement('td');
	column.textContent = users[i].prenom;
	ligne.appendChild(column);
//creation d'une colone et l'initialiser au pseudo
	column = document.createElement('td');
	column.textContent = users[i].pseudo;
	ligne.appendChild(column);
//creation d'une colone et l'initialiser au password
	column = document.createElement('td');
	column.textContent = users[i].password;
	ligne.appendChild(column);

	///initialisation du listner clic :fonction modifier
	ligne.addEventListener('click', modifier);
	///ajouter la ligne 
	tab.appendChild(ligne);
	
	
}
//Pour remplire les champs par les attributs de l'utilisateur selectioner
function modifier(){

	index = this.rowIndex-1;

	formulaire.elements.nom.value = users[index].nom;
	formulaire.elements.prenom.value = users[index].prenom;
	formulaire.elements.sexe.value = users[index].sexe;
	formulaire.elements.pseudo.value = users[index].pseudo;
	formulaire.elements.password.value = users[index].password;
	formulaire.elements.dateNaissance.value = users[index].dateNaissance.substring(0, 10);
	formulaire.elements.type.value = users[index].type;
	formulaire.elements.id.value = users[index].idUtilisateur;
	var x = document.getElementById("privilege");
	let i =0; let trouver = false;
	while(i<x.options.length && trouver == false) {
		if(x.options[i].value==users[index].privilege){
			trouver = true ;
			console.log("sss"+i)
		}
	i++;
	
	}
	if(trouver==false){
		var option = document.createElement("option");
		option.text = users[index].privilege;
		x.add(option)
	}
	formulaire.elements.privilege.value = users[index].privilege;

	formulaire.elements.enregistrer.value = "Modifier";	
	
}



/************Verifier la validiter des informations*******/ 
//Verifie que le pseudo est unique
formulaire.elements.pseudo.addEventListener("blur", function(e){
	
	let i = 0;
	let test = false;

	while(i < users.length && test == false){

		if(i != index){
			if(users[i].pseudo == this.value){
				remarque.test = false;
				remarque.pseudo = "Pseudo existe deja";
				test = true;
			}
		}

		i++;
	}

	if(test == false){
		if(remarque.pseudo != true){
			formulaire.elements.pseudo.style.borderColor = "#666666";
			remarque.test = true;
			remarque.pseudo = "";
		}
	}else{
		formulaire.elements.pseudo.style.borderColor = "red";
		remarque.pseudo = "Pseudo existe deja";
	}
	
});


//Remplir le champs id automatiquement

function remplireId(){

	let date = formulaire.elements.dateNaissance.value;
	let id = date.substring(8, 10) +  date.substring(5, 7) + date.substring(2, 4);
	console.log(date.substring(8, 10))
	let seq = 0;
	let nb;

	for(let i = 0; i < users.length; i++){

		if(i != index){
			if(seq<10){
				if(users[i].idUtilisateur.substring(0, 6) == id &&users[i].idUtilisateur.substring(6,8) == ('0'+seq)){
					seq++;		
				}
			}else{
				if(users[i].idUtilisateur.substring(0, 6) == id &&users[i].idUtilisateur.substring(6,8) == seq){
					seq++;		
				}
			}
			
			
		}
	}
	if(seq < 10){
		seq = '0' + seq;
		
	}
	id += seq;


	formulaire.elements.id.value = id;
}

///Remplissage de l'id lors de fin de saisi de la date de naissance

formulaire.elements.dateNaissance.addEventListener("blur", function(){
	if(index == -1){
		remplireId();
	}
});

///Verifier si les champs ne sont pas vide et remplir l'id

function verifieChamps(){
	let nom  = formulaire.elements.nom.value;
	let prenom = formulaire.elements.prenom.value;
	let password = formulaire.elements.password.value;
	let date = formulaire.elements.dateNaissance.value;
	let type = formulaire.elements.type.value;
	let sexe = formulaire.elements.sexe.value;
	let privilege = formulaire.elements.privilege.value;

	remarque.test = true;

	if(nom.trim() == ""){
		remarque.nom = "Veiller remplir le champs nom";
		remarque.test = false;
		
	}else{
		remarque.nom = "";
	}
	if(prenom.trim() == ""){
		remarque.prenom = "Veiller remplir le champs prenom";
		remarque.test = false;
	}else{
		remarque.prenom = "";
	}

	if(password == ''){
		remarque.password = "Veiller remplir le champs password";
		remarque.test = false;
	}else{
		remarque.password = "";
	}	
	if(date == ''){
		remarque.date = "Veiller remplir le champs date de naissance";
		remarque.test = false;
	}else{
		remarque.date = "";
	}

	if(type == ''){
		remarque.type = "Veiller remplir le champs type";
		remarque.test = false;
	}else{
		remarque.type = "";
	}
	
	if(sexe == ''){
		remarque.type = "Veiller remplir le champs sexe";
		remarque.test = false;
	}else{
		remarque.type = "";
	}
	if(privilege == ''){
		remarque.type = "Veiller remplir le champs privilege";
		remarque.test = false;
	}else{
		remarque.type = "";
	}

}


//L'envoie du formulaire

formulaire.addEventListener("submit", function(e){

	//Les valeurs des champs du formulaire
	

	formulaire.setAttribute("method", "POST");

	//verifier que ya pas de champs vide
	verifieChamps();

	if(remarque.test == false){  //si ya erreur 
		afficheErreur(remarque.nom + "\n" + remarque.prenom + "\n" +remarque.pseudo + "\n" + remarque.password + "\n" + remarque.date + "\n" + remarque.type);
		e.preventDefault();
		
	}else{ 

		formulaire.elements.id.disabled = false;
		if(index == -1){ //si nouveau utilisateur
			formulaire.setAttribute('action', '/nouveauUtilisateur');
		}else{//si modification
			
			formulaire.setAttribute("action", "/modifierCompte");	
				
		}

	}

	
});



///Affiche un message d'errer

function afficheErreur(err){

	document.getElementById("indicationText").textContent = err;
	document.getElementById('indication').style.display = 'block';

	setTimeout(function(){
		document.getElementById('indication').style.display = 'none';
	}, 5000);
}


///Supprimer un utilisateur
document.getElementById("sup").addEventListener('click', function(){

	if(index == -1){
		supprimer.onclick = function(){
			return false;
		};
	}else{
		supprimer.setAttribute("href", "/supprimerUtilisateur/" + users[index].idUtilisateur + "/" + userActuel.id);
	}
	
}); 
//

let principale = document.getElementById('principale');
principale.setAttribute("href", "/principale/" + userActuel.id); 

let profil = document.getElementById('profil');
profil.setAttribute("href", "/profil/" + userActuel.id);

let manip = document.getElementById('manipulation');
manip.setAttribute("href", "/Manipulation/" + userActuel.id);