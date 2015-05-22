package it.uniroma3.status;

import it.uniroma3.model.Customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Status {
	public Status(){}
	public void isLogged(HttpServletRequest request, boolean admin) 
			throws NotLoggedException{
		Customer c=(Customer)request.getSession().getAttribute("currentCustomer");
		if(c==null){
			throw new NotLoggedException();
		}
		if(admin){
			if(!(c.getAdmin()))
				throw new NotLoggedException();				
		}
	}
}
