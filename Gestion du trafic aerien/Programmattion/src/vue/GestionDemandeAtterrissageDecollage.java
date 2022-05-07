package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modele.ConnexionMySQL;
import modele.DemandeVol ;
import modele.Etat;
import modele.PisteDegager;
import modele.PisteReserver;
import modele.Redevance;

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
import javax.swing.JCheckBox;

public class GestionDemandeAtterrissageDecollage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtvol;
	private JTextField txtduree;
	private JDateChooser dateChooser;
	private JComboBox comboBoxType;
	private JTextField txtHeure;
	private JComboBox comboBoxAccord;
	private JComboBox comboBoxpiste ;
	private DemandeVol demandeVol ;
	private Redevance redevance;
	private PisteReserver pisteReserver;
	private JPanel Button_Vol;
	private JPanel Button_Affichage;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionDemandeAtterrissageDecollage frame = new GestionDemandeAtterrissageDecollage();
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
		
	public GestionDemandeAtterrissageDecollage() {
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
				CoordinateuDeVol obj = new CoordinateuDeVol();
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
		
		Button_Affichage = new JPanel();
		Button_Affichage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				onClick(Button_Affichage);
			
				onLeavClick(Button_Acceuil);
				onLeavClick(Button_Vol);
				
				
				
				GestionDecollagerAterrissage obj = new GestionDecollagerAterrissage();
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
		Button_Affichage.setBounds(0, 204, 226, 60);
		panel.add(Button_Affichage);
		
		JLabel label = new JLabel("Affichage des demandes");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(96, 83, 150));
		label.setFont(new Font("Segoe UI", Font.BOLD, 12));
		label.setBounds(56, 18, 149, 24);
		Button_Affichage.add(label);
		
		Button_Vol = new JPanel();
		Button_Vol.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClick(Button_Vol);
				onLeavClick(Button_Acceuil);
				onLeavClick(Button_Affichage);
							
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
		Button_Vol.setBounds(0, 144, 226, 60);
		panel.add(Button_Vol);
		
		JLabel label_1 = new JLabel("Gestion des demandes de vol");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(new Color(181,77,180));
		label_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		label_1.setBounds(25, 18, 191, 24);
		Button_Vol.add(label_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(247,247,247));
		panel_3.setBounds(214, 0, 796, 500);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblWelcomBack = new JLabel("Gestion des demandes d\u2019atterrissage et d\u00E9collages");
		lblWelcomBack.setHorizontalAlignment(SwingConstants.LEFT);
		lblWelcomBack.setForeground(new Color(96, 83, 150));
		lblWelcomBack.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblWelcomBack.setBounds(20, 11, 454, 24);
		panel_3.add(lblWelcomBack);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(396, 160, 390, 331);
		panel_3.add(scrollPane_1);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int ligne = table.getSelectedRow();
				txtvol.setText(table.getModel().getValueAt(ligne,0).toString());
				txtHeure.setText(table.getModel().getValueAt(ligne,2).toString());
				
				try {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					int seectRow = table.getSelectedRow();
					Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(seectRow,1).toString());
					dateChooser.setDate(date);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				comboBoxType.setSelectedItem(table.getModel().getValueAt(ligne,3).toString());
				remplircomboPiste(comboBoxpiste,table.getModel().getValueAt(ligne,1).toString(),table.getModel().getValueAt(ligne,2).toString());			

				
				
				//dateChooser.setDate(new Date(table.getModel().getValueAt(ligne,0).toString()));			
			}
		});
		table.setSelectionBackground(new Color(96, 83, 150));
		table.setRowHeight(20);
		table.setGridColor(new Color(247, 247, 247));
		table.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		table.setBorder(null);
		table.setBackground(new Color(247, 247, 247));
		scrollPane_1.setViewportView(table);
		
		JButton buttonOk = new JButton("Ok");
		buttonOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtduree.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Veuiller remplir la durree");
				}else {
					try {
				demandeVol = new DemandeVol(txtvol.getText(), ( (JTextField)dateChooser.getDateEditor().getUiComponent()).getText(),Double.parseDouble(txtduree.getText()), comboBoxAccord.getSelectedItem().toString(), comboBoxType.getSelectedItem().toString(), Integer.parseInt(comboBoxpiste.getSelectedItem().toString()) ,txtHeure.getText());
			    demandeVol.AjouterDemandeVol();	
			   redevance = new Redevance(demandeVol.getVol().getIdvol(),false, demandeVol.getVol().getCompagnie().getIdCompagnie());
            redevance.ajouter();
            pisteReserver = new PisteReserver(Integer.parseInt(comboBoxpiste.getSelectedItem().toString()),( (JTextField)dateChooser.getDateEditor().getUiComponent()).getText(), txtHeure.getText());
			pisteReserver.AjouterPisteReserver();
					}catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Veuiller remplir tout les champ");
					}
			}
			}
		});
		
		buttonOk.setBackground(new Color(126, 87, 194));
		buttonOk.setBounds(132, 432, 108, 34);
		panel_3.add(buttonOk);
		update_table(table);
		
		//Nbr(txtnbr);
		
		txtvol = new JTextField();
		txtvol.setEnabled(false);
		txtvol.setColumns(10);
		txtvol.setBounds(99, 100, 99, 20);
		panel_3.add(txtvol);
		
	    dateChooser = new JDateChooser();
	    dateChooser.setEnabled(false);
		dateChooser.setDateFormatString("yyyy-MM-dd");	
		dateChooser.setBounds(99, 159, 99, 20);
		panel_3.add(dateChooser);
		
		txtduree = new JTextField();
		txtduree.setColumns(10);
		txtduree.setBounds(99, 230, 99, 20);
		panel_3.add(txtduree);
		
		comboBoxAccord = new JComboBox();
		comboBoxAccord.setBounds(99, 281, 99, 22);
		panel_3.add(comboBoxAccord);
		comboBoxAccord.addItem("sélectionner");
		comboBoxAccord.addItem("true");
		comboBoxAccord.addItem("false");
		
		JLabel lblaccord = new JLabel("Accord");
		lblaccord.setForeground(new Color(96, 83, 150));
		lblaccord.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblaccord.setBounds(30, 279, 67, 24);
		panel_3.add(lblaccord);
		
		JLabel lblduree = new JLabel("duree");
		lblduree.setForeground(new Color(96, 83, 150));
		lblduree.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblduree.setBounds(30, 224, 61, 24);
		panel_3.add(lblduree);
		
		JLabel lbldate = new JLabel("date");
		lbldate.setForeground(new Color(96, 83, 150));
		lbldate.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lbldate.setBounds(30, 155, 67, 24);
		panel_3.add(lbldate);
		
		JLabel lblVol = new JLabel("idVol");
		lblVol.setForeground(new Color(96, 83, 150));
		lblVol.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblVol.setBounds(30, 94, 85, 24);
		panel_3.add(lblVol);
		
		comboBoxType = new JComboBox();
		comboBoxType.setEnabled(false);
		comboBoxType.setBounds(101, 334, 97, 22);
		panel_3.add(comboBoxType);
		comboBoxType.addItem(" ");
		comboBoxType.addItem("ATEERISSAGE");
		comboBoxType.addItem("DECOLLAGE");
		
		JLabel lbltype = new JLabel("Type");
		lbltype.setForeground(new Color(96, 83, 150));
		lbltype.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lbltype.setBounds(30, 332, 67, 24);
		panel_3.add(lbltype);
		
		comboBoxpiste = new JComboBox();
		comboBoxpiste.setBounds(101, 387, 97, 22);
		panel_3.add(comboBoxpiste);
		
		JLabel lblpiste = new JLabel("Piste");
		lblpiste.setForeground(new Color(96, 83, 150));
		lblpiste.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblpiste.setBounds(30, 385, 67, 24);
		panel_3.add(lblpiste);
		
		JButton ButtonDecollage = new JButton("Decollage");
		ButtonDecollage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Connection cnx = null;
			     	PreparedStatement requete = null ;
			     	ResultSet resultat = null ;
			 		cnx = ConnexionMySQL.connectDB();	
			 		String sql = "SELECT idVol,dateDep,HEUREDEPART,('DECOLLAGE') 'type' FROM `vol` WHERE dateDep = CURRENT_DATE and HEUREDEPART > SUBTIME(CURRENT_TIME,'00') and idAeroportDep ='DAAE' ";

			 		try {
			 			requete = cnx.prepareStatement(sql);
			 			resultat = requete.executeQuery();
			 			table.setModel(DbUtils.resultSetToTableModel(resultat));
			 		} catch (SQLException en) {
			 			// TODO Auto-generated catch block
			 			en.printStackTrace();
			 		}	
			}
		});
		ButtonDecollage.setBounds(680, 124, 89, 23);
		panel_3.add(ButtonDecollage);
		
		JButton btnAtterrrissage = new JButton("Atterrrissage");
		btnAtterrrissage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Connection cnx = null;
			    	PreparedStatement requete = null ;
			    	ResultSet resultat = null ;
					cnx = ConnexionMySQL.connectDB();	
					String sql = "SELECT idVol,dateArriver, HEUREARRIVER,('ATEERISSAGE') 'type' FROM `vol` WHERE dateArriver = CURRENT_DATE and HEUREARRIVER > SUBTIME(CURRENT_TIME,'1800') and HEUREARRIVER < CURRENT_TIME and idAeroportArriver ='DAAE'";

					try {
						requete = cnx.prepareStatement(sql);
						resultat = requete.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(resultat));
					} catch (SQLException eh) {
						// TODO Auto-generated catch block
						eh.printStackTrace();
					}	
			}
		});
		btnAtterrrissage.setBounds(572, 124, 99, 23);
		panel_3.add(btnAtterrrissage);
		
	
	txtHeure = new JTextField();
	txtHeure.setEnabled(false);
	txtHeure.setColumns(10);
	txtHeure.setBounds(99, 194, 99, 20);
	panel_3.add(txtHeure);
	
	JLabel lblHeure = new JLabel("Heure");
	lblHeure.setForeground(new Color(96, 83, 150));
	lblHeure.setFont(new Font("Tahoma", Font.PLAIN, 19));
	lblHeure.setBounds(30, 190, 61, 24);
	panel_3.add(lblHeure);
	
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
	
		
		
	}
	
	    public void remplircomboPiste(JComboBox comboBoxpiste,String date,String heure) {
			//remplir combo piste
		   
		    for (int i = 0; i < PisteDegager.listePisteDegager_date_heure(date, heure).size(); i++) {
		    	comboBoxpiste.addItem(PisteDegager.listePisteDegager_date_heure(date, heure).get(i).getIdPiste());			
			}

		}
}
