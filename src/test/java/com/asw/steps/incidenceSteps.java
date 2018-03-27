package com.asw.steps;

import cucumber.api.PendingException;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

public class incidenceSteps {

	@Cuando("^el agente con nombre \"([^\"]*)\" envía una incidencia con nombre \"([^\"]*)\"$")
	public void el_agente_con_nombre_envía_una_incidencia_con_nombre(String arg1, String arg2) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entonces("^el sistema autoriza el envío de la incidencia$")
	public void el_sistema_autoriza_el_envío_de_la_incidencia() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Entonces("^el sistema guarda la incidencia correctamente$")
	public void el_sistema_guarda_la_incidencia_correctamente() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Dado("^producida por un agente autorizado en el sistema$")
	public void producida_por_un_agente_autorizado_en_el_sistema() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Dado("^una incidencia con nombre \"([^\"]*)\", descripción \"([^\"]*)\", etiqueta \"([^\"]*)\", propiedades \"([^\"]*)\"$")
	public void una_incidencia_con_nombre_descripción_etiqueta_propiedades(String arg1, String arg2, String arg3,
			String arg4) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

}
