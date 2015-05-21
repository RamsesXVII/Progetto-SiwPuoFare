package it.uniroma3.model;

import java.util.List;

import javax.persistence.*;


public class OrderFacade {
	private EntityManagerFactory emf;
	private EntityManager em;



	public List<OrderLine> getOrderLines(Long id){
		this.openEntityManager();
		
		EntityTransaction tx= this.em.getTransaction();
		tx.begin();
		try{
			Order o= em.find(Order.class,id);
			return o.getOrderLines();
	
		}catch(Exception e){
			tx.rollback();
			return null;
		}finally{
			tx.commit();
			this.closeEntityManager();}
		
		
		
		
	}
	
	
	public List<Order> retriveAllOrders(){
		
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
	
	public List<Order> retriveAllNoSentOrders(){
		
		this.openEntityManager();
		EntityTransaction tx=this.em.getTransaction();
		tx.begin();
		
		try{
			Query query = this.em.createNamedQuery("Order.findAllNoSent");
			return query.getResultList(); //TODO cosa succede se è vuoto???
		}catch(Exception e){
			tx.rollback();
			return null;
		}finally{
			tx.commit();
			this.closeEntityManager();
		}
	}
	
	public boolean validateOrder(Long id){
		
		this.openEntityManager();
		EntityTransaction tx=this.em.getTransaction();
		tx.begin();
		
		try{
			Order o=em.find(Order.class,id);
			o.complete();
			return true;
		}catch(Exception e){
			tx.rollback();
			return false;
		}finally{
			tx.commit();
			this.closeEntityManager();
		}
	}

	public void openEntityManager(){
		this.emf= Persistence.createEntityManagerFactory("commerce-unit");
		this.em= emf.createEntityManager();
	}
	
	public void closeEntityManager(){
		this.em.close();
		this.emf.close();
	}
}
