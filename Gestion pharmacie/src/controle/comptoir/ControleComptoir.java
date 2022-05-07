package controle.comptoir;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import Vue.comtoir.GestionClient;
import Vue.comtoir.PanneauComptoir;
import model.commercial.Client;
import model.comptoir.MedicamentPrenscrit;
import model.comptoir.Ordonnance;
import model.pharmacien.MedicamentEnStock;

public class ControleComptoir implements ActionListener,MouseListener{
	
	private PanneauComptoir vue;
	
	
	private TableauProduitModel medModel;
	private TableauOrdonnanceModel ordonnance;
	private TableauListOrdonnanceModel listOrdonnance;
	
	
	public ControleComptoir(PanneauComptoir vue) {
		this.vue = vue;
		
		//Le tableau des produit 
		medModel = new TableauProduitModel("Medicament externe");
		vue.getTableProduit().setModel(medModel);
		vue.getTableProduit().revalidate();
		//Le tableau des produits a acheter 
		ordonnance = new TableauOrdonnanceModel("Ordonnance");
		vue.getTableOrdonnance().setModel(ordonnance);
		vue.getTableOrdonnance().revalidate();
		//Le tableau des listes des ordonnances
		listOrdonnance = new TableauListOrdonnanceModel();
		vue.getTableListeOrdonnance().setModel(listOrdonnance);
		vue.getTableListeOrdonnance().revalidate();
		vue.getTableListeOrdonnance().repaint();
		
		initInterface();
		initButton();
		
	}
	
	public void initInterface() {
		for (int i = 0; i < Client.listecclient.size(); i++) {
			vue.getComboBoxclient().addItem(Client.listecclient.get(i).nometprenom());
		}		
	}
	
	public void initButton() {
		
		vue.getBtnRechercher().addActionListener(this);
		vue.getBtnAjouter().addActionListener(this);
		vue.getBtnSupprimer().addActionListener(this);
		vue.getBtnServie().addActionListener(this);
		vue.getBtnAfficher().addActionListener(this);
		vue.getTableProduit().addMouseListener(this);
		vue.getBtnAjouterClient().addActionListener(this);
		vue.getTableOrdonnance().addMouseListener(this);
		vue.getTableListeOrdonnance().addMouseListener(this);
		vue.getPanel().addMouseListener(this);
		vue.getPanel_2().addMouseListener(this);
		vue.getBtnNvlOrdonance().addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==vue.getBtnNvlOrdonance()) {
			ordonnance.setOrd();
			vue.getTableOrdonnance().revalidate();
			vue.getTableOrdonnance().repaint();
			vue.getBtnServie().setEnabled(false);
			vue.getBtnNvlOrdonance().setEnabled(false);
		}
		if(e.getSource()==vue.getBtnAjouterClient()) {
			GestionClient frame = new GestionClient();
			ClientContro c = new ClientContro(frame,vue.getComboBoxclient());
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);	
			}
		if(e.getActionCommand().equals("Afficher")) {
			int index = vue.getTableListeOrdonnance().getSelectedRow();
			if(index > -1) {
				ordonnance.setOrd(Ordonnance.getListeOrdonnance().get(index).getListeMedicamentPrenscrit());
				vue.getTableOrdonnance().revalidate();
				vue.getTableOrdonnance().repaint();
				vue.getTextTotal().setText(ordonnance.getTotal());
				vue.getBtnAfficher().setEnabled(false);
				vue.getBtnNvlOrdonance().setEnabled(true);
			}
			
		}else if(e.getActionCommand().equals("Rechercher")) {
			medModel.recherche(vue.getTxtRecherche().getText());
			vue.getTableProduit().revalidate();
		}else if(e.getActionCommand().equals("Ajouter")) {
			int index = vue.getTableProduit().getSelectedRow();
			if(index > -1) {
				Object med;
				med = medModel.getProduit(index);
				if(MedicamentEnStock.getListeProduit().get(index).getQtt() < 1) {
					JOptionPane.showMessageDialog(null, "Quantite epuiser");
				}else {
					ordonnance.addProduit(transformerProduit((MedicamentEnStock)med), index);
					vue.getTableOrdonnance().repaint();
					vue.getTextTotal().setText(ordonnance.getTotal());	
					
					
					vue.getBtnAjouter().setEnabled(false);
					vue.getBtnServie().setEnabled(true);
					vue.getBtnNvlOrdonance().setEnabled(true);
				}
				
			}
		}else if(e.getActionCommand().equals("Supprimer")) {
			int index = vue.getTableOrdonnance().getSelectedRow();
			if(index > -1) {
				ordonnance.removeProduit(index);
				vue.getTextTotal().setText(ordonnance.getTotal());
				vue.getBtnSupprimer().setEnabled(false);
				if(ordonnance.getRowCount()==0) {
					vue.getBtnServie().setEnabled(false);
				}
			}
		}else if(e.getActionCommand().equals("Servie")) {
			boolean trouver;
			MedicamentEnStock med;
			MedicamentPrenscrit pren;
			int j = 0;
			for(int i = 0 ; i < ordonnance.getRowCount(); i++) {
				trouver = false;
				j = 0;
				pren = ordonnance.getMed(i);
				while(j < MedicamentEnStock.getListeProduit().size() && trouver == false) {
					med = MedicamentEnStock.getListeProduit().get(j);
					if(pren.getIdProduit().equals(med.getIdProduit())) {
						med.setQtt(med.getQtt() - pren.getQttDemander());
						trouver = true;
					}
					j++;
				}
			}
			
			Ordonnance ord = new Ordonnance();
			ord.setIdOrdonnance(Ordonnance.id);
			ord.setDateOrdonnance(LocalDate.now());
			ord.setClient(Client.listecclient.get(vue.getComboBoxclient().getSelectedIndex()));
			ord.setListeMedicamentPrenscrit(ordonnance.getMedicament());
			listOrdonnance.addOrdonnance(ord);
			vue.getTableListeOrdonnance().revalidate();
			vue.getTableListeOrdonnance().repaint();
			
			ordonnance.setOrd();
			vue.getTableOrdonnance().revalidate();
			vue.getTableProduit().revalidate();
			vue.getTableOrdonnance().repaint();
			vue.getTableProduit().repaint();
			
			vue.getTextTotal().setText(ordonnance.getTotal());
			vue.repaint();
			vue.getBtnServie().setEnabled(false);
			vue.getBtnNvlOrdonance().setEnabled(false);			
		}
	}
	
	public MedicamentPrenscrit transformerProduit(MedicamentEnStock med) {
		MedicamentPrenscrit medicament = new MedicamentPrenscrit();
		medicament.setIdProduit(med.getIdProduit());
		medicament.setNomProduit(med.getNomProduit());
		medicament.setCategorieProduit(med.getCategorieProduit());
		medicament.setPrix(med.getPrix());
		medicament.setQttDemander(1);
		
		return medicament;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==vue.getTableProduit()) {
			vue.getBtnAjouter().setEnabled(true);
		}else if(e.getSource()==vue.getTableOrdonnance()) {
			vue.getBtnSupprimer().setEnabled(true);
		}else if(e.getSource()==vue.getTableListeOrdonnance()) {
			vue.getBtnAfficher().setEnabled(true);
		}else if(e.getSource()==vue.getPanel()||e.getSource()==vue.getPanel_2()){
			vue.getBtnAjouter().setEnabled(false);
			vue.getBtnServie().setEnabled(false);
			vue.getBtnSupprimer().setEnabled(false);
			vue.getBtnAfficher().setEnabled(true);
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
