package model;


import java.sql.SQLException;
import java.util.*;

import javax.swing.JOptionPane;

import dao.ArticleDAO;
import dao.IngredientDAO;
import dao.OrderDAO;
import dao.ProviderDAO;

/**
 * 
 */
public class Provider {

    /**
     * Default constructor
     */
    public Provider() {
    }

    /**
     * 
     */
    public int id;

    /**
     * 
     */
    public String companyName;

    /**
     * 
     */
    public String contactLastName;

    /**
     * 
     */
    public String contactFirstName;

    /**
     * 
     */
    public String contactPhoneNumber;

    /**
     * 
     */
    public String providerState;

    public int idAdministrator;





    /**
     * create new provider in database
     */
    public void create() {
    	Provider newProvider = new Provider();
    	newProvider.setCompanyName(getCompanyName());
		newProvider.setContactLastName(getContactLastName());
		newProvider.setContactFirstName(getContactFirstName());
		newProvider.setProviderState(getProviderState());
		newProvider.setContactPhoneNumber(getContactPhoneNumber());
		newProvider.setIdAdministrator(getIdAdministrator());
		JOptionPane.showMessageDialog(null, "Provider create succesfully");
		try {
			(new ProviderDAO()).insert(newProvider);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    /**
     * update the provider in database
     */
    public void update() {
    	Provider updatedProvider = new Provider();
    	
    	updatedProvider.setId(id);
    	updatedProvider.setCompanyName(getCompanyName());
    	updatedProvider.setContactLastName(getContactLastName());
    	updatedProvider.setContactFirstName(getContactFirstName());
		updatedProvider.setProviderState(getProviderState());
		updatedProvider.setContactPhoneNumber(getContactPhoneNumber());
		updatedProvider.setIdAdministrator(getIdAdministrator());
		JOptionPane.showMessageDialog(null, "Provider update succesfully");
		try {
			(new ProviderDAO()).update(updatedProvider);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    }
    boolean result = false;
    /**
     * this function allows to know if an order has been placed with this supplier
     * @return true | false
     */
    public boolean haveOrderStanding() {
    	
    	var listOrders = (new OrderDAO()).findALLBy("idProvider", getId());
    	listOrders.forEach(o->{
    		if(o.getDisplayState().equals("En cours")) {
    			result = true;
    		}
    	});
    	return result;
    }

    /**
     * 
     */
    public void delete() {
        // TODO implement here
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
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return the contactLastName
	 */
	public String getContactLastName() {
		return contactLastName;
	}

	/**
	 * @param contactLastName the contactLastName to set
	 */
	public void setContactLastName(String contactLastName) {
		this.contactLastName = contactLastName;
	}

	/**
	 * @return the contactFirstName
	 */
	public String getContactFirstName() {
		return contactFirstName;
	}

	/**
	 * @param contactFirstName the contactFirstName to set
	 */
	public void setContactFirstName(String contactFirstName) {
		this.contactFirstName = contactFirstName;
	}

	/**
	 * @return the contactPhoneNumber
	 */
	public String getContactPhoneNumber() {
		return contactPhoneNumber;
	}

	/**
	 * @param contactPhoneNumber the contactPhoneNumber to set
	 */
	public void setContactPhoneNumber(String contactPhoneNumber) {
		this.contactPhoneNumber = contactPhoneNumber;
	}

	/**
	 * @return the providerState
	 */
	public String getProviderState() {
		return providerState;
	}

	/**
	 * @param providerState the providerState to set
	 */
	public void setProviderState(String providerState) {
		this.providerState = providerState;
	}

	/**
	 * @return the idAdministrator
	 */
	public int getIdAdministrator() {
		return idAdministrator;
	}

	/**
	 * @param idAdministrator the idAdministrator to set
	 */
	public void setIdAdministrator(int idAdministrator) {
		this.idAdministrator = idAdministrator;
	}

	public Object[] toRow() {
	var status = "Disponible";
	
//	System.out.println(getProviderState());
//	System.out.println((getProviderState().equals("b")));
	if(getProviderState().equals("b")) {
		status = "Inactif";
	}
		Object[] product = { getId(), getCompanyName(), getContactLastName(), getContactFirstName(), getContactPhoneNumber(),status };
		return product;
	}
	
	
	
	

    
}