package it.uniroma3.controller.action;

import java.util.List;

import it.uniroma3.model.Order;
import it.uniroma3.model.OrderFacade;
import it.uniroma3.model.Product;
import it.uniroma3.model.ProductFacade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

//controller/prodcut.list
public class ListProduct implements Action {

	public String perform(HttpServletRequest request) {
		
		ProductFacade facade = new ProductFacade();
		List<Product> products = facade.retriveAllProducts();
		request.setAttribute("products", products);

		return "/products.jsp";
	}
}
