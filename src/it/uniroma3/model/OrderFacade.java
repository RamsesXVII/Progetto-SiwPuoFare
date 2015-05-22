package it.uniroma3.model;

import java.util.Date;
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
			
			Product p;
			Order o=em.find(Order.class,id);
			o.setShipmentDate(new Date());
			o.setStato("spedito");
			for(OrderLine ol:o.getOrderLines()){
				p=ol.getProduct();
				Product c=em.find(Product.class, new Long(p.getId()));
				c.setQuantity(new Integer(9));
		//		p.getQuantity();
		//		p.setQuantity(new Integer(21));
				}
		//	o.complete();	
		//	for(OrderLine ol:o.getOrderLines())
		//		ol.getProduct().se
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
