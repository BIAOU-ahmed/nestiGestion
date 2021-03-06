/**
 * 
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.*;
import tools.DBConnection;

/**
 * This class contain all query of the product
 * @author ahmed
 *
 */
public class ProductDAO extends BaseDAO<Product> {


	@Override
	public String getTableName() {

		return "product";
	}
	
	//INSERT INTO `product` (`idProduct`, `productName`) VALUES (NULL, 'testProduct');
	
	/**
	 * this functions get a resultSet in parameter and 
	 * return an object of type Product
	 * @param rs the query ResultSet
	 * @return the Product
	 */
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
	
	/**
	 * insert the product received as a parameter in the database
	 * @param product the product
	 * @throws SQLException all SQL Exception
	 */
	public void insert (Product product) throws SQLException {
        String sql = "INSERT INTO `product` (`productName`) VALUES (?);"; // Don't insert ID, let database auto-increment it.

        PreparedStatement insertProduct = DBConnection.get().prepareStatement(sql);
     
        insertProduct.setString(1,product.getProductName());
        
        insertProduct.executeUpdate();
  
    }
	/**
	 * updates the Product received as a parameter in the database
	 * @param product the product 
	 * @throws SQLException all SQL Exception
	 */
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
