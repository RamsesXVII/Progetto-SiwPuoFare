package it.uniroma3.controller.action;

import it.uniroma3.controller.helper.HelperProductId;
import it.uniroma3.model.OrderFacade;
import it.uniroma3.model.Product;
import it.uniroma3.model.ProductFacade;

import javax.servlet.http.HttpServletRequest;

public class ValidateOrder implements Action {

	public String perform(HttpServletRequest request) {
			Long id = Long.parseLong(request.getParameter("id"));
	
			OrderFacade of=new OrderFacade();
			of.validateOrder(id);
			return "/controller/ordertosent.list";
		
	}
}
