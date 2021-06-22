package model;

import java.util.*;

import com.lambdaworks.crypto.SCryptUtil;

import dao.SuperAdminDAO;

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
	private int id;

	/**
	 * 
	 */
	private String userName;

	/**
	 * 
	 */
	private String password;

	/**
	 * 
	 */
	private String adminState;

	/**
	 * 
	 */
	private Date createdAt;

	/**
	 * checks if the password entered matches the user's password
	 * @param plaintTextPassword the non-hashed password  
	 * @return true | false
	 */
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
	 * create a new article in the database
	 * @param article the object article
	 */
	public void createArticle(Article article) {
		article.create();
	}

	/**
	 * update an article in the database
	 * @param article the object article
	 */
	public void updateArticle(Article article) {
		article.update();
	}

	/**
	 * create a new provider 
	 * @param provider the provider  
	 */
	public void createProvider(Provider provider) {
		provider.create();
	}

	/**
	 * update the provider passed
	 * @param provider the provider
	 */
	public void updateProvider(Provider provider) {
		provider.update();
	}

	/**
	 * add new order in the database
	 * @param order the order
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
	
	public String getRole() {
		String role = "Administrateur";
		var isSuperAdmin =  (new SuperAdminDAO()).find("idAdministrator", this.getId());
		if(isSuperAdmin == null) {
			 role = "Super Administrateur";
		}
		return adminState;
		
	}

	public Object[] toRow() {
		Object[] administrator = { getId(), getUserName(), getRole(), getCreatedAt(), getAdminState() };
		return administrator;
	}

}