package controle.commercial;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Vue.Commercial.PanneauCommercial;
import controle.comptoir.TableauListCommandeModel;
import controle.comptoir.TableauOrdonnanceModel;
import controle.comptoir.TableauProduitModel;
import model.commercial.CommandeAchat;
import model.commercial.Fournisseur;
import model.comptoir.ProduitQtt;
import model.pharmacien.MedicamentEnStock;
import model.pharmacien.ProduitPharmaceutique;

public class CommercialControleur implements ActionListener,MouseListener{
	
	private PanneauCommercial vue;
	private TableauProduitModel med;
	private TableauProduitModel prod;
	private TableauOrdonnanceModel commande;
	private TableauListCommandeModel listCommande;
	private String categorie;
	
	
	
	public CommercialControleur(PanneauCommercial vue) {
		this.vue = vue;
	
		initInterface();
		initButton();
	}
	
	public void initInterface() {
		prod = new TableauProduitModel("Produit pharmaceutique");	
		med = new TableauProduitModel("Medicament externe");
		
		vue.getTableProduit().setModel(med);
		vue.getTableProduit().revalidate();
		categorie = "Medicament externe";
		
		commande = new TableauOrdonnanceModel("Commande");
		vue.getTableCom().setModel(commande);
		vue.getTableCom().revalidate();
		vue.getTableCom().repaint();
		
		listCommande = new TableauListCommandeModel("Commande achat");
		vue.getTableComAchat().setModel(listCommande);
		vue.getTableComAchat().revalidate();
		vue.getTableComAchat().repaint();
		
		for(int i = 0; i < Fournisseur.listefournisseur.size(); i++) {
			vue.getComboBox().addItem(Fournisseur.listefournisseur.get(i).getNomcollaborateur());

		}
		vue.getComboBox().revalidate();
	}
	
	
	public void initButton() {
		
		vue.getBtnMedicamentExterne().addActionListener(this);
		vue.getBtnProduitPharmaceutique().addActionListener(this);
		
		vue.getBtnAjouterLeProduit().addActionListener(this);
		
		vue.getBtnSupprimerProduit().addActionListener(this);
		
		vue.getBtnRechercher().addActionListener(this);
		
		vue.getBtnAjouterLaCommande().addActionListener(this);
		
		vue.getBtnAfficher().addActionListener(this);
		vue.getBtnSupprimerCom().addActionListener(this);
		vue.getBtnRecu().addActionListener(this);
		
		vue.getTableProduit().addMouseListener(this);
		vue.getTableCom().addMouseListener(this);
		vue.getTableComAchat().addMouseListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Ajouter le produit")) {
			int index = vue.getTableProduit().getSelectedRow();
			
			if(index > -1) {
				commande.addProduit(ProduitQtt.transformer(index, categorie), index, "");
				vue.getTableCom().revalidate();
				vue.getTableCom().repaint();
				
				vue.getTextField().setText(commande.getTotal());
				vue.getBtnAjouterLeProduit().setEnabled(false);
				vue.getBtnAjouterLaCommande().setEnabled(true);
			}
		
		}else if(e.getActionCommand().equals("Supprimer produit")) {
			int index = vue.getTableCom().getSelectedRow();
			if(index > -1) {
				commande.removeProduit(index);
				vue.getTableCom().revalidate();
				
				vue.getTextField().setText(commande.getTotal());
				
				
				vue.getBtnSupprimerProduit().setEnabled(false);
				if(commande.getRowCount()==0) {
					vue.getBtnAjouterLaCommande().setEnabled(false);
				}
			}
				
		}else if(e.getActionCommand().equals("Rechercher")){
			med.recherche(vue.getTxtProduitARechercher().getText());
			prod.recherche(vue.getTxtProduitARechercher().getText());
			vue.getTableProduit().revalidate();
			
		}else if(e.getActionCommand().equals("Return")) {
		
			
		}else if(e.getActionCommand().equals("Produit pharmaceutique")) {
			categorie = "Produit pharmaceutique";
			vue.getTableProduit().setModel(prod);
			vue.getTableProduit().revalidate();
			
		}else if(e.getActionCommand().equals("Medicament externe")) {
			categorie = "Medicament externe";
			vue.getTableProduit().setModel(med);
			vue.getTableProduit().revalidate();
			
		}else if(e.getActionCommand().equals("Ajouter la commande")) {
			CommandeAchat achat = new CommandeAchat();
			if(vue.getTextId().getText().trim().equals("")) {
				achat.setIdCommande(String.valueOf(CommandeAchat.id));
			}
			achat.setDateCommande(LocalDate.now());
			achat.setEtat("En attente");
			achat.setListeProduit(commande.getCommande());
			achat.setFornisseur(Fournisseur.getFournisseur((String)vue.getComboBox().getSelectedItem()));
			listCommande.addCommande(achat);
			
			vue.getTableComAchat().revalidate();
			
			commande.setCommande(new ArrayList<ProduitQtt>());
			vue.getTableCom().revalidate();
			
			vue.getTextField().setText(commande.getTotal());
			vue.getBtnAjouterLaCommande().setEnabled(false);
			vue.getTextId().setText("");
			
		}else if(e.getActionCommand().equals("Afficher")) {
			int index = vue.getTableComAchat().getSelectedRow();
			if(index > -1) {
				commande.setCommande(CommandeAchat.getListecommande().get(index).getListeProduit());
				vue.getTableCom().revalidate();
				vue.getTextId().setText(CommandeAchat.getListecommande().get(index).getIdCommande());
				
				vue.getTextField().setText(commande.getTotal());
				vue.getBtnAfficher().setEnabled(false);
				vue.getBtnSupprimerCom().setEnabled(false);
				vue.getBtnRecu().setEnabled(false);
			}
			
		}else if(e.getActionCommand().equals("Supprimer")) {
			int index = vue.getTableComAchat().getSelectedRow();
			
			if(vue.getTableComAchat().getModel().getValueAt(index,0).toString().equals(vue.getTextId().getText())) {
				commande.setCommande(new ArrayList<ProduitQtt>());
				vue.getTableCom().revalidate();
				vue.getTableCom().repaint();
				}
			
			if(index > -1) {
				CommandeAchat.getListecommande().remove(index);
				vue.getTableComAchat().revalidate();
				vue.getBtnAfficher().setEnabled(false);
				vue.getBtnSupprimerCom().setEnabled(false);
				vue.getBtnRecu().setEnabled(false);
				vue.getTextId().setText("");
			}			
		}else if(e.getActionCommand().equals("Recu")) {
			int index = vue.getTableComAchat().getSelectedRow();
			if(index > -1) {
				if(CommandeAchat.getListecommande().get(index).getEtat().equals("En attente")) {
					recu(index);
					CommandeAchat.getListecommande().get(index).setEtat("Recu");
					vue.getTableComAchat().revalidate();
					vue.getTableComAchat().repaint();
					
					vue.getTableProduit().revalidate();
					vue.getTableProduit().repaint();
					vue.getBtnAfficher().setEnabled(false);
					vue.getBtnSupprimerCom().setEnabled(false);
					vue.getBtnRecu().setEnabled(false);
				}
				
				
			}
			
		}
	}
	
	
	
	
	
	public void recu(int index) {
		ArrayList<ProduitQtt> prQtt = CommandeAchat.getListecommande().get(index).getListeProduit();
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
						newQtt = prPhar.get(j).getQtt() + prQtt.get(i).getQttCommander();
						prPhar.get(j).setQtt(newQtt);
						trouver = true;
					}
					j++;
				}
			}else {
				while(j < medStock.size() && trouver == false) {
					if(prQtt.get(i).getProduit().getIdProduit().equals(medStock.get(j).getIdProduit())) {
						newQtt = medStock.get(j).getQtt() + prQtt.get(i).getQttCommander();
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
			vue.getBtnAjouterLeProduit().setEnabled(true);
		}else if(e.getSource()==vue.getTableCom()) {
			vue.getBtnSupprimerProduit().setEnabled(true);
		}else if(e.getSource()==vue.getTableComAchat()) {
			int ligne = vue.getTableComAchat().getSelectedRow();
			if(vue.getTableComAchat().getModel().getValueAt(ligne,3).toString().equals("Recu")) {
				vue.getBtnAfficher().setEnabled(true);
				vue.getBtnRecu().setEnabled(false);
				vue.getBtnSupprimerCom().setEnabled(false);
			}else {
			vue.getBtnAfficher().setEnabled(true);
			vue.getBtnSupprimerCom().setEnabled(true);
			vue.getBtnRecu().setEnabled(true);
		}
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
