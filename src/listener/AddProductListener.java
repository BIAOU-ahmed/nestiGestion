/**
 * 
 */
package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.ProductDAO;
import model.Product;
import tools.Useful;

/**
 * @author ahmed
 *
 */
public class AddProductListener implements ActionListener {
	JTextField libeleTxt;
	JComboBox typeCombo;
	JComboBox unityCombo;
	DefaultTableModel productModel;

	public AddProductListener(JTextField libeleTxt, JComboBox typeCombo, JComboBox unityCombo,
			DefaultTableModel productModel) {
		this.libeleTxt = libeleTxt;
		this.typeCombo = typeCombo;
		this.unityCombo = unityCombo;
		this.productModel = productModel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		var libele = this.libeleTxt.getText().isEmpty();
		var type = this.typeCombo.getSelectedItem().toString().isEmpty();
		System.out.println(libele);
		System.out.println(type);
		if (libele || type) {

			JOptionPane.showMessageDialog(null, "Required camp is empty");
		} else {
			var myProduct = new Product();
			myProduct.create(libeleTxt, typeCombo, unityCombo);
			List<Product> updateProducts = (new ProductDAO()).findALL();//
			Useful.display(updateProducts, productModel);
			libeleTxt.setText("");
			typeCombo.setSelectedIndex(0);

		}

	}

}
