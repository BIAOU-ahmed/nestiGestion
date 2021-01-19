package component;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class HistoryPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public HistoryPanel() {

		this.setLayout(null);

		JLabel lblTitleHistory = new JLabel("Historique des commandes");
		lblTitleHistory.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleHistory.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTitleHistory.setBounds(100, 20, 490, 30);
		this.add(lblTitleHistory);

		JLabel lblProviderHistory = new JLabel("Fournisseur");
		lblProviderHistory.setHorizontalAlignment(SwingConstants.CENTER);
		lblProviderHistory.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblProviderHistory.setBounds(20, 70, 200, 30);
		this.add(lblProviderHistory);

		JComboBox comboBoxProviderHistory = new JComboBox();
		comboBoxProviderHistory.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxProviderHistory.setBounds(20, 100, 200, 40);
		this.add(comboBoxProviderHistory);

		JComboBox comboBoxStateHistory = new JComboBox();
		comboBoxStateHistory.setBounds(520, 100, 150, 40);
		this.add(comboBoxStateHistory);

		JLabel lblStateHistory = new JLabel("Etat livraison");
		lblStateHistory.setHorizontalAlignment(SwingConstants.CENTER);
		lblStateHistory.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStateHistory.setBounds(520, 70, 150, 30);
		this.add(lblStateHistory);

		JLabel lblOrderNumberHistory = new JLabel("Num\u00E9ro de commande");
		lblOrderNumberHistory.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrderNumberHistory.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOrderNumberHistory.setBounds(270, 70, 200, 30);
		this.add(lblOrderNumberHistory);

		JTextField textFieldOrderNumberHistory = new JTextField();
		textFieldOrderNumberHistory.setBounds(270, 100, 200, 40);
		this.add(textFieldOrderNumberHistory);
		textFieldOrderNumberHistory.setColumns(10);

		JTable tableRecap = new JTable();
		tableRecap.setBounds(750, 50, 600, 500);
		this.add(tableRecap);

		JTextField textFieldTotalPriceHistory = new JTextField();
		textFieldTotalPriceHistory.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldTotalPriceHistory.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldTotalPriceHistory.setBounds(1200, 550, 150, 40);
		this.add(textFieldTotalPriceHistory);
		textFieldTotalPriceHistory.setColumns(10);

		JComboBox comboBoxFinalStateHistory = new JComboBox();
		comboBoxFinalStateHistory.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxFinalStateHistory.setBounds(800, 650, 150, 40);
		this.add(comboBoxFinalStateHistory);

		JButton btnSaveStateHistory = new JButton("Valider");
		btnSaveStateHistory.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSaveStateHistory.setBounds(1000, 650, 150, 40);
		this.add(btnSaveStateHistory);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 170, 650, 550);
		this.add(scrollPane);

		JTable table = new JTable();
		table.setFillsViewportHeight(true);

		DefaultTableModel model = new DefaultTableModel(new Object[][] {,}, new String[] { "Numéro commande",
				"Fournisseur", "Montant €", "Date commande", "Date livraison", "Statut" });

		table.setModel(model);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);
		scrollPane.setViewportView(table);
		
		JLabel lblSaveState = new JLabel("Statut Livraison");
		lblSaveState.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaveState.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSaveState.setBounds(800, 620, 150, 30);
		this.add(lblSaveState);
		
	}

}
