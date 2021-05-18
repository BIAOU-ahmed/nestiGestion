/**
 * 
 */
package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.lambdaworks.crypto.SCryptUtil;

import model.*;
import tools.DBConnection;

/**
 * This class contain all query of the article
 * @author ahmed
 *
 */
public class ArticleDAO extends BaseDAO<Article> {

	@Override
	public String getTableName() {

		return "article";
	}

	// INSERT INTO `product` (`idProduct`, `productName`) VALUES (NULL,
	// 'testProduct');

	/**
	 * this functions get a query in parameter and 
	 * return an object of type article
	 * @param resultSet the query ResultSet
	 * @return the article
	 */
	@Override
	public Article getFromResultSet(ResultSet rs) throws SQLException {
		Article result = null;

		if (rs != null && !rs.isClosed() && rs.next()) {

			result = new Article();
			result.setId(rs.getInt("idArticle"));
			result.setWeight(rs.getDouble("weight"));
			result.setAmount(rs.getInt("amount"));
			result.setArticleState(rs.getString("articleState"));
			result.setCreatedAt(rs.getDate("createdAt"));
			result.setIdAdministrator(rs.getInt("idAdministrator"));
			result.setIdProduct(rs.getInt("idProduct"));
			result.setIdConditioning(rs.getInt("idConditioning"));

		}

		return result;
	}

	/**
	 * this function take the object administrator in parameter and 
	 * insert it in the database
	 * @param article
	 * @throws SQLException
	 */
	public void insert(Article article) throws SQLException {
		var sql = "INSERT INTO " + getTableName()
				+ "(`weight`,`amount`,`articleState`,`createdAt`,`idAdministrator`,`idProduct`,`idConditioning`) VALUES (?,?,?,?,?,?,?);"; 
		// auto-increment it.

		var insertArticle = DBConnection.get().prepareStatement(sql);

//		System.out.println("admin " + article.getIdAdministrator());
//		System.out.println("product " + article.getIdProduct());
//		System.out.println("condi " + article.getIdConditioning());

		insertArticle.setDouble(1, article.getWeight());
		insertArticle.setInt(2, article.getAmount());
		insertArticle.setString(3, article.getArticleState());
		insertArticle.setDate(4, (Date) article.getCreatedAt());
		insertArticle.setInt(5, article.getIdAdministrator());
		insertArticle.setInt(6, article.getIdProduct());
		insertArticle.setInt(7, article.getIdConditioning());

		insertArticle.executeUpdate();
		
		
		

	}

	/**
	 * this function take on article id in parameter and return 
	 * the max price of the article
	 * @param IdArticle
	 * @return article price
	 * @throws SQLException
	 */
	public double getMaxPrice(int IdArticle) throws SQLException {

		String query = "SELECT Max(s.price) as price FROM provider p INNER JOIN orders o "
				+ "ON p.idProvider = o.idProvider INNER JOIN order_line ol "
				+ "ON o.idOrders = ol.idOrders INNER JOIN sell s "
				+ "ON p.idProvider = s.idProvider WHERE ol.idArticle = ? AND s.idArticle = ?";
		PreparedStatement declaration = DBConnection.get().prepareStatement(query);

		declaration.setInt(1, IdArticle);
		declaration.setInt(2, IdArticle);
//		declaration.setString(3, password);
		ResultSet resultat = declaration.executeQuery();
		double price = 0.0;
		if (resultat.next()) {
			price = resultat.getDouble("price");
		}
//		System.out.println(price);
		return price;

//		SELECT Max(s.price),p.compagnyName FROM provider p INNER JOIN orders o ON p.idProvider = o.idProvider INNER JOIN order_line ol ON o.idOrders = ol.idOrders INNER JOIN sell s ON p.idProvider = s.idProvider WHERE ol.idArticle = 1 AND s.idArticle = 1
	}

	/**
	 * this function take an article in parameter and 
	 * find the article in the database if the article 
	 * is found is returned if not null is returned
	 * @param article
	 * @return article
	 */
	public Article find(Article article) {

		Article result = null;

//		System.out.println("table " + getTableName());
		try {
			PreparedStatement find = DBConnection.get().prepareStatement(
					"SELECT * FROM " + getTableName() + " WHERE idProduct = ? AND idConditioning =? AND amount = ?");

//			System.out.println("up id " + article.getId());
//			System.out.println("up cond " + article.getIdConditioning());
//			System.out.println("up amont " + article.getAmount());

			find.setObject(1, article.getIdProduct());
			find.setObject(2, article.getIdConditioning());
			find.setObject(3, article.getAmount());
//			System.out.println(fieldValue);
//			System.out.println("ee " + fieldName);

			result = getFromResultSet(find.executeQuery());

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * this function update the article pass in parameter in the database
	 * @param article
	 * @throws SQLException
	 */
	public void update(Article article) throws SQLException {
		String sql = "UPDATE " + getTableName()
				+ " SET idConditioning = ?, amount =?, articleState =?, weight=? WHERE idArticle = ?;";

		var updateUser = DBConnection.get().prepareStatement(sql);
		updateUser.setInt(1, article.getIdConditioning());
		updateUser.setInt(2, article.getAmount());
		updateUser.setString(3, article.getArticleState());
		updateUser.setDouble(4, article.getWeight());
		updateUser.setInt(5, article.getId());

		updateUser.executeUpdate();

	}

	/**
	 * this delete the article passed in the database
	 * @param article
	 * @throws SQLException
	 */
	public void delete(Article article) throws SQLException {
		var sql = "DELETE FROM "  + getTableName()
		+ " WHERE  	amount = ? AND idProduct = ? AND idConditioning =?"; // Don't insert ID, let database auto-increment it.

		var deleteArticle = DBConnection.get().prepareStatement(sql);

		deleteArticle.setInt(1, article.getAmount());
		deleteArticle.setInt(2, article.getIdProduct());
		deleteArticle.setInt(3, article.getIdConditioning());

		deleteArticle.executeUpdate();

	}

}
