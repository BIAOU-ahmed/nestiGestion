package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Article;
import model.Order;
import model.OrderLine;
import model.Product;
import tools.DBConnection;

/**
 * This class contain all query of the order
 * @author jason, ahmed
 *
 */

public class OrderLineDAO extends BaseDAO<OrderLine>{

	@Override
	public String getTableName() {

		return "order_line";
	}
	
	
	/**
	 * this functions get a resultSet in parameter and 
	 * return an object of type OrderLine
	 * @param rs the query ResultSet
	 * @return the OrderLine
	 */
	@Override
	public OrderLine getFromResultSet(ResultSet rs) throws SQLException {
		OrderLine result = null;

		if (rs != null && !rs.isClosed() && rs.next()) {

			result = new OrderLine();
			result.setIdArticle(rs.getInt("idArticle"));
			result.setIdOrders(rs.getInt("idOrders"));
			result.setAmount(rs.getInt("amount"));
			result.setAmountReceive(rs.getInt("amountReceive"));
			result.setDeliveryDate(rs.getDate("deliveryDate"));
		}

		return result;
	}

	/**
	 * insert new order line in database
	 * @param orderLine the object of type orderLine
	 * @throws SQLException all SQL Exception
	 */
	public void insert(OrderLine orderLine) throws SQLException {
		var sql = "INSERT INTO " + getTableName() + "(`idArticle`,`idOrders`,`amount`) VALUES (?,?,?);"; // Don't insert ID, let database
																					// auto-increment it.

		var insertOrderLine = DBConnection.get().prepareStatement(sql);

		insertOrderLine.setInt(1, orderLine.getIdArticle());
		insertOrderLine.setInt(2, orderLine.getIdOrders());
		insertOrderLine.setInt(3, orderLine.getAmount());
		

		insertOrderLine.executeUpdate();
		

	}
	
	/**
	 * this function is to get the total of order passed with an provider
	 * @param idArticle the id of article
	 * @param idProvider the id of provider
	 * @return the amount ordered
	 * @throws SQLException all SQL Exception
	 */
	public int getAmountOrderred(int idArticle,int idProvider) throws SQLException {
		
		String query = "SELECT SUM(ol.amount) as amount FROM order_line ol INNER JOIN orders o ON ol.idOrders=o.idOrders WHERE ol.idArticle=? AND o.idProvider=?";
				PreparedStatement declaration = DBConnection.get().prepareStatement(query);

		declaration.setInt(1, idArticle);
		declaration.setInt(2, idProvider);
//		declaration.setString(3, password);
		ResultSet resultat = declaration.executeQuery();
		int amount = 0;
		if (resultat.next()) {
			amount = resultat.getInt("amount");
		}
		return amount;
		
		
	}
	
	/**
	 * this function allows you to retrieve the total number of
	 * items received from all that you have ordered from the supplier
	 * @param idArticle the id of the article
	 * @param idProvider the id of the provider
	 * @return amount receive
	 * @throws SQLException all SQL Exceptions
	 */
	public int getAmountReceive(int idArticle,int idProvider) throws SQLException {
		
		String query = "SELECT SUM(ol.amountReceive) as amount FROM order_line ol INNER JOIN orders o "
				+ "ON ol.idOrders=o.idOrders WHERE ol.idArticle=? AND o.idProvider=?";
		PreparedStatement declaration = DBConnection.get().prepareStatement(query);
		
		declaration.setInt(1, idArticle);
		declaration.setInt(2, idProvider);
//		declaration.setString(3, password);
		ResultSet resultat = declaration.executeQuery();
		int amount = 0;
		if (resultat.next()) {
			amount = resultat.getInt("amount");
		}
		return amount;
		
		
	}
	
	/**
	 * updates the command line received as a parameter in the database
	 * @param line the orderLine
	 * @throws SQLException all SQL Exceptions
	 */
	public  void update (OrderLine line) throws SQLException {
        String sql = "UPDATE " + getTableName()
			+ " SET amount = ?, amountReceive = ?,deliveryDate =? "
			+ "WHERE idArticle = ? AND idOrders = ? ;";

        var updateUser = DBConnection.get().prepareStatement(sql);
        
        updateUser.setInt(1,  line.getAmount());
        updateUser.setInt(2,  line.getAmountReceive());
        updateUser.setDate(3, (Date) line.getDeliveryDate());
        updateUser.setInt(4,  line.getIdArticle());
        updateUser.setInt(5,  line.getIdOrders());
        updateUser.executeUpdate();

    }
	
	public OrderLine findOrderLineByOrderAndArticle(OrderLine line) {
		OrderLine result = null;

		try {
			PreparedStatement find = DBConnection.get()
					.prepareStatement("SELECT * FROM " + getTableName() + " WHERE idArticle = ? AND idOrders = ? ;");

			find.setObject(1, line.getIdArticle());
			find.setObject(2, line.getIdOrders());

			result = getFromResultSet(find.executeQuery());

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	/**
	 * this delete the article passed in the database
	 * @param article the object article
	 * @throws SQLException all SQL Exception
	 */
	public void delete(OrderLine line) throws SQLException {
		var sql = "DELETE FROM "  + getTableName()
		+ " WHERE idArticle = ? AND idOrders  =?"; 

		var deleteArticle = DBConnection.get().prepareStatement(sql);

		deleteArticle.setInt(1, line.getIdArticle());
		deleteArticle.setInt(2, line.getIdOrders());

		deleteArticle.executeUpdate();

	}
	
}
