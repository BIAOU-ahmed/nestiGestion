/**
 * 
 */
package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.*;
import tools.DBConnection;

/**
 * This class contain all query of the provider
 * @author ahmed
 *
 */
public class SellDAO extends BaseDAO<Sell> {

	@Override
	public String getTableName() {

		return "sell";
	}

	// INSERT INTO `product` (`idProduct`, `productName`) VALUES (NULL,
	// 'testProduct');

	/**
	 * this functions get a resultSet in parameter and 
	 * return an object of type Sell
	 * @param resultSet the query ResultSet
	 * @return the Sell
	 */
	@Override
	public Sell getFromResultSet(ResultSet rs) throws SQLException {
		Sell result = null;

		if (rs != null && !rs.isClosed() && rs.next()) {

			result = new Sell();
			result.setIdArticle(rs.getInt("idArticle"));
			result.setIdProvider(rs.getInt("idProvider"));
			result.setPrice(rs.getDouble("price"));
			result.setUpdateDate(rs.getDate("updateDate"));
		

		}

		return result;
	}

	/**
	 * find the sell by the article and provider
	 * @param sell
	 * @return sell
	 */
	public Sell findByProviderArticle(Sell sell) {
		Sell result = null;

//		System.out.println("table " + getTableName());
		try {
			PreparedStatement find = DBConnection.get()
					.prepareStatement("SELECT * FROM " + getTableName() + " WHERE idProvider = ? AND idArticle = ?");

			find.setObject(1, sell.getIdProvider());
			find.setObject(2, sell.getIdArticle());
//			System.out.println(fieldValue);
//			System.out.println("ee " + fieldName);

			result = getFromResultSet(find.executeQuery());

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	
	public void getSell(Sell sell) {
		Sell result = null;
		try {
			PreparedStatement find = DBConnection.get()
					.prepareStatement("SELECT * FROM " + getTableName() + " WHERE idProvider = ? AND idArticle=?");

			find.setObject(1, sell.getIdProvider());
			find.setObject(2, sell.getIdArticle());
//			System.out.println(fieldValue);
//			System.out.println("ee " + fieldName);

			result = getFromResultSet(find.executeQuery());

		} catch (SQLException e) {
			e.printStackTrace();
		}
		sell.setPrice(result.getPrice());
		sell.setUpdateDate(result.getUpdateDate());
		
	}
	
	/**
	 * insert the sell received as a parameter in the database
	 * @param sell
	 * @throws SQLException
	 */
	public void insert(Sell sell) throws SQLException {
		var sql = "INSERT INTO " + getTableName() + "(idProvider, idArticle, price, updateDate) VALUES (?,?,?,?);"; 
		var insertArticle = DBConnection.get().prepareStatement(sql);

		System.out.println("provi"+ sell.getIdProvider() +"articl"+sell.getIdArticle());
		insertArticle.setInt(2, sell.getIdArticle());
		insertArticle.setInt(1, sell.getIdProvider());
		insertArticle.setDouble(3, sell.getPrice());
		insertArticle.setDate(4, (Date) sell.getUpdateDate());

		insertArticle.executeUpdate();

	}

	/**
	 * update the sell received as a parameter in the database
	 * @param sell
	 * @throws SQLException
	 */
	public void update(Sell sell) throws SQLException {
		String sql = "UPDATE " + getTableName() + " SET price = ?,updateDate=?" + "WHERE idProvider = ? AND idArticle = ?;";

		var updateUser = DBConnection.get().prepareStatement(sql);
		updateUser.setDouble(1, sell.getPrice());
		updateUser.setDate(2, sell.getUpdateDate());
		updateUser.setInt(3, sell.getIdProvider());
		updateUser.setInt(4, sell.getIdArticle());
        
		updateUser.executeUpdate();

	}
	
	/**
	 * delete the received sell in the database
	 * @param sell
	 * @throws SQLException
	 */
	public void delete (Sell sell) throws SQLException {
        var sql = "DELETE FROM " +getTableName() +" WHERE  	idProvider = ? AND idArticle = ?"; // Don't insert ID, let database auto-increment it.

        var deleteSell = DBConnection.get().prepareStatement(sql);
     
        deleteSell.setInt(1, sell.getIdProvider());
        deleteSell.setInt(2, sell.getIdArticle());
        
        deleteSell.executeUpdate();
  
    }

}
