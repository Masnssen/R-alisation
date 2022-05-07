package Vue.Pharmacien;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Formulaire extends JPanel {
	
	//Les liste de valeur des combo
	private String[] categorieListe = {"Produit pharmaceutique", "Medicament externe", "Medicament interne"};
		
	private JTextField idProduit;
	private JTextField nomProduit;
	
	private JComboBox comb_categorie;
	private JComboBox comb_typeProduit;
	private JComboBox comb_matierePrem1;
	private JComboBox comb_matierePrem2;
	private JComboBox comb_matierePrem3;
	private JComboBox comb_matierePrem4;
	/**
	 * Create the panel.
	 */
	public Formulaire() {
		
		//init combo box
		comb_categorie = new JComboBox(categorieListe);
		comb_categorie.setEnabled(false);
		comb_typeProduit = new JComboBox();
		comb_typeProduit.setEnabled(false);
		comb_matierePrem1 = new JComboBox();
		comb_matierePrem1.setEnabled(false);
		comb_matierePrem2 = new JComboBox();
		comb_matierePrem2.setEnabled(false);
		comb_matierePrem3 = new JComboBox();
		comb_matierePrem3.setEnabled(false);
		comb_matierePrem4 = new JComboBox();
		comb_matierePrem4.setEnabled(false);
		
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
	
		
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{104, 131, 124, 123, 0};
		gbl_panel_1.rowHeights = new int[]{30, 30, 30, 30, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gbl_panel_1);
		
		JLabel idProduitLabel = new JLabel("Id produit :");
		GridBagConstraints gbc_idProduitLabel = new GridBagConstraints();
		gbc_idProduitLabel.anchor = GridBagConstraints.EAST;
		gbc_idProduitLabel.insets = new Insets(0, 0, 5, 5);
		gbc_idProduitLabel.gridx = 0;
		gbc_idProduitLabel.gridy = 0;
		add(idProduitLabel, gbc_idProduitLabel);
		
		idProduit = new JTextField();
		GridBagConstraints gbc_idProduit = new GridBagConstraints();
		gbc_idProduit.insets = new Insets(0, 0, 5, 5);
		gbc_idProduit.fill = GridBagConstraints.HORIZONTAL;
		gbc_idProduit.gridx = 1;
		gbc_idProduit.gridy = 0;
		add(idProduit, gbc_idProduit);
		idProduit.setColumns(10);
		
		JLabel lblMatirePremire = new JLabel("Mati\u00E8re premi\u00E8re 1 :");
		GridBagConstraints gbc_lblMatirePremire = new GridBagConstraints();
		gbc_lblMatirePremire.anchor = GridBagConstraints.SOUTHEAST;
		gbc_lblMatirePremire.insets = new Insets(0, 0, 5, 5);
		gbc_lblMatirePremire.gridx = 2;
		gbc_lblMatirePremire.gridy = 0;
	    add(lblMatirePremire, gbc_lblMatirePremire);
		
		
		GridBagConstraints gbc_comb_matierePrem1 = new GridBagConstraints();
		gbc_comb_matierePrem1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comb_matierePrem1.anchor = GridBagConstraints.SOUTH;
		gbc_comb_matierePrem1.insets = new Insets(0, 0, 5, 0);
		gbc_comb_matierePrem1.gridx = 3;
		gbc_comb_matierePrem1.gridy = 0;
		add(comb_matierePrem1, gbc_comb_matierePrem1);
		
		JLabel lblNewLabel_1 = new JLabel("Nom produit :");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		nomProduit = new JTextField();
		GridBagConstraints gbc_nomProduit = new GridBagConstraints();
		gbc_nomProduit.insets = new Insets(0, 0, 5, 5);
		gbc_nomProduit.fill = GridBagConstraints.HORIZONTAL;
		gbc_nomProduit.gridx = 1;
		gbc_nomProduit.gridy = 1;
		add(nomProduit, gbc_nomProduit);
		nomProduit.setColumns(10);
		
		JLabel lblMatirePremire_1 = new JLabel("Mati\u00E8re premi\u00E8re 2 :");
		GridBagConstraints gbc_lblMatirePremire_1 = new GridBagConstraints();
		gbc_lblMatirePremire_1.anchor = GridBagConstraints.SOUTHEAST;
		gbc_lblMatirePremire_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblMatirePremire_1.gridx = 2;
		gbc_lblMatirePremire_1.gridy = 1;
		add(lblMatirePremire_1, gbc_lblMatirePremire_1);
		
		
		GridBagConstraints gbc_comb_matierePrem2 = new GridBagConstraints();
		gbc_comb_matierePrem2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comb_matierePrem2.anchor = GridBagConstraints.SOUTH;
		gbc_comb_matierePrem2.insets = new Insets(0, 0, 5, 0);
		gbc_comb_matierePrem2.gridx = 3;
		gbc_comb_matierePrem2.gridy = 1;
		add(comb_matierePrem2, gbc_comb_matierePrem2);
		
		JLabel lblNewLabel_4 = new JLabel("Cat\u00E9gorie :");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 2;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		
		GridBagConstraints gbc_comb_categorie = new GridBagConstraints();
		gbc_comb_categorie.insets = new Insets(0, 0, 5, 5);
		gbc_comb_categorie.fill = GridBagConstraints.HORIZONTAL;
		gbc_comb_categorie.gridx = 1;
		gbc_comb_categorie.gridy = 2;
		add(comb_categorie, gbc_comb_categorie);
		
		JLabel lblMatirePremire_2 = new JLabel("Mati\u00E8re premi\u00E8re 3 :");
		GridBagConstraints gbc_lblMatirePremire_2 = new GridBagConstraints();
		gbc_lblMatirePremire_2.anchor = GridBagConstraints.EAST;
		gbc_lblMatirePremire_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblMatirePremire_2.gridx = 2;
		gbc_lblMatirePremire_2.gridy = 2;
		add(lblMatirePremire_2, gbc_lblMatirePremire_2);
		
		
		GridBagConstraints gbc_comb_matierePrem3 = new GridBagConstraints();
		gbc_comb_matierePrem3.fill = GridBagConstraints.HORIZONTAL;
		gbc_comb_matierePrem3.insets = new Insets(0, 0, 5, 0);
		gbc_comb_matierePrem3.gridx = 3;
		gbc_comb_matierePrem3.gridy = 2;
		add(comb_matierePrem3, gbc_comb_matierePrem3);
		
		JLabel lblNewLabel_2 = new JLabel("Type produit :");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		
		GridBagConstraints gbc_comb_typeProduit = new GridBagConstraints();
		gbc_comb_typeProduit.insets = new Insets(0, 0, 0, 5);
		gbc_comb_typeProduit.fill = GridBagConstraints.HORIZONTAL;
		gbc_comb_typeProduit.gridx = 1;
		gbc_comb_typeProduit.gridy = 3;
		add(comb_typeProduit, gbc_comb_typeProduit);
		
		JLabel lblMatirePremire_3 = new JLabel("Mati\u00E8re premi\u00E8re 4 :");
		GridBagConstraints gbc_lblMatirePremire_3 = new GridBagConstraints();
		gbc_lblMatirePremire_3.anchor = GridBagConstraints.EAST;
		gbc_lblMatirePremire_3.insets = new Insets(0, 0, 0, 5);
		gbc_lblMatirePremire_3.gridx = 2;
		gbc_lblMatirePremire_3.gridy = 3;
		add(lblMatirePremire_3, gbc_lblMatirePremire_3);
		
		
		GridBagConstraints gbc_comb_matierePrem4 = new GridBagConstraints();
		gbc_comb_matierePrem4.fill = GridBagConstraints.HORIZONTAL;
		gbc_comb_matierePrem4.gridx = 3;
		gbc_comb_matierePrem4.gridy = 3;
		add(comb_matierePrem4, gbc_comb_matierePrem4);
		
		
	}
	public JTextField getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(JTextField idProduit) {
		this.idProduit = idProduit;
	}
	public JTextField getNomProduit() {
		return nomProduit;
	}
	public void setNomProduit(JTextField nomProduit) {
		this.nomProduit = nomProduit;
	}
	public JComboBox getComb_categorie() {
		return comb_categorie;
	}
	public void setComb_categorie(JComboBox comb_categorie) {
		this.comb_categorie = comb_categorie;
	}
	public JComboBox getComb_typeProduit() {
		return comb_typeProduit;
	}
	public void setComb_typeProduit(JComboBox comb_typeProduit) {
		this.comb_typeProduit = comb_typeProduit;
	}
	public JComboBox getComb_matierePrem1() {
		return comb_matierePrem1;
	}
	public void setComb_matierePrem1(JComboBox comb_matierePrem1) {
		this.comb_matierePrem1 = comb_matierePrem1;
	}
	public JComboBox getComb_matierePrem2() {
		return comb_matierePrem2;
	}
	public void setComb_matierePrem2(JComboBox comb_matierePrem2) {
		this.comb_matierePrem2 = comb_matierePrem2;
	}
	public JComboBox getComb_matierePrem3() {
		return comb_matierePrem3;
	}
	public void setComb_matierePrem3(JComboBox comb_matierePrem3) {
		this.comb_matierePrem3 = comb_matierePrem3;
	}
	public JComboBox getComb_matierePrem4() {
		return comb_matierePrem4;
	}
	public void setComb_matierePrem4(JComboBox comb_matierePrem4) {
		this.comb_matierePrem4 = comb_matierePrem4;
	}
	
	public String getId() {
		return this.idProduit.getText();
	}

}
