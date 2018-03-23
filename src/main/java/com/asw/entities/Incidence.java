package com.asw.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
	private String location; // Se saca del agente?
	private String nombreAgente;
	private String passwordAgente;
	private String tipoAgente;
	private String etiquetas;
	private String properties;

	/*
	@ElementCollection
	@CollectionTable(name = "tags", joinColumns = @JoinColumn(name = "tag_id"))
	@Column(name = "tag")
	private Set<String> tags; // lista de etiquetas
	@OneToMany(mappedBy = "incidence", orphanRemoval = true, fetch = FetchType.EAGER)
	private Set<Property> properties;
	*/
	

	public Incidence() {
		
	}

	public Long getId() { 
		return id;
	}

	public String getDescription() {
		return description;
	}

	public String getNombreAgente() {
		return nombreAgente;
	}

	public String getPasswordAgente() {
		return passwordAgente;
	}

	public String getTipoAgente() {
		return tipoAgente;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setNombreAgente(String nombreAgente) {
		this.nombreAgente = nombreAgente;
	}

	public void setPasswordAgente(String passwordAgente) {
		this.passwordAgente = passwordAgente;
	}

	public void setTipoAgente(String tipoAgente) {
		this.tipoAgente = tipoAgente;
	}

	public void setEtiquetas(String etiquetas) {
		this.etiquetas = etiquetas;
	}

	public void setProperties(String properties) {
		this.properties = properties;
	}

	/**
	 * Constructor con todos los parametros menos propiedades
	 * 
	 * @param name
	 * @param descripcion
	 * @param location
	 * @param etiquetas
	 * @param agente
	 */
	public Incidence(String name, String descripcion, String location, String etiquetas, String nombreAgente,
			String passwordAgente, String tipoAgente) {
		super();
		this.name = name;
		this.description = descripcion;
		this.location = location;
		this.etiquetas = etiquetas;
		this.nombreAgente = nombreAgente;
		this.passwordAgente = passwordAgente;
		this.tipoAgente = tipoAgente;
	}

	/**
	 * Constructor con todos los campos
	 * 
	 * @param name
	 * @param descripcion
	 * @param location
	 * @param etiquetas
	 * @param propiedades
	 * @param agente
	 */

	public Incidence(String name, String descripcion, String location, String etiquetas, String propiedades,
			String nombreAgente, String passwordAgente, String tipoAgente) {
		super();
		this.name = name;
		this.description = descripcion;
		this.location = location;
		this.etiquetas = etiquetas;
		this.properties = propiedades;
		this.nombreAgente = nombreAgente;
		this.passwordAgente = passwordAgente;
		this.tipoAgente = tipoAgente;
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

	/*
	public Set<String> getEtiquetas() {
		return tags;
	}

	public Set<String> getTags() {
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
	
	public Set<Property> getProperties() {
		return properties;
	}
	*/


	@Override
	public String toString() {
		return "Incidence [id=" + id + ", name=" + name + ", description=" + description + ", location=" + location
				+ ", nombreAgente=" + nombreAgente + ", passwordAgente=" + passwordAgente + ", tipoAgente=" + tipoAgente
				+ ", etiquetas=" + etiquetas + ", properties=" + properties + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nombreAgente == null) ? 0 : nombreAgente.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Incidence other = (Incidence) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nombreAgente == null) {
			if (other.nombreAgente != null)
				return false;
		} else if (!nombreAgente.equals(other.nombreAgente))
			return false;
		return true;
	}

}
