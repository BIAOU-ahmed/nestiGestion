/**
 * 
 */
package tools;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.Article;
import model.Product;

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
			// Ajout d'une rangée
			model.addRow(row1);

		});
	}
	
	//make one function to display all
	
	public static void displayArticle(List<Article> products,DefaultTableModel model) {
//		 = (new ProductDAO()).findALL();//
		model.setRowCount(0);
		products.forEach(p -> {

			Object[] row1 = p.toRow();
			// Ajout d'une rangée
			model.addRow(row1);

		});
	}
	
}
