package com.asw.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.asw.entities.Incidence;
import com.asw.services.IncidencesService;

@Controller
public class IncidencesController {

	@Autowired
	IncidencesService incidencesService;

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

//	@RequestMapping(value = "/add", method = RequestMethod.POST)
//	public String addIncidencia(HttpSession session, @RequestParam String userName, @RequestParam String password,
//			@RequestParam String inciName, @RequestParam String description, @RequestParam String latlong,
//			@RequestParam String[] tags) {
//
//		return "";
//	}
	
	@RequestMapping(value = "/incidence/add", method = RequestMethod.POST)
	public String signup(@ModelAttribute Incidence incidence, Model model) {
		incidencesService.addIncidence(incidence);

		return "";
	}
	
	@RequestMapping(value = "/incidence/add", method = RequestMethod.GET)
	public String signup(Model model) {
		model.addAttribute("incidence", new Incidence());
		return "/incidence/add";
	}

}
