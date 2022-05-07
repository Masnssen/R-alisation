package controle.collaborateur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Vue.Commercial.SupprimerFournisseur;
import model.commercial.Fournisseur;


public class SuppFournisseurContro implements ActionListener{
	 DefaultTableModel modelfournisseur = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"idcollaborateur", "Nom", "Prenom"
				}
			);

	SupprimerFournisseur vue ;
	JTable table;
	JButton btnModifier;
	JButton btnSupprimer;
	JScrollPane jScrollPane;
	JButton btnAjouter;
	
	public SuppFournisseurContro(SupprimerFournisseur vue,JTable table,JScrollPane jScrollPane,JButton btnModifier,JButton btnSupprimer,JButton btnAjouter) {
		this.vue = vue;
		this.table = table;
		this.btnModifier = btnModifier;
		this.btnSupprimer = btnSupprimer;
		this.btnAjouter = btnAjouter;
		this.jScrollPane = jScrollPane; 
 		this.vue.getBtnSupprimer().addActionListener(this);
		this.vue.getBtnAnnuler().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==vue.getBtnSupprimer()) {
			Fournisseur fournisseur =new Fournisseur(Integer.parseInt(vue.getLblIdcollaborateur().getText()));
			fournisseur.supprimer();
			btnModifier.setEnabled(false);
			btnSupprimer.setEnabled(false);
			btnAjouter.setEnabled(true);
			vue.dispose();
			affichefournisseur();
		}else if(e.getSource()==vue.getBtnAnnuler()) {
			vue.dispose();
		}
	}
	public void affichefournisseur() {
		table.setModel(modelfournisseur);
		jScrollPane.setViewportView(table);
		 DefaultTableModel model = (DefaultTableModel) table.getModel();
		 int n = model.getRowCount();
		 for (int i=n-1 ; i>=0 ; --i) model.removeRow(i);
		 for (int i = 0; i <Fournisseur.listefournisseur.size(); i++) {
				model.addRow(new Object[] {Fournisseur.listefournisseur.get(i).getIdcollaborateur(),
						Fournisseur.listefournisseur.get(i).getNomcollaborateur(),
						Fournisseur.listefournisseur.get(i).getPrenomcollaborateur()});
			}
	}
}
