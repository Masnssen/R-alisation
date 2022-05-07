package model.comptoir;

import java.time.LocalDate;
import java.util.ArrayList;

public class Commande {
	
	
	private String idCommande;
	private LocalDate dateCommande;
	private String etat = new String();
	private ArrayList<ProduitQtt> listeProduit = new ArrayList<ProduitQtt>();
	
	public Commande() {
	}
	
	public Commande(String idCommande, LocalDate dateCommande) {
		super();
		this.idCommande = idCommande;
		this.dateCommande = dateCommande;
		this.etat = "En attente";
	}
	//return la categorie de la commande soit commandeClient ou commandeAchat
	public String categorieCommende() {
		return this.getClass().toString();
	}
	public String getIdCommande() {
		return idCommande;
	}
	public void setIdCommande(String idCommande) {
		this.idCommande = idCommande;
	}
	public LocalDate getDateCommande() {
		return dateCommande;
	}
	public void setDateCommande(LocalDate dateCommande) {
		this.dateCommande = dateCommande;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public ArrayList<ProduitQtt> getListeProduit() {
		return listeProduit;
	}
	public void setListeProduit(ArrayList<ProduitQtt> listeProduit) {
		this.listeProduit = listeProduit;
	}
	
}
