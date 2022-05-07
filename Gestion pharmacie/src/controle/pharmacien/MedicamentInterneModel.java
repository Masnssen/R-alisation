package controle.pharmacien;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.pharmacien.MedicamentInterne;

public class MedicamentInterneModel extends AbstractTableModel{
	
	private ArrayList<MedicamentInterne> pr = new ArrayList<MedicamentInterne>();
	private String[] titre = {"id","Nom" , " Categorie" , "Type Med", "Matiere prem 1", "Matiere prem 2", "Matiere prem 3", "Matiere prem 4"};
	
	public MedicamentInterneModel() {
		super();
		pr = MedicamentInterne.getListeProduit();
	}
	
	public void setProduit(ArrayList<MedicamentInterne> prod) {
		pr = prod;
		
	}
	
	public int getRowCount() {
		return pr.size();
	}
	
	public int getColumnCount() {
		return titre.length;
	}
	

	public String getColumnName(int index) {
		return titre[index];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		switch(columnIndex) {
			case 0 : return pr.get(rowIndex).getIdProduit();
			case 1 : return pr.get(rowIndex).getNomProduit();
			case 2 : return pr.get(rowIndex).getCategorieProduit();
			case 3 : return pr.get(rowIndex).getTypeMedicament();
			case 4 : return pr.get(rowIndex).getListeMatierePremiere(0);
			case 5 : return pr.get(rowIndex).getListeMatierePremiere(1);
			case 6 : return pr.get(rowIndex).getListeMatierePremiere(2);
			case 7 : return pr.get(rowIndex).getListeMatierePremiere(3);
			default : return null;
		}
	}
	
	
	public void addProduit(MedicamentInterne produit) {
		
		pr.add(produit);
		fireTableRowsInserted(pr.size()-1,pr.size()-1);
	}
	
	public void removeProduit(int index) {
		
		pr.remove(index);
		fireTableRowsDeleted(index, index);
	}
	
	
}
