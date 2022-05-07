package controle.pharmacien;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.pharmacien.MedicamentEnStock;

public class MedicamentExterneModel extends AbstractTableModel {
	private ArrayList<MedicamentEnStock> pr = new ArrayList<MedicamentEnStock>();
	private String[] titre = {"id","Nom" , " Categorie", "Type Medicament" };
	
	public MedicamentExterneModel() {
		super();
		pr = MedicamentEnStock.getListeProduit();
	}
	
	public void setProduit(ArrayList<MedicamentEnStock> prod) {
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
			default : return null;
		}
	}
	
	
	public void addProduit(MedicamentEnStock produit) {
		
		pr.add(produit);
		fireTableRowsInserted(pr.size()-1,pr.size()-1);
	}
	
	public void removeProduit(int index) {
		
		pr.remove(index);
		fireTableRowsDeleted(index, index);
		
	}
}
