package com.test.dao;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.test.model.Person;

@Stateless
public class PersonDao implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName="mysql")
	private EntityManager manager;
	

	public Person getPerson(int id){
		return manager.find(Person.class, id) == null ? new Person(): manager.find(Person.class, id);
	}
	
	public List<Person> getAllPersons(){
		return (List<Person>) (manager.createNamedQuery("Person.findAll").getResultList()==null ? (new ArrayList<Person>()).add(new Person()) : manager.createNamedQuery("Person.findAll").getResultList()); 
	}
	
	public void addPerson(Person p){
		manager.persist(p);
	}
	
	public void updatePerson(Person p){
		manager.merge(p);
	}
}