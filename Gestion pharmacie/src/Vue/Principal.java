package Vue;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Vue.Commercial.GestionCollaborateur;
import Vue.Commercial.PanneauCommercial;
import Vue.Pharmacien.PanneauPharmacien;
import Vue.Pharmacien.PanneauProduit;
import Vue.administrateur.Authentification;
import Vue.administrateur.GestionCompte;
import Vue.comtoir.PanneauComptoir;
import controle.administrateur.AuthentificationControle;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JButton btndeconnection ;
	private JButton btnAdministrateur;
	private JButton btnPharmacien;
	private JButton btnProduit;
	private JButton btnComptoir;
	private JButton btnCommercial;
	private JButton btnCollabor;
	

	
	public JButton getBtnCollabor() {
		return btnCollabor;
	}

	public JButton getBtndeconnection() {
		return btndeconnection;
	}
	
	public JButton getBtnAdministrateur() {
		return btnAdministrateur;
	}

	public void setBtndeconnection(JButton btndeconnection) {
		this.btndeconnection = btndeconnection;
	}



	public JButton getBtnPharmacien() {
		return btnPharmacien;
	}



	public JButton getBtnProduit() {
		return btnProduit;
	}



	public JButton getBtnComptoir() {
		return btnComptoir;
	}



	public JButton getBtnCommercial() {
		return btnCommercial;
	}



	/**
	 * Create the frame.
	 */
	public Principal() {
		setTitle("Principal");
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{140, 492, 0};
		gbl_contentPane.rowHeights = new int[]{561, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		
		
		
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		contentPane.add(panel_1, gbc_panel_1);
		panel_1.setLayout(new GridLayout(10, 0, 0, 0));
		
		 btnAdministrateur = new JButton("Administrateur");
		btnAdministrateur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.add(new GestionCompte());
				panel.revalidate();
				panel.repaint();
				setTitle("Administrateur");
			}
		});
		panel_1.add(btnAdministrateur);
		
		 btnProduit = new JButton("Produit");
		btnProduit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.add(new PanneauProduit());
				panel.validate();
				panel.repaint();
			setTitle("Produit");
			}
		});
		
		 btnPharmacien = new JButton("Pharmacien");
		btnPharmacien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.add(new PanneauPharmacien());
				panel.revalidate();
				panel.repaint();
				setTitle("Pharmacien");
				
			}
		});
		panel_1.add(btnPharmacien);
		panel_1.add(btnProduit);
		
		 btnComptoir = new JButton("Comptoir");
		btnComptoir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.add(new PanneauComptoir());
				panel.validate();
				panel.repaint();
				setTitle("Comptoir");
			}
		});
		panel_1.add(btnComptoir);
		
		 btnCommercial = new JButton("Commercial");
		btnCommercial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.add(new PanneauCommercial());
				panel.validate();
				panel.repaint();
				setTitle("Commercial");
			}
		});
		panel_1.add(btnCommercial);
		
		 btnCollabor = new JButton("Collaborateur");
		btnCollabor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.add(new GestionCollaborateur());
				panel.validate();
				panel.repaint();
				setTitle("Collaborateur");
			}
		});
		panel_1.add(btnCollabor);
		
		JLabel lblNewLabel_1 = new JLabel("");
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		panel_1.add(lblNewLabel);
		
		 btndeconnection = new JButton("D\u00E9connection");
		btndeconnection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Authentification frame = new Authentification();
				AuthentificationControle c = new AuthentificationControle(frame);
				frame.setVisible(true);
				dispose();
			}
		});
		panel_1.add(btndeconnection);
		
		JButton btnNewButton = new JButton("D\u00E9connection");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
	}
}
