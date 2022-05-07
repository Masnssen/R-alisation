package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modele.ConnexionMySQL;
import modele.Statistique;
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

public class AnalysteDeVol extends JFrame {

	private JPanel contentPane;
	private JTable table_1;
	private JTable table_2;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnalysteDeVol frame = new AnalysteDeVol();
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
		
	public AnalysteDeVol() {
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
		JPanel Button_statistique = new JPanel();
		JPanel Button_Redevance = new JPanel();

		
		Button_Acceuil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClick(Button_Acceuil);
				onLeavClick(Button_Redevance);
				onLeavClick(Button_statistique);
				//onLeavClick(Button_déconnexion);	
			

								}
			@Override
			public void mouseEntered(MouseEvent e) {
				onHover(Button_Acceuil);
				//onLeaveHover(Button_déconnexion);
				onLeaveHover(Button_Redevance);
				onLeaveHover(Button_statistique);
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
		
		
		Button_Redevance.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClick(Button_Redevance);
				onLeavClick(Button_Acceuil);
				onLeavClick(Button_statistique);
			
				GestionRedevance obj = new GestionRedevance();
				obj.setVisible(true);
	  			obj.setLocationRelativeTo(null);
	  			dispose();
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				onHover(Button_Redevance);
				onLeaveHover(Button_statistique);
				onLeaveHover(Button_Acceuil);

			}
			public void mouseExited(MouseEvent e) {
				onLeaveHover(Button_Redevance);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				onLeavClick(Button_Redevance);
			}
		});
		Button_Redevance.setLayout(null);
		Button_Redevance.setBackground(Color.WHITE);
		Button_Redevance.setBounds(0, 156, 226, 60);
		panel.add(Button_Redevance);
		
		JLabel lblMail = new JLabel("Gestion des Redevances");
		lblMail.setHorizontalAlignment(SwingConstants.CENTER);
		lblMail.setForeground(new Color(96,83,150));
		lblMail.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblMail.setBounds(56, 18, 148, 24);
		Button_Redevance.add(lblMail);
		
		Button_statistique.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClick(Button_statistique);
				onLeavClick(Button_Redevance);
				onLeavClick(Button_Acceuil);
				
				GestionStatistique obj = new GestionStatistique();
				obj.setVisible(true);
	  			obj.setLocationRelativeTo(null);
	  			dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				onHover(Button_statistique);
				onLeaveHover(Button_Acceuil);
				onLeaveHover(Button_Redevance);
				//onLeaveHover(Button_déconnexion);
			}
			public void mouseExited(MouseEvent e) {
				onLeaveHover(Button_statistique);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				onLeavClick(Button_statistique);
			}
		});
		Button_statistique.setLayout(null);
		Button_statistique.setBackground(Color.WHITE);
		Button_statistique.setBounds(0, 227, 226, 60);
		panel.add(Button_statistique);
		
		JLabel lblPayeent = new JLabel("Gestion des statistiques ");
		lblPayeent.setHorizontalAlignment(SwingConstants.CENTER);
		lblPayeent.setForeground(new Color(96,83,150));
		lblPayeent.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblPayeent.setBounds(47, 11, 146, 24);
		Button_statistique.add(lblPayeent);
		
		Button_déconnexion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//onClick(Button_déconnexion);
				
				onLeavClick(Button_Redevance);
				onLeavClick(Button_statistique);
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
				onLeaveHover(Button_Redevance);
				onLeaveHover(Button_statistique);
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
		panel_3.setBounds(221, 0, 789, 500);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblWelcomBack = new JLabel("Analyste de vol");
		lblWelcomBack.setHorizontalAlignment(SwingConstants.LEFT);
		lblWelcomBack.setForeground(new Color(96, 83, 150));
		lblWelcomBack.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblWelcomBack.setBounds(20, 11, 414, 24);
		panel_3.add(lblWelcomBack);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(45, 115, 136, 67);
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel label = new JLabel(Double.toString(montant_payer()));
		label.setBounds(10, 20, 116, 25);
		panel_4.add(label);
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setForeground(new Color(96, 83, 150));
		label.setFont(new Font("Segoe UI", Font.BOLD, 24));
		
		JLabel lblCompletProjetct = new JLabel("Prix redevance payer");
		lblCompletProjetct.setHorizontalAlignment(SwingConstants.LEFT);
		lblCompletProjetct.setForeground(new Color(96, 83, 150));
		lblCompletProjetct.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblCompletProjetct.setBounds(53, 81, 120, 20);
		panel_3.add(lblCompletProjetct);
		
		JLabel lblHoursWorks = new JLabel("Prix redevance non payer");
		lblHoursWorks.setHorizontalAlignment(SwingConstants.LEFT);
		lblHoursWorks.setForeground(new Color(96, 83, 150));
		lblHoursWorks.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblHoursWorks.setBounds(233, 81, 142, 20);
		panel_3.add(lblHoursWorks);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBounds(225, 115, 136, 67);
		panel_3.add(panel_6);
		
		JLabel label_2 = new JLabel(Double.toString(montant_non_payer()));
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setForeground(new Color(96, 83, 150));
		label_2.setFont(new Font("Segoe UI", Font.BOLD, 24));
		label_2.setBounds(10, 20, 116, 25);
		panel_6.add(label_2);
		
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
		
		table_2 = new JTable();
		table_2.setSelectionBackground(new Color(96, 83, 150));
		table_2.setRowHeight(20);
		table_2.setGridColor(new Color(247, 247, 247));
		table_2.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		table_2.setBorder(null);
		table_2.setBackground(new Color(247, 247, 247));
		scrollPane_1.setViewportView(table_2);
		
		update_table_redevance(table_1);
		update_table_piste_danse(table_2);
		
		JLabel lblPistePlusDanse = new JLabel("Piste plus danse");
		lblPistePlusDanse.setHorizontalAlignment(SwingConstants.LEFT);
		lblPistePlusDanse.setForeground(new Color(96, 83, 150));
		lblPistePlusDanse.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblPistePlusDanse.setBounds(421, 137, 235, 25);
		panel_3.add(lblPistePlusDanse);
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
    public void update_table_redevance(JTable table) {
    	Connection cnx = null;
	   	PreparedStatement requete = null ;
	   	ResultSet resultat = null ;
		   
			cnx = ConnexionMySQL.connectDB();	
			String sql = "SELECT * FROM Redevance order by compagnie";

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
 public double montant_non_payer() {
		
    	double somme = 0;
    	Connection cnx = null;
	   	PreparedStatement requete = null ;
	   	ResultSet resultat = null ;
		   
			cnx = ConnexionMySQL.connectDB();	
			String sql = "select sum(prix) FROM Redevance where payer=1 order by compagnie";

			try {
				requete = cnx.prepareStatement(sql);
				resultat = requete.executeQuery();
				while(resultat.next()) {
					somme = resultat.getDouble("sum(prix)");
				}
     			requete.close();
				cnx.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return somme;
	}
    public double montant_payer() {
		
    	double somme = 0;
    	Connection cnx = null;
	   	PreparedStatement requete = null ;
	   	ResultSet resultat = null ;
		   
			cnx = ConnexionMySQL.connectDB();	
			String sql = "select sum(prix) FROM Redevance where payer=0 order by compagnie";

			try {
				requete = cnx.prepareStatement(sql);
				resultat = requete.executeQuery();
				while(resultat.next()) {
					somme = resultat.getDouble("sum(prix)");
				}
     			requete.close();
				cnx.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return somme;
	}
    public void update_table_piste_danse(JTable table) {
    	DefaultTableModel model = new DefaultTableModel();
        Statistique statistique = new Statistique();
		
		 model.setColumnIdentifiers(new String[]{"IDPISTE","LONGEUR","idAeroport"});
	        for (int i = 0; i <statistique.getPisteDense().length;i++) {
	        		model.addRow(new String[] {Integer.toString(statistique.getPisteDense()[i].getIdPiste()),
	        				Double.toString(statistique.getPisteDense()[i].getLongeur()),
	        				statistique.getPisteDense()[i].getAeroport().getIdAeroport()});
				}
	        
	        table.setModel(model);
	}
}
