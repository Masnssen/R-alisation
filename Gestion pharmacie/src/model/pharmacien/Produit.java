package model.pharmacien;

public class Produit {
	
	private String idProduit;
	private String nomProduit;
	private String categorieProduit = new String();
	private Double prix;

	
	
	public Produit() {};
	
	public Produit(String id, String nom, String categorie, Double prix) {
		idProduit = id;
		nomProduit = nom;
		categorieProduit = categorie;
		this.prix = prix;
		
		
	}
	public String getIdProduit() {
		return idProduit;
	}
	public String getNomProduit() {
		return nomProduit;
	}
	public String getCategorieProduit() {
		return categorieProduit;
	}
	public void setCategorieProduit(String categorieProduit) {
		this.categorieProduit = categorieProduit;
	}
	
	public void setIdProduit(String idProduit) {
		this.idProduit = idProduit;
	}
	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}
		
	public Double tauxRem(Double prix) {
		
		switch(this.getCategorieProduit()) {
			case "MedicamentInterne" : return prix*0.2;
			case "MedicamentExterne" : return prix*0.1;
			default : return 0.0;
		}
		
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}		
}
	