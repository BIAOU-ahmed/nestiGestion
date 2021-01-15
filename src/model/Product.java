package model;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.lambdaworks.crypto.SCryptUtil;

import dao.IngredientDAO;
import dao.ProductDAO;
import dao.UtensilDAO;
import tools.DBConnection;

/**
 * 
 */
public class Product extends DBConnection{

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
    public void create(JTextField libeleTxt,JComboBox typeCombo, JComboBox Unity) {
    	Product newProduct = new Product();
    	 newProduct.setProductName(libeleTxt.getText());
    	 
    	 try {
			(new ProductDAO()).insert(newProduct);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	 Product insertedProduct = (new ProductDAO()).find("productName",newProduct.getProductName());
    	 Product temp;
    	if(typeCombo.getSelectedItem().equals("Ingredients")) {
//    		newProduct = new Ingredient();
    		Ingredient i = new Ingredient();
    		
    		i.setId(insertedProduct.getId());
    		i.setMeasurementFromUnit(Unity.getSelectedItem().toString());
    		try {
				(new IngredientDAO()).insert(i);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}else {
//    		newProduct = new Utensil();
    		Utensil u = new Utensil();
    		u.setId(insertedProduct.getId());
    		try {
				(new UtensilDAO()).insert(u);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	
    	
    	
	
	 
	 
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

    /**
     * 
     */
    public void update() {
        // TODO implement here
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