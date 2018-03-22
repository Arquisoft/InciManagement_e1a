package com.asw.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

//@Entity
public class Property {
	
	@Id
	@GeneratedValue
	private Long id;
	String name;
	String value;
	@ManyToOne
	private Incidence incidence;
	
	
	public Property(String name, String value, Incidence incidence) {
		super();
		this.name = name;
		this.value = value;
		this.incidence = incidence;
	}
	
	public Property() {
		super();
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	

}
