package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modele.ConnexionMySQL;
import modele.Etat;
import modele.Piste;
import modele.PisteReserver;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;

public class GestionPiste extends JFrame {

	private JPanel contentPane;
	private Piste piste;
	private JPanel Button_Piste;
	private JPanel Button_affichage;
	private JScrollPane scrollPane;
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionPiste frame = new GestionPiste();
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
		
	public GestionPiste() {
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
				 ContrôleurAérien obj = new ContrôleurAérien();
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
		
		Button_Piste = new JPanel();
		Button_Piste.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClick(Button_Piste);
				onLeavClick(Button_Acceuil);
				onLeavClick(Button_affichage);
							
				PisteA obj = new PisteA();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				dispose();
				
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				onHover(Button_Piste);
				onLeaveHover(Button_affichage);
				onLeaveHover(Button_Acceuil);
			}
			public void mouseExited(MouseEvent e) {
				onLeaveHover(Button_Piste);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				onLeavClick(Button_Piste);
			}
		});
		Button_Piste.setLayout(null);
		Button_Piste.setBackground(Color.WHITE);
		Button_Piste.setBounds(0, 147, 226, 60);
		panel.add(Button_Piste);
		
		JLabel lblPiste = new JLabel("Pistes");
		lblPiste.setHorizontalAlignment(SwingConstants.CENTER);
		lblPiste.setForeground(new Color(96,83,150));
		lblPiste.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblPiste.setBounds(56, 18, 75, 24);
		Button_Piste.add(lblPiste);
		
		Button_affichage = new JPanel();
		Button_affichage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClick(Button_affichage);
				onLeavClick(Button_Piste);
				onLeavClick(Button_Acceuil);
				
				AffichagePiste obj = new AffichagePiste();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				dispose();	
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				onHover(Button_affichage);
				onLeaveHover(Button_Acceuil);
				onLeaveHover(Button_Piste);
				//onLeaveHover(Button_déconnexion);
			}
			public void mouseExited(MouseEvent e) {
				onLeaveHover(Button_affichage);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				onLeavClick(Button_affichage);
			}
		});
		Button_affichage.setLayout(null);
		Button_affichage.setBackground(Color.WHITE);
		Button_affichage.setBounds(0, 207, 226, 60);
		panel.add(Button_affichage);
		
		JLabel lblAffichage = new JLabel("Affichage");
		lblAffichage.setHorizontalAlignment(SwingConstants.CENTER);
		lblAffichage.setForeground(new Color(96,83,150));
		lblAffichage.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblAffichage.setBounds(56, 18, 75, 24);
		Button_affichage.add(lblAffichage);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(247,247,247));
		panel_3.setBounds(194, 0, 796, 500);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblWelcomBack = new JLabel("Gestion des pistes");
		lblWelcomBack.setHorizontalAlignment(SwingConstants.LEFT);
		lblWelcomBack.setForeground(new Color(96, 83, 150));
		lblWelcomBack.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblWelcomBack.setBounds(50, 11, 414, 24);
		panel_3.add(lblWelcomBack);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(74, 158, 390, 331);
		panel_3.add(scrollPane);
		
		DefaultTableModel model = new DefaultTableModel();
		
		table = new JTable(model);
		update_table_piste_reserver(table);
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(74, 80, 136, 67);
		panel_3.add(panel_1);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setForeground(new Color(96, 83, 150));
		label.setFont(new Font("Segoe UI", Font.BOLD, 24));
		label.setBounds(20, 20, 74, 25);
		panel_1.add(label);
		
		JLabel lblNombreDePiste = new JLabel("Nombre de piste reserver");
		lblNombreDePiste.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombreDePiste.setForeground(new Color(96, 83, 150));
		lblNombreDePiste.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNombreDePiste.setBounds(74, 49, 154, 20);
		panel_3.add(lblNombreDePiste);
		
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
    /*
    public void update_table_piste_reserver(JTable table){
		DefaultTableModel model = new DefaultTableModel();
		
		 model.setColumnIdentifiers(new String[]{"idPiste","Aeroport","date","heure"});
	        for (int i = 0; i < PisteReserver.listePisteReserver().size(); i++) {
				model.addRow(new String[] {Integer.toString(PisteReserver.listePisteReserver().get(i).getIdPiste())
						,PisteReserver.listePisteReserver().get(i).getAeroport().getIdAeroport()
						,PisteReserver.listePisteReserver().get(i).getDate(),
						PisteReserver.listePisteReserver().get(i).getHeure()});
			}
	        
	        table.setModel(model);
		
	}*/
    public void update_table_piste_reserver(JTable table) {
    	   Connection cnx = null;
		   	PreparedStatement requete = null ;
		   	ResultSet resultat = null ;
		   	ArrayList<PisteReserver> listePiste = new ArrayList<PisteReserver>();
			   
				cnx = ConnexionMySQL.connectDB();	
				String sql = "SELECT * FROM pistereserver";

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
}


