/**
 * 
 */
package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.lambdaworks.crypto.SCryptUtil;

import model.Administrator;
import model.Article;
import model.Product;
import tools.DBConnection;

/**
 * This class contain all query of the administrator
 * 
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
	 * this functions get a resultSet in parameter and return an object of type
	 * administrator
	 * 
	 * @param rs the query ResultSet
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
	 * this function take the object administrator in parameter and insert it in the
	 * database
	 * 
	 * @param admin the object administrator
	 * @throws SQLException all SQL Exception
	 */
	public void insert(Administrator admin) throws SQLException {
		var sql = "INSERT INTO " + getTableName() + "(`userName`,`adminState`,`createAt`,`password`) VALUES (?,?,?,?);"; 

		var insertAdmin = DBConnection.get().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		String generatedSecuredPasswordHash = SCryptUtil.scrypt(admin.getPassword(), 16, 16, 16);

		insertAdmin.setString(1, admin.getUserName());
		insertAdmin.setString(2, admin.getAdminState());
		insertAdmin.setDate(3, (Date) admin.getCreatedAt());
		insertAdmin.setString(4, generatedSecuredPasswordHash);

		insertAdmin.executeUpdate();

		var rs = insertAdmin.getGeneratedKeys();
		if (rs.next()) {
			admin.setId(rs.getInt(1));
		}
	}

	public void block(int idAdmin) throws SQLException {
		var sql = "UPDATE " + getTableName() + " SET adminState = ? WHERE idAdministrator = ?;";

		var blockAdmin = DBConnection.get().prepareStatement(sql);

		blockAdmin.setString(1, "b");
		blockAdmin.setInt(2, idAdmin);

		blockAdmin.executeUpdate();

	}
	
	public void update(Administrator admin) throws SQLException {
		var sql = "UPDATE " + getTableName() + " SET userName = ? WHERE idAdministrator = ?;";
		var blockAdmin = DBConnection.get().prepareStatement(sql);

		blockAdmin.setString(1, admin.getUserName());
		blockAdmin.setInt(2, admin.getId());

		blockAdmin.executeUpdate();

	}

	public void updatePassword(int idAdmin, String password) throws SQLException {
		var sql = "UPDATE " + getTableName() + " SET password = ? WHERE idAdministrator = ?;";
		String generatedSecuredPasswordHash = SCryptUtil.scrypt(password, 16, 16, 16);
		var blockAdmin = DBConnection.get().prepareStatement(sql);

		blockAdmin.setString(1, generatedSecuredPasswordHash);
		blockAdmin.setInt(2, idAdmin);

		blockAdmin.executeUpdate();

	}

}
