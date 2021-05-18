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
 * This class contain all query of the order
 * @author ahmed
 *
 */
public class UtensilDAO extends BaseDAO<Utensil> {


	@Override
	public String getTableName() {

		return "utensil";
	}
	
	//INSERT INTO `product` (`idProduct`, `productName`) VALUES (NULL, 'testProduct');
	
	/**
	 * this functions get a resultSet in parameter and 
	 * return an object of type Utensil
	 * @param resultSet the query ResultSet
	 * @return the Utensil
	 */
	@Override
	 public Utensil getFromResultSet(ResultSet rs) throws SQLException
	    {
		Utensil result = null;

	        if (rs != null && !rs.isClosed() && rs.next()) {
	        	
	        	result = new Utensil();
	        	result.setId(rs.getInt("idProduct"));
		        	
	        	
	        }
	        
	        return result;
	    }
	 /**
	  * insert the product id in the utensil table 
	  * @param utensil
	  * @throws SQLException
	  */
	public void insert (Utensil utensil) throws SQLException {
        var sql = "INSERT INTO "+ getTableName() +"(`idProduct`) VALUES (?);";

        PreparedStatement insertUtensil = DBConnection.get().prepareStatement(sql);
     
        insertUtensil.setInt(1, utensil.getId());
        
        insertUtensil.executeUpdate();
  
    }
	
	/**
	 * delete the utensil
	 * @param utensil
	 * @throws SQLException
	 */
	public void delete (Utensil utensil) throws SQLException {
        var sql = "DELETE FROM `utensil` WHERE  	idProduct = ?";

        var insertUtensil = DBConnection.get().prepareStatement(sql);
     
        insertUtensil.setInt(1, utensil.getId());
        
        insertUtensil.executeUpdate();
  
    }
}
