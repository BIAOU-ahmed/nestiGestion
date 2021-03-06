package component;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.MeasurementDAO;
import dao.ProductDAO;
import dao.ProviderDAO;
import listener.AddProductListener;
import listener.ProductListListener;
import model.Measurement;
import model.Product;
import tools.Useful;
import view.Management;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ProductPanel extends Tab {

	protected JComboBox unityCombo;
	protected JTable productList;
	Management mainController;
	JButton creatArticlebtn;
	JComboBox comboBoxType;
	JButton btnAdd;
	JButton btnUpdate;
	JTextField textFieldProductName;
	JTextField textFieldSearch;
	protected DefaultTableModel productModel;

	/**
	 * @return the mainController
	 */

	public Management getMainController() {
		return mainController;
	}

	/**
	 * @param mainController the mainController to set
	 */
	public void setMainController(Management mainController) {
		this.mainController = mainController;
	}

	/**
	 * Create the panel.
	 * 
	 * @param mainController the management panel
	 */
	public ProductPanel(Management mainController) {
		this.mainController = mainController;
		setLayout(null);

		refreshTab();

	}

	/**
	 * refresh the measurement combo box
	 */
	public void refreshMeasurement() {
		var unitys = (new MeasurementDAO()).findALL();//
		unitys.forEach(m -> {
			unityCombo.addItem(m.getUnit());

		});
	}

	/**
	 * @return the productList
	 */
	public JTable getProductList() {
		return productList;
	}

	/**
	 * @param productList the productList to set
	 */
	public void setProductList(JTable productList) {
		this.productList = productList;
	}

	/**
	 * refresh products table
	 */
	public void refreshTable(List<Product> updateProducts) {
		Useful.display(updateProducts, productModel);
	}

	/**
	 * refresh products table
	 */
	public void refreshTableAll() {
		List<Product> updateProducts = (new ProductDAO()).findALL();//
		refreshTable(updateProducts);
	}

	@Override
	public void refreshTab() {
		super.refreshTab();

		textFieldSearch = new JTextField();

		textFieldSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldSearch.setBounds(809, 70, 571, 27);
		this.add(textFieldSearch);
		textFieldSearch.setColumns(10);

		JScrollPane scrollPaneProductList = new JScrollPane();

		scrollPaneProductList.setBounds(809, 132, 571, 492);

		this.add(scrollPaneProductList);

		DefaultTableModel model2 = new DefaultTableModel(new Object[][] {,}, new String[] { "Numéro commande",
				"Fournisseur", "Montant €", "Date commande", "Date livraison", "Statut" });

		this.add(scrollPaneProductList);

		productModel = new DefaultTableModel(new Object[][] {,},
				new String[] { "Identifiant", "Libellé", "Type", "Unité", "Nb d'articles créés" });
		productList = new JTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		productList.setModel(productModel);
		scrollPaneProductList.setViewportView(productList);
		var conbo = mainController.getPanelArticle().getComboBoxProductArticle();
		productModel.addTableModelListener(e -> {
			mainController.getPanelArticle().refreshProduct();
		});

		textFieldProductName = new JTextField();
		textFieldProductName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldProductName.setBounds(100, 200, 200, 40);
		this.add(textFieldProductName);
		textFieldProductName.setColumns(10);

		comboBoxType = new JComboBox();
		comboBoxType.setFont(new Font("Tahoma", Font.PLAIN, 16));
		DefaultComboBoxModel productType = new DefaultComboBoxModel(new String[] { "", "Ingredients", "Ustensils" });
		comboBoxType.setModel(productType);

		unityCombo = new JComboBox();
		unityCombo.setFont(new Font("Tahoma", Font.PLAIN, 16));

		comboBoxType.setBounds(350, 200, 150, 40);

		this.add(comboBoxType);

		unityCombo.setBounds(550, 200, 100, 40);
		this.add(unityCombo);

		btnAdd = new JButton("Ajouter");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAdd.addActionListener(new AddProductListener(textFieldProductName, comboBoxType, unityCombo, productModel));
		btnAdd.setBounds(206, 351, 104, 49);
		this.add(btnAdd);

		btnUpdate = new JButton("Modifier");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdate.setBounds(452, 351, 104, 49);
		this.add(btnUpdate);

		creatArticlebtn = new JButton("Créer un article à partir de ce produit");
		creatArticlebtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		creatArticlebtn.setBounds(206, 535, 350, 50);
		this.add(creatArticlebtn);

		JLabel lblNameProduct = new JLabel("Libell\u00E9");
		lblNameProduct.setHorizontalAlignment(SwingConstants.CENTER);
		lblNameProduct.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNameProduct.setBounds(100, 170, 200, 30);
		this.add(lblNameProduct);

		JLabel lblTypeProduct = new JLabel("Type");
		lblTypeProduct.setHorizontalAlignment(SwingConstants.CENTER);
		lblTypeProduct.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTypeProduct.setBounds(350, 170, 150, 30);
		this.add(lblTypeProduct);

		JLabel lblUnitProduct = new JLabel("Unit\u00E9");
		lblUnitProduct.setHorizontalAlignment(SwingConstants.CENTER);
		lblUnitProduct.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUnitProduct.setBounds(550, 170, 100, 30);
		this.add(lblUnitProduct);

		productList.addMouseListener(
				new ProductListListener(productModel, productList, textFieldProductName, comboBoxType, unityCombo));

		JLabel lblTitleProduct = new JLabel("Gestion des Produits");
		lblTitleProduct.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTitleProduct.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleProduct.setBounds(200, 70, 300, 50);
		add(lblTitleProduct);

		refreshTableAll();
		setUpListener();
	}

	/**
	 * this function allows you to add an event listener on all the elements on
	 * which you want to put an event
	 */
	public void setUpListener() {

		creatArticlebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!productList.getSelectionModel().isSelectionEmpty()) {

					int row = productList.getSelectedRow();
					String p = (String) productModel.getValueAt(row, 1);
					mainController.getTabbedPane().setSelectedIndex(3);
					mainController.getPanelArticle().getComboBoxProductArticle().setSelectedItem(p);

				} else {
					JOptionPane.showInternalMessageDialog(null, "Veuillez d'abord sélectionner un produit",
							"Sélection incorrecte", JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});

		comboBoxType.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (comboBoxType.getSelectedItem() == "Ingredients") {
					unityCombo.removeAllItems();
					refreshMeasurement();
					unityCombo.setEnabled(true);
				} else {
					unityCombo.removeAllItems();
					unityCombo.setEnabled(false);

				}

			}
		});

		textFieldSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				var list = (new ProductDAO()).findAllLike("productName ", textFieldSearch.getText());
				refreshTable(list);
			}
		});

		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (!productList.getSelectionModel().isSelectionEmpty()) {
					int row = productList.getSelectedRow();

					Product updateProduct = new Product();
					updateProduct.setId((Integer) productModel.getValueAt(row, 0));
					updateProduct.setProductName(textFieldProductName.getText());
					updateProduct.setType(comboBoxType.getSelectedItem().toString());
					updateProduct.update(unityCombo);
					List<Product> updateProducts = (new ProductDAO()).findALL();
					refreshTableAll();

					textFieldProductName.setText("");
					comboBoxType.setSelectedIndex(0);

				} else {
					JOptionPane.showInternalMessageDialog(null, "Veuillez d'abord sélectionner un produit",
							"Sélection incorrecte", JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});

	}
}
