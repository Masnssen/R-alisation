package Vue.Pharmacien;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

import controle.pharmacien.ControleProduit;

public class PanneauProduit extends JPanel{
	
	
	//Le controleur
	private ControleProduit controleur;
	
	//Les objets
	private JTable tableProduit;
	private JTable tableMedExternen;
	private JTable tableMedInterne;
	
	private JPanel panel_1 = new JPanel();
	
	
	private JScrollPane scrollPane = new JScrollPane();
	
	//Les boutons
	private JButton btnSupprimer, btnModifier, btnAjouter;
	private JButton btnProduitPharmaceutique, btnMedicamentExterne, btnMedicamentInterne;
	private JButton btnNouveauProduit;
	
	
	
	
	/**
	 * Create the panel.
	 */
	public PanneauProduit() {
		
		
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		this.setBounds(10, 10, 696, 550);
		gridBagLayout.columnWidths = new int[]{750, 0};
		gridBagLayout.rowHeights = new int[]{130, 50, 250, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
	
		
		
		
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.ipady = 1;
		gbc_panel_1.ipadx = 1;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0};
		gbl_panel_1.rowHeights = new int[]{0};
		gbl_panel_1.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		
		
		JSplitPane splitPane = new JSplitPane();
		GridBagConstraints gbc_splitPane = new GridBagConstraints();
		gbc_splitPane.insets = new Insets(0, 0, 5, 0);
		gbc_splitPane.fill = GridBagConstraints.BOTH;
		gbc_splitPane.gridx = 0;
		gbc_splitPane.gridy = 1;
		add(splitPane, gbc_splitPane);
		
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{70, 70, 0, 70, 0};
		gbl_panel.rowHeights = new int[]{40, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		btnAjouter = new JButton("Ajouter");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		panel.add(btnAjouter, gbc_btnNewButton);
		
		btnModifier = new JButton("Modifier");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 0;
		panel.add(btnModifier, gbc_btnNewButton_1);
		
		btnSupprimer = new JButton("Supprimer");
		GridBagConstraints gbc_btnSupprimer = new GridBagConstraints();
		gbc_btnSupprimer.insets = new Insets(0, 0, 0, 5);
		gbc_btnSupprimer.fill = GridBagConstraints.BOTH;
		gbc_btnSupprimer.gridx = 2;
		gbc_btnSupprimer.gridy = 0;
		panel.add(btnSupprimer, gbc_btnSupprimer);
		
		btnNouveauProduit = new JButton("Nouveau produit");
		GridBagConstraints gbc_btnNouveauProduit = new GridBagConstraints();
		gbc_btnNouveauProduit.fill = GridBagConstraints.BOTH;
		gbc_btnNouveauProduit.gridx = 3;
		gbc_btnNouveauProduit.gridy = 0;
		panel.add(btnNouveauProduit, gbc_btnNouveauProduit);
		
		JPanel panel_2 = new JPanel();
		splitPane.setRightComponent(panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{160, 160, 160, 0};
		gbl_panel_2.rowHeights = new int[]{40, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		btnProduitPharmaceutique = new JButton("Produit pharmaceutique");
		GridBagConstraints gbc_btnProduitPharmaceutique = new GridBagConstraints();
		gbc_btnProduitPharmaceutique.fill = GridBagConstraints.VERTICAL;
		gbc_btnProduitPharmaceutique.insets = new Insets(0, 0, 0, 5);
		gbc_btnProduitPharmaceutique.gridx = 0;
		gbc_btnProduitPharmaceutique.gridy = 0;
		panel_2.add(btnProduitPharmaceutique, gbc_btnProduitPharmaceutique);
	
		btnMedicamentInterne = new JButton("Med interne");
		GridBagConstraints gbc_btnMedicamentInterne = new GridBagConstraints();
		gbc_btnMedicamentInterne.fill = GridBagConstraints.BOTH;
		gbc_btnMedicamentInterne.insets = new Insets(0, 0, 0, 5);
		gbc_btnMedicamentInterne.gridx = 1;
		gbc_btnMedicamentInterne.gridy = 0;
		panel_2.add(btnMedicamentInterne, gbc_btnMedicamentInterne);
		
		btnMedicamentExterne = new JButton("Med externe");
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_2.gridx = 2;
		gbc_btnNewButton_2.gridy = 0;
		panel_2.add(btnMedicamentExterne, gbc_btnNewButton_2);
		
		
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		add(scrollPane, gbc_scrollPane);
		
		controleur = new ControleProduit(this);
		controleur = new ControleProduit(this);
	}


	public JButton getBtnSupprimer() {
		return btnSupprimer;
	}

	public void setBtnSupprimer(JButton btnSupprimer) {
		this.btnSupprimer = btnSupprimer;
	}

	public JButton getBtnModifier() {
		return btnModifier;
	}

	public void setBtnModifier(JButton btnModifier) {
		this.btnModifier = btnModifier;
	}

	public JButton getBtnAjouter() {
		return btnAjouter;
	}

	public void setBtnAjouter(JButton btnAjouter) {
		this.btnAjouter = btnAjouter;
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

	public JButton getBtnMedicamentInterne() {
		return btnMedicamentInterne;
	}

	public void setBtnMedicamentInterne(JButton btnMedicamentInterne) {
		this.btnMedicamentInterne = btnMedicamentInterne;
	}



	public JScrollPane getScrollPane() {
		return scrollPane;
	}



	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}





	public JTable getTableProduit() {
		return tableProduit;
	}





	public void setTableProduit(JTable tableProduit) {
		this.tableProduit = tableProduit;
	}





	public JTable getTableMedExternen() {
		return tableMedExternen;
	}





	public void setTableMedExternen(JTable tableMedExternen) {
		this.tableMedExternen = tableMedExternen;
	}





	public JTable getTableMedInterne() {
		return tableMedInterne;
	}





	public void setTableMedInterne(JTable tableMedInterne) {
		this.tableMedInterne = tableMedInterne;
	}


	public JPanel getPanel_1() {
		return panel_1;
	}


	public JButton getBtnNouveauProduit() {
		return btnNouveauProduit;
	}


	public void setBtnNouveauProduit(JButton btnNouveauProduit) {
		this.btnNouveauProduit = btnNouveauProduit;
	}


	

	
	

}
