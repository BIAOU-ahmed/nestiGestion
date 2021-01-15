/**
 * 
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.PreparableStatement;

import model.*;
import tools.DBConnection;

/**
 * @author ahmed
 *
 */
public class IngredientDAO extends BaseDAO<Ingredient> {


	@Override
	public String getTableName() {

		return "ingredient";
	}
	
	//INSERT INTO `product` (`idProduct`, `productName`) VALUES (NULL, 'testProduct');
	
//	@Override
//	 public Measurement getFromResultSet(ResultSet rs) throws SQLException
//	    {
//		Ingredient result = null;
//
//	        if (rs != null && !rs.isClosed() && rs.next()) {
//	        	
//	        	result = new Ingredient();
//	        	result.setId(rs.getInt("idMeasurement"));
//		        	
//	        	
//	        }
//	        
//	        return result;
//	    }
	 
	public void insert (Ingredient ing) throws SQLException {
        String sql = "INSERT INTO"+ getTableName() +"(`idProduct`,`idMeasurement`) VALUES (?,?);"; 

        PreparedStatement insertIngredient = DBConnection.get().prepareStatement(sql);
     
        insertIngredient.setInt(1, ing.getId());
        insertIngredient.setInt(2, ing.getMeasurement().getId());
        
        insertIngredient.executeUpdate();
  
    }
}
