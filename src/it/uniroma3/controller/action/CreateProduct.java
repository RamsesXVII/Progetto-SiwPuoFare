package it.uniroma3.controller.action;

import it.uniroma3.controller.helper.HelperProduct;
import it.uniroma3.model.Product;
import it.uniroma3.model.ProductFacade;

import javax.servlet.http.HttpServletRequest;

public class CreateProduct implements Action {

	public String perform(HttpServletRequest request) {
		
		HelperProduct helper = new HelperProduct();
		
		if (helper.isValid(request)) {
			String name = request.getParameter("name");
			String code = request.getParameter("code");
			Float price = Float.parseFloat(request.getParameter("price"));
			String description = request.getParameter("description");
			
			ProductFacade facade = new ProductFacade();
			Product p= new Product(name,description,price,code);
			facade.createProduct(p);
			request.setAttribute("product", p);
			
			return "/controller/product.list";
		} else
			return "/newProduct.jsp";
	}
}
