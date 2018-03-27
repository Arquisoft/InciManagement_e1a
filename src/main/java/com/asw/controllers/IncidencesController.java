package com.asw.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.asw.entities.Incidence;
import com.asw.exception.UnauthorizedException;
import com.asw.services.AgentsService;
import com.asw.services.IncidencesService;

@Controller
public class IncidencesController {

	@Autowired
	IncidencesService incidencesService;

	@Autowired
	AgentsService agentsService;

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

	// @RequestMapping(value = "/add", method = RequestMethod.POST)
	// public String addIncidencia(HttpSession session, @RequestParam String
	// userName, @RequestParam String password,
	// @RequestParam String inciName, @RequestParam String description,
	// @RequestParam String latlong,
	// @RequestParam String[] tags) {
	//
	// return "";
	// }

	@RequestMapping(value = "/incidence/list")
	public String listIncidences() {
		return "incidence/auth";
	}

	@RequestMapping(value = "/incidence/list", method = RequestMethod.POST)
	public String listIncidences(Model model, @RequestParam("nombreAgente") String userName,
			@RequestParam("passwordAgente") String password, @RequestParam("tipoAgente") String kind) {
		if (agentsService.checkAgent(userName, password, kind)) {
			List<Incidence> incidences = incidencesService.getIncidencesFor(userName);
			model.addAttribute("incidences", incidences);
			return "incidence/list";
		}
		throw new UnauthorizedException();
	}

	@RequestMapping(value = "/")
	public String home() {
		return "redirect:/incidence/add";
	}

	@RequestMapping(value = "/incidence/add", method = RequestMethod.POST)
	public String add(@RequestParam String nombreAgente, @RequestParam String passwordAgente,
			@RequestParam String tipoAgente, @RequestParam String name, @RequestParam String description,
			@RequestParam String etiquetas, @RequestParam String properties) {
		Incidence incidence = new Incidence(nombreAgente, passwordAgente, tipoAgente, name, description, etiquetas,
				properties);
		if (agentsService.checkAgent(incidence)) {
			incidence.setLocation(agentsService.getLocation(incidence));

			incidencesService.addIncidence(incidence);
			return "incidence/sent";
		}
		throw new UnauthorizedException();
	}

	@RequestMapping(value = "/incidence/add", method = RequestMethod.GET)
	public String add(Model model) {
		return "incidence/add";
	}

}
