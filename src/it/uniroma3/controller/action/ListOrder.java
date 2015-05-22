package it.uniroma3.controller.action;

import java.util.List;

import it.uniroma3.model.Order;
import it.uniroma3.model.OrderFacade;

import javax.servlet.http.HttpServletRequest;

public class ListOrder implements Action{

	@Override
	public String perform(HttpServletRequest request) {
		OrderFacade o = new OrderFacade();
		List<Order> list=o.getOrderToSend();
		request.setAttribute("ordini", list);
		return "/mostraOrdiniDaInviare.jsp";
	}

}
