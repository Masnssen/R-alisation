package controle.comptoir;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.commercial.CommandeAchat;
import model.comptoir.CommandeClient;

public class TableauListCommandeModel extends AbstractTableModel {
	
	private String[] titreCl = {"Id", "Client", "Date", "Etat"};
	private String[] titreAchat = {"Id", "Fourniseur", "Date", "Etat"};
	private ArrayList<CommandeClient> commandeCl;
	private ArrayList<CommandeAchat> achat ;
	private String categorie; //Soit commande client soit commande achat
	
	public TableauListCommandeModel(String categorie) {
		this.categorie = categorie;
		commandeCl = CommandeClient.getListeCommande();
		achat = CommandeAchat.getListecommande();
	}
	
	public int getColumnCount() {
		return titreCl.length;
	}
	
	public int getRowCount() {
		if(categorie.equals("Commande achat")) {
			return achat.size();
		}else {
			return commandeCl.size();
		}
		
	}
	
	public String getColumnName(int index) {
		if(categorie.equals("Commande achat")) {
			return titreAchat[index];
		}else {
			return titreCl[index];
		}
		
	}
	
	@Override
	public Object getValueAt(int index, int column) {
		if(categorie.equals("Commande achat")) {
			switch(column) {
				case 0 : return achat.get(index).getIdCommande();
				case 1 : return achat.get(index).getFornisseur().getNomcollaborateur();
				case 2 : return achat.get(index).getDateCommande();
				case 3 : return achat.get(index).getEtat();
				default : return "";
			}
		}else {
			switch(column) {
				case 0 : return commandeCl.get(index).getIdCommande();
				case 1 : return commandeCl.get(index).getClient();
				case 2 : return commandeCl.get(index).getDateCommande();
				case 3 : return commandeCl.get(index).getEtat();
				default : return "";
			}
		}
		
	}
	
	public void addCommande(CommandeClient com) {
		boolean ajouter = true;
		for(int i = 0 ; i < commandeCl.size() ; i++) {
			if(commandeCl.get(i).getIdCommande().equals(com.getIdCommande())) {
				commandeCl.set(i, com);
				ajouter = false;
				
			}
		}
		if(ajouter) {
			commandeCl.add(com);
			fireTableRowsInserted(commandeCl.size()-1,commandeCl.size()-1);
		}
	}
	
	public void addCommande(CommandeAchat com) {
		boolean ajouter = true;
		for(int i = 0 ; i < achat.size() ; i++) {
			if(achat.get(i).getIdCommande().equals(com.getIdCommande())) {
				achat.set(i, com);
				ajouter = false;
				
			}
		}
		if(ajouter) {
			achat.add(com);
			fireTableRowsInserted(achat.size()-1,achat.size()-1);
		}
	}
	

}
