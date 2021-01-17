/**
 * 
 */
package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.*;
import tools.DBConnection;

/**
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

	public void insert(Article article) throws SQLException {
		var sql = "INSERT INTO " + getTableName() + "(`weight`,`amount`,`articleState`,`createdAt`,`idAdministrator`,`idProduct`,`idConditioning`) VALUES (?,?,?,?,?,?,?);"; // Don't insert ID, let database
																					// auto-increment it.

		var insertArticle = DBConnection.get().prepareStatement(sql);

		System.out.println("admin "+article.getIdAdministrator());
		System.out.println("product "+article.getIdProduct());
		System.out.println("condi "+article.getIdConditioning());
		
		insertArticle.setDouble(1, article.getWeight());
		insertArticle.setInt(2, article.getAmount());
		insertArticle.setString(3, article.getArticleState());
		insertArticle.setDate(4, (Date) article.getCreatedAt());
		insertArticle.setInt(5, article.getIdAdministrator());
		insertArticle.setInt(6, article.getIdProduct());
		insertArticle.setInt(7, article.getIdConditioning());

		insertArticle.executeUpdate();

	}

//	public void update(Product product) throws SQLException {
//		String sql = "UPDATE " + getTableName() + " SET productName = ?" + "WHERE idProduct = ?;";
//
//		var updateUser = DBConnection.get().prepareStatement(sql);
//		updateUser.setString(1, product.getProductName());
//		updateUser.setInt(2, product.getId());
////        updateUser.setString(3,  user.getFirstName());
////        updateUser.setString(4,  user.getLastName());
////        updateUser.setString(5,  user.getCity());
////        updateUser.setString(6,  user.getPasswordHash());
////        updateUser.setString(7,  user.getRegistrationDate());
////        updateUser.setInt(8,  user.getUserId());
////        
//		updateUser.executeUpdate();
//
//	}

}
