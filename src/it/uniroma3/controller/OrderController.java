package it.uniroma3.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import it.uniroma3.model.Customer;
import it.uniroma3.model.Order;
import it.uniroma3.model.OrderFacade;
import it.uniroma3.model.Product;
import it.uniroma3.model.ProductFacade;
import it.uniroma3.status.NotLoggedException;
import it.uniroma3.status.Status;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@ManagedBean
public class OrderController {

	@ManagedProperty(value="#{param.id}")
	private Long id;
	private Long idCorrente;
	private Date creationTime;
	private String stato;
	private Date dataSpedizione;
	private Order order;
	private String customerEmail;
	private List<Order> orders;
	private Integer quantitaCorrente;


	@EJB
	private OrderFacade orderFacade;
	private ProductFacade productFacade;

	public String createOrder() {
		this.order = orderFacade.createOrder(customerEmail);
		return "order"; 
	}

	public String listOrders() {
		this.orders = orderFacade.getAllOrders();
		return "orders"; 
	}
	public String listAllOrders() {
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

	public String listOrder(){
		this.order=orderFacade.getOrder(id);
		return "order";
	}
	
	public String sendOrder(){
		this.order= orderFacade.sendOrder(id);
		this.orders = orderFacade.getOrdersToSend();
		return "orders";
	}
	public String listOrderLines(){
		return "orderLines";
	}
	public ProductFacade getProductFacade() {
		return productFacade;
	}

	public void setProductFacade(ProductFacade productFacade) {
		this.productFacade = productFacade;
	}
	public String carrello() {
		return "carrello";
	}
	
	public String addToOrder(){
		OrderControllerAction o = new OrderControllerAction();
		return o.addToOrder(quantitaCorrente);
	}
	
	public Integer getQuantitaCorrente() {
		return quantitaCorrente;
	}

	public void setQuantitaCorrente(Integer quantitaCorrente) {
		this.quantitaCorrente = quantitaCorrente;
	}
	public String confermaOrdine() {
		OrderControllerAction o = new OrderControllerAction();
		return o.confermaOrdine(this);
	}

	public String listCustomerOrders(){
		OrderControllerAction o = new OrderControllerAction();
		return o.listCustomerOrders(this);
	}
	public String getCustomerDetails(){
		OrderControllerAction o = new OrderControllerAction();
		return o.getCustomerDetails(this);
	}

	public Long getIdCorrente() {
		return idCorrente;
	}

	public void setIdCorrente(Long idCorrente) {
		this.idCorrente = idCorrente;
	}
	
	public static HttpSession getSession(){
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
		HttpSession httpSession = request.getSession(false);
		return httpSession;
	}

	public String removeProdotto(Product p){
		HttpSession session = getSession();
		Map<Product, Integer> c2 = (Map<Product, Integer>) session.getAttribute("carrello");
		c2.remove(p);
		session.removeAttribute("carrello");
		session.setAttribute("carrello", c2);
		return "carrello";
	}
}



