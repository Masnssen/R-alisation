package Vue.comtoir;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controle.comptoir.ClientContro;

public class GestionClient extends JFrame {

	private JPanel contentPane;
	private JTextField txtnom;
	private JTextField txtprenom;
	private JTextField txtage;
	private JTextField txtmaladiechro;
	private JTextField txtnumsec;
	private JTable table;
	private JButton btnsupprimerclient;	
	private JButton btnmodifierclient;
	private JButton btnajouterclient;
	private JButton btnReturn;
	

	public JTextField getTxtnom() {
		return txtnom;
	}

	public JTextField getTxtprenom() {
		return txtprenom;
	}

	public JTextField getTxtage() {
		return txtage;
	}

	public JTextField getTxtmaladiechro() {
		return txtmaladiechro;
	}

	public JTextField getTxtnumsec() {
		return txtnumsec;
	}

	public JTable getTable() {
		return table;
	}
	public JPanel getContentPane() {
		return contentPane;
	}
	public JButton getBtnsupprimerclient() {
		return btnsupprimerclient;
	}

	public JButton getBtnmodifierclient() {
		return btnmodifierclient;
	}

	public JButton getBtnajouterclient() {
		return btnajouterclient;
	}



	/**
	 * Create the frame.
	 */
	public GestionClient() {
		setTitle("Gestion Client");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setUndecorated(true);

		setBounds(100, 100, 700, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtnom = new JTextField();
		txtnom.setColumns(10);
		txtnom.setBounds(108, 74, 118, 20);
		contentPane.add(txtnom);
		
		JLabel lblnomCollaborateur = new JLabel("Nom ");
		lblnomCollaborateur.setForeground(Color.BLACK);
		lblnomCollaborateur.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblnomCollaborateur.setBounds(24, 66, 74, 24);
		contentPane.add(lblnomCollaborateur);
		
		JLabel lblnumtel = new JLabel("Prenom");
		lblnumtel.setForeground(Color.BLACK);
		lblnumtel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblnumtel.setBounds(24, 101, 74, 24);
		contentPane.add(lblnumtel);
		
		txtprenom = new JTextField();
		txtprenom.setColumns(10);
		txtprenom.setBounds(108, 109, 118, 20);
		contentPane.add(txtprenom);
		
		txtage = new JTextField();
		txtage.setColumns(10);
		txtage.setBounds(108, 140, 118, 20);
		contentPane.add(txtage);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setForeground(Color.BLACK);
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblAge.setBounds(24, 140, 74, 24);
		contentPane.add(lblAge);
		
		 btnajouterclient = new JButton("Ajouter");
		btnajouterclient.setBackground(Color.WHITE);
		btnajouterclient.setBounds(124, 187, 130, 33);
		contentPane.add(btnajouterclient);
		
		 btnmodifierclient = new JButton("Modifier");
		btnmodifierclient.setEnabled(false);
		btnmodifierclient.setBackground(Color.WHITE);
		btnmodifierclient.setBounds(301, 187, 130, 33);
		contentPane.add(btnmodifierclient);
		
		 btnsupprimerclient = new JButton("Supprimer");
		btnsupprimerclient.setEnabled(false);
		btnsupprimerclient.setBackground(Color.WHITE);
		btnsupprimerclient.setBounds(478, 187, 130, 33);
		contentPane.add(btnsupprimerclient);
		
		txtmaladiechro = new JTextField();
		txtmaladiechro.setColumns(10);
		txtmaladiechro.setBounds(500, 117, 127, 20);
		contentPane.add(txtmaladiechro);
		
		JLabel lblAdresse_1_1 = new JLabel("maladiechro");
		lblAdresse_1_1.setForeground(Color.BLACK);
		lblAdresse_1_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblAdresse_1_1.setBounds(383, 111, 107, 24);
		contentPane.add(lblAdresse_1_1);
		
		JLabel lblNumsecurite = new JLabel("NumSecurite");
		lblNumsecurite.setForeground(Color.BLACK);
		lblNumsecurite.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNumsecurite.setBounds(383, 74, 118, 24);
		contentPane.add(lblNumsecurite);
		
		txtnumsec = new JTextField();
		txtnumsec.setColumns(10);
		txtnumsec.setBounds(500, 80, 127, 20);
		contentPane.add(txtnumsec);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 231, 664, 273);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id","Nom", "Prenom", "Age", "NumSecurite", "Maladiechro"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblGestionClient = new JLabel("Gestion Client");
		lblGestionClient.setHorizontalAlignment(SwingConstants.LEFT);
		lblGestionClient.setForeground(Color.BLACK);
		lblGestionClient.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblGestionClient.setBounds(10, 11, 414, 24);
		contentPane.add(lblGestionClient);
		
		 btnReturn = new JButton("return");
		btnReturn.setBackground(Color.WHITE);
		btnReturn.setBounds(560, 521, 130, 33);
		contentPane.add(btnReturn);
	}
}
