package it.uniroma3.controller.action;

import it.uniroma3.controller.helper.HelperProductId;
import it.uniroma3.model.Product;
import it.uniroma3.model.ProductFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class GetOrderLine implements Action{

	@Override
	public String perform(HttpServletRequest request) {
		HelperProductId helper = new HelperProductId();

		if (helper.isValid(request)) {
			Long id = Long.parseLong(request.getParameter("id"));

			ProductFacade facade = new ProductFacade();
			Product product = facade.getProduct(id);
			HttpSession session = request.getSession();
			session.setAttribute("product", product);			
			return "/productDescription.jsp";
		} else
			return "/invalid.jsp";
	}

}
