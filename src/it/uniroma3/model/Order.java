package it.uniroma3.model;

import java.util.*;

import javax.persistence.*;


@Entity
@NamedQueries({
	@NamedQuery(name="Orders.findAll", query="SELECT o FROM Order o"),
    @NamedQuery(name="Orders.findOrder", query="SELECT o FROM Order o WHERE o.id=:id")
})
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date creationTime;
	@ManyToOne
	private Customer customer;
	@OneToMany(fetch=FetchType.EAGER, cascade={CascadeType.PERSIST,CascadeType.REMOVE})
	@JoinColumn(name="order_id")
	private List<OrderLine> orderLines;
	
	public Order(){
		
	}

	public Order(Date creationTime) {
		this.creationTime = creationTime;
		this.orderLines=new LinkedList<OrderLine>();
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
	
	public void addOrderLine(OrderLine o){
		this.orderLines.add(o);
	}
	@Override
	public String toString(){
		   final StringBuilder sb = new StringBuilder();
	        sb.append("Order"); 
	        sb.append("{id=").append(id);
	        if(this.creationTime!=null)
	        sb.append(", creationTime='").append(this.creationTime); 
	        sb.append("}\n");
	        return sb.toString();
	}

	
}
