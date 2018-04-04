package com.asw.entities;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.asw.util.Util;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author fernando
 *
 */
@Entity
public class Incidence {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String description;
	private String location;
	private String nombreAgente;
	private String passwordAgente;
	private String tipoAgente;
	private String etiquetas;
	private String properties = "";
	private IncidenceState state = IncidenceState.OPENED;
	private String expiration;
	private String comments;
	private String additionalInfo;

	public Incidence() {
		super();
	}

	public Incidence(String nombreAgente, String passwordAgente, String tipoAgente, String name, String description,
			String etiquetas, String properties) {
		this.name = name;
		this.description = description;
		this.etiquetas = etiquetas;
		this.properties = properties;
		this.nombreAgente = nombreAgente;
		this.passwordAgente = passwordAgente;
		this.tipoAgente = tipoAgente;
	}

	public void addComments(String newComment) {
		comments = Util.addString(newComment, comments);
	}

	public void addProperties(String newPropertie) {
		properties = Util.addString(newPropertie, properties);
	}

	public void addTags(String newTag) {
		etiquetas = Util.addString(newTag, etiquetas);
	}

	public void cancel() {
		state = IncidenceState.CANCELED;
	}

	public void close() {
		state = IncidenceState.CLOSED;
	}

	public void deleteComment(String comment) {
		comments = Util.deleteString(comment, comments);
	}

	public void deleteTag(String tag) {
		etiquetas = Util.deleteString(tag, etiquetas);
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

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public List<String> getCommentList() {
		return Util.toList(comments);
	}

	public String getComments() {
		return comments;
	}

	public String getDescripcion() {
		return description;
	}

	public String getDescription() {
		return description;
	}

	public String getEtiquetas() {
		return etiquetas;
	}

	public String getExpiration() {
		return expiration;
	}

	public Long getId() {
		return id;
	}

	public List<String> getInfoList() {
		return Util.toList(additionalInfo);
	}

	public String getLocation() {
		return location;
	}

	public String getName() {
		return name;
	}

	public String getNombreAgente() {
		return nombreAgente;
	}

	public String getPasswordAgente() {
		return passwordAgente;
	}

	public String getProperties() {
		return properties;
	}

	public Map<String, String> getPropertyMap() {
		Map<String, String> out = new HashMap<>();
		try {
			for (String property : properties.split(",")) {
				out.put(property.split(":")[0].trim(), property.split(":")[1].trim());
			}
		} catch (Exception e) {

		}
		return out;
	}

	public IncidenceState getState() {
		return state;
	}

	public List<String> getTagList() {
		return Util.toList(etiquetas);
	}

	public String getTipoAgente() {
		return tipoAgente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nombreAgente == null) ? 0 : nombreAgente.hashCode());
		return result;
	}

	public void open() {
		state = IncidenceState.OPENED;
	}

	public void process() {
		state = IncidenceState.IN_PROCESS;
	}

	public void setDescripcion(String descripcion) {
		this.description = descripcion;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setEtiquetas(String etiquetas) {
		this.etiquetas = etiquetas;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNombreAgente(String nombreAgente) {
		this.nombreAgente = nombreAgente;
	}

	public void setPasswordAgente(String passwordAgente) {
		this.passwordAgente = passwordAgente;
	}

	public void setProperties(String properties) {
		this.properties = properties;
	}

	public void setTipoAgente(String tipoAgente) {
		this.tipoAgente = tipoAgente;
	}

	public String toJson() {
		String json = "{";
		json += "\"agent\":{\"name\":\"" + nombreAgente + "\",\"password\":\"" + passwordAgente + "\",\"kind\":\""
				+ tipoAgente + "\"},";
		json += "\"name\":\"" + name + "\",";
		json += "\"description\":\"" + description + "\",";
		json += "\"location\":\"" + location + "\",";
		json += "\"tags\":" + Util.toJsonArray(etiquetas) + ",";
		json += "\"aditionalInfo\":" + Util.toJsonArray(additionalInfo) + ",";
		json += "\"properties\":{";
		for (String propertie : properties.split(",")) {
			json += "\"" + propertie.split(":")[0] + "\":\"" + propertie.split(":")[1] + "\",";
		}
		if (json.charAt(json.length() - 1) == ',') {
			json = json.substring(0, json.length() - 1);
		}
		json += "},";
		json += "\"state\":\"" + state.toString() + "\",";
		json += "\"comments\":" + Util.toJsonArray(comments) + ",";
		json += "\"expiration\":\"" + expiration + "\"";
		json += "}";
		return json;
	}

	@Override
	public String toString() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			Object obj = mapper.readValue(toJson(), Object.class);
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
		} catch (IOException e) {
			return "problema con json ... ";
		}
	}

}
