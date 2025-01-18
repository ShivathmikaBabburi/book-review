package com.book_management.book_management.Classes;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")
public class User {
	@Id
    private String id;
	private String name;
	private String email;
	private String password;
	private String Address;
	public User(String id, String name, String email, String password, String address) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		Address = address;
	}
	
	public User() {
		super();
	}

	public User(String name, String email, String password) {
		this.name=name;
		this.email=email;
		this.password=password;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", Address="
				+ Address + "]";
	}
	
	

}
