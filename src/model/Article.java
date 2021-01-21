package model;

import java.sql.SQLException;
import java.util.*;

import dao.AdministratorDAO;
import dao.ArticleDAO;
import dao.ConditioningDAO;
import dao.MeasurementDAO;
import dao.ProductDAO;

/**
 * 
 */
public class Article {

	/**
	 * Default constructor
	 */
	public Article() {
	}

	/**
	 * 
	 */
	public int id;

	/**
	 * 
	 */
	public double weight;

	/**
	 * 
	 */
	public int amount;

	/**
	 * 
	 */
	public String articleState;

	/**
	 * 
	 */
	public Date createdAt;
	private int idAdministrator;
	private int idProduct;

	private int idConditioning;

	
	
	public void setProductFromName(String productName) {
		var product = (new ProductDAO()).find("productName", productName);
		this.idProduct = product.getId();
	}

	public Product getProduct() {

		return (new ProductDAO()).find("idProduct", this.idProduct);
	}

	public void setConditioningFromName(String conditioningName) {
		var Conditioning = (new ConditioningDAO()).find("conditioningName", conditioningName);
		this.idConditioning = Conditioning.getId();
	}

	public Conditioning getConditioning() {

		return (new ConditioningDAO()).find("idConditioning", this.idConditioning);
	}

	public Administrator getAdministrator() {

		return (new AdministratorDAO()).find("idAdministrator", this.idAdministrator);
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

	/**
	 * @return the idProduct
	 */
	public int getIdProduct() {
		return idProduct;
	}

	/**
	 * @param idProduct the idProduct to set
	 */
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	/**
	 * @return the idConditioning
	 */
	public int getIdConditioning() {
		return idConditioning;
	}

	/**
	 * @param idConditioning the idConditioning to set
	 */
	public void setIdConditioning(int idConditioning) {
		this.idConditioning = idConditioning;
	}

	/**
	 * 
	 */
	public void create() {
		Article article = new Article();
		article.setWeight(getWeight());
		article.setAmount(getAmount());
		article.setArticleState(getArticleState());
		
		article.setCreatedAt(getCreatedAt());
		article.setIdAdministrator(getIdAdministrator());
		article.setIdProduct(getIdProduct());
		article.setIdConditioning(getIdConditioning());
		
		try {
			(new ArticleDAO()).insert(article);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * @return the articleState
	 */
	public String getArticleState() {
		return articleState;
	}

	/**
	 * @param articleState the articleState to set
	 */
	public void setArticleState(String articleState) {
		this.articleState = articleState;
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
		Object[] article = { getId(), getProduct().getProductName(), "Qté", getConditioning().getConditioningName(), "54", getWeight(),"12",getArticleState() };
		return article;
		
	}

}