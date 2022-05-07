package controle.administrateur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Vue.Principal;
import Vue.administrateur.Authentification;
import model.administrateur.Connexion;

public class AuthentificationControle implements ActionListener {

	Authentification vue ;
	
	public AuthentificationControle(Authentification vue) {
		this.vue = vue;
		this.vue.getBtnSignUp().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==vue.getBtnSignUp()) {
			Boolean trouver = false;int i=0;
			if(vue.getTxtPseudo().getText().equals("")||vue.getTxtpassword().getText().equals("")||
					vue.getComboBoxPoste().getSelectedItem().toString().equals("Sélectionner")) {
				JOptionPane.showMessageDialog(null, "Veuillez remplir tout les champ");
			}else {
				
				Connexion connexion = new Connexion(vue.getTxtPseudo().getText(),
						vue.getTxtpassword().getText(),
						vue.getComboBoxPoste().getSelectedItem().toString());
			if(connexion.verifierConnexion()==true) {
				Principal frame = new Principal();
				if(vue.getComboBoxPoste().getSelectedItem().toString().equals("Pharmacien")) {
					frame.getBtnAdministrateur().setEnabled(false);
				}else if(vue.getComboBoxPoste().getSelectedItem().toString().equals("commercial")) {
					frame.getBtnAdministrateur().setEnabled(false);
					frame.getBtnPharmacien().setEnabled(false);
				}else if(vue.getComboBoxPoste().getSelectedItem().toString().equals("Vendeur")) {
					frame.getBtnAdministrateur().setEnabled(false);
					frame.getBtnPharmacien().setEnabled(false);
					frame.getBtnCommercial().setEnabled(false);
					frame.getBtnPharmacien().setEnabled(false);
					frame.getBtnProduit().setEnabled(false);
					frame.getBtnCollabor().setEnabled(false);
				}
				frame.setLocationRelativeTo(null);
				frame.setResizable(false);
				frame.setVisible(true);
				
				vue.dispose();
				
			}else {
					JOptionPane.showMessageDialog(null, "compte introuvable ");
				}
			
			}

	}
	}
}
