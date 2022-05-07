package Vue.administrateur;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ModifierCompte extends JFrame {

	private JPanel contentPane;
	private JButton btnModifier;
	private JLabel lblIdcollaborateur;
	private JButton btnAnnuler;
	private JTextField txtidCompte;
	private JTextField txtnom;
	private JTextField txtprenom;
	private JTextField txtUser;
	private JComboBox comboBoxfonction;
	private JPasswordField txtPassword;
	
	public JButton getBtnModifier() {
		return btnModifier;
	}

	public JButton getBtnAnnuler() {
		return btnAnnuler;
	}	
	public JTextField getTxtidCompte() {
		return txtidCompte;
	}

	public JTextField getTxtnom() {
		return txtnom;
	}

	public JTextField getTxtprenom() {
		return txtprenom;
	}

	public JTextField getTxtUser() {
		return txtUser;
	}

	public JPasswordField getTxtPassword() {
		return txtPassword;
	}
	public JComboBox getComboBoxfonction() {
		return comboBoxfonction;
	}

	/**
	 * Create the frame.
	 */
	public ModifierCompte() {
		setTitle("Confirmation de Modification");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 534, 384);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblnom = new JLabel("Nom");
		lblnom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblnom.setBounds(10, 57, 181, 27);
		contentPane.add(lblnom);
		
		 btnModifier = new JButton("Modifier");
		 btnModifier.setBounds(117, 321, 107, 23);
		 contentPane.add(btnModifier);
		
		lblIdcollaborateur = new JLabel("Id");
		lblIdcollaborateur.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIdcollaborateur.setBounds(10, 14, 107, 27);
		contentPane.add(lblIdcollaborateur);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(278, 321, 107, 23);
		contentPane.add(btnAnnuler);
		
		txtidCompte = new JTextField();
		txtidCompte.setEditable(false);
		txtidCompte.setBounds(211, 18, 242, 27);
		contentPane.add(txtidCompte);
		txtidCompte.setColumns(10);
		
		txtnom = new JTextField();
		txtnom.setColumns(10);
		txtnom.setBounds(211, 57, 242, 27);
		contentPane.add(txtnom);
		
		txtprenom = new JTextField();
		txtprenom.setColumns(10);
		txtprenom.setBounds(211, 101, 242, 27);
		contentPane.add(txtprenom);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrenom.setBounds(10, 101, 197, 27);
		contentPane.add(lblPrenom);
		
		JLabel lblfonction = new JLabel("Age");
		lblfonction.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblfonction.setBounds(10, 139, 197, 27);
		contentPane.add(lblfonction);
		
		txtUser = new JTextField();
		txtUser.setColumns(10);
		txtUser.setBounds(211, 177, 242, 27);
		contentPane.add(txtUser);
		
		JLabel lbluser = new JLabel("User");
		lbluser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbluser.setBounds(10, 177, 197, 27);
		contentPane.add(lbluser);
		
		JLabel lblpassword = new JLabel("Password");
		lblpassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblpassword.setBounds(10, 222, 197, 27);
		contentPane.add(lblpassword);
		
		comboBoxfonction = new JComboBox();
		comboBoxfonction.addItem("Administrateur");
		comboBoxfonction.addItem("Pharmacien");
		comboBoxfonction.addItem("commercial");
		comboBoxfonction.addItem("Vendeur");
		comboBoxfonction.setBounds(211, 145, 242, 22);
		contentPane.add(comboBoxfonction);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(211, 222, 242, 27);
		contentPane.add(txtPassword);
		

	}
}
