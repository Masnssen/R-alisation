package controle.collaborateur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Vue.Commercial.ModifierClient;
import model.commercial.Client;


public class ModifierClientContro implements ActionListener{
	 DefaultTableModel modelclient = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"idcollaborateur", "Nom", "Prenom","age","numSecurité","maladieChronique"
				}
			);

	ModifierClient vue ;
	JTable table;
	JButton btnModifier;
	JButton btnSupprimer;
	JScrollPane jScrollPane;
	JButton btnAjouter;
	
	public ModifierClientContro(ModifierClient vue,JTable table,JScrollPane jScrollPane,JButton btnModifier,JButton btnSupprimer,JButton btnAjouter) {
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
			Client client =new Client(Integer.parseInt(vue.getTxtidCollaborateur().getText()),vue.getTxtnomcollaborateur().getText(),vue.getTxtprenomcollaborateur().getText(),
					vue.getTxtage().getText(),vue.getTxtnumSecurite().getText(),
					vue.getTxtmaladiechro().getText());
			client.modifier();
			btnModifier.setEnabled(false);
			btnSupprimer.setEnabled(false);
			btnAjouter.setEnabled(true);
			vue.dispose();
			afficheClient();
		}else if(e.getSource()==vue.getBtnAnnuler()) {
			vue.dispose();
		}
	}
	public void afficheClient() {
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
