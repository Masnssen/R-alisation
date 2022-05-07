package controle.comptoir;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Vue.Principal;
import Vue.Commercial.GestionCollaborateur;
import Vue.Commercial.ModifierClient;
import Vue.Commercial.SupprimerClient;
import Vue.comtoir.GestionClient;
import Vue.comtoir.PanneauComptoir;
import model.commercial.Client;
import model.commercial.Client;

public class ClientContro implements ActionListener ,MouseListener{
	
     JComboBox combo ;
     GestionClient vue;
	
	public ClientContro(GestionClient vue, JComboBox combo) {
		this.combo = combo;
		this.vue=vue;
		vue.getBtnajouterclient().addActionListener(this);
		vue.getBtnmodifierclient().addActionListener(this);
		vue.getBtnsupprimerclient().addActionListener(this);
		vue.getTable().addMouseListener(this);
		vue.getContentPane().addMouseListener(this);
		afficheClient();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==vue.getBtnajouterclient()) {
			if(vue.getTxtnom().getText().equals("")||vue.getTxtprenom().getText().equals("")||
					vue.getTxtage().getText().equals("") ||
					vue.getTxtnumsec().getText().equals("")){
				JOptionPane.showMessageDialog(null, "Verefier que tout les champs sont bien remplis");
					}else {
			Client client = new Client(vue.getTxtnom().getText(),vue.getTxtprenom().getText(),
					vue.getTxtage().getText(),vue.getTxtnumsec().getText(),
					vue.getTxtmaladiechro().getText());
			client.ajouter();
				combo.addItem(client.nometprenom());
			JOptionPane.showMessageDialog(null, "Ajouter avec succes");
			afficheClient();
			vue.getTxtnom().setText("");vue.getTxtprenom().setText("");vue.getTxtprenom().setText("");
			vue.getTxtage().setText("");vue.getTxtnumsec().setText("");vue.getTxtmaladiechro().setText("");
			    
			     
		}}else if(e.getSource()==vue.getBtnmodifierclient()) {
			ModifierClient vue1 = new ModifierClient();
			ModifierClientContro c = new ModifierClientContro(vue1,vue.getTable(),vue.getBtnmodifierclient(),vue.getBtnsupprimerclient(),vue.getBtnajouterclient(),combo);
			vue1.setVisible(true);
  			int ligne = vue.getTable().getSelectedRow();
  			vue1.getTxtidCollaborateur().setText(vue.getTable().getModel().getValueAt(ligne,0).toString());
			vue1.getTxtnomcollaborateur().setText(vue.getTable().getModel().getValueAt(ligne,1).toString());
			vue1.getTxtprenomcollaborateur().setText(vue.getTable().getModel().getValueAt(ligne,2).toString());
			vue1.getTxtage().setText(vue.getTable().getModel().getValueAt(ligne,3).toString());
			vue1.getTxtnumSecurite().setText(vue.getTable().getModel().getValueAt(ligne,4).toString());
			vue1.getTxtmaladiechro().setText(vue.getTable().getModel().getValueAt(ligne,5).toString());
		}else if(e.getSource()==vue.getBtnsupprimerclient()) {
			SupprimerClient vue1 = new SupprimerClient();
			SuppClientContro c = new SuppClientContro(vue1,vue.getTable(),vue.getBtnmodifierclient(),vue.getBtnsupprimerclient(),vue.getBtnajouterclient(),combo);
			vue1.setVisible(true);
  			int ligne = vue.getTable().getSelectedRow();
  			vue1.getTxtidCollaborateur().setText(vue.getTable().getModel().getValueAt(ligne,0).toString());
			vue1.getTxtnom().setText(vue.getTable().getModel().getValueAt(ligne,1).toString());
			vue1.getTxtprenom().setText(vue.getTable().getModel().getValueAt(ligne,2).toString());
			vue1.getTxtage().setText(vue.getTable().getModel().getValueAt(ligne,3).toString());
			vue1.getTxtnumSecurite().setText(vue.getTable().getModel().getValueAt(ligne,4).toString());
			vue1.getTxtmaladiechro().setText(vue.getTable().getModel().getValueAt(ligne,5).toString());
		}
	}
	private void afficheClient() {
		 DefaultTableModel model = (DefaultTableModel) vue.getTable().getModel();
		 int n = model.getRowCount();
		 for (int i=n-1 ; i>=0 ; --i) model.removeRow(i);
		 for (int i = 0; i <Client.listecclient.size(); i++) {
				model.addRow(new Object[] {Client.listecclient.get(i).getIdcollaborateur(),
						Client.listecclient.get(i).getNomcollaborateur(),
						Client.listecclient.get(i).getPrenomcollaborateur(),Client.listecclient.get(i).getAge(),
						Client.listecclient.get(i).getNumSecurité(),Client.listecclient.get(i).getMaladieChronique()});
			}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==vue.getTable()) {
			vue.getBtnsupprimerclient().setEnabled(true);
			vue.getBtnmodifierclient().setEnabled(true);
			vue.getBtnajouterclient().setEnabled(false);
		}else {
			vue.getBtnsupprimerclient().setEnabled(false);
			vue.getBtnmodifierclient().setEnabled(false);
			vue.getBtnajouterclient().setEnabled(true);
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
