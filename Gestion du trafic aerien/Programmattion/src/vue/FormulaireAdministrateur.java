package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import modele.Utilisateur;
import net.proteanit.sql.DbUtils;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modele.ConnexionMySQL;
import modele.Poste;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JPasswordField;

public class FormulaireAdministrateur extends JFrame {

	private JPanel contentPane;
	private JTextField txtPseudo;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private Utilisateur utilisateur; 
	private JPasswordField txtmotDePasse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormulaireAdministrateur frame = new FormulaireAdministrateur();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormulaireAdministrateur() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setUndecorated(true);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(247,247,247));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPseudo = new JLabel("Pseudo");
		lblPseudo.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPseudo.setForeground(new Color(96, 83, 150));
		lblPseudo.setBounds(65, 109, 85, 24);
		contentPane.add(lblPseudo);
		
		JLabel lblmotDePasse = new JLabel("Password");
		lblmotDePasse.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblmotDePasse.setForeground(new Color(96, 83, 150));
		lblmotDePasse.setBounds(65, 163, 85, 24);
		contentPane.add(lblmotDePasse);
		
		JLabel lblPoste = new JLabel("Poste");
		lblPoste.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPoste.setForeground(new Color(96, 83, 150));
		lblPoste.setBounds(65, 216, 96, 24);
		contentPane.add(lblPoste);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNom.setForeground(new Color(96, 83, 150));
		lblNom.setBounds(65, 261, 85, 24);
		contentPane.add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPrenom.setForeground(new Color(96, 83, 150));
		lblPrenom.setBounds(65, 301, 85, 24);
		contentPane.add(lblPrenom);
		
		txtPseudo = new JTextField();
		txtPseudo.setBounds(179, 109, 117, 20);
		contentPane.add(txtPseudo);
		txtPseudo.setColumns(10);
		
		txtNom = new JTextField();
		txtNom.setBounds(181, 261, 115, 20);
		contentPane.add(txtNom);
		txtNom.setColumns(10);
		
		txtPrenom = new JTextField();
		txtPrenom.setColumns(10);
		txtPrenom.setBounds(179, 307, 115, 20);
		contentPane.add(txtPrenom);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBackground(new Color(126,87,194));
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtmotDePasse.equals("")||txtNom.equals("")||txtPrenom.equals("")||txtPseudo.equals("")) {
					JOptionPane.showMessageDialog(null, "Veuiller remplir tout les champs");
				}else {
		      utilisateur = new Utilisateur(txtPseudo.getText(), txtmotDePasse.getText(), txtNom.getText(), txtPrenom.getText(), Poste.ADMINISTRATEUR);
		      utilisateur.AjouterUtilisateur();
		      authentification obj = new authentification();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				dispose();
				}
			}
		});
		btnAjouter.setBounds(95, 338, 201, 34);
		contentPane.add(btnAjouter);
		
		JLabel lblPostee = new JLabel("Administrateur");
		lblPostee.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPostee.setBounds(179, 215, 117, 15);
		contentPane.add(lblPostee);
		
		JLabel lblNewLabel = new JLabel("Ajouter un Administrateur");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setForeground(SystemColor.activeCaption);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 36, 414, 48);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("X");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				authentification obj = new authentification();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				dispose();
			}
		});
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(57, 113, 177));
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(405, 0, 45, 36);
		contentPane.add(label);
		
		txtmotDePasse = new JPasswordField();
		txtmotDePasse.setBounds(179, 163, 117, 20);
		contentPane.add(txtmotDePasse);

	}

	    
		public void update_table(JTable table) {
		    Connection cnx = null;
	    	PreparedStatement requete = null ;
	    	ResultSet resultat = null ;
			cnx = ConnexionMySQL.connectDB();	
			String sql = "select * from utilisateur";

			try {
				requete = cnx.prepareStatement(sql);
				resultat = requete.executeQuery();
				requete.close();
      			cnx.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}		
}