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
	private JTable tableSelectedOrder;

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
		comboBoxStateHistory.setFont(new Font("Tahoma", Font.PLAIN, 16));
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
		textFieldOrderNumberHistory.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldOrderNumberHistory.setBounds(270, 100, 200, 40);
		this.add(textFieldOrderNumberHistory);
		textFieldOrderNumberHistory.setColumns(10);

		JTextField textFieldTotalPriceHistory = new JTextField();
		textFieldTotalPriceHistory.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldTotalPriceHistory.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldTotalPriceHistory.setBounds(1200, 550, 150, 40);
		this.add(textFieldTotalPriceHistory);
		textFieldTotalPriceHistory.setColumns(10);
		textFieldTotalPriceHistory.setEditable(false);

		JComboBox comboBoxFinalStateHistory = new JComboBox();
		comboBoxFinalStateHistory.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxFinalStateHistory.setBounds(800, 650, 150, 40);
		this.add(comboBoxFinalStateHistory);

		JButton btnSaveStateHistory = new JButton("Valider");
		btnSaveStateHistory.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSaveStateHistory.setBounds(1000, 650, 150, 40);
		this.add(btnSaveStateHistory);

		JScrollPane scrollPaneOrder = new JScrollPane();
		scrollPaneOrder.setBounds(20, 170, 650, 550);
		this.add(scrollPaneOrder);

		JTable tableOrder = new JTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tableOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tableOrder.setFillsViewportHeight(true);

		DefaultTableModel model = new DefaultTableModel(new Object[][] {,}, new String[] { "Numéro commande",
				"Fournisseur", "Montant €", "Date commande", "Date livraison", "Statut" });

		tableOrder.setModel(model);
		tableOrder.getColumnModel().getColumn(0).setResizable(false);
		tableOrder.getColumnModel().getColumn(1).setResizable(false);
		tableOrder.getColumnModel().getColumn(2).setResizable(false);
		tableOrder.getColumnModel().getColumn(3).setResizable(false);
		tableOrder.getColumnModel().getColumn(4).setResizable(false);
		tableOrder.getColumnModel().getColumn(5).setResizable(false);
		scrollPaneOrder.setViewportView(tableOrder);
		
		JLabel lblSaveState = new JLabel("Statut Livraison");
		lblSaveState.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaveState.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSaveState.setBounds(800, 620, 150, 30);
		this.add(lblSaveState);
		
		JScrollPane scrollPaneSelectedOrder = new JScrollPane();
		scrollPaneSelectedOrder.setBounds(800, 100, 550, 452);
		add(scrollPaneSelectedOrder);
		
		tableSelectedOrder = new JTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tableSelectedOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		DefaultTableModel modelSelected = new DefaultTableModel(new Object[][] {,}, new String[] { "Identifiant",
				"Produit", "Conditionnement", "Qté commandée", "Qté reçue", "Prix €" });

		tableSelectedOrder.setModel(modelSelected);
		tableSelectedOrder.getColumnModel().getColumn(0).setResizable(false);
		tableSelectedOrder.getColumnModel().getColumn(1).setResizable(false);
		tableSelectedOrder.getColumnModel().getColumn(2).setResizable(false);
		tableSelectedOrder.getColumnModel().getColumn(3).setResizable(false);
		tableSelectedOrder.getColumnModel().getColumn(4).setResizable(false);
		tableSelectedOrder.getColumnModel().getColumn(5).setResizable(false);
		scrollPaneSelectedOrder.setViewportView(tableSelectedOrder);
		
	}
}
