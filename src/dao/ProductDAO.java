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
public class ProductDAO extends BaseDAO<Product> {


	@Override
	public String getTableName() {

		return "product";
	}
	
	//INSERT INTO `product` (`idProduct`, `productName`) VALUES (NULL, 'testProduct');
	
	@Override
	 public Product getFromResultSet(ResultSet rs) throws SQLException
	    {
		 Product result = null;

	        if (rs != null && !rs.isClosed() && rs.next()) {
	        	
	        	result = new Product();
	        	result.setId(rs.getInt("idProduct"));
	        	result.setProductName(rs.getString("productName"));
		        	
	        	
	        }
	        
	        return result;
	    }
	
	public void insert (Product product) throws SQLException {
        var sql = "INSERT INTO `product` (`productName`) VALUES (?);"; // Don't insert ID, let database auto-increment it.

        var insertProduct = DBConnection.get().prepareStatement(sql);
     
        insertProduct.setString(1,product.getProductName());
        
        insertProduct.executeUpdate();
  
    }
	
	public  void update (Product product) throws SQLException {
        String sql = "UPDATE " + getTableName()
			+ " SET productName = ?"
			+ "WHERE idProduct = ?;";

        var updateUser = DBConnection.get().prepareStatement(sql);
        updateUser.setString(1,  product.getProductName());
        updateUser.setInt(2,  product.getId());
//        updateUser.setString(3,  user.getFirstName());
//        updateUser.setString(4,  user.getLastName());
//        updateUser.setString(5,  user.getCity());
//        updateUser.setString(6,  user.getPasswordHash());
//        updateUser.setString(7,  user.getRegistrationDate());
//        updateUser.setInt(8,  user.getUserId());
//        
        updateUser.executeUpdate();

    }
	
	 
}
