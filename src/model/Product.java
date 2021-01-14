package model;


import java.sql.PreparedStatement;
import java.util.*;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.lambdaworks.crypto.SCryptUtil;

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
     * 
     */
    public void getId() {
        // TODO implement here
    }

    /**
     * 
     */
    public void setId() {
        // TODO implement here
    }

    /**
     * 
     */
    public void getProductName() {
        // TODO implement here
    }

    /**
     * 
     */
    public void setProductName() {
        // TODO implement here
    }

    /**
     * 
     */
    public void create(JTextField libeleTxt,JComboBox typeCombo, JComboBox Unity) {
    	boolean flag = false;
	 
			try {
				startCo();
				String query = "INSERT INTO `product` (`productName`) VALUES ?;";
				PreparedStatement declaration = accessDataBase.prepareStatement(query);
				declaration.setString(1,libeleTxt.getText());
				int executeUpdate = declaration.executeUpdate();

				flag = (executeUpdate == 1);
			} catch (Exception e) {
				System.err.println("Erreur d'insertion d'utilisateur: " + e.getMessage());
			}
			startCo();
		 

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