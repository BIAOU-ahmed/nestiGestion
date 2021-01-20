package model;


import java.util.*;

import dao.ConditioningDAO;
import dao.ProviderDAO;

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

	



}