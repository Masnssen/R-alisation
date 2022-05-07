package controle.comptoir;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import Vue.comtoir.PanneauCommandeClient;
import model.comptoir.CommandeClient;
import model.comptoir.ProduitQtt;
import model.pharmacien.MedicamentEnStock;
import model.pharmacien.Produit;
import model.pharmacien.ProduitPharmaceutique;

public class ControleCommandeClient implements ActionListener,MouseListener{
	
	private PanneauCommandeClient vue;
	private TableauProduitModel medModel;
	private TableauProduitModel prod;
	private TableauOrdonnanceModel commandeModel;
	private TableauListCommandeModel listModel;
	private String categorie;
	
	
	
	public ControleCommandeClient(PanneauCommandeClient vue) {
		this.vue = vue;
	
		initInterface();
		initButton();
	}
	
	public void initInterface() {
		prod = new TableauProduitModel("Produit pharmaceutique");
		
		medModel = new TableauProduitModel("Medicament externe");
		vue.getTableProduit().setModel(medModel);
		vue.getTableProduit().revalidate();
		categorie = "Medicament externe";
		commandeModel = new TableauOrdonnanceModel("Commande");
		vue.getTableCommande().setModel(commandeModel);
		vue.getTableCommande().revalidate();
		
		listModel = new TableauListCommandeModel("Commande client");
		vue.getTableListCommande().setModel(listModel);
		vue.getTableListCommande().revalidate();
		
	}
	
	
	public void initButton() {
		vue.getBtnReturn().addActionListener(this);
		
		vue.getBtnAjouter().addActionListener(this);
		vue.getBtnSupprimerProduit().addActionListener(this);
		
		vue.getBtnMedicamentExterne().addActionListener(this);
		vue.getBtnProduitPharmaceutique().addActionListener(this);
		
		vue.getBtnAjouterLaCommande().addActionListener(this);
		
		vue.getBtnAfficher().addActionListener(this);
		
		vue.getBtnSupprimerLaCommande().addActionListener(this);
		vue.getBtnServie().addActionListener(this);
		
		vue.getBtnNvCommande().addActionListener(this);
		
		vue.getTableProduit().addMouseListener(this);
		vue.getTableCommande().addMouseListener(this);
		vue.getTableListCommande().addMouseListener(this);		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==vue.getBtnNvCommande()) {
			commandeModel.setCommande(new ArrayList<ProduitQtt>());
			vue.getTableCommande().revalidate();
			vue.getTableCommande().repaint();
			vue.getBtnNvCommande().setEnabled(false);
			vue.getBtnAjouterLaCommande().setEnabled(false);
			vue.getBtnSupprimerProduit().setEnabled(false);
			vue.getBtnAjouter().setEnabled(false);
			vue.getBtnAfficher().setEnabled(false);
			vue.getBtnSupprimerLaCommande().setEnabled(false);
			vue.getBtnServie().setEnabled(false);
			vue.getTxtIdCommande().setText("");
		}
		if(e.getActionCommand().equals("Ajouter le produit")) {
			int index = vue.getTableProduit().getSelectedRow();
			boolean test = true;
			if(index > -1) {
				if(categorie.equals("Produit pharmaceutique")) {
					if(ProduitPharmaceutique.getListeProduit().get(index).getQtt() < 1) {
						test = false;
						JOptionPane.showMessageDialog(null, "Quantite epuiser");
					}else {
					}
				}else {
					if(MedicamentEnStock.getListeProduit().get(index).getQtt() < 1) {
						test = false;
					}
					
				}
				
				if(test) {
					commandeModel.addProduit(transformer(index), index, categorie);
					vue.getTextTotal().setText(commandeModel.getTotal());
					vue.getTableListCommande().revalidate();
					vue.getTableCommande().repaint();
					vue.getBtnAjouterLaCommande().setEnabled(true);
					vue.getBtnAjouter().setEnabled(false);
					vue.getBtnNvCommande().setEnabled(true);
				}
				
			}
		}else if(e.getActionCommand().equals("Supprimer produit")) {
			int index = vue.getTableCommande().getSelectedRow();
			if(index > -1) {
				commandeModel.removeProduit(index);
				vue.getTableCommande().revalidate();
				vue.getTableCommande().repaint();
				vue.getTextTotal().setText(commandeModel.getTotal());
				vue.getBtnSupprimerProduit().setEnabled(false);
				if(commandeModel.getRowCount()==0) {
					vue.getBtnAjouterLaCommande().setEnabled(false);
				}
				
			}
				
		}else if(e.getActionCommand().equals("Return")) {
			vue.dispose();
		}else if(e.getActionCommand().equals("Produit pharmaceutique")) {
			vue.getTableProduit().setModel(prod);
			vue.getTableProduit().revalidate();
			categorie = "Produit pharmaceutique";
		}else if(e.getActionCommand().equals("Medicament externe")) {
			vue.getTableProduit().setModel(medModel);
			vue.getTableProduit().revalidate();
			categorie = "Medicament externe";
		}else if(e.getActionCommand().equals("Ajouter la commande")) {
			CommandeClient commande = new CommandeClient();
			if(vue.getTxtIdCommande().getText().trim().isEmpty()) {
				commande.setIdCommande(String.valueOf(listModel.getRowCount() + 1));
				vue.getBtnAjouterLaCommande().setEnabled(false);
				vue.getBtnNvCommande().setEnabled(false);
			}else {
				commande.setIdCommande(vue.getTxtIdCommande().getText());
			}
			commande.setClient(vue.getComboBox().getSelectedItem().toString());
			commande.setDateCommande(LocalDate.now());
			commande.setEtat("En attente");
			commande.setListeProduit(commandeModel.getCommande());
			commandeModel.setCommande(new ArrayList<ProduitQtt>());
			listModel.addCommande(commande);
			vue.getTableListCommande().repaint();
			vue.getTableCommande().revalidate();
			vue.getTableCommande().repaint();
			
			vue.getTxtIdCommande().setText("");
			vue.getComboBox().setSelectedIndex(0);
			
			vue.getTextTotal().setText(commandeModel.getTotal());
			
		}else if(e.getActionCommand().equals("Afficher")) {
			int index = vue.getTableListCommande().getSelectedRow();
			if(index > -1) {
				commandeModel.setCommande(CommandeClient.getListeCommande().get(index).getListeProduit());
				vue.getTableCommande().revalidate();
				vue.getTableCommande().repaint();
				
				vue.getTxtIdCommande().setText(CommandeClient.getListeCommande().get(index).getIdCommande());
				vue.getComboBox().setSelectedIndex(getNumItem(vue.getComboBox(), CommandeClient.getListeCommande().get(index).getClient()));
				
				vue.getTextTotal().setText(commandeModel.getTotal());
				
				vue.getBtnAfficher().setEnabled(false);
				vue.getBtnServie().setEnabled(false);
				vue.getBtnSupprimerLaCommande().setEnabled(false);
				vue.getBtnNvCommande().setEnabled(true);
			}
			
		}else if(e.getActionCommand().equals("Supprimer la commande")) {
			int ligne = vue.getTableListCommande().getSelectedRow();
			if(vue.getTableListCommande().getModel().getValueAt(ligne,0).toString().equals(vue.getTxtIdCommande().getText())) {
				commandeModel.setCommande(new ArrayList<ProduitQtt>());
				vue.getTableCommande().revalidate();
				vue.getTableCommande().repaint();	
			}
			int index = vue.getTableListCommande().getSelectedRow();
			if(index > -1) {
				CommandeClient.getListeCommande().remove(index);
				vue.getTableListCommande().revalidate();
				vue.getTableListCommande().repaint();
				vue.getBtnAfficher().setEnabled(false);
				vue.getBtnServie().setEnabled(false);
				vue.getBtnSupprimerLaCommande().setEnabled(false);
				
				
			}
		}else if(e.getActionCommand().equals("Servie")) {
			int index = vue.getTableListCommande().getSelectedRow();
			
			if(index > -1) {
				vue.getBtnServie().setEnabled(true);
				if(CommandeClient.getListeCommande().get(index).getEtat().equals("Servie")) {
					
				}else {
					CommandeClient.getListeCommande().get(index).setEtat("Servie");
					servie(index);
					vue.getTableProduit().revalidate();
					vue.getTableProduit().repaint();
					
					vue.getTableListCommande().revalidate();
					vue.getTableListCommande().repaint();
										
				}
			}
			vue.getBtnAfficher().setEnabled(false);
			vue.getBtnServie().setEnabled(false);
			vue.getBtnSupprimerLaCommande().setEnabled(false);
		}
	}
	
	public ProduitQtt transformer(int index) {
		
		ProduitQtt produitQtt;
		Produit produit = new Produit();
		
		if(categorie.equals("Produit pharmaceutique")) {
			ProduitPharmaceutique pr;
			pr = ProduitPharmaceutique.getListeProduit().get(index);
			produit.setIdProduit(pr.getIdProduit());
			produit.setNomProduit(pr.getNomProduit());
			produit.setCategorieProduit(pr.getCategorieProduit());
			produit.setPrix(pr.getPrix());
		}else {
			MedicamentEnStock pr;
			pr = MedicamentEnStock.getListeProduit().get(index);
			produit.setIdProduit(pr.getIdProduit());
			produit.setNomProduit(pr.getNomProduit());
			produit.setCategorieProduit(pr.getCategorieProduit());
			produit.setPrix(pr.getPrix());
		}
		produitQtt = new ProduitQtt(produit, 1);
		
		return produitQtt;

	}
	
	//return le numero du client dans la comboBox
	public int getNumItem(JComboBox comb, String client) {
		
		for(int i = 0; i < comb.getItemCount() ; i++ ) {
			if(comb.getItemAt(i).toString().equals(client)) {
				return i;
			}
		}
		return -1;
	}
	
	public void servie(int index) {
		ArrayList<ProduitQtt> prQtt = CommandeClient.getListeCommande().get(index).getListeProduit();
		ArrayList<ProduitPharmaceutique> prPhar = ProduitPharmaceutique.getListeProduit();
		ArrayList<MedicamentEnStock> medStock = MedicamentEnStock.getListeProduit();
		int newQtt;
		int j = 0;
		boolean trouver;
		for(int i = 0; i < prQtt.size(); i++) {
			trouver = false;
			j = 0;
			if(prQtt.get(i).getProduit().getCategorieProduit().equals("Produit pharmaceutique")) {
				while(j < prPhar.size() && trouver == false) {
					if(prQtt.get(i).getProduit().getIdProduit().equals(prPhar.get(j).getIdProduit())) {
						newQtt = prPhar.get(j).getQtt() - prQtt.get(i).getQttCommander();
						prPhar.get(j).setQtt(newQtt);
						trouver = true;
					}
					j++;
				}
			}else {
				while(j < medStock.size() && trouver == false) {
					if(prQtt.get(i).getProduit().getIdProduit().equals(medStock.get(j).getIdProduit())) {
						newQtt = medStock.get(j).getQtt() - prQtt.get(i).getQttCommander();
						medStock.get(j).setQtt(newQtt);
						trouver = true;
					}
					j++;
				}
			}
			
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==vue.getTableProduit()) {
			vue.getBtnAjouter().setEnabled(true);
		}else if(e.getSource()==vue.getTableCommande()) {
			vue.getBtnSupprimerProduit().setEnabled(true);
		}else if(e.getSource()==vue.getTableListCommande()) {
			vue.getBtnAfficher().setEnabled(true);
			vue.getBtnSupprimerLaCommande().setEnabled(true);
			vue.getBtnServie().setEnabled(true);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
