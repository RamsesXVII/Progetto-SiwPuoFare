package it.uniroma3.model;

import java.util.List;

import javax.persistence.*;


public class OrderFacade {
	private EntityManagerFactory emf;
	private EntityManager em;

	
	public boolean createOrder(Order o){
		
		
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
	public List<Product> retriveAllOrders(){
		
		this.openEntityManager();
		EntityTransaction tx=this.em.getTransaction();
		tx.begin();
		
		try{
			Query query = this.em.createNamedQuery("Orders.findAll");
			return query.getResultList();
		}catch(Exception e){
			tx.rollback();
			return null;
		}finally{
			tx.commit();
			this.closeEntityManager();
		}
	}

	public Order getOrder(Long id) {
		this.openEntityManager();
		
		EntityTransaction tx= this.em.getTransaction();
		tx.begin();
		try{
			Query query = this.em.createNamedQuery("Orders.findOrder");  //se è interrogazione molto rilevante per il dominio  usata spesso
			query.setParameter("id", id);			
			return (Order) query.getResultList().get(0);
	
		}catch(Exception e){
			tx.rollback();
			return null;
		}finally{
			tx.commit();
			this.closeEntityManager();}
	}
}
