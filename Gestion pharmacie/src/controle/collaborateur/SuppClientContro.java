package controle.collaborateur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Vue.Commercial.SupprimerClient;
import model.commercial.Client;


public class SuppClientContro implements ActionListener{
	 DefaultTableModel modelclient = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"idcollaborateur", "Nom", "Prenom","age","numSecurité","maladieChronique"
				}
			);

	 SupprimerClient vue ;
	JTable table;
	JButton btnModifier;
	JButton btnSupprimer;
	JScrollPane jScrollPane;
	JButton btnAjouter;
	
	public SuppClientContro(SupprimerClient vue,JTable table,JScrollPane jScrollPane,JButton btnModifier,JButton btnSupprimer,JButton btnAjouter) {
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
			Client client =new Client(Integer.parseInt(vue.getTxtidCollaborateur().getText()));
			client.supprimer();
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
		table.setModel(modelclient);
		jScrollPane.setViewportView(table);
		 DefaultTableModel model = (DefaultTableModel) table.getModel();
		 int n = model.getRowCount();
		 for (int i=n-1 ; i>=0 ; --i) model.removeRow(i);
		 for (int i = 0; i <Client.listecclient.size(); i++) {
				model.addRow(new Object[] {Client.listecclient.get(i).getIdcollaborateur(),
						Client.listecclient.get(i).getNomcollaborateur(),
						Client.listecclient.get(i).getPrenomcollaborateur(),Client.listecclient.get(i).getAge(),
						Client.listecclient.get(i).getNumSecurité(),Client.listecclient.get(i).getMaladieChronique()});
			}
	}
}
