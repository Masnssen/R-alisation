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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;

public class PisteA extends JFrame {

	private JPanel contentPane;
	private static JTable table;
	private Piste piste;
	private JLabel txtnbr;
	private JTextField txtlongeur;
	private JComboBox comboBoxAeroport;
	private JScrollPane scrollPane;
	private JPanel Button_Piste;
	private JPanel Button_affichage;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PisteA frame = new PisteA();
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
		
	public PisteA() {
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
				GestionPiste obj = new GestionPiste();
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
		lblaccueil.setForeground(new Color(96,83,150));
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
				//onLeavClick(Button_déconnexion);
					
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				onHover(Button_Piste);
				onLeaveHover(Button_affichage);
				//onLeaveHover(Button_déconnexion);
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
		Button_Piste.setBounds(0, 145, 226, 60);
		panel.add(Button_Piste);
		
		JLabel pistes = new JLabel("Pistes");
		pistes.setHorizontalAlignment(SwingConstants.CENTER);
		pistes.setForeground(new Color(181, 77, 180));
		pistes.setFont(new Font("Segoe UI", Font.BOLD, 12));
		pistes.setBounds(56, 18, 75, 24);
		Button_Piste.add(pistes);
		
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
		Button_affichage.setBounds(0, 206, 226, 60);
		panel.add(Button_affichage);
		
		JLabel lblAffichage = new JLabel("Affichage");
		lblAffichage.setHorizontalAlignment(SwingConstants.CENTER);
		lblAffichage.setForeground(new Color(96,83,150));
		lblAffichage.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblAffichage.setBounds(56, 18, 75, 24);
		Button_affichage.add(lblAffichage);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(247,247,247));
		panel_3.setBounds(214, 0, 796, 500);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblWelcomBack = new JLabel("Pistes");
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
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(374, 158, 390, 331);
		panel_3.add(scrollPane);
		
		DefaultTableModel model = new DefaultTableModel();
		table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int ligne = table.getSelectedRow();
				txtlongeur.setText(table.getModel().getValueAt(ligne,1).toString());
				comboBoxAeroport.setSelectedItem(table.getModel().getValueAt(ligne,2).toString());
				
			}
		});
		table.setSelectionBackground(new Color(96, 83, 150));
		table.setRowHeight(20);
		table.setGridColor(new Color(247, 247, 247));
		table.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		table.setBorder(null);
		table.setBackground(new Color(247, 247, 247));
		update_table(table);
		scrollPane.setViewportView(table);
		
		JLabel lblAeroport = new JLabel("Aeroport");
		lblAeroport.setForeground(new Color(96, 83, 150));
		lblAeroport.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblAeroport.setBounds(20, 188, 118, 24);
		panel_3.add(lblAeroport);
		
		JLabel lblLongeur = new JLabel("Longeur");
		lblLongeur.setForeground(new Color(96, 83, 150));
		lblLongeur.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblLongeur.setBounds(36, 241, 96, 24);
		panel_3.add(lblLongeur);
		
		JButton button = new JButton("Ajouter");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtlongeur.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Veuiller remplir la durree");
				}else {
					try {
						piste = new Piste(Double.parseDouble(txtlongeur.getText()),"DAAE");
						piste.AjouterPiste();
						update_table(table);
						scrollPane.setViewportView(table);
					  Nbr(txtnbr);
					}catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Veuiller remplir le champ longeur avec que des nombres");

					}
				  
				}
			}
		});
		
		button.setBackground(new Color(126, 87, 194));
		button.setBounds(20, 352, 108, 34);
		panel_3.add(button);
		
		
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtlongeur.getText().equals("")||comboBoxAeroport.getSelectedItem().toString().equals("Sélectionner")) {
					JOptionPane.showMessageDialog(null, "Veuiller remplir la durree");
				}else {
				int ligne = table.getSelectedRow();
				  piste = new Piste(Integer.parseInt(table.getModel().getValueAt(ligne,0).toString()),Double.parseDouble(txtlongeur.getText()),comboBoxAeroport.getSelectedItem().toString());				
				piste.Modifier();
				update_table(table);
				scrollPane.setViewportView(table);
				}
			}
		});
		btnModifier.setBackground(new Color(126, 87, 194));
		btnModifier.setBounds(138, 352, 108, 34);
		panel_3.add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtlongeur.getText().equals("")||comboBoxAeroport.getSelectedItem().toString().equals("Sélectionner")) {
					JOptionPane.showMessageDialog(null, "Veuiller remplir la durree");
				}else {
				int ligne = table.getSelectedRow();
				  piste = new Piste(Integer.parseInt(table.getModel().getValueAt(ligne,0).toString()),Double.parseDouble(table.getModel().getValueAt(ligne,1).toString()),comboBoxAeroport.getSelectedItem().toString());
				piste.Supprimer();
				update_table(table);
				scrollPane.setViewportView(table);
				Nbr(txtnbr);
				}
			}
		});
		btnSupprimer.setBackground(new Color(126, 87, 194));
		btnSupprimer.setBounds(256, 352, 108, 34);
		panel_3.add(btnSupprimer);
		Nbr(txtnbr);
		
		comboBoxAeroport = new JComboBox();
		comboBoxAeroport.setEditable(true);
		comboBoxAeroport.setEnabled(false);
		comboBoxAeroport.setBounds(148, 193, 101, 22);
		panel_3.add(comboBoxAeroport);
		
		txtlongeur = new JTextField();
		txtlongeur.setColumns(10);
		txtlongeur.setBounds(148, 247, 101, 20);
		panel_3.add(txtlongeur);
		
		remplirCombo(comboBoxAeroport);
		
		
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
	private void Nbr(JLabel txtnbr) {
		Connection cnx = null;
    	PreparedStatement requete = null ;
    	ResultSet resultat = null ;
		
		
		cnx = ConnexionMySQL.connectDB();	
		String sql = "SELECT COUNT(*) FROM Piste ";

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
	public void remplir(JComboBox comboBoxEtat) {
		//remplir combo
	    List<Etat> list = Arrays.asList(Etat.values());
	    for (int i = 0; i < list.size(); i++) {
	    	comboBoxEtat.addItem(list.get(i));			
		}

	}
	public void update_table(JTable table) {
 	   Connection cnx = null;
		   	PreparedStatement requete = null ;
		   	ResultSet resultat = null ;
			   
				cnx = ConnexionMySQL.connectDB();	
				String sql = "SELECT * FROM piste";

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
	 public void remplirCombo(JComboBox comboBoxAeroport) {
		 comboBoxAeroport.addItem("DAAE");
	    }
	 public void remplirComboAffichageLigneTab(JComboBox ComboBoxEtat,int idpiste) {
			Connection cnx = null;
	    	PreparedStatement requete = null ;
	    	ResultSet resultat = null ;
			
			//remplir Ccombo etat 
			cnx = ConnexionMySQL.connectDB();	
			String sql = "SELECT * FROM piste Where IDPISTE = "+idpiste;

			try {
				requete = cnx.prepareStatement(sql);
				resultat = requete.executeQuery();
				while(resultat.next()) {
					String etat = resultat.getString("ETAT");
					
					ComboBoxEtat.setSelectedItem(etat);					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	
}
