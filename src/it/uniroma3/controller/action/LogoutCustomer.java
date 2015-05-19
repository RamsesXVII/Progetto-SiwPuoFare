package it.uniroma3.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogoutCustomer implements Action {

	public String perform(HttpServletRequest request) {		
		/*HttpSession s=request.getSession();
		s.invalidate();
		*/
		return "/index.jsp";
	}
	private boolean isLogged(HttpServletRequest request){
		return (request.getSession().getAttribute("currentCustomer")!=null);
	}
}
