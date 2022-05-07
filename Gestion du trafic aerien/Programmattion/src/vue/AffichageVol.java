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
import modele.TypeVol;
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
import java.util.Arrays;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import com.toedter.components.JLocaleChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JDateChooser;

public class AffichageVol extends JFrame {

	private JPanel contentPane;
	private static JTable table_1;
	private JPanel Button_Affichage;
	private JPanel Button_Vol;
	private JComboBox comboBoxcompagnie;
	private JCheckBox checkCompagnie;
	private JCheckBox checkBoxDate;
	private JDateChooser dateChooser;
	private JCheckBox checkBoxAeronef;
	private JComboBox comboBoxAeronef;
	private JComboBox comboBoxTypevol ;
	private  JCheckBox checkBoxtypevol;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AffichageVol frame = new AffichageVol();
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
		
	public AffichageVol() {
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
	     Button_Vol = new JPanel();

		
		Button_Acceuil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClick(Button_Acceuil);
				onLeavClick(Button_Vol);
				
				IngenieurPreparateurDeVol obj = new IngenieurPreparateurDeVol();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				
								}
			@Override
			public void mouseEntered(MouseEvent e) {
				onHover(Button_Acceuil);
				//onLeaveHover(Button_déconnexion);
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
		lblaccueil.setForeground(new Color(96, 83, 150));
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
		
		Button_déconnexion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//onClick(Button_déconnexion);
				
				onLeavClick(Button_Vol);
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
				onLeaveHover(Button_Vol);
				
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
				
				
				
				GestionVol obj = new GestionVol();
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
		lblAffichageVol.setForeground(new Color(181,77,180));
		lblAffichageVol.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblAffichageVol.setBounds(56, 18, 134, 24);
		Button_Affichage.add(lblAffichageVol);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(247,247,247));
		panel_3.setBounds(223, 0, 787, 500);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblWelcomBack = new JLabel("Affichage vol");
		lblWelcomBack.setHorizontalAlignment(SwingConstants.LEFT);
		lblWelcomBack.setForeground(new Color(96, 83, 150));
		lblWelcomBack.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblWelcomBack.setBounds(20, 11, 414, 24);
		panel_3.add(lblWelcomBack);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(45, 193, 701, 307);
		panel_3.add(scrollPane_1);
		
		DefaultTableModel model_1 = new DefaultTableModel();
		table_1 = new JTable(model_1);
		table_1.setSelectionBackground(new Color(96, 83, 150));
		table_1.setRowHeight(20);
		table_1.setGridColor(new Color(247, 247, 247));
		table_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		table_1.setBorder(null);
		table_1.setBackground(new Color(247, 247, 247));
	
		scrollPane_1.setViewportView(table_1);
		
		comboBoxcompagnie = new JComboBox();
		comboBoxcompagnie.setEnabled(false);
		comboBoxcompagnie.setBounds(148, 97, 105, 22);
		panel_3.add(comboBoxcompagnie);
		
		JLabel lblCompagnie = new JLabel("Compagnie");
		lblCompagnie.setForeground(new Color(96, 83, 150));
		lblCompagnie.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblCompagnie.setBounds(41, 97, 105, 24);
		panel_3.add(lblCompagnie);
		
		
		
		 checkCompagnie = new JCheckBox("");
		 checkCompagnie.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		if (checkCompagnie.isSelected()) {
		 			comboBoxcompagnie.setEnabled(true);
		 		}
		 		else {
		 			comboBoxcompagnie.setEnabled(false);
		 		}
		 	}
		 });
		checkCompagnie.setBounds(259, 97, 28, 23);
		panel_3.add(checkCompagnie);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setForeground(new Color(96, 83, 150));
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblDate.setBounds(41, 141, 105, 24);
		panel_3.add(lblDate);
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-dd");
		dateChooser.setBounds(148, 145, 105, 20);
		dateChooser.setEnabled(false);
		panel_3.add(dateChooser);
		
		 checkBoxDate = new JCheckBox("");
		 checkBoxDate.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		if (checkBoxDate.isSelected()) {
		 			dateChooser.setEnabled(true);
		 		}
		 		else {
		 			dateChooser.setEnabled(false);
		 		}
		 	}
		 });
		checkBoxDate.setBounds(259, 141, 28, 23);
		panel_3.add(checkBoxDate);
		
		JLabel lblAeronef = new JLabel("Aeronef");
		lblAeronef.setForeground(new Color(96, 83, 150));
		lblAeronef.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblAeronef.setBounds(361, 97, 81, 24);
		panel_3.add(lblAeronef);
		
		 comboBoxAeronef = new JComboBox();
		comboBoxAeronef.setEnabled(false);
		comboBoxAeronef.setBounds(452, 97, 105, 22);
		panel_3.add(comboBoxAeronef);
		
		checkBoxAeronef = new JCheckBox("");
		checkBoxAeronef.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (checkBoxAeronef.isSelected()) {
		 			comboBoxAeronef.setEnabled(true);
		 		}
		 		else {
		 			comboBoxAeronef.setEnabled(false);
		 		}
			}
		});
		checkBoxAeronef.setBounds(567, 97, 28, 23);
		panel_3.add(checkBoxAeronef);
		
		
		
		JLabel lblTypeVol = new JLabel("Type vol");
		lblTypeVol.setForeground(new Color(96, 83, 150));
		lblTypeVol.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblTypeVol.setBounds(361, 141, 81, 24);
		panel_3.add(lblTypeVol);
		
	 comboBoxTypevol = new JComboBox();
		comboBoxTypevol.setEnabled(false);
		comboBoxTypevol.setBounds(452, 146, 105, 22);
		panel_3.add(comboBoxTypevol);
		
		checkBoxtypevol = new JCheckBox("");
		checkBoxtypevol.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (checkBoxtypevol.isSelected()) {
		 			comboBoxTypevol.setEnabled(true);
		 		}
		 		else {
		 			comboBoxTypevol.setEnabled(false);
		 		}
			}
		});
		checkBoxtypevol.setBounds(567, 146, 28, 23);
		panel_3.add(checkBoxtypevol);
		
		remplirTypeVol(comboBoxTypevol);
		remplirCombo(comboBoxcompagnie,comboBoxAeronef);
		
		JButton btnAfficher = new JButton("Afficher");
		btnAfficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxAeronef.isEnabled()&&comboBoxcompagnie.isEnabled()&&comboBoxTypevol.isEnabled()&&dateChooser.isEnabled()) {
					update_table_compagnie_aeronef_date_typeVol(table_1, comboBoxcompagnie.getSelectedItem().toString()
							, comboBoxAeronef.getSelectedItem().toString(),
							((JTextField)dateChooser.getDateEditor().getUiComponent()).getText(),
							comboBoxTypevol.getSelectedItem().toString());
					scrollPane_1.setViewportView(table_1);
				}else if(comboBoxAeronef.isEnabled()&&comboBoxTypevol.isEnabled()&&dateChooser.isEnabled()) {
					update_table_aeronef_date_typeVol(table_1, comboBoxAeronef.getSelectedItem().toString(),
							((JTextField)dateChooser.getDateEditor().getUiComponent()).getText(),
							comboBoxTypevol.getSelectedItem().toString());
					scrollPane_1.setViewportView(table_1);
				}else if(comboBoxcompagnie.isEnabled()&&comboBoxTypevol.isEnabled()&&dateChooser.isEnabled()) {
					update_table_compagnie_date_typeVol(table_1, comboBoxcompagnie.getSelectedItem().toString()
							,((JTextField)dateChooser.getDateEditor().getUiComponent()).getText(),
							comboBoxTypevol.getSelectedItem().toString());
					scrollPane_1.setViewportView(table_1);
				}else if(comboBoxAeronef.isEnabled()&&comboBoxcompagnie.isEnabled()&&comboBoxTypevol.isEnabled()) {
					update_table_compagnie_aeronef_typeVol(table_1, comboBoxcompagnie.getSelectedItem().toString()
							, comboBoxAeronef.getSelectedItem().toString(),comboBoxTypevol.getSelectedItem().toString());
					scrollPane_1.setViewportView(table_1);
				}else if(comboBoxAeronef.isEnabled()&&comboBoxcompagnie.isEnabled()) {
					update_table_compagnie_aeronef(table_1, comboBoxcompagnie.getSelectedItem().toString()
							, comboBoxAeronef.getSelectedItem().toString());
					scrollPane_1.setViewportView(table_1);
				}else if(comboBoxcompagnie.isEnabled()&&dateChooser.isEnabled()) {
					update_table_compagnie_date(table_1, comboBoxcompagnie.getSelectedItem().toString()
							,((JTextField)dateChooser.getDateEditor().getUiComponent()).getText());
					scrollPane_1.setViewportView(table_1);
				}else if(comboBoxcompagnie.isEnabled()&&comboBoxTypevol.isEnabled()) {
					update_table_compagnie_typeVol(table_1, comboBoxcompagnie.getSelectedItem().toString(),
							comboBoxTypevol.getSelectedItem().toString());
					scrollPane_1.setViewportView(table_1);
				}else if(comboBoxAeronef.isEnabled()&&dateChooser.isEnabled()) {
					update_table_aeronef_date(table_1,comboBoxAeronef.getSelectedItem().toString(),
							((JTextField)dateChooser.getDateEditor().getUiComponent()).getText());
					scrollPane_1.setViewportView(table_1);
				}else if(comboBoxAeronef.isEnabled()&&comboBoxTypevol.isEnabled()) {
					update_table_aeronef_typeVol(table_1,comboBoxAeronef.getSelectedItem().toString(),
							comboBoxTypevol.getSelectedItem().toString());
					scrollPane_1.setViewportView(table_1);
				}else if(comboBoxAeronef.isEnabled()) {
					update_table_aeronef(table_1,comboBoxAeronef.getSelectedItem().toString());
					scrollPane_1.setViewportView(table_1);
				}else if(comboBoxcompagnie.isEnabled()) {
					update_table_compagnie(table_1,comboBoxcompagnie.getSelectedItem().toString());
					scrollPane_1.setViewportView(table_1);
				}else if(comboBoxTypevol.isEnabled()) {
					update_table_typeVol(table_1,comboBoxTypevol.getSelectedItem().toString());
					scrollPane_1.setViewportView(table_1);
				}else if(dateChooser.isEnabled()) {
					update_table_date(table_1,((JTextField)dateChooser.getDateEditor().getUiComponent()).getText());
					scrollPane_1.setViewportView(table_1);
				}
			}
		});
		btnAfficher.setBackground(new Color(126, 87, 194));
		btnAfficher.setBounds(632, 91, 108, 34);
		panel_3.add(btnAfficher);
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
    public void update_table_compagnie_date(JTable table,String compagnie,String date) {
   	 Connection cnx = null;
		   	PreparedStatement requete = null ;
		   	ResultSet resultat = null ;
			   
				cnx = ConnexionMySQL.connectDB();	
				String sql = "select * from vol where datedep ='"+date+"' and idcompagnie='"+compagnie+"' and (idaeroportdep ='DAAE' or idaeroportarriver ='DAAE')";

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
	
	        	
     public void update_table_compagnie_aeronef_date_typeVol(JTable table,String compagnie,String aeronef,String date,String typevol) {
    	 Connection cnx = null;
		   	PreparedStatement requete = null ;
		   	ResultSet resultat = null ;
			   
				cnx = ConnexionMySQL.connectDB();	
				String sql = "select * from vol where datedep ='"+date+"' and typeVol ='"+typevol+
						"' and idaeronef='"+aeronef+"' and idcompagnie='"+compagnie+"' and (idaeroportdep ='DAAE' or idaeroportarriver ='DAAE')";

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
     public void update_table_compagnie(JTable table,String compagnie) {
    	 Connection cnx = null;
		   	PreparedStatement requete = null ;
		   	ResultSet resultat = null ;
			   
				cnx = ConnexionMySQL.connectDB();	
				String sql = "select * from vol where idcompagnie='"+compagnie+"' and (idaeroportdep ='DAAE' or idaeroportarriver ='DAAE')";

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
     public void update_table_typeVol(JTable table,String typevol) {
    	 Connection cnx = null;
		   	PreparedStatement requete = null ;
		   	ResultSet resultat = null ;
			   
				cnx = ConnexionMySQL.connectDB();	
				String sql = "select * from vol where typeVol ='"+typevol+"' and (idaeroportdep ='DAAE' or idaeroportarriver ='DAAE')";

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
     public void update_table_date(JTable table,String date) {
    	 Connection cnx = null;
		   	PreparedStatement requete = null ;
		   	ResultSet resultat = null ;
			   
				cnx = ConnexionMySQL.connectDB();	
				String sql = "select * from vol where datedep ='"+date+"' and (idaeroportdep ='DAAE' or idaeroportarriver ='DAAE')";

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
     public void update_table_aeronef(JTable table,String aeronef) {
    	 Connection cnx = null;
		   	PreparedStatement requete = null ;
		   	ResultSet resultat = null ;
			   
				cnx = ConnexionMySQL.connectDB();	
				String sql = "select * from vol where idaeronef='"+aeronef+"' and (idaeroportdep ='DAAE' or idaeroportarriver ='DAAE')";

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
     public void update_table_aeronef_typeVol(JTable table,String aeronef,String typevol) {
    	 Connection cnx = null;
		   	PreparedStatement requete = null ;
		   	ResultSet resultat = null ;
			   
				cnx = ConnexionMySQL.connectDB();	
				String sql = "select * from vol where typeVol ='"+typevol+
						"' and idaeronef='"+aeronef+"' and (idaeroportdep ='DAAE' or idaeroportarriver ='DAAE')";

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
     public void update_table_aeronef_date(JTable table,String aeronef,String date) {
    	 Connection cnx = null;
		   	PreparedStatement requete = null ;
		   	ResultSet resultat = null ;
			   
				cnx = ConnexionMySQL.connectDB();	
				String sql = "select * from vol where datedep ='"+date+"' and idaeronef='"+aeronef+"' and (idaeroportdep ='DAAE' or idaeroportarriver ='DAAE')";

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
     public void update_table_compagnie_typeVol(JTable table,String compagnie,String typevol) {
    	 Connection cnx = null;
		   	PreparedStatement requete = null ;
		   	ResultSet resultat = null ;
			   
				cnx = ConnexionMySQL.connectDB();	
				String sql = "select * from vol where typeVol ='"+typevol+
						"' and idcompagnie='"+compagnie+"' and (idaeroportdep ='DAAE' or idaeroportarriver ='DAAE')";

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
     public void update_table_compagnie_aeronef(JTable table,String compagnie,String aeronef) {
    	 Connection cnx = null;
		   	PreparedStatement requete = null ;
		   	ResultSet resultat = null ;
			   
				cnx = ConnexionMySQL.connectDB();	
				String sql = "select * from vol where idaeronef='"+aeronef+"' and idcompagnie='"+compagnie+"' and (idaeroportdep ='DAAE' or idaeroportarriver ='DAAE')";

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
     public void update_table_compagnie_aeronef_typeVol(JTable table,String compagnie,String aeronef,String typevol) {
    	 Connection cnx = null;
		   	PreparedStatement requete = null ;
		   	ResultSet resultat = null ;
			   
				cnx = ConnexionMySQL.connectDB();	
				String sql = "select * from vol where typeVol ='"+typevol+
						"' and idaeronef='"+aeronef+"' and idcompagnie='"+compagnie+"' and (idaeroportdep ='DAAE' or idaeroportarriver ='DAAE')";

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
     public void update_table_compagnie_date_typeVol(JTable table,String compagnie,String date,String typevol) {
    	 Connection cnx = null;
		   	PreparedStatement requete = null ;
		   	ResultSet resultat = null ;
			   
				cnx = ConnexionMySQL.connectDB();	
				String sql = "select * from vol where datedep ='"+date+"' and typeVol ='"+typevol+
						"' and idcompagnie='"+compagnie+"' and (idaeroportdep ='DAAE' or idaeroportarriver ='DAAE')";

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
     public void update_table_aeronef_date_typeVol(JTable table,String aeronef,String date,String typevol) {
    	 Connection cnx = null;
		   	PreparedStatement requete = null ;
		   	ResultSet resultat = null ;
			   
				cnx = ConnexionMySQL.connectDB();	
				String sql = "select * from vol where datedep ='"+date+"' and typeVol ='"+typevol+
						"' and idaeronef='"+aeronef+"' and (idaeroportdep ='DAAE' or idaeroportarriver ='DAAE')";

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
    public void remplirTypeVol(JComboBox ComboBoxTypeVol) {
		//remplir combo
    	ComboBoxTypeVol.addItem("Sélectionner");
	    List<TypeVol> list = Arrays.asList(TypeVol.values());
	    for (int i = 0; i < list.size(); i++) {
	    	ComboBoxTypeVol.addItem(list.get(i));			
		}

	}
    public void remplirCombo(JComboBox ComboBoxCompagnie,JComboBox ComboBoxAeronef) {
		
		 Connection cnx = null;
	    	PreparedStatement requete = null ;
	    	ResultSet resultat = null ;
	    	
	    	//remplir Compagnie
			cnx = ConnexionMySQL.connectDB();	
			String sql = "SELECT * FROM Compagnie";
			ComboBoxCompagnie.addItem("Selectionner");

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
			//remplir Aeronef
			cnx = ConnexionMySQL.connectDB();	
			sql = "SELECT * FROM Aeronef";
			ComboBoxAeronef.addItem("Sélectionner");
			

			try {
				requete = cnx.prepareStatement(sql);
				resultat = requete.executeQuery();
				while(resultat.next()) {
					String Aeronef = resultat.getString("MAT");
					
					ComboBoxAeronef.addItem(Aeronef);
				}
				requete.close();
				cnx.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
}
