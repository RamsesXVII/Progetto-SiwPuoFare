package it.uniroma3.controller.action;

import java.util.*;

import it.uniroma3.model.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CreateOrderline implements Action{

	@Override
	public String perform(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		//Long id =((Product)session.getAttribute("product")).getId();
		
		//ProductFacade facade = new ProductFacade();
		Product product = (Product)session.getAttribute("product");	
		OrderLine o = new OrderLine();
		o.setProduct(product);
		o.setQuantity((Integer.parseInt(request.getParameter("quantita"))));
		o.setUnitPrice(product.getPrice());
		List <OrderLine> orderlines = new LinkedList<OrderLine>();
		orderlines.add(o);
		
		if(session.getAttribute("listOrderLines")!=null)
			orderlines.addAll((List<OrderLine>)session.getAttribute("listOrderLines"));
		
		session.setAttribute("listOrderLines", orderlines);
		return "/controller/product.list";
	}
}
