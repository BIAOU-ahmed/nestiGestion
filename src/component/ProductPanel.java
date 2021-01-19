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

public class ProductPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ProductPanel(JTabbedPane tabbedPane, JComboBox comboBoxProductArticle) {
		setLayout(null);

		JTextField textField_2 = new JTextField();
		textField_2.setBounds(809, 70, 571, 20);
		this.add(textField_2);
		textField_2.setColumns(10);

		JScrollPane scrollPane_1 = new JScrollPane();

		scrollPane_1.setBounds(809, 132, 571, 492);

		this.add(scrollPane_1);

		DefaultTableModel model2 = new DefaultTableModel(new Object[][] {,}, new String[] { "Numéro commande",
				"Fournisseur", "Montant €", "Date commande", "Date livraison", "Statut" });

		this.add(scrollPane_1);

		DefaultTableModel productModel = new DefaultTableModel(new Object[][] {,},
				new String[] { "Identifiant", "Libellé", "Type", "Unité", "Nb d'articles créés" });
		JTable productList = new JTable();

		productList.setModel(productModel);
		scrollPane_1.setViewportView(productList);

		JTextField libeleTxt = new JTextField();
		libeleTxt.setBounds(95, 160, 185, 34);
		this.add(libeleTxt);
		libeleTxt.setColumns(10);

		JComboBox typeCombo = new JComboBox();
		DefaultComboBoxModel productType = new DefaultComboBoxModel(new String[] { "", "Ingredients", "Ustensils" });
		typeCombo.setModel(productType);
		JComboBox unityCombo = new JComboBox();

		typeCombo.setBounds(307, 160, 138, 34);
//		typeCombo.addItem(new ComboItem("Visible String 1", "Value 1"));

		this.add(typeCombo);

		unityCombo.setBounds(478, 160, 78, 34);
		this.add(unityCombo);

		JButton btnAdd = new JButton("Ajouter");
		btnAdd.addActionListener(new AddProductListener(libeleTxt, typeCombo, unityCombo, productModel));
		btnAdd.setBounds(150, 297, 104, 49);
		this.add(btnAdd);

		JButton btnUpdate = new JButton("Modifier");
		btnUpdate.setBounds(308, 297, 104, 49);
		this.add(btnUpdate);

		JButton btnBlocked = new JButton("Retirer");
		btnBlocked.setBounds(452, 297, 104, 49);
		this.add(btnBlocked);

		JButton creatArticlebtn = new JButton("Cr�er un article � partir de ce produit");
		creatArticlebtn.setBounds(226, 424, 248, 77);
		this.add(creatArticlebtn);

		JLabel lblNewLabel_2 = new JLabel("Libell\u00E9");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(95, 132, 78, 27);
		this.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Type");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(338, 132, 78, 27);
		this.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_2 = new JLabel("Unit\u00E9");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_2.setBounds(478, 130, 78, 27);
		this.add(lblNewLabel_2_2);

		productList
				.addMouseListener(new ProductListListener(productModel, productList, libeleTxt, typeCombo, unityCombo));

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
					updateProduct.setProductName(libeleTxt.getText());
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
				}else {
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
					comboBoxProductArticle.setSelectedItem(p);
					tabbedPane.setSelectedIndex(3);
				}else {
					JOptionPane.showMessageDialog(null, "Select product first");
				}

			}
		});

		List<Product> updateProducts = (new ProductDAO()).findALL();//
		Useful.display(updateProducts, productModel);
	}

}
