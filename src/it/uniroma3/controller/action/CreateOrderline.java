package it.uniroma3.controller.action;

import java.util.*;

import it.uniroma3.model.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CreateOrderline implements Action{

	@Override
	public String perform(HttpServletRequest request) {
		Long id = Long.parseLong(request.getParameter("id"));
		
		ProductFacade facade = new ProductFacade();
		Product product = facade.getProduct(id);	
		OrderLine o = new OrderLine();
		o.setProduct(product);
		o.setQuantity((Integer.parseInt(request.getParameter("quantita"))));
		o.setUnitPrice(product.getPrice());
		List <OrderLine> orderlines = new LinkedList<OrderLine>();
		HttpSession session = request.getSession();
		
		if(session.getAttribute("listOrderLines")!=null)
			orderlines.addAll((List<OrderLine>)session.getAttribute("listOrderLines"));
		
		orderlines.add(o);
		session.setAttribute("listOrderLines", orderlines);
		return "/controller/product.list";
	}
}
