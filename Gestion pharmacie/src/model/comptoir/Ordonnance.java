package model.comptoir;

import java.time.LocalDate;
import java.util.ArrayList;

import model.commercial.Client;

public class Ordonnance {
	public static int id = 0;
	private int idOrdonnance;
	private LocalDate dateOrdonnance;
	private Client client;
	private ArrayList<MedicamentPrenscrit> listeMedicamentPrenscrit = new ArrayList<MedicamentPrenscrit>();
	private static ArrayList<Ordonnance> listeOrdonnance = new ArrayList<Ordonnance>();
	
	public Ordonnance() {
		id++;
	}

	public int getIdOrdonnance() {
		return idOrdonnance;
	}

	public void setIdOrdonnance(int idOrdonnance) {
		this.idOrdonnance = idOrdonnance;
	}

	public LocalDate getDateOrdonnance() {
		return dateOrdonnance;
	}

	public void setDateOrdonnance(LocalDate dateOrdonnance) {
		this.dateOrdonnance = dateOrdonnance;
	}

	public ArrayList<MedicamentPrenscrit> getListeMedicamentPrenscrit() {
		return listeMedicamentPrenscrit;
	}

	public void setListeMedicamentPrenscrit(ArrayList<MedicamentPrenscrit> listeMedicamentPrenscrit) {
		this.listeMedicamentPrenscrit = listeMedicamentPrenscrit;
	}

	public static ArrayList<Ordonnance> getListeOrdonnance() {
		return listeOrdonnance;
	}

	public static void setListeOrdonnance(ArrayList<Ordonnance> listeOrdonnance) {
		Ordonnance.listeOrdonnance = listeOrdonnance;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	
}
