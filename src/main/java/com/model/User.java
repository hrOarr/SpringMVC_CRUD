package com.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class User {
	private int id;
	
	@NotEmpty(message = "Name can not be Empty")
	@Size(min = 5, max = 55, message = "Name must be between 5 and 55 characters")
	private String name;
	
	@NotEmpty(message = "Email can not be Empty")
	@Email(message = "Invalid Email")
	private String email;
	
	@NotEmpty(message = "Country can not be Empty")
	private String country;
	
	public User() {}
	public User(int id, String name, String email, String country) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.country = country;
	}
	public User(String name, String email, String country) {
		this.name = name;
		this.email = email;
		this.country = country;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
}