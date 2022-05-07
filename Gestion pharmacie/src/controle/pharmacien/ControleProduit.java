package controle.pharmacien;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Vue.Pharmacien.Formulaire;
import Vue.Pharmacien.PanneauProduit;
import model.pharmacien.MatierePremiere;
import model.pharmacien.MedicamentEnStock;
import model.pharmacien.MedicamentInterne;
import model.pharmacien.Produit;
import model.pharmacien.ProduitPharmaceutique;
import model.pharmacien.TypeMedicament;

public class ControleProduit {
	
	
	private PanneauProduit vue;
	private Formulaire formulaire = new Formulaire();
	 //indique quelle type de produit est afficher
	private String categorie = new String("Produit pharmaceutique");
	
	//Les models du tableau 
	MedicamentInterneModel medInterne;
	MedicamentExterneModel medExterne;
	ProduitPharmaceutiqueModel produit;
	
	//Produit pharmaceutique actuel
	Produit produitActuel;
	
	
	public ControleProduit(PanneauProduit vue) {
		this.vue = vue;
		medInterne = new MedicamentInterneModel();
		medExterne = new MedicamentExterneModel();
		produit = new ProduitPharmaceutiqueModel();
		initInterface();
		//On initialise les boutons et on diffinie leur listener
		medInterne = new MedicamentInterneModel();
		initButton();	
		
		//initialiser les comboBox
		////combo type 
		for(int i = 0; i < TypeMedicament.getListType().size(); i++) {
			formulaire.getComb_typeProduit().addItem(TypeMedicament.getListType().get(i).getLabel());
		}
		//les combo matiere premiere
		for(int i = 0; i < MatierePremiere.getListeMatiere().size(); i++) {
			formulaire.getComb_matierePrem1().addItem(MatierePremiere.getListeMatiere().get(i).getNomMatiere());
			formulaire.getComb_matierePrem2().addItem(MatierePremiere.getListeMatiere().get(i).getNomMatiere());
			formulaire.getComb_matierePrem3().addItem(MatierePremiere.getListeMatiere().get(i).getNomMatiere());
			formulaire.getComb_matierePrem4().addItem(MatierePremiere.getListeMatiere().get(i).getNomMatiere());
		}
		
	}
	
	//Initialisation de l'interface
	public void initInterface() {
		//Medicament externe
		vue.setTableMedExternen(new JTable(medExterne));
		vue.getTableMedExternen().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		vue.getTableMedExternen().getSelectionModel().addListSelectionListener(new TableListener("Medicament externe", vue));
	
		vue.setTableMedInterne(new JTable(medInterne));
		vue.getTableMedInterne().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		vue.getTableMedInterne().getSelectionModel().addListSelectionListener(new TableListener("Medicament interne", vue));
		
		vue.setTableProduit(new JTable(produit));
		vue.getTableProduit().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		vue.getTableProduit().getSelectionModel().addListSelectionListener(new TableListener("Produit pharmaceutique", vue));
		
		vue.getScrollPane().setViewportView(vue.getTableProduit());
		
		vue.getPanel_1().removeAll();
		vue.getPanel_1().add(formulaire);
		
	}
	//Instantiation des button 
	public void initButton() {
		
		
		vue.getBtnAjouter().addActionListener(new ButtonListener());
		vue.getBtnModifier().addActionListener(new ButtonListener());
		vue.getBtnSupprimer().addActionListener(new ButtonListener());
		vue.getBtnNouveauProduit().addActionListener(new ButtonListener());
		
		vue.getBtnProduitPharmaceutique().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				vue.getScrollPane().setViewportView(vue.getTableProduit());
				categorie = "Produit pharmaceutique";
				formulaire.getComb_categorie().setSelectedItem("Produit pharmaceutique");
				formulaire.getComb_typeProduit().setEnabled(false);
				formulaire.getComb_matierePrem1().setEnabled(false);
				formulaire.getComb_matierePrem2().setEnabled(false);
				formulaire.getComb_matierePrem3().setEnabled(false);
				formulaire.getComb_matierePrem4().setEnabled(false);
				
				vue.getBtnProduitPharmaceutique().setEnabled(false);
				vue.getBtnMedicamentExterne().setEnabled(true);
				vue.getBtnMedicamentInterne().setEnabled(true);
				vue.getBtnAjouter().setEnabled(true);
				vue.getBtnModifier().setEnabled(false);
				vue.getBtnSupprimer().setEnabled(false);
				
				formulaire.getIdProduit().setText("");
				formulaire.getNomProduit().setText("");
			}
		});
		
		
		vue.getBtnMedicamentExterne().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				vue.getScrollPane().setViewportView(vue.getTableMedExternen());
				categorie = "Medicament externe";
				formulaire.getComb_categorie().setSelectedItem("Medicament externe");
				formulaire.getComb_typeProduit().setEnabled(true);
				formulaire.getComb_matierePrem1().setEnabled(false);
				formulaire.getComb_matierePrem2().setEnabled(false);
				formulaire.getComb_matierePrem3().setEnabled(false);
				formulaire.getComb_matierePrem4().setEnabled(false);
				
				vue.getBtnProduitPharmaceutique().setEnabled(true);
				vue.getBtnMedicamentExterne().setEnabled(false);
				vue.getBtnMedicamentInterne().setEnabled(true);
				vue.getBtnAjouter().setEnabled(true);
				vue.getBtnModifier().setEnabled(false);
				vue.getBtnSupprimer().setEnabled(false);
				
				formulaire.getIdProduit().setText("");
				formulaire.getNomProduit().setText("");
			}
		});
		
	
		vue.getBtnMedicamentInterne().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				vue.getScrollPane().setViewportView(vue.getTableMedInterne());
				categorie = "Medicament interne";
				formulaire.getComb_categorie().setSelectedItem("Medicament interne");
				formulaire.getComb_typeProduit().setEnabled(true);
				formulaire.getComb_matierePrem1().setEnabled(true);
				formulaire.getComb_matierePrem2().setEnabled(true);
				formulaire.getComb_matierePrem3().setEnabled(true);
				formulaire.getComb_matierePrem4().setEnabled(true);
				
				vue.getBtnProduitPharmaceutique().setEnabled(true);
				vue.getBtnMedicamentExterne().setEnabled(true);
				vue.getBtnMedicamentInterne().setEnabled(false);
				vue.getBtnAjouter().setEnabled(true);
				vue.getBtnModifier().setEnabled(false);
				vue.getBtnSupprimer().setEnabled(false);
				
				formulaire.getIdProduit().setText("");
				formulaire.getNomProduit().setText("");
				
			}
		});
		
		
		vue.getBtnAjouter().setEnabled(true);
		vue.getBtnModifier().setEnabled(false);
		vue.getBtnSupprimer().setEnabled(false);
		vue.getBtnProduitPharmaceutique().setEnabled(false);
		
	}
	
	
	public int getNumItem(JComboBox combo, String st) {
	
		for(int i = 0; i < combo.getItemCount(); i++) {
			if(st.equals(combo.getItemAt(i))) {
				return i;
			}
		}
		return -1;
		
	}
	
	/*clic sur les bouton*/
	
	
	/*Le modele du tableau des produits*/
	
	public class TableListener implements ListSelectionListener{
		
		private String categorie;
		private PanneauProduit pan;
		
		public TableListener(String categorie, PanneauProduit pan) {
			this.categorie = categorie;
			this.pan = pan;
		}
		
		public void valueChanged(ListSelectionEvent e) {
			if(!e.getValueIsAdjusting()) {
				int index;
				vue.getBtnAjouter().setEnabled(false);
				vue.getBtnModifier().setEnabled(true);
				vue.getBtnSupprimer().setEnabled(true);
				if(categorie.equals("Produit pharmaceutique")) {
					
					index = vue.getTableProduit().getSelectedRow();
					formulaire.getIdProduit().setText((String)produit.getValueAt(index, 0));
					formulaire.getNomProduit().setText((String)produit.getValueAt(index, 1));
					formulaire.getComb_categorie().setSelectedIndex(0);
					
					
				}else if(categorie.equals("Medicament externe")) {
					index = vue.getTableMedExternen().getSelectedRow();
					formulaire.getIdProduit().setText((String)medExterne.getValueAt(index, 0));
					formulaire.getNomProduit().setText((String)medExterne.getValueAt(index, 1));
					formulaire.getComb_categorie().setSelectedIndex(1);
					formulaire.getComb_typeProduit().setSelectedIndex(getNumItem(formulaire.getComb_typeProduit(),(String)medExterne.getValueAt(index, 3)));
					System.out.print(getNumItem(formulaire.getComb_typeProduit(),(String)medExterne.getValueAt(index, 3)));
				}else {
					index = vue.getTableMedInterne().getSelectedRow();
					formulaire.getIdProduit().setText((String)medInterne.getValueAt(index, 0));
					formulaire.getNomProduit().setText((String)medInterne.getValueAt(index, 1));
					formulaire.getComb_categorie().setSelectedIndex(2);
					formulaire.getComb_typeProduit().setSelectedIndex(getNumItem(formulaire.getComb_typeProduit(),(String)medInterne.getValueAt(index, 3)));
					
					formulaire.getComb_matierePrem1().setSelectedIndex(getNumItem(formulaire.getComb_matierePrem1(),(String)medInterne.getValueAt(index, 4)));
					formulaire.getComb_matierePrem2().setSelectedIndex(getNumItem(formulaire.getComb_matierePrem2(),(String)medInterne.getValueAt(index, 5)));
					formulaire.getComb_matierePrem3().setSelectedIndex(getNumItem(formulaire.getComb_matierePrem3(),(String)medInterne.getValueAt(index, 6)));
					formulaire.getComb_matierePrem4().setSelectedIndex(getNumItem(formulaire.getComb_matierePrem4(),(String)medInterne.getValueAt(index, 7)));
					
				}
			}
		}
	}
	
	
	public class ButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("Ajouter")) {
				if(formulaire.getIdProduit().getText().trim().equals("")) {
					
				}else {
					ajouter();
					formulaire.getIdProduit().setText("");
					formulaire.getNomProduit().setText("");
				}
				
			}else if(e.getActionCommand().equals("Modifier")) {
				if(formulaire.getIdProduit().getText().trim().equals("")) {
					
				}else {
					modifier();
					formulaire.getIdProduit().setText("");
					formulaire.getNomProduit().setText("");
					vue.getBtnAjouter().setEnabled(true);
					vue.getBtnModifier().setEnabled(false);
					vue.getBtnSupprimer().setEnabled(false);
				
				}
				
			}else if(e.getActionCommand().equals("Supprimer")){
				supprimer();
				formulaire.getIdProduit().setText("");
				formulaire.getNomProduit().setText("");
				vue.getBtnAjouter().setEnabled(true);
				vue.getBtnModifier().setEnabled(false);
				vue.getBtnSupprimer().setEnabled(false);
			}else {
				formulaire.getIdProduit().setText("");
				formulaire.getNomProduit().setText("");
				vue.getBtnAjouter().setEnabled(true);
				vue.getBtnModifier().setEnabled(false);
				vue.getBtnSupprimer().setEnabled(false);
			}
		}
		
		public void ajouter() {
			String cat = formulaire.getComb_categorie().getSelectedItem().toString();
			if(cat.equals("Produit pharmaceutique")) {
				ProduitPharmaceutique pr = new ProduitPharmaceutique();
				pr.setIdProduit(formulaire.getIdProduit().getText());
				pr.setNomProduit(formulaire.getNomProduit().getText());
				pr.setCategorieProduit(formulaire.getComb_categorie().getSelectedItem().toString());
				ProduitPharmaceutique.getListeProduit().add(pr);
				vue.getTableProduit().revalidate();
				//vue.getTableProduit().repaint();
			}else if(cat.equals("Medicament externe")) {
				MedicamentEnStock pr = new MedicamentEnStock();
				pr.setIdProduit(formulaire.getIdProduit().getText());
				pr.setNomProduit(formulaire.getNomProduit().getText());
				pr.setCategorieProduit(formulaire.getComb_categorie().getSelectedItem().toString());
				pr.setTypeMedicament(formulaire.getComb_typeProduit().getSelectedItem().toString());
				MedicamentEnStock.getListeProduit().add(pr);
				vue.getTableMedExternen().revalidate();
			}else {
				MedicamentInterne pr = new MedicamentInterne();
				pr.setIdProduit(formulaire.getIdProduit().getText());
				pr.setNomProduit(formulaire.getNomProduit().getText());
				pr.setCategorieProduit(formulaire.getComb_categorie().getSelectedItem().toString());
				pr.setTypeMedicament(formulaire.getComb_typeProduit().getSelectedItem().toString());
				
				pr.setListeMatierePremiere(formulaire.getComb_matierePrem1().getSelectedItem().toString(), 0);
				pr.setListeMatierePremiere(formulaire.getComb_matierePrem2().getSelectedItem().toString(), 1);
				pr.setListeMatierePremiere(formulaire.getComb_matierePrem3().getSelectedItem().toString(), 2);
				pr.setListeMatierePremiere(formulaire.getComb_matierePrem4().getSelectedItem().toString(), 3);
				
				MedicamentInterne.getListeProduit().add(pr);
				
				vue.getTableMedInterne().revalidate();
				
			}
		}
		
		public void modifier() {
			int index;
			Produit pr;
			if(categorie.equals("Produit pharmaceutique")) {
				index = vue.getTableProduit().getSelectedRow();
				if(index > -1) {
					pr = new ProduitPharmaceutique();
					pr.setIdProduit(formulaire.getIdProduit().getText());
					pr.setNomProduit(formulaire.getNomProduit().getText());
					pr.setCategorieProduit(formulaire.getComb_categorie().getSelectedItem().toString());
					ProduitPharmaceutique.getListeProduit().set(index, (ProduitPharmaceutique)pr);
					vue.getTableProduit().repaint();
				}
				
			}else if(categorie.equals("Medicament externe")) {
				index = vue.getTableMedExternen().getSelectedRow();
				if(index > -1) {
					pr = new MedicamentEnStock();
					pr.setIdProduit(formulaire.getIdProduit().getText());
					pr.setNomProduit(formulaire.getNomProduit().getText());
					pr.setCategorieProduit(formulaire.getComb_categorie().getSelectedItem().toString());
					((MedicamentEnStock)pr).setTypeMedicament(formulaire.getComb_typeProduit().getSelectedItem().toString());
					MedicamentEnStock.getListeProduit().set(index, (MedicamentEnStock)pr);
					vue.getTableMedExternen().repaint();
				}
			}else {
				index = vue.getTableMedInterne().getSelectedRow();
				if(index > -1) {
					pr = new MedicamentInterne();
					pr.setIdProduit(formulaire.getIdProduit().getText());
					pr.setNomProduit(formulaire.getNomProduit().getText());
					pr.setCategorieProduit(formulaire.getComb_categorie().getSelectedItem().toString());
					//Type produit
					((MedicamentInterne)pr).setTypeMedicament(formulaire.getComb_typeProduit().getSelectedItem().toString());
					//Matiere premiere
					((MedicamentInterne)pr).setListeMatierePremiere(formulaire.getComb_matierePrem1().getSelectedItem().toString(), 0);
					((MedicamentInterne)pr).setListeMatierePremiere(formulaire.getComb_matierePrem2().getSelectedItem().toString(), 1);
					((MedicamentInterne)pr).setListeMatierePremiere(formulaire.getComb_matierePrem3().getSelectedItem().toString(), 2);
					((MedicamentInterne)pr).setListeMatierePremiere(formulaire.getComb_matierePrem4().getSelectedItem().toString(), 3);
					MedicamentInterne.getListeProduit().set(index, (MedicamentInterne)pr);
					vue.getTableMedInterne().repaint();
				}
			}
		}
		
		public void supprimer() {
			int index;
			if(categorie.equals("Produit pharmaceutique")) {
				index = vue.getTableProduit().getSelectedRow();
				if(index > -1) {
					ProduitPharmaceutique.getListeProduit().remove(index);
					vue.getTableProduit().repaint();
				}
				
			}else if(categorie.equals("Medicament externe")) {
				index = vue.getTableMedExternen().getSelectedRow();
				if(index > -1) {
					MedicamentEnStock.getListeProduit().remove(index);
					vue.getTableMedExternen().repaint();
				}
				
				
			}else {
				index = vue.getTableMedInterne().getSelectedRow();
				if(index > -1) {
					MedicamentInterne.getListeProduit().remove(index);
					vue.getTableMedInterne().repaint();
				}
				
			}
		}
	}


			
}


