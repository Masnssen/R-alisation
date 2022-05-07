package model.commercial;

import java.time.LocalDate;
import java.util.ArrayList;

import model.comptoir.Commande;

public class CommandeAchat extends Commande{
	
	private Fournisseur fornisseur;
	public static int id = 0;
	private static ArrayList<CommandeAchat> listecommande = new ArrayList<>();
	
	public CommandeAchat() {
		id++;
	}
	public CommandeAchat(String idCommande, LocalDate dateCommande) {
		super(idCommande, dateCommande);
	}
	public static ArrayList<CommandeAchat> getListecommande() {
		return listecommande;
	}
	public static void setListecommande(ArrayList<CommandeAchat> listecommande) {
		CommandeAchat.listecommande = listecommande;
	}
	public Fournisseur getFornisseur() {
		return fornisseur;
	}
	public void setFornisseur(Fournisseur fornisseur) {
		this.fornisseur = fornisseur;
	}
	
	
	
	
}
