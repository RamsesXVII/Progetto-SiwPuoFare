package it.uniroma3.status;

import it.uniroma3.model.Customer;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Status {
	public static void isLogged(boolean admin) throws NotLoggedException{
		HttpSession session=getSession();
		Customer c=(Customer)session.getAttribute("utenteCorrente");
		if(c==null){
			throw new NotLoggedException();
		}
		if(admin){
			if(!(c.getAdmin()).booleanValue())
				throw new NotLoggedException();				
		}
	}
	public static HttpSession getSession(){
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
		HttpSession httpSession = request.getSession(false);
		return httpSession;
	}
}
