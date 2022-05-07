package controle.comptoir;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import model.comptoir.MedicamentPrenscrit;
import model.comptoir.ProduitQtt;
import model.pharmacien.MedicamentEnStock;
import model.pharmacien.Produit;
import model.pharmacien.ProduitPharmaceutique;

public class TableauOrdonnanceModel extends AbstractTableModel {
	private String[] titreOrdonnance = {"Id" , "Nom", "Prix/u", "Qtt", "Duree traitement", "prix"};
	private String[] titreCommande = {"id", "Nom", "Prix/u", "Qtt", "Prix"};
	private String[] titre;
	private ArrayList<MedicamentPrenscrit> pr;
	private ArrayList<ProduitQtt> prQtt;
	private String categorie; //soit Ordonnance  soit Commande
	
	public TableauOrdonnanceModel(String categorie) {
		this.categorie = categorie;
		if(categorie.equals("Ordonnance")) {
			pr = new ArrayList<MedicamentPrenscrit>();
			titre = titreOrdonnance;
		}else {
			prQtt = new ArrayList<ProduitQtt>();
			titre = titreCommande;
		}
		
	}
	
	public void setOrd() {
		pr = new ArrayList<MedicamentPrenscrit>();
	}
	
	public void setOrd(ArrayList<MedicamentPrenscrit> med) {
		pr = new ArrayList<MedicamentPrenscrit>();
		MedicamentPrenscrit pren;
		for(int i = 0; i < med.size(); i++) {
			pren = new MedicamentPrenscrit();
			pren.setIdProduit(med.get(i).getIdProduit());
			pren.setNomProduit(med.get(i).getNomProduit());
			pren.setCategorieProduit(med.get(i).getCategorieProduit());
			pren.setModeDeProse(med.get(i).getModeDeProse());
			pren.setPrix(med.get(i).getPrix());
			pren.setQttDemander(med.get(i).getQttDemander());
			
			pr.add(pren);
			
		}
		
	}
	
	public void setCommande(ArrayList<ProduitQtt> commande) {
		prQtt = new ArrayList<ProduitQtt>();
		ProduitQtt pren;
		Produit prod;
		for(int i = 0; i < commande.size(); i++) {
			pren = new ProduitQtt();
			prod = new Produit();
			prod.setIdProduit(commande.get(i).getProduit().getIdProduit());
			prod.setNomProduit(commande.get(i).getProduit().getNomProduit());
			prod.setCategorieProduit(commande.get(i).getProduit().getCategorieProduit());
			prod.setPrix(commande.get(i).getProduit().getPrix());
			
			pren.setQttCommander(commande.get(i).getQttCommander());
			pren.setProduit(prod);
			
			prQtt.add(pren);
			
		}
	
	}
	
	public MedicamentPrenscrit getMed(int index) {
			return pr.get(index);
	}
	
	public ArrayList<MedicamentPrenscrit> getMedicament(){
		return pr;
	}
	
	public ArrayList<ProduitQtt> getCommande(){
		return prQtt;
	}
	
	public int getColumnCount() {
		return titre.length;
	}
	
	public int getRowCount() {
		if(categorie.equals("Ordonnance")) {
			return pr.size();
		}else {
			return prQtt.size();
		}
		
		
	}
	
	public String getColumnName(int index) {
		return titre[index];
	}
	
	@Override
	public Object getValueAt(int index, int column) {
		if(categorie.equals("Ordonnance")) {
			switch(column) {
				case 0 : return pr.get(index).getIdProduit();
				case 1 : return pr.get(index).getNomProduit();
				case 2 : return pr.get(index).getPrix();
				case 3 : return pr.get(index).getQttDemander();
				case 4 : return pr.get(index).getDureeTraitement();
				case 5 : return pr.get(index).getPrix() *  pr.get(index).getQttDemander();
				default : return "";
			}
		}else {
			switch(column) {
				case 0 : return prQtt.get(index).getProduit().getIdProduit();
				case 1 : return prQtt.get(index).getProduit().getNomProduit();
				case 2 : return prQtt.get(index).getProduit().getPrix();
				case 3 : return prQtt.get(index).getQttCommander();
				case 4 : return prQtt.get(index).getProduit().getPrix()* prQtt.get(index).getQttCommander();
				default : return "";
			}
		}
		
		
	}
	
	public void addProduit(MedicamentPrenscrit produit, int row) {
		
		int index = this.verifieExistance(produit);
		if(index > -1) {
			if(this.verifieQtt(MedicamentEnStock.getListeProduit().get(row).getQtt(), pr.get(index).getQttDemander())) {
				pr.get(index).setQttDemander(pr.get(index).getQttDemander() +1);
			}else {
				JOptionPane.showMessageDialog(null, "Quantite epuiser");
			}	
		}else {
			pr.add(produit);
			fireTableRowsInserted(pr.size()-1,pr.size()-1);
		}
		
	}
	
	public void addProduit(ProduitQtt produit, int row, String type) {
		int index = this.verifieExistance(produit);
		if(index > -1) {
			
			if(type.equals("Produit pharmaceutique")) {
				if(this.verifieQtt(ProduitPharmaceutique.getListeProduit().get(row).getQtt(), prQtt.get(index).getQttCommander())) {
					prQtt.get(index).setQttCommander(pr.get(index).getQttDemander() +1);
				}else {
					JOptionPane.showMessageDialog(null, "Quantite epuiser");
				}
			}else if(type.equals("Medicament externe")){
				if(this.verifieQtt(MedicamentEnStock.getListeProduit().get(row).getQtt(), prQtt.get(index).getQttCommander())) {
					prQtt.get(index).setQttCommander(pr.get(index).getQttDemander() +1);
				}else {
					JOptionPane.showMessageDialog(null, "Quantite epuiser");
				}
			}else {
				prQtt.get(index).setQttCommander(pr.get(index).getQttDemander() +1);
			}
			
		}else {
			prQtt.add(produit);
			fireTableRowsInserted(prQtt.size()-1,prQtt.size()-1);
		}
	}
	
	public void removeProduit(int index) {
		if(categorie.equals("Ordonnance")) {
			pr.remove(index);
		}else {
			prQtt.remove(index);
		}
		
		fireTableRowsDeleted(index, index);
		
	}
	
	public String getTotal() {
		Double total = 0.0;
		if(categorie.equals("Ordonnance")) {
			for(int i = 0; i < pr.size(); i++) {
				total = total + (Double)pr.get(i).getPrix() * pr.get(i).getQttDemander();
			}
		}else {
			for(int i = 0; i < prQtt.size(); i++) {
				total = total + (Double)prQtt.get(i).getProduit().getPrix() * prQtt.get(i).getQttCommander();
			}
		}
		
		if(total.toString().length() < 8) {
			return total.toString();
		}
		return total.toString().substring(0, 8);
	}
	//Methode qui verifie si un ProduitQtt ou un Medicament prenscrit existe deja dans la liste
	public int verifieExistance(ProduitQtt prod) {
		
		for(int i = 0; i < this.prQtt.size(); i++ ) {
			if(prod.getProduit().getIdProduit().equals(prQtt.get(i).getProduit().getIdProduit())) {
				return i;
			}
		}
		return -1;
	}
	
	public int verifieExistance(MedicamentPrenscrit medPren) {
		for(int i = 0; i < this.pr.size(); i++ ) {
			if(medPren.getIdProduit().equals(pr.get(i).getIdProduit())) {
				return i;
			}
		}
		return -1;
	}
	
	
	public boolean verifieQtt(int qtt1, int qtt2) {
		if(qtt1 > qtt2) {
			return true;
		}else {
			return false;
		}
	}
	
	
}
