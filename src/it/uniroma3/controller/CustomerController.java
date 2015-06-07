package it.uniroma3.controller;

import java.util.Date;
import java.util.List;

import it.uniroma3.model.Address;
import it.uniroma3.model.Customer;
import it.uniroma3.model.CustomerFacade;
import it.uniroma3.model.Order;
import it.uniroma3.status.NotLoggedException;
import it.uniroma3.status.Status;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.persistence.Query;
import javax.servlet.http.*;


@ManagedBean
public class CustomerController {

	@ManagedProperty(value="#{param.id}")
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String dateOfBirth;
	private Date registrationDate;
	private Address address;
	private List<Customer> customers;
	private Customer customer;
	private String street;
	private String city;
	private String state;
	private String zipcode;
	private String country;

	@EJB
	private CustomerFacade customerFacade;

	public String createCustomer(){
		this.customer=customerFacade.createCustomer(firstName, lastName, email, password, dateOfBirth, street, city, state, zipcode, country);
		return "customer";
	}

	public String listCustomers() {
		this.customers = customerFacade.getAllCustomer();
		return "customers"; 
	}

	public String findCustomer() {
		try{
			Status.isLogged(true);
		}catch(NotLoggedException e){
			return "notLogged";
		}
		this.customer = customerFacade.getCustomer(id);
		return "customerDetails";
	}

	public String login() {
		HttpSession session = getSession();
		if(((Customer)session.getAttribute("utenteCorrente"))!=null)
			return "alreadyLogged";
		else{
			this.customer = customerFacade.getCustomer(email);
			if(this.customer!=null)
				if(this.customer.getPassword().equals(this.password)){
					
					session.setAttribute("utenteCorrente", this.customer);
					if(this.customer.getAdmin()){
						session.setAttribute("admin", new Boolean(true));
					}
					if(session.getAttribute("carrello")!=null){
						return "carrello";
					}
					return "index";
				}
			return "notLogged";
		}
	}

	public String logout(){
		try{
			Status.isLogged(false);
		}catch(NotLoggedException e){
			return "notLogged";
		}
		HttpSession session = getSession();
		session.invalidate();
		return "index";

	}

	public static HttpSession getSession(){
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
		HttpSession httpSession = request.getSession(false);
		return httpSession;
	}

	public String findCustomer(Long id) {
		customerFacade.getCustomer(id);
		return "customer";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public CustomerFacade getCustomerFacade() {
		return customerFacade;
	}

	public void setCustomerFacade(CustomerFacade customerFacade) {
		this.customerFacade = customerFacade;
	}
	
	public String log(){
		return "login";
	}

}


