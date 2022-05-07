////Importer le module utilisateur
const Utilisateur = require('../modules/Utilisateur.js');



exports.io = async function(io){

    ///La variable qui sauvegarde si le robot est connecter ou nn 
    var robot = false;


    //La variable qui sauvegarde la socket de l'utilisateur qui est entrain d'etablir une connection
    var utilisateur;

    //la variable qui sauvegarde l'id de l'utilisateur qui est entrain de manipuler le robot 
        ///false si aucun utilisateur
    var idManipulateur = false;
    var manipulateur = false; //la variable qui sauvegarde la socket du manipulateur

    io.on('connection', function(socket){    
        
        // Utilisateur demande une connection (video et audio) au robot
        socket.on('demandeCon', function(data){
            console.log('demande con');
            //sauvegarder la socket de l'utilisateur pour lui envoyer le signale juste pour lui
            utilisateur = socket;
            //Transmetre la demande au robot
            io.emit('demandeCon', '');

        });

        ///Recevoir le signale du client et l'envoyer au robot 
        socket.on('offer', function(data){
            console.log('id client');
            //Envoyer le signale au robot s'il est tjrs connecter
            io.emit('clientConnect', data);
           
            ///supprimer la socket de l'utilisateur car il a recu le signale
            utilisateur = false;
        });

        //Recoi le signale du robot est l'envoyer au client 
        socket.on('answer', function(idRobot){
            //transmettre le signale du robot a l'utilisateur
            console.log("id robot");
            if(utilisateur == false){
                console.log('Utilisateur a deja recu le signale');
            }else{
                utilisateur.emit('robotAnswer', idRobot);
            }
            
        });

        //////La camera arriere

        // Utilisateur demande la camera arriere (video et audio) au robot
        socket.on('demandeArr', function(data){
            console.log("Demande cam arr");
            //sauvegarder la socket de l'utilisateur pour lui envoyer le signale juste pour lui
            utilisateur = socket;
            //Transmetre la demande au robot
            io.emit('demandeArr', '');

        });

        //Recoi le signale du robot est l'envoyer au client (Pour camera arriere)
        socket.on('camArr', function(idRobot){

            //transmettre le signale du robot a l'utilisateur
            if(utilisateur == false){
                console.log('Utilisateur a deja recu le signale');
            }else{
                utilisateur.emit('camArr', idRobot);
            }
            
        });

         ///Recevoir le signale du client et l'envoyer au robot 
         socket.on('utilArr', function(data){
          
            //Envoyer le signale au robot s'il est tjrs connecter
            io.emit('utilArr', data);
           
            ///supprimer la socket de l'utilisateur car il a recu le signale
            utilisateur = false;
        });

        
        ////******Partie concernant commander robot*******/
        //////////////////////////////
        /////////////////////////////// Revoire cette partie

        //////Recoi la demande de controle du robot
        ///////// - Si robot n'est pas en etat de controle lui dire qu'il peux le manipuler
        ////////  - Sinon verifie les privileges si le nouveau utilisateur 
        //////////////////////est previliger lui transmettre la demande sinon envoyer message impossible
        socket.on('demControl', async function(data){
            let trans = true; // si true alors envoyer au robot que l'utilisateur peux le manipuler sinon envoyer au client qu'il ne peut pas

            if(idManipulateur != false){ //Si un utilisateur est en etat de manipuler le robot
               //Verifier les privilege (Si les commandes doivent passer a l'autre utilisateur)
                trans =  await Utilisateur.gestionPrivilege(idManipulateur, data);
                
                ///Le manipulateur doit changer
                if(trans){

                    //Envoyer au manipulateur l'information que les commande sont passer a un autre utilisateur
                    manipulateur.emit('finManip', true);

                    idManipulateur = data;
                    manipulateur = socket;  
                    
                }
            }else{//Utilisateur peut manipuler le robot
                idManipulateur = data;
                manipulateur = socket;
            }
            
            ///Envoyer la reponse true s'il peux le controller 
            //////////////////////false si il ne peut pas
            socket.emit("repCont", trans);

        });

        ///Lors l'utilisateur arrete de manipuler le robot 
        socket.on('finManip', function(data){
            idManipulateur = false;
            manipulateur = false;

            io.emit("finVidUtil", true);
        });


        ////L'envoie de l'id du manipulateur au robot pour le peer-to-peer de l'autre video
        socket.on("videoUtil", function(data){
            io.emit('videoUtil', data);
        });

        ////L'envoie de l'id du robot au manipulateur pour le peer-to-peer de l'autre video
        socket.on("repRob", function(data){
            io.emit("repRob", data);
        });
    });
}
