package com.test.model;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
	@NamedQuery(
		name  = "Person.findAll",
		query = "select p from Person p")
})


@Entity
public class Person implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int    id;
	private String username;
	private String email;
	private String firstname;
	private String lastname;
	private String country;
	private String aboutme;
	
	public Person(){
		this.username = "";
		this.email    = "";
		this.firstname= "";
		this.lastname = "";
		this.country  = "";
		this.aboutme  = "";
	}
	public Person(String username, String email, String firstname, String lastname, String country, String city, String aboutme){
		this.username = username;
		this.email    = email;
		this.firstname= firstname;
		this.lastname = lastname;
		this.country  = country;
		this.aboutme  = aboutme;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAboutme() {
		return aboutme;
	}
	public void setAboutme(String aboutme) {
		this.aboutme = aboutme;
	}
	


}
