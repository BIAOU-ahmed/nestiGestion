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
import javax.swing.table.TableRowSorter;

import dao.ConditioningDAO;
import dao.OrderDAO;
import dao.OrderLineDAO;
import dao.ProviderDAO;
import dao.SellDAO;
import model.Order;
import model.OrderLine;
import model.Sell;
import tools.Useful;
import view.Management;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class HistoryPanel extends Tab {
	private JTable tableSelectedOrder;
	protected JComboBox comboBoxProviderHistory;
	JComboBox comboBoxStateHistory;
	DefaultTableModel model;
	JTable tableOrder;
	JTextField textFieldOrderNumberHistory;
	DefaultTableModel modelSelected;
	JTextField textFieldTotalPriceHistory;
	
	
	/**
	 * Create the panel.
	 */
	public HistoryPanel(Management c) {

		this.setLayout(null);

		refreshTab();

	}

	public void refreshProvider() {
		var provider = (new ProviderDAO()).findALL();//
		comboBoxProviderHistory.removeAllItems();
		comboBoxProviderHistory.addItem("");
		provider.forEach(p -> {

			comboBoxProviderHistory.addItem(p.getCompanyName());

		});
	}

	public void refreshOrdersTable(List<Order> orders) {
//		if(comboBoxStateHistory.getSelectedIndex()==0) {
		var provider = (new ProviderDAO()).find("compagnyName", comboBoxProviderHistory.getSelectedItem().toString());
//		List<Order> orders = (new OrderDAO()).findALLBy("state", "a");//

		model.setRowCount(0);
		orders.forEach(s -> {
			Object[] row1 = null;
			var t = false;
			if (provider != null) {
				if (s.getIdProvider() == provider.getId()) {

					if (comboBoxStateHistory.getSelectedIndex() != 0) {

						if (s.getDisplayState().equals(comboBoxStateHistory.getSelectedItem().toString())) {
							row1 = s.toRow();
//							System.out.println("state "+s.getDisplayState());
//							model.addRow(row1);
						}
					} else {
						row1 = s.toRow();

						// Ajout d'une rang�e

					}

				}
			} else {
//				row1 = s.toRow();

				if (comboBoxStateHistory.getSelectedIndex() != 0) {

					if (s.getDisplayState().equals(comboBoxStateHistory.getSelectedItem().toString())) {
						row1 = s.toRow();
//						System.out.println("state "+s.getDisplayState());
//						model.addRow(row1);
					}
				} else {
					row1 = s.toRow();

					// Ajout d'une rang�e

				}
			}
			if (row1 != null) {
				model.addRow(row1);
			}

		});

//			Useful.displayOrder(ordes, model,provider.getId());
//		}
	}

	@Override
	public void refreshTab() {
		super.refreshTab();

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

		comboBoxStateHistory = new JComboBox();
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

		textFieldOrderNumberHistory = new JTextField();

		textFieldOrderNumberHistory.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldOrderNumberHistory.setBounds(270, 100, 200, 40);
		this.add(textFieldOrderNumberHistory);
		textFieldOrderNumberHistory.setColumns(10);

		textFieldTotalPriceHistory = new JTextField();
		textFieldTotalPriceHistory.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldTotalPriceHistory.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldTotalPriceHistory.setBounds(1200, 600, 150, 40);
		this.add(textFieldTotalPriceHistory);
		textFieldTotalPriceHistory.setColumns(10);
		textFieldTotalPriceHistory.setEditable(false);

		JScrollPane scrollPaneOrder = new JScrollPane();
		scrollPaneOrder.setBounds(20, 170, 650, 550);
		this.add(scrollPaneOrder);

		tableOrder = new JTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tableOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tableOrder.setFillsViewportHeight(true);

		model = (DefaultTableModel) tableOrder.getModel();
		model.addColumn("N° commande");
		model.addColumn("Fournisseur");
		model.addColumn("Montant €");
		model.addColumn("Date commande");
		model.addColumn("Date livraison");
		model.addColumn("Statut");
//				new DefaultTableModel(new Object[][] {,}, new String[] { "", "", "",
//				"", "", "" });

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
		modelSelected = new DefaultTableModel(new Object[][] {,},
				new String[] { "Identifiant", "Article", "Qté commandée", "Qté reçue", "Prix €" });

		tableSelectedOrder.setModel(modelSelected);
		tableSelectedOrder.getColumnModel().getColumn(0).setResizable(false);
		tableSelectedOrder.getColumnModel().getColumn(1).setResizable(false);
		tableSelectedOrder.getColumnModel().getColumn(2).setResizable(false);
		tableSelectedOrder.getColumnModel().getColumn(3).setResizable(false);
		tableSelectedOrder.getColumnModel().getColumn(4).setResizable(false);
		scrollPaneSelectedOrder.setViewportView(tableSelectedOrder);
		List<Order> orders = (new OrderDAO()).findALLBy("state", "a");
		refreshOrdersTable(orders);

		setUpListener();
		Useful.sort(model, tableOrder);
	}

	public void setUpListener() {

		
		tableOrder.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!tableOrder.getSelectionModel().isSelectionEmpty()) {
					int row = tableOrder.getSelectedRow();
					
					List<OrderLine> orderLines = (new OrderLineDAO()).findALLBy("idOrders",
							((Integer) tableOrder.getValueAt(row, 0)));//
					Useful.displayOrderLineByOrder(orderLines, modelSelected);
					textFieldTotalPriceHistory.setText(tableOrder.getValueAt(row, 2).toString()+" €");

				}
			}
		});
		
		textFieldOrderNumberHistory.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				var list = (new OrderDAO()).findAllLike("idOrders", textFieldOrderNumberHistory.getText());
				var newList = new ArrayList<Order>();
				
				list.forEach(o->{
					if(o.getState().equals("a")) {
						newList.add(o);
					}
				});
				
//				System.out.println(list.size());
				refreshOrdersTable(newList);

			}
		});
		
		
		comboBoxProviderHistory.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				List<Order> orders = (new OrderDAO()).findALLBy("state", "a");
				refreshOrdersTable(orders);
			}
		});

		comboBoxStateHistory.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				List<Order> orders = (new OrderDAO()).findALLBy("state", "a");
				refreshOrdersTable(orders);
			}
		});

		textFieldOrderNumberHistory.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char testChar = e.getKeyChar();
				if (!(Character.isDigit(testChar))) {
					e.consume();
				}
			}
		});

	}
}
