package com.asw.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.asw.entities.Incidence;

public interface IncidencesRepository extends CrudRepository<Incidence, Long> {

	List<Incidence> findByNombreAgente(String userName);

}
