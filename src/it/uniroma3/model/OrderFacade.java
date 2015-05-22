package it.uniroma3.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

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
		this.openEntityManager();
		EntityTransaction tx=this.em.getTransaction();
		tx.begin();
		
		try{
			Query query = this.em.createNamedQuery("trovaOrdini");
			query.setParameter("id", customerID);			
			return query.getResultList();
		}catch(Exception e){
			tx.rollback();
			return null;
		}finally{
			tx.commit();
			this.closeEntityManager();
		}
	}

	public Order getOrder(Long IdOrder) {
		this.openEntityManager();
		EntityTransaction tx=this.em.getTransaction();
		tx.begin();
		
		try{
			Query query = this.em.createNamedQuery("OrderFromId.findAll");
			query.setParameter("id", IdOrder);			
			return (Order)query.getResultList().get(0);
		}catch(Exception e){
			tx.rollback();
			return null;
		}finally{
			tx.commit();
			this.closeEntityManager();
		}
	}

	public List<Order> getOrderToSend() {
		this.openEntityManager();
		EntityTransaction tx=this.em.getTransaction();
		tx.begin();
		
		try{
			Query query = this.em.createNamedQuery("Order.findAll");
			return query.getResultList();
		}catch(Exception e){
			tx.rollback();
			return null;
		}finally{
			tx.commit();
			this.closeEntityManager();
		}
	}
}