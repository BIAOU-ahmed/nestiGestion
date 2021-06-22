/**
 * 
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.*;
import tools.DBConnection;

/**
 * This class contain all query of the conditioning
 * @author ahmed
 *
 */
public class ConditioningDAO extends BaseDAO<Conditioning> {


	@Override
	public String getTableName() {

		return "conditioning";
	}
	
	//INSERT INTO `product` (`idProduct`, `productName`) VALUES (NULL, 'testProduct');
	
	/**
	 * this functions get a resultSet in parameter and 
	 * return an object of type administrator
	 * @param rs the query ResultSet
	 * @return the conditioning
	 */
	@Override
	 public Conditioning getFromResultSet(ResultSet rs) throws SQLException
	    {
		Conditioning result = null;

	        if (rs != null && !rs.isClosed() && rs.next()) {
	        	
	        	result = new Conditioning();
	        	result.setId(rs.getInt("idConditioning"));
	        	result.setConditioningName(rs.getString("conditioningName"));
		        	
	        	
	        }
	        
	        return result;
	    }
	
	/**
	 * this function take the object Conditioning in parameter and insert it in the
	 * database
	 * 
	 * @param conditioning the object Conditioning
	 * @throws SQLException all SQL Exceptions
	 */
	public void insert(Conditioning conditioning) throws SQLException {
		var sql = "INSERT INTO " + getTableName()
				+ "(`conditioningName`)"
				+ " VALUES (?);";

		var insertArticle = DBConnection.get().prepareStatement(sql);

		insertArticle.setString(1, conditioning.getConditioningName());

		insertArticle.executeUpdate();

	}

	/**
	 * this function update the Conditioning pass in parameter in the database
	 * @param Conditioning the object article
	 * @throws SQLException all SQL Exception
	 */
	public void update(Conditioning conditioning) throws SQLException {
		String sql = "UPDATE " + getTableName()
				+ " SET conditioningName = ? WHERE idConditioning = ?;";

		var updateUser = DBConnection.get().prepareStatement(sql);
		updateUser.setString(1, conditioning.getConditioningName());
		updateUser.setInt(2, conditioning.getId());

		updateUser.executeUpdate();

	}
	
	 
}
