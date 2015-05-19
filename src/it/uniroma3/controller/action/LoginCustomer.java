package it.uniroma3.controller.action;

import it.uniroma3.model.Customer;
import it.uniroma3.model.CustomerFacade;
import it.uniroma3.model.Product;
import it.uniroma3.model.ProductFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginCustomer implements Action {

	public String perform(HttpServletRequest request) {		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		CustomerFacade cf = new CustomerFacade();
		Customer c;
		try{
			c=cf.retriveCustomerByEmail(email);
		}catch(Exception e){
			return "/login.jsp";
		}
		if(c.getPassword().equals(password)){
			HttpSession session= request.getSession();
			session.setAttribute("currentCustomer", c);
			return "/index.jsp";
		}
		return "/login.jsp";
	}
	private boolean isLogged(HttpServletRequest request){
		return (request.getSession().getAttribute("currentCustomer")!=null);
	}
}
