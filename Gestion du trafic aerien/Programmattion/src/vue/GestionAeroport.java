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

public class GestionAeroport extends JFrame {

	private JPanel contentPane;
	private static JTable table;
	private JTextField txtID;
	private Aeroport aeroport;
	private JTextField txtPays;
	private JLabel txtnbr;
	private JTextField txtNnomAeroport;
	private JPanel Button_Aeroport;
	private JPanel Button_Compagnie ;
	private JPanel Button_liste_noir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionAeroport frame = new GestionAeroport();
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
		
	public GestionAeroport() {
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
				//onLeaveHover(Button_déconnexion);
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
		
		JLabel label = new JLabel("Gestion de la liste  noire ");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(96, 83, 150));
		label.setFont(new Font("Segoe UI", Font.BOLD, 12));
		label.setBounds(47, 11, 136, 24);
		Button_liste_noir.add(label);
		
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
		label_1.setForeground(new Color(96, 83, 150));
		label_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		label_1.setBounds(47, 11, 139, 24);
		Button_Compagnie.add(label_1);
		
		JLabel label_2 = new JLabel("a\u00E9riennes");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(new Color(96, 83, 150));
		label_2.setFont(new Font("Segoe UI", Font.BOLD, 12));
		label_2.setBounds(57, 36, 124, 13);
		Button_Compagnie.add(label_2);
		
		Button_Aeroport = new JPanel();
		Button_Aeroport.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClick(Button_Aeroport);
				onLeavClick(Button_Acceuil);
				onLeavClick(Button_Compagnie);			
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
		
		JLabel label_3 = new JLabel("Gestion des a\u00E9roports");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(new Color(181,77,180));
		label_3.setFont(new Font("Segoe UI", Font.BOLD, 12));
		label_3.setBounds(56, 18, 134, 24);
		Button_Aeroport.add(label_3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(247,247,247));
		panel_3.setBounds(214, 0, 796, 500);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblWelcomBack = new JLabel("Gestion des aeroports");
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
				   txtNnomAeroport.setText(table.getModel().getValueAt(ligne,1).toString());
				   txtPays.setText(table.getModel().getValueAt(ligne,2).toString());
				 
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
		txtID.setBounds(131, 140, 196, 20);
		panel_3.add(txtID);
		
		JLabel lblPseudo = new JLabel("ID");
		lblPseudo.setForeground(new Color(96, 83, 150));
		lblPseudo.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPseudo.setBounds(36, 134, 85, 24);
		panel_3.add(lblPseudo);
		
		JLabel lblPassword = new JLabel("Nom Aeroport");
		lblPassword.setForeground(new Color(96, 83, 150));
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPassword.setBounds(20, 188, 146, 24);
		panel_3.add(lblPassword);
		
		JLabel lblPays = new JLabel("Pays");
		lblPays.setForeground(new Color(96, 83, 150));
		lblPays.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPays.setBounds(36, 241, 96, 24);
		panel_3.add(lblPays);
		
		JButton button = new JButton("Ajouter");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtID.getText().equals("")||txtnbr.getText().equals("")||txtNnomAeroport.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Veuiller remplir tout les champs");
				}else {
					try {
				 aeroport = new Aeroport(txtID.getText(),txtNnomAeroport.getText(),txtPays.getText());
					aeroport.AjouterAeroport();
				  update_table(table);
				  scrollPane_1.setViewportView(table);
				  Nbr(txtnbr);
					}catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Veuiller remplir tout les champ comme il se doit");
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
		
				if(txtID.getText().equals("")||txtnbr.getText().equals("")||txtNnomAeroport.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Veuiller remplir tout les champs");
				}else {
					try{
				int ligne = table.getSelectedRow();
				String id = table.getModel().getValueAt(ligne,0).toString();
				aeroport = new Aeroport(id,txtNnomAeroport.getText(),txtPays.getText());
			   	aeroport.Modifier();
				update_table(table);
				scrollPane_1.setViewportView(table);
					}catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Veuiller remplir tout les champ comme il se doit");
					}
				}
			}
		});
		btnModifier.setBackground(new Color(126, 87, 194));
		btnModifier.setBounds(138, 352, 108, 34);
		panel_3.add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtID.getText().equals("")||txtnbr.getText().equals("")||txtNnomAeroport.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Veuiller remplir tout les champs");
				}else {
					try {
				int ligne = table.getSelectedRow();
				String id = table.getModel().getValueAt(ligne,0).toString();
				aeroport = new Aeroport(id,txtNnomAeroport.getText(),txtPays.getText());
			    aeroport.Supprimer();
				update_table(table);
				scrollPane_1.setViewportView(table);
				Nbr(txtnbr);
					}catch (Exception e3) {
						JOptionPane.showMessageDialog(null, "Veuiller remplir tout les champ comme il se doit");
					}
				}
			}
		});
		btnSupprimer.setBackground(new Color(126, 87, 194));
		btnSupprimer.setBounds(256, 352, 108, 34);
		panel_3.add(btnSupprimer);
		
		
		txtPays = new JTextField();
		txtPays.setColumns(10);
		txtPays.setBounds(131, 247, 196, 20);
		panel_3.add(txtPays);
		Nbr(txtnbr);
		
		txtNnomAeroport = new JTextField();
		txtNnomAeroport.setColumns(10);
		txtNnomAeroport.setBounds(152, 194, 178, 20);
		panel_3.add(txtNnomAeroport);
		
		
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
		String sql = "SELECT COUNT(*) FROM Aeroport ";

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
	public void update_table(JTable table) {
			
		 Connection cnx = null;
		   	PreparedStatement requete = null ;
		   	ResultSet resultat = null ;
			   
				cnx = ConnexionMySQL.connectDB();	
				String sql = "SELECT * FROM aeroport";

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
