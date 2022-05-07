package controle.comptoir;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.pharmacien.MedicamentEnStock;
import model.pharmacien.ProduitPharmaceutique;

public class TableauProduitModel extends AbstractTableModel {
	
	private String[] titre;
	private ArrayList<ProduitPharmaceutique> pr;
	private ArrayList<MedicamentEnStock> med;
	private String categorie = new String(); //soit produit pharmaceutique m soit medicament externe 
	
	public TableauProduitModel(String categorie) {
		this.categorie = categorie;
		if(categorie.equals("Produit pharmaceutique")) {
			pr = ProduitPharmaceutique.getListeProduit();
			titre = new String[4];
			titre[0] = "Id";
			titre[1] = "Nom";
			titre[2] = "Prix/U";
			titre[3] = "Qtt";
			
		}else {
			med = MedicamentEnStock.getListeProduit();
			titre = new String[8];
			titre[0] = "Id";
			titre[1] = "Nom";
			titre[2] = "Prix/U";
			titre[3] = "Qtt";
			titre[4] = "Type";
			titre[5] = "Mode prise";
			titre[6] = "Date exp";
			titre[7] = "Lot";
		}
	}
	
	public int getColumnCount() {
		return titre.length;
	}
	
	public int getRowCount() {
		
		if(categorie.equals("Produit pharmaceutique")) {
			return pr.size();
		}else {
			return med.size();
		}
		
	}
	
	public String getColumnName(int index) {
		return titre[index];
	}
	
	@Override
	public Object getValueAt(int index, int column) {
		if(categorie.equals("Produit pharmaceutique")) {
			switch(column) {
				case 0 : return pr.get(index).getIdProduit();
				case 1 : return pr.get(index).getNomProduit();
				case 2 : return pr.get(index).getPrix();
				case 3 : return String.valueOf(pr.get(index).getQtt());
				default : return "";
			}
		}else {
			switch(column) {
				case 0 : return med.get(index).getIdProduit();
				case 1 : return med.get(index).getNomProduit();
				case 2 : return med.get(index).getPrix();
				case 3 : return String.valueOf(med.get(index).getQtt());
				case 4 : return med.get(index).getTypeMedicament();
				case 5 : return med.get(index).getModeDeProse();
				case 6 : return med.get(index).getDateExp().toString();
				case 7 : return String.valueOf(med.get(index).getNumLot());
				default : return "";
			}
		}
		
	}
	
	public Object getProduit(int index) {
		if(categorie.equals("Produit pharmaceutique")) {
			return pr.get(index);
		}else {
			return med.get(index);
		}
	}
	
	public void recherche(String recherche) {
		if(categorie.equals("Produit pharmaceutique")) {
			pr = new ArrayList<ProduitPharmaceutique>();
			for(int i = 0; i < ProduitPharmaceutique.getListeProduit().size(); i++) {
				if(ProduitPharmaceutique.getListeProduit().get(i).getNomProduit().contains(recherche)) {
					pr.add(ProduitPharmaceutique.getListeProduit().get(i));
				}
			}
		}else {
			med = new ArrayList<MedicamentEnStock>();
			for(int i = 0; i < MedicamentEnStock.getListeProduit().size(); i++) {
				if(MedicamentEnStock.getListeProduit().get(i).getNomProduit().contains(recherche)) {
					med.add(MedicamentEnStock.getListeProduit().get(i));
				}
			}
			
		}
	}
}
