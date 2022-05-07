package model.comptoir;

import model.pharmacien.MedicamentEnStock;
import model.pharmacien.Produit;
import model.pharmacien.ProduitPharmaceutique;

public class ProduitQtt {
	
	
	private Produit produit;
	private int qttCommander;
	
	
	
	public ProduitQtt() {
	}
	public ProduitQtt(Produit produit, int qttCommander) {
		this.produit = produit;
		this.qttCommander = qttCommander;
	}
	
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public int getQttCommander() {
		return qttCommander;
	}
	public void setQttCommander(int qttCommander) {
		this.qttCommander = qttCommander;
	}
	
	//transforme un produit pharmaceutique ou medicament externe en produitQtt (Produit d'une commande)
	
	public static ProduitQtt transformer(int index, String categorie) {
		
		ProduitQtt produitQtt;
		Produit produit = new Produit();
		
		if(categorie.equals("Produit pharmaceutique")) {
			ProduitPharmaceutique pr;
			pr = ProduitPharmaceutique.getListeProduit().get(index);
			produit.setIdProduit(pr.getIdProduit());
			produit.setNomProduit(pr.getNomProduit());
			produit.setCategorieProduit(pr.getCategorieProduit());
			produit.setPrix(pr.getPrix());
		}else {
			MedicamentEnStock pr;
			pr = MedicamentEnStock.getListeProduit().get(index);
			produit.setIdProduit(pr.getIdProduit());
			produit.setNomProduit(pr.getNomProduit());
			produit.setCategorieProduit(pr.getCategorieProduit());
			produit.setPrix(pr.getPrix());
		}
		produitQtt = new ProduitQtt(produit, 1);
		
		return produitQtt;

	}
	
}
