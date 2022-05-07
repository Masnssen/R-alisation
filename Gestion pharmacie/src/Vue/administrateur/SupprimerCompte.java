package Vue.administrateur;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SupprimerCompte extends JFrame {

	private JPanel contentPane;
	private JButton btnSupprimer;
	private JLabel txtnom;
	private JLabel txtprenom;
	private JLabel txtidCompte;
	private JLabel lblIdcollaborateur;
	private JButton btnAnnuler;
	private JLabel lblFonction;
	private JLabel lblUser;
	private JLabel txtUser;
	private JLabel lblPassword;
	private JLabel txtPassword;
	private JComboBox comboBoxfonction;

	public JButton getBtnSupprimer() {
		return btnSupprimer;
	}
	public JLabel getTxtidCompte() {
		return txtidCompte;
	}
	
	public JLabel getTxtnom() {
		return txtnom;
	}
	public JLabel getTxtprenom() {
		return txtprenom;
	}
	public JComboBox getComboBoxfonction() {
		return comboBoxfonction;
	}
	public JLabel getTxtuser() {
		return txtUser;
	}
	public JLabel getTxtPassword() {
		return txtPassword;
	}
	public JButton getBtnAnnuler() {
		return btnAnnuler;
	}

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public SupprimerCompte() {
		setTitle("Confirmation de suppression");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 464, 375);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblnom = new JLabel("Nom ");
		lblnom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblnom.setBounds(14, 63, 190, 27);
		contentPane.add(lblnom);
		
		JLabel lblNom = new JLabel("Prenom");
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNom.setBounds(14, 101, 203, 27);
		contentPane.add(lblNom);
		
		 txtnom = new JLabel("");
		txtnom.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtnom.setBounds(227, 63, 221, 27);
		contentPane.add(txtnom);
		
	     txtprenom = new JLabel("");
		txtprenom.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtprenom.setBounds(227, 101, 221, 27);
		contentPane.add(txtprenom);
		
		 btnSupprimer = new JButton("Supprimer");
		 btnSupprimer.setBounds(76, 296, 107, 23);
		 contentPane.add(btnSupprimer);
		
		txtidCompte = new JLabel("");
		txtidCompte.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtidCompte.setBounds(227, 25, 221, 27);
		contentPane.add(txtidCompte);
		
		lblIdcollaborateur = new JLabel("Id");
		lblIdcollaborateur.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIdcollaborateur.setBounds(14, 25, 107, 27);
		contentPane.add(lblIdcollaborateur);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(228, 296, 107, 23);
		contentPane.add(btnAnnuler);
		
		lblFonction = new JLabel("Fonction");
		lblFonction.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFonction.setBounds(14, 151, 203, 27);
		contentPane.add(lblFonction);
		
		lblUser = new JLabel("User");
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUser.setBounds(14, 199, 203, 27);
		contentPane.add(lblUser);
		
		txtUser = new JLabel("");
		txtUser.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtUser.setBounds(227, 199, 221, 27);
		contentPane.add(txtUser);
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(14, 248, 203, 27);
		contentPane.add(lblPassword);
		
		txtPassword = new JLabel("");
		txtPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtPassword.setBounds(227, 248, 221, 27);
		contentPane.add(txtPassword);
		
		 comboBoxfonction = new JComboBox();
		 comboBoxfonction.setEnabled(false);
		comboBoxfonction.setBounds(227, 157, 221, 22);
		comboBoxfonction.addItem("Administrateur");
		comboBoxfonction.addItem("Pharmacien");
		comboBoxfonction.addItem("commercial");
		comboBoxfonction.addItem("Vendeur");
		contentPane.add(comboBoxfonction);

	}
}
