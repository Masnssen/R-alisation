package Vue.comtoir;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controle.comptoir.ControleCommandeClient;

public class PanneauCommandeClient extends JFrame {

	private ControleCommandeClient controle;
	private JPanel contentPane;
	private JTable tableCommande;
	private JTextField textTotal;
	private JTable tableListCommande;
	private JTable tableProduit;
	private JTextField txtNomProduit;
	private JButton btnReturn, btnServie, btnSupprimerLaCommande, btnAjouterLaCommande, btnSupprimerProduit, btnRechercher,
						btnAjouter, btnMedicamentExterne, btnProduitPharmaceutique;
	private JComboBox comboBox;
	private String[] client = {"Client 1", "Client 2", "Client 3", "Client 4", "Client 5"}; 
	private JLabel lblNewLabel_3;
	private JTextField txtIdCommande;
	private JButton btnAfficher;
	private JButton btnNvCommande;
	

	/**
	 * Create the frame.
	 */
	public PanneauCommandeClient() {
		setTitle("Commande client");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 0, 0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		contentPane.add(splitPane);
		
		JPanel panel_1 = new JPanel();
		splitPane.setRightComponent(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{200};
		gbl_panel_1.rowHeights = new int[]{30, 200, 20, 0};
		gbl_panel_1.columnWeights = new double[]{1.0};
		gbl_panel_1.rowWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel = new JLabel("Liste commandes client");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 1;
		panel_1.add(scrollPane_1, gbc_scrollPane_1);
		
		tableListCommande = new JTable();
		scrollPane_1.setViewportView(tableListCommande);
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 2;
		panel_1.add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{0, 50, 50, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0};
		gbl_panel_4.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		btnAfficher = new JButton("Afficher");
		btnAfficher.setEnabled(false);
		GridBagConstraints gbc_btnAfficher = new GridBagConstraints();
		gbc_btnAfficher.insets = new Insets(0, 0, 0, 5);
		gbc_btnAfficher.gridx = 0;
		gbc_btnAfficher.gridy = 0;
		panel_4.add(btnAfficher, gbc_btnAfficher);
		
		btnServie = new JButton("Servie");
		btnServie.setEnabled(false);
		GridBagConstraints gbc_btnServie = new GridBagConstraints();
		gbc_btnServie.insets = new Insets(0, 0, 0, 5);
		gbc_btnServie.gridx = 1;
		gbc_btnServie.gridy = 0;
		panel_4.add(btnServie, gbc_btnServie);
		
		btnSupprimerLaCommande = new JButton("Supprimer la commande");
		btnSupprimerLaCommande.setEnabled(false);
		
		GridBagConstraints gbc_btnSupprimerLaCommande = new GridBagConstraints();
		gbc_btnSupprimerLaCommande.gridx = 2;
		gbc_btnSupprimerLaCommande.gridy = 0;
		panel_4.add(btnSupprimerLaCommande, gbc_btnSupprimerLaCommande);
		
		JPanel panel_2 = new JPanel();
		splitPane.setLeftComponent(panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{500, 0};
		gbl_panel_2.rowHeights = new int[]{0, 20, 200, 20, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Detail commande ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel_2.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JPanel panel_7 = new JPanel();
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.insets = new Insets(0, 0, 5, 0);
		gbc_panel_7.fill = GridBagConstraints.BOTH;
		gbc_panel_7.gridx = 0;
		gbc_panel_7.gridy = 1;
		panel_2.add(panel_7, gbc_panel_7);
		GridBagLayout gbl_panel_7 = new GridBagLayout();
		gbl_panel_7.columnWidths = new int[]{100, 125, 0, 100, 140, 0};
		gbl_panel_7.rowHeights = new int[]{0, 0};
		gbl_panel_7.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_7.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_7.setLayout(gbl_panel_7);
		
		lblNewLabel_3 = new JLabel("Id commande");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 0;
		panel_7.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		txtIdCommande = new JTextField();
		GridBagConstraints gbc_txtIdCommande = new GridBagConstraints();
		gbc_txtIdCommande.insets = new Insets(0, 0, 0, 5);
		gbc_txtIdCommande.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIdCommande.gridx = 1;
		gbc_txtIdCommande.gridy = 0;
		panel_7.add(txtIdCommande, gbc_txtIdCommande);
		txtIdCommande.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Client");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2.gridx = 3;
		gbc_lblNewLabel_2.gridy = 0;
		panel_7.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		comboBox = new JComboBox(client);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 4;
		gbc_comboBox.gridy = 0;
		panel_7.add(comboBox, gbc_comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		panel_2.add(scrollPane, gbc_scrollPane);
		
		tableCommande = new JTable();
		scrollPane.setViewportView(tableCommande);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 3;
		panel_2.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0, 0, 40, 0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		btnAjouterLaCommande = new JButton("Ajouter la commande");
		btnAjouterLaCommande.setEnabled(false);
		GridBagConstraints gbc_btnAjouterLaCommande = new GridBagConstraints();
		gbc_btnAjouterLaCommande.insets = new Insets(0, 0, 0, 5);
		gbc_btnAjouterLaCommande.gridx = 0;
		gbc_btnAjouterLaCommande.gridy = 0;
		panel_3.add(btnAjouterLaCommande, gbc_btnAjouterLaCommande);
		
		btnSupprimerProduit = new JButton("Supprimer produit");
		btnSupprimerProduit.setEnabled(false);
		GridBagConstraints gbc_btnSupprimerProduit = new GridBagConstraints();
		gbc_btnSupprimerProduit.insets = new Insets(0, 0, 0, 5);
		gbc_btnSupprimerProduit.gridx = 2;
		gbc_btnSupprimerProduit.gridy = 0;
		panel_3.add(btnSupprimerProduit, gbc_btnSupprimerProduit);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblTotal = new GridBagConstraints();
		gbc_lblTotal.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblTotal.insets = new Insets(0, 0, 0, 5);
		gbc_lblTotal.gridx = 4;
		gbc_lblTotal.gridy = 0;
		panel_3.add(lblTotal, gbc_lblTotal);
		
		textTotal = new JTextField();
		textTotal.setHorizontalAlignment(SwingConstants.CENTER);
		textTotal.setText("0000000");
		textTotal.setFont(new Font("Tahoma", Font.BOLD, 12));
		textTotal.setEditable(false);
		GridBagConstraints gbc_textTotal = new GridBagConstraints();
		gbc_textTotal.fill = GridBagConstraints.BOTH;
		gbc_textTotal.gridx = 5;
		gbc_textTotal.gridy = 0;
		panel_3.add(textTotal, gbc_textTotal);
		textTotal.setColumns(10);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{30, 0, 20, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(0, 0, 5, 0);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 0;
		panel.add(panel_5, gbc_panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{200, 100, 0, 50, 100, 100, 0};
		gbl_panel_5.rowHeights = new int[]{0, 0};
		gbl_panel_5.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 8.0, 1.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		txtNomProduit = new JTextField();
		txtNomProduit.setHorizontalAlignment(SwingConstants.CENTER);
		txtNomProduit.setText("Nom produit");
		GridBagConstraints gbc_txtNomProduit = new GridBagConstraints();
		gbc_txtNomProduit.insets = new Insets(0, 0, 0, 5);
		gbc_txtNomProduit.fill = GridBagConstraints.BOTH;
		gbc_txtNomProduit.gridx = 0;
		gbc_txtNomProduit.gridy = 0;
		panel_5.add(txtNomProduit, gbc_txtNomProduit);
		txtNomProduit.setColumns(10);
		
		btnRechercher = new JButton("Rechercher");
		GridBagConstraints gbc_btnRechercher = new GridBagConstraints();
		gbc_btnRechercher.fill = GridBagConstraints.BOTH;
		gbc_btnRechercher.insets = new Insets(0, 0, 0, 5);
		gbc_btnRechercher.gridx = 1;
		gbc_btnRechercher.gridy = 0;
		panel_5.add(btnRechercher, gbc_btnRechercher);
		
		btnAjouter = new JButton("Ajouter le produit");
		btnAjouter.setEnabled(false);
		
		GridBagConstraints gbc_btnAjouter = new GridBagConstraints();
		gbc_btnAjouter.insets = new Insets(0, 0, 0, 5);
		gbc_btnAjouter.fill = GridBagConstraints.BOTH;
		gbc_btnAjouter.gridx = 2;
		gbc_btnAjouter.gridy = 0;
		panel_5.add(btnAjouter, gbc_btnAjouter);
		
		btnNvCommande = new JButton("Nv Commande");
		btnNvCommande.setEnabled(false);
		GridBagConstraints gbc_btnNvCommande = new GridBagConstraints();
		gbc_btnNvCommande.insets = new Insets(0, 0, 0, 5);
		gbc_btnNvCommande.gridx = 3;
		gbc_btnNvCommande.gridy = 0;
		panel_5.add(btnNvCommande, gbc_btnNvCommande);
		
		btnProduitPharmaceutique = new JButton("Produit pharmaceutique");
		GridBagConstraints gbc_btnProduitPharmaceutique = new GridBagConstraints();
		gbc_btnProduitPharmaceutique.insets = new Insets(0, 0, 0, 5);
		gbc_btnProduitPharmaceutique.gridx = 4;
		gbc_btnProduitPharmaceutique.gridy = 0;
		panel_5.add(btnProduitPharmaceutique, gbc_btnProduitPharmaceutique);
		
		btnMedicamentExterne = new JButton("Medicament externe");
		GridBagConstraints gbc_btnMedicamentExterne = new GridBagConstraints();
		gbc_btnMedicamentExterne.gridx = 5;
		gbc_btnMedicamentExterne.gridy = 0;
		panel_5.add(btnMedicamentExterne, gbc_btnMedicamentExterne);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_2.setToolTipText("");
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridx = 0;
		gbc_scrollPane_2.gridy = 1;
		panel.add(scrollPane_2, gbc_scrollPane_2);
		
		tableProduit = new JTable();
		scrollPane_2.setViewportView(tableProduit);
		
		JPanel panel_6 = new JPanel();
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 0;
		gbc_panel_6.gridy = 2;
		panel.add(panel_6, gbc_panel_6);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[]{0, 100, 0};
		gbl_panel_6.rowHeights = new int[]{0, 0};
		gbl_panel_6.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_6.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_6.setLayout(gbl_panel_6);
		
		btnReturn = new JButton("Return");
		
		btnReturn.setForeground(Color.BLACK);
		btnReturn.setBackground(Color.ORANGE);
		btnReturn.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_btnReturn = new GridBagConstraints();
		gbc_btnReturn.fill = GridBagConstraints.BOTH;
		gbc_btnReturn.gridx = 1;
		gbc_btnReturn.gridy = 0;
		panel_6.add(btnReturn, gbc_btnReturn);
		
		
		controle = new ControleCommandeClient(this);
	}


	public JTextField getTxtNomProduit() {
		return txtNomProduit;
	}



	public void setTxtNomProduit(JTextField txtNomProduit) {
		this.txtNomProduit = txtNomProduit;
	}



	public JTextField getTextTotal() {
		return textTotal;
	}



	public void setTextTotal(JTextField textTotal) {
		this.textTotal = textTotal;
	}



	public JTable getTableCommande() {
		return tableCommande;
	}



	public void setTableCommande(JTable tableCommande) {
		this.tableCommande = tableCommande;
	}



	public JTable getTableListCommande() {
		return tableListCommande;
	}



	public void setTableListCommande(JTable tableListCommande) {
		this.tableListCommande = tableListCommande;
	}



	public JTable getTableProduit() {
		return tableProduit;
	}



	public void setTableProduit(JTable tableProduit) {
		this.tableProduit = tableProduit;
	}



	public JButton getBtnReturn() {
		return btnReturn;
	}



	public void setBtnReturn(JButton btnReturn) {
		this.btnReturn = btnReturn;
	}



	public JButton getBtnServie() {
		return btnServie;
	}



	public void setBtnServie(JButton btnServie) {
		this.btnServie = btnServie;
	}



	public JButton getBtnSupprimerLaCommande() {
		return btnSupprimerLaCommande;
	}



	public void setBtnSupprimerLaCommande(JButton btnSupprimerLaCommande) {
		this.btnSupprimerLaCommande = btnSupprimerLaCommande;
	}



	public JButton getBtnAjouterLaCommande() {
		return btnAjouterLaCommande;
	}



	public void setBtnAjouterLaCommande(JButton btnAjouterLaCommande) {
		this.btnAjouterLaCommande = btnAjouterLaCommande;
	}



	public JButton getBtnSupprimerProduit() {
		return btnSupprimerProduit;
	}



	public void setBtnSupprimerProduit(JButton btnSupprimerProduit) {
		this.btnSupprimerProduit = btnSupprimerProduit;
	}



	public JButton getBtnRechercher() {
		return btnRechercher;
	}



	public void setBtnRechercher(JButton btnRechercher) {
		this.btnRechercher = btnRechercher;
	}



	public JButton getBtnAjouter() {
		return btnAjouter;
	}



	public void setBtnAjouter(JButton btnAjouter) {
		this.btnAjouter = btnAjouter;
	}


	public JComboBox getComboBox() {
		return comboBox;
	}


	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}


	public JButton getBtnMedicamentExterne() {
		return btnMedicamentExterne;
	}


	public void setBtnMedicamentExterne(JButton btnMedicamentExterne) {
		this.btnMedicamentExterne = btnMedicamentExterne;
	}


	public JButton getBtnProduitPharmaceutique() {
		return btnProduitPharmaceutique;
	}


	public void setBtnProduitPharmaceutique(JButton btnProduitPharmaceutique) {
		this.btnProduitPharmaceutique = btnProduitPharmaceutique;
	}


	public String[] getClient() {
		return client;
	}


	public void setClient(String[] client) {
		this.client = client;
	}


	public JTextField getTxtIdCommande() {
		return txtIdCommande;
	}


	public void setTxtIdCommande(JTextField txtIdCommande) {
		this.txtIdCommande = txtIdCommande;
	}


	public JButton getBtnAfficher() {
		return btnAfficher;
	}


	public void setBtnAfficher(JButton btnAfficher) {
		this.btnAfficher = btnAfficher;
	}
   public JButton getBtnNvCommande() {
		return btnNvCommande;
	}
	

}
