package model.commercial;

public class Collaborateur {
	private int idcollaborateur;
	private String nomcollaborateur;
	private String prenomcollaborateur;
	
	public Collaborateur(int idcollaborateur, String nomcollaborateur, String prenomcollaborateur) {
		this.idcollaborateur = idcollaborateur;
		this.nomcollaborateur = nomcollaborateur;
		this.prenomcollaborateur = prenomcollaborateur;
	}
	public Collaborateur(String nomcollaborateur, String prenomcollaborateur) {
		this.nomcollaborateur = nomcollaborateur;
		this.prenomcollaborateur = prenomcollaborateur;
	}
	public Collaborateur(int idcollaborateur) {
		this.idcollaborateur = idcollaborateur;
	}	

	public String getNomcollaborateur() {
		return nomcollaborateur;
	}

	public void setNomcollaborateur(String nomcollaborateur) {
		this.nomcollaborateur = nomcollaborateur;
	}

	public String getPrenomcollaborateur() {
		return prenomcollaborateur;
	}

	public void setPrenomcollaborateur(String prenomcollaborateur) {
		this.prenomcollaborateur = prenomcollaborateur;
	}

	public void setIdcollaborateur(int idcollaborateur) {
		this.idcollaborateur = idcollaborateur;
	}
	public int getIdcollaborateur() {
		return idcollaborateur;
	}
	public String getType() {
		return "";
	}
}
