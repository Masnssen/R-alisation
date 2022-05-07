package Vue.administrateur;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controle.administrateur.CompteControle;

public class GestionCompte extends JPanel {
	private JTextField txtprenom;
	private JTextField txtnom;
	private JTextField txtuser;
	private JTable table;
	private JButton btnajouter;
	private JButton btnmodifier;
	private JButton btnsupprimer;
	private JComboBox comboBoxfonction;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JPasswordField txtpassword;
	private CompteControle contorler;

		
	public JTextField getTxtprenom() {
		return txtprenom;
	}
	public JTextField getTxtnom() {
		return txtnom;
	}
	public JTextField getTxtuser() {
		return txtuser;
	}
	public JButton getBtnajouter() {
		return btnajouter;
	}
	public JButton getBtnmodifier() {
		return btnmodifier;
	}
	public JButton getBtnsupprimer() {
		return btnsupprimer;
	}
	public JComboBox getComboBoxfonction() {
		return comboBoxfonction;
	}
	public JPasswordField getTxtpassword() {
		return txtpassword;
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
	public GestionCompte() {

		setLayout(new GridLayout(1, 0, 0, 0));
		this.setBounds(10, 10, 700, 550);
		 panel = new JPanel();
		add(panel);
		panel.setLayout(null);
		
		txtprenom = new JTextField();
		txtprenom.setColumns(10);
		txtprenom.setBounds(102, 104, 152, 20);
		panel.add(txtprenom);
		
		JLabel lblprenom = new JLabel("Prenom");
		lblprenom.setForeground(Color.BLACK);
		lblprenom.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblprenom.setBounds(18, 96, 74, 24);
		panel.add(lblprenom);
		
		JLabel lblnom = new JLabel("Nom ");
		lblnom.setForeground(Color.BLACK);
		lblnom.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblnom.setBounds(18, 61, 74, 24);
		panel.add(lblnom);
		
		txtnom = new JTextField();
		txtnom.setColumns(10);
		txtnom.setBounds(102, 69, 152, 20);
		panel.add(txtnom);
		
		JLabel gestioncollaborateur = new JLabel("Gestion des comptes");
		gestioncollaborateur.setHorizontalAlignment(SwingConstants.LEFT);
		gestioncollaborateur.setForeground(Color.BLACK);
		gestioncollaborateur.setFont(new Font("Segoe UI", Font.BOLD, 18));
		gestioncollaborateur.setBounds(12, 11, 414, 24);
		panel.add(gestioncollaborateur);
		
		JLabel lblfonction = new JLabel("Fonction");
		lblfonction.setForeground(Color.BLACK);
		lblfonction.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblfonction.setBounds(18, 133, 74, 24);
		panel.add(lblfonction);
		
		 comboBoxfonction = new JComboBox();
		comboBoxfonction.setEnabled(true);
		comboBoxfonction.setBounds(102, 135, 152, 22);
		comboBoxfonction.addItem("Sélectionner");
		comboBoxfonction.addItem("Administrateur");
		comboBoxfonction.addItem("Pharmacien");
		comboBoxfonction.addItem("commercial");
		comboBoxfonction.addItem("Vendeur");
		
		panel.add(comboBoxfonction);
		
		JLabel lblpassword = new JLabel("Password");
		lblpassword.setForeground(Color.BLACK);
		lblpassword.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblpassword.setBounds(346, 96, 118, 24);
		panel.add(lblpassword);
		
		JLabel lbluser = new JLabel("User");
		lbluser.setForeground(Color.BLACK);
		lbluser.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lbluser.setBounds(346, 61, 107, 24);
		panel.add(lbluser);
		
		txtuser = new JTextField();
		txtuser.setColumns(10);
		txtuser.setBounds(463, 67, 152, 20);
		panel.add(txtuser);
		
		 btnajouter = new JButton("Ajouter");
		btnajouter.setBackground(Color.WHITE);
		btnajouter.setBounds(110, 219, 130, 33);
		panel.add(btnajouter);
		
		 btnmodifier = new JButton("Modifier");
		btnmodifier.setEnabled(false);
		btnmodifier.setBackground(Color.WHITE);
		btnmodifier.setBounds(276, 219, 130, 33);
		panel.add(btnmodifier);
		
		 btnsupprimer = new JButton("Supprimer");
		 btnsupprimer.setEnabled(false);
		btnsupprimer.setBackground(Color.WHITE);
		btnsupprimer.setBounds(460, 219, 130, 33);
		panel.add(btnsupprimer);
		
		 scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 263, 700, 296);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"IdCompte", "Nom", "Prenom", "Fonction", "User", "Password"
			}
		));
		
		scrollPane.setViewportView(table);
		
		txtpassword = new JPasswordField();
		txtpassword.setBounds(463, 104, 152, 20);
		panel.add(txtpassword);
		
		contorler= new CompteControle(this);

	}
}
