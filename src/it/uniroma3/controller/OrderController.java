package it.uniroma3.controller;

import java.util.Date;
import java.util.List;

import it.uniroma3.model.Order;
import it.uniroma3.model.OrderFacade;
import it.uniroma3.model.ProductFacade;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;


@ManagedBean
public class OrderController {
	
	@ManagedProperty(value="#{param.id}")
	private Long id;
	private Date creationTime;
	private String stato;
	private Date dataSpedizione;
	private Order order;
	private String customerEmail;
	private List<Order> orders;

	
	@EJB
	private OrderFacade orderFacade;
	
	public String createOrder() {
		this.order = orderFacade.createOrder(customerEmail);
		return "order"; 
	}
	
	public String listOrders() {
		this.orders = orderFacade.getAllOrders();
		return "orders"; 
	}

	public String findOrder() {
		this.order = orderFacade.getOrder(id);
		return "product";
	}
	
	public String findOrder(Long id) {
		this.order = orderFacade.getOrder(id);
		return "product";
	}
	
	public String listOrdersToSend(){
		this.orders=orderFacade.getOrdersToSend();
		return "orders";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public Date getDataSpedizione() {
		return dataSpedizione;
	}

	public void setDataSpedizione(Date dataSpedizione) {
		this.dataSpedizione = dataSpedizione;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public OrderFacade getOrderFacade() {
		return orderFacade;
	}

	public void setOrderFacade(OrderFacade orderFacade) {
		this.orderFacade = orderFacade;
	}

	public String sendOrder(){
		this.order= orderFacade.sendOrder(id);
		return "order";
	}
	public String listOrderLines(){
		return "orderLines";
	}

}



