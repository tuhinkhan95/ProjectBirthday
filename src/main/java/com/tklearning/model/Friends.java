package com.tklearning.model;

public class Friends {
	
	private String name;
	private String email;
	private String dob;
	
	public Friends(String name, String email, String dob) {
		super();
		this.name = name;
		this.email = email;
		this.dob = dob;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	

}
