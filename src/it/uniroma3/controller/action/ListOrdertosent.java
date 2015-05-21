package it.uniroma3.controller.action;

import it.uniroma3.model.OrderFacade;

import javax.servlet.http.HttpServletRequest;

public class ListOrdertosent implements Action {

	public String perform(HttpServletRequest request) {
		OrderFacade of= new OrderFacade();
		request.setAttribute("ordersnosent", of.retriveAllNoSentOrders());
		return "/orderstosend.jsp";
	}
}
