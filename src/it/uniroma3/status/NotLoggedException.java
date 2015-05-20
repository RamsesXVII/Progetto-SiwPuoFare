package it.uniroma3.status;

public class NotLoggedException extends Exception {
	public NotLoggedException(){
		super("\n--- You are not logged in ---\n");
	}
}
