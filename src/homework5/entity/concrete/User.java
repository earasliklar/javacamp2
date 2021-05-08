package homework5.entity.concrete;

import homework5.entity.abtracts.Entities;

public class User implements Entities{

	private int id;
	private String firstName;
	private String surName;
	private String email;
	private String password;
	private boolean isVerified;
	
	public User() {
		super();
	}
//	forLogIn 
	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
// forRegister
	public User(int id, String firstName, String surName, String email, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.surName = surName;
		this.email = email;
		this.password = password;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
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
	public boolean isVerified() {
		return isVerified;
	}
	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}
	
	
	
	
}
