package model;

import java.sql.Date;
import java.sql.SQLException;
import java.util.*;

import dao.AdministratorDAO;
import dao.ConditioningDAO;
import dao.OrderDAO;
import dao.OrderLineDAO;
import dao.ProviderDAO;
import dao.SellDAO;

/**
 * 
 */
public class Order {

	/**
	 * Default constructor
	 */

	private int idAdministrator;
	private int idProvider;

	/**
	 * 
	 */
	public int id;

	
	/**
	 * 
	 */
	public Date orderDate;

	/**
	 * 
	 */
	public String state;

	public Order() {
		java.util.Date sqlDate = new java.util.Date();
//		Date createDate = new Date(sqlDate.getTime());
		setOrderDate(new Date(sqlDate.getTime()));
	}

	Double price = 0.0;

	public Double getPrice() {
		var allOrderLine = (new OrderLineDAO()).findALLBy("idOrders", getId());

		allOrderLine.forEach(OrderLine -> {

			price += OrderLine.getPrice();
		});

		return price;
	}

	public void setProviderFromName(String providerName) {
		var provider = (new ProviderDAO()).find("compagnyName", providerName);
		this.idProvider = provider.getId();
	}

	public int getIdAdministrator() {
		return idAdministrator;
	}

	public void setIdAdministrator(int idAdministrator) {
		this.idAdministrator = idAdministrator;
	}

	public Provider getProvider() {

		return (new ProviderDAO()).find("idProvider", this.idProvider);
	}

	public int getIdProvider() {
		return idProvider;
	}

	public void setIdProvider(int idProvider) {
		this.idProvider = idProvider;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getState() {
		return state;
	}

	boolean isAllDelevery = true;
	String displayState = "En cours";

	public String getDisplayState() {

		var allOrderLine = (new OrderLineDAO()).findALLBy("idOrders", getId());

		allOrderLine.forEach(OrderLine -> {
			if (OrderLine.getDeliveryDate() == null) {
				isAllDelevery = false;
			}

		});
		if (isAllDelevery) {
			displayState = "Reçue";
		}
		
//		System.out.println("state in order"+displayState);
		return displayState;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void create(Order cretedOrder) {
		Order order = new Order();
		order.setOrderDate(getOrderDate());
		order.setState(getState());
		order.setIdProvider(getIdProvider());
		order.setIdAdministrator(getIdAdministrator());

		try {
			(new OrderDAO()).insert(order);
			cretedOrder.setId(order.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Object[] toRow() {

		Object[] order = { getId(), getProvider().getCompanyName(), getPrice(), getOrderDate(), " date livr ",
				getDisplayState() };
		return order;
	}

}