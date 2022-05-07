package controle.administrateur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Vue.administrateur.GestionCompte;
import Vue.administrateur.ModifierCompte;
import Vue.administrateur.SupprimerCompte;
import model.administrateur.Compte;

public class CompteControle implements ActionListener,MouseListener {

	private GestionCompte vue;
	
	public CompteControle(GestionCompte vue) {
		this.vue = vue;
		vue.getBtnajouter().addActionListener(this);
		vue.getBtnsupprimer().addActionListener(this);
		vue.getBtnmodifier().addActionListener(this);
		vue.getTable().addMouseListener(this);
		vue. getPanel().addMouseListener(this);
		Afficher_table();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		AjouterCompte(e);
		Supprimer(e);
		Modifier(e);
	}
	private void AjouterCompte(ActionEvent e) {
		if(e.getSource()==vue.getBtnajouter()) {
			if(vue.getTxtnom().getText().equals("")||vue.getTxtprenom().getText().equals("")||
					vue.getComboBoxfonction().getSelectedItem().toString().equals("Sélectionner")||
					vue.getTxtuser().getText().equals("")||vue.getTxtpassword().getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Veuillez remplir tout les champ");
			}else {
			Compte compte = new Compte(vue.getTxtnom().getText(),vue.getTxtprenom().getText(),
					vue.getComboBoxfonction().getSelectedItem().toString(),
					vue.getTxtuser().getText(),vue.getTxtpassword().getText());
			compte.ajouter();
			JOptionPane.showMessageDialog(null, "Ajouter avec succes ");
			Afficher_table();
			vue.getTxtnom().setText("");vue.getTxtprenom().setText("");vue.getComboBoxfonction().setSelectedItem("Sélectionner");
			vue.getTxtuser().setText("");vue.getTxtpassword().setText("");
		}
		}
	}
	private void Supprimer(ActionEvent e) {
		if(e.getSource()==vue.getBtnsupprimer()) {
			SupprimerCompte vue1 = new SupprimerCompte();
			SuppCompteContro c = new SuppCompteContro(vue1,vue.getTable(),vue.getBtnmodifier(),vue.getBtnsupprimer(),vue.getBtnajouter());
			vue1.setVisible(true);
  			int ligne = vue.getTable().getSelectedRow();
  			vue1.getTxtidCompte().setText(vue.getTable().getModel().getValueAt(ligne,0).toString());
			vue1.getTxtnom().setText(vue.getTable().getModel().getValueAt(ligne,1).toString());
			vue1.getTxtprenom().setText(vue.getTable().getModel().getValueAt(ligne,2).toString());
			vue1.getComboBoxfonction().setSelectedItem(vue.getTable().getModel().getValueAt(ligne,3).toString());
			vue1.getTxtuser().setText(vue.getTable().getModel().getValueAt(ligne,4).toString());
			vue1.getTxtPassword().setText(vue.getTable().getModel().getValueAt(ligne,5).toString());
		}
	}
	public void Modifier(ActionEvent e) {
		if(e.getSource()==vue.getBtnmodifier()) {
		ModifierCompte vue1 = new ModifierCompte();
		ModifierCompteContro c = new ModifierCompteContro(vue1,vue.getTable(),vue.getBtnmodifier(),vue.getBtnsupprimer(),vue.getBtnajouter());
		vue1.setVisible(true);
			int ligne = vue.getTable().getSelectedRow();
			vue1.getTxtidCompte().setText(vue.getTable().getModel().getValueAt(ligne,0).toString());
		vue1.getTxtnom().setText(vue.getTable().getModel().getValueAt(ligne,1).toString());
		vue1.getTxtprenom().setText(vue.getTable().getModel().getValueAt(ligne,2).toString());
		vue1.getComboBoxfonction().setSelectedItem(vue.getTable().getModel().getValueAt(ligne,3).toString());
		vue1.getTxtUser().setText(vue.getTable().getModel().getValueAt(ligne,4).toString());
		vue1.getTxtPassword().setText(vue.getTable().getModel().getValueAt(ligne,5).toString());
		}
	}
	private void Afficher_table() {
		 DefaultTableModel model = (DefaultTableModel) vue.getTable().getModel();
		 int n = model.getRowCount();
		 for (int i=n-1 ; i>=0 ; --i) model.removeRow(i);
		 for (int i = 0; i < Compte.listecompte.size(); i++) {
			 model.addRow(new Object[] {Compte.listecompte.get(i).getIdcompte(),Compte.listecompte.get(i).getNom(),Compte.listecompte.get(i).getPrenom(),
					 Compte.listecompte.get(i).getFonction(),Compte.listecompte.get(i).getUser(),
					 Compte.listecompte.get(i).getPassword()});
			 }
		}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==vue.getTable()) {
			vue.getBtnsupprimer().setEnabled(true);
			vue.getBtnmodifier().setEnabled(true);
			vue.getBtnajouter().setEnabled(false);
		}else {
			vue.getBtnsupprimer().setEnabled(false);
			vue.getBtnmodifier().setEnabled(false);
			vue.getBtnajouter().setEnabled(true);
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
	

