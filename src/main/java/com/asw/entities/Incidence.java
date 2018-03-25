package com.asw.entities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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

	public void addComment(String newComment) {
		comments = addString(newComment, comments);
	}

	public void addPropertie(String newPropertie) {
		properties = addString(newPropertie, properties);
	}

	private String addString(String newString, String csv) {
		List<String> list = toList(csv);
		list.add(newString);
		return toCsv(list);
	}

	public void addTag(String newTag) {
		etiquetas = addString(newTag, etiquetas);
	}

	public void cancel() {
		state = IncidenceState.CANCELED;
	}

	public void close() {
		state = IncidenceState.CLOSED;
	}

	public void deleteComment(String comment) {
		comments = deleteString(comment, comments);
	}

	private String deleteString(String stringToDelete, String csv) {
		List<String> list = toList(csv);
		list.remove(stringToDelete);
		return toCsv(list);
	}

	public void deleteTag(String tag) {
		etiquetas = deleteString(tag, etiquetas);
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
		return toList(comments);
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
		return toList(additionalInfo);
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
		for (String property : properties.split(",")) {
			out.put(property.split(":")[0].trim(), property.split(":")[1].trim());
		}
		return out;
	}

	public IncidenceState getState() {
		return state;
	}

	public List<String> getTagList() {
		return toList(etiquetas);
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

	private String toArrayFields(String csv) {
		return "[" + toList(csv).stream().map(f -> "\"" + f + "\"").collect(Collectors.joining(",")) + "]";
	}

	public String toJson() {
		String json = "{";
		json += "\"agent\":{\"name\":\"" + nombreAgente + "\",\"password\":\"" + passwordAgente + "\",\"kind\":\""
				+ tipoAgente + "\"},";
		json += "\"name\":\"" + name + "\",";
		json += "\"description\":\"" + description + "\",";
		json += "\"location\":\"" + location + "\",";
		json += "\"tags\":" + toArrayFields(etiquetas) + ",";
		json += "\"aditionalInfo\":" + toArrayFields(additionalInfo) + ",";
		json += "\"properties\":{";
		for (String propertie : properties.split(",")) {
			json += "\"" + propertie.split(":")[0] + "\":\"" + propertie.split(":")[1] + "\",";
		}
		if (json.charAt(json.length() - 1) == ',') {
			json = json.substring(0, json.length() - 1);
		}
		json += "},";
		json += "\"state\":\"" + state.toString() + "\",";
		json += "\"comments\":" + toArrayFields(comments) + ",";
		json += "\"expiration\":\"" + expiration + "\"";
		json += "}";
		return json;
	}

	private String toCsv(List<String> values) {
		return values == null ? null
				: values.stream().map(v -> v.trim().toLowerCase()).collect(Collectors.joining(","));
	}

	private List<String> toList(String csv) {
		List<String> out = new ArrayList<>();
		if (csv != null) {
			for (String tag : csv.split(",")) {
				out.add(tag.toLowerCase().trim());
			}
		}
		return out;
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
