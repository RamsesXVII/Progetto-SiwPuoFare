package it.uniroma3.controller.action;

import it.uniroma3.controller.helper.HelperProductId;
import it.uniroma3.model.OrderFacade;
import it.uniroma3.model.Product;
import it.uniroma3.model.ProductFacade;

import javax.servlet.http.HttpServletRequest;

public class GetOrderlines implements Action {

	public String perform(HttpServletRequest request) {
		
	
			Long id = Long.parseLong(request.getParameter("id"));	
			OrderFacade facade = new OrderFacade();
			request.setAttribute("orderLines", facade.getOrderLines(id));
			request.setAttribute("id", id);
			return "/orderlines.jsp";
		
	}
}
