package controle.administrateur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Vue.administrateur.ModifierCompte;
import model.administrateur.Compte;


public class ModifierCompteContro implements ActionListener{

	 ModifierCompte vue ;
	JTable table;
	JButton btnModifier;
	JButton btnSupprimer;
	JScrollPane jScrollPane;
	JButton btnAjouter;
	
	public ModifierCompteContro(ModifierCompte vue,JTable table,JButton btnModifier,JButton btnSupprimer,JButton btnAjouter) {
		this.vue = vue;
		this.table = table;
		this.btnModifier = btnModifier;
		this.btnSupprimer = btnSupprimer;
		this.btnAjouter = btnAjouter;
 		this.vue.getBtnModifier().addActionListener(this);
		this.vue.getBtnAnnuler().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==vue.getBtnModifier()) {
			Compte compte =new Compte(Integer.parseInt(vue.getTxtidCompte().getText()),vue.getTxtnom().getText(),
					vue.getTxtprenom().getText(),vue.getComboBoxfonction().getSelectedItem().toString(),vue.getTxtUser().getText(),
					vue.getTxtPassword().getText());
			compte.modifier();
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
