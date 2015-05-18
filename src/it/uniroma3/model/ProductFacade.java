package it.uniroma3.model;

import java.util.List;

import javax.persistence.*;


public class ProductFacade {
	private EntityManagerFactory emf;
	private EntityManager em;

	
	public boolean createProduct(Product p){
		

		this.openEntityManager();
		EntityTransaction tx=this.em.getTransaction();
		
		tx.begin();
		em.persist(p);
		tx.commit();
	
		
		this.closeEntityManager();
		return true;
		
	}
	
	public List<Provider> retrieveProviders(Long id){
		this.openEntityManager();
		EntityTransaction tx=this.em.getTransaction();
		tx.begin();
		try{
			Query ricercaFornitori = this.em.createNamedQuery("findAllProviders");  
			ricercaFornitori.setParameter("id", new Long(id));
			return ricercaFornitori.getResultList();
		}catch(Exception e){
			tx.rollback();
			return null;
		}finally{
			tx.commit();
			this.closeEntityManager();}
	}

	public void openEntityManager(){
		this.emf= Persistence.createEntityManagerFactory("commerce-unit");
		this.em= emf.createEntityManager();
	}
	
	public void closeEntityManager(){
		this.em.close();
		this.emf.close();
	}
	public List<Product> retriveAllProducts(){
		
		this.openEntityManager();
		EntityTransaction tx=this.em.getTransaction();
		tx.begin();
		
		try{
			Query query = this.em.createNamedQuery("Products.findAll");
			return query.getResultList();
		}catch(Exception e){
			tx.rollback();
			return null;
		}finally{
			tx.commit();
			this.closeEntityManager();
		}
	}

	public Product getProduct(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
