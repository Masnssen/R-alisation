package model.pharmacien;

import java.util.ArrayList;

public class ProduitPharmaceutique extends Produit {
	
	private int qtt; //c'est la qtt en stock
	
	
	private static ArrayList<ProduitPharmaceutique> listeProduit = new ArrayList<ProduitPharmaceutique>();
	
	public ProduitPharmaceutique() {};
	public ProduitPharmaceutique(String id, String nom, Double prix) {
		super(id, nom, "Produit pharmaceutique", prix);
		this.qtt = 0;
	}
	public ProduitPharmaceutique(String id, String nom, int qtt, Double prix) {
		super(id, nom, "Produit pharmaceutique", prix);
		this.qtt = qtt;
	}

	public static ArrayList<ProduitPharmaceutique> getListeProduit() {
		return listeProduit;
	}

	public static void setListeProduit(ArrayList<ProduitPharmaceutique> listeProduit) {
		ProduitPharmaceutique.listeProduit = listeProduit;
	}
	
	public void addProduit(ProduitPharmaceutique produit) {
		listeProduit.add(produit);
	}
	public void removeProduit(ProduitPharmaceutique produit) {
		listeProduit.remove(produit);
	}
	public int getQtt() {
		return qtt;
	}
	public void setQtt(int qtt) {
		this.qtt = qtt;
	}
	

}
