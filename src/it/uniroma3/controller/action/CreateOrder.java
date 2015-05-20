package it.uniroma3.controller.action;

import it.uniroma3.model.*;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CreateOrder implements Action{

	@Override
	public String perform(HttpServletRequest request) {
		HttpSession session = request.getSession();

		//se è loggato (altrimenti string a login)
		if((Customer)session.getAttribute("currentCustomer")!=null){
			List<OrderLine> orderlines = ((List<OrderLine>)session.getAttribute("listOrderLines"));

			Order o = new Order(new Date());
			
			o.setOrderLines(orderlines);
			o.setCustomer((Customer)session.getAttribute("currentCustomer"));
			
			OrderFacade of= new OrderFacade();
			of.createOrder(o);
			session.invalidate();
			return "/completato.jsp";
		}
		return "/notLogged.jsp";
	}
}
