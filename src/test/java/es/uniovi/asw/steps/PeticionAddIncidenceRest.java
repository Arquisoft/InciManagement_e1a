package es.uniovi.asw.steps;

public class PeticionAddIncidenceRest {

	private String nombreAgente;
	private String passwordAgente;
	private String tipoAgente;
	private String name;
	private String description;
	private String etiquetas;
	private String properties;

	public PeticionAddIncidenceRest() {
	}

	public PeticionAddIncidenceRest(String nombreAgente, String passwordAgente, String tipoAgente, String name,
			String description, String etiquetas, String properties) {
		this.nombreAgente = nombreAgente;
		this.passwordAgente = passwordAgente;
		this.tipoAgente = tipoAgente;
		this.name = name;
		this.description = description;
		this.etiquetas = etiquetas;
		this.properties = properties;
	}

	public String getDescription() {
		return description;
	}

	public String getEtiquetas() {
		return etiquetas;
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

	public String getTipoAgente() {
		return tipoAgente;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setEtiquetas(String etiquetas) {
		this.etiquetas = etiquetas;
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

}
