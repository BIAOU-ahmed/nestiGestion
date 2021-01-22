package component;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import dao.AdministratorDAO;
import dao.ArticleDAO;
import dao.OrderDAO;
import dao.OrderLineDAO;
import dao.ProviderDAO;
import model.Order;
import model.OrderLine;
import model.Provider;
import tools.AppSettings;

import tools.Useful;
import view.Management;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class OrderPanel extends JPanel implements Activatable {

	Order order = null;
	JComboBox<String> comboBoxProviderOrder;
	JComboBox<String> comboBoxArticleOrder;

	/**
	 * Create the panel.
	 */
	public OrderPanel(Management c) {

		this.setLayout(null);

		var orderList = (new OrderDAO()).getActiveOrders();

//		if(orderList.size()==0) {
//			orderList.add(new Order()); 
//		}

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

		var comboBoxOrderNumberOrder = new JComboBox<String>();
		comboBoxOrderNumberOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxOrderNumberOrder.setBounds(900, 30, 250, 40);

		this.add(comboBoxOrderNumberOrder);
//		for (int i = 0; i < orderList.size(); i++) {
//			
//		}
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
		refreshArticle();

		JTextField textFieldQtyOrder = new JTextField();
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

		JTable tableOrder = new JTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		scrollPaneOrder.setViewportView(tableOrder);

		DefaultTableModel modelOrder = new DefaultTableModel(new Object[][] {,},
				new String[] { "Identifiant", "Produit", "Conditionnement", "Quantite Commande", "Prix €" });

		tableOrder.setModel(modelOrder);
		tableOrder.getColumnModel().getColumn(0).setResizable(false);
		tableOrder.getColumnModel().getColumn(1).setResizable(false);
		tableOrder.getColumnModel().getColumn(2).setResizable(false);
		tableOrder.getColumnModel().getColumn(3).setResizable(false);
		tableOrder.getColumnModel().getColumn(4).setResizable(false);
		scrollPaneOrder.setViewportView(tableOrder);

		JButton btnOrderOrder = new JButton("Commander");
		btnOrderOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnOrderOrder.setBounds(1200, 670, 150, 40);
		this.add(btnOrderOrder);

		JTextField textFieldTotalPrice = new JTextField();
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

		JButton btnAddOrder = new JButton("Ajouter");
		btnAddOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

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
			
//				var ordDAO = new OrderDAO();

				if (comboBoxOrderNumberOrder.getSelectedItem().toString().isEmpty()) {
//						ordDAO.insert(order);
					admin.createOrder(order);
					var orderLis = (new OrderDAO()).getActiveOrders();

					comboBoxOrderNumberOrder.removeAllItems();
					comboBoxOrderNumberOrder.addItem("");
					orderLis.forEach(o -> {
						comboBoxOrderNumberOrder.addItem(Integer.toString(o.getId()));
					});
					System.out.println("new order id " + order.getId());
					comboBoxOrderNumberOrder.setSelectedItem(Integer.toString(order.getId()));

				} else {
					System.out.println("toto " + comboBoxOrderNumberOrder.getSelectedItem().toString() + "toto");
				}
				
				//verifier si la ligne de commande existe deja pour cette commande
				System.out.println(Integer.parseInt(article[0]));
				orderLine.setIdArticle(Integer.parseInt(article[0]));
				orderLine.setIdOrders(Integer.parseInt(comboBoxOrderNumberOrder.getSelectedItem().toString()));
				orderLine.setAmount(Integer.parseInt(textFieldQtyOrder.getText()));
				orderLine.create();
				
				List<OrderLine> updateLine = (new OrderLineDAO()).findALLBy("idOrders", Integer.parseInt(comboBoxOrderNumberOrder.getSelectedItem().toString()));//
				Useful.displayOrderLine(updateLine, modelOrder);
			}
		});
		btnAddOrder.setBounds(35, 600, 120, 40);
		this.add(btnAddOrder);

		JButton btnUpdateOrder = new JButton("Modifier");
		btnUpdateOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdateOrder.setBounds(190, 600, 120, 40);
		this.add(btnUpdateOrder);

		JButton btnDeleteOrder = new JButton("Supprimer");
		btnDeleteOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDeleteOrder.setBounds(345, 600, 120, 40);
		this.add(btnDeleteOrder);

	}

	public void refreshProvider() {
		var provider = (new ProviderDAO()).findALL();//
		comboBoxProviderOrder.removeAllItems();
		provider.forEach(p -> {

			comboBoxProviderOrder.addItem(p.getCompanyName());

		});
	}

	public void refreshArticle() {
		var article = (new ArticleDAO()).findALL();//
		comboBoxArticleOrder.removeAllItems();
		article.forEach(a -> {

			comboBoxArticleOrder.addItem(a.getId() + " - " + a.getProduct().getProductName() + " "
					+ a.getConditioning().getConditioningName() + " " + a.getAmount());

		});
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
	public void onActivate() {
		// TODO Auto-generated method stub

	}

}
