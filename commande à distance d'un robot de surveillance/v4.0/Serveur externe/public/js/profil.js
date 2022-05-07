///Les variables
var remarque = 
{
	password : "Mot de passe faux",
	confirmePassword : ""
};


//masquer le type
document.getElementById('type').value = user.type;
document.getElementById('type').style.display = "none";

//Afficher message d'erreur si il existe
if(message != ""){

	document.getElementById("indicationText").textContent = message;
	document.getElementById('indication').style.display = 'block';

	setTimeout(function(){
		document.getElementById('indication').style.display = 'none';
	}, 5000);
}
///Les constantes qui sont les champs du formulaire

const form = document.getElementById('form');

const pseudo = document.getElementById('pseudo');
const id = document.getElementById('id');
const nom = document.getElementById('nom');
const prenom = document.getElementById('prenom');
const sexe = document.getElementById('sexe');
const dateNaissance = document.getElementById('dateNaissance');
const email = document.getElementById('email');
const tel = document.getElementById('tel');
const changePassword = document.getElementById('changePassword');
const password = document.getElementById('password');
const newPassword = document.getElementById('newPassword');
const confirmePassword = document.getElementById('confirmePassword');



//Initialisation des champs
pseudo.value = user.pseudo;
id.value = user.idUtilisateur;
nom.value = user.nom;
prenom.value = user.prenom;
sexe.value = user.sexe;
dateNaissance.value = user.dateNaissance.substring(0, 10);
email.value = user.email;
tel.value = user.tel;
password.value = "";



//Verifier mot de passe

password.addEventListener("blur", function(){

	if(password.value != user.password){
		remarque.password = "Mot de passe faux";
		password.style.borderColor = "red";
	}else{
		remarque.password = '';
		password.style.borderColor = "#7F7F7F";
	}

});

confirmePassword.addEventListener("blur", function(){

	if(this.value != newPassword.value && changePassword.checked == true){
		remarque.confirmePassword = "Entrer deux mot de passe equivalent";
		confirmePassword.style.borderColor = "red";
	}
});

changePassword.onchange = function(){

	if(changePassword.checked == true){
		document.getElementById('newPassword').value="";
		document.getElementById('confirmePassword').value="";
		document.getElementById('newPassword').disabled= false;
		document.getElementById('confirmePassword').disabled= false;
		newPassword.required = true;
		confirmePassword.required = true;
	}else{
		document.getElementById('newPassword').value="";
		document.getElementById('confirmePassword').value="";
		document.getElementById('newPassword').disabled= true;
		document.getElementById('confirmePassword').disabled= true;
		newPassword.required = false;
		confirmePassword.required = false;
	}
};


form.addEventListener('submit', function(e){


	if(remarque.password != "" || remarque.confirmePassword != ""){
		e.preventDefault();
	}else{
		form.setAttribute("method", "POST" );
		form.setAttribute("action", "/updateUser");

		id.disabled = false;
		if(changePassword.checked == true){
			password.value = newPassword.value;
		}
		
	}

	
});


let principale = document.getElementById('principale');
principale.setAttribute("href", "/principale/" + user.idUtilisateur); 

let manip = document.getElementById('manipulation');
manip.setAttribute("href", "/Manipulation/" + user.idUtilisateur);


