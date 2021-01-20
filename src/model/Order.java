package model;


import java.util.*;

/**
 * 
 */
public class Order {

    /**
     * Default constructor
     */
    public Order() {
    }

    /**
     * 
     */
    public int id;

    /**
     * 
     */
    public Date orderDate;

    /**
     * 
     */
    public String state;






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
    public void getAmount() {
        // TODO implement here
    }

    /**
     * 
     */
    public void setAmount() {
        // TODO implement here
    }

    /**
     * 
     */
    public void getOrderDate() {
        // TODO implement here
    }

    /**
     * 
     */
    public void setOrderDate() {
        // TODO implement here
    }
    
    public Object[] toRow() {
    	
    	Object[] order = { "numéro de commande", "fournisseur", "montant", "date commande", "date livraison", "statut"};
    	return order;
    }

}