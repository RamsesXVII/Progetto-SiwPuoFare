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

	public String sendOrder(){
		this.order= orderFacade.sendOrder(id);
		return "order";
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
		//this
		return "carrello";
	}
	public String addToOrder(){
		try{
			Status.isLogged(false);
		}catch(NotLoggedException e){
			return "notLogged";
		}
		HttpSession session=getSession();
		Product p=(Product)session.getAttribute("p1");
		Map<Product, Integer> carrelloInSessione=(Map<Product, Integer>)session.getAttribute("carrello");
		if(carrelloInSessione!=null){
			if(carrelloInSessione.containsKey(p)){
				carrelloInSessione.put(p, new Integer(this.quantitaCorrente+carrelloInSessione.get(p)));
			}else{
				carrelloInSessione.put(p,this.quantitaCorrente);
			}
			session.setAttribute("carrello", carrelloInSessione);
		}else{
			Map<Product, Integer> carrello=new HashMap<Product, Integer>();
			carrello.put(p, this.quantitaCorrente);
			session.setAttribute("carrello", carrello);
		}
		return "carrello";
	}
	public static HttpSession getSession(){
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
		HttpSession httpSession = request.getSession(false);
		return httpSession;
	}

	public Integer getQuantitaCorrente() {
		return quantitaCorrente;
	}

	public void setQuantitaCorrente(Integer quantitaCorrente) {
		this.quantitaCorrente = quantitaCorrente;
	}
	public String confermaOrdine() {
		try{
			Status.isLogged(false);
		}catch(NotLoggedException e){
			return "notLogged";
		}
		HttpSession session=getSession();
		Map<Product, Integer> carrelloInSessione=(Map<Product, Integer>)session.getAttribute("carrello");
		Customer c=(Customer)session.getAttribute("utenteCorrente");
		if(carrelloInSessione==null)
			return "prodotti";
		orderFacade.createOrder(carrelloInSessione,c);
		return "orders";
	}

	public String findOrders(){
		HttpSession session = getSession();
		this.orders =this.orderFacade.getOrders(((Customer)session.getAttribute("utenteCorrente")).getId());
		return "ordersOfCustomer";
	}
	public String getCustomerDetails(){
		Order o=orderFacade.getOrder(this.idCorrente);
		Customer c=null;
		try{c=o.getCustomer();}catch(Exception e){c=null;}
		HttpSession session=getSession();
		session.setAttribute("searchedCustomer", c);
		return "customerDetails";
	}

	public Long getIdCorrente() {
		return idCorrente;
	}

	public void setIdCorrente(Long idCorrente) {
		this.idCorrente = idCorrente;
	}
}



