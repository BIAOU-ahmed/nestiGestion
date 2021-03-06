package component;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import dao.AdministratorDAO;
import dao.OrderDAO;
import dao.OrderLineDAO;
import dao.ProviderDAO;
import dao.SellDAO;
import listener.OrderNumberListener;
import model.Order;
import model.OrderLine;
import tools.AppSettings;
import tools.Useful;
import view.Management;

public class OrderPanel extends Tab {

	Order order = null;
	JComboBox<String> comboBoxProviderOrder;
	JComboBox<String> comboBoxArticleOrder;
	JComboBox<String> comboBoxOrderNumberOrder;
	JTextField textFieldTotalPrice;
	DefaultTableModel modelOrder;
	JTextField textFieldQtyOrder;
	JButton btnAddOrder;
	JTable tableOrder;
	JButton btnOrderOrder;
	JButton btnUpdateOrder;
	JButton btnDeleteOrder;

	/**
	 * Create the panel.
	 * @param c the management panel
	 */
	public OrderPanel(Management c) {

		this.setLayout(null);
		refreshTab();
		

		Useful.sort(modelOrder, tableOrder);
	}

	/**
	 * refresh the combo box of provider
	 */
	public void refreshProvider() {
		var provider = (new ProviderDAO()).findALLBy("providerState", "a");//
		comboBoxProviderOrder.removeAllItems();
		comboBoxProviderOrder.addItem("");
		provider.forEach(p -> {

			comboBoxProviderOrder.addItem(p.getCompanyName());

		});
	}

	/**
	 * refresh the article combo box
	 */
	public void refreshArticle() {
		if (!comboBoxProviderOrder.getSelectedItem().toString().isEmpty()) {
			var provider = (new ProviderDAO()).find("compagnyName", comboBoxProviderOrder.getSelectedItem().toString());

			var article = (new SellDAO()).findALLBy("idProvider", provider.getId());//

			comboBoxArticleOrder.removeAllItems();

			article.forEach(a -> {

				comboBoxArticleOrder.addItem(
						a.getArticle().getId() + " - " + a.getArticle().getConditioning().getConditioningName() + " de "
								+ a.getArticle().getAmount() + " " + a.getArticle().getProduct().getProductName());

			});
		} else {
			comboBoxArticleOrder.removeAllItems();
		}
		textFieldQtyOrder.setText("");
	}

	/**
	 * refresh order lines table
	 */
	public void refreshTable() {
		if (comboBoxOrderNumberOrder.getSelectedItem() != null) {
			if (!comboBoxOrderNumberOrder.getSelectedItem().toString().isEmpty()) {
				List<OrderLine> updateLine = (new OrderLineDAO()).findALLBy("idOrders",
						Integer.parseInt(comboBoxOrderNumberOrder.getSelectedItem().toString()));
				Useful.displayOrderLine(updateLine, modelOrder);
				updateTotalPrice();
			}
		} else {
			modelOrder.setRowCount(0);
			textFieldTotalPrice.setText("");
		}

	}

	/**
	 * @return the comboBoxProviderOrder
	 */
	public JComboBox getComboBoxProviderOrder() {
		return comboBoxProviderOrder;
	}

	/**
	 * @return the comboBoxArticleOrder
	 */
	public JComboBox getComboBoxArticleOrder() {
		return comboBoxArticleOrder;
	}

	@Override
	public void refreshTab() {
		super.refreshTab();

		var orderList = (new OrderDAO()).getActiveOrders();
	

		JLabel lblTitle1Order = new JLabel("Passer une commande");
		lblTitle1Order.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle1Order.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTitle1Order.setBounds(0, 50, 500, 70);
		this.add(lblTitle1Order);

		JLabel lblProviderOrder = new JLabel("Fournisseur");
		lblProviderOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblProviderOrder.setHorizontalAlignment(SwingConstants.CENTER);
		lblProviderOrder.setBounds(100, 180, 300, 20);
		this.add(lblProviderOrder);

		JLabel lblQtyOrder = new JLabel("Quantité");
		lblQtyOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQtyOrder.setHorizontalAlignment(SwingConstants.CENTER);
		lblQtyOrder.setBounds(350, 430, 100, 20);
		this.add(lblQtyOrder);

		JLabel lblArticleOrder = new JLabel("Article");
		lblArticleOrder.setHorizontalAlignment(SwingConstants.CENTER);
		lblArticleOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblArticleOrder.setBounds(50, 430, 250, 20);
		this.add(lblArticleOrder);

		JLabel lblOrderNumberOrder = new JLabel("Num\u00E9ro de commande en cours");
		lblOrderNumberOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOrderNumberOrder.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrderNumberOrder.setBounds(650, 30, 250, 40);
		this.add(lblOrderNumberOrder);

		JLabel lblTitle2Order = new JLabel("Ligne de Commande");
		lblTitle2Order.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle2Order.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitle2Order.setBounds(100, 320, 300, 40);
		this.add(lblTitle2Order);

		comboBoxOrderNumberOrder = new JComboBox<String>();

		comboBoxOrderNumberOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxOrderNumberOrder.setBounds(900, 30, 250, 40);

		this.add(comboBoxOrderNumberOrder);
		comboBoxOrderNumberOrder.addItem("");
		orderList.forEach(o -> {
			comboBoxOrderNumberOrder.addItem(Integer.toString(o.getId()));
		});

		comboBoxOrderNumberOrder.setSelectedIndex(0);

		comboBoxProviderOrder = new JComboBox();
		comboBoxProviderOrder.setBounds(100, 200, 300, 40);
		comboBoxProviderOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		this.add(comboBoxProviderOrder);
		refreshProvider();

		comboBoxArticleOrder = new JComboBox();
		comboBoxArticleOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxArticleOrder.setBounds(50, 450, 250, 40);
		this.add(comboBoxArticleOrder);

		textFieldQtyOrder = new JTextField();
		textFieldQtyOrder.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char testChar = e.getKeyChar();
				if (!(Character.isDigit(testChar))) {
					e.consume();
				}
			}
		});
		textFieldQtyOrder.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldQtyOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldQtyOrder.setBounds(350, 450, 100, 40);
		this.add(textFieldQtyOrder);
		textFieldQtyOrder.setColumns(10);

		JScrollPane scrollPaneOrder = new JScrollPane();
		scrollPaneOrder.setBounds(500, 90, 850, 550);
		this.add(scrollPaneOrder);

		tableOrder = new JTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		scrollPaneOrder.setViewportView(tableOrder);

		modelOrder = new DefaultTableModel(new Object[][] {,},
				new String[] { "Identifiant", "Article", "Quantite Commande", "Prix €" });

		tableOrder.setModel(modelOrder);
		tableOrder.getColumnModel().getColumn(0).setResizable(false);
		tableOrder.getColumnModel().getColumn(1).setResizable(false);
		tableOrder.getColumnModel().getColumn(2).setResizable(false);
		tableOrder.getColumnModel().getColumn(3).setResizable(false);
		scrollPaneOrder.setViewportView(tableOrder);

		btnOrderOrder = new JButton("Commander");

		btnOrderOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnOrderOrder.setBounds(1200, 670, 150, 40);
		this.add(btnOrderOrder);

		textFieldTotalPrice = new JTextField();
		textFieldTotalPrice.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldTotalPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldTotalPrice.setBounds(1050, 670, 100, 40);
		this.add(textFieldTotalPrice);
		textFieldTotalPrice.setColumns(10);
		textFieldTotalPrice.setEditable(false);

		JLabel lblTotalPriceOrder = new JLabel("Montant Total");
		lblTotalPriceOrder.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalPriceOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTotalPriceOrder.setBounds(900, 670, 150, 40);
		this.add(lblTotalPriceOrder);

		btnAddOrder = new JButton("Ajouter");

		btnAddOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));

		btnAddOrder.setBounds(35, 600, 120, 40);
		this.add(btnAddOrder);

		btnUpdateOrder = new JButton("Modifier");


		btnUpdateOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdateOrder.setBounds(190, 600, 120, 40);
		this.add(btnUpdateOrder);

		btnDeleteOrder = new JButton("Supprimer");

		btnDeleteOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDeleteOrder.setBounds(345, 600, 120, 40);
		this.add(btnDeleteOrder);

		setUpListener();
	}

	
	/**
	 * this function allows you to add an event listener 
	 * on all the elements on which you want to put an event
	 */
	public void setUpListener() {
		
		btnDeleteOrder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				var qty = textFieldQtyOrder.getText().isEmpty();

				if (!tableOrder.getSelectionModel().isSelectionEmpty()) {
					int p = JOptionPane.showConfirmDialog(null,
							"Voulez vous vraiment supprimer cettligne de commande ?", "Confirmation",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

					if (p == 0) {
						int row = tableOrder.getSelectedRow();
						OrderLine orderLine = new OrderLine();
						orderLine.setIdArticle(Integer.parseInt(tableOrder.getValueAt(row, 0).toString()));
						orderLine.setIdOrders(
								Integer.parseInt(comboBoxOrderNumberOrder.getSelectedItem().toString()));
						orderLine.delete();
						refreshTable();
						JOptionPane.showInternalMessageDialog(null, "Supprimer avec succes", "Succès", JOptionPane.INFORMATION_MESSAGE);
					}
					textFieldQtyOrder.setText("");
				} else {
					JOptionPane.showInternalMessageDialog(null, "Veuillez d'abord sélectionner une ligne de commande", "Sélection incorrecte", JOptionPane.INFORMATION_MESSAGE);
					
					
				}
			}
		});

		
		btnOrderOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxOrderNumberOrder.getSelectedIndex() != 0) {
					var order = new Order();
					order.setId(Integer.parseInt(comboBoxOrderNumberOrder.getSelectedItem().toString()));
					order.setState("a");

					try {
						(new OrderDAO()).update(order);
						refreshProvider();

					} catch (SQLException e1) {
						e1.printStackTrace();
					}

				}
			}
		});

		btnUpdateOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!tableOrder.getSelectionModel().isSelectionEmpty()) {
					var qty = textFieldQtyOrder.getText().isEmpty();

					if (qty == false) {

						int row = tableOrder.getSelectedRow();
						var orderLine = new OrderLine();
						orderLine.setIdArticle(
								Integer.parseInt(Integer.toString((Integer) tableOrder.getValueAt(row, 0))));
						orderLine.setIdOrders(Integer.parseInt(comboBoxOrderNumberOrder.getSelectedItem().toString()));
						orderLine.setAmount(Integer.parseInt(textFieldQtyOrder.getText()));

						orderLine.update();

						textFieldQtyOrder.setText("");
						refreshTable();
					} else {
						JOptionPane.showInternalMessageDialog(null, "Tous les champs ne sont pas remplis.","Champs vide", JOptionPane.INFORMATION_MESSAGE);
					}

				} else {
					JOptionPane.showInternalMessageDialog(null, "Veuillez d'abord sélectionner une ligne de commande", "Sélection incorrecte", JOptionPane.INFORMATION_MESSAGE);
					
					
				}
			}
		});

		btnAddOrder.addActionListener(arg0 -> {

			var qty = textFieldQtyOrder.getText().isEmpty();

			if (qty == false) {

				order = new Order();

				var orderLine = new OrderLine();
				var adminId = Integer.parseInt(AppSettings.get("loginUser"));
				var admin = (new AdministratorDAO()).find("idAdministrator", adminId);

				java.util.Date sqlDate = new java.util.Date();
				Date orderDate = new Date(sqlDate.getTime());

				order.setOrderDate(orderDate);
				order.setIdAdministrator(adminId);
				order.setProviderFromName(comboBoxProviderOrder.getSelectedItem().toString());
				order.setState("w");
				var article = comboBoxArticleOrder.getSelectedItem().toString().split(" - ");

				if (comboBoxOrderNumberOrder.getSelectedItem().toString().isEmpty()) {
					admin.createOrder(order);
					var orderLis = (new OrderDAO()).getActiveOrders();

					comboBoxOrderNumberOrder.removeAllItems();
					comboBoxOrderNumberOrder.addItem("");
					orderLis.forEach(o -> {
						comboBoxOrderNumberOrder.addItem(Integer.toString(o.getId()));
					});
					comboBoxOrderNumberOrder.setSelectedItem(Integer.toString(order.getId()));

				} 

				// verifier si la ligne de commande existe deja pour cette commande
				System.out.println(Integer.parseInt(article[0]));
				orderLine.setIdArticle(Integer.parseInt(article[0]));
				orderLine.setIdOrders(Integer.parseInt(comboBoxOrderNumberOrder.getSelectedItem().toString()));
				orderLine.setAmount(Integer.parseInt(textFieldQtyOrder.getText()));

				var line = (new OrderLineDAO()).findOrderLineByOrderAndArticle(orderLine);
				if(line == null) {

					orderLine.create();
				}else {
					JOptionPane.showInternalMessageDialog(this, "Cette article a deja été ajouter a cette commande","Duplication impossible", JOptionPane.INFORMATION_MESSAGE );
				}

				refreshTable();
				textFieldQtyOrder.setText("");
			} else {
				JOptionPane.showMessageDialog(null, "Tous les champs ne sont pas remplis.","Champs vide", JOptionPane.INFORMATION_MESSAGE);
			}

		});

		comboBoxProviderOrder.addActionListener(e -> {
			if (comboBoxProviderOrder.getSelectedItem() != null) {

				if (!comboBoxProviderOrder.getSelectedItem().toString().isEmpty()) {
					var orderLis = (new OrderDAO()).getActiveOrders();

					var provider = (new ProviderDAO()).find("compagnyName",
							comboBoxProviderOrder.getSelectedItem().toString());

					var t = comboBoxOrderNumberOrder.getSelectedItem().toString();
					comboBoxOrderNumberOrder.removeAllItems();
					comboBoxOrderNumberOrder.addItem("");

					orderLis.forEach(o -> {

						if (o.getIdProvider() == provider.getId()) {
							comboBoxOrderNumberOrder.addItem(Integer.toString(o.getId()));
						}

					});

					comboBoxOrderNumberOrder.setSelectedItem(t);

				} else {

					var orderLis = (new OrderDAO()).getActiveOrders();

					comboBoxOrderNumberOrder.removeAllItems();
					comboBoxOrderNumberOrder.addItem("");
					orderLis.forEach(o -> {
						comboBoxOrderNumberOrder.addItem(Integer.toString(o.getId()));
					});

				}
				refreshArticle();
			}

		});

		comboBoxOrderNumberOrder.addActionListener(new OrderNumberListener(this));


		tableOrder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (!tableOrder.getSelectionModel().isSelectionEmpty()) {
					int row = tableOrder.getSelectedRow();

					comboBoxArticleOrder.setSelectedItem((Integer.toString((Integer) tableOrder.getValueAt(row, 0)))
							+ " - " + (tableOrder.getValueAt(row, 1).toString()));
					textFieldQtyOrder.setText(tableOrder.getValueAt(row, 2).toString());

				}
			}
		});
		
	}
	/**
	 * @return the comboBoxOrderNumberOrder
	 */
	public JComboBox<String> getComboBoxOrderNumberOrder() {
		return comboBoxOrderNumberOrder;
	}

	/**
	 * @return the modelOrder
	 */
	public DefaultTableModel getModelOrder() {
		return modelOrder;
	}

	public void updateTotalPrice() {
		System.out.println(modelOrder.getRowCount());
		var totalPrice = 0.0;
		for (int i = 0; i < modelOrder.getRowCount(); i++) {

			totalPrice += (Double) modelOrder.getValueAt(i, 3);
		}

		textFieldTotalPrice.setText(Double.toString(totalPrice) + " €");
	}
}
