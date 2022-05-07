package model.pharmacien;

import java.util.ArrayList;

public class MatierePremiere {
	
	public static int id = 0;
	private int idMatiere;
	private String nomMatiere;
	private double dosage;
	private static ArrayList<MatierePremiere> listeMatiere = new ArrayList<MatierePremiere>();
	
	
	public MatierePremiere() {
		id++;
		this.idMatiere = id;
		this.nomMatiere = new String("INCONNU");
	}
	public MatierePremiere(String nomMatiere) {
		id++;
		this.idMatiere = id;
		this.nomMatiere = nomMatiere;
	}
	
	public int getIdMatiere() {
		return idMatiere;
	}
	
	public String getNomMatiere() {
		return nomMatiere;
	}
	public void setNomMatiere(String nomMatiere) {
		this.nomMatiere = nomMatiere;
	}
	public double getDosage() {
		return dosage;
	}
	public void setDosage(double dosage) {
		this.dosage = dosage;
	}
	public static ArrayList<MatierePremiere> getListeMatiere() {
		return listeMatiere;
	}
	public static void setListeMatiere(ArrayList<MatierePremiere> listeMatiere) {
		MatierePremiere.listeMatiere = listeMatiere;
	}

}
