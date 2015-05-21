package it.uniroma3.model;

import javax.persistence.*;

@Entity
public class OrderLine {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(nullable=false)
	private Float unitPrice;
	@Column(nullable=false)
	private Integer quantity;
	@ManyToOne
	private Product product;
	
	public OrderLine(){
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public String toString(){
		   final StringBuilder sb = new StringBuilder();
	        sb.append("OrderLine"); 
	        sb.append("{id=").append(id); 
	        sb.append(", unit Price='").append(unitPrice); 
	        sb.append(", quantita='").append(quantity); 
	        sb.append(", product=").append(product.getName()); 
	        sb.append(", totale riga='").append((unitPrice*quantity));  
	        sb.append("}\n");
	        return sb.toString();
	}
}
