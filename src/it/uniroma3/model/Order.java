package it.uniroma3.model;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="orders")
@NamedQueries({
	@NamedQuery(name= "Order.findAll", query="SELECT p FROM Order p"),
	@NamedQuery(name= "Order.findById", query="SELECT c FROM Order c WHERE c.id=:id"),
	@NamedQuery(name= "Order.findAllNoSent", query="SELECT p FROM Order p WHERE p.stato='nonSpedito'"),
	@NamedQuery(name= "trovaOrdini", query="SELECT p FROM Order p Where p.customer.id= :id"),
})

public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date creationTime;
	@Column(nullable=false)
	private String stato;
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dataSpedizione;
	@ManyToOne
	private Customer customer;
	@OneToMany(fetch=FetchType.EAGER, cascade={CascadeType.PERSIST,CascadeType.REMOVE})
	@JoinColumn(name="order_id")
	private List<OrderLine> orderLines;
	
	public Order(){
		
	}

	public Order(Date creationTime, Customer c) {
		this.dataSpedizione=new Date();
		this.creationTime = creationTime;
		this.orderLines=new LinkedList<OrderLine>();
		this.customer=c;
		this.stato="nonSpedito";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	@Override
	public String toString(){
		   final StringBuilder sb = new StringBuilder();
	        sb.append("Order"); 
	        sb.append("{id=").append(id);
	        if(this.creationTime!=null)
	        sb.append(", creationTime='").append(this.creationTime); 
	        sb.append(", customer='").append(customer.getEmail()); 
	        sb.append(", status='").append(this.stato); 
	        sb.append("}\n");
	        return sb.toString();
	}

	public Date getDataSpedizione() {
		return dataSpedizione;
	}

	public void setDataSpedizione(Date dataSpedizione) {
		this.dataSpedizione = dataSpedizione;
	}

	public Float getTotal() {
		Float totale=new Float(0);
		for(OrderLine o: this.orderLines)
			totale +=new Float(o.getUnitPrice()*o.getQuantity());
		return totale;
		
	}


	
}
