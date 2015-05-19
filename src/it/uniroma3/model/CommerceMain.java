package it.uniroma3.model;

import java.util.List;

import javax.persistence.*;
public class CommerceMain {
	
	public static void main(String[] args) {
<<<<<<< HEAD
		CustomerFacade cf=new CustomerFacade();
		//cf.createCustomer("a", "b", "a", "password", "10/10/2010", "a", "a", "a", "a", "a");
		String a="";
		System.out.println(a!="" && a!=null);
=======
		 ProductFacade pf= new ProductFacade();
		 System.out.println(pf.getProduct(new Long(4351)).getName());
>>>>>>> e4b7a9f9013b31467f74760e2307c31de0236baa
	}
}
