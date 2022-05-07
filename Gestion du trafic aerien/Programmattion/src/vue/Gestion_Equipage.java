package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modele.ConnexionMySQL;
import modele.Equipage;
import modele.MembreEquippage;
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

public class Gestion_Equipage extends JFrame {

	private JPanel contentPane;
	private JTable tableEquippage;
	private JTextField txtLibell;
	private JLabel txtnbr ;
	private JTable table_Attribution;
	private Equipage equipage ;
	private MembreEquippage membreEquippage ;
	private JComboBox comboBoxMembre;
	private JComboBox comboBoxEquipage ;
	private JPanel Button_Aeronef;
	private JPanel Button_Equipage;
	private JPanel Button_fonction;
	private JPanel Button_Membre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gestion_Equipage frame = new Gestion_Equipage();
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
		
	public Gestion_Equipage() {
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
		
		Button_Equipage = new JPanel();
		Button_Equipage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClick(Button_Equipage);
				onLeavClick(Button_Aeronef);
				onLeavClick(Button_Acceuil);
				onLeavClick(Button_fonction);
				onLeavClick(Button_Membre);
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
		Button_Equipage.setBounds(0, 214, 226, 60);
		panel.add(Button_Equipage);
		
		JLabel label = new JLabel("Gestion des equipages");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(181, 77, 180));
		label.setFont(new Font("Segoe UI", Font.BOLD, 12));
		label.setBounds(47, 11, 139, 24);
		Button_Equipage.add(label);
		
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
		Button_Aeronef.setBounds(0, 143, 226, 60);
		panel.add(Button_Aeronef);
		
		JLabel label_1 = new JLabel("Gestion des aeronefs");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(new Color(96, 83, 150));
		label_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		label_1.setBounds(56, 18, 134, 24);
		Button_Aeronef.add(label_1);
		
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
		Button_fonction.setBounds(0, 276, 226, 60);
		panel.add(Button_fonction);
		
		JLabel label_2 = new JLabel("Gestion des Fonctions");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(new Color(96, 83, 150));
		label_2.setFont(new Font("Segoe UI", Font.BOLD, 12));
		label_2.setBounds(47, 11, 139, 24);
		Button_fonction.add(label_2);
		
		Button_Membre = new JPanel();
		Button_Membre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClick(Button_Membre);
				onLeavClick(Button_Aeronef);
				onLeavClick(Button_Acceuil);
				onLeavClick(Button_Equipage);
				onLeavClick(Button_fonction);
				
			
				GestionMembre obj = new GestionMembre();
				obj.setVisible(true);
	  			obj.setLocationRelativeTo(null);
	  			dispose();
				
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
		Button_Membre.setBounds(0, 335, 226, 60);
		panel.add(Button_Membre);
		
		JLabel label_3 = new JLabel("Gestion des Membres");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(new Color(96, 83, 150));
		label_3.setFont(new Font("Segoe UI", Font.BOLD, 12));
		label_3.setBounds(47, 11, 139, 24);
		Button_Membre.add(label_3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(247,247,247));
		panel_3.setBounds(214, 0, 796, 500);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblWelcomBack = new JLabel("Gestion Equippage et Attribution");
		lblWelcomBack.setHorizontalAlignment(SwingConstants.LEFT);
		lblWelcomBack.setForeground(new Color(96, 83, 150));
		lblWelcomBack.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblWelcomBack.setBounds(20, 11, 304, 24);
		panel_3.add(lblWelcomBack);
		
		JLabel lblPayment = new JLabel("Nombre equippage");
		lblPayment.setHorizontalAlignment(SwingConstants.LEFT);
		lblPayment.setForeground(new Color(96, 83, 150));
		lblPayment.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblPayment.setBounds(397, 43, 128, 20);
		panel_3.add(lblPayment);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBounds(389, 74, 136, 67);
		panel_3.add(panel_7);
		
		txtnbr = new JLabel("");
		txtnbr.setHorizontalAlignment(SwingConstants.LEFT);
		txtnbr.setForeground(new Color(96, 83, 150));
		txtnbr.setFont(new Font("Segoe UI", Font.BOLD, 24));
		txtnbr.setBounds(20, 20, 74, 25);
		panel_7.add(txtnbr);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(373, 152, 390, 122);
		panel_3.add(scrollPane_1);
		
		tableEquippage = new JTable();
		tableEquippage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
			}
		});
		tableEquippage.setSelectionBackground(new Color(96, 83, 150));
		tableEquippage.setRowHeight(20);
		tableEquippage.setGridColor(new Color(247, 247, 247));
		tableEquippage.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		tableEquippage.setBorder(null);
		tableEquippage.setBackground(new Color(247, 247, 247));
		scrollPane_1.setViewportView(tableEquippage);
		
		txtLibell = new JTextField();
		txtLibell.setColumns(10);
		txtLibell.setBounds(114, 163, 196, 20);
		panel_3.add(txtLibell);
		
		JLabel lblNewLabel = new JLabel("libell\u00E9");
		lblNewLabel.setForeground(new Color(96, 83, 150));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBounds(20, 163, 85, 24);
		panel_3.add(lblNewLabel);
		
		JLabel lblMembre = new JLabel("Membre");
		lblMembre.setForeground(new Color(96, 83, 150));
		lblMembre.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblMembre.setBounds(30, 306, 113, 24);
		panel_3.add(lblMembre);
		
		JButton button = new JButton("Ajouter");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxEquipage.getSelectedItem().toString().equals("Sélectionner")|| comboBoxMembre.getSelectedItem().toString().equals("Sélectionner") ) {
					JOptionPane.showMessageDialog(null, "Veuiller remplir tout les champs");
				}else {
				membreEquippage = new MembreEquippage(Integer.parseInt(comboBoxMembre.getSelectedItem().toString()),Integer.parseInt(comboBoxEquipage.getSelectedItem().toString()));
				membreEquippage.AjouterMembreEquipage();
				update_table_Equip_Membree(table_Attribution);
				remplirCombo(comboBoxMembre,comboBoxEquipage);
				}
			}
		});
		
		button.setBackground(new Color(126, 87, 194));
		button.setBounds(20, 439, 108, 34);
		panel_3.add(button);
		
		
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxEquipage.getSelectedItem().toString().equals("Sélectionner")|| comboBoxMembre.getSelectedItem().toString().equals("Sélectionner") ) {
					JOptionPane.showMessageDialog(null, "Veuiller remplir tout les champs");
				}else {
				membreEquippage = new MembreEquippage(Integer.parseInt(comboBoxMembre.getSelectedItem().toString()),Integer.parseInt(comboBoxEquipage.getSelectedItem().toString()));
			    membreEquippage.Modifier();
			    update_table_Equip_Membree(table_Attribution);
			    remplirCombo(comboBoxMembre,comboBoxEquipage);
				}
			}
		});
		btnModifier.setBackground(new Color(126, 87, 194));
		btnModifier.setBounds(138, 439, 108, 34);
		panel_3.add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxEquipage.getSelectedItem().toString().equals("Sélectionner")|| comboBoxMembre.getSelectedItem().toString().equals("Sélectionner") ) {
					JOptionPane.showMessageDialog(null, "Veuiller remplir tout les champs");
				}else {
				membreEquippage = new MembreEquippage(Integer.parseInt(comboBoxMembre.getSelectedItem().toString()),Integer.parseInt(comboBoxEquipage.getSelectedItem().toString()));
			    membreEquippage.Supprimer();
			    update_table_Equip_Membree(table_Attribution);
			    remplirCombo(comboBoxMembre,comboBoxEquipage);
				}
			}
		});
		btnSupprimer.setBackground(new Color(126, 87, 194));
		btnSupprimer.setBounds(255, 439, 108, 34);
		panel_3.add(btnSupprimer);
		
		
		JLabel lblEquipage = new JLabel("Equipage");
		lblEquipage.setForeground(new Color(96, 83, 150));
		lblEquipage.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblEquipage.setBounds(36, 355, 96, 24);
		panel_3.add(lblEquipage);
		
		
		
		JButton btnAjouterEquipage = new JButton("Ajouter");
		btnAjouterEquipage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtLibell.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Veuiller remplir le champs Libellé");
					}else{
					equipage = new Equipage(txtLibell.getText());
					equipage.AjouterEquipage();
					update_table_Equippage(tableEquippage);
					remplirCombo(comboBoxMembre,comboBoxEquipage);

				}
			}
		});
		btnAjouterEquipage.setBackground(new Color(126, 87, 194));
		btnAjouterEquipage.setBounds(30, 210, 108, 34);
		panel_3.add(btnAjouterEquipage);
		
		 comboBoxMembre = new JComboBox();
		 comboBoxMembre.setEditable(true);
		comboBoxMembre.setBounds(158, 311, 130, 22);
		panel_3.add(comboBoxMembre);
	
		 comboBoxEquipage = new JComboBox();
		 comboBoxEquipage.setEditable(true);
		comboBoxEquipage.setBounds(160, 360, 128, 22);
		panel_3.add(comboBoxEquipage);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(373, 306, 390, 167);
		panel_3.add(scrollPane);
		
		table_Attribution = new JTable();
		table_Attribution.setSelectionBackground(new Color(96, 83, 150));
		table_Attribution.setRowHeight(20);
		table_Attribution.setGridColor(new Color(247, 247, 247));
		table_Attribution.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		table_Attribution.setBorder(null);
		table_Attribution.setBackground(new Color(247, 247, 247));
		scrollPane.setViewportView(table_Attribution);
	 	comboBoxMembre.addItem("Sélectionner");
    	comboBoxEquipage.addItem("Sélectionner");
    	
    

		remplirCombo(comboBoxMembre,comboBoxEquipage);
		update_table_Equippage(tableEquippage);
		update_table_Equip_Membree(table_Attribution);
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
    public void remplirCombo(JComboBox ComboBoxMembre,JComboBox ComboBoxEquipage) {
    	
		 Connection cnx = null;
	    	PreparedStatement requete = null ;
	    	ResultSet resultat = null ;
		 //remplir Membre
			cnx = ConnexionMySQL.connectDB();	
			String sql = "SELECT * FROM membre";

			try {
				requete = cnx.prepareStatement(sql);
				resultat = requete.executeQuery();
				while(resultat.next()) {
					String idMembre = resultat.getString("IDMEMBRE");
					
					ComboBoxMembre.addItem(idMembre);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//remplir Equipage
			cnx = ConnexionMySQL.connectDB();	
			sql = "SELECT * FROM Equippage";

			try {
				requete = cnx.prepareStatement(sql);
				resultat = requete.executeQuery();
				while(resultat.next()) {
					String idFonction = resultat.getString("IDEQUIPPAGE");
					
					ComboBoxEquipage.addItem(idFonction);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	public void update_table_Equippage(JTable table) {
			
		    Connection cnx = null;
		   	PreparedStatement requete = null ;
		   	ResultSet resultat = null ;
			   
				cnx = ConnexionMySQL.connectDB();	
				String sql = "SELECT * FROM Equippage";
	
				try {
					requete = cnx.prepareStatement(sql);
					resultat = requete.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(resultat));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
	public void update_table_Equip_Membree(JTable table) {
		
	    Connection cnx = null;
	   	PreparedStatement requete = null ;
	   	ResultSet resultat = null ;
		   
			cnx = ConnexionMySQL.connectDB();	
			String sql = "SELECT * FROM Equip_Membree";

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
			String sql = "SELECT COUNT(*) FROM Compagnie ";

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
