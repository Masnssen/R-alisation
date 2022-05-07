package Vue.Commercial;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SupprimerMedecin extends JFrame {

	private JPanel contentPane;
	private JButton btnSupprimer;
	private JLabel txtnom;
	private JLabel txtprenom;
	private JLabel txtidCollaborateur;
	private JLabel lblIdcollaborateur;
	private JButton btnAnnuler;
	private JLabel lblSpecialite;
	private JLabel txtspecialite;
	private JLabel lblAdresse;
	private JLabel txtadresse;

	public JButton getBtnSupprimer() {
		return btnSupprimer;
	}
	public JLabel getTxtnom() {
		return txtnom;
	}
	public JLabel getTxtprenom() {
		return txtprenom;
	}
	public JLabel getTxtspecialite() {
		return txtspecialite;
	}
	public JLabel getTxtadresse() {
		return txtadresse;
	}
	public JLabel getLblIdcollaborateur() {
		return txtidCollaborateur;
	}
	public JButton getBtnAnnuler() {
		return btnAnnuler;
	}

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public SupprimerMedecin() {
		setTitle("Confirmation de suppression");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 464, 384);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblnom = new JLabel("Nom collaborateur");
		lblnom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblnom.setBounds(14, 63, 190, 27);
		contentPane.add(lblnom);
		
		JLabel lblType = new JLabel("Prenom Collaborateur");
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblType.setBounds(14, 101, 203, 27);
		contentPane.add(lblType);
		
		 txtnom = new JLabel("");
		txtnom.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtnom.setBounds(227, 63, 221, 27);
		contentPane.add(txtnom);
		
	     txtprenom = new JLabel("");
		txtprenom.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtprenom.setBounds(227, 101, 221, 27);
		contentPane.add(txtprenom);
		
		 btnSupprimer = new JButton("Supprimer");
		 btnSupprimer.setBounds(72, 286, 107, 23);
		 contentPane.add(btnSupprimer);
		
		txtidCollaborateur = new JLabel("");
		txtidCollaborateur.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtidCollaborateur.setBounds(227, 25, 221, 27);
		contentPane.add(txtidCollaborateur);
		
		lblIdcollaborateur = new JLabel("Id");
		lblIdcollaborateur.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIdcollaborateur.setBounds(14, 25, 107, 27);
		contentPane.add(lblIdcollaborateur);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(224, 286, 107, 23);
		contentPane.add(btnAnnuler);
		
		lblSpecialite = new JLabel("Specialite");
		lblSpecialite.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSpecialite.setBounds(14, 139, 203, 27);
		contentPane.add(lblSpecialite);
		
		txtspecialite = new JLabel("");
		txtspecialite.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtspecialite.setBounds(227, 139, 221, 27);
		contentPane.add(txtspecialite);
		
		lblAdresse = new JLabel("Adresse");
		lblAdresse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAdresse.setBounds(14, 185, 203, 27);
		contentPane.add(lblAdresse);
		
		txtadresse = new JLabel("");
		txtadresse.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtadresse.setBounds(227, 185, 221, 27);
		contentPane.add(txtadresse);

	}
}
