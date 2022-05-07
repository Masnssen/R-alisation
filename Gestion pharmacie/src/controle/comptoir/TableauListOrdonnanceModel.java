package controle.comptoir;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.comptoir.Ordonnance;

public class TableauListOrdonnanceModel extends AbstractTableModel{
	private String[] titre = {"Id", "Date", "Total", "Client"};
	private ArrayList<Ordonnance> ordonnance;
	
	public TableauListOrdonnanceModel() {
		ordonnance = Ordonnance.getListeOrdonnance();
	}
	
	public int getColumnCount() {
		return titre.length;
	}
	
	public int getRowCount() {
		return ordonnance.size();
	}
	
	public String getColumnName(int index) {
		return titre[index];
	}
	
	@Override
	public Object getValueAt(int index, int column) {
		switch(column) {
			case 0 : return ordonnance.get(index).getIdOrdonnance();
			case 1 : return	ordonnance.get(index).getDateOrdonnance();
			case 2 : return totalOrdonnance(index);
			case 3 : return ordonnance.get(index).getClient().nometprenom();
			default : return "";
		}
	}
	
	public void addOrdonnance(Ordonnance ord) {
			ordonnance.add(ord);
			fireTableRowsInserted(ordonnance.size()-1,ordonnance.size()-1);
	}
	
	public double totalOrdonnance(int index) {
		double total = 0;
		for(int i = 0; i < ordonnance.get(index).getListeMedicamentPrenscrit().size(); i++) {
			total = total+ordonnance.get(index).getListeMedicamentPrenscrit().get(i).getPrix() * ordonnance.get(index).getListeMedicamentPrenscrit().get(i).getQttDemander();
			
		}
		return total;
	}
	
}
