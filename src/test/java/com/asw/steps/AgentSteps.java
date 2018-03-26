package com.asw.steps;

import cucumber.api.PendingException;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;

public class AgentSteps {
	
	@Dado("^un agente con nombre \"([^\"]*)\", contraseña \"([^\"]*)\", tipo (\\d+)$")
	public void un_agente_con_nombre_contraseña_tipo(String arg1, String arg2, int arg3) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Dado("^autorizado en el sistema$")
	public void autorizado_en_el_sistema() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Cuando("^el agente con nombre \"([^\"]*)\" envía una incidencia$")
	public void el_agente_con_nombre_envía_una_incidencia(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

}
