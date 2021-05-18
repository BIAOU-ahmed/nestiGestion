/**
 * 
 */
package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Administrator;
import model.Article;
import model.Product;
import tools.DBConnection;

/**
 * This class contain all query of the administrator
 * @author ahmed
 *
 */
public class AdministratorDAO extends BaseDAO<Administrator> {

	/**
	 * this is just the name of the table in the database
	 */
	@Override
	public String getTableName() {

		return "administrator";
	}

	/**
	 * this functions get a resultSet in parameter and 
	 * return an object of type administrator
	 * @param resultSet the query ResultSet
	 * @return the administrator
	 */
	@Override
	public Administrator getFromResultSet(ResultSet rs) throws SQLException {
		Administrator result = null;

		if (rs != null && !rs.isClosed() && rs.next()) {

			result = new Administrator();
			result.setId(rs.getInt("idAdministrator"));
			result.setUserName(rs.getString("userName"));
			result.setAdminState(rs.getString("adminState"));
			result.setCreatedAt(rs.getDate("createAt"));
			result.setPassword(rs.getString("password"));

		}

		return result;
	}

	/**
	 * this function take the object administrator in parameter and 
	 * insert it in the database
	 * @param admin
	 * @throws SQLException
	 */
	public void insert(Administrator admin) throws SQLException {
		var sql = "INSERT INTO " + getTableName()
				+ "(`userName`,`adminState`,`createAt`,`password`) VALUES (?,?,?,?);"; // Don't
																																			// insert
																																			// ID,
																																			// let
																																			// database
		// auto-increment it.

		var insertAdmin = DBConnection.get().prepareStatement(sql);

//		System.out.println("admin " + article.getIdAdministrator());
//		System.out.println("product " + article.getIdProduct());
//		System.out.println("condi " + article.getIdConditioning());

		insertAdmin.setString(1, admin.getUserName());
		insertAdmin.setString(2, admin.getAdminState());
		insertAdmin.setDate(3, (Date) admin.getCreatedAt());
		insertAdmin.setString(4, admin.getPassword());

		insertAdmin.executeUpdate();

	}
}
