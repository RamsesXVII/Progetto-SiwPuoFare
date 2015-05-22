package it.uniroma3.model;

import java.util.*;

import javax.persistence.*;

@Entity
@NamedQueries({
	@NamedQuery(name="Products.findAll", query="SELECT c FROM Product c"),
    @NamedQuery(name="Products.findProduct", query="SELECT c FROM Product c WHERE c.id=:id")
})

public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(nullable=false)
	private String name;
	private String description;
	private Float price;
	private String code;
	private Integer quantity;
	@ManyToMany(mappedBy= "products", cascade={CascadeType.PERSIST,CascadeType.REMOVE})
	private List<Provider> providers;
	
	public Product (){
		
	}	
	
	public  Product (String name, String description, Float price,String code){
		this.name=name;
		this.description=description;
		this.price= price;
		this.providers= new LinkedList<Provider>();
		this.code=code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public void setName(String name) {
		this.name = name;
	}


	public List<Provider> getProviders() {
		return providers;
	}


	public void setProviders(List<Provider> providers) {
		this.providers = providers;
	}
	

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}
	
	public void addProvider(Provider p){
		this.providers.add(p);
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
