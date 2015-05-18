package it.uniroma3.model;

import java.util.*;

import javax.persistence.*;


public class CustomerFacade {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public CustomerFacade(){
		
	}
	
	public void createCustomer(String firstName, String lastName, String email, String dateOfBirth,
			String street, String city, String state, String zipcode, String country){
		
		Customer c1=new Customer(firstName, lastName, email, dateOfBirth);
		Address a= new Address(street, city, state, zipcode, country);
		c1.setAddress(a);
		
		this.openEntityManager();
		EntityTransaction tx=this.em.getTransaction();
		
		tx.begin();
		em.persist(c1);
		tx.commit();
		
		this.closeEntityManager();
		
		
	}
	
	public List<Customer> retriveAllCustomer(){
		
		this.openEntityManager();
		EntityTransaction tx=this.em.getTransaction();
		tx.begin();
		
		try{
			Query query = this.em.createNamedQuery("Customer.findAll");
			return query.getResultList();
		}catch(Exception e){
			tx.rollback();
			return null;
		}finally{
			tx.commit();
			this.closeEntityManager();
		}
	}
	
	public List<Order> getOrders(Long id){
		this.openEntityManager();
		EntityTransaction tx= this.em.getTransaction();
		tx.begin();
		try{
			Query query = this.em.createNamedQuery("trovaOrdini");  //se è interrogazione molto rilevante per il dominio  usata spesso
			query.setParameter("id", new Long(id));
			return query.getResultList();
		}catch(Exception e){
			tx.rollback();
			return null;
		}finally{
			tx.commit();
			this.closeEntityManager();}
		
//		Customer c=this.em.find(Customer.class, new Long(2601));
//		tx.commit(); // aggiungere 	@OneToMany(mappedBy="customer",fetch=FetchType.EAGER)
//		em.close();
//		emf.close();
//		return c.getOrders();

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
