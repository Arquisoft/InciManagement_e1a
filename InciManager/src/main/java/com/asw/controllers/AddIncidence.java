package com.asw.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddIncidence {

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

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addIncidencia(HttpSession session, @RequestParam String userName, @RequestParam String password,
			@RequestParam String inciName, @RequestParam String description, @RequestParam String latlong,
			@RequestParam String[] tags) {

		return "";
	}

}
