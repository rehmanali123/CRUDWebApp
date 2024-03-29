package org.crud.model;

public class Employee {

	private int id;
	private String name, email, password, country;
	
	public Employee() {
		// no-argument constructor
	}
	
	public Employee(int id, String name, String email, String password, String country) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.country = country;
	}

	public Employee(String name, String email, String password, String country) {
		this.name = name;
		this.email = email;
		this.password = password;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", country="
				+ country + "]";
	}

	
	
	
}
