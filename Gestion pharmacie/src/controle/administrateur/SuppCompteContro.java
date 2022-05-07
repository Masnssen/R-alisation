package controle.administrateur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Vue.administrateur.SupprimerCompte;
import model.administrateur.Compte;


public class SuppCompteContro implements ActionListener{

	SupprimerCompte vue ;
	JTable table;
	JButton btnModifier;
	JButton btnSupprimer;
	JButton btnAjouter;
	
	public SuppCompteContro(SupprimerCompte vue,JTable table,JButton btnModifier,JButton btnSupprimer,JButton btnAjouter) {
		this.vue = vue;
		this.table = table;
		this.btnModifier = btnModifier;
		this.btnSupprimer = btnSupprimer;
		this.btnAjouter = btnAjouter;
 		this.vue.getBtnSupprimer().addActionListener(this);
		this.vue.getBtnAnnuler().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==vue.getBtnSupprimer()) {
			Compte compte =new Compte(Integer.parseInt(vue.getTxtidCompte().getText()));
			compte.supprimer();
			btnModifier.setEnabled(false);
			btnSupprimer.setEnabled(false);
			btnAjouter.setEnabled(true);
			vue.dispose();
			afficherCompte();
		}else if(e.getSource()==vue.getBtnAnnuler()) {
			vue.dispose();
		}
	}
	public void afficherCompte() {
		 DefaultTableModel model = (DefaultTableModel) table.getModel();
		 int n = model.getRowCount();
		 for (int i=n-1 ; i>=0 ; --i) model.removeRow(i);
		 for (int i = 0; i < Compte.listecompte.size(); i++) {
			 model.addRow(new Object[] {Compte.listecompte.get(i).getIdcompte(),Compte.listecompte.get(i).getNom(),Compte.listecompte.get(i).getPrenom(),
					 Compte.listecompte.get(i).getFonction(),Compte.listecompte.get(i).getUser(),
					 Compte.listecompte.get(i).getPassword()});
			 
	}
}
}
