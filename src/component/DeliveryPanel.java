package component;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import dao.ArticleDAO;
import dao.OrderDAO;
import dao.OrderLineDAO;
import dao.ProductDAO;
import dao.ProviderDAO;
import model.OrderLine;
import tools.Useful;
import view.Management;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class DeliveryPanel extends Tab {
	JComboBox comboBoxArticleDelivery;
	JComboBox comboBoxProviderDelivery;
	JComboBox comboBoxOrderNumberDelivery;
	JTextField textFieldAmountReceived;
	JTextField textFieldAmountExpected;
	JTextField textFieldDeliveryDate;
	JButton btnSaveDelivery;
	JButton btnDeleteDelivery;
	JTable tableDelivery;
	DefaultTableModel modelDelivery;

	/**
	 * Create the panel.
	 */
	public DeliveryPanel(Management c) {

		this.setLayout(null);
		refreshTab();

	}

	/**
	 * refresh the selectable list of provider
	 */
	public void refreshProvider() {

		var provider = (new ProviderDAO()).findALLBy("providerState", "a");//
		comboBoxProviderDelivery.removeAllItems();
		comboBoxProviderDelivery.addItem("");
		provider.forEach(p -> {
			if (p.haveOrderStanding()) {
				comboBoxProviderDelivery.addItem(p.getCompanyName());
			}

		});

	}

	/**
	 * refresh the order lines table of a order 
	 */
	public void refreshTable() {
		if (comboBoxOrderNumberDelivery.getSelectedItem() != null) {
			if (!comboBoxOrderNumberDelivery.getSelectedItem().toString().isEmpty()) {
				List<OrderLine> updateLine = (new OrderLineDAO()).findALLBy("idOrders",
						Integer.parseInt(comboBoxOrderNumberDelivery.getSelectedItem().toString()));
				modelDelivery.setRowCount(0);
				updateLine.forEach(s -> {
//					if (s.getDeliveryDate() == null) {

					Object[] row1 = s.toRowForDelevery();
					// Ajout d'une rang�e
					modelDelivery.addRow(row1);

//					}

				});

			}
		} else {
			modelDelivery.setRowCount(0);
			textFieldAmountReceived.setText("");
		}

	}

	/**
	 * refresh article combobox
	 */
	public void refreshArticle() {
		List<OrderLine> updateLine = (new OrderLineDAO()).findALLBy("idOrders",
				Integer.parseInt(comboBoxOrderNumberDelivery.getSelectedItem().toString()));//
		comboBoxArticleDelivery.removeAllItems();
		System.out.println("in refresh article box");
		updateLine.forEach(ol -> {
			comboBoxArticleDelivery.addItem(
					ol.getArticle().getId() + " - " + ol.getArticle().getConditioning().getConditioningName() + " de "
							+ ol.getArticle().getAmount() + " " + ol.getArticle().getProduct().getProductName());
		});

	}

	/**
	 * format the date entered by the user in the correct format
	 * @param dateSize
	 * @return formated date
	 */
	private String formatDeliveryDate(String dateSize) {
		String result = "";
		int i = 0;
		for (char c : dateSize.toCharArray()) {

			if (Character.isDigit(c)) {
				if (i % 2 == 0 && i != 0) {
					result += "/";
				}
				result += c;
				i++;
			}
		}
		return result;
	}

	/**
	 *  this function allows to refresh all the elements of the tab so that
	 *  in the event of change in the data base on another tab one can 
	 *  recover the data on the current tab
	 */
	@Override
	public void refreshTab() {
		super.refreshTab();
		var orderList = (new OrderDAO()).findALLBy("state", "a");

		JLabel lblTitleDelivery = new JLabel("R\u00E9ception des Articles");
		lblTitleDelivery.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTitleDelivery.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleDelivery.setBounds(0, 50, 500, 70);
		this.add(lblTitleDelivery);

		comboBoxArticleDelivery = new JComboBox();
		comboBoxArticleDelivery.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxArticleDelivery.setBounds(25, 320, 250, 40);
		this.add(comboBoxArticleDelivery);
//		refreshArticle();

		comboBoxOrderNumberDelivery = new JComboBox();
		comboBoxOrderNumberDelivery.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxOrderNumberDelivery.setBounds(900, 30, 250, 40);
		this.add(comboBoxOrderNumberDelivery);

		textFieldAmountReceived = new JTextField();

		textFieldAmountReceived.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldAmountReceived.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldAmountReceived.setBounds(325, 320, 75, 40);
		this.add(textFieldAmountReceived);
		textFieldAmountReceived.setColumns(10);

		textFieldAmountExpected = new JTextField();

		textFieldAmountExpected.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldAmountExpected.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldAmountExpected.setBounds(400, 320, 75, 40);
		this.add(textFieldAmountExpected);
		textFieldAmountExpected.setColumns(10);
		textFieldAmountExpected.setEditable(false);

		textFieldDeliveryDate = new JTextField();

		textFieldDeliveryDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldDeliveryDate.setBounds(150, 470, 200, 40);
		this.add(textFieldDeliveryDate);
		textFieldDeliveryDate.setColumns(10);

		btnSaveDelivery = new JButton("Enregistrer");

		btnSaveDelivery.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSaveDelivery.setBounds(75, 600, 150, 40);
		this.add(btnSaveDelivery);

		btnDeleteDelivery = new JButton("Supprimer");

		btnDeleteDelivery.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDeleteDelivery.setBounds(275, 600, 150, 40);
		this.add(btnDeleteDelivery);

		JLabel lblProviderDelivery = new JLabel("Fournisseur");
		lblProviderDelivery.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblProviderDelivery.setHorizontalAlignment(SwingConstants.CENTER);
		lblProviderDelivery.setBounds(100, 180, 300, 20);
		this.add(lblProviderDelivery);

		JLabel lblArticleDelivery = new JLabel("Article");
		lblArticleDelivery.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblArticleDelivery.setHorizontalAlignment(SwingConstants.CENTER);
		lblArticleDelivery.setBounds(25, 300, 250, 20);
		this.add(lblArticleDelivery);

		JLabel lblAmountDelivery = new JLabel("Quantit\u00E9 re\u00E7ue/Command\u00E9e");
		lblAmountDelivery.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmountDelivery.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAmountDelivery.setBounds(300, 300, 200, 14);
		this.add(lblAmountDelivery);

		JLabel lblDeliveryDate = new JLabel("Date de livraison");
		lblDeliveryDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDeliveryDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeliveryDate.setBounds(150, 450, 200, 20);
		this.add(lblDeliveryDate);

		JLabel lblOrderNumberDelivery = new JLabel("Num\u00E9ro de la commande");
		lblOrderNumberDelivery.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOrderNumberDelivery.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrderNumberDelivery.setBounds(700, 30, 200, 40);
		this.add(lblOrderNumberDelivery);

		JScrollPane scrollPaneDelivery = new JScrollPane();
		scrollPaneDelivery.setBounds(500, 90, 850, 600);
		this.add(scrollPaneDelivery);

		tableDelivery = new JTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		scrollPaneDelivery.setViewportView(tableDelivery);

		modelDelivery = new DefaultTableModel(new Object[][] {,}, new String[] { "Identifiant", "Article",
				"Qté Commandée", "Qté reçue", "Prix €", "Date commande", "Date livraison" });

		tableDelivery.setModel(modelDelivery);
		tableDelivery.getColumnModel().getColumn(0).setResizable(false);
		tableDelivery.getColumnModel().getColumn(1).setResizable(false);
		tableDelivery.getColumnModel().getColumn(2).setResizable(false);
		tableDelivery.getColumnModel().getColumn(3).setResizable(false);
		tableDelivery.getColumnModel().getColumn(4).setResizable(false);
		tableDelivery.getColumnModel().getColumn(5).setResizable(false);
		tableDelivery.getColumnModel().getColumn(6).setResizable(false);
		scrollPaneDelivery.setViewportView(tableDelivery);

		comboBoxProviderDelivery = new JComboBox();
		comboBoxProviderDelivery.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxProviderDelivery.setBounds(100, 200, 300, 40);
		this.add(comboBoxProviderDelivery);
		refreshProvider();
		comboBoxOrderNumberDelivery.addItem("");
		DateFormat format = new SimpleDateFormat("yyyy--MMMM--dd");

		orderList.forEach(o -> {
			if (o.getDisplayState().equals("En cours")) {
				comboBoxOrderNumberDelivery.addItem(Integer.toString(o.getId()));
			}

		});

		setUpListener();
	}

	/**
	 * this function allows you to add an event listener 
	 * on all the elements on which you want to put an event
	 */
	public void setUpListener() {

		textFieldAmountReceived.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char testChar = e.getKeyChar();
				if (!(Character.isDigit(testChar))) {
					e.consume();
				}
			}
		});

		comboBoxOrderNumberDelivery.addActionListener(e -> {
			if (comboBoxProviderDelivery.getSelectedItem() != null) {

				if (getComboBoxProviderDelivery().getSelectedItem().toString().isEmpty()) {
					if (getComboBoxOrderNumberDelivery().getSelectedItem() != null) {

						if (!getComboBoxOrderNumberDelivery().getSelectedItem().toString().isEmpty()) {
							var order = (new OrderDAO()).find("idOrders",
									getComboBoxOrderNumberDelivery().getSelectedItem().toString());
//							System.out.println("order number act");
							
							getComboBoxProviderDelivery().setSelectedItem(order.getProvider().getCompanyName());

						} else {

							getComboBoxProviderDelivery().setSelectedIndex(0);

						}
						
						
					}
					
				}
					if(getComboBoxOrderNumberDelivery().getSelectedItem() != null) {
						if (!getComboBoxOrderNumberDelivery().getSelectedItem().toString().isEmpty()) {
							refreshArticle();
						}else {
							comboBoxArticleDelivery.removeAllItems();
						}
						
					}
				
				
				refreshTable();
			}

		});

		comboBoxProviderDelivery.addActionListener(e -> {
			if (comboBoxProviderDelivery.getSelectedItem() != null) {

				if (!comboBoxProviderDelivery.getSelectedItem().toString().isEmpty()) {
					var orderLis = (new OrderDAO()).findALLBy("state", "a");

					var provider = (new ProviderDAO()).find("compagnyName",
							comboBoxProviderDelivery.getSelectedItem().toString());
					System.out.println("test " + comboBoxProviderDelivery.getSelectedItem().toString());
					var t = comboBoxOrderNumberDelivery.getSelectedItem().toString();
					comboBoxOrderNumberDelivery.removeAllItems();
					comboBoxOrderNumberDelivery.addItem("");

					orderLis.forEach(o -> {

						if (o.getIdProvider() == provider.getId() && o.getDisplayState().equals("En cours")) {
							comboBoxOrderNumberDelivery.addItem(Integer.toString(o.getId()));
						}

					});
//						textFieldQtyOrder.setText("");
					comboBoxOrderNumberDelivery.setSelectedItem(t);

				} else {

					var orderLis = (new OrderDAO()).findALLBy("state", "a");

					comboBoxOrderNumberDelivery.removeAllItems();
					comboBoxOrderNumberDelivery.addItem("");
					orderLis.forEach(o -> {
						if (o.getDisplayState().equals("En cours")) {
							comboBoxOrderNumberDelivery.addItem(Integer.toString(o.getId()));
						}

					});

				}
//				refreshArticle();
			}

		});

		tableDelivery.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				System.out.println("testttt");
				if (!tableDelivery.getSelectionModel().isSelectionEmpty()) {
					int row = tableDelivery.getSelectedRow();
//					(Integer.toString((Integer)modelOrder.getValueAt(row, 0))
					comboBoxArticleDelivery
							.setSelectedItem((Integer.toString((Integer) tableDelivery.getValueAt(row, 0))) + " - "
									+ (tableDelivery.getValueAt(row, 1).toString()));
					textFieldAmountReceived.setText(tableDelivery.getValueAt(row, 3).toString());
					textFieldAmountExpected.setText(tableDelivery.getValueAt(row, 2).toString());
					java.util.Date date = null;
					var dateDelevery = "";
					if (tableDelivery.getValueAt(row, 6) != null) {
						try {
							date = new SimpleDateFormat("dd/MM/yyyy")
									.parse(tableDelivery.getValueAt(row, 6).toString());
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
						DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
						dateDelevery = formatter.format(date);

					}
					textFieldDeliveryDate.setText(dateDelevery);

				}
			}
		});

		btnSaveDelivery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				var amount = textFieldAmountReceived.getText().isEmpty();
				var date = textFieldDeliveryDate.getText().isEmpty();

				if (!tableDelivery.getSelectionModel().isSelectionEmpty()) {
					var receivedAmountIsCorect = (Integer.parseInt(textFieldAmountReceived.getText()) <= Integer
							.parseInt(textFieldAmountExpected.getText()));
//					System.out.println("delevery panel amout not upper " + receivedAmountIsCorect);
					if (amount == false && date == false && receivedAmountIsCorect) {

						int row = tableDelivery.getSelectedRow();
						OrderLine orderLine = new OrderLine();
						orderLine.setIdArticle(Integer.parseInt(tableDelivery.getValueAt(row, 0).toString()));
						orderLine.setIdOrders(
								Integer.parseInt(comboBoxOrderNumberDelivery.getSelectedItem().toString()));
						orderLine.setAmount(Integer.parseInt(tableDelivery.getValueAt(row, 2).toString()));
						orderLine.setAmountReceive(Integer.parseInt(textFieldAmountReceived.getText()));
//						  Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1); 
						java.util.Date sqlDate = null;
						try {
							sqlDate = new SimpleDateFormat("dd/MM/yy").parse(textFieldDeliveryDate.getText());
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
						Date createDate = new Date(sqlDate.getTime());

						orderLine.setDeliveryDate(createDate);
						orderLine.update();
						refreshTable();
						textFieldAmountReceived.setText("");
						textFieldDeliveryDate.setText("");
						textFieldAmountExpected.setText("");
					} else {
						JOptionPane.showMessageDialog(null, "Tous les champs ne sont pas remplis.");
					}
				}
			}
		});

		btnDeleteDelivery.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				var amount = textFieldAmountReceived.getText().isEmpty();
				var date = textFieldDeliveryDate.getText().isEmpty();

				if (amount == false && date == false) {

					textFieldAmountReceived.setText("");
					textFieldDeliveryDate.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "Tous les champs ne sont pas remplis.");

				}
			}
		});

		textFieldDeliveryDate.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() != KeyEvent.VK_BACK_SPACE || e.getKeyCode() != KeyEvent.VK_DELETE) {
					var dateSize = textFieldDeliveryDate.getText();
					var dateFormat = formatDeliveryDate(dateSize);
					textFieldDeliveryDate.setText(dateFormat);
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				char testChar = e.getKeyChar();
				if (!(Character.isDigit(testChar)) || (textFieldDeliveryDate.getText().length() >= 8)) {
					e.consume();
				}
			}
		});

		textFieldAmountExpected.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char testChar = e.getKeyChar();
				if (!(Character.isDigit(testChar))) {
					e.consume();
				}
			}
		});
	}

	/**
	 * @return the comboBoxArticleDelivery
	 */
	public JComboBox getComboBoxArticleDelivery() {
		return comboBoxArticleDelivery;
	}

	/**
	 * @return the comboBoxProviderDelivery
	 */
	public JComboBox getComboBoxProviderDelivery() {
		return comboBoxProviderDelivery;
	}

	/**
	 * @return the comboBoxOrderNumberDelivery
	 */
	public JComboBox getComboBoxOrderNumberDelivery() {
		return comboBoxOrderNumberDelivery;
	}
}
