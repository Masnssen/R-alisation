package Vue.Commercial;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ModifierFournisseur extends JFrame {

	private JPanel contentPane;
	private JButton btnModifier;
	private JLabel lblIdcollaborateur;
	private JButton btnAnnuler;
	private JTextField txtidCollaborateur;
	private JTextField txtnomcollaborateur;
	private JTextField txtprenomcollaborateur;
	
		

	public JButton getBtnModifier() {
		return btnModifier;
	}

	public JButton getBtnAnnuler() {
		return btnAnnuler;
	}

	public JTextField getTxtidCollaborateur() {
		return txtidCollaborateur;
	}

	public JTextField getTxtnomcollaborateur() {
		return txtnomcollaborateur;
	}

	public JTextField getTxtprenomcollaborateur() {
		return txtprenomcollaborateur;
	}

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public ModifierFournisseur() {
		setTitle("Confirmation de Modification");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 534, 289);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblnom = new JLabel("Nom Fournisseur");
		lblnom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblnom.setBounds(10, 57, 181, 27);
		contentPane.add(lblnom);
		
		 btnModifier = new JButton("Modifier");
		 btnModifier.setBounds(121, 186, 107, 23);
		 contentPane.add(btnModifier);
		
		lblIdcollaborateur = new JLabel("Id");
		lblIdcollaborateur.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIdcollaborateur.setBounds(10, 14, 107, 27);
		contentPane.add(lblIdcollaborateur);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(282, 186, 107, 23);
		contentPane.add(btnAnnuler);
		
		txtidCollaborateur = new JTextField();
		txtidCollaborateur.setEditable(false);
		txtidCollaborateur.setBounds(211, 18, 242, 27);
		contentPane.add(txtidCollaborateur);
		txtidCollaborateur.setColumns(10);
		
		txtnomcollaborateur = new JTextField();
		txtnomcollaborateur.setColumns(10);
		txtnomcollaborateur.setBounds(211, 57, 242, 27);
		contentPane.add(txtnomcollaborateur);
		
		txtprenomcollaborateur = new JTextField();
		txtprenomcollaborateur.setColumns(10);
		txtprenomcollaborateur.setBounds(211, 101, 242, 27);
		contentPane.add(txtprenomcollaborateur);
		
		JLabel lblPrenomCollaborateur = new JLabel("Prenom Fournisseur");
		lblPrenomCollaborateur.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrenomCollaborateur.setBounds(10, 101, 197, 27);
		contentPane.add(lblPrenomCollaborateur);
		

	}
}
