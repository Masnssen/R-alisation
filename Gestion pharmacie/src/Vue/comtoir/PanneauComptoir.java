package Vue.comtoir;

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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import controle.comptoir.ControleComptoir;
import javax.swing.JComboBox;

public class PanneauComptoir extends JPanel {
	private ControleComptoir controle;
	private JTextField txtRecherche;
	private JTable tableProduit;
	private JTextField textTotal;
	private JTable tableOrdonnance;
	private JButton btnRechercher, btnAjouter,btnSupprimer, btnServie;
	private JButton btnAfficher;
	private JTable tableListeOrdonnance;
	private JPanel panel;
	private JPanel panel_2;
	private JButton btnNvlOrdonance;
	private JButton btnAjouterClient;
	private JComboBox comboBoxclient;

	/**
	 * Create the panel.
	 */
	public PanneauComptoir() {
		this.setBounds(10, 10, 700, 550);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{100, 160, 0};
		gridBagLayout.rowHeights = new int[]{300, 200, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		 panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{700, 0};
		gbl_panel.rowHeights = new int[]{30, 250, 20, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("Ordonnance");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 1;
		panel.add(scrollPane_1, gbc_scrollPane_1);
		
		tableOrdonnance = new JTable();
		scrollPane_1.setViewportView(tableOrdonnance);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 2;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{50, 0, 60, 60, 50, 50, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JButton btnCommandeClient = new JButton("Commande client");
		btnCommandeClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PanneauCommandeClient().setVisible(true);;
			}
		});
		
		GridBagConstraints gbc_btnCommandeClient = new GridBagConstraints();
		gbc_btnCommandeClient.anchor = GridBagConstraints.EAST;
		gbc_btnCommandeClient.insets = new Insets(0, 0, 5, 5);
		gbc_btnCommandeClient.gridx = 0;
		gbc_btnCommandeClient.gridy = 0;
		panel_1.add(btnCommandeClient, gbc_btnCommandeClient);
		
		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setEnabled(false);
		
		GridBagConstraints gbc_btnSupprimer = new GridBagConstraints();
		gbc_btnSupprimer.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSupprimer.insets = new Insets(0, 0, 5, 5);
		gbc_btnSupprimer.gridx = 2;
		gbc_btnSupprimer.gridy = 0;
		panel_1.add(btnSupprimer, gbc_btnSupprimer);
		
		btnServie = new JButton("Servie");
		btnServie.setEnabled(false);
		GridBagConstraints gbc_btnServie = new GridBagConstraints();
		gbc_btnServie.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnServie.insets = new Insets(0, 0, 5, 5);
		gbc_btnServie.gridx = 3;
		gbc_btnServie.gridy = 0;
		panel_1.add(btnServie, gbc_btnServie);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblTotal = new GridBagConstraints();
		gbc_lblTotal.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblTotal.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotal.gridx = 4;
		gbc_lblTotal.gridy = 0;
		panel_1.add(lblTotal, gbc_lblTotal);
		
		textTotal = new JTextField();
		textTotal.setFont(new Font("Tahoma", Font.BOLD, 13));
		textTotal.setHorizontalAlignment(SwingConstants.CENTER);
		textTotal.setText("000000");
		textTotal.setEditable(false);
		GridBagConstraints gbc_textTotal = new GridBagConstraints();
		gbc_textTotal.insets = new Insets(0, 0, 5, 0);
		gbc_textTotal.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTotal.gridx = 5;
		gbc_textTotal.gridy = 0;
		panel_1.add(textTotal, gbc_textTotal);
		textTotal.setColumns(10);
		
		btnNvlOrdonance = new JButton("Nvl Ordonance");
		GridBagConstraints gbc_btnNvlOrdonance = new GridBagConstraints();
		gbc_btnNvlOrdonance.insets = new Insets(0, 0, 0, 5);
		gbc_btnNvlOrdonance.gridx = 0;
		gbc_btnNvlOrdonance.gridy = 1;
		panel_1.add(btnNvlOrdonance, gbc_btnNvlOrdonance);
		
		btnAjouterClient = new JButton("Ajouter client");
		GridBagConstraints gbc_btnAjouterClient = new GridBagConstraints();
		gbc_btnAjouterClient.insets = new Insets(0, 0, 0, 5);
		gbc_btnAjouterClient.gridx = 2;
		gbc_btnAjouterClient.gridy = 1;
		panel_1.add(btnAjouterClient, gbc_btnAjouterClient);
		
		comboBoxclient = new JComboBox();
		GridBagConstraints gbc_comboBoxclient = new GridBagConstraints();
		gbc_comboBoxclient.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxclient.gridx = 5;
		gbc_comboBoxclient.gridy = 1;
		panel_1.add(comboBoxclient, gbc_comboBoxclient);
		
		
		
		 panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 0;
		add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblListeDesOrdonnances = new JLabel("Liste des Ordonnances ");
		lblListeDesOrdonnances.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblListeDesOrdonnances.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblListeDesOrdonnances = new GridBagConstraints();
		gbc_lblListeDesOrdonnances.insets = new Insets(0, 0, 5, 0);
		gbc_lblListeDesOrdonnances.fill = GridBagConstraints.BOTH;
		gbc_lblListeDesOrdonnances.gridx = 0;
		gbc_lblListeDesOrdonnances.gridy = 0;
		panel_2.add(lblListeDesOrdonnances, gbc_lblListeDesOrdonnances);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_3 = new GridBagConstraints();
		gbc_scrollPane_3.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_3.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_3.gridx = 0;
		gbc_scrollPane_3.gridy = 1;
		panel_2.add(scrollPane_3, gbc_scrollPane_3);
		
		tableListeOrdonnance = new JTable();
		scrollPane_3.setViewportView(tableListeOrdonnance);
		
		btnAfficher = new JButton("Afficher");
		btnAfficher.setEnabled(false);
		
		GridBagConstraints gbc_btnAfficher = new GridBagConstraints();
		gbc_btnAfficher.gridx = 0;
		gbc_btnAfficher.gridy = 2;
		panel_2.add(btnAfficher, gbc_btnAfficher);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		add(scrollPane, gbc_scrollPane);
		
		JPanel panel_3 = new JPanel();
		scrollPane.setColumnHeaderView(panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{160, 100, 100, 0, 80, 0};
		gbl_panel_3.rowHeights = new int[]{30, 0};
		gbl_panel_3.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		txtRecherche = new JTextField();
		txtRecherche.setHorizontalAlignment(SwingConstants.CENTER);
		txtRecherche.setText("Nom produit");
		GridBagConstraints gbc_txtRecherche = new GridBagConstraints();
		gbc_txtRecherche.insets = new Insets(0, 0, 0, 5);
		gbc_txtRecherche.fill = GridBagConstraints.BOTH;
		gbc_txtRecherche.gridx = 0;
		gbc_txtRecherche.gridy = 0;
		panel_3.add(txtRecherche, gbc_txtRecherche);
		txtRecherche.setColumns(10);
		
		btnRechercher = new JButton("Rechercher");
		GridBagConstraints gbc_btnRechercher = new GridBagConstraints();
		gbc_btnRechercher.fill = GridBagConstraints.BOTH;
		gbc_btnRechercher.insets = new Insets(0, 0, 0, 5);
		gbc_btnRechercher.gridx = 1;
		gbc_btnRechercher.gridy = 0;
		panel_3.add(btnRechercher, gbc_btnRechercher);
		
		btnAjouter = new JButton("Ajouter");
		btnAjouter.setEnabled(false);
			
		GridBagConstraints gbc_btnAjouter = new GridBagConstraints();
		gbc_btnAjouter.fill = GridBagConstraints.BOTH;
		gbc_btnAjouter.insets = new Insets(0, 0, 0, 5);
		gbc_btnAjouter.gridx = 2;
		gbc_btnAjouter.gridy = 0;
		panel_3.add(btnAjouter, gbc_btnAjouter);
			
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane.setViewportView(scrollPane_2);
			
		tableProduit = new JTable();
		scrollPane_2.setViewportView(tableProduit);
			
		controle = new ControleComptoir(this);

	}

	public JTable getTableProduit() {
		return tableProduit;
	}

	public void setTableProduit(JTable tableProduit) {
		this.tableProduit = tableProduit;
	}

	public JTable getTableOrdonnance() {
		return tableOrdonnance;
	}

	public void setTableOrdonnance(JTable tableOrdonnance) {
		this.tableOrdonnance = tableOrdonnance;
	}

	public JTextField getTxtRecherche() {
		return txtRecherche;
	}

	public void setTxtRecherche(JTextField txtRecherche) {
		this.txtRecherche = txtRecherche;
	}

	public JTextField getTextTotal() {
		return textTotal;
	}

	public void setTextTotal(JTextField textTotal) {
		this.textTotal = textTotal;
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


	public JButton getBtnSupprimer() {
		return btnSupprimer;
	}

	public void setBtnSupprimer(JButton btnSupprimer) {
		this.btnSupprimer = btnSupprimer;
	}

	public ControleComptoir getControle() {
		return controle;
	}

	public void setControle(ControleComptoir controle) {
		this.controle = controle;
	}

	public JButton getBtnServie() {
		return btnServie;
	}

	public void setBtnServie(JButton btnServie) {
		this.btnServie = btnServie;
	}


	public JTable getTableListeOrdonnance() {
		return tableListeOrdonnance;
	}

	public void setTableListeOrdonnance(JTable tableListeOrdonnance) {
		this.tableListeOrdonnance = tableListeOrdonnance;
	}

	public JButton getBtnAfficher() {
		return btnAfficher;
	}

	public void setBtnAfficher(JButton btnAfficher) {
		this.btnAfficher = btnAfficher;
	}

	public JPanel getPanel() {
		return panel;
	}

	public JPanel getPanel_2() {
		return panel_2;
	}
	public JButton getBtnNvlOrdonance() {
		return btnNvlOrdonance;
	}
	public JButton getBtnAjouterClient() {
		return btnAjouterClient;
	}
	public JComboBox getComboBoxclient() {
		return comboBoxclient;
	}

	public void setComboBoxclient(JComboBox comboBoxclient) {
		this.comboBoxclient = comboBoxclient;
	}	
	
	
}
