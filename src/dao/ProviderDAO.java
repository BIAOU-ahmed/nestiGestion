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
public class ProviderDAO extends BaseDAO<Provider> {

	@Override
	public String getTableName() {

		return "provider";
	}

	// INSERT INTO `product` (`idProduct`, `productName`) VALUES (NULL,
	// 'testProduct');

	@Override
	public Provider getFromResultSet(ResultSet rs) throws SQLException {
		Provider result = null;

		if (rs != null && !rs.isClosed() && rs.next()) {

			result = new Provider();
			result.setId(rs.getInt("idArticle"));
//			result.setWeight(rs.getDouble("weight"));
//			result.setAmount(rs.getInt("amount"));
//			result.setArticleState(rs.getString("articleState"));
//			result.setCreatedAt(rs.getDate("createdAt"));
//			result.setIdAdministrator(rs.getInt("idAdministrator"));
//			result.setIdProduct(rs.getInt("idProduct"));
//			result.setIdConditioning(rs.getInt("idConditioning"));

		}

		return result;
	}

	public void insert(Provider provider) throws SQLException {
		var sql = "INSERT INTO " + getTableName() + "(`compagnyName`,`contactLastName`,`contactFirstName`,`providerState`,`contactPhoneNumber`,`idAdministrator`) VALUES (?,?,?,?,?,?);"; // Don't insert ID, let database
																					// auto-increment it.

		var insertArticle = DBConnection.get().prepareStatement(sql);

//		System.out.println("admin "+article.getIdAdministrator());
//		System.out.println("product "+article.getIdProduct());
//		System.out.println("condi "+article.getIdConditioning());
		
		insertArticle.setString(1, provider.getCompanyName());
		insertArticle.setString(2,provider.getContactLastName());
		insertArticle.setString(3, provider.getContactFirstName());
		insertArticle.setString(4, provider.getProviderState());
		insertArticle.setString(5, provider.getContactPhoneNumber());
		insertArticle.setInt(6, provider.getIdAdministrator());

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
