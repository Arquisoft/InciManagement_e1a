package com.asw.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asw.entities.Incidence;
import com.asw.repositories.IncidencesRepository;

@Service
public class IncidencesService {
	@Autowired
	IncidencesRepository incidencesRepository;

	public void addIncidence(Incidence incidence) {
		incidencesRepository.save(incidence);
	}

}
