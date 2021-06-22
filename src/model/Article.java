package model;

import java.sql.SQLException;
import java.util.*;

import javax.swing.JOptionPane;

import dao.AdministratorDAO;
import dao.ArticleDAO;
import dao.ConditioningDAO;
import dao.MeasurementDAO;
import dao.OrderLineDAO;
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
	private int id;

	/**
	 * 
	 */
	private double weight;

	/**
	 * 
	 */
	private int amount;

	/**
	 * 
	 */
	private String articleState;

	/**
	 * 
	 */
	private Date createdAt;
	private int idAdministrator;
	private int idProduct;

	private int idConditioning;

	/**
	 * 
	 * @param productName the name of the product
	 */
	public void setProductFromName(String productName) {
		var product = (new ProductDAO()).find("productName", productName);
		this.idProduct = product.getId();
	}

	/**
	 * 
	 * @return Product
	 */
	public Product getProduct() {

		return (new ProductDAO()).find("idProduct", this.idProduct);
	}

	/**
	 * 
	 * @param conditioningName the conditioning name
	 */
	public void setConditioningFromName(String conditioningName) {
		var Conditioning = (new ConditioningDAO()).find("conditioningName", conditioningName);
		this.idConditioning = Conditioning.getId();
	}

	/**
	 * 
	 * @return Conditioning
	 */
	public Conditioning getConditioning() {

		return (new ConditioningDAO()).find("idConditioning", this.idConditioning);
	}

	/**
	 * 
	 * @return Administrator
	 */
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

	double stock = 0.0;

	/**
	 * get the stock of the article
	 * @return stock
	 */
	public double getStock() {
		var allOrderLineToThis = getAllOrderLines();
		allOrderLineToThis.forEach(orderLine -> {
			stock += orderLine.getAmountReceive();
		});
		return stock;
	}

	/**
	 * get the price of the article
	 * @return price
	 */
	public double getPrice() {
		double price = 0.0;
		try {
			price = (new ArticleDAO()).getMaxPrice(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return price;
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

	
	/**create a new article in the database 
	 * after check is not already exist
	 * @return boolean
	 */
	public boolean create() {
		var flag = false;
		Article article = new Article();
		article.setWeight(getWeight());
		article.setAmount(getAmount());
		article.setArticleState(getArticleState());

		article.setCreatedAt(getCreatedAt());
		article.setIdAdministrator(getIdAdministrator());
		article.setIdProduct(getIdProduct());
		article.setIdConditioning(getIdConditioning());

		if ((new ArticleDAO()).find(article) == null) {
			try {
				(new ArticleDAO()).insert(article);
				flag = true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null, "L'article existe déjà");
		}
		return flag;
	}

	/**
	 * get all order lines with this article
	 * @return array of OrderLine
	 */
	public List<OrderLine> getAllOrderLines() {

		return (new OrderLineDAO()).findALLBy("idArticle", getId());
	}

	
	/**
	 * update the article and check the new values not already exist with another article id 
	 * @return boolean
	 */
	public boolean update() {
		var flag = false;
		Article article = new Article();
		article.setWeight(getWeight());
		article.setAmount(getAmount());
		article.setArticleState(getArticleState());
		article.setId(id);
		article.setCreatedAt(getCreatedAt());
		article.setIdAdministrator(getIdAdministrator());
		article.setIdProduct(getIdProduct());
		article.setIdConditioning(getIdConditioning());
//		System.out.println("up " + article.getId());
//		System.out.println("up " + article.getIdConditioning());
//		System.out.println("up " + article.getAmount());
		var art = (new ArticleDAO()).find(article);
//		System.out.println("up "+art.getId());
//		System.out.println("exist id "+ art.getId() );
//		System.out.println("actual id "+ article.getId() );
		if (art == null || art.getId() == article.getId()) {
			try {
				(new ArticleDAO()).update(article);
				flag = true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null, "other Article alrady exist");
		}
		
		return flag;
	}

	
	/**
	 * delete the article
	 * @return true | false
	 */
	public boolean delete() {
		var flag = false;
		Article article = new Article();
		article.setWeight(getWeight());
		article.setAmount(getAmount());
		article.setArticleState(getArticleState());
		article.setId(id);
		article.setCreatedAt(getCreatedAt());
		article.setIdAdministrator(getIdAdministrator());
		article.setIdProduct(getIdProduct());
		article.setIdConditioning(getIdConditioning());
//		System.out.println("up " + article.getId());
//		System.out.println("up " + article.getIdConditioning());
//		System.out.println("up " + article.getAmount());
		var art = (new ArticleDAO()).find(article);
//		System.out.println("up "+art.getId());
//		System.out.println("exist id "+ art.getId() );
//		System.out.println("actual id "+ article.getId() );
		if (art != null) {
			try {
				(new ArticleDAO()).delete(article);
				flag = true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null, "other Article alrady exist");
		}
		
		return flag;
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

	/**
	 * prepare the object to put in the table which is display for user
	 * @return object of type article
	 */
	public Object[] toRow() {
		var status = "Disponible";
		if (getArticleState().equals("b")) {
			status = "retiré";
		} else if (getAllOrderLines().size() == 0) {
			status = "Brouillon";
		}
		Object[] article = { getId(), getProduct().getProductName(), getAmount(),
				getConditioning().getConditioningName(), getWeight(), getPrice(), getStock(), status };
		return article;

	}

}