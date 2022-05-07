package controle.collaborateur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Vue.Commercial.GestionCollaborateur;
import Vue.Commercial.ModifierClient;
import Vue.Commercial.ModifierFournisseur;
import Vue.Commercial.ModifierMedecin;
import Vue.Commercial.SupprimerClient;
import Vue.Commercial.SupprimerFournisseur;
import Vue.Commercial.SupprimerMedecin;
import model.commercial.Client;
import model.commercial.Fournisseur;
import model.commercial.Medecin;

public class collaborateurControle implements ActionListener,MouseListener {

	 GestionCollaborateur vue ;
	 DefaultTableModel modelmedecin = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"idcollaborateur", "Nom", "Prenom","adresse","specialite"
					}
			);
	 DefaultTableModel modelfournisseur = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"idcollaborateur", "Nom", "Prenom"
				}
			);
	 DefaultTableModel modelclient = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"idcollaborateur", "Nom", "Prenom","age","numSecurité","maladieChronique"
				}
			);
	
	public collaborateurControle(GestionCollaborateur vue) {
		this.vue = vue;
		this.vue.getBtnajoutercollaborateur().addActionListener(this);
		this.vue.getBtnsupprimercollaborateur().addActionListener(this);
		this.vue.getBtnmodifiercollaborateur().addActionListener(this);
		this.vue.getBtnClient().addActionListener(this);
		this.vue.getBtnFournisseur().addActionListener(this);
		this.vue.getBtnMedecin().addActionListener(this);
		this.vue.getComboBoxtype().addActionListener(this);
		this.vue.getTable().addMouseListener(this);
		this.vue.getPanel().addMouseListener(this);
		affichefournisseur();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		enabledtxt(e);
		affichetableboutton(e);
		ajouterCollaborateur(e);
		supprimercollaborateur(e);
		Modifiercollaborateur(e);				
		}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==vue.getTable()) {
			vue.getBtnsupprimercollaborateur().setEnabled(true);
			vue.getBtnmodifiercollaborateur().setEnabled(true);
			vue.getBtnajoutercollaborateur().setEnabled(false);
		}else {
			vue.getBtnsupprimercollaborateur().setEnabled(false);
			vue.getBtnmodifiercollaborateur().setEnabled(false);
			vue.getBtnajoutercollaborateur().setEnabled(true);
			if((DefaultTableModel) vue.getTable().getModel()==modelfournisseur) {
				affichefournisseur();
			}else if((DefaultTableModel) vue.getTable().getModel()==modelmedecin) {
				affichemedecin();
			}else if((DefaultTableModel) vue.getTable().getModel()==modelclient) {
				afficheClient();
			}
			}
	}
	//activer ou desactiver les jtext par apport au combo type
		public void enabledtxt(ActionEvent e) {
			if(e.getSource()==vue.getComboBoxtype()) {
				if(vue.getComboBoxtype().getSelectedItem().toString().equals("Medecin")) {
					vue.getTxtadresse().setEnabled(true);
					vue.getTxtspecialite().setEnabled(true);
					vue.getTxtage().setEnabled(false);
					vue.getTxtmaladie().setEnabled(false);
					vue.getTxtnumsec().setEnabled(false);
				}else if(vue.getComboBoxtype().getSelectedItem().toString().equals("Client")) {
					vue.getTxtage().setEnabled(true);
					vue.getTxtmaladie().setEnabled(true);
					vue.getTxtnumsec().setEnabled(true);
					vue.getTxtadresse().setEnabled(false);
					vue.getTxtspecialite().setEnabled(false);
					}else if(vue.getComboBoxtype().getSelectedItem().toString().equals("Fournisseur")) {
						vue.getTxtage().setEnabled(false);
						vue.getTxtmaladie().setEnabled(false);
						vue.getTxtnumsec().setEnabled(false);
						vue.getTxtadresse().setEnabled(false);
						vue.getTxtspecialite().setEnabled(false);
					}
		}
		
	}
		public void affichetableboutton(ActionEvent e) {
			 
			 if(e.getSource()==vue.getBtnClient()) {
				 afficheClient();
			 }
			 if(e.getSource()==vue.getBtnFournisseur()) {
				 affichefournisseur();
			 }		
			 if(e.getSource()==vue.getBtnMedecin()) {
				 affichemedecin();
			 }
		}
		public void ajouterCollaborateur(ActionEvent e) {
			if(e.getSource()==vue.getBtnajoutercollaborateur()&&vue.getComboBoxtype().getSelectedItem().toString().equals("Fournisseur")) {
				Fournisseur fournisseur = new Fournisseur(vue.getTxtnom().getText(),vue.getTxtprenom().getText());
				fournisseur.ajouter();
				affichefournisseur();
				vue.getTxtnom().setText("");vue.getTxtprenom().setText("");vue.getTxtprenom().setText("");
				vue.getComboBoxtype().setSelectedItem("Sélectionner");
				JOptionPane.showMessageDialog(null, "Ajouter avec succes ");
			}else if(e.getSource()==vue.getBtnajoutercollaborateur()&&vue.getComboBoxtype().getSelectedItem().toString().equals("Client")) {
				Client client = new Client(vue.getTxtnom().getText(),vue.getTxtprenom().getText(),
						vue.getTxtage().getText(), vue.getTxtnumsec().getText(),
						vue.getTxtmaladie().getText());
				client.ajouter();
				afficheClient();
				vue.getTxtnom().setText("");vue.getTxtprenom().setText("");vue.getTxtprenom().setText("");
				vue.getTxtage().setText("");vue.getTxtnumsec().setText("");vue.getTxtmaladie().setText("");
				vue.getTxtage().setEnabled(false);vue.getTxtnumsec().setEnabled(false);
				vue.getTxtmaladie().setEnabled(false);
				vue.getComboBoxtype().setSelectedItem("Sélectionner");
			}else if(e.getSource()==vue.getBtnajoutercollaborateur()&&vue.getComboBoxtype().getSelectedItem().toString().equals("Medecin")) {
				Medecin medecin = new Medecin(vue.getTxtnom().getText(),vue.getTxtprenom().getText(),
						vue.getTxtadresse().getText(),vue.getTxtspecialite().getText());
				medecin.ajouter();
				affichemedecin();
				vue.getTxtnom().setText("");vue.getTxtprenom().setText("");vue.getTxtprenom().setText("");
				vue.getTxtadresse().setText("");vue.getTxtspecialite().setText("");vue.getTxtage().setEnabled(false);vue.getTxtnumsec().setEnabled(false);
				vue.getComboBoxtype().setSelectedItem("Sélectionner");
			}
		}
		public void supprimercollaborateur(ActionEvent e) {
			if(e.getSource()==vue.getBtnsupprimercollaborateur()&&(DefaultTableModel) vue.getTable().getModel()==modelfournisseur) {
				SupprimerFournisseur vue1 = new SupprimerFournisseur();
				SuppFournisseurContro c = new SuppFournisseurContro(vue1,vue.getTable(),vue.getScrollPane(),vue.getBtnmodifiercollaborateur(),vue.getBtnsupprimercollaborateur(),vue.getBtnajoutercollaborateur());
				vue1.setVisible(true);
	  			int ligne = vue.getTable().getSelectedRow();
	  			vue1.getLblIdcollaborateur().setText(vue.getTable().getModel().getValueAt(ligne,0).toString());
				vue1.getTxtnom().setText(vue.getTable().getModel().getValueAt(ligne,1).toString());
				vue1.getTxtprenom().setText(vue.getTable().getModel().getValueAt(ligne,2).toString());
			}else if(e.getSource()==vue.getBtnsupprimercollaborateur()&&(DefaultTableModel) vue.getTable().getModel()==modelmedecin) {
				SupprimerMedecin vue1 = new SupprimerMedecin();
				SuppMedecinContro c = new SuppMedecinContro(vue1,vue.getTable(),vue.getScrollPane(),vue.getBtnmodifiercollaborateur(),vue.getBtnsupprimercollaborateur(),vue.getBtnajoutercollaborateur());
				vue1.setVisible(true);
	  			int ligne = vue.getTable().getSelectedRow();
	  			vue1.getLblIdcollaborateur().setText(vue.getTable().getModel().getValueAt(ligne,0).toString());
				vue1.getTxtnom().setText(vue.getTable().getModel().getValueAt(ligne,1).toString());
				vue1.getTxtprenom().setText(vue.getTable().getModel().getValueAt(ligne,2).toString());
				vue1.getTxtadresse().setText(vue.getTable().getModel().getValueAt(ligne,3).toString());
				vue1.getTxtspecialite().setText(vue.getTable().getModel().getValueAt(ligne,4).toString());
			}else if(e.getSource()==vue.getBtnsupprimercollaborateur()&&(DefaultTableModel) vue.getTable().getModel()==modelclient) {
				SupprimerClient vue1 = new SupprimerClient();
				SuppClientContro c = new SuppClientContro(vue1,vue.getTable(),vue.getScrollPane(),vue.getBtnmodifiercollaborateur(),vue.getBtnsupprimercollaborateur(),vue.getBtnajoutercollaborateur());
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
		public void Modifiercollaborateur(ActionEvent e) {
			if(e.getSource()==vue.getBtnmodifiercollaborateur()&&(DefaultTableModel) vue.getTable().getModel()==modelfournisseur) {
				ModifierFournisseur vue1 = new ModifierFournisseur();
				ModifierFournisseurContro c = new ModifierFournisseurContro(vue1,vue.getTable(),vue.getScrollPane(),vue.getBtnmodifiercollaborateur(),vue.getBtnsupprimercollaborateur(),vue.getBtnajoutercollaborateur());
				vue1.setVisible(true);
	  			int ligne = vue.getTable().getSelectedRow();
	  			vue1.getTxtidCollaborateur().setText(vue.getTable().getModel().getValueAt(ligne,0).toString());
				vue1.getTxtnomcollaborateur().setText(vue.getTable().getModel().getValueAt(ligne,1).toString());
				vue1.getTxtprenomcollaborateur().setText(vue.getTable().getModel().getValueAt(ligne,2).toString());
			}else if(e.getSource()==vue.getBtnmodifiercollaborateur()&&(DefaultTableModel) vue.getTable().getModel()==modelmedecin) {
				ModifierMedecin vue1 = new ModifierMedecin();
				ModifierMedecinContro c = new ModifierMedecinContro(vue1,vue.getTable(),vue.getScrollPane(),vue.getBtnmodifiercollaborateur(),vue.getBtnsupprimercollaborateur(),vue.getBtnajoutercollaborateur());
				vue1.setVisible(true);
	  			int ligne = vue.getTable().getSelectedRow();
	  			vue1.getTxtidCollaborateur().setText(vue.getTable().getModel().getValueAt(ligne,0).toString());
				vue1.getTxtnomcollaborateur().setText(vue.getTable().getModel().getValueAt(ligne,1).toString());
				vue1.getTxtprenomcollaborateur().setText(vue.getTable().getModel().getValueAt(ligne,2).toString());
				vue1.getTxtadresse().setText(vue.getTable().getModel().getValueAt(ligne,3).toString());
				vue1.getTxtspacialite().setText(vue.getTable().getModel().getValueAt(ligne,4).toString());
			}else if(e.getSource()==vue.getBtnmodifiercollaborateur()&&(DefaultTableModel) vue.getTable().getModel()==modelclient) {
				ModifierClient vue1 = new ModifierClient();
				ModifierClientContro c = new ModifierClientContro(vue1,vue.getTable(),vue.getScrollPane(),vue.getBtnmodifiercollaborateur(),vue.getBtnsupprimercollaborateur(),vue.getBtnajoutercollaborateur());
				vue1.setVisible(true);
	  			int ligne = vue.getTable().getSelectedRow();
	  			vue1.getTxtidCollaborateur().setText(vue.getTable().getModel().getValueAt(ligne,0).toString());
				vue1.getTxtnomcollaborateur().setText(vue.getTable().getModel().getValueAt(ligne,1).toString());
				vue1.getTxtprenomcollaborateur().setText(vue.getTable().getModel().getValueAt(ligne,2).toString());
				vue1.getTxtage().setText(vue.getTable().getModel().getValueAt(ligne,3).toString());
				vue1.getTxtnumSecurite().setText(vue.getTable().getModel().getValueAt(ligne,4).toString());
				vue1.getTxtmaladiechro().setText(vue.getTable().getModel().getValueAt(ligne,5).toString());
			}
		}
		public void affichefournisseur() {
			vue.getTable().setModel(modelfournisseur);
			vue.getScrollPane().setViewportView(vue.getTable());
			 DefaultTableModel model = (DefaultTableModel) vue.getTable().getModel();
			 int n = model.getRowCount();
			 for (int i=n-1 ; i>=0 ; --i) model.removeRow(i);
			 for (int i = 0; i <Fournisseur.listefournisseur.size(); i++) {
					model.addRow(new Object[] {Fournisseur.listefournisseur.get(i).getIdcollaborateur(),
							Fournisseur.listefournisseur.get(i).getNomcollaborateur(),
							Fournisseur.listefournisseur.get(i).getPrenomcollaborateur()});
				}
		}
		public void afficheClient() {
			vue.getTable().setModel(modelclient);
			vue.getScrollPane().setViewportView(vue.getTable());
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
		public void affichemedecin() {
			vue.getTable().setModel(modelmedecin);
			vue.getScrollPane().setViewportView(vue.getTable());
			 DefaultTableModel model = (DefaultTableModel) vue.getTable().getModel();
			 int n = model.getRowCount();
			 for (int i=n-1 ; i>=0 ; --i) model.removeRow(i);
			 for (int i = 0; i <Medecin.listemedecin.size(); i++) {
					model.addRow(new Object[] {Medecin.listemedecin.get(i).getIdcollaborateur(),
							Medecin.listemedecin.get(i).getNomcollaborateur(),
							Medecin.listemedecin.get(i).getPrenomcollaborateur(),Medecin.listemedecin.get(i).getAdressemedecin(),
							Medecin.listemedecin.get(i).getSpecialite()});
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
