package it.uniroma3.controller.action;
import java.util.*;

import it.uniroma3.model.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class GetOrderLines implements Action{

	@Override
	public String perform(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Long id = Long.parseLong(request.getParameter("idOrder"));
		OrderFacade o= new OrderFacade();
		Order l = o.getOrder(id); 
		session.setAttribute("orls", l.getOrderLines());
		return "/printOrderLines.jsp";
		
	}
	

}
