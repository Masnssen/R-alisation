package controle.collaborateur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Vue.Commercial.ModifierMedecin;
import model.commercial.Medecin;


public class ModifierMedecinContro implements ActionListener{
	 DefaultTableModel modelfournisseur = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"idcollaborateur", "Nom", "Prenom","adresse","specialite"
				}
			);

	 ModifierMedecin vue ;
	JTable table;
	JButton btnModifier;
	JButton btnSupprimer;
	JScrollPane jScrollPane;
	JButton btnAjouter;
	
	public ModifierMedecinContro(ModifierMedecin vue,JTable table,JScrollPane jScrollPane,JButton btnModifier,JButton btnSupprimer,JButton btnAjouter) {
		this.vue = vue;
		this.table = table;
		this.btnModifier = btnModifier;
		this.btnSupprimer = btnSupprimer;
		this.btnAjouter = btnAjouter;
		this.jScrollPane = jScrollPane; 
 		this.vue.getBtnModifier().addActionListener(this);
		this.vue.getBtnAnnuler().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==vue.getBtnModifier()) {
			Medecin medecin =new Medecin(Integer.parseInt(vue.getTxtidCollaborateur().getText()),vue.getTxtnomcollaborateur().getText(),vue.getTxtprenomcollaborateur().getText(),
					vue.getTxtadresse().getText(),vue.getTxtspacialite().getText());
			medecin.modifier();
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
		 for (int i = 0; i <Medecin.listemedecin.size(); i++) {
				model.addRow(new Object[] {Medecin.listemedecin.get(i).getIdcollaborateur(),
						Medecin.listemedecin.get(i).getNomcollaborateur(),
						Medecin.listemedecin.get(i).getPrenomcollaborateur(),Medecin.listemedecin.get(i).getAdressemedecin(),
						Medecin.listemedecin.get(i).getSpecialite()});
			}
	}
}
