package modele;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Testf extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Testf frame = new Testf();
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
	public Testf() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(84, 32, 560, 254);
		contentPane.add(scrollPane);
		
		DefaultTableModel model = new DefaultTableModel();
		table_1 = new JTable(model);
		//scrollPane.setViewportView(table_1);
		
		System.out.println(PisteDegager.listePisteDegager_date_heure("2020-08-16","23:00:00").size());
		
		

        model.setColumnIdentifiers(new String[]{"idPiste"});
        for (int i = 0; i < Piste.listePiste().size(); i++) {
		}
        
        table_1.setModel(model);
         scrollPane.setViewportView(table_1);
       
	}
}
