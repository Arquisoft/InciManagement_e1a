package com.asw.entities;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author fernando
 *
 */
@Entity
public class Incidence {
	/*
	 * Cada incidencia puede contener los siguientes campos: nombre de usuario y
	 * password, nombre de la incidencia, descripción, localización (se obtendrá
	 * automáticamente del dispositivo si es posible), etiquetas (lista de palabras
	 * separadas por comas que permitirán categorizar las incidencias), información
	 * adicional (fotos, vídeos, etc.). Algunas incidencias podrán también contener
	 * una lista de campos con la forma "propiedad/valor", donde el campo propiedad
	 * indica un nombre de propiedad, y el campo valor, indica el valor de dicha
	 * propiedad.
	 */
	
	@Id
	@GeneratedValue
	private Long id;	
	private String name;
	private String description;
	private String location; //Se saca del agente?

	@ElementCollection
	@CollectionTable(name="tags", joinColumns=@JoinColumn(name="tag_id") )
	@Column(name="tag")
	private Set<String> tags; 	// lista de etiquetas

	@OneToMany(mappedBy = "incidence", orphanRemoval = true, fetch = FetchType.EAGER)
	private Set<Property> properties;
	@ManyToOne
	private Agent agent;
	
	public Incidence() {}
	
	
	
	/**
	 * Constructor con todos los parametros menos propiedades
	 * @param name
	 * @param descripcion
	 * @param location
	 * @param etiquetas
	 * @param agente
	 */
	public Incidence(String name, String descripcion, String location, Set<String> etiquetas,
			 Agent agente) {
		super();
		this.name = name;
		this.description = descripcion;
		this.location = location;
		this.tags = etiquetas;
		this.agent = agente;
	}

	/**
	 * Constructor con todos los campos
	 * @param name
	 * @param descripcion
	 * @param location
	 * @param etiquetas
	 * @param propiedades
	 * @param agente
	 */
	public Incidence(String name, String descripcion, String location, Set<String> etiquetas,
			Set<Property> propiedades, Agent agente) {
		super();
		this.name = name;
		this.description = descripcion;
		this.location = location;
		this.tags = etiquetas;
		this.properties = propiedades;
		this.agent = agente;
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescripcion() {
		return description;
	}
	public void setDescripcion(String descripcion) {
		this.description = descripcion;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Set<String> getEtiquetas() {
		return tags;
	}
	public void setEtiquetas(Set<String> etiquetas) {
		this.tags = etiquetas;
	}
	public Set<Property> getPropiedades() {
		return properties;
	}
	public void setPropiedades(Set<Property> propiedades) {
		this.properties = propiedades;
	}
	public Agent getAgente() {
		return agent;
	}
	public void setAgente(Agent agente) {
		this.agent = agente;
	}
	
	
}
