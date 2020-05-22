package com.river.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private long id;
	private String name;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Employee(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
