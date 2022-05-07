package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modele.ConnexionMySQL;
import modele.Piste;
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
import javax.swing.ScrollPaneConstants;

public class GestionVol extends JFrame {

	private JPanel contentPane;
	private static JTable table;
	private Vol vol;
	private JTextField txtHeureArriver;
	private JTextField txtNbEscale;
	private JTextField txtFretVol;
	private JLabel txtnbr ;
	private JTextField txtHeureDepart;
	private JTextField txtNbPassager;
	private JComboBox comboBoxAeroportDepart;
	private JComboBox comboBoxTypeVol;
	private JComboBox comboBoxAeronef;
	private JComboBox comboBoxAeroportArriver;
	private JComboBox comboBoxEquipage;
	private JDateChooser dateChooserDepart;
	private JDateChooser dateChooserArriver;
	private JComboBox comboBoxCompagnie;
	private JTextField txtdistance;
	private JPanel Button_Affichage;
	private JPanel Button_Vol;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionVol frame = new GestionVol();
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
		
	public GestionVol() {
		setLocationByPlatform(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setUndecorated(true);
		setBounds(100, 100, 1000,600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204,204,204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 226, 614);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel Button_Acceuil = new JPanel();
		JPanel Button_déconnexion = new JPanel();

		
		Button_Acceuil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClick(Button_Acceuil);
				
				IngenieurPreparateurDeVol obj = new IngenieurPreparateurDeVol();
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
		Button_déconnexion.setBounds(0, 543, 226, 60);
		panel.add(Button_déconnexion);
		
		JLabel lblTaskView = new JLabel("d\u00E9connexion");
		lblTaskView.setHorizontalAlignment(SwingConstants.CENTER);
		lblTaskView.setForeground(Color.WHITE);
		lblTaskView.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblTaskView.setBounds(56, 18, 123, 24);
		Button_déconnexion.add(lblTaskView);
		
		 Button_Vol = new JPanel();
		 Button_Vol.setBackground(new Color(205,136,205));
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
		
		JLabel label = new JLabel("Gestion des vols");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(181,77,180));
		label.setFont(new Font("Segoe UI", Font.BOLD, 12));
		label.setBounds(56, 18, 134, 24);
		Button_Vol.add(label);
		
		 Button_Affichage = new JPanel();
		 Button_Affichage.addMouseListener(new MouseAdapter() {
			 @Override
				public void mouseClicked(MouseEvent e) {
				
					onClick(Button_Affichage);
				
					onLeavClick(Button_Acceuil);
					onLeavClick(Button_Vol);
					
					
					
					AffichageVol obj = new AffichageVol();
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
		
		JLabel label_1 = new JLabel("Affichage vol");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(new Color(96, 83, 150));
		label_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		label_1.setBounds(56, 18, 134, 24);
		Button_Affichage.add(label_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(247,247,247));
		panel_3.setBounds(214, 0, 796, 625);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblWelcomBack = new JLabel("Gestion des Vol");
		lblWelcomBack.setHorizontalAlignment(SwingConstants.LEFT);
		lblWelcomBack.setForeground(new Color(96, 83, 150));
		lblWelcomBack.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblWelcomBack.setBounds(20, 11, 414, 24);
		panel_3.add(lblWelcomBack);
		
		JLabel lblPayment = new JLabel("Nombre de vol");
		lblPayment.setHorizontalAlignment(SwingConstants.LEFT);
		lblPayment.setForeground(new Color(96, 83, 150));
		lblPayment.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblPayment.setBounds(421, 46, 128, 20);
		panel_3.add(lblPayment);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBounds(413, 80, 136, 67);
		panel_3.add(panel_7);
		
		txtnbr = new JLabel(Integer.toString(Vol.listeVol().size()));
		txtnbr.setHorizontalAlignment(SwingConstants.LEFT);
		txtnbr.setForeground(new Color(96, 83, 150));
		txtnbr.setFont(new Font("Segoe UI", Font.BOLD, 24));
		txtnbr.setBounds(20, 20, 74, 25);
		panel_7.add(txtnbr);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(384, 158, 402, 422);
		panel_3.add(scrollPane_1);
		
		DefaultTableModel model = new DefaultTableModel();
		table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int ligne = table.getSelectedRow();
				txtdistance.setText(table.getModel().getValueAt(ligne,14).toString());
				txtFretVol.setText(table.getModel().getValueAt(ligne,7).toString());
				txtHeureArriver.setText(table.getModel().getValueAt(ligne,13).toString());
				txtHeureDepart.setText(table.getModel().getValueAt(ligne,12).toString());
				txtNbEscale.setText(table.getModel().getValueAt(ligne,5).toString());
				txtNbPassager.setText(table.getModel().getValueAt(ligne,6).toString());
			
				comboBoxAeronef.setSelectedItem(table.getModel().getValueAt(ligne,11).toString());
				comboBoxAeroportArriver.setSelectedItem(table.getModel().getValueAt(ligne,4).toString());
				comboBoxAeroportDepart.setSelectedItem(table.getModel().getValueAt(ligne,3).toString());
				comboBoxCompagnie.setSelectedItem(table.getModel().getValueAt(ligne,8).toString());
				comboBoxEquipage.setSelectedItem(table.getModel().getValueAt(ligne,9).toString());
				comboBoxTypeVol.setSelectedItem(table.getModel().getValueAt(ligne,10).toString());
				
				try {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					int seectRow = table.getSelectedRow();
					Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(seectRow,1).toString());
					dateChooserDepart.setDate(date);
					date = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(seectRow,2).toString());
					dateChooserArriver.setDate(date);
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
		
		JLabel lblDateDepart = new JLabel("Date depart");
		lblDateDepart.setForeground(new Color(96, 83, 150));
		lblDateDepart.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblDateDepart.setBounds(32, 50, 118, 24);
		panel_3.add(lblDateDepart);
		
		  dateChooserDepart = new JDateChooser();
		  dateChooserDepart.setDateFormatString("yyyy-MM-dd");
			dateChooserDepart.setBounds(191, 54, 114, 20);
			panel_3.add(dateChooserDepart);
			
			dateChooserArriver = new JDateChooser();
			dateChooserArriver.setDateFormatString("yyyy-MM-dd");
			dateChooserArriver.setBounds(191, 162, 114, 20);
			panel_3.add(dateChooserArriver);
		
		JLabel lblHeuredepart = new JLabel("Heure depart");
		lblHeuredepart.setForeground(new Color(96, 83, 150));
		lblHeuredepart.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblHeuredepart.setBounds(32, 90, 136, 24);
		panel_3.add(lblHeuredepart);
		
		JButton button = new JButton("Ajouter");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String dateDep = ( (JTextField)dateChooserDepart.getDateEditor().getUiComponent()).getText();
				String dateArriver =( (JTextField) dateChooserArriver.getDateEditor().getUiComponent()).getText();
				if(dateDep.equals("")||dateArriver.equals("")||comboBoxAeroportDepart.getSelectedItem().toString().equals("Sélectionner")||comboBoxAeroportArriver.getSelectedItem().toString().equals("Sélectionner")||txtNbEscale.getText().equals("")||txtNbPassager.getText().equals("")||txtFretVol.getText().equals("")||comboBoxCompagnie.getSelectedItem().toString().equals("Sélectionner")||comboBoxTypeVol.getSelectedItem().toString().equals("Sélectionner")|| comboBoxAeronef.getSelectedItem().toString().equals("Sélectionner")||comboBoxEquipage.getSelectedItem().toString().equals("Sélectionner")||txtHeureDepart.getText().equals("")||txtHeureArriver.getText().equals("")||txtdistance.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Veuiller remplir tout les champs");
				}else {
					try {
				if(comboBoxTypeVol.getSelectedItem().toString().equals("COMMERCIAL_regulier"))
				   vol = new Vol(dateChooserDepart.getDate(), dateChooserArriver.getDate(), comboBoxAeroportDepart.getSelectedItem().toString(), comboBoxAeroportArriver.getSelectedItem().toString(),Integer.parseInt(txtNbEscale.getText()),Integer.parseInt(txtNbPassager.getText()),Double.parseDouble(txtFretVol.getText()),comboBoxCompagnie.getSelectedItem().toString(), TypeVol.COMMERCIAL_regulier, comboBoxAeronef.getSelectedItem().toString(),Integer.parseInt(comboBoxEquipage.getSelectedItem().toString()),txtHeureDepart.getText(),txtHeureArriver.getText(),Integer.parseInt(txtdistance.getText()));
				else
					if(comboBoxTypeVol.getSelectedItem().toString().equals("COMMERCIAL_OCCASIONNEL"))
						   vol = new Vol(dateChooserDepart.getDate(), dateChooserArriver.getDate(), comboBoxAeroportDepart.getSelectedItem().toString(), comboBoxAeroportArriver.getSelectedItem().toString(),Integer.parseInt(txtNbEscale.getText()),Integer.parseInt(txtNbPassager.getText()),Double.parseDouble(txtFretVol.getText()),comboBoxCompagnie.getSelectedItem().toString(), TypeVol.COMMERCIAL_OCCASIONNEL, comboBoxAeronef.getSelectedItem().toString(),Integer.parseInt(comboBoxEquipage.getSelectedItem().toString()),txtHeureDepart.getText(),txtHeureArriver.getText(),Integer.parseInt(txtdistance.getText()));
					else
						if(comboBoxTypeVol.getSelectedItem().toString().equals("NON_COMMERCIAL"))
							   vol = new Vol(dateChooserDepart.getDate(), dateChooserArriver.getDate(), comboBoxAeroportDepart.getSelectedItem().toString(), comboBoxAeroportArriver.getSelectedItem().toString(),Integer.parseInt(txtNbEscale.getText()),Integer.parseInt(txtNbPassager.getText()),Double.parseDouble(txtFretVol.getText()),comboBoxCompagnie.getSelectedItem().toString(), TypeVol.NON_COMMERCIAL, comboBoxAeronef.getSelectedItem().toString(),Integer.parseInt(comboBoxEquipage.getSelectedItem().toString()),txtHeureDepart.getText(),txtHeureArriver.getText(),Integer.parseInt(txtdistance.getText()));
						else
							if(comboBoxTypeVol.getSelectedItem().toString().equals("MILITAIRE"))
								   vol = new Vol(dateChooserDepart.getDate(), dateChooserArriver.getDate(), comboBoxAeroportDepart.getSelectedItem().toString(), comboBoxAeroportArriver.getSelectedItem().toString(),Integer.parseInt(txtNbEscale.getText()),Integer.parseInt(txtNbPassager.getText()),Double.parseDouble(txtFretVol.getText()),comboBoxCompagnie.getSelectedItem().toString(), TypeVol.MILITAIRE, comboBoxAeronef.getSelectedItem().toString(),Integer.parseInt(comboBoxEquipage.getSelectedItem().toString()),txtHeureDepart.getText(),txtHeureArriver.getText(),Integer.parseInt(txtdistance.getText()));
							else
								if(comboBoxTypeVol.getSelectedItem().toString().equals("GOUVERNEMENTAL"))
									   vol = new Vol(dateChooserDepart.getDate(), dateChooserArriver.getDate(), comboBoxAeroportDepart.getSelectedItem().toString(), comboBoxAeroportArriver.getSelectedItem().toString(),Integer.parseInt(txtNbEscale.getText()),Integer.parseInt(txtNbPassager.getText()),Double.parseDouble(txtFretVol.getText()),comboBoxCompagnie.getSelectedItem().toString(), TypeVol.GOUVERNEMENTAL, comboBoxAeronef.getSelectedItem().toString(),Integer.parseInt(comboBoxEquipage.getSelectedItem().toString()),txtHeureDepart.getText(),txtHeureArriver.getText(),Integer.parseInt(txtdistance.getText()));
								else
									if(comboBoxTypeVol.getSelectedItem().toString().equals("HUMANITAIRE"))
										   vol = new Vol(dateChooserDepart.getDate(), dateChooserArriver.getDate(), comboBoxAeroportDepart.getSelectedItem().toString(), comboBoxAeroportArriver.getSelectedItem().toString(),Integer.parseInt(txtNbEscale.getText()),Integer.parseInt(txtNbPassager.getText()),Double.parseDouble(txtFretVol.getText()),comboBoxCompagnie.getSelectedItem().toString(), TypeVol.HUMANITAIRE, comboBoxAeronef.getSelectedItem().toString(),Integer.parseInt(comboBoxEquipage.getSelectedItem().toString()),txtHeureDepart.getText(),txtHeureArriver.getText(),Integer.parseInt(txtdistance.getText()));
			
				vol.AjouterVol();
				txtnbr.setText(Integer.toString(Vol.listeVol().size()));
				update_table(table);
				scrollPane_1.setViewportView(table);
					}catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Veuiller remplir tout les champ comme il se doit");
					}
				}
			}
		});
		
		button.setBackground(new Color(126, 87, 194));
		button.setBounds(32, 549, 108, 34);
		panel_3.add(button);
		
		
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ligne = table.getSelectedRow();

				String dateDep = ( (JTextField)dateChooserDepart.getDateEditor().getUiComponent()).getText();
				String dateArriver =( (JTextField) dateChooserArriver.getDateEditor().getUiComponent()).getText();
				if(dateDep.equals("")||dateArriver.equals("")||comboBoxAeroportDepart.getSelectedItem().toString().equals("Sélectionner")||comboBoxAeroportArriver.getSelectedItem().toString().equals("Sélectionner")||txtNbEscale.getText().equals("")||txtNbPassager.getText().equals("")||txtFretVol.getText().equals("")||comboBoxCompagnie.getSelectedItem().toString().equals("Sélectionner")||comboBoxTypeVol.getSelectedItem().toString().equals("Sélectionner")|| comboBoxAeronef.getSelectedItem().toString().equals("Sélectionner")||comboBoxEquipage.getSelectedItem().toString().equals("Sélectionner")||txtHeureDepart.getText().equals("")||txtHeureArriver.getText().equals("")||txtdistance.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Veuiller remplir tout les champs");
				}else {		
					try {
				if(comboBoxTypeVol.getSelectedItem().toString().equals("COMMERCIAL_regulier"))
				   vol = new Vol(table.getModel().getValueAt(ligne,0).toString(),dateDep, dateArriver, comboBoxAeroportDepart.getSelectedItem().toString(), comboBoxAeroportArriver.getSelectedItem().toString(),Integer.parseInt(txtNbEscale.getText()),Integer.parseInt(txtNbPassager.getText()),Double.parseDouble(txtFretVol.getText()),comboBoxCompagnie.getSelectedItem().toString(), TypeVol.COMMERCIAL_regulier, comboBoxAeronef.getSelectedItem().toString(),Integer.parseInt(comboBoxEquipage.getSelectedItem().toString()),txtHeureDepart.getText(),txtHeureArriver.getText(),Double.parseDouble(txtdistance.getText()));
				else
					if(comboBoxTypeVol.getSelectedItem().toString().equals("COMMERCIAL_OCCASIONNEL"))
						   vol = new Vol(table.getModel().getValueAt(ligne,0).toString(),dateDep, dateArriver, comboBoxAeroportDepart.getSelectedItem().toString(), comboBoxAeroportArriver.getSelectedItem().toString(),Integer.parseInt(txtNbEscale.getText()),Integer.parseInt(txtNbPassager.getText()),Double.parseDouble(txtFretVol.getText()),comboBoxCompagnie.getSelectedItem().toString(), TypeVol.COMMERCIAL_OCCASIONNEL, comboBoxAeronef.getSelectedItem().toString(),Integer.parseInt(comboBoxEquipage.getSelectedItem().toString()),txtHeureDepart.getText(),txtHeureArriver.getText(),Double.parseDouble(txtdistance.getText()));
					else
						if(comboBoxTypeVol.getSelectedItem().toString().equals("NON_COMMERCIAL"))
							   vol = new Vol(table.getModel().getValueAt(ligne,0).toString(),dateDep, dateArriver, comboBoxAeroportDepart.getSelectedItem().toString(), comboBoxAeroportArriver.getSelectedItem().toString(),Integer.parseInt(txtNbEscale.getText()),Integer.parseInt(txtNbPassager.getText()),Double.parseDouble(txtFretVol.getText()),comboBoxCompagnie.getSelectedItem().toString(), TypeVol.NON_COMMERCIAL, comboBoxAeronef.getSelectedItem().toString(),Integer.parseInt(comboBoxEquipage.getSelectedItem().toString()),txtHeureDepart.getText(),txtHeureArriver.getText(),Double.parseDouble(txtdistance.getText()));
						else
							if(comboBoxTypeVol.getSelectedItem().toString().equals("MILITAIRE"))
								   vol = new Vol(table.getModel().getValueAt(ligne,0).toString(),dateDep, dateArriver, comboBoxAeroportDepart.getSelectedItem().toString(), comboBoxAeroportArriver.getSelectedItem().toString(),Integer.parseInt(txtNbEscale.getText()),Integer.parseInt(txtNbPassager.getText()),Double.parseDouble(txtFretVol.getText()),comboBoxCompagnie.getSelectedItem().toString(), TypeVol.MILITAIRE, comboBoxAeronef.getSelectedItem().toString(),Integer.parseInt(comboBoxEquipage.getSelectedItem().toString()),txtHeureDepart.getText(),txtHeureArriver.getText(),Double.parseDouble(txtdistance.getText()));
							else
								if(comboBoxTypeVol.getSelectedItem().toString().equals("GOUVERNEMENTAL"))
									   vol = new Vol(table.getModel().getValueAt(ligne,0).toString(),dateDep, dateArriver, comboBoxAeroportDepart.getSelectedItem().toString(), comboBoxAeroportArriver.getSelectedItem().toString(),Integer.parseInt(txtNbEscale.getText()),Integer.parseInt(txtNbPassager.getText()),Double.parseDouble(txtFretVol.getText()),comboBoxCompagnie.getSelectedItem().toString(), TypeVol.GOUVERNEMENTAL, comboBoxAeronef.getSelectedItem().toString(),Integer.parseInt(comboBoxEquipage.getSelectedItem().toString()),txtHeureDepart.getText(),txtHeureArriver.getText(),Double.parseDouble(txtdistance.getText()));
								else
									if(comboBoxTypeVol.getSelectedItem().toString().equals("HUMANITAIRE"))
										   vol = new Vol(table.getModel().getValueAt(ligne,0).toString(),dateDep, dateArriver, comboBoxAeroportDepart.getSelectedItem().toString(), comboBoxAeroportArriver.getSelectedItem().toString(),Integer.parseInt(txtNbEscale.getText()),Integer.parseInt(txtNbPassager.getText()),Double.parseDouble(txtFretVol.getText()),comboBoxCompagnie.getSelectedItem().toString(), TypeVol.HUMANITAIRE, comboBoxAeronef.getSelectedItem().toString(),Integer.parseInt(comboBoxEquipage.getSelectedItem().toString()),txtHeureDepart.getText(),txtHeureArriver.getText(),Double.parseDouble(txtdistance.getText()));
			
				vol.Modifier();
				update_table(table);
				scrollPane_1.setViewportView(table);
					}catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Veuiller remplir tout les champ comme il se doit");
					}
				}
			}
		});
		btnModifier.setBackground(new Color(126, 87, 194));
		btnModifier.setBounds(150, 549, 108, 34);
		panel_3.add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ligne = table.getSelectedRow();

				String dateDep = ( (JTextField)dateChooserDepart.getDateEditor().getUiComponent()).getText();
				String dateArriver =( (JTextField) dateChooserArriver.getDateEditor().getUiComponent()).getText();
				if(dateDep.equals("")||dateArriver.equals("")||comboBoxAeroportDepart.getSelectedItem().toString().equals("Sélectionner")||comboBoxAeroportArriver.getSelectedItem().toString().equals("Sélectionner")||txtNbEscale.getText().equals("")||txtNbPassager.getText().equals("")||txtFretVol.getText().equals("")||comboBoxCompagnie.getSelectedItem().toString().equals("Sélectionner")||comboBoxTypeVol.getSelectedItem().toString().equals("Sélectionner")|| comboBoxAeronef.getSelectedItem().toString().equals("Sélectionner")||comboBoxEquipage.getSelectedItem().toString().equals("Sélectionner")||txtHeureDepart.getText().equals("")||txtHeureArriver.getText().equals("")||txtdistance.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Veuiller remplir tout les champs");
				}else {
				if(comboBoxTypeVol.getSelectedItem().toString().equals("COMMERCIAL_regulier"))
				   vol = new Vol(table.getModel().getValueAt(ligne,0).toString(),dateDep, dateArriver, comboBoxAeroportDepart.getSelectedItem().toString(), comboBoxAeroportArriver.getSelectedItem().toString(),Integer.parseInt(txtNbEscale.getText()),Integer.parseInt(txtNbPassager.getText()),Double.parseDouble(txtFretVol.getText()),comboBoxCompagnie.getSelectedItem().toString(), TypeVol.COMMERCIAL_regulier, comboBoxAeronef.getSelectedItem().toString(),Integer.parseInt(comboBoxEquipage.getSelectedItem().toString()),txtHeureDepart.getText(),txtHeureArriver.getText(),Double.parseDouble(txtdistance.getText()));
				else
					if(comboBoxTypeVol.getSelectedItem().toString().equals("COMMERCIAL_OCCASIONNEL"))
						   vol = new Vol(table.getModel().getValueAt(ligne,0).toString(),dateDep, dateArriver, comboBoxAeroportDepart.getSelectedItem().toString(), comboBoxAeroportArriver.getSelectedItem().toString(),Integer.parseInt(txtNbEscale.getText()),Integer.parseInt(txtNbPassager.getText()),Double.parseDouble(txtFretVol.getText()),comboBoxCompagnie.getSelectedItem().toString(), TypeVol.COMMERCIAL_OCCASIONNEL, comboBoxAeronef.getSelectedItem().toString(),Integer.parseInt(comboBoxEquipage.getSelectedItem().toString()),txtHeureDepart.getText(),txtHeureArriver.getText(),Double.parseDouble(txtdistance.getText()));
					else
						if(comboBoxTypeVol.getSelectedItem().toString().equals("NON_COMMERCIAL"))
							   vol = new Vol(table.getModel().getValueAt(ligne,0).toString(),dateDep, dateArriver, comboBoxAeroportDepart.getSelectedItem().toString(), comboBoxAeroportArriver.getSelectedItem().toString(),Integer.parseInt(txtNbEscale.getText()),Integer.parseInt(txtNbPassager.getText()),Double.parseDouble(txtFretVol.getText()),comboBoxCompagnie.getSelectedItem().toString(), TypeVol.NON_COMMERCIAL, comboBoxAeronef.getSelectedItem().toString(),Integer.parseInt(comboBoxEquipage.getSelectedItem().toString()),txtHeureDepart.getText(),txtHeureArriver.getText(),Double.parseDouble(txtdistance.getText()));
						else
							if(comboBoxTypeVol.getSelectedItem().toString().equals("MILITAIRE"))
								   vol = new Vol(table.getModel().getValueAt(ligne,0).toString(),dateDep, dateArriver, comboBoxAeroportDepart.getSelectedItem().toString(), comboBoxAeroportArriver.getSelectedItem().toString(),Integer.parseInt(txtNbEscale.getText()),Integer.parseInt(txtNbPassager.getText()),Double.parseDouble(txtFretVol.getText()),comboBoxCompagnie.getSelectedItem().toString(), TypeVol.MILITAIRE, comboBoxAeronef.getSelectedItem().toString(),Integer.parseInt(comboBoxEquipage.getSelectedItem().toString()),txtHeureDepart.getText(),txtHeureArriver.getText(),Double.parseDouble(txtdistance.getText()));
							else
								if(comboBoxTypeVol.getSelectedItem().toString().equals("GOUVERNEMENTAL"))
									   vol = new Vol(table.getModel().getValueAt(ligne,0).toString(),dateDep, dateArriver, comboBoxAeroportDepart.getSelectedItem().toString(), comboBoxAeroportArriver.getSelectedItem().toString(),Integer.parseInt(txtNbEscale.getText()),Integer.parseInt(txtNbPassager.getText()),Double.parseDouble(txtFretVol.getText()),comboBoxCompagnie.getSelectedItem().toString(), TypeVol.GOUVERNEMENTAL, comboBoxAeronef.getSelectedItem().toString(),Integer.parseInt(comboBoxEquipage.getSelectedItem().toString()),txtHeureDepart.getText(),txtHeureArriver.getText(),Double.parseDouble(txtdistance.getText()));
								else
									if(comboBoxTypeVol.getSelectedItem().toString().equals("HUMANITAIRE"))
										   vol = new Vol(table.getModel().getValueAt(ligne,0).toString(),dateDep, dateArriver, comboBoxAeroportDepart.getSelectedItem().toString(), comboBoxAeroportArriver.getSelectedItem().toString(),Integer.parseInt(txtNbEscale.getText()),Integer.parseInt(txtNbPassager.getText()),Double.parseDouble(txtFretVol.getText()),comboBoxCompagnie.getSelectedItem().toString(), TypeVol.HUMANITAIRE, comboBoxAeronef.getSelectedItem().toString(),Integer.parseInt(comboBoxEquipage.getSelectedItem().toString()),txtHeureDepart.getText(),txtHeureArriver.getText(),Integer.parseInt(txtdistance.getText()));
			
				vol.Supprimer();
				txtnbr.setText(Integer.toString(Vol.listeVol().size()));
				update_table(table);
				scrollPane_1.setViewportView(table);
				}			
			}
		});
		btnSupprimer.setBackground(new Color(126, 87, 194));
		btnSupprimer.setBounds(271, 549, 108, 34);
		panel_3.add(btnSupprimer);
		
		
		JLabel lblHeureArrive = new JLabel("Heure Arriver");
		lblHeureArrive.setForeground(new Color(96, 83, 150));
		lblHeureArrive.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblHeureArrive.setBounds(32, 194, 124, 24);
		panel_3.add(lblHeureArrive);
		
		JLabel lblNbEscale = new JLabel("Nombre escale");
		lblNbEscale.setForeground(new Color(96, 83, 150));
		lblNbEscale.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNbEscale.setBounds(32, 265, 138, 24);
		panel_3.add(lblNbEscale);
		
		txtHeureArriver = new JTextField();
		txtHeureArriver.setColumns(10);
		txtHeureArriver.setBounds(187, 200, 118, 20);
		panel_3.add(txtHeureArriver);
		
		txtNbEscale = new JTextField();
		txtNbEscale.setColumns(10);
		txtNbEscale.setBounds(187, 271, 118, 20);
		panel_3.add(txtNbEscale);
		
		txtFretVol = new JTextField();
		txtFretVol.setBounds(187, 302, 118, 20);
		panel_3.add(txtFretVol);
		txtFretVol.setColumns(10);
		
	  
		
		JLabel lblDateArrive = new JLabel("Date arriver");
		lblDateArrive.setForeground(new Color(96, 83, 150));
		lblDateArrive.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblDateArrive.setBounds(32, 159, 128, 24);
		panel_3.add(lblDateArrive);
		
		txtHeureDepart = new JTextField();
		txtHeureDepart.setColumns(10);
		txtHeureDepart.setBounds(187, 96, 118, 20);
		panel_3.add(txtHeureDepart);
		
	    comboBoxAeroportDepart = new JComboBox();
		comboBoxAeroportDepart.setBounds(188, 128, 117, 22);
		panel_3.add(comboBoxAeroportDepart);
		
		JLabel lblAeroportDep = new JLabel("Aeroport Depart");
		lblAeroportDep.setForeground(new Color(96, 83, 150));
		lblAeroportDep.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblAeroportDep.setBounds(32, 125, 146, 24);
		panel_3.add(lblAeroportDep);
		
		comboBoxAeroportArriver = new JComboBox();
		comboBoxAeroportArriver.setBounds(188, 231, 117, 22);
		panel_3.add(comboBoxAeroportArriver);
		
		JLabel lblAeroportArrive = new JLabel("Aeroport Arriver");
		lblAeroportArrive.setForeground(new Color(96, 83, 150));
		lblAeroportArrive.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblAeroportArrive.setBounds(32, 229, 136, 24);
		panel_3.add(lblAeroportArrive);
		
		JLabel lblFretvol = new JLabel("Fret vol");
		lblFretvol.setForeground(new Color(96, 83, 150));
		lblFretvol.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblFretvol.setBounds(30, 300, 138, 24);
		panel_3.add(lblFretvol);
		
		txtNbPassager = new JTextField();
		txtNbPassager.setColumns(10);
		txtNbPassager.setBounds(187, 340, 118, 20);
		panel_3.add(txtNbPassager);
		
		JLabel lblNbPassager = new JLabel("Nombre passager");
		lblNbPassager.setForeground(new Color(96, 83, 150));
		lblNbPassager.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNbPassager.setBounds(32, 335, 158, 24);
		panel_3.add(lblNbPassager);
		
		comboBoxCompagnie = new JComboBox();
		comboBoxCompagnie.setBounds(187, 371, 118, 22);
		panel_3.add(comboBoxCompagnie);
		
		JLabel lblCompagnie = new JLabel("Compagnie");
		lblCompagnie.setForeground(new Color(96, 83, 150));
		lblCompagnie.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblCompagnie.setBounds(32, 370, 138, 24);
		panel_3.add(lblCompagnie);
		
		comboBoxTypeVol = new JComboBox();
		comboBoxTypeVol.setBounds(187, 404, 118, 22);
		panel_3.add(comboBoxTypeVol);
		
		JLabel lblTypeVol = new JLabel("TypeVol");
		lblTypeVol.setForeground(new Color(96, 83, 150));
		lblTypeVol.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblTypeVol.setBounds(32, 405, 138, 24);
		panel_3.add(lblTypeVol);
		
	   comboBoxAeronef = new JComboBox();
		comboBoxAeronef.setBounds(187, 437, 118, 22);
		panel_3.add(comboBoxAeronef);
		
		JLabel lblAeronef = new JLabel("Aeronef");
		lblAeronef.setForeground(new Color(96, 83, 150));
		lblAeronef.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblAeronef.setBounds(32, 440, 138, 24);
		panel_3.add(lblAeronef);
		
		comboBoxEquipage = new JComboBox();
		comboBoxEquipage.setBounds(187, 470, 118, 22);
		panel_3.add(comboBoxEquipage);
		
		JLabel lblEquipage = new JLabel("Equipage");
		lblEquipage.setForeground(new Color(96, 83, 150));
		lblEquipage.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblEquipage.setBounds(30, 475, 138, 24);
		panel_3.add(lblEquipage);
		
		
		remplir(comboBoxTypeVol);
		 remplirCombo(comboBoxAeroportDepart,comboBoxAeroportArriver,comboBoxCompagnie,comboBoxAeronef,comboBoxEquipage);
		 
		 JLabel lblDistance = new JLabel("distance");
		 lblDistance.setForeground(new Color(96, 83, 150));
		 lblDistance.setFont(new Font("Tahoma", Font.PLAIN, 19));
		 lblDistance.setBounds(32, 510, 138, 24);
		 panel_3.add(lblDistance);
		 
		 txtdistance = new JTextField();
		 txtdistance.setColumns(10);
		 txtdistance.setBounds(187, 503, 118, 20);
		 panel_3.add(txtdistance);
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
				String sql = "SELECT * FROM vol";

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
    public void remplir(JComboBox ComboBoxTypeVol) {
		//remplir combo
    	ComboBoxTypeVol.addItem("Sélectionner");
	    List<TypeVol> list = Arrays.asList(TypeVol.values());
	    for (int i = 0; i < list.size(); i++) {
	    	ComboBoxTypeVol.addItem(list.get(i));			
		}

	}
    public void remplirCombo(JComboBox ComboBoxAeroportDepart,JComboBox ComboBoxAeroportArriver,JComboBox ComboBoxCompagnie,JComboBox ComboBoxAeronef,JComboBox ComboBoxEquipage) {
		ComboBoxAeronef.addItem("Sélectionner");
		ComboBoxAeroportArriver.addItem("Sélectionner");
		ComboBoxAeroportDepart.addItem("Sélectionner");
		ComboBoxCompagnie.addItem("Sélectionner");
		ComboBoxEquipage.addItem("Sélectionner");
		
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
			
			//remplir Aeronef
			cnx = ConnexionMySQL.connectDB();	
			sql = "SELECT * FROM Aeronef";

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
			//remplir Aeroport
			cnx = ConnexionMySQL.connectDB();	
			sql = "SELECT * FROM Aeroport";

			try {
				requete = cnx.prepareStatement(sql);
				resultat = requete.executeQuery();
				while(resultat.next()) {
					String Aeroport = resultat.getString("IDAEROPORT");
					
					ComboBoxAeroportDepart.addItem(Aeroport);
				}
				requete.close();
				cnx.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cnx = ConnexionMySQL.connectDB();	
			sql = "SELECT * FROM Aeroport";

			try {
				requete = cnx.prepareStatement(sql);
				resultat = requete.executeQuery();
				while(resultat.next()) {
					String Aeroport = resultat.getString("IDAEROPORT");
					
					ComboBoxAeroportArriver.addItem(Aeroport);
				}
				requete.close();
				cnx.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Equippage
			cnx = ConnexionMySQL.connectDB();	
			sql = "SELECT * FROM Equippage";

			try {
				requete = cnx.prepareStatement(sql);
				resultat = requete.executeQuery();
				while(resultat.next()) {
					String Equipage = resultat.getString("IDEQUIPPAGE");
					
					ComboBoxEquipage.addItem(Equipage);
				}
				requete.close();
				cnx.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
}
