/**
 * 
 */
package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.*;
import tools.DBConnection;

/**
 * This class contain all query of the provider
 * 
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
	 * this functions get a resultSet in parameter and return an object of type Sell
	 * 
	 * @param rs the query ResultSet
	 * @return the Sell
	 */
	@Override
	public Sell getFromResultSet(ResultSet rs) throws SQLException {
		Sell result = null;

		if (rs != null && !rs.isClosed() && rs.next()) {
			String flag = rs.getString("flag");

//			if (rs.getString("flag").equals("a") ) {
			result = new Sell();
			result.setIdArticle(rs.getInt("idArticle"));
			result.setIdProvider(rs.getInt("idProvider"));
			result.setPrice(rs.getDouble("price"));
			result.setUpdateDate(rs.getDate("updateDate"));
//			}

		}

		return result;
	}

	/**
	 * find all values by the passed parameter
	 * 
	 * @param <T>        designates the type of the variable to be generic
	 * @param fieldName  the name of the attribute
	 * @param fieldValue the value which select by
	 * @return array of object
	 */
	public <T> ArrayList<Sell> findALLBy(String fieldName, T fieldValue) {
		ArrayList<Sell> result = null;

		try {

			PreparedStatement find = DBConnection.get()
					.prepareStatement("SELECT * FROM " + getTableName() + " WHERE " + fieldName + " = ? AND flag = ?");

			find.setObject(1, fieldValue);
			find.setString(2, "a");

			ResultSet allRs = find.executeQuery();

			result = getAllFromResultSet(allRs);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * find the sell by the article and provider
	 * 
	 * @param sell the object sell
	 * @return sell
	 */
	public Sell findByProviderArticle(Sell sell) {
		Sell result = null;

//		System.out.println("table " + getTableName());
		try {
			PreparedStatement find = DBConnection.get().prepareStatement(
					"SELECT * FROM " + getTableName() + " WHERE idProvider = ? AND idArticle = ? AND flag = ?");

			find.setObject(1, sell.getIdProvider());
			find.setObject(2, sell.getIdArticle());
			find.setString(3, "a");
//			System.out.println(fieldValue);
//			System.out.println("ee " + fieldName);

			result = getFromResultSet(find.executeQuery());

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * get the sell from the database
	 * 
	 * @param sell the sell
	 */
	public void getSell(Sell sell) {
		Sell result = null;
		try {
			PreparedStatement find = DBConnection.get().prepareStatement(
					"SELECT * FROM " + getTableName() + " WHERE idProvider = ? AND idArticle=? AND flag = ?");

			find.setObject(1, sell.getIdProvider());
			find.setObject(2, sell.getIdArticle());
			find.setString(3, "a");
//			System.out.println(fieldValue);
//			System.out.println("ee " + fieldName);
			System.out.println(find);
			result = getFromResultSet(find.executeQuery());

		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result != null) {

			sell.setPrice(result.getPrice());
			sell.setUpdateDate(result.getUpdateDate());
		}

	}

	/**
	 * insert the sell received as a parameter in the database
	 * 
	 * @param sell the object sell
	 * @throws SQLException all SQL Exceptions
	 */
	public void insert(Sell sell) throws SQLException {
		var sql = "INSERT INTO " + getTableName() + "(idProvider, idArticle, price, updateDate) VALUES (?,?,?,?);";
		var insertArticle = DBConnection.get().prepareStatement(sql);

		System.out.println("provi" + sell.getIdProvider() + "articl" + sell.getIdArticle());
		insertArticle.setInt(2, sell.getIdArticle());
		insertArticle.setInt(1, sell.getIdProvider());
		insertArticle.setDouble(3, sell.getPrice());
		insertArticle.setDate(4, (Date) sell.getUpdateDate());

		insertArticle.executeUpdate();

	}

	/**
	 * update the sell received as a parameter in the database
	 * 
	 * @param sell the object sell
	 * @throws SQLException all SQL Exceptions
	 */
	public void update(Sell sell) throws SQLException {
		String sql = "UPDATE " + getTableName() + " SET price = ?,updateDate=?"
				+ "WHERE idProvider = ? AND idArticle = ?;";

		var updateUser = DBConnection.get().prepareStatement(sql);
		updateUser.setDouble(1, sell.getPrice());
		updateUser.setDate(2, sell.getUpdateDate());
		updateUser.setInt(3, sell.getIdProvider());
		updateUser.setInt(4, sell.getIdArticle());

		updateUser.executeUpdate();

	}

	/**
	 * delete the received sell in the database
	 * 
	 * @param sell the object sell
	 * @throws SQLException all SQL Exceptions
	 */
	public void delete(Sell sell) throws SQLException {
		var sql = "UPDATE " + getTableName() + " SET flag = ? WHERE idProvider = ? AND idArticle = ?";

		var deleteSell = DBConnection.get().prepareStatement(sql);

		deleteSell.setString(1, "b");
		deleteSell.setInt(2, sell.getIdProvider());
		deleteSell.setInt(3, sell.getIdArticle());
		System.out.println(deleteSell);
		deleteSell.executeUpdate();

	}

}
