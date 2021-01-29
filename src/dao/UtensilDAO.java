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
 * @author ahmed
 *
 */
public class UtensilDAO extends BaseDAO<Utensil> {


	@Override
	public String getTableName() {

		return "utensil";
	}
	
	//INSERT INTO `product` (`idProduct`, `productName`) VALUES (NULL, 'testProduct');
	
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
	 
	public void insert (Utensil utensil) throws SQLException {
        var sql = "INSERT INTO "+ getTableName() +"(`idProduct`) VALUES (?);"; // Don't insert ID, let database auto-increment it.

        PreparedStatement insertUtensil = DBConnection.get().prepareStatement(sql);
     
        insertUtensil.setInt(1, utensil.getId());
        
        insertUtensil.executeUpdate();
  
    }
	
	public void delete (Utensil utensil) throws SQLException {
        var sql = "DELETE FROM `utensil` WHERE  	idProduct = ?"; // Don't insert ID, let database auto-increment it.

        var insertUtensil = DBConnection.get().prepareStatement(sql);
     
        insertUtensil.setInt(1, utensil.getId());
        
        insertUtensil.executeUpdate();
  
    }
}
