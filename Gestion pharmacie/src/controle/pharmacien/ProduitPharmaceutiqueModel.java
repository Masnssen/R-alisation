package controle.pharmacien;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.pharmacien.ProduitPharmaceutique;

public class ProduitPharmaceutiqueModel extends AbstractTableModel {
	private ArrayList<ProduitPharmaceutique> pr;
	private String[] titre = {"id","Nom" , " Categorie" };
	
	public ProduitPharmaceutiqueModel() {
		super();
		pr = ProduitPharmaceutique.getListeProduit();
		//for(int i = 0 ; i < ProduitPharmaceutique.getListeProduit().size(); i++) {
			//pr.add(ProduitPharmaceutique.getListeProduit().get(i));
		//}
	}
	
	public void setProduit(ArrayList<ProduitPharmaceutique> prod) {
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
			case 0 : return ((ProduitPharmaceutique)pr.get(rowIndex)).getIdProduit();
			case 1 : return ((ProduitPharmaceutique)pr.get(rowIndex)).getNomProduit();
			case 2 : return ((ProduitPharmaceutique)pr.get(rowIndex)).getCategorieProduit();
			default : return null;
		}
	}
	
	
	public void addProduit(ProduitPharmaceutique produit) {
		
		pr.add(produit);
		fireTableRowsInserted(pr.size()-1,pr.size()-1);
	}
	
	public void removeProduit(int index) {
		pr.remove(index);
		fireTableRowsDeleted(index, index);
		
	}
	public void setProduit(ProduitPharmaceutique produit,int index) {
		pr.set(index, produit);
		this.fireTableRowsUpdated(index, index);
	}
}
