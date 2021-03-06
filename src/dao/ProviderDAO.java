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
 * This class contain all query of the provider
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

	/**
	 * this functions get a resultSet in parameter and 
	 * return an object of type Provider
	 * @param rs the query ResultSet
	 * @return the Provider
	 */
	@Override
	public Provider getFromResultSet(ResultSet rs) throws SQLException {
		Provider result = null;

		if (rs != null && !rs.isClosed() && rs.next()) {

			result = new Provider();
			result.setId(rs.getInt("idProvider"));
			result.setCompanyName(rs.getString("compagnyName"));
			result.setContactLastName(rs.getString("contactLastName"));
			result.setContactFirstName(rs.getString("contactFirstName"));
			result.setProviderState(rs.getString("providerState"));
			result.setIdAdministrator(rs.getInt("idAdministrator"));
			result.setContactPhoneNumber(rs.getString("contactPhoneNumber"));

		}

		return result;
	}

	/**
	 * insert the provider received as a parameter in the database
	 * @param provider the object provider
	 * @throws SQLException all SQL Exceptions
	 */
	public void insert(Provider provider) throws SQLException {
		var sql = "INSERT INTO " + getTableName()
				+ "(`compagnyName`,`contactLastName`,`contactFirstName`,`providerState`,`contactPhoneNumber`,`idAdministrator`) VALUES (?,?,?,?,?,?);"; 

		var insertArticle = DBConnection.get().prepareStatement(sql);

//		System.out.println("admin "+article.getIdAdministrator());
//		System.out.println("product "+article.getIdProduct());
//		System.out.println("condi "+article.getIdConditioning());

		insertArticle.setString(1, provider.getCompanyName());
		insertArticle.setString(2, provider.getContactLastName());
		insertArticle.setString(3, provider.getContactFirstName());
		insertArticle.setString(4, provider.getProviderState());
		insertArticle.setString(5, provider.getContactPhoneNumber());
		insertArticle.setInt(6, provider.getIdAdministrator());

		insertArticle.executeUpdate();

	}

	/**
	 * updates the provider received as a parameter in the database
	 * @param provider the object provider
	 * @throws SQLException all SQL Exceptions
	 */
	public void update(Provider provider) throws SQLException {
		String sql = "UPDATE "+ getTableName() +" SET `compagnyName` = ?, `contactLastName` = ?, `contactFirstName` = ?, `providerState` = ?, `contactPhoneNumber` = ? WHERE `provider`.`idProvider` = ?; ";
//		System.out.println("update provider");
		var updateProvider = DBConnection.get().prepareStatement(sql);
		updateProvider.setString(1, provider.getCompanyName());
		updateProvider.setString(2, provider.getContactLastName());
		updateProvider.setString(3, provider.getContactFirstName());
		updateProvider.setString(4, provider.getProviderState());
		updateProvider.setString(5, provider.getContactPhoneNumber());
		updateProvider.setInt(6, provider.getId());

//        
		updateProvider.executeUpdate();

	}

}
