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
import modele.PisteDegager;
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
import com.toedter.calendar.JDateChooser;
import javax.swing.JCheckBox;

public class AffichagePiste extends JFrame {

	private JPanel contentPane;
	private static JTable table;
	private Piste piste;
	private JScrollPane scrollPane;
	private JPanel Button_Piste;
	private JPanel Button_affichage;
	private JDateChooser dateChooser;
	private JCheckBox checkBoxheure;
	private JCheckBox checkBoxdate;
	private JTextField txtheure;
	private static JTable table_degager;
	private JScrollPane scrollPane_1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AffichagePiste frame = new AffichagePiste();
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
		
	public AffichagePiste() {
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
		pistes.setForeground(new Color(96,83,150));
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
		Button_affichage.setBounds(0, 207, 226, 60);
		panel.add(Button_affichage);
		
		JLabel lblAffichage = new JLabel("Affichage");
		lblAffichage.setHorizontalAlignment(SwingConstants.CENTER);
		lblAffichage.setForeground(new Color(181, 77, 180));
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
		
		JLabel lblPayment = new JLabel("Nombre de pistes reserver");
		lblPayment.setHorizontalAlignment(SwingConstants.LEFT);
		lblPayment.setForeground(new Color(96, 83, 150));
		lblPayment.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblPayment.setBounds(421, 46, 158, 20);
		panel_3.add(lblPayment);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(413, 186, 373, 303);
		panel_3.add(scrollPane);
		
		DefaultTableModel model = new DefaultTableModel();
		table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		table.setSelectionBackground(new Color(96, 83, 150));
		table.setRowHeight(20);
		table.setGridColor(new Color(247, 247, 247));
		table.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		table.setBorder(null);
		table.setBackground(new Color(247, 247, 247));
		update_table_piste_reserver(table);
		scrollPane.setViewportView(table);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 186, 377, 303);
		panel_3.add(scrollPane_1);
		
		table_degager = new JTable();
		scrollPane_1.setViewportView(table_degager);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(30, 80, 158, 67);
		panel_3.add(panel_1);
		
		JLabel nbrdagager = new JLabel("");
		nbrdagager.setHorizontalAlignment(SwingConstants.CENTER);
		nbrdagager.setForeground(new Color(96, 83, 150));
		nbrdagager.setFont(new Font("Segoe UI", Font.BOLD, 24));
		nbrdagager.setBounds(39, 16, 79, 33);
		panel_1.add(nbrdagager);
		
		JLabel lblNombreDePiste = new JLabel("Nombre de piste d\u00E9gager");
		lblNombreDePiste.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombreDePiste.setForeground(new Color(96, 83, 150));
		lblNombreDePiste.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNombreDePiste.setBounds(38, 46, 150, 20);
		panel_3.add(lblNombreDePiste);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(421, 77, 158, 67);
		panel_3.add(panel_2);
		
		JLabel label = new JLabel(Integer.toString(PisteReserver.listePisteReserver().size()));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(96, 83, 150));
		label.setFont(new Font("Segoe UI", Font.BOLD, 24));
		label.setBounds(39, 16, 79, 33);
		panel_2.add(label);
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-dd");
		dateChooser.setEnabled(false);
		dateChooser.setBounds(198, 84, 114, 20);
		panel_3.add(dateChooser);
		
		checkBoxdate = new JCheckBox("");
		checkBoxdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (checkBoxdate.isSelected()) {
					dateChooser.setEnabled(true);
				}else {
					dateChooser.setEnabled(false);
				}
			}
		});
		checkBoxdate.setBounds(318, 80, 28, 23);
		panel_3.add(checkBoxdate);
		
		txtheure = new JTextField();
		txtheure.setToolTipText("");
		txtheure.setEnabled(false);
		txtheure.setBounds(198, 124, 114, 20);
		panel_3.add(txtheure);
		txtheure.setColumns(10);
		
		checkBoxheure = new JCheckBox("");
		checkBoxheure.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (checkBoxheure.isSelected()) {
					txtheure.setEnabled(true);
				}
				else {
					txtheure.setEnabled(false);
				}
			}
		});
		checkBoxheure.setBounds(318, 124, 28, 23);
		panel_3.add(checkBoxheure);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if (checkBoxdate.isSelected()&&checkBoxheure.isSelected()) {
				if (txtheure.getText().isEmpty() && ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText().isEmpty() ) {
					JOptionPane.showMessageDialog(null, "Veuilliez saisir l'heure et la date ");
				}else if (txtheure.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Veuilliez saisir l'heure");
				}else if (((JTextField)dateChooser.getDateEditor().getUiComponent()).getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Veuilliez saisir la date");
				}
				update_table_piste_dagager_date_heure(table_degager, ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText(), txtheure.getText(),nbrdagager);
				scrollPane_1.setViewportView(table_degager);
			}else if (checkBoxdate.isSelected()) {
				if (((JTextField)dateChooser.getDateEditor().getUiComponent()).getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Veuilliez saisir la date");
				}else {
				update_table_piste_dagager_date(table_degager, ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText(),nbrdagager);
				scrollPane_1.setViewportView(table_degager);
				}
			}
			}
		});
		btnOk.setBackground(new Color(126, 87, 194));
		btnOk.setBounds(204, 155, 108, 24);
		panel_3.add(btnOk);
		
		
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
	
	public void update_table_piste_reserver(JTable table){
		DefaultTableModel model = new DefaultTableModel();
		
		 model.setColumnIdentifiers(new String[]{"idPiste","Aeroport","date","heure"});
	        for (int i = 0; i < PisteReserver.listePisteReserver().size(); i++) {
				model.addRow(new String[] {Integer.toString(PisteReserver.listePisteReserver().get(i).getIdPiste())
						,PisteReserver.listePisteReserver().get(i).getAeroport().getIdAeroport()
						,PisteReserver.listePisteReserver().get(i).getDate(),
						PisteReserver.listePisteReserver().get(i).getHeure()});
			}
	        
	        table.setModel(model);
		
	}
	public void update_table_piste_dagager_date_heure(JTable table,String date,String heure,JLabel nbrdagager){
		DefaultTableModel model = new DefaultTableModel();
		int nbr = 0;
		 model.setColumnIdentifiers(new String[]{"idPiste","Aeroport"});
	        for (int i = 0; i < PisteDegager.listePisteDegager_date_heure(date, heure).size(); i++) {
				model.addRow(new String[] {Integer.toString(PisteDegager.listePisteDegager_date_heure(date, heure).get(i).getIdPiste())
						,PisteDegager.listePisteDegager_date_heure(date, heure).get(i).getAeroport().getIdAeroport()
						});
				nbr++;
			}
	        nbrdagager.setText(Integer.toString(nbr));
	        
	        table.setModel(model);
		
	}
	public void update_table_piste_dagager_date(JTable table,String date,JLabel nbrdagager){
		DefaultTableModel model = new DefaultTableModel();
		int nbr = 0;
		 model.setColumnIdentifiers(new String[]{"idPiste","Aeroport"});
	        for (int i = 0; i < PisteDegager.listePisteDegager_date(date).size(); i++) {
				model.addRow(new String[] {Integer.toString(PisteDegager.listePisteDegager_date(date).get(i).getIdPiste())
						,PisteDegager.listePisteDegager_date(date).get(i).getAeroport().getIdAeroport()
						});
				nbr++;
			}
	        nbrdagager.setText(Integer.toString(nbr));
	        
	        table.setModel(model);
		
	}
	

}
