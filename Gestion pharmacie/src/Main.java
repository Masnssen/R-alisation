import Vue.administrateur.Authentification;
import controle.administrateur.AuthentificationControle;
import model.administrateur.Compte;
import model.commercial.Client;
import model.commercial.Fournisseur;
import model.pharmacien.MatierePremiere;
import model.pharmacien.MedicamentEnStock;
import model.pharmacien.MedicamentInterne;
import model.pharmacien.Produit;
import model.pharmacien.ProduitPharmaceutique;
import model.pharmacien.TypeMedicament;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Initialisation */
		//Matiere premiere
		MatierePremiere matPrem;
		for(int i = 1; i < 6; i++) {
			matPrem = new MatierePremiere("Matiere prem " + i);
			MatierePremiere.getListeMatiere().add(matPrem);
		}
				
		//Type medicament
		TypeMedicament typeMed;
	    for(int i = 1; i < 6; i++) {
			typeMed = new TypeMedicament("Type medicament " + i, "Description du type " + i);
			TypeMedicament.getListType().add(typeMed);
	   }
        //Produit pharmaceutique
		Produit pr[] = new Produit[20];
		pr[0]= new ProduitPharmaceutique("0001","ProduitPharmaceutique 1", 4, 222.0);
		pr[1]= new ProduitPharmaceutique("0002","ProduitPharmaceutique 2", 6, 250.0);
		pr[2]= new ProduitPharmaceutique("0003","ProduitPharmaceutique 3", 10, 500.0);
		pr[3]= new ProduitPharmaceutique("0004","ProduitPharmaceutique 4", 0, 100.0);
		pr[4]= new ProduitPharmaceutique("0005","ProduitPharmaceutique 5", 1, 1200.5);
		for(int i = 0; i < 5; i++) {
			ProduitPharmaceutique.getListeProduit().add((ProduitPharmaceutique)pr[i]);
		}
		
		//Produit en stock
		for(int i = 5; i < 10; i++) {
			pr[i] = new MedicamentEnStock("0000" + i, "Medicament en stock " + i ,TypeMedicament.getListType().get(i%5), i % 8, 12.2*i, i%5+1);
		}
		
		for(int i = 5; i < 10; i++) {
			MedicamentEnStock.getListeProduit().add((MedicamentEnStock)pr[i]);
		}
		
		//Produit interne
		
		for(int i = 10; i < 20; i++) {
			pr[i] = new MedicamentInterne("0000" + i, "Medicament interne",TypeMedicament.getListType().get(i%5), i*13.5/2, 
					MatierePremiere.getListeMatiere().get(0), MatierePremiere.getListeMatiere().get(1),MatierePremiere.getListeMatiere().get(2),MatierePremiere.getListeMatiere().get(3));
		}
		
		for(int i = 10; i < 20; i++) {
			MedicamentInterne.getListeProduit().add((MedicamentInterne)pr[i]);
		}
		
		//Compte 
		Compte compte1 = new Compte("barache","syphax","Vendeur", "syphax", "barache");compte1.ajouter();
		Compte compte2 = new Compte("tighilt","massinissa","Pharmacien", "massinissa", "tighilt");compte2.ajouter();
		Compte compte3 = new Compte("boutnarte","aimad","commercial", "aimad", "aimad");compte3.ajouter();
		Compte compte4 = new Compte("souad","souad","Pharmacien", "souad", "souad");compte4.ajouter();
		Compte compte5 = new Compte("ait ouali","lynda","Administrateur", "lynda", "lynda");compte5.ajouter();
		
		//Collaborateur
		//Fournisseur
		Fournisseur fournisseur;
		for(int i = 1; i < 6; i++) {
			fournisseur = new Fournisseur("Fournisseur" + i, "Prenom fournisseur " + i );
			fournisseur.ajouter();
		}
		//client
		Client cl = new Client("INCONNU", "", "", "", "");
		cl.ajouter();
		
		
		
		
		Authentification frame = new Authentification();
		AuthentificationControle c = new AuthentificationControle(frame);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
