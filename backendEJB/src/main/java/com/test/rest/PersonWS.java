package com.test.rest;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.dao.PersonDao;
import com.test.model.Person;


@Path("/")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PersonWS implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	PersonDao persondao;
	
	ObjectMapper mapper = new ObjectMapper();
	
	@GET
	@Path("/")
	public String hello(@Context HttpHeaders headers){
		return "{\"message\" : \"Welcome to my rest ejb application\"}";
	}
	
	@GET
	@Path("/person/{id}")
	public Person getPerson(@PathParam("id") int id) throws JsonProcessingException{
		return persondao.getPerson(id);
	}
	
	@GET
	@Path("/persons")
	public List<Person> getAllPersons(){
		return persondao.getAllPersons();
	}
	
	@POST
	@Path("/person/insert")
	public void insertPerson(Person p){
		persondao.addPerson(p);
	}
}