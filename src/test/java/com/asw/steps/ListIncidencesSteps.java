package com.asw.steps;

import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import com.asw.InciManagerApplication;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import es.uniovi.asw.steps.PeticionAddIncidenceRest;

@ContextConfiguration(classes = InciManagerApplication.class, loader = SpringBootContextLoader.class)
@SpringBootTest
@WebAppConfiguration
public class ListIncidencesSteps {

	@Given("^una incidencia enviada$")
	public void una_incidencia_enviada() throws Throwable {
		RestTemplate template = new RestTemplate();
		PeticionAddIncidenceRest peticionAddIncidenceRest = new PeticionAddIncidenceRest("usuarioJuan", "password",
				"Person", "Fuego!", "El monte se quema", "calor, viento, fuego", "temperatura:alta, viento:fuerte");

		ResponseEntity<String> response = template.postForEntity("http://localhost:8090/incidence/add",
				peticionAddIncidenceRest, String.class);
		
		System.out.println(response.getBody());
	}

	@When("^me identifico como usuarioJuan, contraseña password y tipo Person$")
	public void me_identifico_como_usuarioJuan_contraseña_password_y_tipo_Person() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^se listarán todas mis incidencias$")
	public void se_listarán_todas_mis_incidencias() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^podré consultar la incidencia enviada$")
	public void podré_consultar_la_incidencia_enviada() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

}
