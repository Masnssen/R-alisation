package model.pharmacien;

import java.util.ArrayList;

public class MedicamentInterne extends Medicament {
	
	private MatierePremiere[] listeMatierePremiere = new MatierePremiere[4];
	private static ArrayList<MedicamentInterne> listeProduit = new ArrayList<MedicamentInterne>();
	
	
	public MedicamentInterne() {
		super();
	}
	
	public MedicamentInterne(String id, String nom, TypeMedicament typeMed,Double prix, MatierePremiere matierePrem1, MatierePremiere matierePrem2
								, MatierePremiere matirePrem3, MatierePremiere matierePrem4) {
		super(id, nom, "Medicament interne", typeMed, prix);
		listeMatierePremiere[0] = matierePrem1;
		listeMatierePremiere[1] = matierePrem2;
		listeMatierePremiere[2] = matirePrem3;
		listeMatierePremiere[3] = matierePrem4;
		
		
		// TODO Auto-generated constructor stub
	}
	

	public String getListeMatierePremiere(int index) {
		return listeMatierePremiere[index].getNomMatiere();
	}

	public void setListeMatierePremiere(String matPrem, int index) {
		boolean trouver = false;
		int i = 0;
		
		while(i < MatierePremiere.getListeMatiere().size() && trouver == false) {
			if(MatierePremiere.getListeMatiere().get(i).getNomMatiere().equals(matPrem)) {
				this.listeMatierePremiere[index] = MatierePremiere.getListeMatiere().get(i);
				trouver = true;
			}
			i++;
		}
	}

	public static ArrayList<MedicamentInterne> getListeProduit() {
		return listeProduit;
	}




	public static void setListeProduit(ArrayList<MedicamentInterne> listeProd) {
		listeProduit = listeProd;
	}
	
	public static void addProduit(MedicamentInterne produit) {
		listeProduit.add(produit);
	}
	
	public static void removeProduit(MedicamentInterne produit) {
		listeProduit.remove(produit);
	}

}
