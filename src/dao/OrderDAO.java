package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Article;
import model.Order;
import tools.DBConnection;

/**
 * @author jason
 *
 */

public class OrderDAO extends BaseDAO<Order>{

	@Override
	public String getTableName() {

		return "orders";
	}
	
	
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

	public void insert(Order order) throws SQLException {
		var sql = "INSERT INTO " + getTableName() + "(`orderDate`,`state`,`idProvider`,`idAdministrator`) VALUES (?,?,?,?);"; // Don't insert ID, let database
																					// auto-increment it.

		var insertOrder = DBConnection.get().prepareStatement(sql);

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
}
