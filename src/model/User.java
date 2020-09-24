package model;

import java.time.LocalDate;

public class User{
	
	//variable
	private String email;
	private String password;
	private LocalDate date;
	
	
	//constructor for the User class 
	
	public User(String email, String password, LocalDate date) {
		super();
		this.email = email;
		this.password = password;
		this.date = date;
	}
	//getters and setters
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
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
}