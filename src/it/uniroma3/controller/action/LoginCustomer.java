package it.uniroma3.controller.action;

import java.security.NoSuchAlgorithmException;

import it.uniroma3.md5.Md5Generator;
import it.uniroma3.model.Customer;
import it.uniroma3.model.CustomerFacade;
import it.uniroma3.model.Product;
import it.uniroma3.model.ProductFacade;
import it.uniroma3.status.NotLoggedException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginCustomer implements Action {

	public String perform(HttpServletRequest request)
			throws NotLoggedException, NoSuchAlgorithmException {		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		CustomerFacade cf = new CustomerFacade();
		//se non esiste lascio che l'eccezione si propaghi
		Customer c=cf.retriveCustomerByEmail(email);
		Md5Generator m=new Md5Generator();
		password=m.md5Of(password);
		if(c.getPassword().equals(password)){
			HttpSession session= request.getSession();
			session.setAttribute("currentCustomer", c);
			if(c.getAdmin())
				session.setAttribute("admin", "yes");
			else
				session.setAttribute("admin", "no");
			return "/index.jsp";
		}else{
			throw new NotLoggedException();
		}
	}
}
