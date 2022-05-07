package controle.pharmacien;

import javax.swing.table.AbstractTableModel;

import model.pharmacien.MatierePremiere;
import model.pharmacien.TypeMedicament;

public class MatiereListeModel extends AbstractTableModel{
	
	private String[] titreType = {"id", "Label", "Description" };
	private String[] titreMat = {"id", "Nom" };
	private String categorie; //Soit typeMedicamet soit matiere premiere
	
	
	public MatiereListeModel(String categorie) {
		this.categorie = categorie;
	}
	
	public int getRowCount() {
		if(categorie.equals("Type medicament")) {
			return TypeMedicament.getListType().size();
		}else {
			return MatierePremiere.getListeMatiere().size();
		}
	}
	
	public int getColumnCount() {
		if(categorie.equals("Type medicament")) {
			return titreType.length;
		}else {
			return titreMat.length;
		}
	}
	

	public String getColumnName(int index) {
		if(categorie.equals("Type medicament")) {
			return titreType[index];
		}else {
			return titreMat[index];
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		if(categorie.equals("Type medicament")) {
			switch(columnIndex) {
				case 0 : return TypeMedicament.getListType().get(rowIndex).getId();
				case 1 : return TypeMedicament.getListType().get(rowIndex).getLabel();
				case 2 : return TypeMedicament.getListType().get(rowIndex).getDescription();
				default : return null;
			}
		}else {
			switch(columnIndex) {
				case 0 : return MatierePremiere.getListeMatiere().get(rowIndex).getIdMatiere();
				case 1 : return MatierePremiere.getListeMatiere().get(rowIndex).getNomMatiere();
				default : return null;
			}
		}
		
	}
	
	
}
