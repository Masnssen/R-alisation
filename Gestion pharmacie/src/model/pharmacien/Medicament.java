package model.pharmacien;

public class Medicament extends Produit {
	
	private String modeDeProse;
	private TypeMedicament typeMedicament;	
	
	public Medicament() {
		super();
	}
	
	public Medicament(String id, String nom, String categorie, TypeMedicament typeMed, Double prix) {
		super(id, nom, categorie, prix);
		this.typeMedicament = typeMed;
	}

	public String getModeDeProse() {
		return modeDeProse;
	}

	public void setModeDeProse(String modeDeProse) {
		this.modeDeProse = modeDeProse;
	}

	public String getTypeMedicament() {
		return typeMedicament.getLabel();
	}

	public void setTypeMedicament(String typeMedicament) {
		boolean trouver = false;
		int i = 0;
		while(i < TypeMedicament.getListType().size() && trouver == false) {
			if(TypeMedicament.getListType().get(i).getLabel().equals(typeMedicament)) {
				this.typeMedicament = TypeMedicament.getListType().get(i);
				trouver = true;
			}
			i++;
		}
		
	}	
}
