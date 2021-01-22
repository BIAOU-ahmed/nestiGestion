/**
 * 
 */
package tools;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.Article;
import model.OrderLine;
import model.Product;
import model.Provider;
import model.Sell;

/**
 * @author ahmed
 *
 */
public  class Useful {

	
	public static void display(List<Product> products,DefaultTableModel model) {
//		 = (new ProductDAO()).findALL();//
		model.setRowCount(0);
		products.forEach(p -> {

			Object[] row1 = p.toRow();
			// Ajout d'une rang�e
			model.addRow(row1);

		});
	}
	
	//make one function to display all
	
	public static void displayArticle(List<Article> products,DefaultTableModel model) {
//		 = (new ProductDAO()).findALL();//
		model.setRowCount(0);
		products.forEach(p -> {
			
			Object[] row1 = p.toRow();
			// Ajout d'une rang�e
			model.addRow(row1);

		});
	}
	
	
	public static void displayProvider(List<Provider> products,DefaultTableModel model) {
//		 = (new ProductDAO()).findALL();//
		model.setRowCount(0);
		products.forEach(p -> {

			Object[] row1 = p.toRow();
			// Ajout d'une rang�e
			model.addRow(row1);

		});
	}
	
	
	public static void displaySell(List<Sell> sells,DefaultTableModel model) {
//		 = (new ProductDAO()).findALL();//
		model.setRowCount(0);
		sells.forEach(s -> {

			Object[] row1 = s.toRow();
			// Ajout d'une rang�e
			model.addRow(row1);

		});
	}
	public static void displayProviderSell(List<Sell> sells,DefaultTableModel model) {
//		 = (new ProductDAO()).findALL();//
		model.setRowCount(0);
		sells.forEach(s -> {
			
			Object[] row1 = s.toRowForProvider();
			// Ajout d'une rang�e
			model.addRow(row1);
			
		});
	}
	public static void displayOrderLine(List<OrderLine> sells,DefaultTableModel model) {
//		 = (new ProductDAO()).findALL();//
		model.setRowCount(0);
		sells.forEach(s -> {
			
			Object[] row1 = s.toRow2();
			// Ajout d'une rang�e
			model.addRow(row1);
			
		});
	}
	
}
