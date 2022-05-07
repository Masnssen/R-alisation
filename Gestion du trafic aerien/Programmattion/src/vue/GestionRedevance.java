package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modele.ConnexionMySQL;
import modele.Redevance;
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
import java.text.DecimalFormat;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;

public class GestionRedevance extends JFrame {

	private JPanel contentPane;
	private static JTable table_1;
	private JScrollPane scrollPane;	
	private JLabel lblNbr;
	private JTable table_2;
	private static JLabel lbl_payer ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionRedevance frame = new GestionRedevance();
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
		
	public GestionRedevance() {
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
		JPanel Button_Redevance = new JPanel();
		JPanel Button_Payer_Redevance = new JPanel();

		
		Button_Acceuil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClick(Button_Acceuil);
				onLeavClick(Button_Payer_Redevance);
				onLeavClick(Button_Redevance);
				
				AnalysteDeVol obj = new AnalysteDeVol();
				obj.setVisible(true);
	  			obj.setLocationRelativeTo(null);
	  			dispose();
				
								}
			@Override
			public void mouseEntered(MouseEvent e) {
				onHover(Button_Acceuil);
				//onLeaveHover(Button_déconnexion);
				onLeaveHover(Button_Payer_Redevance);
				onLeaveHover(Button_Redevance);
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
		lblaccueil.setForeground(new Color(96,83,150));
		lblaccueil.setHorizontalAlignment(SwingConstants.CENTER);
		lblaccueil.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblaccueil.setBounds(56, 18, 75, 24);
		Button_Acceuil.add(lblaccueil);
		
		
		Button_Payer_Redevance.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClick(Button_Payer_Redevance);
				onLeavClick(Button_Acceuil);
				onLeavClick(Button_Redevance);
			
				PayerRedevance obj = new PayerRedevance();
				obj.setVisible(true);
	  			obj.setLocationRelativeTo(null);
	  			dispose();
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				onHover(Button_Payer_Redevance);
				onLeaveHover(Button_Redevance);
				onLeaveHover(Button_Acceuil);

			}
			public void mouseExited(MouseEvent e) {
				onLeaveHover(Button_Payer_Redevance);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				onLeavClick(Button_Payer_Redevance);
			}
		});
		Button_Payer_Redevance.setLayout(null);
		Button_Payer_Redevance.setBackground(Color.WHITE);
		Button_Payer_Redevance.setBounds(0, 203, 226, 60);
		panel.add(Button_Payer_Redevance);
		
		JLabel lblMail = new JLabel("Payer les redevance");
		lblMail.setHorizontalAlignment(SwingConstants.CENTER);
		lblMail.setForeground(new Color(96,83,150));
		lblMail.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblMail.setBounds(30, 18, 148, 24);
		Button_Payer_Redevance.add(lblMail);
		
		Button_Redevance.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClick(Button_Redevance);
				onLeavClick(Button_Payer_Redevance);
				onLeavClick(Button_Acceuil);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				onHover(Button_Redevance);
				onLeaveHover(Button_Acceuil);
				onLeaveHover(Button_Payer_Redevance);
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
		Button_Redevance.setBounds(0, 144, 226, 60);
		panel.add(Button_Redevance);
		
		JLabel lblPayeent = new JLabel("Gestion des redevance");
		lblPayeent.setHorizontalAlignment(SwingConstants.CENTER);
		lblPayeent.setForeground(new Color(181,77,180));
		lblPayeent.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblPayeent.setBounds(47, 11, 146, 24);
		Button_Redevance.add(lblPayeent);
		
		Button_déconnexion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//onClick(Button_déconnexion);
				
				onLeavClick(Button_Payer_Redevance);
				onLeavClick(Button_Redevance);
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
				onLeaveHover(Button_Payer_Redevance);
				onLeaveHover(Button_Redevance);
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
		panel_3.setBounds(225, 0, 785, 500);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblWelcomBack = new JLabel("Payer les redevance");
		lblWelcomBack.setHorizontalAlignment(SwingConstants.LEFT);
		lblWelcomBack.setForeground(new Color(96, 83, 150));
		lblWelcomBack.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblWelcomBack.setBounds(20, 11, 414, 24);
		panel_3.add(lblWelcomBack);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 181, 360, 307);
		panel_3.add(scrollPane);
		
		DefaultTableModel model = new DefaultTableModel();

		table_1 = new JTable(model);
		table_1.setSelectionBackground(new Color(96, 83, 150));
		table_1.setRowHeight(20);
		table_1.setGridColor(new Color(247, 247, 247));
		table_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		table_1.setBorder(null);
		table_1.setBackground(new Color(247, 247, 247));
		update_table_payer(table_1);
		scrollPane.setViewportView(table_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(366, 31, 136, 67);
		panel_3.add(panel_1);
		
		Statistique statistique = new Statistique();
		DecimalFormat f = new DecimalFormat();
		f.setMaximumFractionDigits(2);
		lblNbr = new JLabel(f.format(statistique.getMontant()));
		lblNbr.setHorizontalAlignment(SwingConstants.LEFT);
		lblNbr.setForeground(new Color(96, 83, 150));
		lblNbr.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNbr.setBounds(10, 20, 116, 25);
		panel_1.add(lblNbr);
		
		JLabel lblPrixTotal = new JLabel("Prix total");
		lblPrixTotal.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrixTotal.setForeground(new Color(96, 83, 150));
		lblPrixTotal.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblPrixTotal.setBounds(378, 0, 128, 20);
		panel_3.add(lblPrixTotal);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(403, 181, 360, 307);
		panel_3.add(scrollPane_1);
		DefaultTableModel model_1 = new DefaultTableModel();

		table_2 = new JTable(model_1);
		update_table_non_payer(table_2);
		scrollPane_1.setViewportView(table_2);
		
		JLabel lblRedevancePayer = new JLabel("Redevance payer");
		lblRedevancePayer.setHorizontalAlignment(SwingConstants.LEFT);
		lblRedevancePayer.setForeground(new Color(96, 83, 150));
		lblRedevancePayer.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblRedevancePayer.setBounds(20, 148, 350, 24);
		panel_3.add(lblRedevancePayer);
		
		JLabel lblRedevanceNonPayer = new JLabel("Redevance non payer");
		lblRedevanceNonPayer.setHorizontalAlignment(SwingConstants.LEFT);
		lblRedevanceNonPayer.setForeground(new Color(96, 83, 150));
		lblRedevanceNonPayer.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblRedevanceNonPayer.setBounds(403, 146, 350, 24);
		panel_3.add(lblRedevanceNonPayer);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(616, 103, 136, 67);
		panel_3.add(panel_2);
		
		JLabel label = new JLabel(Double.toString(montant_non_payer()));
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setForeground(new Color(96, 83, 150));
		label.setFont(new Font("Segoe UI", Font.BOLD, 16));
		label.setBounds(10, 20, 116, 25);
		panel_2.add(label);
		
		JLabel lblPrix = new JLabel("Prix ");
		lblPrix.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrix.setForeground(new Color(96, 83, 150));
		lblPrix.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblPrix.setBounds(612, 78, 128, 20);
		panel_3.add(lblPrix);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBounds(220, 103, 136, 67);
		panel_3.add(panel_5);
		
		lbl_payer = new JLabel(Double.toString(montant_payer()));
		lbl_payer.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_payer.setForeground(new Color(96, 83, 150));
		lbl_payer.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lbl_payer.setBounds(10, 20, 116, 25);
		panel_5.add(lbl_payer);
		
		JLabel label_4 = new JLabel("Prix");
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_4.setForeground(new Color(96, 83, 150));
		label_4.setFont(new Font("Segoe UI", Font.BOLD, 12));
		label_4.setBounds(216, 78, 128, 20);
		panel_3.add(label_4);
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
    
    public void update_table_payer(JTable table) {
    	Connection cnx = null;
	   	PreparedStatement requete = null ;
	   	ResultSet resultat = null ;
		   
			cnx = ConnexionMySQL.connectDB();	
			String sql = "SELECT * FROM Redevance where payer=1 order by compagnie";

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
    public void update_table_non_payer(JTable table) {
    	Connection cnx = null;
	   	PreparedStatement requete = null ;
	   	ResultSet resultat = null ;
		   
			cnx = ConnexionMySQL.connectDB();	
			String sql = "SELECT * FROM Redevance where payer=0 order by compagnie";

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
}
