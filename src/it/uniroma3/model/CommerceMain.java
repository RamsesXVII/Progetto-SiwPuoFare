package it.uniroma3.model;

import java.util.List;

import javax.persistence.*;
public class CommerceMain {
	
	public static void main(String[] args) {
		ProductFacade pf= new ProductFacade();
		List<Provider>lp=pf.retrieveProviders(new Long(2751));
		System.out.println(lp.size());
		
		
		CustomerFacade cf= new CustomerFacade();
		List<Order>orders=cf.getOrders(new Long(2601));
		System.out.println(orders.size());
		cf.createCustomer("paolo", "rossini", "jj@@", "11/11/2000", "via", "rom", "stato", "78", "it");


	}
}
