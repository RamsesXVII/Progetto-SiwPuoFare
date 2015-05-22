package it.uniroma3.controller.action;

import it.uniroma3.controller.helper.HelperProduct;
import it.uniroma3.model.Address;
import it.uniroma3.model.Customer;
import it.uniroma3.model.Order;
import it.uniroma3.model.OrderFacade;
import it.uniroma3.status.*;

import javax.servlet.http.HttpServletRequest;

public class GetaddressCustomer implements Action {

	public String perform(HttpServletRequest request) throws NotLoggedException{
		
		Status s=new Status();
		s.isLogged(request,true);
		
		Long orderId = Long.parseLong(request.getParameter("orderId"));
		OrderFacade of=new OrderFacade();
		Order o=(Order) of.getOrder(orderId);
		
		Customer c=o.getCustomer();
		request.setAttribute("requestedCustomer", ("Customer: "+c.getFirstName()+" "+c.getLastName()));
		
		Address a=c.getAddress();
		request.setAttribute("requestedAddress", ("Address: "+a.toString()));
		
		return "/customerDescription.jsp";
	}
}
