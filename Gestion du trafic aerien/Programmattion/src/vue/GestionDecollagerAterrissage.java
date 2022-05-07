package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modele.ConnexionMySQL;
import modele.Vol;
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

public class GestionDecollagerAterrissage extends JFrame {

	private JPanel contentPane;
	private JTable table_Decollage;
	private Compagnie compagnie;
	private JTable table_Aterrissage;
	private JPanel Button_Vol;
	private JPanel Button_Affichage;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionDecollagerAterrissage frame = new GestionDecollagerAterrissage();
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
		
	public GestionDecollagerAterrissage() {
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

				CoordinateuDeVol obj = new CoordinateuDeVol();
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
		
		Button_Affichage = new JPanel();
		Button_Affichage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				onClick(Button_Affichage);
			
				onLeavClick(Button_Acceuil);
				onLeavClick(Button_Vol);
				
				
				
				GestionDecollagerAterrissage obj = new GestionDecollagerAterrissage();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				dispose();
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				onHover(Button_Affichage);
				
				onLeaveHover(Button_Acceuil);
				onLeaveHover(Button_Vol);
				
				

			}
			public void mouseExited(MouseEvent e) {
				onLeaveHover(Button_Affichage);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				onLeavClick(Button_Affichage);
			}
		});
		Button_Affichage.setLayout(null);
		Button_Affichage.setBackground(Color.WHITE);
		Button_Affichage.setBounds(0, 204, 226, 60);
		panel.add(Button_Affichage);
		
		JLabel label = new JLabel("Affichage des demandes");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(181,77,180));
		label.setFont(new Font("Segoe UI", Font.BOLD, 12));
		label.setBounds(56, 18, 149, 24);
		Button_Affichage.add(label);
		
		 Button_Vol = new JPanel();
		 Button_Vol.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					onClick(Button_Vol);
					onLeavClick(Button_Acceuil);
					onLeavClick(Button_Affichage);
					
					
					
					GestionDemandeAtterrissageDecollage obj = new GestionDemandeAtterrissageDecollage();
					obj.setVisible(true);
					obj.setLocationRelativeTo(null);
					dispose();
					
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					onHover(Button_Vol);
					
					onLeaveHover(Button_Acceuil);
					onLeaveHover(Button_Affichage);
					
					

				}
				public void mouseExited(MouseEvent e) {
					onLeaveHover(Button_Vol);
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					onLeavClick(Button_Vol);
				}
			});
		Button_Vol.setLayout(null);
		Button_Vol.setBackground(Color.WHITE);
		Button_Vol.setBounds(0, 144, 226, 60);
		panel.add(Button_Vol);
		
		JLabel label_1 = new JLabel("Gestion des demandes de vol");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(new Color(96, 83, 150));
		label_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		label_1.setBounds(25, 18, 191, 24);
		Button_Vol.add(label_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(247,247,247));
		panel_3.setBounds(214, 0, 796, 500);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblWelcomBack = new JLabel("Affichage des Decollage et Aterrissage");
		lblWelcomBack.setHorizontalAlignment(SwingConstants.LEFT);
		lblWelcomBack.setForeground(new Color(96, 83, 150));
		lblWelcomBack.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblWelcomBack.setBounds(20, 11, 414, 24);
		panel_3.add(lblWelcomBack);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 57, 766, 200);
		panel_3.add(scrollPane_1);
		
		table_Decollage = new JTable();
		table_Decollage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
						  
			}
		});
		table_Decollage.setSelectionBackground(new Color(96, 83, 150));
		table_Decollage.setRowHeight(20);
		table_Decollage.setGridColor(new Color(247, 247, 247));
		table_Decollage.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		table_Decollage.setBorder(null);
		table_Decollage.setBackground(new Color(247, 247, 247));
		scrollPane_1.setViewportView(table_Decollage);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 268, 766, 221);
		panel_3.add(scrollPane);
		
		table_Aterrissage = new JTable();
		table_Aterrissage.setSelectionBackground(new Color(96, 83, 150));
		table_Aterrissage.setRowHeight(20);
		table_Aterrissage.setGridColor(new Color(247, 247, 247));
		table_Aterrissage.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		table_Aterrissage.setBorder(null);
		table_Aterrissage.setBackground(new Color(247, 247, 247));
		scrollPane.setViewportView(table_Aterrissage);
		boolean rafrichir = true;
	
		update_table_decollage(table_Decollage);
		update_table_Atterissage(table_Aterrissage);
	
			
		
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
    public void update_table_decollage(JTable table) {
	 
    	 Connection cnx = null;
     	PreparedStatement requete = null ;
     	ResultSet resultat = null ;
 		cnx = ConnexionMySQL.connectDB();	
 		String sql = "SELECT idVol,dateDep,HEUREDEPART,dateArriver, HEUREARRIVER,('decollage') 'type' FROM `vol` WHERE dateDep = CURRENT_DATE and HEUREDEPART > SUBTIME(CURRENT_TIME,'1800') and HEUREDEPART < CURRENT_TIME";

 		try {
 			requete = cnx.prepareStatement(sql);
 			resultat = requete.executeQuery();
 			table.setModel(DbUtils.resultSetToTableModel(resultat));
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}	
    }
    public void update_table_Atterissage(JTable table) {
   	 
   	 Connection cnx = null;
    	PreparedStatement requete = null ;
    	ResultSet resultat = null ;
		cnx = ConnexionMySQL.connectDB();	
		String sql = "SELECT idVol,dateDep,HEUREDEPART,dateArriver, HEUREARRIVER,('decollage') 'type' FROM `vol` WHERE dateArriver = CURRENT_DATE and HEUREARRIVER > SUBTIME(CURRENT_TIME,'1800') and HEUREARRIVER < CURRENT_TIME";

		try {
			requete = cnx.prepareStatement(sql);
			resultat = requete.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(resultat));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
   }
}
	
