package Vue.Commercial;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controle.commercial.CommercialControleur;
import model.commercial.Fournisseur;

public class PanneauCommercial extends JPanel {
	private JTable tableComAchat;
	private JTable tableCom;
	private JTextField txtProduitARechercher;
	private JTable tableProduit;
	private JTextField textField;
	private JButton btnRechercher, btnAjouterLeProduit, btnProduitPharmaceutique, btnMedicamentExterne;
	private JButton btnSupprimerProduit, btnAjouterLaCommande;
	private JButton btnRecu, btnSupprimerCom, btnAfficher;
	
	private CommercialControleur controleur;
	private JPanel panel_5;
	private JLabel lblCommande;
	private JLabel lblFournisseur;
	private JLabel lblIdCommande;
	private JTextField textId;
	private JComboBox comboBox;
	
	private ArrayList<Fournisseur> fournisseur;

	/**
	 * Create the panel.
	 */
	public PanneauCommercial() {
		this.setBounds(10, 10, 700, 550);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{50, 0};
		gridBagLayout.rowHeights = new int[]{250, 250, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JSplitPane splitPane = new JSplitPane();
		GridBagConstraints gbc_splitPane = new GridBagConstraints();
		gbc_splitPane.insets = new Insets(0, 0, 5, 0);
		gbc_splitPane.fill = GridBagConstraints.BOTH;
		gbc_splitPane.gridx = 0;
		gbc_splitPane.gridy = 0;
		add(splitPane, gbc_splitPane);
		
		JPanel panel = new JPanel();
		splitPane.setRightComponent(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{265, 0};
		gbl_panel.rowHeights = new int[]{20, 0, 30, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("Liste des commande d'achats");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel.add(scrollPane, gbc_scrollPane);
		
		tableComAchat = new JTable();
		scrollPane.setViewportView(tableComAchat);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 2;
		panel.add(panel_2, gbc_panel_2);
		
		btnAfficher = new JButton("Afficher");
		btnAfficher.setEnabled(false);
		btnAfficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_2.add(btnAfficher);
		
		btnSupprimerCom = new JButton("Supprimer");
		btnSupprimerCom.setEnabled(false);
		panel_2.add(btnSupprimerCom);
		
		btnRecu = new JButton("Recu");
		btnRecu.setEnabled(false);
		panel_2.add(btnRecu);
		
		JPanel panel_1 = new JPanel();
		splitPane.setLeftComponent(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{445, 0};
		gbl_panel_1.rowHeights = new int[]{30, 0, 30, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(0, 0, 5, 0);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 0;
		panel_1.add(panel_5, gbc_panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{100, 0, 0, 50, 50, 70, 0};
		gbl_panel_5.rowHeights = new int[]{0, 0};
		gbl_panel_5.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		lblCommande = new JLabel("Commande");
		lblCommande.setHorizontalAlignment(SwingConstants.CENTER);
		lblCommande.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblCommande = new GridBagConstraints();
		gbc_lblCommande.insets = new Insets(0, 0, 0, 5);
		gbc_lblCommande.fill = GridBagConstraints.BOTH;
		gbc_lblCommande.gridx = 0;
		gbc_lblCommande.gridy = 0;
		panel_5.add(lblCommande, gbc_lblCommande);
		
		lblIdCommande = new JLabel("Id :");
		GridBagConstraints gbc_lblIdCommande = new GridBagConstraints();
		gbc_lblIdCommande.anchor = GridBagConstraints.EAST;
		gbc_lblIdCommande.insets = new Insets(0, 0, 0, 5);
		gbc_lblIdCommande.gridx = 2;
		gbc_lblIdCommande.gridy = 0;
		panel_5.add(lblIdCommande, gbc_lblIdCommande);
		
		textId = new JTextField();
		GridBagConstraints gbc_textId = new GridBagConstraints();
		gbc_textId.insets = new Insets(0, 0, 0, 5);
		gbc_textId.fill = GridBagConstraints.HORIZONTAL;
		gbc_textId.gridx = 3;
		gbc_textId.gridy = 0;
		panel_5.add(textId, gbc_textId);
		textId.setColumns(10);
		
		lblFournisseur = new JLabel("Fournisseur");
		GridBagConstraints gbc_lblFournisseur = new GridBagConstraints();
		gbc_lblFournisseur.anchor = GridBagConstraints.WEST;
		gbc_lblFournisseur.insets = new Insets(0, 0, 0, 5);
		gbc_lblFournisseur.gridx = 4;
		gbc_lblFournisseur.gridy = 0;
		panel_5.add(lblFournisseur, gbc_lblFournisseur);
		
		
		comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.BOTH;
		gbc_comboBox.gridx = 5;
		gbc_comboBox.gridy = 0;
		panel_5.add(comboBox, gbc_comboBox);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 1;
		panel_1.add(scrollPane_1, gbc_scrollPane_1);
		
		tableCom = new JTable();
		scrollPane_1.setViewportView(tableCom);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 2;
		panel_1.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{30, 30, 50, 100, 0};
		gbl_panel_3.rowHeights = new int[]{23, 0};
		gbl_panel_3.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		btnAjouterLaCommande = new JButton("Ajouter la commande");
		btnAjouterLaCommande.setEnabled(false);
		btnAjouterLaCommande.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_btnAjouterLaCommande = new GridBagConstraints();
		gbc_btnAjouterLaCommande.fill = GridBagConstraints.BOTH;
		gbc_btnAjouterLaCommande.insets = new Insets(0, 0, 0, 5);
		gbc_btnAjouterLaCommande.gridx = 0;
		gbc_btnAjouterLaCommande.gridy = 0;
		panel_3.add(btnAjouterLaCommande, gbc_btnAjouterLaCommande);
		
		btnSupprimerProduit = new JButton("Supprimer produit");
		btnSupprimerProduit.setEnabled(false);
		btnSupprimerProduit.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_btnSupprimerProduit = new GridBagConstraints();
		gbc_btnSupprimerProduit.fill = GridBagConstraints.BOTH;
		gbc_btnSupprimerProduit.insets = new Insets(0, 0, 0, 5);
		gbc_btnSupprimerProduit.gridx = 1;
		gbc_btnSupprimerProduit.gridy = 0;
		panel_3.add(btnSupprimerProduit, gbc_btnSupprimerProduit);
		
		JLabel lblTotal = new JLabel("Total");
		GridBagConstraints gbc_lblTotal = new GridBagConstraints();
		gbc_lblTotal.insets = new Insets(0, 0, 0, 5);
		gbc_lblTotal.gridx = 2;
		gbc_lblTotal.gridy = 0;
		panel_3.add(lblTotal, gbc_lblTotal);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEditable(false);
		textField.setText("0000000000000");
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 0;
		panel_3.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 1;
		add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{150, 50, 10, 50, 0, 0, 0, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0, 0};
		gbl_panel_4.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		txtProduitARechercher = new JTextField();
		txtProduitARechercher.setHorizontalAlignment(SwingConstants.CENTER);
		txtProduitARechercher.setText("produit a rechercher");
		GridBagConstraints gbc_txtProduitARechercher = new GridBagConstraints();
		gbc_txtProduitARechercher.insets = new Insets(0, 0, 5, 5);
		gbc_txtProduitARechercher.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtProduitARechercher.gridx = 0;
		gbc_txtProduitARechercher.gridy = 0;
		panel_4.add(txtProduitARechercher, gbc_txtProduitARechercher);
		txtProduitARechercher.setColumns(10);
		
		btnRechercher = new JButton("Rechercher");
		GridBagConstraints gbc_btnRechercher = new GridBagConstraints();
		gbc_btnRechercher.insets = new Insets(0, 0, 5, 5);
		gbc_btnRechercher.gridx = 1;
		gbc_btnRechercher.gridy = 0;
		panel_4.add(btnRechercher, gbc_btnRechercher);
		
		btnAjouterLeProduit = new JButton("Ajouter le produit");
		btnAjouterLeProduit.setEnabled(false);
		GridBagConstraints gbc_btnAjouterLeProduit = new GridBagConstraints();
		gbc_btnAjouterLeProduit.insets = new Insets(0, 0, 5, 5);
		gbc_btnAjouterLeProduit.gridx = 3;
		gbc_btnAjouterLeProduit.gridy = 0;
		panel_4.add(btnAjouterLeProduit, gbc_btnAjouterLeProduit);
		
		btnProduitPharmaceutique = new JButton("Produit pharmaceutique");
		GridBagConstraints gbc_btnProduitPharmaceutique = new GridBagConstraints();
		gbc_btnProduitPharmaceutique.insets = new Insets(0, 0, 5, 5);
		gbc_btnProduitPharmaceutique.gridx = 5;
		gbc_btnProduitPharmaceutique.gridy = 0;
		panel_4.add(btnProduitPharmaceutique, gbc_btnProduitPharmaceutique);
		
		btnMedicamentExterne = new JButton("Medicament externe");
		GridBagConstraints gbc_btnMedicamentExterne = new GridBagConstraints();
		gbc_btnMedicamentExterne.insets = new Insets(0, 0, 5, 0);
		gbc_btnMedicamentExterne.gridx = 6;
		gbc_btnMedicamentExterne.gridy = 0;
		panel_4.add(btnMedicamentExterne, gbc_btnMedicamentExterne);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.gridwidth = 7;
		gbc_scrollPane_2.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridx = 0;
		gbc_scrollPane_2.gridy = 1;
		panel_4.add(scrollPane_2, gbc_scrollPane_2);
		
		tableProduit = new JTable();
		scrollPane_2.setViewportView(tableProduit);
		
		
		
		controleur = new CommercialControleur(this);

	}

	public JTable getTableComAchat() {
		return tableComAchat;
	}

	public void setTableComAchat(JTable tableComAchat) {
		this.tableComAchat = tableComAchat;
	}

	public JTable getTableCom() {
		return tableCom;
	}

	public void setTableCom(JTable tableCom) {
		this.tableCom = tableCom;
	}

	public JTextField getTxtProduitARechercher() {
		return txtProduitARechercher;
	}

	public void setTxtProduitARechercher(JTextField txtProduitARechercher) {
		this.txtProduitARechercher = txtProduitARechercher;
	}

	public JTable getTableProduit() {
		return tableProduit;
	}

	public void setTableProduit(JTable tableProduit) {
		this.tableProduit = tableProduit;
	}

	public JButton getBtnRechercher() {
		return btnRechercher;
	}

	public void setBtnRechercher(JButton btnRechercher) {
		this.btnRechercher = btnRechercher;
	}

	public JButton getBtnAjouterLeProduit() {
		return btnAjouterLeProduit;
	}

	public void setBtnAjouterLeProduit(JButton btnAjouterLeProduit) {
		this.btnAjouterLeProduit = btnAjouterLeProduit;
	}

	public JButton getBtnProduitPharmaceutique() {
		return btnProduitPharmaceutique;
	}

	public void setBtnProduitPharmaceutique(JButton btnProduitPharmaceutique) {
		this.btnProduitPharmaceutique = btnProduitPharmaceutique;
	}

	public JButton getBtnMedicamentExterne() {
		return btnMedicamentExterne;
	}

	public void setBtnMedicamentExterne(JButton btnMedicamentExterne) {
		this.btnMedicamentExterne = btnMedicamentExterne;
	}

	public JButton getBtnSupprimerProduit() {
		return btnSupprimerProduit;
	}

	public void setBtnSupprimerProduit(JButton btnSupprimerProduit) {
		this.btnSupprimerProduit = btnSupprimerProduit;
	}

	public JButton getBtnAjouterLaCommande() {
		return btnAjouterLaCommande;
	}

	public void setBtnAjouterLaCommande(JButton btnAjouterLaCommande) {
		this.btnAjouterLaCommande = btnAjouterLaCommande;
	}

	public JButton getBtnRecu() {
		return btnRecu;
	}

	public void setBtnRecu(JButton btnRecu) {
		this.btnRecu = btnRecu;
	}

	public JButton getBtnSupprimerCom() {
		return btnSupprimerCom;
	}

	public void setBtnSupprimerCom(JButton btnSupprimerCom) {
		this.btnSupprimerCom = btnSupprimerCom;
	}

	public JButton getBtnAfficher() {
		return btnAfficher;
	}

	public void setBtnAfficher(JButton btnAfficher) {
		this.btnAfficher = btnAfficher;
	}

	public JTextField getTextField() {
		return textField;
	}

	public JTextField getTextId() {
		return textId;
	}

	public void setTextId(JTextField textId) {
		this.textId = textId;
	}

	public JComboBox getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}

}
