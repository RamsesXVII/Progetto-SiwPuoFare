package it.uniroma3.controller;

import java.util.LinkedList;
import java.util.List;

import it.uniroma3.model.Product;
import it.uniroma3.model.ProductFacade;
import it.uniroma3.status.NotLoggedException;
import it.uniroma3.status.Status;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@ManagedBean
public class ProductController {
	
	@ManagedProperty(value="#{param.id}")
	private Long id;
	private String name;
	private Float price;
	private String description;
	private String code;
	private Product product;
	private List<Product> products=new LinkedList<Product>();
	
	
	@EJB
	private ProductFacade productFacade;
	
	public String createProduct() {
		try{
			Status.isLogged(true);
		}catch(NotLoggedException e){
			return "notLogged";
		}
		this.product = productFacade.createProduct(name, code, price, description);
		getSession().setAttribute("p1", this.product); 
		getRequest().setAttribute("inserimentoIncorso", new Boolean(true));
		return "product"; 
	}
	
	public String listProducts() {
		this.products = productFacade.getAllProducts();
		return "products"; 
	}

	public String findProduct() {
		HttpSession s=getSession();
		this.product = productFacade.getProduct(id);
		s.setAttribute("p1", this.product);
		return "product";
	}
	public static HttpSession getSession(){
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
		HttpSession httpSession = request.getSession(false);
		return httpSession;
	}
	public static HttpServletRequest getRequest(){
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
		return request;
	}
	public String findProduct(Long id) {
		this.product = productFacade.getProduct(id);
		return "product";
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

	public void setName(String name) {
		this.name = name;
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

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}


