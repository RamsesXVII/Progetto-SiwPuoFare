package it.uniroma3.model;

import java.util.List;

import javax.persistence.*;
public class CommerceMain {
	
	public static void main(String[] args) {
		 ProductFacade pf= new ProductFacade();
		 System.out.println(pf.getProduct(new Long(4351)).getName());
	}
}
