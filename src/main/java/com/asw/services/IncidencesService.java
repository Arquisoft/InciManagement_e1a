package com.asw.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asw.Kafka.producer.KafkaProducer;
import com.asw.entities.Incidence;
import com.asw.repositories.IncidencesRepository;

@Service
public class IncidencesService {
	@Autowired
	IncidencesRepository incidencesRepository;
	@Autowired
	KafkaProducer producer;
	
	public void addIncidence(Incidence incidence) {
		producer.send("Entities", incidence.toString());
		incidencesRepository.save(incidence);
	}

	public List<Incidence> getIncidencesFor(String userName) {
		return incidencesRepository.findByNombreAgente(userName);
	}

}
