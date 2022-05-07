package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modele.ConnexionMySQL;
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

import javax.swing.JScrollPane;

public class IngénieurOpérationDeVol extends JFrame {

	private JPanel contentPane;
	private JTable table_1;
	private JTable table;
	private JPanel Button_fonction;
	private JPanel Button_Membre;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IngénieurOpérationDeVol frame = new IngénieurOpérationDeVol();
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
		
	public IngénieurOpérationDeVol() {
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
		JPanel Button_Equipage = new JPanel();
		JPanel Button_Aeronef = new JPanel();

		
		Button_Acceuil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClick(Button_Acceuil);
				onLeavClick(Button_Aeronef);
				onLeavClick(Button_Equipage);
				
			
	  			}
			@Override
			public void mouseEntered(MouseEvent e) {
				onHover(Button_Acceuil);
				onLeaveHover(Button_Aeronef);
				onLeaveHover(Button_Equipage);
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
		
		
		Button_Aeronef.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClick(Button_Aeronef);
				onLeavClick(Button_Acceuil);
				onLeavClick(Button_Equipage);
				onLeavClick(Button_fonction);
				
			
				GestionAeronef obj = new GestionAeronef();
				obj.setVisible(true);
	  			obj.setLocationRelativeTo(null);
	  			dispose();
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				onHover(Button_Aeronef);
				onLeaveHover(Button_Equipage);
				
				onLeaveHover(Button_Acceuil);

			}
			public void mouseExited(MouseEvent e) {
				onLeaveHover(Button_Aeronef);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				onLeavClick(Button_Aeronef);
			}
		});
		Button_Aeronef.setLayout(null);
		Button_Aeronef.setBackground(Color.WHITE);
		Button_Aeronef.setBounds(0, 156, 226, 60);
		panel.add(Button_Aeronef);
		
		JLabel lblMail = new JLabel("Gestion des aeronefs");
		lblMail.setHorizontalAlignment(SwingConstants.CENTER);
		lblMail.setForeground(new Color(96,83,150));
		lblMail.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblMail.setBounds(56, 18, 134, 24);
		Button_Aeronef.add(lblMail);
		
		Button_Equipage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClick(Button_Equipage);
				onLeavClick(Button_Aeronef);
				onLeavClick(Button_Acceuil);
				onLeavClick(Button_fonction);
				
				Gestion_Equipage obj = new Gestion_Equipage();
				obj.setVisible(true);
	  			obj.setLocationRelativeTo(null);
	  			dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				onHover(Button_Equipage);
				onLeaveHover(Button_Acceuil);
				onLeaveHover(Button_Aeronef);
				
			}
			public void mouseExited(MouseEvent e) {
				onLeaveHover(Button_Equipage);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				onLeavClick(Button_Equipage);
			}
		});
		Button_Equipage.setLayout(null);
		Button_Equipage.setBackground(Color.WHITE);
		Button_Equipage.setBounds(0, 227, 226, 60);
		panel.add(Button_Equipage);
		
		JLabel lblPayeent = new JLabel("Gestion des equipages");
		lblPayeent.setHorizontalAlignment(SwingConstants.CENTER);
		lblPayeent.setForeground(new Color(96,83,150));
		lblPayeent.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblPayeent.setBounds(47, 11, 139, 24);
		Button_Equipage.add(lblPayeent);
		
		Button_déconnexion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//onClick(Button_déconnexion);
				
				onLeavClick(Button_Aeronef);
				onLeavClick(Button_Equipage);
				onLeavClick(Button_Acceuil);
				
				
				 authentification obj = new authentification();
					obj.setVisible(true);
					obj.setLocationRelativeTo(null);
					dispose();
					}
			@Override
			public void mouseEntered(MouseEvent e) {
				//onHover(Button_déconnexion);
				Button_déconnexion.setBackground(Color.DARK_GRAY);
				onLeaveHover(Button_Acceuil);
				onLeaveHover(Button_Aeronef);
				onLeaveHover(Button_Equipage);
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
		
	 Button_fonction = new JPanel();
		Button_fonction.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClick(Button_Equipage);
				onLeavClick(Button_Aeronef);
				onLeavClick(Button_Acceuil);
				
				GestionFonction obj = new GestionFonction();
				obj.setVisible(true);
	  			obj.setLocationRelativeTo(null);
	  			dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				onHover(Button_fonction);
				onLeaveHover(Button_Equipage);
				onLeaveHover(Button_Acceuil);
				onLeaveHover(Button_Aeronef);
				
			}
			public void mouseExited(MouseEvent e) {
				onLeaveHover(Button_fonction);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				onLeavClick(Button_fonction);
			}
		});
		Button_fonction.setLayout(null);
		Button_fonction.setBackground(Color.WHITE);
		Button_fonction.setBounds(0, 288, 226, 60);
		panel.add(Button_fonction);
		
		JLabel lblGestionDesFonctions = new JLabel("Gestion des Fonctions");
		lblGestionDesFonctions.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionDesFonctions.setForeground(new Color(96, 83, 150));
		lblGestionDesFonctions.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblGestionDesFonctions.setBounds(47, 11, 139, 24);
		Button_fonction.add(lblGestionDesFonctions);
		
		Button_Membre = new JPanel();
		Button_Membre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClick(Button_Membre);
				onLeavClick(Button_Aeronef);
				onLeavClick(Button_Acceuil);
				onLeavClick(Button_Equipage);
				onLeavClick(Button_fonction);
				
			
				GestionMembre obj = new GestionMembre();
				obj.setVisible(true);
	  			obj.setLocationRelativeTo(null);
	  			dispose();
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				onHover(Button_Aeronef);
				onLeaveHover(Button_Equipage);
				
				onLeaveHover(Button_Acceuil);

			}
			public void mouseExited(MouseEvent e) {
				onLeaveHover(Button_Aeronef);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				onLeavClick(Button_Aeronef);
			}
		});
		Button_Membre.setLayout(null);
		Button_Membre.setBackground(Color.WHITE);
		Button_Membre.setBounds(0, 347, 226, 60);
		panel.add(Button_Membre);
		
		JLabel lblGestionDesMembres = new JLabel("Gestion des Membres");
		lblGestionDesMembres.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionDesMembres.setForeground(new Color(96, 83, 150));
		lblGestionDesMembres.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblGestionDesMembres.setBounds(47, 11, 139, 24);
		Button_Membre.add(lblGestionDesMembres);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(247,247,247));
		panel_3.setBounds(236, 0, 774, 500);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblWelcomBack = new JLabel("Ing\u00E9nieur op\u00E9ration de vol");
		lblWelcomBack.setHorizontalAlignment(SwingConstants.LEFT);
		lblWelcomBack.setForeground(new Color(96, 83, 150));
		lblWelcomBack.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblWelcomBack.setBounds(20, 11, 414, 24);
		panel_3.add(lblWelcomBack);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(45, 115, 136, 67);
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel label = new JLabel("500");
		label.setBounds(20, 20, 74, 25);
		panel_4.add(label);
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setForeground(new Color(96, 83, 150));
		label.setFont(new Font("Segoe UI", Font.BOLD, 24));
		
		JLabel lblCompletProjetct = new JLabel("Nombre aeronef");
		lblCompletProjetct.setHorizontalAlignment(SwingConstants.LEFT);
		lblCompletProjetct.setForeground(new Color(96, 83, 150));
		lblCompletProjetct.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblCompletProjetct.setBounds(53, 81, 120, 20);
		panel_3.add(lblCompletProjetct);
		
		JLabel lblPayment = new JLabel("Nombre d'equipage");
		lblPayment.setHorizontalAlignment(SwingConstants.LEFT);
		lblPayment.setForeground(new Color(96, 83, 150));
		lblPayment.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblPayment.setBounds(421, 81, 120, 20);
		panel_3.add(lblPayment);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBounds(413, 115, 136, 67);
		panel_3.add(panel_7);
		
		JLabel lblequipage = new JLabel("");
		lblequipage.setHorizontalAlignment(SwingConstants.LEFT);
		lblequipage.setForeground(new Color(96, 83, 150));
		lblequipage.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblequipage.setBounds(20, 20, 74, 25);
		panel_7.add(lblequipage);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBounds(596, 115, 136, 67);
		panel_3.add(panel_5);
		
		JLabel lblmembre = new JLabel("");
		lblmembre.setHorizontalAlignment(SwingConstants.LEFT);
		lblmembre.setForeground(new Color(96, 83, 150));
		lblmembre.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblmembre.setBounds(20, 20, 74, 25);
		panel_5.add(lblmembre);
		
		JLabel lblNombreDeMembre = new JLabel("Nombre de membre");
		lblNombreDeMembre.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombreDeMembre.setForeground(new Color(96, 83, 150));
		lblNombreDeMembre.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNombreDeMembre.setBounds(604, 81, 120, 20);
		panel_3.add(lblNombreDeMembre);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 193, 319, 307);
		panel_3.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setSelectionBackground(new Color(96, 83, 150));
		table_1.setRowHeight(20);
		table_1.setGridColor(new Color(247, 247, 247));
		table_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		table_1.setBorder(null);
		table_1.setBackground(new Color(247, 247, 247));
		scrollPane.setViewportView(table_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(421, 193, 312, 307);
		panel_3.add(scrollPane_1);
		
		table = new JTable();
		table.setSelectionBackground(new Color(96, 83, 150));
		table.setRowHeight(20);
		table.setGridColor(new Color(247, 247, 247));
		table.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		table.setBorder(null);
		table.setBackground(new Color(247, 247, 247));
		scrollPane_1.setViewportView(table);
		
		update_table_aeronef(table_1);
		Nbr_aeronef(label);
		update_table_membre(table);
		Nbr_membre(lblmembre);
		Nbr_equipage(lblequipage);
		
		
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
    public void update_table_aeronef(JTable table) {
		 Connection cnx = null;
		   	PreparedStatement requete = null ;
		   	ResultSet resultat = null ;
			   
				cnx = ConnexionMySQL.connectDB();	
				String sql = "SELECT * FROM aeronef";

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
    private void Nbr_aeronef(JLabel txtnbr) {
		Connection cnx = null;
    	PreparedStatement requete = null ;
    	ResultSet resultat = null ;
		
		
		cnx = ConnexionMySQL.connectDB();	
		String sql = "SELECT COUNT(*) FROM Aeronef ";

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
    public void update_table_membre(JTable table) {
	    Connection cnx = null;
    	PreparedStatement requete = null ;
    	ResultSet resultat = null ;
		cnx = ConnexionMySQL.connectDB();	
		String sql = "SELECT * FROM MEMBRE";

		try {
			requete = cnx.prepareStatement(sql);
			resultat = requete.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(resultat));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
		
		 private void Nbr_membre(JLabel txtnbr) {
			Connection cnx = null;
	    	PreparedStatement requete = null ;
	    	ResultSet resultat = null ;
			
			
			cnx = ConnexionMySQL.connectDB();	
			String sql = "SELECT COUNT(*) FROM MEMBRE ";

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
		 private void Nbr_equipage(JLabel txtnbr) {
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
