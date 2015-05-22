package it.uniroma3.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;
public class CommerceMain {
	
	public static void main(String[] args) {
//	CustomerFacade cf = new CustomerFacade();
//	cf.createCustomer("mattia", "iodice", "mattia.iodice@yahoo.it", "password", "11/11/1992", "street", "citta", "stato", "zipcode", "country");
	EntityManagerFactory emf= Persistence.createEntityManagerFactory("commerce-unit");
	EntityManager em= emf.createEntityManager();
	EntityTransaction tx=em.getTransaction();
	tx.begin();
	Customer c=em.find(Customer.class, new Long(1));
	Order o= new Order();
	o.setCreationTime(new Date());
	o.setCustomer(c);
	o.setStato("nonspedito");
	OrderLine ol= new OrderLine();
	ol.setProduct(em.find(Product.class, new Long(101)));
	ol.setQuantity(new Integer(2));
	ol.setUnitPrice(new Float(2));
	OrderLine oll= new OrderLine();
	oll.setProduct(em.find(Product.class, new Long(151)));
	oll.setQuantity(new Integer(3));
	oll.setUnitPrice(new Float(3));
	List<OrderLine>list= new LinkedList<OrderLine>();
	list.add(ol);
	list.add(oll);
	o.setOrderLines(list);
	em.persist(o);
//////	Query query=em.createNamedQuery("trovaOrdini");
//////	List<Order>l=query.getResultList();
	
//	em.find(Product.class, new Long(101)).setQuantity(new Integer(100));
//	em.find(Product.class, new Long(151)).setQuantity(new Integer(100));
//	em.find(Product.class, new Long(201)).setQuantity(new Integer(100));


	tx.commit();
	em.close();
	emf.close();
//	for(Order o:l)
//		System.out.println(o.getStato());
		
//		ProductFacade pf=new ProductFacade();
//		pf.createProduct(new Product("penna", "una Penna", new Float(2), "p1"));
//		pf.createProduct(new Product("cd", "un cd", new Float(3), "c1"));
//		pf.createProduct(new Product("astuccio", "un astuccio", new Float(13), "a1"));

	//	OrderFacade of= new OrderFacade();
	//	System.out.println(of.getOrderLines(new Long(201)).size());

//	OrderFacade of= new OrderFacade();
//	of.validateOrder(new Long(251));
	
	
	}
}
