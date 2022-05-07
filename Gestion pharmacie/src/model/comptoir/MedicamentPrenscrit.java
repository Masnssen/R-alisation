package model.comptoir;

import model.pharmacien.Medicament;
import model.pharmacien.TypeMedicament;

public class MedicamentPrenscrit extends Medicament {
	

	private int qttDemander;
	private int dureeTraitement;
	
	
	public MedicamentPrenscrit() {
	}
	
	public MedicamentPrenscrit(String id, String nom, TypeMedicament typeMed, Double prix) {
		super(id, nom, "Medicament prenscrit", typeMed, prix);
	}
	
	public MedicamentPrenscrit(String id, String nom, TypeMedicament typeMed,Double prix, int qtt, int duree) {
		super(id, nom, "Medicament prenscrit", typeMed, prix);
		this.qttDemander = qtt;
		this.dureeTraitement = duree;
	}
	
	public int getQttDemander() {
		return qttDemander;
	}
	public void setQttDemander(int qttDemander) {
		this.qttDemander = qttDemander;
	}
	public int getDureeTraitement() {
		return dureeTraitement;
	}
	public void setDureeTraitement(int dureeTraitement) {
		this.dureeTraitement = dureeTraitement;
	}
	
	
}
