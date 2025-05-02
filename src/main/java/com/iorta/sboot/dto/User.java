package com.iorta.sboot.dto;

public class User {
	private String name;
	private String role;
	
	//Default Constructor (Needed for @RequestBody)
	public User() {}
	
	//Constructor
	public User(String name, String role) {
		this.name = name;
		this.role = role;
	}
	
	//Getters and setters
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
}
	
