package it.uniroma3.model;

import javax.persistence.*;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(nullable=false)
	private String street;
	private String city;
	private String state;
	private String zipcode;
	private String country;

	public Address(){
		
	}
	
	public Address(String street, String city, String state, String zipcode,
			String country) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.country = country;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	public String toString(){
		   final StringBuilder sb = new StringBuilder();
	        sb.append(" Address"); 
	        sb.append("{id=").append(id); 
	        sb.append(", street='").append(street); 
	        sb.append(", city=").append(city); 
	        sb.append(", state='").append(state); 
	        sb.append(", zipcode='").append(zipcode);
	        sb.append("}\n");
	        return sb.toString();
	}
	public String description(){
		   final StringBuilder sb = new StringBuilder();
	        sb.append("<br>Address: ");
	        sb.append(" street=").append(street); 
	        sb.append(" city=").append(city); 
	        sb.append(" state=").append(state); 
	        sb.append(" zipcode=").append(zipcode);
	        return sb.toString();
	}
}
