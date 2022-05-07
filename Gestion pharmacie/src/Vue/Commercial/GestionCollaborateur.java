package Vue.Commercial;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import controle.collaborateur.collaborateurControle;

public class GestionCollaborateur extends JPanel {
	private JTextField txtprenom;
	private JTextField txtnom;
	private JTextField txtspecialite;
	private JTextField txtadresse;
	private JTextField txtnumsec;
	private JTextField txtage;
	private JTextField txtmaladie;
	private JTable table;
	private JButton btnajoutercollaborateur;
	private JButton btnmodifiercollaborateur;
	private JButton btnsupprimercollaborateur;
	private JButton btnFournisseur;
	private JButton btnMedecin;
	private JButton btnClient;
	private JComboBox comboBoxtype;
	private JPanel panel;
	private JScrollPane scrollPane;
	private collaborateurControle controleur;
	

	public JButton getBtnajoutercollaborateur() {
		return btnajoutercollaborateur;
	}
	public JButton getBtnmodifiercollaborateur() {
		return btnmodifiercollaborateur;
	}

	public JButton getBtnsupprimercollaborateur() {
		return btnsupprimercollaborateur;
	}

	public JButton getBtnFournisseur() {
		return btnFournisseur;
	}

	public JButton getBtnMedecin() {
		return btnMedecin;
	}

	public JButton getBtnClient() {
		return btnClient;
	}

	public JComboBox getComboBoxtype() {
		return comboBoxtype;
	}
	public JTextField getTxtprenom() {
		return txtprenom;
	}
	public JTextField getTxtnom() {
		return txtnom;
	}
	public JTextField getTxtspecialite() {
		return txtspecialite;
	}
	public JTextField getTxtadresse() {
		return txtadresse;
	}
	public JTextField getTxtnumsec() {
		return txtnumsec;
	}
	public JTextField getTxtage() {
		return txtage;
	}
	public JTextField getTxtmaladie() {
		return txtmaladie;
	}
	public JTable getTable() {
		return table;
	}
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	public JPanel getPanel() {
		return panel;
	}
	/**
	 * Create the panel.
	 */
	public GestionCollaborateur() {

		setLayout(new GridLayout(1, 0, 0, 0));
		this.setBounds(10, 10, 700, 550);
		 panel = new JPanel();
		add(panel);
		panel.setLayout(null);
		
		txtprenom = new JTextField();
		txtprenom.setColumns(10);
		txtprenom.setBounds(94, 89, 118, 20);
		panel.add(txtprenom);
		
		JLabel lblnumtel = new JLabel("Prenom");
		lblnumtel.setForeground(Color.BLACK);
		lblnumtel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblnumtel.setBounds(10, 81, 74, 24);
		panel.add(lblnumtel);
		
		JLabel lblnomCollaborateur = new JLabel("Nom ");
		lblnomCollaborateur.setForeground(Color.BLACK);
		lblnomCollaborateur.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblnomCollaborateur.setBounds(10, 46, 74, 24);
		panel.add(lblnomCollaborateur);
		
		txtnom = new JTextField();
		txtnom.setColumns(10);
		txtnom.setBounds(94, 54, 118, 20);
		panel.add(txtnom);
		
		JLabel gestioncollaborateur = new JLabel("Gestion des collaborateurs");
		gestioncollaborateur.setHorizontalAlignment(SwingConstants.LEFT);
		gestioncollaborateur.setForeground(Color.BLACK);
		gestioncollaborateur.setFont(new Font("Segoe UI", Font.BOLD, 18));
		gestioncollaborateur.setBounds(12, 11, 414, 24);
		panel.add(gestioncollaborateur);
		
		JLabel lblnumtel_1 = new JLabel("Type");
		lblnumtel_1.setForeground(Color.BLACK);
		lblnumtel_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblnumtel_1.setBounds(10, 118, 74, 24);
		panel.add(lblnumtel_1);
		
		 comboBoxtype = new JComboBox();
		comboBoxtype.setEnabled(true);
		comboBoxtype.setBounds(94, 120, 118, 22);
		comboBoxtype.addItem("Sélectionner");
		comboBoxtype.addItem("Fournisseur");
		comboBoxtype.addItem("Medecin");
		comboBoxtype.addItem("Client");
		
		panel.add(comboBoxtype);
		
		JLabel lblNewLabel = new JLabel("Medecin");
		lblNewLabel.setBounds(236, 44, 88, 14);
		panel.add(lblNewLabel);
		
		txtspecialite = new JTextField();
		txtspecialite.setEnabled(false);
		txtspecialite.setColumns(10);
		txtspecialite.setBounds(333, 65, 130, 20);
		panel.add(txtspecialite);
		
		JLabel lblSpecialite = new JLabel("Specialite");
		lblSpecialite.setForeground(Color.BLACK);
		lblSpecialite.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblSpecialite.setBounds(236, 61, 107, 24);
		panel.add(lblSpecialite);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setForeground(Color.BLACK);
		lblAdresse.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblAdresse.setBounds(236, 96, 107, 24);
		panel.add(lblAdresse);
		
		txtadresse = new JTextField();
		txtadresse.setEnabled(false);
		txtadresse.setColumns(10);
		txtadresse.setBounds(333, 102, 130, 20);
		panel.add(txtadresse);
		
		txtnumsec = new JTextField();
		txtnumsec.setEnabled(false);
		txtnumsec.setColumns(10);
		txtnumsec.setBounds(593, 89, 127, 20);
		panel.add(txtnumsec);
		
		JLabel lblNumsecurite = new JLabel("NumSecurite");
		lblNumsecurite.setForeground(Color.BLACK);
		lblNumsecurite.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNumsecurite.setBounds(476, 83, 118, 24);
		panel.add(lblNumsecurite);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setForeground(Color.BLACK);
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblAge.setBounds(476, 48, 107, 24);
		panel.add(lblAge);
		
		txtage = new JTextField();
		txtage.setEnabled(false);
		txtage.setColumns(10);
		txtage.setBounds(593, 54, 127, 20);
		panel.add(txtage);
		
		JLabel lblPateint = new JLabel("Pateint");
		lblPateint.setBounds(476, 31, 88, 14);
		panel.add(lblPateint);
		
		 btnajoutercollaborateur = new JButton("Ajouter");
		btnajoutercollaborateur.setBackground(Color.WHITE);
		btnajoutercollaborateur.setBounds(110, 167, 130, 33);
		panel.add(btnajoutercollaborateur);
		
		 btnmodifiercollaborateur = new JButton("Modifier");
		btnmodifiercollaborateur.setEnabled(false);
		btnmodifiercollaborateur.setBackground(Color.WHITE);
		btnmodifiercollaborateur.setBounds(287, 167, 130, 33);
		panel.add(btnmodifiercollaborateur);
		
		 btnsupprimercollaborateur = new JButton("Supprimer");
		 btnsupprimercollaborateur.setEnabled(false);
		btnsupprimercollaborateur.setBackground(Color.WHITE);
		btnsupprimercollaborateur.setBounds(464, 167, 130, 33);
		panel.add(btnsupprimercollaborateur);
		
		JLabel lblAdresse_1_1 = new JLabel("maladiechro");
		lblAdresse_1_1.setForeground(Color.BLACK);
		lblAdresse_1_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblAdresse_1_1.setBounds(476, 120, 107, 24);
		panel.add(lblAdresse_1_1);
		
		txtmaladie = new JTextField();
		txtmaladie.setEnabled(false);
		txtmaladie.setColumns(10);
		txtmaladie.setBounds(593, 126, 127, 20);
		panel.add(txtmaladie);
		
		 btnClient = new JButton("Client");
		btnClient.setBackground(Color.WHITE);
		btnClient.setBounds(593, 219, 130, 33);
		panel.add(btnClient);
		
		 btnMedecin = new JButton("Medecin");
		btnMedecin.setBackground(Color.WHITE);
		btnMedecin.setBounds(453, 219, 130, 33);
		panel.add(btnMedecin);
		
		 btnFournisseur = new JButton("Fournisseur");
		btnFournisseur.setBackground(Color.WHITE);
		btnFournisseur.setBounds(313, 219, 130, 33);
		panel.add(btnFournisseur);
		
		 scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 263, 700, 296);
		panel.add(scrollPane);
		
		table = new JTable();
		
		scrollPane.setViewportView(table);
		controleur = new collaborateurControle(this);

	}
}
