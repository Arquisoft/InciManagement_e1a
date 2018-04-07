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
	private IncidencesRepository incidencesRepository;

	@Autowired
	private KafkaProducer producer; 

	public void addIncidence(Incidence incidence) {
		 
		incidencesRepository.save(incidence);
		producer.send("Entities", incidence.toString());
	}

	public void cancelIncidence(Incidence incidence) {
		incidence.cancel();
		incidencesRepository.save(incidence);
	}

	public void closeIncidence(Incidence incidence) {
		incidence.close();
		incidencesRepository.save(incidence);
	}

	public List<Incidence> getIncidencesFor(String userName) {
		return incidencesRepository.findByNombreAgente(userName);
	}

	public void processIncidence(Incidence incidence) {
		incidence.process();
		incidencesRepository.save(incidence);
	}

}
