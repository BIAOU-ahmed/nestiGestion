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
 * This class contain all query of the article
 * @author ahmed
 *
 */
public class IngredientDAO extends BaseDAO<Ingredient> {

	@Override
	public String getTableName() {

		return "ingredient";
	}

	// INSERT INTO `product` (`idProduct`, `productName`) VALUES (NULL,
	// 'testProduct');

	/**
	 * this functions get a query in parameter and 
	 * return an object of type ingredient
	 * @param resultSet the query ResultSet
	 * @return the ingredient
	 */
	@Override
	public Ingredient getFromResultSet(ResultSet rs) throws SQLException {
		Ingredient result = null;

		if (rs != null && !rs.isClosed() && rs.next()) {

			result = new Ingredient();
			result.setId(rs.getInt("idProduct"));
			result.setMeasurementId(rs.getInt("idMeasurement"));

		}

		return result;
	}

	/**
	 * this function take the object Ingredient in parameter and 
	 * insert it in the database
	 * @param ing
	 * @throws SQLException
	 */
	public void insert(Ingredient ing) throws SQLException {
		var sql = "INSERT INTO " + getTableName() + "(`idProduct`,`idMeasurement`) VALUES (?,?);";

		var insertIngredient = DBConnection.get().prepareStatement(sql);

		insertIngredient.setInt(1, ing.getId());
		insertIngredient.setInt(2, ing.getMeasurement().getId());

		insertIngredient.executeUpdate();

	}

	/**
	 * this function update the Ingredient pass in parameter in the database
	 * @param ing
	 * @throws SQLException
	 */
	public void update(Ingredient ing) throws SQLException {
//		System.out.println("id" + ing.getId());
//		System.out.println("idM" + ing.getMeasurementId());
		String sql = "UPDATE `ingredient` SET `idMeasurement` = ? WHERE `ingredient`.`idProduct` = ?";
//		System.out.println(sql);
		var updateUser = DBConnection.get().prepareStatement(sql);
		updateUser.setInt(2, ing.getId());
		updateUser.setInt(1, ing.getMeasurementId());
//        updateUser.setString(3,  user.getFirstName());
//        updateUser.setString(4,  user.getLastName());
//        updateUser.setString(5,  user.getCity());
//        updateUser.setString(6,  user.getPasswordHash());
//        updateUser.setString(7,  user.getRegistrationDate());
//        updateUser.setInt(8,  user.getUserId());
//        
		updateUser.executeUpdate();

	}
//tttt
	
	/**
	 * this delete the Ingredient passed in the database
	 * @param ing
	 * @throws SQLException
	 */
	public void delete (Ingredient ing) throws SQLException {
        var sql = "DELETE FROM `ingredient` WHERE  	idProduct = ?"; // Don't insert ID, let database auto-increment it.

        var insertUtensil = DBConnection.get().prepareStatement(sql);
     
        insertUtensil.setInt(1, ing.getId());
        
        insertUtensil.executeUpdate();
  
    }
	
}
