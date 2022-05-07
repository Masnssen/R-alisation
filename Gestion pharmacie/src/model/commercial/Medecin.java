package model.commercial;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Medecin extends Collaborateur {
	private static int cpt = 1;
	private String listecclient;
	private String adressemedecin;
	private String specialite ;
	public static ArrayList<Medecin> listemedecin = new ArrayList<>();
	
	public Medecin(int idcollaborateur, String nomcollaborateur, String prenomcollaborateur,String adressemedecin,String specialite) {
		super(idcollaborateur, nomcollaborateur, prenomcollaborateur);
		this.adressemedecin=adressemedecin;
		this.specialite = specialite;
	}
	public Medecin(String nomcollaborateur, String prenomcollaborateur,String adressemedecin,String specialite) {
		super(nomcollaborateur, prenomcollaborateur);
		this.adressemedecin=adressemedecin;
		this.specialite = specialite;
	}
	public Medecin(int idcollaborateur) {
		super(idcollaborateur);
		
	}
	public String getListecclient() {
		return listecclient;
	}
	public void setListecclient(String listecclient) {
		this.listecclient = listecclient;
	}
	public String getAdressemedecin() {
		return adressemedecin;
	}
	public void setAdressemedecin(String adressemedecin) {
		this.adressemedecin = adressemedecin;
	}
	
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	public static ArrayList<Medecin> getListemedecin() {
		return listemedecin;
	}
	
	public void ajouter() {
		super.setIdcollaborateur(cpt++);
		listemedecin.add(this);
		JOptionPane.showMessageDialog(null, "Ajouter avec succes ");
		}
	public void modifier() {
		for (Medecin medecin : listemedecin) {
			if(medecin.getIdcollaborateur() == getIdcollaborateur()) {
				medecin.setNomcollaborateur(getNomcollaborateur());
				medecin.setAdressemedecin(getAdressemedecin());
				medecin.setSpecialite(getSpecialite());
				medecin.setPrenomcollaborateur(getPrenomcollaborateur());
				break;
			}
		}
		JOptionPane.showMessageDialog(null, "Modifier avec succes ");
	}
	public void supprimer() {
		for (Medecin medecin  : listemedecin) {
			if(medecin.getIdcollaborateur() == getIdcollaborateur()) {
				listemedecin.remove(medecin);
				break;
			}
		}
		JOptionPane.showMessageDialog(null, "Supprimer avec succes ");
	}
	public String getType() {
		return "Medecin";
	}
}
