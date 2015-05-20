package it.uniroma3.model;

import it.uniroma3.md5.Md5Generator;

import java.util.List;

import javax.persistence.*;
public class CommerceMain {
	
	public static void main(String[] args) throws Exception {
		//CustomerFacade cf=new CustomerFacade();
		//cf.createCustomer("a", "b", "a", "b", "10/10/1990", "", "", "", "", "");
		Md5Generator m=new Md5Generator();
		System.out.println(m.md5Of("b"));
	}
}
