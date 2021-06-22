package component;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.AdministratorDAO;
import dao.ArticleDAO;
import dao.ConditioningDAO;
import dao.MeasurementDAO;
import dao.OrderDAO;
import dao.ProductDAO;
import dao.SellDAO;
import model.Article;
import model.Conditioning;
import model.Measurement;
import model.Product;
import tools.AppSettings;
import tools.Useful;
import view.Management;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ArticlePanel extends Tab {
	protected JComboBox comboBoxProductArticle;
	protected JComboBox comboBoxConditioningArticle;
	Management mainController;
	protected DefaultTableModel articleModel;
	JTable tableArticle;
	JTextField textFieldWeightArticle;
	JTextField textFieldQtyArticle;
	JButton btnAddArticle;
	JButton btnEditArticle;
	JTable tableProviderListArticle;
	JButton btnOrdering;
	JButton btnOrderArticle;
	JComboBox<String> comboBoxStatutArticle;
	DefaultTableModel providerListArticleModel;

	JTextField textFieldSearchArticle;

	/**
	 * Create the panel.
	 * 
	 * @param c the management panel
	 */
	public ArticlePanel(Management c) {
		mainController = c;
		this.setLayout(null);

		refreshTab();

	}

	/**
	 * refresh the article list table
	 * 
	 * @param articles array of articles
	 */
	public void refreshTable(List<Article> articles) {
		articleModel.setRowCount(0);
		articles.forEach(p -> {

			Object[] row1 = p.toRow();
			// Ajout d'une rang�e
			articleModel.addRow(row1);

		});

	}

	/**
	 * refresh the selectable list of products
	 */
	public void refreshProduct() {
		var productList = (new ProductDAO()).findALL();//
		comboBoxProductArticle.removeAllItems();
		productList.forEach(p -> {

			comboBoxProductArticle.addItem(p.getProductName());

		});
	}

	/**
	 * refresh the selectable list of conditions
	 */
	public void refreshConditioning() {
		var conditioning = (new ConditioningDAO()).findALL();//
		comboBoxConditioningArticle.removeAllItems();
		conditioning.forEach(condi -> {

			comboBoxConditioningArticle.addItem(condi.getConditioningName());

		});
	}

	/**
	 * @return the comboBoxProductArticle
	 */
	public JComboBox getComboBoxProductArticle() {
		return comboBoxProductArticle;
	}

	/**
	 * @param comboBoxProductArticle the comboBoxProductArticle to set
	 */
	public void setComboBoxProductArticle(JComboBox comboBoxProductArticle) {
		this.comboBoxProductArticle = comboBoxProductArticle;
	}

	/**
	 * this function allows to refresh all the elements of the tab so that in the
	 * event of change in the data base on another tab one can recover the data on
	 * the current tab
	 */
	@Override
	public void refreshTab() {
		super.refreshTab();

		JLabel lblSearchArticle = new JLabel("Rechercher");
		lblSearchArticle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblSearchArticle.setBounds(947, 23, 120, 29);
		this.add(lblSearchArticle);

		textFieldSearchArticle = new JTextField();
		textFieldSearchArticle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldSearchArticle.setBounds(643, 63, 726, 40);
		this.add(textFieldSearchArticle);
		textFieldSearchArticle.setColumns(10);

		JScrollPane scrollPaneArticle = new JScrollPane();
		scrollPaneArticle.setBounds(643, 142, 726, 560);
		this.add(scrollPaneArticle);

		tableArticle = new JTable() {

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tableArticle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPaneArticle.setViewportView(tableArticle);

		articleModel = new DefaultTableModel(new Object[][] {,}, new String[] { "Identifiant", "Produit", "Quantité",
				"Conditionnement", "Poids", "Prix €", "En Stock", "Statut" });

		tableArticle.setModel(articleModel);
		tableArticle.getColumnModel().getColumn(0).setResizable(false);
		tableArticle.getColumnModel().getColumn(1).setResizable(false);
		tableArticle.getColumnModel().getColumn(2).setResizable(false);
		tableArticle.getColumnModel().getColumn(3).setResizable(false);
		tableArticle.getColumnModel().getColumn(4).setResizable(false);
		tableArticle.getColumnModel().getColumn(5).setResizable(false);
		tableArticle.getColumnModel().getColumn(6).setResizable(false);
		tableArticle.getColumnModel().getColumn(7).setResizable(false);

		JLabel lblWeightArticle = new JLabel("Poids");
		lblWeightArticle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblWeightArticle.setBounds(291, 189, 46, 14);
		this.add(lblWeightArticle);

		JLabel lblQtyArticle = new JLabel("Quantité");
		lblQtyArticle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQtyArticle.setBounds(87, 189, 64, 14);
		this.add(lblQtyArticle);

		JLabel lblProductsArticle = new JLabel("Produits");
		lblProductsArticle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblProductsArticle.setBounds(118, 64, 64, 14);
		this.add(lblProductsArticle);

		JLabel lblConditioningArticle = new JLabel("Conditionnement");
		lblConditioningArticle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConditioningArticle.setBounds(422, 76, 126, 14);
		this.add(lblConditioningArticle);

		JLabel lblStatusArticle = new JLabel("Statut");
		lblStatusArticle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStatusArticle.setBounds(487, 189, 46, 14);
		this.add(lblStatusArticle);

		textFieldWeightArticle = new JTextField();

		textFieldWeightArticle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldWeightArticle.setBounds(246, 215, 131, 40);
		this.add(textFieldWeightArticle);
		textFieldWeightArticle.setColumns(10);

		textFieldQtyArticle = new JTextField();

		textFieldQtyArticle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldQtyArticle.setBounds(39, 214, 152, 40);
		this.add(textFieldQtyArticle);
		textFieldQtyArticle.setColumns(10);

		comboBoxProductArticle = new JComboBox<String>();
		comboBoxProductArticle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxProductArticle.setBounds(39, 103, 219, 40);
		this.add(comboBoxProductArticle);

		comboBoxConditioningArticle = new JComboBox();
		comboBoxConditioningArticle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxConditioningArticle.setBounds(381, 103, 200, 40);
		this.add(comboBoxConditioningArticle);

		comboBoxStatutArticle = new JComboBox<String>();
		DefaultComboBoxModel<String> articleStatutsModel = new DefaultComboBoxModel<String>(
				new String[] { "Disponible", "Brouillon", "Retiré" });
		comboBoxStatutArticle.setModel(articleStatutsModel);
		comboBoxStatutArticle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxStatutArticle.setBounds(436, 215, 145, 40);
		this.add(comboBoxStatutArticle);
		comboBoxStatutArticle.setSelectedIndex(1);

		btnAddArticle = new JButton("Ajouter");

		btnAddArticle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddArticle.setBounds(153, 286, 111, 40);
		this.add(btnAddArticle);

		btnEditArticle = new JButton("Modfifier");

		btnEditArticle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEditArticle.setBounds(349, 286, 111, 40);
		this.add(btnEditArticle);

		JLabel lblProviderListArticle = new JLabel("Liste Fournisseurs");
		lblProviderListArticle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblProviderListArticle.setBounds(200, 341, 191, 40);
		this.add(lblProviderListArticle);

		JScrollPane scrollPaneProviderListArticle = new JScrollPane();
		scrollPaneProviderListArticle.setBounds(39, 392, 544, 275);
		this.add(scrollPaneProviderListArticle);

		tableProviderListArticle = new JTable() {

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tableProviderListArticle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPaneProviderListArticle.setViewportView(tableProviderListArticle);

		providerListArticleModel = new DefaultTableModel(new Object[][] {,},
				new String[] { "Entreprise", "Qté commandée", "Qté reçue", "Stock", "Prix €" });

		tableProviderListArticle.setModel(providerListArticleModel);

		JLabel lblTitleArticle = new JLabel("Gestions des Articles");
		lblTitleArticle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleArticle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTitleArticle.setBounds(150, 10, 300, 50);
		add(lblTitleArticle);

		btnOrdering = new JButton("Passer une commande");

		btnOrdering.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnOrdering.setBounds(220, 680, 200, 40);
		add(btnOrdering);
		tableProviderListArticle.getColumnModel().getColumn(0).setResizable(false);
		tableProviderListArticle.getColumnModel().getColumn(1).setResizable(false);
		tableProviderListArticle.getColumnModel().getColumn(2).setResizable(false);
		tableProviderListArticle.getColumnModel().getColumn(3).setResizable(false);
		tableProviderListArticle.getColumnModel().getColumn(4).setResizable(false);

		setUpListener();
		refreshConditioning();

		refreshProduct();

		List<Article> productsList = (new ArticleDAO()).findALL();
		refreshTable(productsList);

		Useful.sort(articleModel, tableArticle);
	}

	/**
	 * this function allows you to add an event listener on all the elements on
	 * which you want to put an event
	 */
	public void setUpListener() {

		textFieldWeightArticle.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char testChar = e.getKeyChar();
				if (!(Character.isDigit(testChar))
						&& (!(testChar == '.') || textFieldWeightArticle.getText().indexOf(".") != -1)) {
					e.consume();
				}

			}
		});

		textFieldQtyArticle.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char testChar = e.getKeyChar();
				System.out.println();
				if (!(Character.isDigit(testChar))) {
					e.consume();
				}
			}
		});

		tableArticle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (!tableArticle.getSelectionModel().isSelectionEmpty()) {
					int row = tableArticle.getSelectedRow();

					if (tableArticle.getValueAt(row, 7).toString().equals("Brouillon")) {
						comboBoxStatutArticle.setSelectedItem((String) tableArticle.getValueAt(row, 7));

						comboBoxProductArticle.setSelectedItem((String) tableArticle.getValueAt(row, 1));

						comboBoxConditioningArticle.setSelectedItem((String) tableArticle.getValueAt(row, 3));
						textFieldQtyArticle.setText(Integer.toString((Integer) tableArticle.getValueAt(row, 2)));
						textFieldWeightArticle.setText(Double.toString((Double) tableArticle.getValueAt(row, 4)));
					}

					var listSell = (new SellDAO()).findALLBy("idArticle", (Integer) tableArticle.getValueAt(row, 0));

					providerListArticleModel.setRowCount(0);

					listSell.forEach(s -> {

						Object[] row1 = s.toRowForArticle();
						// Ajout d'une rang�e
						providerListArticleModel.addRow(row1);

					});

				}
			}
		});

		btnEditArticle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (!tableArticle.getSelectionModel().isSelectionEmpty()) {

					var qty = textFieldQtyArticle.getText().isEmpty();
					var weight = textFieldWeightArticle.getText().isEmpty();

					if (qty == false && weight == false) {
						int row = tableArticle.getSelectedRow();
						var state = "a";
						Article article = new Article();
						var adminId = Integer.parseInt(AppSettings.get("loginUser"));
						var admin = (new AdministratorDAO()).find("idAdministrator", adminId);

						if (comboBoxStatutArticle.getSelectedItem().toString().equals("Retiré")) {
							state = "b";
						}

						article.setId((Integer) tableArticle.getValueAt(row, 0));
						article.setWeight(Double.parseDouble(textFieldWeightArticle.getText()));
						article.setAmount(Integer.parseInt(textFieldQtyArticle.getText()));
						article.setArticleState(state);

						article.setProductFromName(comboBoxProductArticle.getSelectedItem().toString());
						article.setConditioningFromName(comboBoxConditioningArticle.getSelectedItem().toString());
						admin.updateArticle(article);

						// vider les champ apres modification
						List<Article> productsList = (new ArticleDAO()).findALL();
						refreshTable(productsList);

						textFieldQtyArticle.setText("");
						textFieldWeightArticle.setText("");
					} 

				}else {
					JOptionPane.showInternalMessageDialog(null,
							"Veuillez d'abord sélectionner une ligne de commande", "Sélection incorrecte",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		btnOrdering.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!tableProviderListArticle.getSelectionModel().isSelectionEmpty()
						&& !tableArticle.getSelectionModel().isSelectionEmpty()) {

					int row = tableArticle.getSelectedRow();

					String article = tableArticle.getValueAt(row, 0).toString() + " - "
							+ tableArticle.getValueAt(row, 3).toString() + " de "
							+ tableArticle.getValueAt(row, 2).toString() + " "
							+ tableArticle.getValueAt(row, 1).toString();

					int providerRow = tableProviderListArticle.getSelectedRow();
					mainController.getTabbedPane().setSelectedIndex(2);
					mainController.getPanelOrder().getComboBoxProviderOrder()
							.setSelectedItem(tableProviderListArticle.getValueAt(providerRow, 0));

					mainController.getPanelOrder().getComboBoxArticleOrder().setSelectedItem(article);

				} else {
					JOptionPane.showInternalMessageDialog(null,
							"Veuillez d'abord sélectionner une ligne de produit et de fournisseur",
							"Sélection incorrecte", JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});

		textFieldSearchArticle.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				List<Article> productsList = (new ArticleDAO()).findALL();
				var list = new ArrayList<Article>();
				productsList.forEach(a -> {
					var productName = a.getProduct().getProductName();
					if (productName.indexOf(textFieldSearchArticle.getText()) != -1) {
						list.add(a);
					}
				});

				refreshTable(list);

			}
		});

		btnAddArticle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				var qty = textFieldQtyArticle.getText().isEmpty();
				var weight = textFieldWeightArticle.getText().isEmpty();

				if (qty == false && weight == false) {

					Article article = new Article();
					var state = "a";
					var adminId = Integer.parseInt(AppSettings.get("loginUser"));
					var admin = (new AdministratorDAO()).find("idAdministrator", adminId);

					article.setWeight(Useful.parseDouble(Double.parseDouble(textFieldWeightArticle.getText()), 2));
					article.setAmount(Integer.parseInt(textFieldQtyArticle.getText()));
					if (comboBoxStatutArticle.getSelectedItem().toString().equals("Retiré")) {
						state = "b";

					}
					article.setArticleState(state);
					java.util.Date sqlDate = new java.util.Date();
					Date createDate = new Date(sqlDate.getTime());
					article.setCreatedAt(createDate);
					article.setIdAdministrator(adminId);
					article.setProductFromName(comboBoxProductArticle.getSelectedItem().toString());
					article.setConditioningFromName(comboBoxConditioningArticle.getSelectedItem().toString());
					admin.createArticle(article);

					List<Article> updateProducts = (new ArticleDAO()).findALL();//
					Useful.displayArticle(updateProducts, articleModel);

					textFieldQtyArticle.setText("");
					textFieldWeightArticle.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "Tous les champs ne sont pas remplis.", "Champs vide",
							JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});

	}
}
