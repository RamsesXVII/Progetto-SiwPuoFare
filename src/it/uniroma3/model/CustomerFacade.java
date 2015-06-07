package it.uniroma3.model;


import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.List;

@Stateless
public class CustomerFacade {

	@PersistenceContext(unitName = "unit-jee-es2")
	private EntityManager em;

	public Customer createCustomer(String firstName, String lastName, String email, String password, String dateOfBirth,
			String street, String city, String state, String zipcode, String country){
		Customer c1=new Customer(firstName, lastName, email, password, dateOfBirth);
		Address a= new Address(street, city, state, zipcode, country);
		c1.setAddress(a);
		em.persist(c1);
		return c1;
	}

	public Customer getCustomer(Long id) {
		Customer customer= em.find(Customer.class, id);
		HttpSession session=getSession();
		session.setAttribute("searchedCustomer", customer);
		return customer;
	}

	public Customer getCustomer(String email) {
		Query query = this.em.createNamedQuery("Customer.findByEmail");
		query.setParameter("email", email);
		List<Customer> listCustomers = query.getResultList();
		if(listCustomers.size()!=0){
			return listCustomers.get(0);
		}
		return null;
	}


	public List<Customer> getAllCustomer() {
		CriteriaQuery<Customer> cq = em.getCriteriaBuilder().createQuery(Customer.class);
		cq.select(cq.from(Customer.class));
		List<Customer> customers = em.createQuery(cq).getResultList();
		return customers;
	}

	public void updateCustomer(Customer c) {
		em.merge(c);
	}

	private void deleteCustomer(Customer c) {
		em.remove(c);
	}

	public void deleteCustomer(Long id) {
		Customer c = em.find(Customer.class, id);
		deleteCustomer(c);
	}

	public static HttpSession getSession(){
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
		HttpSession httpSession = request.getSession(false);
		return httpSession;
	}
}
