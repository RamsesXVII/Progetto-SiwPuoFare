package it.uniroma3.controller.action;

import it.uniroma3.controller.helper.HelperProduct;
import it.uniroma3.model.Product;
import it.uniroma3.model.ProductFacade;
import it.uniroma3.status.NotLoggedException;
import it.uniroma3.status.Status;

import javax.servlet.http.HttpServletRequest;

public class CreateProduct implements Action {

	public String perform(HttpServletRequest request) 
			throws NotLoggedException{
		
		Status s=new Status();
		s.isLogged(request,true);
		
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
			
			return "/product.jsp";
		} else
			return "/newProduct.jsp";
	}
}
