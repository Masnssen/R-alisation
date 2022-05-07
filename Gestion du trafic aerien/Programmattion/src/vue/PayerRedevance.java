package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modele.ConnexionMySQL;
import modele.Redevance;
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
import javax.swing.JComboBox;

public class PayerRedevance extends JFrame {

	private JPanel contentPane;
	private static JTable table_1;
	private JScrollPane scrollPane;	
	private JComboBox ComboBoxCompagnie;
	private JLabel lblNbr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PayerRedevance frame = new PayerRedevance();
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
		
	public PayerRedevance() {
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
				AnalysteDeVol obj = new AnalysteDeVol();
				obj.setVisible(true);
	  			obj.setLocationRelativeTo(null);
	  			dispose();
				
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
		lblaccueil.setForeground(new Color(96,83,150));
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
			
				PayerRedevance obj = new PayerRedevance();
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
		Button_Redevance.setBounds(0, 203, 226, 60);
		panel.add(Button_Redevance);
		
		JLabel lblMail = new JLabel("Payer les redevance");
		lblMail.setHorizontalAlignment(SwingConstants.CENTER);
		lblMail.setForeground(new Color(181,77,180));
		lblMail.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblMail.setBounds(30, 18, 148, 24);
		Button_Redevance.add(lblMail);
		
		Button_statistique.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClick(Button_statistique);
				onLeavClick(Button_Redevance);
				onLeavClick(Button_Acceuil);
				//onLeavClick(Button_déconnexion);
				
				
			;
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
		Button_statistique.setBounds(0, 144, 226, 60);
		panel.add(Button_statistique);
		
		JLabel lblPayeent = new JLabel("Gestion des redevance");
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
		scrollPane.setBounds(10, 181, 517, 307);
		panel_3.add(scrollPane);
		
		DefaultTableModel model = new DefaultTableModel();

		table_1 = new JTable(model);
		table_1.setSelectionBackground(new Color(96, 83, 150));
		table_1.setRowHeight(20);
		table_1.setGridColor(new Color(247, 247, 247));
		table_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		table_1.setBorder(null);
		table_1.setBackground(new Color(247, 247, 247));
		
		scrollPane.setViewportView(table_1);
		
		JLabel lblTouteLesRedevance = new JLabel("compagnie");
		lblTouteLesRedevance.setHorizontalAlignment(SwingConstants.LEFT);
		lblTouteLesRedevance.setForeground(new Color(96, 83, 150));
		lblTouteLesRedevance.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblTouteLesRedevance.setBounds(20, 128, 94, 20);
		panel_3.add(lblTouteLesRedevance);
		
		ComboBoxCompagnie = new JComboBox();
		ComboBoxCompagnie.setBounds(108, 128, 123, 22);
		panel_3.add(ComboBoxCompagnie);
		remplirCombo(ComboBoxCompagnie);
		
		JButton btnAfficher = new JButton("Afficher");
		btnAfficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update_table(table_1,ComboBoxCompagnie.getSelectedItem().toString());
				scrollPane.setViewportView(table_1);
				lblNbr.setText(Double.toString(Redevance.getMontantCompagnie(ComboBoxCompagnie.getSelectedItem().toString())));
			
			}
		});
		btnAfficher.setBackground(new Color(126, 87, 194));
		btnAfficher.setBounds(272, 128, 108, 34);
		panel_3.add(btnAfficher);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(570, 204, 136, 67);
		panel_3.add(panel_1);
		
		lblNbr = new JLabel("");
		lblNbr.setHorizontalAlignment(SwingConstants.LEFT);
		lblNbr.setForeground(new Color(96, 83, 150));
		lblNbr.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNbr.setBounds(10, 20, 116, 25);
		panel_1.add(lblNbr);
		
		JLabel lblPrixTotal = new JLabel("Prix total");
		lblPrixTotal.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrixTotal.setForeground(new Color(96, 83, 150));
		lblPrixTotal.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblPrixTotal.setBounds(582, 173, 128, 20);
		panel_3.add(lblPrixTotal);
		
		JButton btnPayer = new JButton("Payer");
		btnPayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Redevance.Payer(ComboBoxCompagnie.getSelectedItem().toString());
				update_table(table_1,ComboBoxCompagnie.getSelectedItem().toString());
				scrollPane.setViewportView(table_1);
				lblNbr.setText(Double.toString(Redevance.getMontantCompagnie(ComboBoxCompagnie.getSelectedItem().toString())));
			}
		});
		btnPayer.setBackground(new Color(126, 87, 194));
		btnPayer.setBounds(592, 331, 108, 34);
		panel_3.add(btnPayer);
		
		JLabel lblRedevanceNonPayer = new JLabel("Redevance non payer");
		lblRedevanceNonPayer.setHorizontalAlignment(SwingConstants.LEFT);
		lblRedevanceNonPayer.setForeground(Color.DARK_GRAY);
		lblRedevanceNonPayer.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblRedevanceNonPayer.setBounds(20, 89, 414, 24);
		panel_3.add(lblRedevanceNonPayer);
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
    public void remplirCombo(JComboBox ComboBoxCompagnie) {
		
		 Connection cnx = null;
	    	PreparedStatement requete = null ;
	    	ResultSet resultat = null ;
		 //remplir Compagnie
			cnx = ConnexionMySQL.connectDB();	
			String sql = "SELECT * FROM Compagnie";

			try {
				requete = cnx.prepareStatement(sql);
				resultat = requete.executeQuery();
				while(resultat.next()) {
					String idCompagnie = resultat.getString("IDCOMPAGNIE");
					
					ComboBoxCompagnie.addItem(idCompagnie);
				}
				requete.close();
				cnx.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
    public void update_table(JTable table,String compagnie) {
    	Connection cnx = null;
	   	PreparedStatement requete = null ;
	   	ResultSet resultat = null ;
		   
			cnx = ConnexionMySQL.connectDB();	
			String sql = "SELECT * FROM Redevance where compagnie ='"+compagnie+"'and "
  					+ "payer = 0";

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
