package it.uniroma3.controller.action;

import java.security.NoSuchAlgorithmException;

import it.uniroma3.status.NotLoggedException;

import javax.servlet.http.HttpServletRequest;

public interface Action {

	public String perform(HttpServletRequest request) 
			throws NotLoggedException, NoSuchAlgorithmException;
}
