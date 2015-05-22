package it.uniroma3.model;

import it.uniroma3.md5.Md5Generator;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
public class CommerceMain {
	
	public static void main(String[] args) throws Exception {
		CustomerFacade cf=new CustomerFacade();
		cf.createCustomer("nome_user", "cognome_user", "user", "user", "19/12/1993", "v", "x", "y", "w", "z", false);
		//Md5Generator m=new Md5Generator();
		//System.out.println(m.md5Of("b"));
//		Order o=new Order();
//		o.setCreationTime(new Date());
//		o.setCustomer(cf.retriveCustomerByEmail("e1"));
//		OrderFacade of=new OrderFacade();
//		of.createOrder(o);
	}
}
