package it.uniroma3.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogoutCustomer implements Action {

	public String perform(HttpServletRequest request) {		
		HttpSession session = request.getSession();
		session.invalidate();
		return "/index.jsp";
	}
}
