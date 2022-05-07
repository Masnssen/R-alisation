package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modele.ConnexionMySQL;
import modele.Piste;
import modele.Poste;
import modele.Utilisateur;
import net.proteanit.sql.DbUtils;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;

public class Administrateurs extends JFrame {

	private JPanel contentPane;
	private static JTable table;
	private JTextField txtPseudo;
	private JPasswordField txtPassword;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JLabel lblNom;
	private JComboBox comboBoxPoste;
	Utilisateur utilisateur ;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administrateurs frame = new Administrateurs();
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
		
	public Administrateurs() {
		setLocationByPlatform(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(100, 100, 1000,500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204,204,204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 226, 500);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel Button_Acceuil = new JPanel();
		JPanel Button_déconnexion = new JPanel();

		
		Button_Acceuil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClick(Button_Acceuil);
				
				}
			@Override
			public void mouseEntered(MouseEvent e) {
				onHover(Button_Acceuil);
							}
			public void mouseExited(MouseEvent e) {
				onLeaveHover(Button_Acceuil);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				onLeavClick(Button_Acceuil);
			}
		});

		Button_Acceuil.setLayout(null);
		Button_Acceuil.setBackground(Color.WHITE);
		Button_Acceuil.setBounds(0, 85, 226, 60);
		panel.add(Button_Acceuil);
		
		JLabel lblaccueil = new JLabel("Accueil");
		lblaccueil.setForeground(new Color(181,77,180));
		lblaccueil.setHorizontalAlignment(SwingConstants.CENTER);
		lblaccueil.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblaccueil.setBounds(56, 18, 75, 24);
		Button_Acceuil.add(lblaccueil);
		
		Button_déconnexion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {				
				
				onLeavClick(Button_Acceuil);
			
				 authentification obj = new authentification();
					obj.setVisible(true);
					obj.setLocationRelativeTo(null);
					dispose();
					}
			@Override
			public void mouseEntered(MouseEvent e) {
				
				Button_déconnexion.setBackground(Color.DARK_GRAY);
				onLeaveHover(Button_Acceuil);
				
				
			}public void mouseExited(MouseEvent e) {
				Button_déconnexion.setBackground(Color.RED);
			}
			
			
		});
		Button_déconnexion.setLayout(null);
		Button_déconnexion.setBackground(Color.RED);
		Button_déconnexion.setBounds(0, 429, 226, 60);
		panel.add(Button_déconnexion);
		
		JLabel lblTaskView = new JLabel("d\u00E9connexion");
		lblTaskView.setHorizontalAlignment(SwingConstants.CENTER);
		lblTaskView.setForeground(Color.WHITE);
		lblTaskView.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblTaskView.setBounds(56, 18, 123, 24);
		Button_déconnexion.add(lblTaskView);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(247,247,247));
		panel_3.setBounds(214, 0, 796, 500);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblWelcomBack = new JLabel("Gestion des comptes");
		lblWelcomBack.setHorizontalAlignment(SwingConstants.LEFT);
		lblWelcomBack.setForeground(new Color(96, 83, 150));
		lblWelcomBack.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblWelcomBack.setBounds(20, 11, 414, 24);
		panel_3.add(lblWelcomBack);
		
		JLabel lblPayment = new JLabel("Nombre d'utilisateur");
		lblPayment.setHorizontalAlignment(SwingConstants.LEFT);
		lblPayment.setForeground(new Color(96, 83, 150));
		lblPayment.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblPayment.setBounds(421, 46, 128, 20);
		panel_3.add(lblPayment);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBounds(413, 80, 136, 67);
		panel_3.add(panel_7);
		
		JLabel label_3 = new JLabel(Integer.toString(Utilisateur.listeUtilisateur().size()));
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setForeground(new Color(96, 83, 150));
		label_3.setFont(new Font("Segoe UI", Font.BOLD, 24));
		label_3.setBounds(20, 20, 74, 25);
		panel_7.add(label_3);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(384, 158, 390, 331);
		panel_3.add(scrollPane_1);
		
		DefaultTableModel model = new DefaultTableModel();
		table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int ligne = table.getSelectedRow();
				   txtPseudo.setText(table.getModel().getValueAt(ligne,1).toString());
				   txtPassword.setText(table.getModel().getValueAt(ligne,2).toString());
				   txtNom.setText(table.getModel().getValueAt(ligne,3).toString());
				   txtPrenom.setText(table.getModel().getValueAt(ligne,4).toString());
				//   remplirComboAffichageLigneTab(comboBoxPoste,Integer.parseInt(table.getModel().getValueAt(ligne,0).toString()));
				   if(table.getModel().getValueAt(ligne,5).toString().equals("CONTROLEUR_AERIEN"))
					   comboBoxPoste.setSelectedItem(Poste.CONTROLEUR_AERIEN);
				   else
						if(table.getModel().getValueAt(ligne,5).toString().equals("INGENIEUR_PREPARATEUR_DE_VOL"))
							 comboBoxPoste.setSelectedItem(Poste.INGENIEUR_PREPARATEUR_DE_VOL);
						else 
							if(table.getModel().getValueAt(ligne,5).toString().equals("COORDINATEUR_DE_VOL"))
								 comboBoxPoste.setSelectedItem(Poste.COORDINATEUR_DE_VOL);
							else 
								if(table.getModel().getValueAt(ligne,5).toString().equals("RESPONSABLE_D_EXPLOITATION_AEROPORTUAIRE"))
									 comboBoxPoste.setSelectedItem(Poste.RESPONSABLE_D_EXPLOITATION_AEROPORTUAIRE);
								else
									if(table.getModel().getValueAt(ligne,5).toString().equals("INGENIEUR_OPERATION_DE_VOL"))
										 comboBoxPoste.setSelectedItem(Poste.INGENIEUR_OPERATION_DE_VOL);
									else
										if(table.getModel().getValueAt(ligne,5).toString().equals("INGENIEUR_SECURITE_AERIEN"))
											 comboBoxPoste.setSelectedItem(Poste.INGENIEUR_SECURITE_AERIEN);
											else
												if(table.getModel().getValueAt(ligne,5).toString().equals("ANALYSTE_DE_VOL"))
													 comboBoxPoste.setSelectedItem(Poste.ANALYSTE_DE_VOL);
												else
	                                               if(table.getModel().getValueAt(ligne,5).toString().equals("ADMINISTRATEUR"))
	                                            	   comboBoxPoste.setSelectedItem(Poste.ADMINISTRATEUR);
			}
		});
		table.setSelectionBackground(new Color(96, 83, 150));
		table.setRowHeight(20);
		table.setGridColor(new Color(247, 247, 247));
		table.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		table.setBorder(null);
		table.setBackground(new Color(247, 247, 247));
		update_table(table);
		scrollPane_1.setViewportView(table);
		
		txtPseudo = new JTextField();
		txtPseudo.setColumns(10);
		txtPseudo.setBounds(131, 96, 196, 20);
		panel_3.add(txtPseudo);
		
		JLabel lblPseudo = new JLabel("Pseudo");
		lblPseudo.setForeground(new Color(96, 83, 150));
		lblPseudo.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPseudo.setBounds(36, 90, 85, 24);
		panel_3.add(lblPseudo);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(96, 83, 150));
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPassword.setBounds(36, 144, 85, 24);
		panel_3.add(lblPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(131, 150, 196, 20);
		panel_3.add(txtPassword);
		
		JLabel lblPoste = new JLabel("Poste");
		lblPoste.setForeground(new Color(96, 83, 150));
		lblPoste.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPoste.setBounds(36, 197, 96, 24);
		panel_3.add(lblPoste);
		
		lblNom = new JLabel("Nom");
		lblNom.setForeground(new Color(96, 83, 150));
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNom.setBounds(36, 242, 85, 24);
		panel_3.add(lblNom);
		
		txtNom = new JTextField();
		txtNom.setColumns(10);
		txtNom.setBounds(131, 248, 196, 20);
		panel_3.add(txtNom);
		
		txtPrenom = new JTextField();
		txtPrenom.setColumns(10);
		txtPrenom.setBounds(131, 288, 196, 20);
		panel_3.add(txtPrenom);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setForeground(new Color(96, 83, 150));
		lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPrenom.setBounds(36, 282, 85, 24);
		panel_3.add(lblPrenom);
		
		JButton button = new JButton("Ajouter");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxPoste.getSelectedItem().toString().equals("Sélectionner")|| txtNom.getText().equals("")||txtPassword.getText().equals("")||txtPrenom.getText().equals("")||txtPseudo.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Veuiller remplir tout les champs");
				}else {
					try {
				if(comboBoxPoste.getSelectedItem().toString().equals("CONTROLEUR_AERIEN"))
                    utilisateur = new Utilisateur(txtPseudo.getText(), txtPassword.getText(), txtNom.getText(), txtPrenom.getText(), Poste.CONTROLEUR_AERIEN);
				else
					if(comboBoxPoste.getSelectedItem().toString().equals("INGENIEUR_PREPARATEUR_DE_VOL"))
		                    utilisateur = new Utilisateur(txtPseudo.getText(), txtPassword.getText(), txtNom.getText(), txtPrenom.getText(), Poste.INGENIEUR_PREPARATEUR_DE_VOL);
					else 
						if(comboBoxPoste.getSelectedItem().toString().equals("COORDINATEUR_DE_VOL"))
		                    utilisateur = new Utilisateur(txtPseudo.getText(), txtPassword.getText(), txtNom.getText(), txtPrenom.getText(), Poste.COORDINATEUR_DE_VOL);
						else 
							if(comboBoxPoste.getSelectedItem().toString().equals("RESPONSABLE_D_EXPLOITATION_AEROPORTUAIRE"))
			                    utilisateur = new Utilisateur(txtPseudo.getText(), txtPassword.getText(), txtNom.getText(), txtPrenom.getText(), Poste.RESPONSABLE_D_EXPLOITATION_AEROPORTUAIRE);
							else
								if(comboBoxPoste.getSelectedItem().toString().equals("INGENIEUR_OPERATION_DE_VOL"))
				                    utilisateur = new Utilisateur(txtPseudo.getText(), txtPassword.getText(), txtNom.getText(), txtPrenom.getText(), Poste.INGENIEUR_OPERATION_DE_VOL);
								else
									if(comboBoxPoste.getSelectedItem().toString().equals("INGENIEUR_SECURITE_AERIEN"))
					                    utilisateur = new Utilisateur(txtPseudo.getText(), txtPassword.getText(), txtNom.getText(), txtPrenom.getText(), Poste.INGENIEUR_SECURITE_AERIEN);
										else
											if(comboBoxPoste.getSelectedItem().toString().equals("ANALYSTE_DE_VOL"))
							                    utilisateur = new Utilisateur(txtPseudo.getText(), txtPassword.getText(), txtNom.getText(), txtPrenom.getText(), Poste.ANALYSTE_DE_VOL);
											else
                                               if(comboBoxPoste.getSelectedItem().toString().equals("ADMINISTRATEUR"))
                    			                    utilisateur = new Utilisateur(txtPseudo.getText(), txtPassword.getText(), txtNom.getText(), txtPrenom.getText(), Poste.ADMINISTRATEUR);
				
				utilisateur.AjouterUtilisateur();
				update_table(table);
				scrollPane_1.setViewportView(table);
				label_3.setText(Integer.toString(Utilisateur.listeUtilisateur().size()));
					}catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Veuiller remplir la durree");
					}
			}}
		});
		
		button.setBackground(new Color(126, 87, 194));
		button.setBounds(20, 352, 108, 34);
		panel_3.add(button);
		
		comboBoxPoste = new JComboBox();
		comboBoxPoste.setBounds(131, 197, 196, 22);
		panel_3.add(comboBoxPoste);
		
		
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxPoste.getSelectedItem().toString().equals("Sélectionner")|| txtNom.getText().equals("")||txtPassword.getText().equals("")||txtPrenom.getText().equals("")||txtPseudo.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Veuiller remplir tout les champs");
				}else {
				int ligne = table.getSelectedRow();
				String id = table.getModel().getValueAt(ligne,0).toString();
				if(comboBoxPoste.getSelectedItem().toString().equals("CONTROLEUR_AERIEN"))
                    utilisateur = new Utilisateur(Integer.parseInt(id),txtPseudo.getText(), txtPassword.getText(), txtNom.getText(), txtPrenom.getText(), Poste.CONTROLEUR_AERIEN);
				else
					if(comboBoxPoste.getSelectedItem().toString().equals("INGENIEUR_PREPARATEUR_DE_VOL"))
		                    utilisateur = new Utilisateur(Integer.parseInt(id),txtPseudo.getText(), txtPassword.getText(), txtNom.getText(), txtPrenom.getText(), Poste.INGENIEUR_PREPARATEUR_DE_VOL);
					else 
						if(comboBoxPoste.getSelectedItem().toString().equals("COORDINATEUR_DE_VOL"))
		                    utilisateur = new Utilisateur(Integer.parseInt(id),txtPseudo.getText(), txtPassword.getText(), txtNom.getText(), txtPrenom.getText(), Poste.COORDINATEUR_DE_VOL);
						else 
							if(comboBoxPoste.getSelectedItem().toString().equals("RESPONSABLE_D_EXPLOITATION_AEROPORTUAIRE"))
			                    utilisateur = new Utilisateur(Integer.parseInt(id),txtPseudo.getText(), txtPassword.getText(), txtNom.getText(), txtPrenom.getText(), Poste.RESPONSABLE_D_EXPLOITATION_AEROPORTUAIRE);
							else
								if(comboBoxPoste.getSelectedItem().toString().equals("INGENIEUR_OPERATION_DE_VOL"))
				                    utilisateur = new Utilisateur(Integer.parseInt(id),txtPseudo.getText(), txtPassword.getText(), txtNom.getText(), txtPrenom.getText(), Poste.INGENIEUR_OPERATION_DE_VOL);
								else
									if(comboBoxPoste.getSelectedItem().toString().equals("INGENIEUR_SECURITE_AERIEN"))
					                    utilisateur = new Utilisateur(Integer.parseInt(id),txtPseudo.getText(), txtPassword.getText(), txtNom.getText(), txtPrenom.getText(), Poste.INGENIEUR_SECURITE_AERIEN);
										else
											if(comboBoxPoste.getSelectedItem().toString().equals("ANALYSTE_DE_VOL"))
							                    utilisateur = new Utilisateur(Integer.parseInt(id),txtPseudo.getText(), txtPassword.getText(), txtNom.getText(), txtPrenom.getText(), Poste.ANALYSTE_DE_VOL);
											else
                                               if(comboBoxPoste.getSelectedItem().toString().equals("ADMINISTRATEUR"))
                    			                    utilisateur = new Utilisateur(Integer.parseInt(id),txtPseudo.getText(), txtPassword.getText(), txtNom.getText(), txtPrenom.getText(), Poste.ADMINISTRATEUR);				
				
			
                    			                    utilisateur.Modifier();
                    			                    update_table(table);
                    			                    scrollPane_1.setViewportView(table);
			}
			}
		});
		btnModifier.setBackground(new Color(126, 87, 194));
		btnModifier.setBounds(138, 352, 108, 34);
		panel_3.add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxPoste.getSelectedItem().toString().equals("Sélectionner")|| txtNom.getText().equals("")||txtPassword.getText().equals("")||txtPrenom.getText().equals("")||txtPseudo.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Veuiller remplir tout les champs");
				}else {
				int ligne = table.getSelectedRow();
				String id = table.getModel().getValueAt(ligne,0).toString();
				if(comboBoxPoste.getSelectedItem().toString().equals("CONTROLEUR_AERIEN"))
                    utilisateur = new Utilisateur(Integer.parseInt(id),txtPseudo.getText(), txtPassword.getText(), txtNom.getText(), txtPrenom.getText(), Poste.CONTROLEUR_AERIEN);
				else
					if(comboBoxPoste.getSelectedItem().toString().equals("INGENIEUR_PREPARATEUR_DE_VOL"))
		                    utilisateur = new Utilisateur(Integer.parseInt(id),txtPseudo.getText(), txtPassword.getText(), txtNom.getText(), txtPrenom.getText(), Poste.INGENIEUR_PREPARATEUR_DE_VOL);
					else 
						if(comboBoxPoste.getSelectedItem().toString().equals("COORDINATEUR_DE_VOL"))
		                    utilisateur = new Utilisateur(Integer.parseInt(id),txtPseudo.getText(), txtPassword.getText(), txtNom.getText(), txtPrenom.getText(), Poste.COORDINATEUR_DE_VOL);
						else 
							if(comboBoxPoste.getSelectedItem().toString().equals("RESPONSABLE_D_EXPLOITATION_AEROPORTUAIRE"))
			                    utilisateur = new Utilisateur(Integer.parseInt(id),txtPseudo.getText(), txtPassword.getText(), txtNom.getText(), txtPrenom.getText(), Poste.RESPONSABLE_D_EXPLOITATION_AEROPORTUAIRE);
							else
								if(comboBoxPoste.getSelectedItem().toString().equals("INGENIEUR_OPERATION_DE_VOL"))
				                    utilisateur = new Utilisateur(Integer.parseInt(id),txtPseudo.getText(), txtPassword.getText(), txtNom.getText(), txtPrenom.getText(), Poste.INGENIEUR_OPERATION_DE_VOL);
								else
									if(comboBoxPoste.getSelectedItem().toString().equals("INGENIEUR_SECURITE_AERIEN"))
					                    utilisateur = new Utilisateur(Integer.parseInt(id),txtPseudo.getText(), txtPassword.getText(), txtNom.getText(), txtPrenom.getText(), Poste.INGENIEUR_SECURITE_AERIEN);
										else
											if(comboBoxPoste.getSelectedItem().toString().equals("ANALYSTE_DE_VOL"))
							                    utilisateur = new Utilisateur(Integer.parseInt(id),txtPseudo.getText(), txtPassword.getText(), txtNom.getText(), txtPrenom.getText(), Poste.ANALYSTE_DE_VOL);
											else
                                               if(comboBoxPoste.getSelectedItem().toString().equals("ADMINISTRATEUR"))
                    			                    utilisateur = new Utilisateur(Integer.parseInt(id),txtPseudo.getText(), txtPassword.getText(), txtNom.getText(), txtPrenom.getText(), Poste.ADMINISTRATEUR);	
				utilisateur.Supprimer();	
				update_table(table);
				scrollPane_1.setViewportView(table);
				label_3.setText(Integer.toString(Utilisateur.listeUtilisateur().size()));
			}
			}
		});
		btnSupprimer.setBackground(new Color(126, 87, 194));
		btnSupprimer.setBounds(256, 352, 108, 34);
		panel_3.add(btnSupprimer);
		
	
		remplirCombo(comboBoxPoste);
	}
	private void onHover(JPanel p) {
		p.setBackground(new Color(232,201,232));
	}
	private void onLeaveHover(JPanel p) {
		p.setBackground(Color.white);
	}
    private void onClick(JPanel p) {
		p.setBackground(new Color(205,136,205));

	}
    private void onLeavClick(JPanel p) {
		p.setBackground(Color.white);

	}
    public void update_table(JTable table) {
    	 Connection cnx = null;
		   	PreparedStatement requete = null ;
		   	ResultSet resultat = null ;
			   
				cnx = ConnexionMySQL.connectDB();	
				String sql = "SELECT * FROM utilisateur";

				try {
					requete = cnx.prepareStatement(sql);
					resultat = requete.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(resultat));
					requete.close();
					cnx.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
	}	
  //remplir combo Poste
    public void remplirCombo(JComboBox comboBoxPoste) {
		comboBoxPoste.addItem("Sélectionner");
	    List<Poste> list = Arrays.asList(Poste.values());
	    for (int i = 0; i < list.size(); i++) {
	    	comboBoxPoste.addItem(list.get(i));			
		}

	}
    
    
}
