package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modele.ConnexionMySQL;
import modele.Fonction;
import modele.Piste;
import modele.TypeAeronef;
import modele.Aeronef;
import modele.Attribution;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

public class GestionFonction extends JFrame {

	private Attribution attribution ;

	private JPanel contentPane;
	private JTable table;
	Aeronef aeronef;
	private JComboBox comboBoxFonction;
	private JComboBox comboBoxMembre;
	private JLabel txtnbr ;
	private static JScrollPane scrollPane_1;
	private JPanel Button_Aeronef;
	private JPanel Button_Equipage;
	private JPanel Button_fonction;
	private JPanel Button_Membre;
	private JDateChooser dateChooser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionFonction frame = new GestionFonction();
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
		
	public GestionFonction() {
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
		 
	    Button_Aeronef = new JPanel();
	    Button_Aeronef.addMouseListener(new MouseAdapter() {
	    	@Override
			public void mouseClicked(MouseEvent e) {
				onClick(Button_Aeronef);
				onLeavClick(Button_Acceuil);
				onLeavClick(Button_Equipage);
				onLeavClick(Button_fonction);
				onLeavClick(Button_Membre);
				
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
		
		JLabel label = new JLabel("Gestion des aeronefs");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(181,77,180));
		label.setFont(new Font("Segoe UI", Font.BOLD, 12));
		label.setBounds(56, 18, 134, 24);
		Button_Aeronef.add(label);
		
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
		
		JLabel label_1 = new JLabel("Gestion des equipages");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(new Color(96, 83, 150));
		label_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		label_1.setBounds(47, 11, 139, 24);
		Button_Equipage.add(label_1);
		
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
		Button_Membre.setBounds(0, 337, 226, 60);
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
		
		JLabel lblWelcomBack = new JLabel("Gestion des fonctions");
		lblWelcomBack.setHorizontalAlignment(SwingConstants.LEFT);
		lblWelcomBack.setForeground(new Color(96, 83, 150));
		lblWelcomBack.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblWelcomBack.setBounds(20, 11, 414, 24);
		panel_3.add(lblWelcomBack);
		
		JLabel lbl = new JLabel("Nombre d'attribution");
		lbl.setHorizontalAlignment(SwingConstants.LEFT);
		lbl.setForeground(new Color(96, 83, 150));
		lbl.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lbl.setBounds(421, 46, 128, 20);
		panel_3.add(lbl);
		
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
		
	    scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(384, 158, 390, 331);
		panel_3.add(scrollPane_1);
		
		DefaultTableModel model = new DefaultTableModel();
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int ligne = table.getSelectedRow();
				comboBoxFonction.setSelectedItem(table.getModel().getValueAt(ligne,2).toString());

				comboBoxMembre.setSelectedItem(table.getModel().getValueAt(ligne,1).toString());
				try {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					int seectRow = table.getSelectedRow();
					Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(seectRow,3).toString());
					dateChooser.setDate(date);
					
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
		
		JLabel lblFonction = new JLabel("Fonction");
		lblFonction.setForeground(new Color(96, 83, 150));
		lblFonction.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblFonction.setBounds(33, 255, 96, 24);
		panel_3.add(lblFonction);
		
		JButton button = new JButton("Ajouter");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxFonction.getSelectedItem().toString().equals("Sélectionner")||comboBoxMembre.getSelectedItem().toString().equals("Sélectionner")||((JTextField)dateChooser.getDateEditor().getUiComponent()).getText().equals("")){
					JOptionPane.showMessageDialog(null, "Veuiller remplir tout les champs");
				}else {
				if(comboBoxFonction.getSelectedItem().toString().equals("PILOTE"))
		   		    attribution = new Attribution(Integer.parseInt(comboBoxMembre.getSelectedItem().toString()),Fonction.PILOTE, ( (JTextField)dateChooser.getDateEditor().getUiComponent()).getText());
				else
					if(comboBoxFonction.getSelectedItem().toString().equals("COMMANDANT_DE_BORD"))
				   		attribution = new Attribution(Integer.parseInt(comboBoxMembre.getSelectedItem().toString()),Fonction.COMMANDANT_DE_BORD, ( (JTextField)dateChooser.getDateEditor().getUiComponent()).getText());
					else
						if(comboBoxFonction.getSelectedItem().toString().equals("COPILOTE"))
					   		attribution = new Attribution(Integer.parseInt(comboBoxMembre.getSelectedItem().toString()),Fonction.COPILOTE, ( (JTextField)dateChooser.getDateEditor().getUiComponent()).getText());
						else 
							if(comboBoxFonction.getSelectedItem().toString().equals("STEWARDS"))
						   		attribution = new Attribution(Integer.parseInt(comboBoxMembre.getSelectedItem().toString()),Fonction.STEWARDS, ( (JTextField)dateChooser.getDateEditor().getUiComponent()).getText());
							else 
								if(comboBoxFonction.getSelectedItem().toString().equals("HOTESSES"))
							   		attribution = new Attribution(Integer.parseInt(comboBoxMembre.getSelectedItem().toString()),Fonction.HOTESSES, ( (JTextField)dateChooser.getDateEditor().getUiComponent()).getText());
				attribution.Ajouter();
				update_table(table);
				Nbr(txtnbr);
				}	
			}
		});
		
		button.setBackground(new Color(126, 87, 194));
		button.setBounds(30, 441, 108, 34);
		panel_3.add(button);
		
		
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ligne = table.getSelectedRow();
				if(comboBoxFonction.getSelectedItem().toString().equals("Sélectionner")||comboBoxMembre.getSelectedItem().toString().equals("Sélectionner")||((JTextField)dateChooser.getDateEditor().getUiComponent()).getText().equals("")){
					JOptionPane.showMessageDialog(null, "Veuiller remplir tout les champs");
				}else {
				if(comboBoxFonction.getSelectedItem().toString().equals("PILOTE"))
		   		    attribution = new Attribution(Integer.parseInt(table.getModel().getValueAt(ligne,0).toString()),Integer.parseInt(comboBoxMembre.getSelectedItem().toString()),Fonction.PILOTE, ( (JTextField)dateChooser.getDateEditor().getUiComponent()).getText());
				else
					if(comboBoxFonction.getSelectedItem().toString().equals("COMMANDANT_DE_BORD"))
				   		attribution = new Attribution(Integer.parseInt(table.getModel().getValueAt(ligne,0).toString()),Integer.parseInt(comboBoxMembre.getSelectedItem().toString()),Fonction.COMMANDANT_DE_BORD, ( (JTextField)dateChooser.getDateEditor().getUiComponent()).getText());
					else
						if(comboBoxFonction.getSelectedItem().toString().equals("COPILOTE"))
					   		attribution = new Attribution(Integer.parseInt(table.getModel().getValueAt(ligne,0).toString()),Integer.parseInt(comboBoxMembre.getSelectedItem().toString()),Fonction.COPILOTE, ( (JTextField)dateChooser.getDateEditor().getUiComponent()).getText());
						else 
							if(comboBoxFonction.getSelectedItem().toString().equals("STEWARDS"))
						   		attribution = new Attribution(Integer.parseInt(table.getModel().getValueAt(ligne,0).toString()),Integer.parseInt(comboBoxMembre.getSelectedItem().toString()),Fonction.STEWARDS, ( (JTextField)dateChooser.getDateEditor().getUiComponent()).getText());
							else 
								if(comboBoxFonction.getSelectedItem().toString().equals("HOTESSES"))
							   		attribution = new Attribution(Integer.parseInt(table.getModel().getValueAt(ligne,0).toString()),Integer.parseInt(comboBoxMembre.getSelectedItem().toString()),Fonction.HOTESSES, ( (JTextField)dateChooser.getDateEditor().getUiComponent()).getText());
				attribution.Modifier();
				update_table(table);
				Nbr(txtnbr);
				}
			}
		});
		btnModifier.setBackground(new Color(126, 87, 194));
		btnModifier.setBounds(148, 441, 108, 34);
		panel_3.add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ligne = table.getSelectedRow();
				if(comboBoxFonction.getSelectedItem().toString().equals("Sélectionner")||comboBoxMembre.getSelectedItem().toString().equals("Sélectionner")||((JTextField)dateChooser.getDateEditor().getUiComponent()).getText().equals("")){
					JOptionPane.showMessageDialog(null, "Veuiller remplir tout les champs");
				}else {
				if(comboBoxFonction.getSelectedItem().toString().equals("PILOTE"))
		   		    attribution = new Attribution(Integer.parseInt(table.getModel().getValueAt(ligne,0).toString()),Integer.parseInt(comboBoxMembre.getSelectedItem().toString()),Fonction.PILOTE, ( (JTextField)dateChooser.getDateEditor().getUiComponent()).getText());
				else
					if(comboBoxFonction.getSelectedItem().toString().equals("COMMANDANT_DE_BORD"))
				   		attribution = new Attribution(Integer.parseInt(table.getModel().getValueAt(ligne,0).toString()),Integer.parseInt(comboBoxMembre.getSelectedItem().toString()),Fonction.COMMANDANT_DE_BORD, ( (JTextField)dateChooser.getDateEditor().getUiComponent()).getText());
					else
						if(comboBoxFonction.getSelectedItem().toString().equals("COPILOTE"))
					   		attribution = new Attribution(Integer.parseInt(table.getModel().getValueAt(ligne,0).toString()),Integer.parseInt(comboBoxMembre.getSelectedItem().toString()),Fonction.COPILOTE, ( (JTextField)dateChooser.getDateEditor().getUiComponent()).getText());
						else 
							if(comboBoxFonction.getSelectedItem().toString().equals("STEWARDS"))
						   		attribution = new Attribution(Integer.parseInt(table.getModel().getValueAt(ligne,0).toString()),Integer.parseInt(comboBoxMembre.getSelectedItem().toString()),Fonction.STEWARDS, ( (JTextField)dateChooser.getDateEditor().getUiComponent()).getText());
							else 
								if(comboBoxFonction.getSelectedItem().toString().equals("HOTESSES"))
							   		attribution = new Attribution(Integer.parseInt(table.getModel().getValueAt(ligne,0).toString()),Integer.parseInt(comboBoxMembre.getSelectedItem().toString()),Fonction.HOTESSES, ( (JTextField)dateChooser.getDateEditor().getUiComponent()).getText());
				attribution.Supprimer();
				update_table(table);
				Nbr(txtnbr);
				}
			}
		});
		btnSupprimer.setBackground(new Color(126, 87, 194));
		btnSupprimer.setBounds(266, 441, 108, 34);
		panel_3.add(btnSupprimer);
		
		
		JLabel lblCapacite = new JLabel("date");
		lblCapacite.setForeground(new Color(96, 83, 150));
		lblCapacite.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblCapacite.setBounds(33, 303, 96, 24);
		panel_3.add(lblCapacite);
		
		JLabel lblMembre = new JLabel("Membre");
		lblMembre.setForeground(new Color(96, 83, 150));
		lblMembre.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblMembre.setBounds(33, 218, 96, 24);
		panel_3.add(lblMembre);
		
	    comboBoxMembre = new JComboBox();
		comboBoxMembre.setBounds(139, 221, 185, 22);
		panel_3.add(comboBoxMembre);
		
		comboBoxFonction = new JComboBox();
		comboBoxFonction.setBounds(139, 260, 185, 22);
		panel_3.add(comboBoxFonction);
		
		
		update_table(table);
		scrollPane_1.setViewportView(table);
		Nbr(txtnbr);
		
		 dateChooser = new JDateChooser();
		dateChooser.setBounds(140, 307, 143, 20);
		dateChooser.setDateFormatString("yyyy-MM-dd");
		panel_3.add(dateChooser);
		
		remplir_fonction(comboBoxFonction);
		remplir_Membre(comboBoxMembre);
		
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
				String sql = "SELECT * FROM Attribution";

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
		
	
	public void remplir_fonction(JComboBox comboBoxFonction) {
		//remplir combo
		comboBoxFonction.addItem("Sélectionner");
	    List<Fonction> list = Arrays.asList(Fonction.values());
	    for (int i = 0; i < list.size(); i++) {
	    	comboBoxFonction.addItem(list.get(i));			
		}

	}
	public void remplir_Membre(JComboBox ComboBoxMembre) {
		comboBoxMembre.addItem("Sélectionner");
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
			
			
		}
	 private void Nbr(JLabel txtnbr) {
			Connection cnx = null;
	    	PreparedStatement requete = null ;
	    	ResultSet resultat = null ;
			
			
			cnx = ConnexionMySQL.connectDB();	
			String sql = "SELECT COUNT(*) FROM attribution ";

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
