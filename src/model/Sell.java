package model;

import java.sql.Date;
import java.sql.SQLException;
import java.util.*;

import javax.swing.JOptionPane;

import dao.AdministratorDAO;
import dao.ArticleDAO;
import dao.ConditioningDAO;
import dao.ProviderDAO;
import dao.SellDAO;

/**
 * 
 */
public class Sell {

	/**
	 * Default constructor
	 */
	public Sell() {
	}

	public int idProvider;

	public int idArticle;

	public double price;

	public void setProviderFromName(String compagnyName) {
		var provider = (new ProviderDAO()).find("compagnyName", compagnyName);
		this.idProvider = provider.getId();
	}

//    public void setArticleFromName(String article) {
//		var article = (new ArticleDAO()).find("compagnyName", compagnyName);
//		this.idProvider = article.getId();
//	}

	public Date updateDate;

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the updateDate
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate the updateDate to set
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * @return the idProvider
	 */
	public int getIdProvider() {
		return idProvider;
	}

	/**
	 * @param idProvider the idProvider to set
	 */
	public void setIdProvider(int idProvider) {
		this.idProvider = idProvider;
	}

	/**
	 * @return the idArticle
	 */
	public int getIdArticle() {
		return idArticle;
	}

	/**
	 * @param idArticle the idArticle to set
	 */
	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}

	public void create() {
		var sell = new Sell();
		sell.setIdProvider(idProvider);
		sell.setIdArticle(idArticle);
//			sell.setIdProvider();
		sell.setPrice(price);

		sell.setUpdateDate(updateDate);

		System.out.println(sell.getIdArticle() + "provi" + sell.getIdProvider());

		var selExist = (new SellDAO()).findByProviderArticle(sell);

		if (selExist == null) {
			try {
				(new SellDAO()).insert(sell);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null, "exist");
		}

	}

	public void update() {
		var updatesell = new Sell();

		updatesell.setIdArticle(idArticle);
		updatesell.setIdProvider(idProvider);
		updatesell.setPrice(price);
		updatesell.setUpdateDate(updateDate);

		try {
			(new SellDAO()).update(updatesell);
			JOptionPane.showMessageDialog(null, "Sell update succesfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete() {
		var deleteSell = new Sell();

		deleteSell.setIdArticle(idArticle);
		deleteSell.setIdProvider(idProvider);
		deleteSell.setPrice(price);
		deleteSell.setUpdateDate(updateDate);

		try {
			(new SellDAO()).delete(deleteSell);
			JOptionPane.showMessageDialog(null, "Sell deleted succesfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Object[] toRow() {
		Object[] sell = {
				getIdArticle() + " - " + getArticle().getProduct().getProductName() + " "
						+ getArticle().getConditioning().getConditioningName() + " " + getArticle().getAmount(),
				getPrice() };
		return sell;

	}

	public Object[] toRowForProvider() {
		Object[] sell = { getIdArticle(), getArticle().getConditioning().getConditioningName()+ " de "+ getArticle().getAmount()+" "+ getArticle().getProduct().getProductName(),
				 getArticle().getWeight(), getPrice() };
		return sell;

	}

	public Article getArticle() {
		// TODO Auto-generated method stub
		return (new ArticleDAO()).find("idArticle", this.idArticle);
	}

}