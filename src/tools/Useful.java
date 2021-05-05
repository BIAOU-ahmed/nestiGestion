/**
 * 
 */
package tools;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import model.Article;
import model.Order;
import model.OrderLine;
import model.Product;
import model.Provider;
import model.Sell;

/**
 * @author ahmed
 *
 */
public class Useful {

	public static void display(List<Product> products, DefaultTableModel model) {
//		 = (new ProductDAO()).findALL();//
		model.setRowCount(0);
		products.forEach(p -> {

			Object[] row1 = p.toRow();
			// Ajout d'une rang�e
			model.addRow(row1);

		});
	}

	// make one function to display all

	public static void displayArticle(List<Article> products, DefaultTableModel model) {
//		 = (new ProductDAO()).findALL();//
		model.setRowCount(0);
		products.forEach(p -> {

			Object[] row1 = p.toRow();
			// Ajout d'une rang�e
			model.addRow(row1);

		});
	}

	public static void displayProvider(List<Provider> products, DefaultTableModel model) {
//		 = (new ProductDAO()).findALL();//
		model.setRowCount(0);
		products.forEach(p -> {

			Object[] row1 = p.toRow();
			// Ajout d'une rang�e
			model.addRow(row1);

		});
	}

	public static void displaySell(List<Sell> sells, DefaultTableModel model) {
//		 = (new ProductDAO()).findALL();//
		model.setRowCount(0);
		sells.forEach(s -> {

			Object[] row1 = s.toRow();
			// Ajout d'une rang�e
			model.addRow(row1);

		});
	}

	public static void displayProviderSell(List<Sell> sells, DefaultTableModel model) {
//		 = (new ProductDAO()).findALL();//
		model.setRowCount(0);
		sells.forEach(s -> {

			Object[] row1 = s.toRowForProvider();
			// Ajout d'une rang�e
			model.addRow(row1);

		});
	}

	public static void displayOrderLine(List<OrderLine> line, DefaultTableModel model) {
//		 = (new ProductDAO()).findALL();//
		model.setRowCount(0);
		line.forEach(s -> {

			Object[] row1 = s.toRow2();
			// Ajout d'une rang�e
			model.addRow(row1);

		});
	}

	public static void displayOrderLineByOrder(List<OrderLine> line, DefaultTableModel model) {
//		 = (new ProductDAO()).findALL();//
		model.setRowCount(0);
		line.forEach(s -> {

			Object[] row1 = s.toRow();
			// Ajout d'une rang�e
			model.addRow(row1);

		});
	}

	public static void displayOrder(List<Order> order, DefaultTableModel model, int idProvider) {
//		 = (new ProductDAO()).findALL();//
		model.setRowCount(0);
		order.forEach(s -> {
			if (s.getIdProvider() == idProvider) {
				Object[] row1 = s.toRow();
				// Ajout d'une rang�e
				model.addRow(row1);
			}

		});
	}

	public static void sort(DefaultTableModel model, JTable tableOrder) {
		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);
		tableOrder.setRowSorter(sorter);
	}

	public static double parseDouble(double number, int nbDecimal) {
		BigDecimal bigDecimal = new BigDecimal(number);
		bigDecimal = bigDecimal.setScale(nbDecimal, RoundingMode.HALF_UP);
		return bigDecimal.doubleValue();

	}

	public static boolean isUserNameValid(String userName) {
		
		var result = false;
		String pattern = "^[a-zA-Z0-9]{5,10}+$";
		
		if(userName.matches(pattern)) {
			result = true;
		}
		return result;
		
	}

	public static boolean isPasswordValid(String password) {
		var result = false;
		String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,16}$";
		
		if(password.matches(pattern)) {
			result = true;
		}
		System.out.println(password);
		return result;
	}
	// pas d'espace, 8 et 16, avec cs, obligatoire 1 au moins : maj min chiffre et cs
}
