package it.uniroma3.controller.action;

import it.uniroma3.model.*;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class RemoveOrderLine implements Action{

	@Override
	public String perform(HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<OrderLine> orderLines = (List<OrderLine>)session.getAttribute("listOrderLines");
		Long id = Long.parseLong(request.getParameter("idOrderLine"));
		String s=null;
		for(OrderLine o : orderLines){
			  if(o!=null && o.getProduct().getId().equals(id)){
				  orderLines.remove(o);
				  if(orderLines.size()==0){
						s="/controller/product.list";
					}
				  else s="/OrderLines.jsp";
			  }
		}
		return s;
	}

}
