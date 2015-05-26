package it.uniroma3.model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Stateless
public class OrderFacade {
	
    @PersistenceContext(unitName = "unit-jee-es2")
    private EntityManager em;
    
	public Order createOrder(String customerEmail) {
		Order o=null;
        CriteriaQuery<Customer> cq = em.getCriteriaBuilder().createQuery(Customer.class);
        cq.select(cq.from(Customer.class));
        List<Customer> customers = em.createQuery(cq).getResultList();
        for(Customer c:customers)
        	if(c.getEmail().equals(customerEmail))
        		o=new Order(new Date(), c);
		em.persist(o);
		return o;
	}
	
	public Order getOrder(Long id) {
	    Order order = em.find(Order.class, id);
		return order;
	}
	
	public List<Order> getAllOrders() {
        CriteriaQuery<Order> cq = em.getCriteriaBuilder().createQuery(Order.class);
        cq.select(cq.from(Order.class));
        List<Order> orders = em.createQuery(cq).getResultList();
		return orders;
	}
	
	public List<Order> getOrdersToSend(){
		Query query=em.createNamedQuery("Order.findAllNoSent");
		List<Order> orders=query.getResultList();
		return orders;
	}

	public void updateOrder(Order order) {
        em.merge(order);
	}
	
    private void deleteOrder(Order order) {
        em.remove(order);
    }

	public void deleteProduct(Long id) {
        Order order = em.find(Order.class, id);
        deleteOrder(order);
	}

	public Order sendOrder(Long id) {
		Order o=em.find(Order.class, id);
		o.setDataSpedizione(new Date());
		o.setStato("spedito");
	//	em.merge(o);
	//	return o;
		return o;
	}

	public void createOrder(Map<Product, Integer> carrelloInSessione, Customer c) {
		Order o=new Order(new Date(), c);
		OrderLine ol=null;
		for(Product p:carrelloInSessione.keySet()){
			ol=new OrderLine();
			ol.setProduct(p);
			ol.setQuantity(carrelloInSessione.get(p));
			ol.setUnitPrice(p.getPrice());
			o.getOrderLines().add(ol);
			Product a=em.find(Product.class, p.getId());
			a.setQty(a.getQty()-ol.getQuantity());
			
		}
		em.persist(o);
	}

	
	public List<Order> getOrders(Long id){
		Query query = this.em.createNamedQuery("trovaOrdini");  //se è interrogazione molto rilevante per il dominio  usata spesso
		query.setParameter("id", new Long(id));
		return query.getResultList();
	}


}