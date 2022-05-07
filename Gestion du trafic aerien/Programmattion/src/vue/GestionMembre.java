package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modele.ConnexionMySQL;
import modele.Membre;
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

public class GestionMembre extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtNom;
	private Compagnie compagnie;
	private JLabel txtnbr ;
	private Membre membreEquipe ;
	private JTextField txtNbHeure;
	private JPanel Button_Aeronef;
	private JPanel Button_Equipage;
	private JPanel Button_fonction ;
	private JPanel Button_Membre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionMembre frame = new GestionMembre();
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
		
	public GestionMembre() {
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
				onLeavClick(Button_Aeronef);
				onLeavClick(Button_Equipage);
				onLeavClick(Button_fonction);
				onLeavClick(Button_Membre);

				IngénieurOpérationDeVol obj = new IngénieurOpérationDeVol();
				obj.setVisible(true);
	  			obj.setLocationRelativeTo(null);
	  			dispose();
				
			
	  			}
			@Override
			public void mouseEntered(MouseEvent e) {
				onHover(Button_Acceuil);
				onLeaveHover(Button_Aeronef);
				onLeaveHover(Button_Equipage);
				onLeaveHover(Button_Membre);
				onLeaveHover(Button_fonction);
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
		
        Button_fonction = new JPanel();
        Button_fonction.addMouseListener(new MouseAdapter() {
        	@Override
			public void mouseClicked(MouseEvent e) {
				onClick(Button_fonction);
				onLeavClick(Button_Aeronef);
				onLeavClick(Button_Acceuil);
				onLeavClick(Button_Equipage);
				onLeavClick(Button_Membre);
				
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
				onLeaveHover(Button_Membre);
				
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
		Button_fonction.setBounds(0, 278, 226, 60);
		panel.add(Button_fonction);
		
		JLabel label = new JLabel("Gestion des Fonctions");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(96, 83, 150));
		label.setFont(new Font("Segoe UI", Font.BOLD, 12));
		label.setBounds(47, 11, 139, 24);
		Button_fonction.add(label);
		
		Button_Membre = new JPanel();
		Button_Membre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClick(Button_Membre);
				onLeavClick(Button_Aeronef);
				onLeavClick(Button_Acceuil);
				onLeavClick(Button_Equipage);
				onLeavClick(Button_fonction);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				onHover(Button_Membre);
				onLeaveHover(Button_Equipage);
				onLeaveHover(Button_Acceuil);
				onLeaveHover(Button_Aeronef);
				onLeaveHover(Button_fonction);

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
		Button_Membre.setBounds(0, 337, 226, 60);
		panel.add(Button_Membre);
		
		JLabel label_1 = new JLabel("Gestion des Membres");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(new Color(96, 83, 150));
		label_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		label_1.setBounds(47, 11, 139, 24);
		Button_Membre.add(label_1);
		
		Button_Equipage = new JPanel();
		Button_Equipage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClick(Button_Equipage);
				onLeavClick(Button_Aeronef);
				onLeavClick(Button_Acceuil);
				onLeavClick(Button_fonction);
				onLeavClick(Button_Membre);
				
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
				onLeaveHover(Button_fonction);
				onLeaveHover(Button_Membre);
							
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
		Button_Equipage.setBounds(0, 216, 226, 60);
		panel.add(Button_Equipage);
		
		JLabel label_2 = new JLabel("Gestion des equipages");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(new Color(96, 83, 150));
		label_2.setFont(new Font("Segoe UI", Font.BOLD, 12));
		label_2.setBounds(47, 11, 139, 24);
		Button_Equipage.add(label_2);
		
		Button_Aeronef = new JPanel();
		Button_Aeronef.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClick(Button_Aeronef);
				onLeavClick(Button_Acceuil);
				onLeavClick(Button_Equipage);
				onLeavClick(Button_fonction);
				onLeavClick(Button_Membre);
			
				GestionAeronef obj = new GestionAeronef();
				obj.setVisible(true);
	  			obj.setLocationRelativeTo(null);
	  			dispose();
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				onHover(Button_Aeronef);
				onLeaveHover(Button_Equipage);
				onLeaveHover(Button_fonction);
				onLeaveHover(Button_Membre);
				
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
		Button_Aeronef.setBounds(0, 145, 226, 60);
		panel.add(Button_Aeronef);
		
		JLabel label_3 = new JLabel("Gestion des aeronefs");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(new Color(181, 77, 180));
		label_3.setFont(new Font("Segoe UI", Font.BOLD, 12));
		label_3.setBounds(56, 18, 134, 24);
		Button_Aeronef.add(label_3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(247,247,247));
		panel_3.setBounds(214, 0, 796, 500);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblWelcomBack = new JLabel("Gestion des Membre");
		lblWelcomBack.setHorizontalAlignment(SwingConstants.LEFT);
		lblWelcomBack.setForeground(new Color(96, 83, 150));
		lblWelcomBack.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblWelcomBack.setBounds(20, 11, 414, 24);
		panel_3.add(lblWelcomBack);
		
		JLabel lblmembre = new JLabel("Nombre de membre");
		lblmembre.setHorizontalAlignment(SwingConstants.LEFT);
		lblmembre.setForeground(new Color(96, 83, 150));
		lblmembre.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblmembre.setBounds(421, 46, 128, 20);
		panel_3.add(lblmembre);
		
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
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int ligne = table.getSelectedRow();
				  txtNom.setText(table.getModel().getValueAt(ligne,1).toString());
				   txtNbHeure.setText(table.getModel().getValueAt(ligne,2).toString());
			}
		});
		table.setSelectionBackground(new Color(96, 83, 150));
		table.setRowHeight(20);
		table.setGridColor(new Color(247, 247, 247));
		table.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		table.setBorder(null);
		table.setBackground(new Color(247, 247, 247));
		scrollPane_1.setViewportView(table);
		
		txtNom = new JTextField();
		txtNom.setColumns(10);
		txtNom.setBounds(171, 235, 166, 20);
		panel_3.add(txtNom);
		
		JLabel lblnom = new JLabel("Nom");
		lblnom.setForeground(new Color(96, 83, 150));
		lblnom.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblnom.setBounds(46, 229, 85, 24);
		panel_3.add(lblnom);
		
		JLabel lblnbrheure = new JLabel("Nombre d'Heure");
		lblnbrheure.setForeground(new Color(96, 83, 150));
		lblnbrheure.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblnbrheure.setBounds(30, 283, 149, 24);
		panel_3.add(lblnbrheure);
		
		JButton button = new JButton("Ajouter");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtNom.getText().equals("")||txtNbHeure.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Veuiller remplir tout les champs");
				}else {
					try {
				membreEquipe = new Membre(txtNom.getText(), Integer.parseInt(txtNbHeure.getText()));
				membreEquipe.AjouterMembre();
				Nbr(txtnbr);

				update_table(table);
					}catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Veuiller remplir le champ nombre d 'heure en nombre");
					}
				}
			}
		});
		
		button.setBackground(new Color(126, 87, 194));
		button.setBounds(30, 417, 108, 34);
		panel_3.add(button);
		
		
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtNom.getText().equals("")||txtNbHeure.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Veuiller remplir tout les champs");
				}else {
					try {
				int ligne = table.getSelectedRow();
				String id = table.getModel().getValueAt(ligne,0).toString();
				membreEquipe = new Membre(Integer.parseInt(id),txtNom.getText(), Integer.parseInt(txtNbHeure.getText()));
				membreEquipe.Modifier();
				update_table(table);
					}catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Veuiller remplir tout le champ nombre d'heure en nombre");
					}
				}
			}
		});
		btnModifier.setBackground(new Color(126, 87, 194));
		btnModifier.setBounds(148, 417, 108, 34);
		panel_3.add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtNom.getText().equals("")||txtNbHeure.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Veuiller remplir tout les champs");
				}else {
				int ligne = table.getSelectedRow();
				String id = table.getModel().getValueAt(ligne,0).toString();
				membreEquipe = new Membre(Integer.parseInt(id),txtNom.getText(), Integer.parseInt(txtNbHeure.getText()));
				membreEquipe.Supprimer();
				Nbr(txtnbr);
				update_table(table);
				}
			}
		});
		btnSupprimer.setBackground(new Color(126, 87, 194));
		btnSupprimer.setBounds(266, 417, 108, 34);
		panel_3.add(btnSupprimer);
		update_table(table);
		
		Nbr(txtnbr);
		
		txtNbHeure = new JTextField();
		txtNbHeure.setColumns(10);
		txtNbHeure.setBounds(171, 289, 166, 20);
		panel_3.add(txtNbHeure);
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
    public void update_table(JTable table) {
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
		
		 private void Nbr(JLabel txtnbr) {
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
}
