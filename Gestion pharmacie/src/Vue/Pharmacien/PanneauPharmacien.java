package Vue.Pharmacien;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controle.pharmacien.ControleurPharmacien;

public class PanneauPharmacien extends JPanel {
	private JTable tableMatPrem;
	private JTable tableTypeMed;
	private JTextField textId;
	private JTextField textNom;
	private JTextField textIdType;
	private JTextField textLabel;
	private JTextField textDescription;
	private JButton btnAjouter, btnSupprimer, btnModifier;
	private JButton btnAjouterType, btnModifierType, btnSupprimerType;
	private ControleurPharmacien controleur;
	private JLabel lblMatierePremiere;
	private JLabel lblTypeMedicament;
	private JButton btnNouvelleMatiere;
	private JButton btnNouveauType;
	
	/**
	 * Create the panel.
	 */
	public PanneauPharmacien() {
		this.setBounds(10, 10, 700, 550);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblMatierePremiere = new JLabel("Matiere premiere");
		lblMatierePremiere.setForeground(Color.BLACK);
		lblMatierePremiere.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblMatierePremiere = new GridBagConstraints();
		gbc_lblMatierePremiere.insets = new Insets(0, 0, 5, 0);
		gbc_lblMatierePremiere.gridx = 0;
		gbc_lblMatierePremiere.gridy = 0;
		add(lblMatierePremiere, gbc_lblMatierePremiere);
		
		JSplitPane splitPane_1 = new JSplitPane();
		GridBagConstraints gbc_splitPane_1 = new GridBagConstraints();
		gbc_splitPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_splitPane_1.fill = GridBagConstraints.BOTH;
		gbc_splitPane_1.gridx = 0;
		gbc_splitPane_1.gridy = 1;
		add(splitPane_1, gbc_splitPane_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		splitPane_1.setRightComponent(scrollPane_1);
		
		tableMatPrem = new JTable();
		scrollPane_1.setViewportView(tableMatPrem);
		
		JPanel panel = new JPanel();
		splitPane_1.setLeftComponent(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{100, 200, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblIdMat = new JLabel("Id :");
		lblIdMat.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblIdMat = new GridBagConstraints();
		gbc_lblIdMat.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdMat.anchor = GridBagConstraints.EAST;
		gbc_lblIdMat.gridx = 0;
		gbc_lblIdMat.gridy = 1;
		panel.add(lblIdMat, gbc_lblIdMat);
		
		textId = new JTextField();
		textId.setEditable(false);
		textId.setHorizontalAlignment(SwingConstants.CENTER);
		textId.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_textId = new GridBagConstraints();
		gbc_textId.insets = new Insets(0, 0, 5, 5);
		gbc_textId.fill = GridBagConstraints.HORIZONTAL;
		gbc_textId.gridx = 1;
		gbc_textId.gridy = 1;
		panel.add(textId, gbc_textId);
		textId.setColumns(10);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNom = new GridBagConstraints();
		gbc_lblNom.insets = new Insets(0, 0, 5, 5);
		gbc_lblNom.gridx = 0;
		gbc_lblNom.gridy = 2;
		panel.add(lblNom, gbc_lblNom);
		
		textNom = new JTextField();
		textNom.setHorizontalAlignment(SwingConstants.CENTER);
		textNom.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		GridBagConstraints gbc_textNom = new GridBagConstraints();
		gbc_textNom.insets = new Insets(0, 0, 5, 5);
		gbc_textNom.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNom.gridx = 1;
		gbc_textNom.gridy = 2;
		panel.add(textNom, gbc_textNom);
		textNom.setColumns(10);
		
		btnAjouter = new JButton("Ajouter matiere");
		btnAjouter.setForeground(Color.BLUE);
		btnAjouter.setFont(new Font("Source Serif Pro Semibold", Font.ITALIC, 14));
		GridBagConstraints gbc_btnAjouter = new GridBagConstraints();
		gbc_btnAjouter.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAjouter.gridwidth = 3;
		gbc_btnAjouter.insets = new Insets(0, 0, 5, 0);
		gbc_btnAjouter.gridx = 0;
		gbc_btnAjouter.gridy = 3;
		panel.add(btnAjouter, gbc_btnAjouter);
		
		btnModifier = new JButton("Modifier matiere");
		btnModifier.setFont(new Font("Source Serif Pro Semibold", Font.ITALIC, 14));
		btnModifier.setForeground(Color.BLUE);
		GridBagConstraints gbc_btnModifier = new GridBagConstraints();
		gbc_btnModifier.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnModifier.gridwidth = 4;
		gbc_btnModifier.insets = new Insets(0, 0, 5, 0);
		gbc_btnModifier.gridx = 0;
		gbc_btnModifier.gridy = 4;
		panel.add(btnModifier, gbc_btnModifier);
		
		btnSupprimer = new JButton("Supprimer matiere");
		btnSupprimer.setForeground(Color.BLUE);
		btnSupprimer.setFont(new Font("Source Serif Pro Semibold", Font.ITALIC, 14));
		GridBagConstraints gbc_btnSupprimer = new GridBagConstraints();
		gbc_btnSupprimer.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSupprimer.insets = new Insets(0, 0, 5, 0);
		gbc_btnSupprimer.gridwidth = 4;
		gbc_btnSupprimer.gridx = 0;
		gbc_btnSupprimer.gridy = 5;
		panel.add(btnSupprimer, gbc_btnSupprimer);
		
		btnNouvelleMatiere = new JButton("Nouvelle matiere");
		btnNouvelleMatiere.setForeground(Color.BLUE);
		btnNouvelleMatiere.setFont(new Font("Tahoma", Font.ITALIC, 14));
		GridBagConstraints gbc_btnNouvelleMatiere = new GridBagConstraints();
		gbc_btnNouvelleMatiere.fill = GridBagConstraints.BOTH;
		gbc_btnNouvelleMatiere.gridwidth = 2;
		gbc_btnNouvelleMatiere.insets = new Insets(0, 0, 5, 5);
		gbc_btnNouvelleMatiere.gridx = 0;
		gbc_btnNouvelleMatiere.gridy = 6;
		panel.add(btnNouvelleMatiere, gbc_btnNouvelleMatiere);
		
		lblTypeMedicament = new JLabel("Type Medicament");
		lblTypeMedicament.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblTypeMedicament = new GridBagConstraints();
		gbc_lblTypeMedicament.insets = new Insets(0, 0, 5, 0);
		gbc_lblTypeMedicament.gridx = 0;
		gbc_lblTypeMedicament.gridy = 2;
		add(lblTypeMedicament, gbc_lblTypeMedicament);
		
		JSplitPane splitPane = new JSplitPane();
		GridBagConstraints gbc_splitPane = new GridBagConstraints();
		gbc_splitPane.fill = GridBagConstraints.BOTH;
		gbc_splitPane.gridx = 0;
		gbc_splitPane.gridy = 3;
		add(splitPane, gbc_splitPane);
		
		JScrollPane scrollPane = new JScrollPane();
		splitPane.setRightComponent(scrollPane);
		
		tableTypeMed = new JTable();
		scrollPane.setViewportView(tableTypeMed);
		
		JPanel panel_1 = new JPanel();
		splitPane.setLeftComponent(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{100, 200, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 70, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblIdType = new JLabel("Id : ");
		lblIdType.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblIdType = new GridBagConstraints();
		gbc_lblIdType.anchor = GridBagConstraints.EAST;
		gbc_lblIdType.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdType.gridx = 0;
		gbc_lblIdType.gridy = 1;
		panel_1.add(lblIdType, gbc_lblIdType);
		
		textIdType = new JTextField();
		textIdType.setEditable(false);
		textIdType.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		textIdType.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_textIdType = new GridBagConstraints();
		gbc_textIdType.insets = new Insets(0, 0, 5, 0);
		gbc_textIdType.fill = GridBagConstraints.HORIZONTAL;
		gbc_textIdType.gridx = 1;
		gbc_textIdType.gridy = 1;
		panel_1.add(textIdType, gbc_textIdType);
		textIdType.setColumns(10);
		
		JLabel lblLabel = new JLabel("Label : ");
		lblLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblLabel = new GridBagConstraints();
		gbc_lblLabel.anchor = GridBagConstraints.EAST;
		gbc_lblLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblLabel.gridx = 0;
		gbc_lblLabel.gridy = 2;
		panel_1.add(lblLabel, gbc_lblLabel);
		
		textLabel = new JTextField();
		textLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		textLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_textLabel = new GridBagConstraints();
		gbc_textLabel.insets = new Insets(0, 0, 5, 0);
		gbc_textLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_textLabel.gridx = 1;
		gbc_textLabel.gridy = 2;
		panel_1.add(textLabel, gbc_textLabel);
		textLabel.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description :");
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblDescription = new GridBagConstraints();
		gbc_lblDescription.anchor = GridBagConstraints.EAST;
		gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescription.gridx = 0;
		gbc_lblDescription.gridy = 3;
		panel_1.add(lblDescription, gbc_lblDescription);
		
		textDescription = new JTextField();
		textDescription.setHorizontalAlignment(SwingConstants.CENTER);
		textDescription.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		GridBagConstraints gbc_textDescription = new GridBagConstraints();
		gbc_textDescription.insets = new Insets(0, 0, 5, 0);
		gbc_textDescription.fill = GridBagConstraints.BOTH;
		gbc_textDescription.gridx = 1;
		gbc_textDescription.gridy = 3;
		panel_1.add(textDescription, gbc_textDescription);
		textDescription.setColumns(10);
		
		btnAjouterType = new JButton("Ajouter type");
		btnAjouterType.setFont(new Font("Tahoma", Font.ITALIC, 14));
		btnAjouterType.setForeground(Color.BLUE);
		GridBagConstraints gbc_btnAjouterType = new GridBagConstraints();
		gbc_btnAjouterType.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAjouterType.gridwidth = 5;
		gbc_btnAjouterType.insets = new Insets(0, 0, 5, 0);
		gbc_btnAjouterType.gridx = 0;
		gbc_btnAjouterType.gridy = 4;
		panel_1.add(btnAjouterType, gbc_btnAjouterType);
		
		btnModifierType = new JButton("Modifier type");
		btnModifierType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModifierType.setFont(new Font("Tahoma", Font.ITALIC, 14));
		btnModifierType.setForeground(Color.BLUE);
		GridBagConstraints gbc_btnModifierType = new GridBagConstraints();
		gbc_btnModifierType.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnModifierType.gridwidth = 4;
		gbc_btnModifierType.insets = new Insets(0, 0, 5, 0);
		gbc_btnModifierType.gridx = 0;
		gbc_btnModifierType.gridy = 5;
		panel_1.add(btnModifierType, gbc_btnModifierType);
		
		btnSupprimerType = new JButton("Supprimer type");
		btnSupprimerType.setForeground(Color.BLUE);
		btnSupprimerType.setFont(new Font("Tahoma", Font.ITALIC, 14));
		GridBagConstraints gbc_btnSupprimerType = new GridBagConstraints();
		gbc_btnSupprimerType.insets = new Insets(0, 0, 5, 0);
		gbc_btnSupprimerType.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSupprimerType.gridwidth = 4;
		gbc_btnSupprimerType.gridx = 0;
		gbc_btnSupprimerType.gridy = 6;
		panel_1.add(btnSupprimerType, gbc_btnSupprimerType);
		
		btnNouveauType = new JButton("Nouveau type");
		btnNouveauType.setForeground(Color.BLUE);
		btnNouveauType.setFont(new Font("Tahoma", Font.ITALIC, 14));
		GridBagConstraints gbc_btnNouveauType = new GridBagConstraints();
		gbc_btnNouveauType.fill = GridBagConstraints.BOTH;
		gbc_btnNouveauType.gridwidth = 2;
		gbc_btnNouveauType.insets = new Insets(0, 0, 5, 0);
		gbc_btnNouveauType.gridx = 0;
		gbc_btnNouveauType.gridy = 7;
		panel_1.add(btnNouveauType, gbc_btnNouveauType);
		
		controleur = new ControleurPharmacien(this);
		
	}

	public JTextField getTextId() {
		return textId;
	}

	public void setTextId(JTextField textId) {
		this.textId = textId;
	}

	public JTextField getTextNom() {
		return textNom;
	}

	public void setTextNom(JTextField textNom) {
		this.textNom = textNom;
	}

	public JTextField getTextIdType() {
		return textIdType;
	}

	public void setTextIdType(JTextField textIdType) {
		this.textIdType = textIdType;
	}

	public JTextField getTextLabel() {
		return textLabel;
	}

	public void setTextLabel(JTextField textLabel) {
		this.textLabel = textLabel;
	}

	public JTable getTableMatPrem() {
		return tableMatPrem;
	}

	public JTable getTableTypeMed() {
		return tableTypeMed;
	}

	public JTextField getTextDescription() {
		return textDescription;
	}

	public JButton getBtnAjouter() {
		return btnAjouter;
	}

	public JButton getBtnSupprimer() {
		return btnSupprimer;
	}

	public JButton getBtnModifier() {
		return btnModifier;
	}

	public JButton getBtnAjouterType() {
		return btnAjouterType;
	}

	public JButton getBtnModifierType() {
		return btnModifierType;
	}

	public JButton getBtnSupprimerType() {
		return btnSupprimerType;
	}

	public JButton getBtnNouvelleMatiere() {
		return btnNouvelleMatiere;
	}

	public JButton getBtnNouveauType() {
		return btnNouveauType;
	}

}
