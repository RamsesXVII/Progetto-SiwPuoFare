package it.uniroma3.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class OrderFacade {
	private EntityManagerFactory emf;
	private EntityManager em;


	public boolean createOrder(Order o) {
		this.openEntityManager();
		EntityTransaction tx=this.em.getTransaction();		
		tx.begin();
		em.persist(o);
		tx.commit();
		
		this.closeEntityManager();
		return true;

	}
	
	public void openEntityManager(){
		this.emf= Persistence.createEntityManagerFactory("commerce-unit");
		this.em= emf.createEntityManager();
	}
	
	public void closeEntityManager(){
		this.em.close();
		this.emf.close();
	}

	public List<Order> getOrders(Long customerID) {
		// TODO Auto-generated method stub
		return null;
	}

}