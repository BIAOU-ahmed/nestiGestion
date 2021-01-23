package component;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
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
import dao.ProductDAO;
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

public class ArticlePanel extends Tab{
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

	/**
	 * Create the panel.
	 */
	public ArticlePanel(Management c) {
		mainController = c;
//		comboBoxProductArticle = comboBoxProductArticles;
//		tabbedPane.addTab("Gestion Article", null, this, null);
		this.setLayout(null);

		refreshTab();


		
		
	

		Useful.sort(articleModel, tableArticle);
	}

	public void refreshTable() {
		List<Article> updateProducts = (new ArticleDAO()).findALL();//
		Useful.displayArticle(updateProducts, articleModel);
	}

	public void refreshProduct() {
		var productList = (new ProductDAO()).findALL();//
		comboBoxProductArticle.removeAllItems();
		productList.forEach(p -> {

			comboBoxProductArticle.addItem(p.getProductName());

		});
	}

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

	@Override
	public void refreshTab() {
		// TODO Auto-generated method stub
		super.refreshTab();
		
		JLabel lblSearchArticle = new JLabel("Rechercher");
		lblSearchArticle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblSearchArticle.setBounds(947, 23, 120, 29);
		this.add(lblSearchArticle);

		JTextField textFieldSearchArticle = new JTextField();
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
//		scrollPane.setViewportView(table);
//		scrollPane.setColumnHeaderView(table);

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
//		btnEditArticle.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				var qty = textFieldQtyArticle.getText().isEmpty();
//				var weight = textFieldWeightArticle.getText().isEmpty();
//
//				if (qty == false && weight == false) {
//					textFieldQtyArticle.setText("");
//					textFieldWeightArticle.setText("");
//				} else {
//					JOptionPane.showMessageDialog(null, "Tous les champs ne sont pas remplis.");
//				}
//			}
//		});
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

		DefaultTableModel providerListArticleModel = new DefaultTableModel(new Object[][] {,},
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
//		scrollPane.setViewportView(table);
//		scrollPane.setColumnHeaderView(table);

		btnOrderArticle = new JButton("Passer une commande");
		btnOrderArticle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnOrderArticle.setBounds(214, 687, 203, 35);

		refreshConditioning();

//		var productList = (new ProductDAO()).findALL();//
		refreshProduct();
//		mainController.getPanelProduct().getProductList().getModel().addTableModelListener(e->refreshProduct(productList));

		refreshTable();
		setUpListener();
		
	}
	
	public void setUpListener() {
		
		textFieldWeightArticle.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char testChar = e.getKeyChar();
				if (!(Character.isDigit(testChar))) {
					e.consume();
				}
			}
		});
		
		textFieldQtyArticle.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char testChar = e.getKeyChar();
				if (!(Character.isDigit(testChar))) {
					e.consume();
				}
			}
		});
		
		tableArticle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				System.out.println("testttt");
				if (!tableArticle.getSelectionModel().isSelectionEmpty()) {
					int row = tableArticle.getSelectedRow();

					comboBoxStatutArticle.setSelectedItem((String) tableArticle.getValueAt(row, 7));
//					textFieldWeightArticle.setText((String) articleModel.getValueAt(row, 4));
					comboBoxProductArticle.setSelectedItem((String) tableArticle.getValueAt(row, 1));

					comboBoxConditioningArticle.setSelectedItem((String) tableArticle.getValueAt(row, 3));
					textFieldQtyArticle.setText(Integer.toString((Integer) tableArticle.getValueAt(row, 2)));
					textFieldWeightArticle.setText(Double.toString((Double) tableArticle.getValueAt(row, 4)));

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
						System.out.println("art " + ((Integer) tableArticle.getValueAt(row, 0)));
						if (comboBoxStatutArticle.getSelectedItem().toString().equals("Retiré")) {
							state = "w";
						}
						
						article.setId((Integer) tableArticle.getValueAt(row, 0));
						article.setWeight(Double.parseDouble(textFieldWeightArticle.getText()));
						article.setAmount(Integer.parseInt(textFieldQtyArticle.getText()));
						article.setArticleState(state);

						article.setProductFromName(comboBoxProductArticle.getSelectedItem().toString());
						article.setConditioningFromName(comboBoxConditioningArticle.getSelectedItem().toString());
						admin.updateArticle(article);

						// vider les champ apres modification
						refreshTable();
						
						textFieldQtyArticle.setText("");
						textFieldWeightArticle.setText("");
					} else {
						JOptionPane.showMessageDialog(null, "Tous les champs ne sont pas remplis.");
					}
					
					
				}
			}
		});
		
		
		btnAddArticle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				var qty = textFieldQtyArticle.getText().isEmpty();
				var weight = textFieldWeightArticle.getText().isEmpty();

				if (qty == false && weight == false) {
					textFieldQtyArticle.setText("");
					textFieldWeightArticle.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "Tous les champs ne sont pas remplis.");
				}
			}
		});
		btnAddArticle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Article article = new Article();
				var state = "a";
				var adminId = Integer.parseInt(AppSettings.get("loginUser"));
				var admin = (new AdministratorDAO()).find("idAdministrator", adminId);

				article.setWeight(Double.parseDouble(textFieldWeightArticle.getText()));
				article.setAmount(Integer.parseInt(textFieldQtyArticle.getText()));
				if (comboBoxStatutArticle.getSelectedItem().toString().equals("Retiré")) {
					state = "w";
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

			}
		});
		
		
	}
}
