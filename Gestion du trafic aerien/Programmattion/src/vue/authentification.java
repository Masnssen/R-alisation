package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.event.CaretListener;

import modele.Connexion;
import modele.ConnexionMySQL;
import modele.Poste;
import modele.Utilisateur;

import javax.swing.event.CaretEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;

public class authentification extends JFrame {

	private JPanel contentPane;
	private JTextField txtPseudo;
	private JPasswordField passwordField;
	private Connexion connexion ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					authentification frame = new authentification();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public authentification() {
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
		
		JLabel lblNewLabel_1 = new JLabel("Aeroport : Bejaia  DAAE");
		lblNewLabel_1.setForeground(SystemColor.activeCaption);
		lblNewLabel_1.setFont(new Font("Sitka Subheading", Font.BOLD, 35));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(49, 177, 391, 112);
		panel_1.add(lblNewLabel_1);
		
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
		
		
		
		JComboBox comboBoxPoste = new JComboBox();
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
		passwordField = new JPasswordField();
		passwordField.addFocusListener(new FocusAdapter() {
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
		JButton btnSignUp = new JButton("Sign up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtPseudo.getText().equals("")||passwordField.getText().equals("")||comboBoxPoste.getSelectedItem().toString().equals("Sélectionner")) {
					JOptionPane.showMessageDialog(null, "Veuiller remplir tout les champs");
				}else {
				if(comboBoxPoste.getSelectedItem().toString().equals("CONTROLEUR_AERIEN")) {
					connexion = new Connexion(txtPseudo.getText(), passwordField.getText(), Poste.CONTROLEUR_AERIEN);
					if(connexion.existe()) {
      					ContrôleurAérien obj = new ContrôleurAérien();
						obj.setVisible(true);
						obj.setLocationRelativeTo(null);
						dispose();
      				}else {
    					JOptionPane.showMessageDialog(null, "coordonnées incorrecte");
      				}
			      }else
					if(comboBoxPoste.getSelectedItem().toString().equals("INGENIEUR_OPERATION_DE_VOL")) {
						connexion = new Connexion(txtPseudo.getText(), passwordField.getText(), Poste.INGENIEUR_OPERATION_DE_VOL);
						if(connexion.existe()) {
          					IngénieurOpérationDeVol obj = new IngénieurOpérationDeVol();
    						obj.setVisible(true);
    						obj.setLocationRelativeTo(null);
    						dispose();
          				}else {
        					JOptionPane.showMessageDialog(null, "coordonnées incorrecte");
          				}
			         }else 
						if(comboBoxPoste.getSelectedItem().toString().equals("Coordinateur_de_vol")) {
							connexion = new Connexion(txtPseudo.getText(), passwordField.getText(), Poste.COORDINATEUR_DE_VOL);
							if(connexion.existe()) {
              				    CoordinateuDeVol obj = new CoordinateuDeVol();
        						obj.setVisible(true);
        						obj.setLocationRelativeTo(null);
        						dispose();
              				}else {
            					JOptionPane.showMessageDialog(null, "coordonnées incorrecte");
              				}
			              }else 
							if(comboBoxPoste.getSelectedItem().toString().equals("RESPONSABLE_D_EXPLOITATION_AEROPORTUAIRE")) {
								connexion = new Connexion(txtPseudo.getText(), passwordField.getText(), Poste.RESPONSABLE_D_EXPLOITATION_AEROPORTUAIRE);
								if(connexion.existe()) {
                  					ResponsableDexploitationAeroportuaire obj = new ResponsableDexploitationAeroportuaire();
            						obj.setVisible(true);
            						obj.setLocationRelativeTo(null);
            						dispose();
                  				}else {
                					JOptionPane.showMessageDialog(null, "coordonnées incorrecte");
                  				}
			                  }else
								if(comboBoxPoste.getSelectedItem().toString().equals("INGENIEUR_PREPARATEUR_DE_VOL")) {
									connexion = new Connexion(txtPseudo.getText(), passwordField.getText(), Poste.INGENIEUR_PREPARATEUR_DE_VOL);
									if(connexion.existe()) {
                      					IngenieurPreparateurDeVol obj = new IngenieurPreparateurDeVol();
                						obj.setVisible(true);
                						obj.setLocationRelativeTo(null);
                						dispose();
                      				}else {
                    					JOptionPane.showMessageDialog(null, "coordonnées incorrecte");
                      				}
			                       }else
										if(comboBoxPoste.getSelectedItem().toString().equals("INGENIEUR_SECURITE_AERIEN")) {
											connexion = new Connexion(txtPseudo.getText(), passwordField.getText(), Poste.INGENIEUR_SECURITE_AERIEN);
											if(connexion.existe()) {
                              					
                              				}else {
                            					JOptionPane.showMessageDialog(null, "coordonnées incorrecte");
                              				}
			                              }else
											if(comboBoxPoste.getSelectedItem().toString().equals("ANALYSTE_DE_VOL")) {
												connexion = new Connexion(txtPseudo.getText(), passwordField.getText(), Poste.ANALYSTE_DE_VOL);
												if(connexion.existe()) {
                                  					AnalysteDeVol obj = new AnalysteDeVol();
                            						obj.setVisible(true);
                            						obj.setLocationRelativeTo(null);
                            						dispose();
                                  				}else {
                                					JOptionPane.showMessageDialog(null, "coordonnées incorrecte");
                                  				}
											}else if(comboBoxPoste.getSelectedItem().toString().equals("ADMINISTRATEUR")) {
                                      				connexion = new Connexion(txtPseudo.getText(), passwordField.getText(), Poste.ADMINISTRATEUR);
                                      				if(connexion.existe()) {
                                      					Administrateurs obj = new Administrateurs();
                                						obj.setVisible(true);
                                						obj.setLocationRelativeTo(null);
                                						dispose();
                                      				}else {
                                    					JOptionPane.showMessageDialog(null, "coordonnées incorrecte");
                                      				}

											}
					
			}}
		});
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
		passwordField.setBorder(null);
		passwordField.setBackground(new Color(32,33,35));
		passwordField.setForeground(Color.WHITE);
		passwordField.setBounds(94, 209, 285, 20);
		panel_2.add(passwordField);
		remplirCombo(comboBoxPoste);
		remplirCombo(comboBoxPoste);
		
		JLabel lblNewLabel = new JLabel("Premiere Utilisation ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setForeground(new Color(0,0,0));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			FormulaireAdministrateur obj = new FormulaireAdministrateur();
			obj.setVisible(true);
			obj.setLocationRelativeTo(null);
			dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel.setForeground(new Color(57,113,177));
			}
			public void mouseExited(MouseEvent e) {
				lblNewLabel.setForeground(new Color(0,0,0));
			}
		});
		lblNewLabel.setBounds(263, 400, 126, 22);
		panel_2.add(lblNewLabel);
			
	}
	public void remplirCombo(JComboBox comboBoxPoste) {
		//remplir combo
		comboBoxPoste.addItem("Sélectionner");
	    List<Poste> list = Arrays.asList(Poste.values());
	    for (int i = 0; i < list.size(); i++) {
	    	comboBoxPoste.addItem(list.get(i));			
		}

	}
}
