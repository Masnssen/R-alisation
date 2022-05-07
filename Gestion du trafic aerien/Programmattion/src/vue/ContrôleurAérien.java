package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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

public class ContrôleurAérien extends JFrame {

	private JPanel contentPane;
	private JTable table_1;
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContrôleurAérien frame = new ContrôleurAérien();
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
		
	public ContrôleurAérien() {
		setLocationByPlatform(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		JPanel Button_décollage = new JPanel();
		JPanel Button_Piste = new JPanel();

		
		Button_Acceuil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClick(Button_Acceuil);
				onLeavClick(Button_Piste);
				onLeavClick(Button_décollage);
	
								}
			@Override
			public void mouseEntered(MouseEvent e) {
				onHover(Button_Acceuil);
				onLeaveHover(Button_Piste);
				onLeaveHover(Button_décollage);
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
		lblaccueil.setForeground(new Color(181,77,180));
		lblaccueil.setHorizontalAlignment(SwingConstants.CENTER);
		lblaccueil.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblaccueil.setBounds(56, 18, 75, 24);
		Button_Acceuil.add(lblaccueil);
		
		
		Button_Piste.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClick(Button_Piste);
				onLeavClick(Button_Acceuil);
				onLeavClick(Button_décollage);
				//onLeavClick(Button_déconnexion);
				
				GestionPiste obj = new GestionPiste();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				dispose();
				
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				onHover(Button_Piste);
				onLeaveHover(Button_décollage);
				onLeaveHover(Button_Acceuil);

			}
			public void mouseExited(MouseEvent e) {
				onLeaveHover(Button_Piste);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				onLeavClick(Button_Piste);
			}
		});
		Button_Piste.setLayout(null);
		Button_Piste.setBackground(Color.WHITE);
		Button_Piste.setBounds(0, 156, 226, 60);
		panel.add(Button_Piste);
		
		JLabel lblMail = new JLabel("Gestion des pistes");
		lblMail.setHorizontalAlignment(SwingConstants.CENTER);
		lblMail.setForeground(new Color(96,83,150));
		lblMail.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblMail.setBounds(56, 18, 134, 24);
		Button_Piste.add(lblMail);
		
		Button_décollage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onClick(Button_décollage);
				onLeavClick(Button_Piste);
				onLeavClick(Button_Acceuil);
				
				GestionDecollagerAterrissage obj = new GestionDecollagerAterrissage();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				dispose();
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				onHover(Button_décollage);
				onLeaveHover(Button_Acceuil);
				onLeaveHover(Button_Piste);
				//onLeaveHover(Button_déconnexion);
			}
			public void mouseExited(MouseEvent e) {
				onLeaveHover(Button_décollage);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				onLeavClick(Button_décollage);
			}
		});
		Button_décollage.setLayout(null);
		Button_décollage.setBackground(Color.WHITE);
		Button_décollage.setBounds(0, 227, 226, 60);
		panel.add(Button_décollage);
		
		JLabel lblPayeent = new JLabel("Gestion des d\u00E9collage ");
		lblPayeent.setHorizontalAlignment(SwingConstants.CENTER);
		lblPayeent.setForeground(new Color(96,83,150));
		lblPayeent.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblPayeent.setBounds(47, 11, 124, 24);
		Button_décollage.add(lblPayeent);
		
		JLabel lblEtAtterrissage = new JLabel("et atterrissage");
		lblEtAtterrissage.setHorizontalAlignment(SwingConstants.CENTER);
		lblEtAtterrissage.setForeground(new Color(96, 83, 150));
		lblEtAtterrissage.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblEtAtterrissage.setBounds(47, 36, 124, 13);
		Button_décollage.add(lblEtAtterrissage);
		
		Button_déconnexion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//onClick(Button_déconnexion);
				
				onLeavClick(Button_Piste);
				onLeavClick(Button_décollage);
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
				onLeaveHover(Button_Piste);
				onLeaveHover(Button_décollage);
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
		
		JLabel lblWelcomBack = new JLabel("Contr\u00F4leur A\u00E9rien");
		lblWelcomBack.setHorizontalAlignment(SwingConstants.LEFT);
		lblWelcomBack.setForeground(new Color(96, 83, 150));
		lblWelcomBack.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblWelcomBack.setBounds(20, 11, 414, 24);
		panel_3.add(lblWelcomBack);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(45, 115, 136, 67);
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel label = new JLabel("500");
		label.setBounds(20, 20, 74, 25);
		panel_4.add(label);
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setForeground(new Color(96, 83, 150));
		label.setFont(new Font("Segoe UI", Font.BOLD, 24));
		
		JLabel lblCompletProjetct = new JLabel("Pistes");
		lblCompletProjetct.setHorizontalAlignment(SwingConstants.LEFT);
		lblCompletProjetct.setForeground(new Color(96, 83, 150));
		lblCompletProjetct.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblCompletProjetct.setBounds(53, 81, 120, 20);
		panel_3.add(lblCompletProjetct);
		
		JLabel lblHoursWorks = new JLabel("Voles");
		lblHoursWorks.setHorizontalAlignment(SwingConstants.LEFT);
		lblHoursWorks.setForeground(new Color(96, 83, 150));
		lblHoursWorks.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblHoursWorks.setBounds(233, 81, 120, 20);
		panel_3.add(lblHoursWorks);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBounds(225, 115, 136, 67);
		panel_3.add(panel_6);
		
		JLabel label_2 = new JLabel("50");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setForeground(new Color(96, 83, 150));
		label_2.setFont(new Font("Segoe UI", Font.BOLD, 24));
		label_2.setBounds(20, 20, 74, 25);
		panel_6.add(label_2);
		
		JLabel lblPayment = new JLabel("decollage");
		lblPayment.setHorizontalAlignment(SwingConstants.LEFT);
		lblPayment.setForeground(new Color(96, 83, 150));
		lblPayment.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblPayment.setBounds(421, 81, 120, 20);
		panel_3.add(lblPayment);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBounds(413, 115, 136, 67);
		panel_3.add(panel_7);
		
		JLabel label_3 = new JLabel("");
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setForeground(new Color(96, 83, 150));
		label_3.setFont(new Font("Segoe UI", Font.BOLD, 24));
		label_3.setBounds(20, 20, 74, 25);
		panel_7.add(label_3);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBounds(596, 115, 136, 67);
		panel_3.add(panel_5);
		
		JLabel label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setForeground(new Color(96, 83, 150));
		label_1.setFont(new Font("Segoe UI", Font.BOLD, 24));
		label_1.setBounds(20, 20, 74, 25);
		panel_5.add(label_1);
		
		JLabel label_4 = new JLabel("decollage");
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_4.setForeground(new Color(96, 83, 150));
		label_4.setFont(new Font("Segoe UI", Font.BOLD, 12));
		label_4.setBounds(604, 81, 120, 20);
		panel_3.add(label_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 193, 319, 307);
		panel_3.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setSelectionBackground(new Color(96, 83, 150));
		table_1.setRowHeight(20);
		table_1.setGridColor(new Color(247, 247, 247));
		table_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		table_1.setBorder(null);
		table_1.setBackground(new Color(247, 247, 247));
		scrollPane.setViewportView(table_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(421, 193, 312, 307);
		panel_3.add(scrollPane_1);
		
		table = new JTable();
		table.setSelectionBackground(new Color(96, 83, 150));
		table.setRowHeight(20);
		table.setGridColor(new Color(247, 247, 247));
		table.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		table.setBorder(null);
		table.setBackground(new Color(247, 247, 247));
		scrollPane_1.setViewportView(table);
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
}
