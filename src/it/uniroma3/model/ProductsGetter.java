package it.uniroma3.model;

import java.util.LinkedList;
import java.util.List;

public class ProductsGetter {
	List<Product> products;
	
	public ProductsGetter(){
		this.products= new LinkedList<Product>();
		ProductFacade fc= new ProductFacade();
		this.products.addAll(fc.retriveAllProducts());
	}

	public List<Product> getProducts() {
		return products;
	}

}
