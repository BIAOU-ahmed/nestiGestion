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
import listener.AddProductListener;
import listener.ProductListListener;
import model.Measurement;
import model.Product;
import tools.Useful;
import view.Management;

public class ProductPanel extends JPanel {

	protected JTable productList;
	Management mainController;

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
	 */
	public ProductPanel(Management mainController) {
		setLayout(null);

		JTextField textFieldSearch = new JTextField();
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

		DefaultTableModel productModel = new DefaultTableModel(new Object[][] {,},
				new String[] { "Identifiant", "Libellé", "Type", "Unité", "Nb d'articles créés" });
		productList = new JTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		productList.setModel(productModel);
		scrollPaneProductList.setViewportView(productList);
		var conbo = mainController.getPanelArticle().getComboBoxProductArticle();
//		productModel.addTableModelListener(e->refreshProduct(productList));
		productModel.addTableModelListener(e->{
				// mon code a executer quand table change
			mainController.getPanelArticle().refreshProduct();
		});

		JTextField textFieldProductName = new JTextField();
		textFieldProductName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldProductName.setBounds(95, 160, 185, 34);
		this.add(textFieldProductName);
		textFieldProductName.setColumns(10);

		JComboBox typeCombo = new JComboBox();
		typeCombo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		DefaultComboBoxModel productType = new DefaultComboBoxModel(new String[] { "", "Ingredients", "Ustensils" });
		typeCombo.setModel(productType);
		JComboBox unityCombo = new JComboBox();
		unityCombo.setFont(new Font("Tahoma", Font.PLAIN, 16));

		typeCombo.setBounds(307, 160, 138, 34);
//		typeCombo.addItem(new ComboItem("Visible String 1", "Value 1"));

		this.add(typeCombo);

		unityCombo.setBounds(478, 160, 78, 34);
		this.add(unityCombo);

		JButton btnAdd = new JButton("Ajouter");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAdd.addActionListener(new AddProductListener(textFieldProductName, typeCombo, unityCombo, productModel));
		btnAdd.setBounds(150, 297, 104, 49);
		this.add(btnAdd);

		JButton btnUpdate = new JButton("Modifier");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdate.setBounds(308, 297, 104, 49);
		this.add(btnUpdate);

		JButton btnBlocked = new JButton("Retirer");
		btnBlocked.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBlocked.setBounds(452, 297, 104, 49);
		this.add(btnBlocked);

		JButton creatArticlebtn = new JButton("Créer un article à partir de ce produit");
		creatArticlebtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		creatArticlebtn.setBounds(200, 424, 330, 77);
		this.add(creatArticlebtn);

		JLabel lblProductName = new JLabel("Libell\u00E9");
		lblProductName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblProductName.setBounds(95, 132, 78, 27);
		this.add(lblProductName);

		JLabel lblProductType = new JLabel("Type");
		lblProductType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblProductType.setBounds(347, 132, 78, 27);
		this.add(lblProductType);

		JLabel lblProductUnit = new JLabel("Unit\u00E9");
		lblProductUnit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblProductUnit.setBounds(478, 130, 78, 27);
		this.add(lblProductUnit);

		productList
				.addMouseListener(new ProductListListener(productModel, productList, textFieldProductName, typeCombo, unityCombo));

		typeCombo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (typeCombo.getSelectedItem() == "Ingredients") {
//					Querys querys = new Querys();
//					querys.getUnitys(unityCombo);
					unityCombo.removeAllItems();
					List<Measurement> unitys = (new MeasurementDAO()).findALL();//
					unitys.forEach(m -> {

						unityCombo.addItem(m.getUnit());

					});
					unityCombo.setEnabled(true);
				} else {
//		  					DefaultComboBoxModel unityModel = new DefaultComboBoxModel();
//		  					unityCombo.setModel(unityModel);
					unityCombo.removeAllItems();
					unityCombo.setEnabled(false);

				}

			}
		});

		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (!productList.getSelectionModel().isSelectionEmpty()) {
//					System.out.println("oui in the dd");
					int row = productList.getSelectedRow();

					Product updateProduct = new Product();
					updateProduct.setId((Integer) productModel.getValueAt(row, 0));
					updateProduct.setProductName(textFieldProductName.getText());
					updateProduct.setType(typeCombo.getSelectedItem().toString());
					updateProduct.update(unityCombo);
					List<Product> updateProducts = (new ProductDAO()).findALL();//
					Useful.display(updateProducts, productModel);
//					libeleTxt.setText((String) productModel.getValueAt(row, 1));
////					String t = ((String) productModel.getValueAt(row, 1));
//					String p = (String) productModel.getValueAt(row, 1);
//					System.out.println(p);
//					comboBoxProductArticle.setSelectedItem(p);
//					tabbedPane.setSelectedIndex(3);
				} else {
					JOptionPane.showMessageDialog(null, "Select product first");
				}

			}
		});

		creatArticlebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!productList.getSelectionModel().isSelectionEmpty()) {
//					System.out.println("oui in the dd");

					int row = productList.getSelectedRow();
//					libeleTxt.setText((String) productModel.getValueAt(row, 1));
////					String t = ((String) productModel.getValueAt(row, 1));
					String p = (String) productModel.getValueAt(row, 1);
//					System.out.println(p);
					mainController.getPanelArticle().getComboBoxProductArticle().setSelectedItem(p);
					mainController.getTabbedPane().setSelectedIndex(3);
				} else {
					JOptionPane.showMessageDialog(null, "Select product first");
				}

			}
		});

		List<Product> updateProducts = (new ProductDAO()).findALL();//
		Useful.display(updateProducts, productModel);
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

}
