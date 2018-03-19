package com.asw.entities;

import java.util.HashMap;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author fernando
 *
 */
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
	private String descripcion;
	private String location; //Se saca del agente?
	private List<String> etiquetas;
	private List<HashMap<String,String>> propiedades;
	@ManyToOne
	private Agent agente;
	
	public Incidence() {}
	
	
	
	/**
	 * Constructor con todos los parametros menos propiedades
	 * @param name
	 * @param descripcion
	 * @param location
	 * @param etiquetas
	 * @param agente
	 */
	public Incidence(String name, String descripcion, String location, List<String> etiquetas,
			 Agent agente) {
		super();
		this.name = name;
		this.descripcion = descripcion;
		this.location = location;
		this.etiquetas = etiquetas;
		this.agente = agente;
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
	public Incidence(String name, String descripcion, String location, List<String> etiquetas,
			List<HashMap<String, String>> propiedades, Agent agente) {
		super();
		this.name = name;
		this.descripcion = descripcion;
		this.location = location;
		this.etiquetas = etiquetas;
		this.propiedades = propiedades;
		this.agente = agente;
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<String> getEtiquetas() {
		return etiquetas;
	}
	public void setEtiquetas(List<String> etiquetas) {
		this.etiquetas = etiquetas;
	}
	public List<HashMap<String, String>> getPropiedades() {
		return propiedades;
	}
	public void setPropiedades(List<HashMap<String, String>> propiedades) {
		this.propiedades = propiedades;
	}
	public Agent getAgente() {
		return agente;
	}
	public void setAgente(Agent agente) {
		this.agente = agente;
	}
	
	
}
