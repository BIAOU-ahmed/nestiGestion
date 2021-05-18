package model;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import dao.ArticleDAO;
import dao.OrderDAO;
import dao.OrderLineDAO;
import dao.ProductDAO;
import dao.SellDAO;

/**
 * 
 */
public class OrderLine {

	/**
	 * Default constructor
	 */
	public OrderLine() {
	}

	/**
	 * 
	 */
	private int amount;

	private int idArticle;
	private int idOrders;
	private int amountReceive;

	/**
	 * 
	 */
	private Date deliveryDate;

	public Order getOrder() {

		return (new OrderDAO()).find("idOrders", this.idOrders);

	}

	public Article getArticle() {

		return (new ArticleDAO()).find("idArticle", this.idArticle);

	}

	public Double getPrice() {
		double price = 0;
		Sell sell = new Sell();
		sell.setIdArticle(idArticle);
		sell.setIdProvider(getOrder().getIdProvider());
		(new SellDAO()).getSell(sell);
		price = sell.getPrice() * amount;
		return price;
	}

	/**
	 * @return the idArticle
	 */
	public int getIdArticle() {
		return idArticle;
	}

	/**
	 * @param idArticle the idArticle to set
	 */
	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}

	/**
	 * @return the idOrders
	 */
	public int getIdOrders() {
		return idOrders;
	}

	/**
	 * @param idOrders the idOrders to set
	 */
	public void setIdOrders(int idOrders) {
		this.idOrders = idOrders;
	}

	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * @return the amountReceive
	 */
	public int getAmountReceive() {
		return amountReceive;
	}

	/**
	 * @param amountReceive the amountReceive to set
	 */
	public void setAmountReceive(int amountReceive) {
		this.amountReceive = amountReceive;
	}

	/**
	 * @return the deliveryDate
	 */
	public Date getDeliveryDate() {
		return deliveryDate;
	}

	/**
	 * @param deliveryDate the deliveryDate to set
	 */
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public void create() {
		OrderLine orderLine = new OrderLine();
		orderLine.setIdArticle(idArticle);
		orderLine.setIdOrders(idOrders);
		orderLine.setAmount(amount);

		try {
			(new OrderLineDAO()).insert(orderLine);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update() {
		OrderLine orderLine = new OrderLine();
		orderLine.setIdArticle(idArticle);
		orderLine.setIdOrders(idOrders);
		orderLine.setAmount(amount);
		orderLine.setAmountReceive(amountReceive);
		orderLine.setDeliveryDate(deliveryDate);

//		System.out.println("orderLine idArt"+orderLine.getIdArticle());
//		System.out.println("orderLine idOrder"+orderLine.getIdOrders());
//		System.out.println("orderLine amount"+orderLine.getAmount());
		try {
			(new OrderLineDAO()).update(orderLine);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Object[] toRow() {

		Object[] orderLine = {
				getArticle().getId(), getArticle().getConditioning().getConditioningName() + " de "
						+ getArticle().getAmount() + " " + getArticle().getProduct().getProductName(),
				getAmount(), getAmountReceive(), getPrice() };
		return orderLine;
	}

	public Object[] toRowForDelevery() {
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String deleveryDate = null;
		if(getDeliveryDate() != null) {
			deleveryDate=formatter.format(getDeliveryDate());
		}
		Object[] orderLine = { getArticle().getId(),
				getArticle().getConditioning().getConditioningName() + " de " + getArticle().getAmount() + " "
						+ getArticle().getProduct().getProductName(),
				getAmount(), getAmountReceive(), getPrice(), formatter.format(getOrder().getOrderDate()),
				deleveryDate};
		return orderLine;
	}

	public Object[] toRow2() {

		Object[] orderLine = {
				getArticle().getId(), getArticle().getConditioning().getConditioningName() + " de "
						+ getArticle().getAmount() + " " + getArticle().getProduct().getProductName(),
				getAmount(), getPrice() };
		return orderLine;
	}
}