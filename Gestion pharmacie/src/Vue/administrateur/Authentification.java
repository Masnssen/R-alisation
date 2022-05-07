package Vue.administrateur;


import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Authentification extends JFrame {

	private JPanel contentPane;
	private JTextField txtPseudo;
	private JPasswordField txtpassword;
	private JComboBox comboBoxPoste;
	private JButton btnSignUp;
	

	public JButton getBtnSignUp() {
		return btnSignUp;
	}

	public JTextField getTxtPseudo() {
		return txtPseudo;
	}

	public JPasswordField getTxtpassword() {
		return txtpassword;
	}

	public JComboBox getComboBoxPoste() {
		return comboBoxPoste;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the frame.
	 */
	public Authentification() {
		setResizable(false);
		setLocationByPlatform(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setUndecorated(true);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 450, 500);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Pharmacie: ISIL_A");
		lblNewLabel_1.setForeground(SystemColor.activeCaption);
		lblNewLabel_1.setFont(new Font("Sitka Subheading", Font.BOLD, 35));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(32, 36, 332, 68);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("BARACHE Syphax:181833012823");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(SystemColor.activeCaption);
		lblNewLabel_1_1.setFont(new Font("Sitka Small", Font.BOLD, 24));
		lblNewLabel_1_1.setBounds(10, 136, 430, 68);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("TIGHILT Massinissa:181831016207");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setForeground(SystemColor.activeCaption);
		lblNewLabel_1_1_1.setFont(new Font("Sitka Small", Font.BOLD, 23));
		lblNewLabel_1_1_1.setBounds(10, 215, 440, 68);
		panel_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("G02");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setForeground(SystemColor.activeCaption);
		lblNewLabel_1_1_1_1.setFont(new Font("Sitka Small", Font.BOLD, 23));
		lblNewLabel_1_1_1_1.setBounds(134, 324, 191, 68);
		panel_1.add(lblNewLabel_1_1_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(32,33,35));
		panel_2.setBounds(449, 0, 461, 500);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblPseudo = new JLabel("Pseudo");
		lblPseudo.setForeground(new Color(57,113,177));
		lblPseudo.setBounds(94, 100, 82, 14);
		panel_2.add(lblPseudo);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setForeground(new Color(51, 52, 54));
		lblMotDePasse.setBounds(94, 183, 96, 14);
		panel_2.add(lblMotDePasse);
		
		JLabel lblPoste = new JLabel("Poste");
		lblPoste.setForeground(new Color(51, 52, 54));
		lblPoste.setBounds(94, 253, 96, 14);
		panel_2.add(lblPoste);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.WHITE);
		separator_1.setBounds(94, 150, 285, 2);
		panel_2.add(separator_1);
		
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(94, 233, 285, 2);
		panel_2.add(separator_2);
		
		
		
		 comboBoxPoste = new JComboBox();
		comboBoxPoste.addItem("Sélectionner");
		comboBoxPoste.addItem("Administrateur");
		comboBoxPoste.addItem("Pharmacien");
		comboBoxPoste.addItem("commercial");
		comboBoxPoste.addItem("Vendeur");
		comboBoxPoste.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblMotDePasse.setForeground(new Color(51, 52, 54));
				lblPseudo.setForeground(new Color(51, 52, 54));
				lblPoste.setForeground(new Color(57,113,177));
				comboBoxPoste.setForeground(new Color(57,113,177));
				separator_2.setForeground(new Color(51,52,54));
				separator_2.setBackground(new Color(51,52,54));
				separator_1.setForeground(new Color(51,52,54));
				separator_1.setBackground(new Color(51,52,54));
				
			}
		});
		txtpassword = new JPasswordField();
		txtpassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				separator_2.setForeground(new Color(57,113,177));
				lblMotDePasse.setForeground(new Color(57,113,177));
				separator_1.setForeground(new Color(51,52,54));	
				separator_1.setBackground(new Color(51,52,54));
				lblPseudo.setForeground(new Color(51, 52, 54));
				comboBoxPoste.setForeground(new Color(51,52,54));
				lblPoste.setForeground(new Color(51,52,54));
			}
		});
		txtPseudo = new JTextField();
		txtPseudo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				separator_1.setForeground(new Color(57,113,177));
				lblPseudo.setForeground(new Color(57,113,177));
				separator_2.setForeground(new Color(51,52,54));
				separator_2.setBackground(new Color(51,52,54));
				lblMotDePasse.setForeground(new Color(51, 52, 54));
				comboBoxPoste.setForeground(new Color(51,52,54));
				lblPoste.setForeground(new Color(51,52,54));			
			
			}
		});
		
		comboBoxPoste.setBackground(new Color(32,33,35));
		comboBoxPoste.setForeground(Color.WHITE);
		comboBoxPoste.setBounds(94, 278, 285, 22);
		panel_2.add(comboBoxPoste);
		 btnSignUp = new JButton("Sign up");
		
		btnSignUp.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnSignUp.setForeground(Color.WHITE);
		btnSignUp.setBackground(new Color(126,87,194));
		btnSignUp.setBounds(94, 344, 285, 45);
		panel_2.add(btnSignUp);
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblX.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setForeground(new Color(57, 113, 177));
		lblX.setBounds(390, 0, 61, 44);
		panel_2.add(lblX);
		
		txtPseudo.setForeground(Color.WHITE);
		txtPseudo.setBorder(null);
		txtPseudo.setBackground(new Color(32,33,35));
		txtPseudo.setBounds(94, 125, 285, 20);
		panel_2.add(txtPseudo);
		txtPseudo.setColumns(10);
		txtpassword.setBorder(null);
		txtpassword.setBackground(new Color(32,33,35));
		txtpassword.setForeground(Color.WHITE);
		txtpassword.setBounds(94, 209, 285, 20);
		panel_2.add(txtpassword);
			
	}
	}