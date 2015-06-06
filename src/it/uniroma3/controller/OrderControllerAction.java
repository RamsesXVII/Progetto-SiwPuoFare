package it.uniroma3.controller;

import it.uniroma3.model.Customer;
import it.uniroma3.model.Order;
import it.uniroma3.model.Product;
import it.uniroma3.status.NotLoggedException;
import it.uniroma3.status.Status;

import java.util.HashMap;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class OrderControllerAction {

	public String addToOrder(Integer quantitaCorrente ) {
		HttpSession session = getSession();
		Product p=(Product)session.getAttribute("p1");
		Map<Product, Integer> carrelloInSessione=(Map<Product, Integer>)session.getAttribute("carrello");
		if(carrelloInSessione!=null){
			if(carrelloInSessione.containsKey(p)){
				carrelloInSessione.put(p, new Integer(quantitaCorrente+carrelloInSessione.get(p)));
			}else{
				carrelloInSessione.put(p,quantitaCorrente);
			}
			session.setAttribute("carrello", carrelloInSessione);
			
			Float totale=(Float)session.getAttribute("totaleVendita");
			totale += new Float(p.getPrice()*quantitaCorrente);
			session.setAttribute("totaleVendita", totale);
			
		}else{
			Map<Product, Integer> carrello=new HashMap<Product, Integer>();
			carrello.put(p, quantitaCorrente);
			session.setAttribute("carrello", carrello);
			session.setAttribute("totaleVendita", new Float(quantitaCorrente*p.getPrice()));
		}
		try{
			Status.isLogged(false);
		}catch(NotLoggedException e){
			return "notLogged";
		}
	
		return "carrello";
	}
	
	public static HttpSession getSession(){
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
		HttpSession httpSession = request.getSession(false);
		return httpSession;
	}

	public String confermaOrdine(OrderController o) {
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
		o.getOrderFacade().createOrder(carrelloInSessione,c);
		o.setOrders(o.getOrderFacade().getOrders(c.getId())); 
		session.removeAttribute("carrello");//TODO è necessario farlo x cambiare pagina??'
		return "orders";								//ggestire i login nei metodi leggengp i casi d'uso
		//gestire bottoni
	}

	public String listCustomerOrders(OrderController o) {
		try{
			Status.isLogged(false);
		}catch(NotLoggedException e){
			return "notLogged";
		}
		HttpSession session = getSession();
		o.setOrders(o.getOrderFacade().getOrders(((Customer)session.getAttribute("utenteCorrente")).getId()));
		return "orders";
	}

	public String getCustomerDetails(OrderController o) {
		try{
			Status.isLogged(true);
		}catch(NotLoggedException e){
			return "notLogged";
		}
		Order order=o.getOrderFacade().getOrder(o.getIdCorrente());
		Customer c=null;
		try{c=order.getCustomer();}catch(Exception e){c=null;}
		HttpSession session=getSession();
		session.setAttribute("searchedCustomer", c);
		return "customerDetails";
	}

}
