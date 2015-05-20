package it.uniroma3.status;

import javax.servlet.http.HttpServletRequest;

public class Status {
	public Status(){}
	public void isLogged(HttpServletRequest request) 
			throws NotLoggedException{
		if(request.getSession().getAttribute("currentCustomer")==null){
			throw new NotLoggedException();
		}
	}
}
