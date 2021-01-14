package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.Dimension;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class Management extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table_1;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Management frame = new Management();
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
	public Management() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1440, 810);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setMaximumSize(new Dimension(10, 32767));
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Historique Commande", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Historique des commandes");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(181, 11, 290, 34);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Fournisseur");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(28, 85, 74, 28);
		panel.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(112, 90, 127, 22);
		panel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(585, 88, 137, 22);
		panel.add(comboBox_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Etat livraison");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(608, 49, 84, 28);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Num\u00E9ro de commande");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBounds(255, 85, 137, 28);
		panel.add(lblNewLabel_1_1_1);
		
		textField = new JTextField();
		textField.setBounds(402, 85, 156, 28);
		panel.add(textField);
		textField.setColumns(10);
		
		table_1 = new JTable();
		table_1.setBounds(836, 85, 548, 378);
		panel.add(table_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(1289, 473, 95, 34);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(836, 562, 127, 34);
		panel.add(comboBox_2);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.setBounds(1000, 562, 109, 34);
		panel.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 142, 698, 558);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		
		DefaultTableModel model = new DefaultTableModel(new Object[][] {,},
				new String[] { "Numéro commande", "Fournisseur","Montant €", "Date commande","Date livraison","Statut" });

		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Num\u00E9ro commande", "Fournisseur", "Montant \u20AC", "Date commande", "Date livraison", "Statut"
			}
		));
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);
		scrollPane.setViewportView(table);
//		scrollPane.setColumnHeaderView(table);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Gestion Livraison", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Gestion Commande", null, panel_2, null);
		
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Gestion article", null, panel_3, null);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Gestion produit", null, panel_4, null);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Gestion Fournisseur", null, panel_5, null);
		
		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("Profil", null, panel_6, null);
	}
}
