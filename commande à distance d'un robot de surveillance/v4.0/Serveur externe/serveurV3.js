///La classe principale de serveur


///importer express et le module Root.js
const express = require('express');
var app = express();
var route = require('./modules/Root');

//importer le module https
const https = require('https');
		
//importer le module fs qui sert a Créer et gérer des fichiers pour y stocker ou lire des informations
const fs = require('fs');



//Lire les cle de https
const options = {
key: fs.readFileSync('key.pem'),
cert: fs.readFileSync('cert.pem')
};


//initialiser le serveur https
const serveur = https.createServer(options,app);


//socket.io pour la connection en temps reel 
var io = require("socket.io")(serveur);

var socketIo = require('./modules/TempsReel').io(io);


//Moteur de template ejs , qui facilite l'utilisateur des page web
app.set('view engine', 'ejs');

//Les midelware : fonctions qui peuvent accéder à l'objet Request ( req ), 
/////l'objet response ( res ) et à la 
////fonction middleware suivant dans le cycle demande-réponse de l'application
app.use(express.static('public'));
app.use(express.json());
app.use(express.urlencoded({extended : true}));

///enregistrer notre routeur pour toutes les demandes effectuées
app.use('/', route);
	
serveur.listen(3000);



