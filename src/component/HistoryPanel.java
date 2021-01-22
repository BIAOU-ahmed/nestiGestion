package component;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import dao.ConditioningDAO;
import dao.ProviderDAO;

import view.Management;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class HistoryPanel extends JPanel implements Activatable{
	private JTable tableSelectedOrder;
	protected JComboBox comboBoxProviderHistory;

	/**
	 * Create the panel.
	 */
	public HistoryPanel(Management c) {

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

		comboBoxProviderHistory = new JComboBox();
		comboBoxProviderHistory.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxProviderHistory.setBounds(20, 100, 200, 40);
		this.add(comboBoxProviderHistory);
		refreshProvider();

		JComboBox comboBoxStateHistory = new JComboBox();
		comboBoxStateHistory.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxStateHistory.setBounds(520, 100, 150, 40);
		DefaultComboBoxModel<String> stateHistoryModel = new DefaultComboBoxModel<String>(
				new String[] { "Toutes", "En cours", "Reçue" });
		comboBoxStateHistory.setModel(stateHistoryModel);
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
		textFieldOrderNumberHistory.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char testChar = e.getKeyChar();
				if (!(Character.isDigit(testChar))) {
					e.consume();
				}
			}
		});
		textFieldOrderNumberHistory.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldOrderNumberHistory.setBounds(270, 100, 200, 40);
		this.add(textFieldOrderNumberHistory);
		textFieldOrderNumberHistory.setColumns(10);

		JTextField textFieldTotalPriceHistory = new JTextField();
		textFieldTotalPriceHistory.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldTotalPriceHistory.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldTotalPriceHistory.setBounds(1200, 600, 150, 40);
		this.add(textFieldTotalPriceHistory);
		textFieldTotalPriceHistory.setColumns(10);
		textFieldTotalPriceHistory.setEditable(false);

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

		DefaultTableModel model = new DefaultTableModel(new Object[][] {,}, new String[] { "N° commande",
				"Fournisseur", "Montant €", "Date commande", "Date livraison", "Statut" });

		tableOrder.setModel(model);
		tableOrder.getColumnModel().getColumn(0).setResizable(false);
		tableOrder.getColumnModel().getColumn(1).setResizable(false);
		tableOrder.getColumnModel().getColumn(2).setResizable(false);
		tableOrder.getColumnModel().getColumn(3).setResizable(false);
		tableOrder.getColumnModel().getColumn(4).setResizable(false);
		tableOrder.getColumnModel().getColumn(5).setResizable(false);
		scrollPaneOrder.setViewportView(tableOrder);
		
		JScrollPane scrollPaneSelectedOrder = new JScrollPane();
		scrollPaneSelectedOrder.setBounds(800, 100, 550, 500);
		add(scrollPaneSelectedOrder);
		
		tableSelectedOrder = new JTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tableSelectedOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		DefaultTableModel modelSelected = new DefaultTableModel(new Object[][] {,}, new String[] { "Identifiant",
				"Article", "Qté commandée", "Qté reçue", "Prix €" });

		tableSelectedOrder.setModel(modelSelected);
		tableSelectedOrder.getColumnModel().getColumn(0).setResizable(false);
		tableSelectedOrder.getColumnModel().getColumn(1).setResizable(false);
		tableSelectedOrder.getColumnModel().getColumn(2).setResizable(false);
		tableSelectedOrder.getColumnModel().getColumn(3).setResizable(false);
		tableSelectedOrder.getColumnModel().getColumn(4).setResizable(false);
		scrollPaneSelectedOrder.setViewportView(tableSelectedOrder);
		
	}
	
	public void refreshProvider() {
		var provider = (new ProviderDAO()).findALL();//
		comboBoxProviderHistory.removeAllItems();
		provider.forEach(p -> {

			comboBoxProviderHistory.addItem(p.getCompanyName());

		});
	}

	@Override
	public void onActivate() {
		// TODO Auto-generated method stub
//		HistoryPanel();
		
	}
}
