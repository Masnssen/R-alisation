package model.pharmacien;

import java.time.LocalDate;
import java.util.ArrayList;

public class MedicamentEnStock extends Medicament {

	private int qtt;
	private int numLot;
	private LocalDate dateExp;
	
	private static ArrayList<MedicamentEnStock> listeProduit = new ArrayList<MedicamentEnStock>();
		
	public MedicamentEnStock() {
		super();
	}
	public MedicamentEnStock(String id, String nom, TypeMedicament typeMed, Double prix) {
		super(id, nom, "Medicament externe", typeMed, prix);
		
	}
	
	public MedicamentEnStock(String id, String nom, TypeMedicament typeMed, int qtt,Double prix, int numLot) {
		super(id, nom, "Medicament externe", typeMed, prix);
		this.qtt = qtt;
		this.numLot = numLot;
		this.dateExp = LocalDate.now();
	}

	public int getQtt() {
		return qtt;
	}

	public void setQtt(int qtt) {
		this.qtt = qtt;
	}

	public int getNumLot() {
		return numLot;
	}

	public void setNumLot(int numLot) {
		this.numLot = numLot;
	}

	public LocalDate getDateExp() {
		return dateExp;
	}

	public void setDateExp(LocalDate dateExp) {
		this.dateExp = dateExp;
	}

	
	public static ArrayList<MedicamentEnStock> getListeProduit(){
		return listeProduit;
	}
	
	
	

}
