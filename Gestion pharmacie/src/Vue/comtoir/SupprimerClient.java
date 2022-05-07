package Vue.comtoir;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SupprimerClient extends JFrame {

	private JPanel contentPane;
	private JButton btnSupprimer;
	private JLabel txtnom;
	private JLabel txtprenom;
	private JLabel txtidCollaborateur;
	private JLabel lblIdcollaborateur;
	private JButton btnAnnuler;
	private JLabel lblAge;
	private JLabel txtage;
	private JLabel lblNumsecurite;
	private JLabel txtnumSecurite;
	private JLabel lblMaladiechro;
	private JLabel txtmaladiechro;

	public JButton getBtnSupprimer() {
		return btnSupprimer;
	}
	public JLabel getTxtidCollaborateur() {
		return txtidCollaborateur;
	}
	
	public JLabel getTxtnom() {
		return txtnom;
	}
	public JLabel getTxtprenom() {
		return txtprenom;
	}
	public JLabel getTxtage() {
		return txtage;
	}
	public JLabel getTxtnumSecurite() {
		return txtnumSecurite;
	}
	public JLabel getTxtmaladiechro() {
		return txtmaladiechro;
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
	public SupprimerClient() {
		setTitle("Confirmation de suppression");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 464, 375);
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
		 btnSupprimer.setBounds(76, 296, 107, 23);
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
		btnAnnuler.setBounds(228, 296, 107, 23);
		contentPane.add(btnAnnuler);
		
		lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAge.setBounds(14, 151, 203, 27);
		contentPane.add(lblAge);
		
		txtage = new JLabel("");
		txtage.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtage.setBounds(227, 151, 221, 27);
		contentPane.add(txtage);
		
		lblNumsecurite = new JLabel("NumSecurite");
		lblNumsecurite.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNumsecurite.setBounds(14, 199, 203, 27);
		contentPane.add(lblNumsecurite);
		
		txtnumSecurite = new JLabel("");
		txtnumSecurite.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtnumSecurite.setBounds(227, 199, 221, 27);
		contentPane.add(txtnumSecurite);
		
		lblMaladiechro = new JLabel("Maladiechro");
		lblMaladiechro.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaladiechro.setBounds(14, 248, 203, 27);
		contentPane.add(lblMaladiechro);
		
		txtmaladiechro = new JLabel("");
		txtmaladiechro.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtmaladiechro.setBounds(227, 248, 221, 27);
		contentPane.add(txtmaladiechro);

	}
}
