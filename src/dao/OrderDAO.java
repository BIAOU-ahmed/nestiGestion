package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Article;
import model.Order;
import model.OrderLine;
import tools.DBConnection;

/**
 * This class contain all query of the order
 * @author jason, ahmed
 *
 */

public class OrderDAO extends BaseDAO<Order>{

	@Override
	public String getTableName() {

		return "orders";
	}
	
	
	/**
	 * this functions get a resultSet in parameter and 
	 * return an object of type order
	 * @param rs the query ResultSet
	 * @return the order
	 */
	@Override
	public Order getFromResultSet(ResultSet rs) throws SQLException {
		Order result = null;

		if (rs != null && !rs.isClosed() && rs.next()) {

			result = new Order();
			result.setId(rs.getInt("idOrders"));
			result.setOrderDate(rs.getDate("orderDate"));
			result.setState(rs.getString("state"));
			result.setIdProvider(rs.getInt("idProvider"));
			result.setIdAdministrator(rs.getInt("idAdministrator"));
		}

		return result;
	}

	/**
	 * this function select all order with the state'w' in the database
	 * @return array of order
	 */
	public List<Order> getActiveOrders() {
		var result = new ArrayList<Order>();
		PreparedStatement find;
		try {
			find = DBConnection.get()
					.prepareStatement("SELECT * FROM " + getTableName() + " WHERE state = 'w'");
			
			ResultSet allRs = find.executeQuery();

			result = getAllFromResultSet(allRs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		
//		if(result.size()==0) {
//			var newOrder = new Order();
//			newOrder.setState("w");
//			try {
//				this.insert(newOrder);
//				result.add(newOrder);
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		return result;
	}
	
	/**
	 * insert new oder in the database
	 * @param order the order
	 * @throws SQLException all SQL Exception
	 */
	public void insert(Order order) throws SQLException {
		var sql = "INSERT INTO " + getTableName() + "(`orderDate`,`state`,`idProvider`,`idAdministrator`) VALUES (?,?,?,?);"; // Don't insert ID, let database
																					// auto-increment it.

		var insertOrder = DBConnection.get().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

//		System.out.println("admin "+article.getIdAdministrator());
//		System.out.println("product "+article.getIdProduct());
//		System.out.println("condi "+article.getIdConditioning());
		
		insertOrder.setDate(1, (Date) order.getOrderDate());
		insertOrder.setString(2, order.getState());
		insertOrder.setInt(3, order.getIdProvider());
		insertOrder.setInt(4, order.getIdAdministrator());

		insertOrder.executeUpdate();
		
		var rs = insertOrder.getGeneratedKeys();
		if (rs.next()) {
		  order.setId(rs.getInt(1));
		}

//		return order;

	}
	
	/**
	 * update the order passed
	 * @param order the object order
	 * @throws SQLException all SQL Exception
	 */
	public  void update (Order order) throws SQLException {
        String sql = "UPDATE " + getTableName()
			+ " SET state = ? "
			+ "WHERE idOrders = ?;";

        var updateUser = DBConnection.get().prepareStatement(sql);
//        System.out.println("id "+order.getId());
//        System.out.println("state "+order.getState());
       
        updateUser.setInt(2, order.getId());
        updateUser.setString(1, order.getState());
       
        updateUser.executeUpdate();

    }
	
}
