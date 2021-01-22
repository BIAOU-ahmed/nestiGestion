package model;

import java.util.*;

import com.lambdaworks.crypto.SCryptUtil;

/**
 * 
 */
public class Administrator {

    /**
     * Default constructor
     */
    public Administrator() {
    }

    /**
     * 
     */
    public int id;

    /**
     * 
     */
    public String userName;

    /**
     * 
     */
    public String password;

    /**
     * 
     */
    public String adminState;

    /**
     * 
     */
    public Date createdAt;



    public boolean isPassword(String plaintTextPassword) {
    	boolean matched = SCryptUtil.check(plaintTextPassword, this.password);
    	return matched;
    	
    }

    /**
     * 
     */
    public void ordering() {
        // TODO implement here
    }

    /**
     * 
     */
    public void createArticle(Article article) {
        article.create();
    }
    /**
     * 
     */
    public void updateArticle(Article article) {
    	article.update();
    }

    /**
     * 
     */
    public void createProvider(Provider provider) {
    	provider.create();
    }

    
    /**
     * 
     */
    public void updateProvider(Provider provider) {
    	provider.update();
    }

    
    /**
     * 
     */
    public void createOrder(Order order) {
    	order.create(order);
    }
    
    /**
     * 
     */
    public void deleteProvider() {
        // TODO implement here
    }

    /**
     * 
     */
    public void addProduct() {
        // TODO implement here
    }

    /**
     * 
     */
    public void updateProduct() {
        // TODO implement here
    }

    /**
     * 
     */
    public void deleteProduct() {
        // TODO implement here
    }

    /**
     * 
     */
    public void showProvider() {
        // TODO implement here
    }

    /**
     * 
     */
    public void manageStateOrder() {
        // TODO implement here
    }

    /**
     * 
     */
    public void updateArticleStorage() {
        // TODO implement here
    }



    /**
     * 
     */
    public void isSuperAdmin() {
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
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the adminState
	 */
	public String getAdminState() {
		return adminState;
	}

	/**
	 * @param adminState the adminState to set
	 */
	public void setAdminState(String adminState) {
		this.adminState = adminState;
	}

	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

    public Object[] toRow() {
    	Object[] administrator = { getId(), getUserName(), "getdroits", getCreatedAt(), getAdminState()};
    	return administrator;
    }
    

}