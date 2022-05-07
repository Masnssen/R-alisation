const {exec} = require('child_process');
const e = require('express');
//importer fs pour la lecture et l'ecriture des fichiers
const fs = require('fs');
const { exit } = require('process');

class Robot{
    ///Etat du robot soit connecter ==> true  (pres l'utilisation)
                    //////deconnecter ==> false (il n'est pas allumer)
    etatRobot = false;

    //la variable qui sauvegarde la socket du manipulateur
    manipulateur = false;
    //l'id du manipulateur du robot
    idManipulateur = false;
    //La variable qui sauvegarde un itiniraire 
    itineraire = false;
    ///Sauvegarde le mode de deplacement du robot (prudance ou nn)
    prudance = true;

    ///La methode qui permet de faire bouger le robot 
    ////On lui donne les cordonners 
    ////Elle returne true si tous vas bien et faulse s'il y'a erreur
    bougerRobot(data) {
        return new Promise(function(resolve, reject){
            exec("rostopic pub -1 /turtle1/cmd_vel geometry_msgs/Twist -- '[" + data.x + ", 0.0, 0.0]' '[0.0, 0.0, " + data.y + "]'", function(error, stdout, stderr){
                if(error || stderr){
                    resolve(false);   
                }else{
                    resolve(true);
                }
            });
           
        });
    }


    //La methodes qui permet d'initialiser l'atribut itineraire
    initItineraire(nom , desc, bcl, lancer){
        this.itineraire = new Itineraire(nom, desc, bcl, lancer);
    }

    ///La methode qui permet de lancer un itiniraire (executer un itineraire)
    async lancer(socket){
        
        let listeCor = this.itineraire.listeCord;
        let executer = true;
        let i = 0;
        do{
            i = 0;
            while(i < listeCor.length && executer == true){
                if(this.itineraire.lancer === false){
                    console.log("fin");
                    //Destruction de l'itineraire qui est en cours d'execution
                    this.itineraire = false;
                    //Fin de la fonction
                    return 0;
                }
                executer = await this.bougerRobot(listeCor[i]);
                ///Pour qu'il execute une seul commande
                let stop = {
                    x : 0,
                    y : 0
                }
                executer = await this.bougerRobot(stop);
                
                i++;
            }
            
        }while(this.itineraire.boucle == true && executer != false);
        let reponse;
        if(executer == false){
            reponse = {
                test : false,
                sup : true,
                message : "Erreur lors d’exécutions de l'itinéraire(Itinéraire arrêter)"
            }
        }else{
            reponse = {
                test : false,
                sup : true,
                message : "Fin de l'itinéraire"
            }
        }
        socket.emit('infIt', reponse);
    }


}

class Itineraire{
    nom;
    description;
    boucle;
    listeCord;
    ///Etat d'un itineraire soit il est en etat d'enregistrement ==> false
    ////////////////////////Soit en etat d'executer ==> true (il est lancer)
    lancer;

    constructor(nom, description, boucle, lancer){
        this.nom = nom;
        this.description = description;
        this.boucle = boucle;
        this.listeCord = [];
        this.lancer = lancer;
    }
    //methode qui permet d'afecter une liste de coordonner
    setListeCord(listeCord){
        this.listeCord = listeCord;
    }
    ///Methode qui permet d'ajouter une cordonne(depacement) a l'iteneraire actuelle
    ajouterCord(cord){
        this.listeCord.push(cord);
    }

    //Methode qui permet de sauvegarder l'itineraire dans un fichier
    ///Elle returne true si il est bien enregistrer et false si il y a une erreur
    sauvegarderItineraire(socket){
        let donneer = {
            nom : this.nom,
            description : this.description,
            boucle : this.boucle,
            listeCord : this.listeCord
        };
        let itiner = {
            nom : this.nom,
            description : this.description,
            boucle : this.boucle,
        }
        donneer = JSON.stringify(donneer);
        fs.appendFile("./enregistrement/" + this.nom , donneer, function(err){
            if(err){
                //Envoyer au client que l'itineraire n'est pas sauvegarder
                let reponse = {
                    test : false,
                    sup : true, ////Variable qui donne l'info de l'affichage temporairement
                    message : "Erreur lors de la sauvegarde de l'itinéraire"
                }
                socket.emit("infIt", reponse); 
                return false;
            }
            else{
                socket.emit('listeIt', itiner);//Envoyer l'itineraire pour metre a jours le tableaux 
                let reponse = {
                    test : true,
                    sup : true, ////Variable qui donne l'info de l'affichage temporairement
                    message : "Itinéraire bien sauvegarder"
                }
                socket.emit("infIt", reponse); 
                return true;
            }
        });
    }

    //Methode qui permet de recuperer un itineraire dans un fichier
    //////On lui donne le nom de l'itineraire 
    /////Elle renvoie l'itineraire ou false s'il y a une erreur
    static getItineraire(nom){
        return new Promise(function(resolve, reject){
            fs.readFile('./enregistrement/'+nom, 'utf8', function(err, contenu){
                if(err) resolve(false);
                contenu = JSON.parse(contenu);
                resolve(contenu);
            });        
        });
    }

    ///Methode qui recuperer tous les noms des itineraire et leur discription
      //S'il y'a erreur elle return false
    static getListeItiniraire(socket){

        fs.readdir("./enregistrement", function(err, files){
            if(err){
                return false;
            }else{
                files.forEach(element => {
                     fs.readFile("./enregistrement/"+element,'utf8', function(err, data){
                         if(err){
                             return false;
                         }
                         let contenu = JSON.parse(data);
                         let listeIt = {
                             nom : contenu.nom,
                             description : contenu.description,
                             boucle : contenu.boucle
                         };
                         socket.emit('listeIt', listeIt);
                     });
                });
            } 
        });
    }


    static supprimerIt(nom, socket){
        return new Promise(function(resolve, reject){
            fs.rm('./enregistrement/'+nom,function(err){
                if(err) resolve(nom);
                else{
                    resolve(true);
                }
            });    
        })
        
    }

}

exports.robot = Robot;
exports.itineraire = Itineraire;

