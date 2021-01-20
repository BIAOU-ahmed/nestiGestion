package model;


import java.sql.SQLException;
import java.util.*;
import dao.OrderDAO;

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
    }

    public int getIdAdministrator() {
		return idAdministrator;
	}

	public void setIdAdministrator(int idAdministrator) {
		this.idAdministrator = idAdministrator;
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

	public void setState(String state) {
		this.state = state;
	}

	public void create() {
		Order order = new Order();
		order.setOrderDate(getOrderDate());
		order.setState(getState());
		order.setIdProvider(getIdProvider());
		order.setIdAdministrator(getIdAdministrator());
	
		try {
			(new OrderDAO()).insert(order);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




}