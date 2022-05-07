///Le button pour allumer les cameras
var allumer = document.getElementById("allumer");
////La zone d'affichage de la camera
var camera = document.getElementById("vidCamera");
//socket.io 
var socketVideo = io();  ///Pour la connection video avec les utilisateurs
var socket = io("https://localhost:8080"); ///Pour la manipulation du robot

//Un tableau qui sauvegarde les connections avec les utilisateur connecter
var peerRobot = [];

///Le peer actuel qui veux une connection video
var peer;
var peerArriere; ///Pour envoyer la camera arriere a l'utilisateur
///Pour recevoir la webCam de l'utilisateur
var peerUtil;

///Stream de la camera arriere
var cameraArriere;

allumer.addEventListener("click", function(e){
	try{
		///dire au serveur que c'est le robot qui est connecter
		socket.emit('robot', 'robot');

		///Recuperer le flux video 
		navigator.mediaDevices.getDisplayMedia({video:true, audio:false})
		.then(async function(stream){
			/////video connection (camera avant)
			socketVideo.on('demandeCon', function(data){
				///Appeler la fonctions qui cree une connection (objet Simple-peer)
				peer = createNewPeerElement(stream, true);
				//Ajouter la connections au tableaux des connections
				peerRobot.push(peer);
			});
			///Recevoir le signale du client (video connection)
			socketVideo.on('clientConnect', function(data){
				peer.signal(data);
			});

			try{
				cameraArriere = await navigator.mediaDevices.getUserMedia({video:true, audio:true});
			}catch(err){
				cameraArriere = false;
				console.log("Camera arriere a un probleme");
			}

			socketVideo.on("demandeArr", function(data){
				if(cameraArriere){
					///Appeler la fonctions qui cree une connection (objet Simple-peer)
					peerArriere = createNewPeerElement(cameraArriere, false);
					//Ajouter la connections au tableaux des connections
					peerRobot.push(peerArriere);
				}else{
					socketVideo.emit('camArr', false);
				}
			});

			///Recevoir le signale du client (video arriere)
			socketVideo.on('utilArr', function(data){
				peerArriere.signal(data);
			});

			allumer.style.display = "none";

		});

	}catch(err){
		////Envoyer au client que la camera avant n'est pas allumer
		console.log("Erreur lors de la recuperation de la camera avant");
	}
	
});

socketVideo.on('videoUtil', function(data){
	peerUtil = false;
	peerUtil = createPeerUtilisateur();

	peerUtil.signal(data);
});	

socketVideo.on("finVidUtil", function(data){
	//peerUtil.destroy();
	peerUtil = false;
});

///cree l'objet simple peer et initialiser la connection video
function createNewPeerElement(stream, camAvant){

	let peer = new SimplePeer({
		initiator : true,
		trickle : false,
		stream : stream
	});
	
	///envoyer le signal a l'utilisateur
	peer.on('signal', function(data){
		if(camAvant){
			socketVideo.emit('answer', JSON.stringify(data)); //La camera avant
		}else{
			socketVideo.emit('camArr', JSON.stringify(data)); //La camera arriere
		}	
	});
	peer.on('close', function(){
		///Retirer la connection du tableaux des connections
		peerRobot.pop(peerRobot.indexOf(peer));
		peer.destroy();
	});
	return peer;
}	

///cree l'objet simple peer et initialiser la connection video envoyer par l'utilisateur
function createPeerUtilisateur(){

	let peer = new SimplePeer({
		initiator : false,
		trickle : false,
	});
	
	///envoyer le signal a l'utilisateur
	peer.on('signal', function(data){
		socketVideo.emit('repRob', JSON.stringify(data));
	});

	peer.on('stream', function(stream){
		camera.srcObject = stream;
		camera.play();
	});

	peer.on('close', function(){
		//Afficher le petit robot
		camera.load();
		camera.setAttribute("poster","/images/agent.jpg");
		peer.destroy();
		peer = false;
		
	});

	return peer;
}


