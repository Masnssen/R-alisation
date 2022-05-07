///La classe principale de serveur externe
///importer express
const express = require('express');
var app = express();
//Importer le modules robot
var rob = require('./modules/Robot');
var robot = new rob.robot();

//importer le module https
const https = require('https');

const fs = require('fs');

const options = {
  key: fs.readFileSync('key.pem'),
  cert: fs.readFileSync('cert.pem')
};

//initialiser le serveur https
const serveur = https.createServer(options,app);

//socket.io pour la connection en temps reel 
var io = require("socket.io")(serveur, {
    cors: {
      origin: "*",
      methods: ["GET", "POST"]
    }
});

//Moteur de template ejs , qui facilite l'utilisateur des page web
app.set('view engine', 'ejs');

//Les midelware : fonctions qui peuvent accéder à l'objet Request ( req ), 
/////l'objet response ( res ) et à la 
////fonction middleware suivant dans le cycle demande-réponse de l'application
app.use(express.static('public'));
app.use(express.json());
app.use(express.urlencoded({extended : true}));

app.use(function(request, response, next) {
    response.header("Access-Control-Allow-Origin", "*");
    response.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
    next();
});


///La partie de reception et envoi des donnees 
io.on('connection',async function(socket){
    //Lors que l'utilisateur est connecter lui envoyer la liste des itiniraire
    rob.itineraire.getListeItiniraire(socket);
    ///Quand le client est connecter on lui envoi l'etat du robot 
    socket.on("client", function(data){
        /////Verifier si le robot est connecter ou nn 
        ///     - Si connecter envoyer true 
        ///     - Si robot deconnecter envoyer false
        if(robot.etatRobot == false){
            socket.emit('etatRobot', false);
        }else{
            socket.emit('etatRobot', true);
        }
        if(robot.manipulateur){          
            socket.emit('etatRobotCont',true);
        }
    });

    //Recoir l'information que le robot est connecter
    socket.on('robot', function(data){
        //Un seul robot doit etre connecter un moment donnee 
        if(robot.etatRobot == false){
            ///initialiser les informations du robot 
            robot.etatRobot = socket;
            //Envoyer au client l'etat du robot
            io.emit("etatRobot", "true");
        }else{
            console.log("un robot est deja connecter");
        }
    });

    //lorsque le robot ce deconnecte ou l'utilisateur qui manipule le robot est deconnecter
    socket.on('disconnect', function(data){
        if(robot.etatRobot == socket){
            robot.etatRobot = false;
            ///Envoyer au client que le robot est deconnecter
            io.emit('etatRobot', false);
            io.emit('etatRobotCont', false); 
        }else if(socket == robot.manipulateur){
            
            robot.manipulateur.broadcast.emit('etatRobotCont', false);
            robot.manipulateur = false;
            robot.idManipulateur = false;
            //Envoyer au autre client que le robot n'est pas en etet de commande
            io.emit('etatRobotCont', false);
        }
    });

    ////Recevoir l'etat du robot par rapport a la manipulation  
    socket.on('etatRobotCont', function(data){
        //Si c'est le manipulateur qui a envoyer le message alors il est deconnecter
        if(robot.manipulateur == socket){
            robot.manipulateur = false;
        }else{
            robot.manipulateur = socket;
        }
        //Envoyer au autre client l'etat du robot
        socket.broadcast.emit('etatRobotCont', data);
    });

    ///Lors que on recois les vitesses a executer
    socket.on('donnee',async function(data){

        if(robot.manipulateur == socket){ //Si l'utilisateur est le manipulateur alors executer
            //Executer les commandes 
            let executer = await robot.bougerRobot(data);

            if(robot.prudance){
                let stop = {
                    x : 0,
                    y : 0
                };
                executer = await robot.bougerRobot(stop);
            }
            
            ///verifie si ils sont bien executer
            if(executer == false){
                console.log('Erreur lors d execution des coordonner');
                ///Envoyer a l'utilisateur que une erreur est survenu est les commandes sont pas executer
                let reponse = {
                    test : false,
                    sup : true,
                    message : "Erreur, le robot n'a pas executer les vitesses"
                }
                socket.emit("infIt", reponse);
            }else{
                //Les commandes sont bien executer
                if(robot.itineraire != false){
                    //Ajouter les coordonner a l'itineraire
                    robot.itineraire.ajouterCord(data);
                }
            }
        }else{
            ///On cas d'essaie de piratage
            console.log("Impossible t'est pas le manipulateur");
        }
    });
    ////Lors que on veux enregistrer un itineraire
        //Soit le squvegarder dans un fichier soit commencer a sauvegrader les commandes
    socket.on('enregistrer', function(data){
        ///Si debut enregistrement
        ////On cree un objet Itineraire avec le nom et description envoyer (si nom existe deja il sera remplacer)
        if(data != false){
            robot.initItineraire(data.nom, data.description, data.boucle, false); 
            let reponse = {
                test : true,
                sup : true, ////Variable qui donne l'info de l'affichage temporairement
                message : "Enregistrement d'un itinéraire"
            }
            socket.emit("infIt", reponse); 
        }else{
            //On sauvegarde l'itineraire dans un fichier et on met l'attribut itineraire du robot a false
            robot.itineraire.sauvegarderItineraire(socket);
            robot.itineraire = false;
        }
    });
    /////Lors de la demande d'executer un itineraire
    socket.on('lancerIt', async function(data){
        let itineraire = await rob.itineraire.getItineraire(data);
        //Si il y'a erreur
        if(itineraire == false){
            //Envoyer au client qu'une erreur est produite
            let reponse = {
                test : false,
                sup : true,
                message : "Erreur lors de la récupération de l'itinéraire"
            }
            socket.emit('infIt', reponse);
        }else{
            ///On cree l'objet itineraire
            robot.initItineraire(itineraire.nom, itineraire.description, itineraire.boucle, true);
            robot.itineraire.setListeCord(itineraire.listeCord);
            //On lance l'itineraire
            robot.lancer(socket);

            let reponse = {
                test : true,
                sup : false,
                message : "Itinéraire est en état d’exécution"
            }
            socket.emit('infIt', reponse);
        }
    });
    socket.on('arreterIt', function(data){
        if(robot.itineraire.lancer == true){
            //Arreter l'itiniraire
            robot.itineraire.lancer = false;
            let reponse = {
                test : false,
                sup : true,
                message : "Itinéraire arrêter"
            }
            socket.emit("infIt", reponse);
        }
    });

    socket.on('supprimerIt',async function(data){
        let rep = await rob.itineraire.supprimerIt(data);
        //S'il n'est pas supprimer alors inclure l'itineraire dans le tableaux
        if(rep != true){
            rob.itineraire.getItineraire(rep); 
            //Envoyer l'information que l'itineraire n'est pas supprimer
            let reponse = {
                test : false,
                sup : true,
                message : "Itinéraire n'est pas été supprimé, une erreur est survenu"
            }
            socket.emit("infIt", reponse);   
        }else{
            //Envoyer que l'itineraire est bien supprimer
            let reponse = {
                test : true,
                sup : true,
                message : "Itinéraire a été bien supprimé"
            }
            socket.emit("infIt", reponse); 
        }
         
    });

    ///Changemet du mode de deplacement
    socket.on("prudance", function(data){
        console.log(data);
        if(robot.manipulateur == socket){
            robot.prudance = data;
            console.log(data);
        }
    });
});


serveur.listen(8080);