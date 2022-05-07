package model.commercial;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Client extends Collaborateur{

	private static int cpt = 1;
	private String age;
	private String numSecurité;
	private String maladieChronique;
	public static ArrayList<Client> listecclient = new ArrayList<>();
	public Client(int idcollaborateur, String nomcollaborateur, String prenomcollaborateur,
			String String,String numSecurité,String maladieChronique) {
		super(idcollaborateur, nomcollaborateur, prenomcollaborateur);
		this.age=age;
		this.numSecurité = numSecurité;
		this.maladieChronique = maladieChronique;
	}
	public Client(String nomcollaborateur, String prenomcollaborateur,
			String age,String numSecurité,String maladieChronique) {
		super(nomcollaborateur, prenomcollaborateur);
		this.age=age;
		this.numSecurité = numSecurité;
		this.maladieChronique = maladieChronique;
	}
	public Client(int idcollaborateur) {
		super(idcollaborateur);
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getNumSecurité() {
		return numSecurité;
	}
	public void setNumSecurité(String numSecurité) {
		this.numSecurité = numSecurité;
	}
	public String getMaladieChronique() {
		return maladieChronique;
	}
	public void setMaladieChronique(String maladieChronique) {
		this.maladieChronique = maladieChronique;
	}
	public String nometprenom() {
		return getNomcollaborateur() +" "+getPrenomcollaborateur();
	}
	
	public static ArrayList<Client> getListecclient() {
		return listecclient;
	}
	public void ajouter() {
		super.setIdcollaborateur(cpt++);
		listecclient.add(this);
		}
	public void modifier() {
		for (Client client : listecclient) {
			if(client.getIdcollaborateur() == getIdcollaborateur()) {
				client.setNomcollaborateur(getNomcollaborateur());
				client.setAge(getAge());
				client.setMaladieChronique(getMaladieChronique());
				client.setNumSecurité(getNumSecurité());
				client.setPrenomcollaborateur(getPrenomcollaborateur());
				break;
			}
		}
		JOptionPane.showMessageDialog(null, "Modifier avec succes ");
	}
	public void supprimer() {
		for (Client client : listecclient) {
			if(client.getIdcollaborateur() == getIdcollaborateur()) {
				listecclient.remove(client);
				break;
			}
		}
		JOptionPane.showMessageDialog(null, "Supprimer avec succes ");
	}
	public String getType() {
		return "Client";
	}
}
