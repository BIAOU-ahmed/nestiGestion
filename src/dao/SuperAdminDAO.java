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
import model.SuperAdmin;
import tools.DBConnection;

/**
 * @author ahmed
 *
 */
public class SuperAdminDAO extends BaseDAO<SuperAdmin> {

	@Override
	public String getTableName() {

		return "administrator";
	}

	@Override
	public SuperAdmin getFromResultSet(ResultSet rs) throws SQLException {
		SuperAdmin result = null;

		if (rs != null && !rs.isClosed() && rs.next()) {

			result = new SuperAdmin();
			result.setId(rs.getInt("idAdministrator"));
			result.setUserName(rs.getString("userName"));
			result.setAdminState(rs.getString("adminState"));
			result.setCreatedAt(rs.getDate("createAt"));
			result.setPassword(rs.getString("password"));

		}

		return result;
	}

	public void insert(Administrator admin) throws SQLException {
		var sql = "INSERT INTO " + getTableName()
				+ "(`idAdministrator`) VALUES (?);"; 

		var insertAdmin = DBConnection.get().prepareStatement(sql);

//		System.out.println("admin " + article.getIdAdministrator());
//		System.out.println("product " + article.getIdProduct());
//		System.out.println("condi " + article.getIdConditioning());

		insertAdmin.setInt(1, admin.getId());
		insertAdmin.executeUpdate();

	}
}
