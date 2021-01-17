/**
 * 
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.*;
import tools.DBConnection;

/**
 * @author ahmed
 *
 */
public class ConditioningDAO extends BaseDAO<Conditioning> {


	@Override
	public String getTableName() {

		return "conditioning";
	}
	
	//INSERT INTO `product` (`idProduct`, `productName`) VALUES (NULL, 'testProduct');
	
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
	
//	public void insert (Product product) throws SQLException {
//        var sql = "INSERT INTO `product` (`productName`) VALUES (?);"; // Don't insert ID, let database auto-increment it.
//
//        var insertProduct = DBConnection.get().prepareStatement(sql);
//     
//        insertProduct.setString(1,product.getProductName());
//        
//        insertProduct.executeUpdate();
//  
//    }
//	INSERT INTO `conditioning` (`idConditioning`, `conditionningName`) VALUES (NULL, 'paquet'), (NULL, 'lot');
	public  void update (Product product) throws SQLException {
        String sql = "UPDATE " + getTableName()
			+ " SET username = ?,email = ?,first_name = ?,last_name = ?,city = ?,password_hash = ?,registration_date = ?"
			+ "WHERE user_id = ?;";

//        var updateUser = DatabaseManager.getConnection().prepareStatement(sql);
//        updateUser.setString(1,  user.getUsername());
//        updateUser.setString(2,  user.getEmail());
//        updateUser.setString(3,  user.getFirstName());
//        updateUser.setString(4,  user.getLastName());
//        updateUser.setString(5,  user.getCity());
//        updateUser.setString(6,  user.getPasswordHash());
//        updateUser.setString(7,  user.getRegistrationDate());
//        updateUser.setInt(8,  user.getUserId());
//        
//        updateUser.executeUpdate();

    }
	
	 
}
