/***********************Le module de manipulation du robot côté client 
    Nom fichier : manupulation.js
    Auteur : TIGHILT Massinissa
    email : masnssen@gmail.com
    derniere mise a jours : 22/06/2021

************************///////

///*****initialisation des variables******///
///le module socket.io pour la connection peer to peer
var socket = io();

//Le module socket.io pour communiquer avec le robot
var socketRobot = io("https://192.168.0.106:8080");

//L'affichage du flux video des robot 
var videoAvant = document.getElementById("vidCamera"); //video avant du robot
var videoArr = document.getElementById('vidArr');

////Les informations
//l'information si le robot est connecter ou pas 
var infoCon = document.getElementById("infoCon");
//l'information si le robot est en etat de manipulation
var infoMan = document.getElementById("infManip");
//Information si on peux pas manipuler le robot
var infoCommand = document.getElementById('infCommande');

////Les buttons de connection et deconnection 
var connect = document.getElementById("connection");
var control = document.getElementById("controler");
var deconnect = document.getElementById("deconnecter");
var finCont = document.getElementById("finControle");


///Les buttons de manipulation 
var buttonManip = {
    generale : document.getElementById('buttonManip'),
    top : document.getElementById('top'),
    right : document.getElementById('right'),
    bas : document.getElementById('bas'),
    left : document.getElementById('left'),
    vitesse : document.getElementById('vitesse'),
    stop : document.getElementById('stop'), /// Le button qui permet d'arreter le robot
    prudence : document.getElementById('prudance')
};

//Les option 
var option = document.getElementById("option");

///La vitesse de deplacement 
var vitesseDep =  parseFloat(buttonManip.vitesse.value);

////Les objets peer pour recevoir les camera du robot
var peerVideoAvant; // pour recevoir la camera d'avant du robot
var peerVideoArriere; // pour recevoir la camera d'arriere du robot

///La variable qui controle les etats du robot
var robotInf = {
    etatConnection : false, //Le robot est connecter
    etatManipulation : false, // Le robot est en etat de manipulation
    connecter : false, //l'utilisateur est connecter 
    manipulateur : false //l'utilisateur est le manipulateur
};

///Les buttons des itineraire
///Variable qui verifie si on enregistre le circuit
var enregistrer = document.getElementById("enregistrer");
var enr = false;

var lancer = document.getElementById("lancer");///Le button lancer
var arreter = document.getElementById("arreter");//Le button arreter
var supprimer = document.getElementById('supprimer');//Le button supprimer un itineraire
var tabIt = document.getElementById("listeIteneraire");//Le tableaux des iteneraire 
var ligneSelectionner = false;////Variable qui sauvegarde la ligne selectionner

miseAjoursInterface();
///Dire au serveur je suis connecter pour qu'il renvoi l'etat du robot
socketRobot.emit('client', "hello");

////*****L'etat du robot *****/////
//Recevoir l'etat(si connecter ou non) du robot depuis le serveur
//////     - Quand on entre dans la fenetre manipulation 
//////     - Quand l'etat du robot change 
//L'etat du robot ici signifie que soit le robot est connecter ou pas 
socketRobot.on("etatRobot", function(etat){

    robotInf.etatConnection = etat;
    if(etat == false){
        if(robotInf.connecter == true){
             ///Relancer la page 
            document.location.reload();
            robotInf.connecter = false;

        }
        robotInf.manipulateur = false;
    }
    miseAjoursInterface();
});

///*****L'etat du robot *****/////
//Recevoir l'etat(si en etat de manipulation ou non) du robot depuis le serveur
//////     - Quand on entre dans la fenetre manipulation 
//////     - Quand l'etat du robot change 
//L'etat du robot ici signifie que soit le robot est en etat de manipulation ou non
socketRobot.on('etatRobotCont', function(etat){   
    robotInf.etatManipulation = etat;
    miseAjoursInterface();
});

///Lors du click sur le button connecter
connect.addEventListener("click", function(e){
    ///Appeler la methode qui cree l'objet Simple-peer et definie c'est fonction
    peerVideoAvant = createNewPeer(true);
    
    //Demander au robot de nous donnee la camera avant
    socket.emit('demandeCon', '');

    ///Recevoir l'id du robot est etablire la connection directe (camera avant)
    socket.on('robotAnswer',  function(otherId){
        peerVideoAvant.signal(otherId);
        
        robotInf.connecter = true;
        miseAjoursInterface();
    });

    ///Recevoir l'id du robot pour recevoir la camera arriere
    socket.on('camArr', function(data){
        peerVideoArriere = createNewPeer(false);
        
        peerVideoArriere.signal(data);
    });

    
    
});

////lors du click sur le button deconnection
deconnect.addEventListener('click', function(e){

    ///Arreter la connection peer to peer
    document.location.reload();

});

var test;

////lors du click sur le button controller
control.addEventListener('click', function(e){
    test = false;   
    //demander au serveur la possibiliter de manipuler le robot en lui envoyant l'id de l'utilisateur
    socket.emit('demControl', userId);
    
});

///La fonction qui met fin a la manipulation du robot
finCont.addEventListener('click', function(e){

    buttonManip.stop.click();
    peerInit.destroy();
    peerInit = false;
    //stream.stop();
    stream.getTracks().forEach(element => {
        element.stop();
    });;

    robotInf.manipulateur = false;
    //Envoyer au serveur externe que le robot n'est pas en etat de manipulation
    socket.emit("finManip", true);

    ///Envoyer au serveurEmbarquer que le robot n'est pas en etat de manipulation
	socketRobot.emit('etatRobotCont', false);
    robotInf.etatManipulation = false;
    miseAjoursInterface();
}); 

var peerInit;
var stream;

/////Reponse sur la possibiliter de manipuler le robot
socket.on('repCont', async function(data){

    if(data == true){
        
        try{
            ///Recuperer le flux video 
            stream = await navigator.mediaDevices.getUserMedia({video:true, audio:true});
            peerInit = createInitPeer(stream);
            //verifier qu'un seul id est arriver  
            let test = true;
            socket.on("repRob", function(data){   
                if(test){      
                    test = false;
                    peerInit.signal(data);
                }
            });
        }catch(err){
            console.log("Erreur lors de la recuperation de la video");
        }
        ///L'utilisateur peut manipuler le robot
        robotInf.manipulateur = true;
        robotInf.etatManipulation = true;

        ///Envoyer au serveur embarquer que l'utilisateur vas manipuler le robot
        socketRobot.emit("etatRobotCont", true);

        miseAjoursInterface();
    }else{
        //Utilisateur plus privileger le manipule
        infoCommand.textContent = "Impossible, utilisateur plus priviliger le manipule";
        infoCommand.style.backgroundColor = "#ad1e1e";
    
   
        robotInf.etatManipulation = true;
        miseAjoursInterface();
    
        setTimeout(function(){
            infoCommand.textContent = "";
        }, 15000);
    }
});

///Les commandes sont donnee a un autre utilisateur priviliger
socket.on('finManip', function(data){
    
    //L'utilisateur n'est pas le manipulateur
    robotInf.manipulateur = false;
    ////Le robot n'est pas en etat de manipulation
    robotInf.etatManipulation = false;

    miseAjoursInterface();
   
    infoCommand.textContent = "Les commandes sont donnee a un autre utilisateur";
    setTimeout(function(){
        infoCommand.textContent = "";
    }, 20000);
});
////Les ordres a envoyer au robot
document.addEventListener("keypress", function(e){ //Lors du click sur les touche
    if(robotInf.manipulateur){
        switch(e.key){
            case 'w' : buttonManip.top.click(); 
            break;
            case 'd' : buttonManip.right.click();
            break;
            case 'a' : buttonManip.left.click();
            break;
            case 's' : buttonManip.bas.click();
            break;
        }
    }
    
});

buttonManip.top.addEventListener('click', function(e){
    let cor = {
        x : vitesseDep,
        y : 0
    };
    
    socketRobot.emit("donnee", cor);
});

buttonManip.right.addEventListener('click', function(e){
    let cor = {
        x : 0,
        y : -vitesseDep
    };
    socketRobot.emit("donnee", cor);
});

buttonManip.bas.addEventListener('click', function(e){
    let cor = {
        x : -vitesseDep,
        y : 0
    };
    socketRobot.emit("donnee", cor);
});

buttonManip.left.addEventListener('click', function(e){
    let cor = {
        x : 0,
        y : vitesseDep
    };
    socketRobot.emit("donnee", cor);
}); 

buttonManip.stop.addEventListener('click', function(e){
    let cor = {
        x : 0,
        y : 0
    };
    socketRobot.emit("donnee", cor);
});
///Lors du changement de la vitesse
buttonManip.vitesse.addEventListener('blur', function(e){
    let vit = parseFloat(buttonManip.vitesse.value);
    if(vit){
        vitesseDep = vit;
    }else{
        vitesseDep = 0.1;
    }
});


//Lors du changement de l'etat prundance
buttonManip.prudence.addEventListener("change", function(e){
    socketRobot.emit("prudance", buttonManip.prudence.checked);
});

///La fonction qui cree l'objet Simple peer pour recevoir la video du robot 
function createNewPeer(camAvant){

    var peer = new SimplePeer({
        initiator : false,
        trickle : false
    });
    

    ///Renvoyer la reponse au robot pour une connection peer to peer
    peer.on('signal', function(data){
        ///Envoyer les cordonnee du client au serveur pour qu'il les transmette au robot
        if(camAvant){
            socket.emit("offer", JSON.stringify(data));
            ///Demander la camera arriere
            socket.emit('demandeArr', '');
        }else{
            console.log("envoyer id client");
            socket.emit("utilArr", JSON.stringify(data));
        }
        
    });


    ///Afficher la video quand elle est envoyer par le robot
    peer.on('stream', function(data){
        if(camAvant){
            //Afficher la camera d'avant
            videoAvant.srcObject = data;
            videoAvant.play();
        }else{
            //Afficher la camera arriere
            console.log("Camera arriere recu");
            videoArr.srcObject = data;
            videoArr.play();
        }
        
    });

    ///Quand la connection est perdu
    peer.on('close', function(){
        ///Relancer la page 
        document.location.reload();
        robotInf.connecter = false;
        peer.destroy();
    });
    
    return peer;
}

///La fonction qui cree l'objet Simple peer pour envoyer la video au pc du robot
function createInitPeer(stream){

    let peer = new SimplePeer({
        initiator : true,
        trickle : false,
        stream : stream
    });
    
    peer.on('signal', function(data){
        //envoyer l'id du client au serveur
        socket.emit('videoUtil', JSON.stringify(data));
    });


    ///Quand la connection est perdu
    peer.on('close', function(){
        ///Relancer la page 
        peer.destroy();
    });
    
    return peer;
}

///La fonction qui met a jours de l'interface graphique
function miseAjoursInterface(){

    if(robotInf.etatConnection){
        infoMan.style.display = "block";
        if(robotInf.etatManipulation){
            //Affichage
            infoMan.textContent = "Le robot est en état de manipulation";
            infoMan.style.backgroundColor = "#ad1e1e"; 
        }else{
            //Affichage
            infoMan.textContent = "Le robot n'est pas en état de manipulation";
            infoMan.style.backgroundColor = "olive";
        }
        //Affichage 
        infoCon.textContent = "Le robot est connecté";
        infoCon.style.backgroundColor = "olive";
        if(robotInf.connecter){
            ///Activer/desactiver button
            connect.style.display = 'none';
            deconnect.style.display = 'block';
           
            if(robotInf.etatManipulation && robotInf.manipulateur){
                ///Activer/desactiver button
                control.style.display = 'none';
                finCont.style.display = 'block';
                buttonManip.generale.style.display = 'block';
                option.style.display = 'block';
                
                //Affichage
                infoMan.textContent = "Vous êtes en état de manipuler le robot";
                infoMan.style.backgroundColor = "olive";

            }else{
                ///Activer/desactiver button
                control.style.display = 'block';
                finCont.style.display = 'none';
                buttonManip.generale.style.display = 'none';
                option.style.display = 'none';
            }
            
        }else{
            ///Activer/desactiver button
            connect.style.display = 'block';
            deconnect.style.display = 'none';
        }
       
    }else{
        connect.style.display = 'none';
        deconnect.style.display = 'none';
        control.style.display = 'none';
        finCont.style.display = 'none';
        buttonManip.generale.style.display = 'none';
        option.style.display = 'none';

        infoMan.style.display = "none";
        //Affichage 
        infoCon.textContent = "Le robot n'est pas connecté";
        infoCon.style.backgroundColor = "#ad1e1e";
    }
}

////Les itineraire
//Initialiser listeIt
socketRobot.on('listeIt', function(data){
    ajouterTableau(data);
});

//Lors du click sur le button enregistrement
enregistrer.addEventListener('click', function(e){
    if(enr == false){
        ///Itineraire juste dans le mode prudance
        buttonManip.prudence.checked = true;
        buttonManip.prudence.style.display = "none";
        socketRobot.emit("prudance", buttonManip.prudence.checked);
        enr = true;
        ///Demander le nom la description et si c'est une boucle ou non
        let nomEnr;
        let sansEspace;
        let desc;
        let bcl;
        ///Assurer que le nom n'est pas vide
        do
        {
            nomEnr = prompt("Nom de l'enregistrement");
            sansEspace = nomEnr.split(" ").join("");
        }while(sansEspace == "");
        
        desc = prompt("Entrer une description de l'enregistrement");

        do{
            bcl = prompt('Cette itineraire est-il une boucle ? repondre avec (O/N)');
        }while(bcl !== 'O' && bcl !== 'o' && bcl !== 'n' && bcl !== 'N');

        if(bcl == 'o' || bcl == 'O'){
            bcl = true;
        }else{
            bcl = false;
        }
        let ecrireFichier = {
            nom : nomEnr,
            description : desc,
            boucle : bcl
        }
        //Envoyer les informations de l'itineraire au serveur
        socketRobot.emit('enregistrer', ecrireFichier);
        enregistrer.textContent = "Fin enregistrement";
    }else{
        enr = false;
        enregistrer.textContent = "Enregistrer";
        //Envoyer au serveur que l'itineraire est fini
        socketRobot.emit('enregistrer', false);

        
        buttonManip.prudence.style.display = "inline";
    }
});

///Lors du click sur lancer
lancer.addEventListener('click', function(e){
    if(ligneSelectionner){
        console.log("lancer it");
        socketRobot.emit('lancerIt', ligneSelectionner.children[0].textContent);
    }
});

//Lors du click sur le button arreter l'itineraire
arreter.addEventListener('click', function(e){
    socketRobot.emit('arreterIt', 'true');
    ligneSelectionner.style.background = 'cadetblue';
});

////Lors du click sur le button supprimer l'itineraire
supprimer.addEventListener('click', function(e){
    if(ligneSelectionner != false && ligneSelectionner != undefined){
        socketRobot.emit('supprimerIt', ligneSelectionner.children[0].textContent);
    } 
    ligneSelectionner.remove();
    ligneSelectionner = false;
});

///Arriver des informations sur l'itineraire
socketRobot.on('infIt', function(data){
    let infIt = document.getElementById("infItin");
    infIt.textContent = data.message;
    if(data.test == true){
        infIt.style.backgroundColor = "olive";
        if(data.sup == true){
            setTimeout(function(){
                infIt.textContent = "";
            }, 7000);
        }
    }else{
        infIt.style.backgroundColor = "#ad1e1e";
        if(data.sup == true){
            setTimeout(function(){
                infIt.textContent = "";
            }, 7000);
        }
    }
});


//Fonction de remplissage du tableaux
function ajouterTableau(data){

    let ligne = document.createElement('tr');
    let column = document.createElement('td');
	column.textContent = data.nom;
	ligne.appendChild(column);

	column = document.createElement('td');
	column.textContent = data.description;
	ligne.appendChild(column);

    column = document.createElement('td');
    if(data.boucle == true){
        column.textContent = "Oui";
    }else{
        column.textContent = "Non";
    }
	ligne.appendChild(column);

	ligne.addEventListener('click', modifier);

	tabIt.appendChild(ligne);
}

//Fonction lors d'un click sur une ligne du tableaux

function modifier(){
    if(ligneSelectionner != false){
        ligneSelectionner.style.background = 'cadetblue';
    }
    ligneSelectionner = this;
    this.style.background =  "#7F7F7F";
    
}

///La barre de navigation
let principale = document.getElementById('principale');
principale.setAttribute("href", "/principale/" + userId);