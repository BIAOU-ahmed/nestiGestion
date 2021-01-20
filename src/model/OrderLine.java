package model;


import java.util.*;

/**
 * 
 */
public class OrderLine {

    /**
     * Default constructor
     */
    public OrderLine() {
    }

    /**
     * 
     */
    public int amount;

    /**
     * 
     */
    public int amountReceive;

    /**
     * 
     */
    public Date deliveryDate;

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
    public void getAmountReceive() {
        // TODO implement here
    }

    /**
     * 
     */
    public void setAmountReceive() {
        // TODO implement here
    }

    /**
     * 
     */
    public void getDeliveryDate() {
        // TODO implement here
    }

    /**
     * 
     */
    public void setDeliveryDate() {
        // TODO implement here
    }

    
    public Object[] toRow() {
    	
    	Object[] orderLine = {"id", "produit", "conditionnement", "qté commandée", "prix"};
    	return orderLine;
    }
    
    public Object[] toRow2() {
    	
    	Object[] orderLine = {"id", "produit", "conditionnement", "qté commandée", "prix", "date commande", "date livraison"};
    	return orderLine;
    }
}