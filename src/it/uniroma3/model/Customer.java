package it.uniroma3.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@NamedQueries({
	@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c"),
    @NamedQuery(name="Customer.findAllCity",
                query="SELECT c.address.city FROM Customer c"),
    @NamedQuery(name="Customer.findByEmail",
                query="SELECT c FROM Customer c WHERE c.email= :email")
}) 
public class Customer {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	@Column(nullable=false)
	private String firstName;
	@Column(nullable=false)
	private String lastName;
	@Column
	private String email;
	@Column
	private Boolean admin;
	@Column
	private String password;
	@Column(nullable=false)
	@Temporal(TemporalType.DATE) //solo giorno mese anno
	private Date dateOfBirth;
	@Temporal(TemporalType.TIMESTAMP) //conto i millisecondi
	private Date registrationDate;
//	@OneToOne(cascade={CascadeType.PERSIST,CascadeType.REMOVE},fetch=FetchType.LAZY) se non voglio caricare indirizzi
	@OneToOne (cascade={CascadeType.PERSIST,CascadeType.REMOVE})
	private Address address;
//	@OneToMany(mappedBy="customer",fetch=FetchType.EAGER)
	@OneToMany(mappedBy="customer")
	private List<Order> orders;
	
	public Customer(){
		
	}
	
	public Customer(String firstName, String lastName, String email, String password,
			String dateOfBirthm) {
		this.registrationDate=new Date();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password=password;
		this.dateOfBirth= this.getBirthDate(dateOfBirthm);
		setRegistrationDate();
		this.admin=new Boolean(false);

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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String toString(){
		   final StringBuilder sb = new StringBuilder();
	        sb.append("Customer"); 
	        sb.append("{id=").append(id); 
	        sb.append(", name='").append(firstName); 
	        sb.append(", lastName=").append(lastName); 
	        sb.append(", email='").append(email);  
	        sb.append(", password='").append(password); 
	        sb.append(", admin='").append(admin); 
	        sb.append(", dateofBirth= day'").append(dateOfBirth.toString());
	        if(registrationDate!=null)
	        sb.append(", registration='").append(registrationDate.toString());
	        if(address!=null)
	        sb.append(address.toString());
	        sb.append("}\n");
	        return sb.toString();
	}


	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	private void setRegistrationDate(){
		Date date=new Date();
		this.registrationDate=date;
	}
	
	private Date getBirthDate(String dateOfBirthh) {
		Date date=null;
		try{
			SimpleDateFormat dateformat3 = new SimpleDateFormat("dd/MM/yyyy");
			date=dateformat3.parse(dateOfBirthh);
			}catch(ParseException e) {e.printStackTrace();}
		return date;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

}
