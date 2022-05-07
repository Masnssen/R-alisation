package controle.comptoir;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Vue.Commercial.ModifierClient;
import Vue.Commercial.SupprimerClient;
import Vue.Commercial.SupprimerFournisseur;
import model.commercial.Client;
import model.commercial.Fournisseur;


public class ModifierClientContro implements ActionListener{
	 

	ModifierClient vue ;
	JTable table;
	JButton btnModifier;
	JButton btnSupprimer;
	JButton btnAjouter;
	JComboBox combo;
	
	public ModifierClientContro(ModifierClient vue,JTable table,JButton btnModifier,JButton btnSupprimer,JButton btnAjouter,JComboBox combo) {
		this.vue = vue;
		this.table = table;
		this.combo = combo;
		this.btnModifier = btnModifier;
		this.btnSupprimer = btnSupprimer;
		this.btnAjouter = btnAjouter;
 		this.vue.getBtnModifier().addActionListener(this);
		this.vue.getBtnAnnuler().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==vue.getBtnModifier()) {
			int ligne = table.getSelectedRow();
			combo.removeItem(table.getModel().getValueAt(ligne,1).toString()+" "+table.getModel().getValueAt(ligne,2).toString());
			Client client =new Client(Integer.parseInt(vue.getTxtidCollaborateur().getText()),vue.getTxtnomcollaborateur().getText(),vue.getTxtprenomcollaborateur().getText(),
					vue.getTxtage().getText(), vue.getTxtnumSecurite().getText(),
					vue.getTxtmaladiechro().getText());
			client.modifier();
		    	 combo.addItem(client.nometprenom());
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
