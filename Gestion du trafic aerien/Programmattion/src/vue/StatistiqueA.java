package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modele.Statistique;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;

public class StatistiqueA extends JFrame {

	private JPanel contentPane;
	private static JTable table_1;
	private JScrollPane scrollPane;
	private Statistique statistique =  new Statistique();	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatistiqueA frame = new StatistiqueA();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
		
	public StatistiqueA() {
		setLocationByPlatform(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(100, 100, 1000,500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204,204,204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 226, 500);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel Button_Acceuil = new JPanel();
		JPanel Button_déconnexion = new JPanel();
		JPanel Button_statistique = new JPanel();
		JPanel Button_Redevance = new JPanel();

		
		Button_Acceuil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClick(Button_Acceuil);
				onLeavClick(Button_Redevance);
				onLeavClick(Button_statistique);
				//onLeavClick(Button_déconnexion);	
			

								}
			@Override
			public void mouseEntered(MouseEvent e) {
				onHover(Button_Acceuil);
				//onLeaveHover(Button_déconnexion);
				onLeaveHover(Button_Redevance);
				onLeaveHover(Button_statistique);
			}
			public void mouseExited(MouseEvent e) {
				onLeaveHover(Button_Acceuil);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				onLeavClick(Button_Acceuil);
			}
		});

		Button_Acceuil.setLayout(null);
		Button_Acceuil.setBackground(Color.WHITE);
		Button_Acceuil.setBounds(0, 85, 226, 60);
		panel.add(Button_Acceuil);
		
		JLabel lblaccueil = new JLabel("Accueil");
		lblaccueil.setForeground(new Color(96,83,150));
		lblaccueil.setHorizontalAlignment(SwingConstants.CENTER);
		lblaccueil.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblaccueil.setBounds(56, 18, 75, 24);
		Button_Acceuil.add(lblaccueil);
		
		
		Button_Redevance.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClick(Button_Redevance);
				onLeavClick(Button_Acceuil);
				onLeavClick(Button_statistique);
			
				GestionRedevance obj = new GestionRedevance();
				obj.setVisible(true);
	  			obj.setLocationRelativeTo(null);
	  			dispose();
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				onHover(Button_Redevance);
				onLeaveHover(Button_statistique);
				onLeaveHover(Button_Acceuil);

			}
			public void mouseExited(MouseEvent e) {
				onLeaveHover(Button_Redevance);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				onLeavClick(Button_Redevance);
			}
		});
		Button_Redevance.setLayout(null);
		Button_Redevance.setBackground(Color.WHITE);
		Button_Redevance.setBounds(0, 156, 226, 60);
		panel.add(Button_Redevance);
		
		JLabel lblMail = new JLabel("Pistes et compagnie les plus danses");
		lblMail.setHorizontalAlignment(SwingConstants.CENTER);
		lblMail.setForeground(new Color(181,77,180));
		lblMail.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblMail.setBounds(10, 18, 194, 24);
		Button_Redevance.add(lblMail);
		
		Button_statistique.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClick(Button_statistique);
				onLeavClick(Button_Redevance);
				onLeavClick(Button_Acceuil);
				//onLeavClick(Button_déconnexion);
				
				
			;
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				onHover(Button_statistique);
				onLeaveHover(Button_Acceuil);
				onLeaveHover(Button_Redevance);
				//onLeaveHover(Button_déconnexion);
			}
			public void mouseExited(MouseEvent e) {
				onLeaveHover(Button_statistique);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				onLeavClick(Button_statistique);
			}
		});
		Button_statistique.setLayout(null);
		Button_statistique.setBackground(Color.WHITE);
		Button_statistique.setBounds(0, 227, 226, 60);
		panel.add(Button_statistique);
		
		JLabel lblPayeent = new JLabel("Gestion des statistiques ");
		lblPayeent.setHorizontalAlignment(SwingConstants.CENTER);
		lblPayeent.setForeground(new Color(96,83,150));
		lblPayeent.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblPayeent.setBounds(47, 11, 146, 24);
		Button_statistique.add(lblPayeent);
		
		Button_déconnexion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//onClick(Button_déconnexion);
				
				onLeavClick(Button_Redevance);
				onLeavClick(Button_statistique);
				onLeavClick(Button_Acceuil);
				
				
				 authentification obj = new authentification();
					obj.setVisible(true);
					obj.setLocationRelativeTo(null);
					dispose();
					}
			@Override
			public void mouseEntered(MouseEvent e) {
				//onHover(Button_déconnexion);
				Button_déconnexion.setBackground(Color.DARK_GRAY);
				onLeaveHover(Button_Acceuil);
				onLeaveHover(Button_Redevance);
				onLeaveHover(Button_statistique);
			}public void mouseExited(MouseEvent e) {
				Button_déconnexion.setBackground(Color.RED);
			}
			
			
		});
		Button_déconnexion.setLayout(null);
		Button_déconnexion.setBackground(Color.RED);
		Button_déconnexion.setBounds(0, 429, 226, 60);
		panel.add(Button_déconnexion);
		
		JLabel lblTaskView = new JLabel("d\u00E9connexion");
		lblTaskView.setHorizontalAlignment(SwingConstants.CENTER);
		lblTaskView.setForeground(Color.WHITE);
		lblTaskView.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblTaskView.setBounds(56, 18, 123, 24);
		Button_déconnexion.add(lblTaskView);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(247,247,247));
		panel_3.setBounds(236, 0, 774, 500);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblWelcomBack = new JLabel("Gestion des statistiques ");
		lblWelcomBack.setHorizontalAlignment(SwingConstants.LEFT);
		lblWelcomBack.setForeground(new Color(96, 83, 150));
		lblWelcomBack.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblWelcomBack.setBounds(20, 11, 414, 24);
		panel_3.add(lblWelcomBack);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(68, 145, 286, 270);
		panel_3.add(scrollPane);
		
		DefaultTableModel model = new DefaultTableModel();
		table_1 = new JTable(model);
		table_1.setSelectionBackground(new Color(96, 83, 150));
		table_1.setRowHeight(20);
		table_1.setGridColor(new Color(247, 247, 247));
		table_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		table_1.setBorder(null);
		table_1.setBackground(new Color(247, 247, 247));
		update_table_piste_danse(table_1);
		scrollPane.setViewportView(table_1);
		
		JLabel lblPisteDanse = new JLabel("Piste danse");
		lblPisteDanse.setHorizontalAlignment(SwingConstants.LEFT);
		lblPisteDanse.setForeground(new Color(96, 83, 150));
		lblPisteDanse.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblPisteDanse.setBounds(68, 86, 286, 24);
		panel_3.add(lblPisteDanse);
		
		JLabel lblCompagnieLaPlus = new JLabel("Compagnie la plus impos\u00E9");
		lblCompagnieLaPlus.setHorizontalAlignment(SwingConstants.LEFT);
		lblCompagnieLaPlus.setForeground(new Color(96, 83, 150));
		lblCompagnieLaPlus.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblCompagnieLaPlus.setBounds(386, 86, 286, 24);
		panel_3.add(lblCompagnieLaPlus);
		
		JLabel lblIdCompagnie = new JLabel("ID Compagnie");
		lblIdCompagnie.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdCompagnie.setForeground(new Color(96, 83, 150));
		lblIdCompagnie.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblIdCompagnie.setBounds(386, 168, 164, 24);
		panel_3.add(lblIdCompagnie);
		
		JLabel lblNomCompagnie = new JLabel("Nom Compagnie");
		lblNomCompagnie.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomCompagnie.setForeground(new Color(96, 83, 150));
		lblNomCompagnie.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNomCompagnie.setBounds(386, 215, 164, 24);
		panel_3.add(lblNomCompagnie);
		
		JLabel lblSite = new JLabel("Site");
		lblSite.setHorizontalAlignment(SwingConstants.LEFT);
		lblSite.setForeground(new Color(96, 83, 150));
		lblSite.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblSite.setBounds(386, 266, 164, 24);
		panel_3.add(lblSite);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setForeground(new Color(96, 83, 150));
		lblEmail.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblEmail.setBounds(386, 318, 164, 24);
		panel_3.add(lblEmail);
		
		JLabel lblNumTel = new JLabel("Num Tell");
		lblNumTel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumTel.setForeground(new Color(96, 83, 150));
		lblNumTel.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNumTel.setBounds(386, 368, 164, 24);
		panel_3.add(lblNumTel);
		
		
		JLabel lblid = new JLabel(statistique.getCompagnieImposé().getIdCompagnie());
		lblid.setHorizontalAlignment(SwingConstants.LEFT);
		lblid.setForeground(Color.DARK_GRAY);
		lblid.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblid.setBounds(558, 168, 164, 24);
		panel_3.add(lblid);
		
		JLabel lblnomcompagnie = new JLabel(statistique.getCompagnieImposé().getNomCompagnie());
		lblnomcompagnie.setHorizontalAlignment(SwingConstants.LEFT);
		lblnomcompagnie.setForeground(Color.DARK_GRAY);
		lblnomcompagnie.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblnomcompagnie.setBounds(558, 215, 164, 24);
		panel_3.add(lblnomcompagnie);
		
		JLabel lblsite = new JLabel(statistique.getCompagnieImposé().getSite());
		lblsite.setHorizontalAlignment(SwingConstants.LEFT);
		lblsite.setForeground(Color.DARK_GRAY);
		lblsite.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblsite.setBounds(558, 275, 164, 24);
		panel_3.add(lblsite);
		
		JLabel lblemail = new JLabel(statistique.getCompagnieImposé().getEmail());
		lblemail.setHorizontalAlignment(SwingConstants.LEFT);
		lblemail.setForeground(Color.DARK_GRAY);
		lblemail.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblemail.setBounds(558, 318, 164, 24);
		panel_3.add(lblemail);
		
		JLabel lblNumTe = new JLabel(statistique.getCompagnieImposé().getNumTel());
		lblNumTe.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumTe.setForeground(Color.DARK_GRAY);
		lblNumTe.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNumTe.setBounds(558, 368, 164, 24);
		panel_3.add(lblNumTe);
	}
	private void onHover(JPanel p) {
		p.setBackground(new Color(232,201,232));
	}
	private void onLeaveHover(JPanel p) {
		p.setBackground(Color.white);
	}
    private void onClick(JPanel p) {
		p.setBackground(new Color(205,136,205));

	}
    private void onLeavClick(JPanel p) {
		p.setBackground(Color.white);

	}
    public void update_table_piste_danse(JTable table){
		DefaultTableModel model = new DefaultTableModel();
		Statistique stat = new Statistique();
		
		 model.setColumnIdentifiers(new String[]{"idPiste","longeur","aeroport"});
	        for (int i = 0; i < stat.getPisteDense().length; i++) {
				model.addRow(new String[] {Integer.toString(stat.getPisteDense()[i].getIdPiste())
						,Double.toString(stat.getPisteDense()[i].getLongeur())
						,stat.getPisteDense()[i].getAeroport().getIdAeroport()});
			}
	        
	        table.setModel(model);
		
	}
}
