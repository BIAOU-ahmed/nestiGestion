package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Article;
import model.Order;
import model.OrderLine;
import model.Product;
import tools.DBConnection;

/**
 * @author jason
 *
 */

public class OrderLineDAO extends BaseDAO<OrderLine>{

	@Override
	public String getTableName() {

		return "order_line";
	}
	
	
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

	public void insert(OrderLine orderLine) throws SQLException {
		var sql = "INSERT INTO " + getTableName() + "(`idArticle`,`idOrders`,`amount`) VALUES (?,?,?);"; // Don't insert ID, let database
																					// auto-increment it.

		var insertOrderLine = DBConnection.get().prepareStatement(sql);

//		System.out.println("admin "+article.getIdAdministrator());
//		System.out.println("product "+article.getIdProduct());
//		System.out.println("condi "+article.getIdConditioning());
		insertOrderLine.setInt(1, orderLine.getIdArticle());
		insertOrderLine.setInt(2, orderLine.getIdOrders());
		insertOrderLine.setInt(3, orderLine.getAmount());
		

		insertOrderLine.executeUpdate();
		

//		return order;

	}
	
	public  void update (OrderLine line) throws SQLException {
        String sql = "UPDATE " + getTableName()
			+ " SET amount = ?, amountReceive = ?,deliveryDate =? "
			+ "WHERE idArticle = ? AND idOrders = ? ;";

        var updateUser = DBConnection.get().prepareStatement(sql);
        
        System.out.println("orderLine idArt"+line.getIdArticle());
		System.out.println("orderLine idOrder"+line.getIdOrders());
		System.out.println("orderLine amount"+line.getAmount());
        updateUser.setInt(1,  line.getAmount());
        updateUser.setInt(2,  line.getAmountReceive());
        updateUser.setDate(3, (Date) line.getDeliveryDate());
        updateUser.setInt(4,  line.getIdArticle());
        updateUser.setInt(5,  line.getIdOrders());
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
