/**
 * 
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Administrator;
import model.Product;
import tools.DBConnection;

/**
 * @author ahmed
 *
 */
public class AdministratorDAO extends BaseDAO<Administrator> {


	@Override
	public String getTableName() {

		return "administrator";
	}
	
	
	@Override
	 public Administrator getFromResultSet(ResultSet rs) throws SQLException
	    {
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
}
