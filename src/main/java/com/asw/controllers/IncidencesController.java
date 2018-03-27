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

	@RequestMapping(value = "/incidence/add", method = RequestMethod.GET)
	public String add(Model model) {
		return "incidence/add";
	}

	@RequestMapping(value = "/incidence/add", method = RequestMethod.POST)
	public String add(@RequestParam String nombreAgente, @RequestParam String passwordAgente,
			@RequestParam String tipoAgente, @RequestParam String name, @RequestParam String description,
			@RequestParam String etiquetas, @RequestParam String properties) {
		Incidence incidence = new Incidence(nombreAgente, passwordAgente, tipoAgente, name, description, etiquetas,
				properties);
		if (agentsService.checkAgent(incidence)) {
			incidence.setLocation(agentsService.getLocation(incidence));
			incidence.addComments("incidencia en trámite");
			incidence.process();
			incidencesService.addIncidence(incidence);
			return "incidence/sent";
		}
		throw new UnauthorizedException();
	}

	@RequestMapping(value = "/")
	public String home() {
		return "redirect:/incidence/add";
	}

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

}
