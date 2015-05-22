package it.uniroma3.model;

import java.util.List;

import javax.persistence.*;
public class CommerceMain {
	
	public static void main(String[] args) {
//		CustomerFacade c = new CustomerFacade();
//		Customer cu=(Customer)c.retriveCustomerByEmail("a");
//		System.out.println(cu.getOrders().size());
//		OrderFacade of= new OrderFacade();
//		List<Order> orders=of.getOrders(new Long(3232));
//		cu.setOrders(orders);
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("commerce-unit");
		EntityManager em= emf.createEntityManager();
		EntityTransaction tx= em.getTransaction();
		tx.begin();
		
	//	Address o=new Address("eqw","ew","rwqe","rew","wer");
		Customer c = new Customer("mario", "rossi", "m", "r", "02/04/13");
		
		c.setAmministratore(true);
		em.persist(c);
		tx.commit();
		em.close();
		emf.close();
	}
}
