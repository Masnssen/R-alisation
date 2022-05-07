package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modele.ConnexionMySQL;
import modele.Piste;
import modele.Aeroport;
import modele.Compagnie;
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

public class GestionCompagnie extends JFrame {

	private JPanel contentPane;
	private static JTable table;
	private JTextField txtID;
	private Compagnie compagnie;
	private JTextField txtSite;
	private JTextField txtEmail;
	private JTextField txtNumTel;
	private JLabel txtnbr ;
	private JTextField txtNomCompagnie;
	private JPanel Button_Aeroport;
	private JPanel Button_Compagnie;
	private JPanel Button_liste_noir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionCompagnie frame = new GestionCompagnie();
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
		
	public GestionCompagnie() {
		setLocationByPlatform(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
				ResponsableDexploitationAeroportuaire obj = new ResponsableDexploitationAeroportuaire();
				obj.setVisible(true);
	  			obj.setLocationRelativeTo(null);
	  			dispose();
				
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
		lblaccueil.setForeground(new Color(96, 83, 150));
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
		
		 Button_Aeroport = new JPanel();
		Button_Aeroport.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClick(Button_Aeroport);
				onLeavClick(Button_Acceuil);
				onLeavClick(Button_Compagnie);
 
				GestionAeroport obj = new GestionAeroport();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				dispose();				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				onHover(Button_Aeroport);
				onLeaveHover(Button_Compagnie);
				//onLeaveHover(Button_déconnexion);
				onLeaveHover(Button_Acceuil);

			}
			public void mouseExited(MouseEvent e) {
				onLeaveHover(Button_Aeroport);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				onLeavClick(Button_Aeroport);
			}
		});
		Button_Aeroport.setLayout(null);
		Button_Aeroport.setBackground(Color.WHITE);
		Button_Aeroport.setBounds(0, 144, 226, 60);
		panel.add(Button_Aeroport);
		
		JLabel label = new JLabel("Gestion des a\u00E9roports");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(96, 83, 150));
		label.setFont(new Font("Segoe UI", Font.BOLD, 12));
		label.setBounds(56, 18, 134, 24);
		Button_Aeroport.add(label);
		
		 Button_Compagnie = new JPanel();
		 Button_Compagnie.addMouseListener(new MouseAdapter() {
			 @Override
				public void mouseClicked(MouseEvent e) {
					onClick(Button_Compagnie);
					onLeavClick(Button_Aeroport);
					onLeavClick(Button_Acceuil);
					
					GestionCompagnie obj = new GestionCompagnie();
					obj.setVisible(true);
		  			obj.setLocationRelativeTo(null);
		  			dispose();
					
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					onHover(Button_Compagnie);
					onLeaveHover(Button_Acceuil);
					onLeaveHover(Button_Aeroport);
					//onLeaveHover(Button_déconnexion);
				}
				public void mouseExited(MouseEvent e) {
					onLeaveHover(Button_Compagnie);
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					onLeavClick(Button_Compagnie);
				}
			});
		Button_Compagnie.setLayout(null);
		Button_Compagnie.setBackground(Color.WHITE);
		Button_Compagnie.setBounds(0, 215, 226, 60);
		panel.add(Button_Compagnie);
		
		JLabel label_1 = new JLabel("Gestion des compagnie ");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(new Color(181,77,180));
		label_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		label_1.setBounds(47, 11, 139, 24);
		Button_Compagnie.add(label_1);
		
		JLabel label_2 = new JLabel("a\u00E9riennes");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(new Color(181,77,180));
		label_2.setFont(new Font("Segoe UI", Font.BOLD, 12));
		label_2.setBounds(57, 36, 124, 13);
		Button_Compagnie.add(label_2);
		
		Button_liste_noir = new JPanel();
		Button_liste_noir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClick(Button_liste_noir);
				onLeavClick(Button_Aeroport);
				onLeavClick(Button_Compagnie);
				
				GestionListeNoir obj = new GestionListeNoir();
				obj.setVisible(true);
	  			obj.setLocationRelativeTo(null);
	  			dispose();
	  			}
			@Override
			public void mouseEntered(MouseEvent e) {
				onHover(Button_liste_noir);
				onLeaveHover(Button_Aeroport);
				onLeaveHover(Button_Compagnie);
			}
			public void mouseExited(MouseEvent e) {
				onLeaveHover(Button_liste_noir);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				onLeavClick(Button_liste_noir);
			}
		});
		Button_liste_noir.setLayout(null);
		Button_liste_noir.setBackground(Color.WHITE);
		Button_liste_noir.setBounds(0, 277, 226, 60);
		panel.add(Button_liste_noir);
		
		JLabel label_3 = new JLabel("Gestion de la liste  noire ");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(new Color(96, 83, 150));
		label_3.setFont(new Font("Segoe UI", Font.BOLD, 12));
		label_3.setBounds(47, 11, 136, 24);
		Button_liste_noir.add(label_3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(247,247,247));
		panel_3.setBounds(214, 0, 796, 500);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblWelcomBack = new JLabel("Gestion des Compagnie aeriennes");
		lblWelcomBack.setHorizontalAlignment(SwingConstants.LEFT);
		lblWelcomBack.setForeground(new Color(96, 83, 150));
		lblWelcomBack.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblWelcomBack.setBounds(20, 11, 414, 24);
		panel_3.add(lblWelcomBack);
		
		JLabel lblPayment = new JLabel("Nombre d'aeroport");
		lblPayment.setHorizontalAlignment(SwingConstants.LEFT);
		lblPayment.setForeground(new Color(96, 83, 150));
		lblPayment.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblPayment.setBounds(421, 46, 128, 20);
		panel_3.add(lblPayment);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBounds(413, 80, 136, 67);
		panel_3.add(panel_7);
		
		txtnbr = new JLabel("");
		txtnbr.setHorizontalAlignment(SwingConstants.LEFT);
		txtnbr.setForeground(new Color(96, 83, 150));
		txtnbr.setFont(new Font("Segoe UI", Font.BOLD, 24));
		txtnbr.setBounds(20, 20, 74, 25);
		panel_7.add(txtnbr);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(384, 158, 390, 331);
		panel_3.add(scrollPane_1);
		
		DefaultTableModel model = new DefaultTableModel();
		table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int ligne = table.getSelectedRow();
				   txtID.setText(table.getModel().getValueAt(ligne,0).toString());
				   txtNomCompagnie.setText(table.getModel().getValueAt(ligne,1).toString());
				   txtSite.setText(table.getModel().getValueAt(ligne,2).toString());
				   txtEmail.setText(table.getModel().getValueAt(ligne,3).toString());
				   txtNumTel.setText(table.getModel().getValueAt(ligne,4).toString());				  
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
		
		txtID = new JTextField();
		txtID.setColumns(10);
		txtID.setBounds(131, 146, 196, 20);
		panel_3.add(txtID);
		
		JLabel lblID = new JLabel("ID");
		lblID.setForeground(new Color(96, 83, 150));
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblID.setBounds(36, 140, 85, 24);
		panel_3.add(lblID);
		
		JLabel lblNomCompagnie = new JLabel("Nom compagnie");
		lblNomCompagnie.setForeground(new Color(96, 83, 150));
		lblNomCompagnie.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNomCompagnie.setBounds(20, 194, 169, 24);
		panel_3.add(lblNomCompagnie);
		
		JButton button = new JButton("Ajouter");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtID.getText().equals("")||txtEmail.getText().equals("")||txtnbr.getText().equals("")||txtNomCompagnie.getText().equals("")||txtNumTel.getText().equals("")||txtSite.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Veuiller remplir tout les champs");
				}else {
					try {
				compagnie = new Compagnie(txtID.getText(), txtNomCompagnie.getText(),txtSite.getText(),txtEmail.getText(), txtNumTel.getText());
				compagnie.AjouterCompagnie();
			   update_table(table);	
			   scrollPane_1.setViewportView(table);
			   Nbr(txtnbr);
					}catch (Exception e5) {
						JOptionPane.showMessageDialog(null, "Veuiller remplir tout les champ comme il se doit");
					}
			}
			}
		});
		
		button.setBackground(new Color(126, 87, 194));
		button.setBounds(30, 441, 108, 34);
		panel_3.add(button);
		
		
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtID.getText().equals("")||txtEmail.getText().equals("")||txtnbr.getText().equals("")||txtNomCompagnie.getText().equals("")||txtNumTel.getText().equals("")||txtSite.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Veuiller remplir tout les champs");
				}else {
					try {
				int ligne = table.getSelectedRow();
				String id = table.getModel().getValueAt(ligne,0).toString();
				compagnie = new Compagnie(txtID.getText(), txtNomCompagnie.getText(),txtSite.getText(),txtEmail.getText(), txtNumTel.getText());
				compagnie.Modifier();
			    update_table(table);
			    scrollPane_1.setViewportView(table);
					}catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Veuiller remplir tout les champ comme il se doit");
					}
			}
			}
		});
		btnModifier.setBackground(new Color(126, 87, 194));
		btnModifier.setBounds(148, 441, 108, 34);
		panel_3.add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtID.getText().equals("")||txtEmail.getText().equals("")||txtnbr.getText().equals("")||txtNomCompagnie.getText().equals("")||txtNumTel.getText().equals("")||txtSite.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Veuiller remplir tout les champs");
				}else {
					try {
				int ligne = table.getSelectedRow();
				String id = table.getModel().getValueAt(ligne,0).toString();
				compagnie = new Compagnie(id, txtNomCompagnie.getText(),txtSite.getText(),txtEmail.getText(), txtNumTel.getText());
				compagnie.Supprimer();	
				update_table(table);
				scrollPane_1.setViewportView(table);
				Nbr(txtnbr);
					}catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Veuiller remplir tout les champ comme il se doit");
					}
			}
			}
		});
		btnSupprimer.setBackground(new Color(126, 87, 194));
		btnSupprimer.setBounds(266, 441, 108, 34);
		panel_3.add(btnSupprimer);
		
		
		JLabel lblSite = new JLabel("Site");
		lblSite.setForeground(new Color(96, 83, 150));
		lblSite.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblSite.setBounds(26, 243, 96, 24);
		panel_3.add(lblSite);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(96, 83, 150));
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblEmail.setBounds(26, 301, 96, 24);
		panel_3.add(lblEmail);
		
		txtSite = new JTextField();
		txtSite.setColumns(10);
		txtSite.setBounds(138, 249, 196, 20);
		panel_3.add(txtSite);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(138, 307, 196, 20);
		panel_3.add(txtEmail);
		
		JLabel lblNumTel = new JLabel("NumTel");
		lblNumTel.setBounds(26, 361, 46, 14);
		panel_3.add(lblNumTel);
		
		txtNumTel = new JTextField();
		txtNumTel.setBounds(148, 358, 185, 20);
		panel_3.add(txtNumTel);
		txtNumTel.setColumns(10);
		
		Nbr(txtnbr);
		
		txtNomCompagnie = new JTextField();
		txtNomCompagnie.setBounds(170, 200, 157, 20);
		panel_3.add(txtNomCompagnie);
		txtNomCompagnie.setColumns(10);
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
				String sql = "SELECT * FROM compagnie";

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
		
		 private void Nbr(JLabel txtnbr) {
			Connection cnx = null;
	    	PreparedStatement requete = null ;
	    	ResultSet resultat = null ;
			
			
			cnx = ConnexionMySQL.connectDB();	
			String sql = "SELECT COUNT(*) FROM Compagnie ";

			try {
				requete = cnx.prepareStatement(sql);
				resultat = requete.executeQuery();
				while(resultat.next()) {
					String nbr = resultat.getString("COUNT(*)");
					
					txtnbr.setText(nbr);				
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
