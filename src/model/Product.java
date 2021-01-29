package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.lambdaworks.crypto.SCryptUtil;

import dao.ArticleDAO;
import dao.IngredientDAO;
import dao.ProductDAO;
import dao.UtensilDAO;
import tools.DBConnection;

/**
 * 
 */
public class Product extends DBConnection {

	/**
	 * Default constructor
	 */
	public Product() {
	}

	/**
	 * 
	 */
	public int id;

	/**
	 * 
	 */
	public String productName;
	public String type;

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * 
	 */
	public void create(JTextField libeleTxt, JComboBox typeCombo, JComboBox Unity) {

//		System.out.println("not" + libeleTxt.getText());
		Product newProduct = new Product();

		newProduct.setProductName(libeleTxt.getText());
		Product productExist = (new ProductDAO()).find("productName", newProduct.getProductName());//
		if (productExist == null) {

			try {

				(new ProductDAO()).insert(newProduct);

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			var insertedProduct = (new ProductDAO()).find("productName", newProduct.getProductName());
			Product temp;
			if (typeCombo.getSelectedItem().equals("Ingredients")) {
//		    		newProduct = new Ingredient();
				var i = new Ingredient();

				i.setId(insertedProduct.getId());
				i.setMeasurementFromUnit(Unity.getSelectedItem().toString());
				try {
					(new IngredientDAO()).insert(i);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
//		    		newProduct = new Utensil();
				var u = new Utensil();
				u.setId(insertedProduct.getId());
				try {
					(new UtensilDAO()).insert(u);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		} else {
			JOptionPane.showMessageDialog(null, "Product alrady exist");

		}
		libeleTxt.setText("");
		typeCombo.setSelectedIndex(0);
//	 var myIngredient = new Ingredient();
//	 
//			try {
//				startCo();
//				String query = "INSERT INTO `product` (`productName`) VALUES ?;";
//				PreparedStatement declaration = accessDataBase.prepareStatement(query);
//				declaration.setString(1,libeleTxt.getText());
//				int executeUpdate = declaration.executeUpdate();
//
//				flag = (executeUpdate == 1);
//			} catch (Exception e) {
//				System.err.println("Erreur d'insertion d'utilisateur: " + e.getMessage());
//			}
//			startCo();

//		return flag;
	}

	public Object[] toRow() {
		String type = "Ustensils";
		String unity = "";
		var ing = (new IngredientDAO()).find("idProduct", this.id);
		if (ing != null) {
			type = "Ingredients";
			unity = ing.getMeasurement().getUnit();
		}
		List<Article> nbArticle = (new ArticleDAO()).findALLBy("idProduct",getId());
		Object[] product = { getId(), getProductName(), type, unity, nbArticle.size() };
		return product;
	}

	/**
	 * 
	 */
	public void update(JComboBox Unity) {

		Product product = new Product();
		product.setId(id);
		product.setProductName(productName);
		product.setType(type);
		try {
			(new ProductDAO()).update(product);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Utensil u = new Utensil();
		u.setId(id);
		Ingredient ig = new Ingredient();
		ig.setId(id);
		
		
		if (product.getType().equals("Ingredients")) {
		
			
			Ingredient i = (new IngredientDAO()).find("idProduct", id);
			if(i == null) {
				
				
				ig.setMeasurementFromUnit(Unity.getSelectedItem().toString());
				try {
					(new UtensilDAO()).delete(u);
					(new IngredientDAO()).insert(ig);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				Ingredient ing = new Ingredient();
				ing.setId(id);
				ing.setMeasurementFromUnit(Unity.getSelectedItem().toString());
//				System.out.println("unity"+Unity.getSelectedItem().toString());
//				System.out.println("value"+ing.getMeasurementId());
				ing.update();
			}
			

//			System.out.println("ingrd");
		}else {
			
			var utensil = (new UtensilDAO()).find("idProduct", product.getId());
			
			if(utensil == null) {
				
				try {
					
					(new UtensilDAO()).insert(u);
					(new IngredientDAO()).delete(ig);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 
	 */
	public void lock() {
		// TODO implement here
	}

	/**
	 * 
	 */
	public void unlock() {
		// TODO implement here
	}
	

}