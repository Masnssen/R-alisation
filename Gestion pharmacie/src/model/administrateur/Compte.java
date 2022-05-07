package model.administrateur;

import java.util.ArrayList;

import javax.swing.JOptionPane;


public class Compte {
	private static int cpt = 1;
	private int idcompte;
	private String nom;
	private String prenom;
	private String fonction;
	private String user;
	private String password;
	public static ArrayList<Compte> listecompte= new ArrayList<>();
	
	public Compte(int idcompte) {
		this.idcompte = idcompte;
	}
	public Compte(int idcompte, String nom, String prenom, String fonction, String user, String password) {
		this.idcompte = idcompte;
		this.nom = nom;
		this.prenom = prenom;
		this.fonction = fonction;
		this.user = user;
		this.password = password;
	}
	public Compte(String nom, String prenom, String fonction, String user, String password) {
		this.nom = nom;
		this.prenom = prenom;
		this.fonction = fonction;
		this.user = user;
		this.password = password;
	}
	
	public int getIdcompte() {
		return idcompte;
	}
	public String getNom() {
		return nom;
	}
	public String getFonction() {
		return fonction;
	}
	public String getUser() {
		return user;
	}
	public String getPassword() {
		return password;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setFonction(String fonction) {
		this.fonction = fonction;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public static ArrayList<Compte> getListecompte() {
		return listecompte;
	}
	public void ajouter() {
		idcompte=cpt++;
		listecompte.add(this);
		
	}
	public void modifier() {
		for (Compte compte:listecompte) {
			if(compte.getIdcompte()==getIdcompte()) {
				compte.setFonction(getFonction());
				compte.setNom(getNom());
				compte.setPassword(getPassword());
				compte.setPrenom(getPrenom());
				compte.setUser(getUser());
				break;
				}
		}
		JOptionPane.showMessageDialog(null, "Modifier avec succes ");
	}
	public void supprimer() {
		for (Compte compte:listecompte) {
			if(compte.getIdcompte()==getIdcompte()) {
				listecompte.remove(compte);
				JOptionPane.showMessageDialog(null, "Supprimer avec succes ");			
				break;
			}
		}
	}
	
}
