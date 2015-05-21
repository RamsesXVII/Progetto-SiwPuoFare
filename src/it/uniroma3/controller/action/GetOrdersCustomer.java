package it.uniroma3.controller.action;

import java.util.*;

import it.uniroma3.model.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class GetOrdersCustomer implements Action{

	@Override
	public String perform(HttpServletRequest request) {
		HttpSession session = request.getSession();
		OrderFacade facade = new OrderFacade();
		Long id = (Long)((Customer)session.getAttribute("currentCustomer")).getId();
		List<Order> orders = facade.getOrders(id);
		session.setAttribute("orders",orders);
		return "/visualizzaOrdini.jsp";
	}
}
