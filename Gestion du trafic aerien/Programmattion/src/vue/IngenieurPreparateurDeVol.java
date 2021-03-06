package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modele.ConnexionMySQL;
import modele.Piste;
import modele.Statistique;
import modele.Vol;
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
import javax.swing.ScrollPaneConstants;

public class IngenieurPreparateurDeVol extends JFrame {

	private JPanel contentPane;
	private static JTable table_1;
	private static JTable table_2;
	private JPanel Button_Affichage;
	private JPanel Button_Vol;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IngenieurPreparateurDeVol frame = new IngenieurPreparateurDeVol();
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
		
	public IngenieurPreparateurDeVol() {
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
		JPanel Button_d?connexion = new JPanel();
	     Button_Vol = new JPanel();

		
		Button_Acceuil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClick(Button_Acceuil);
				onLeavClick(Button_Vol);
				
								}
			@Override
			public void mouseEntered(MouseEvent e) {
				onHover(Button_Acceuil);
				//onLeaveHover(Button_d?connexion);
				onLeaveHover(Button_Vol);
				
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
		
		
		Button_Vol.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClick(Button_Vol);
				onLeavClick(Button_Acceuil);
				onLeavClick(Button_Affichage);
				
				
				
				GestionVol obj = new GestionVol();
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
		Button_Vol.setBounds(0, 156, 226, 60);
		panel.add(Button_Vol);
		
		JLabel lblMail = new JLabel("Gestion des vols");
		lblMail.setHorizontalAlignment(SwingConstants.CENTER);
		lblMail.setForeground(new Color(96,83,150));
		lblMail.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblMail.setBounds(56, 18, 134, 24);
		Button_Vol.add(lblMail);
		
		Button_d?connexion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//onClick(Button_d?connexion);
				
				onLeavClick(Button_Vol);
				onLeavClick(Button_Acceuil);
				
				
				 authentification obj = new authentification();
					obj.setVisible(true);
					obj.setLocationRelativeTo(null);
					dispose();
					}
			@Override
			public void mouseEntered(MouseEvent e) {
				
				Button_d?connexion.setBackground(Color.DARK_GRAY);
				onLeaveHover(Button_Acceuil);
				onLeaveHover(Button_Vol);
				
			}public void mouseExited(MouseEvent e) {
				Button_d?connexion.setBackground(Color.RED);
			}
			
			
		});
		Button_d?connexion.setLayout(null);
		Button_d?connexion.setBackground(Color.RED);
		Button_d?connexion.setBounds(0, 429, 226, 60);
		panel.add(Button_d?connexion);
		
		JLabel lblTaskView = new JLabel("d\u00E9connexion");
		lblTaskView.setHorizontalAlignment(SwingConstants.CENTER);
		lblTaskView.setForeground(Color.WHITE);
		lblTaskView.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblTaskView.setBounds(56, 18, 123, 24);
		Button_d?connexion.add(lblTaskView);
		
		Button_Affichage = new JPanel();
		Button_Affichage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				onClick(Button_Affichage);
			
				onLeavClick(Button_Acceuil);
				onLeavClick(Button_Vol);
				
				
				
				AffichageVol obj = new AffichageVol();
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
		Button_Affichage.setBounds(0, 216, 226, 60);
		panel.add(Button_Affichage);
		
		JLabel lblAffichageVol = new JLabel("Affichage vol");
		lblAffichageVol.setHorizontalAlignment(SwingConstants.CENTER);
		lblAffichageVol.setForeground(new Color(96, 83, 150));
		lblAffichageVol.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblAffichageVol.setBounds(56, 18, 134, 24);
		Button_Affichage.add(lblAffichageVol);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(247,247,247));
		panel_3.setBounds(236, 0, 774, 500);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblWelcomBack = new JLabel("Ingenieur preparateur de vol");
		lblWelcomBack.setHorizontalAlignment(SwingConstants.LEFT);
		lblWelcomBack.setForeground(new Color(96, 83, 150));
		lblWelcomBack.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblWelcomBack.setBounds(20, 11, 414, 24);
		panel_3.add(lblWelcomBack);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(45, 115, 136, 67);
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel label = new JLabel(Integer.toString(Piste.listePiste().size()));
		label.setBounds(20, 20, 74, 25);
		panel_4.add(label);
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setForeground(new Color(96, 83, 150));
		label.setFont(new Font("Segoe UI", Font.BOLD, 24));
		
		JLabel lblCompletProjetct = new JLabel("Pistes");
		lblCompletProjetct.setHorizontalAlignment(SwingConstants.LEFT);
		lblCompletProjetct.setForeground(new Color(96, 83, 150));
		lblCompletProjetct.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblCompletProjetct.setBounds(53, 81, 120, 20);
		panel_3.add(lblCompletProjetct);
		
		JLabel lblHoursWorks = new JLabel("Voles");
		lblHoursWorks.setHorizontalAlignment(SwingConstants.LEFT);
		lblHoursWorks.setForeground(new Color(96, 83, 150));
		lblHoursWorks.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblHoursWorks.setBounds(233, 81, 120, 20);
		panel_3.add(lblHoursWorks);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBounds(225, 115, 136, 67);
		panel_3.add(panel_6);
		
		JLabel label_2 = new JLabel(Integer.toString(Vol.listeVol().size()));
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setForeground(new Color(96, 83, 150));
		label_2.setFont(new Font("Segoe UI", Font.BOLD, 24));
		label_2.setBounds(20, 20, 74, 25);
		panel_6.add(label_2);
		
		JLabel lblPayment = new JLabel("decollage");
		lblPayment.setHorizontalAlignment(SwingConstants.LEFT);
		lblPayment.setForeground(new Color(96, 83, 150));
		lblPayment.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblPayment.setBounds(421, 81, 120, 20);
		panel_3.add(lblPayment);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBounds(413, 115, 136, 67);
		panel_3.add(panel_7);
		
		JLabel label_3 = new JLabel(Integer.toString(Statistique.listeDecollage().size()));
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setForeground(new Color(96, 83, 150));
		label_3.setFont(new Font("Segoe UI", Font.BOLD, 24));
		label_3.setBounds(20, 20, 74, 25);
		panel_7.add(label_3);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBounds(596, 115, 136, 67);
		panel_3.add(panel_5);
		
		JLabel label_1 = new JLabel(Integer.toString(Statistique.listeAtterrissage().size()));
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setForeground(new Color(96, 83, 150));
		label_1.setFont(new Font("Segoe UI", Font.BOLD, 24));
		label_1.setBounds(20, 20, 74, 25);
		panel_5.add(label_1);
		
		JLabel lblAtterrissage = new JLabel("Atterrissage");
		lblAtterrissage.setHorizontalAlignment(SwingConstants.LEFT);
		lblAtterrissage.setForeground(new Color(96, 83, 150));
		lblAtterrissage.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblAtterrissage.setBounds(604, 81, 120, 20);
		panel_3.add(lblAtterrissage);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(45, 193, 319, 307);
		panel_3.add(scrollPane_1);
		
		DefaultTableModel model_1 = new DefaultTableModel();
		table_1 = new JTable(model_1);
		table_1.setSelectionBackground(new Color(96, 83, 150));
		table_1.setRowHeight(20);
		table_1.setGridColor(new Color(247, 247, 247));
		table_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		table_1.setBorder(null);
		table_1.setBackground(new Color(247, 247, 247));
		update_table_Vol(table_1);
		scrollPane_1.setViewportView(table_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(421, 193, 312, 307);
		panel_3.add(scrollPane_2);
		
		table_2 = new JTable();
		table_2.setSelectionBackground(new Color(96, 83, 150));
		table_2.setRowHeight(20);
		table_2.setGridColor(new Color(247, 247, 247));
		table_2.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		table_2.setBorder(null);
		table_2.setBackground(new Color(247, 247, 247));
		scrollPane_2.setViewportView(table_2);
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
    public void update_table_Vol(JTable table) {
    	  Connection cnx = null;
		   	PreparedStatement requete = null ;
		   	ResultSet resultat = null ;
			   
				cnx = ConnexionMySQL.connectDB();	
				String sql = "SELECT * FROM vol order by datedep ";

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
