package com.asw.repositories;

import org.springframework.data.repository.CrudRepository;

import com.asw.entities.Incidence;

public interface IncidencesRepository extends CrudRepository<Incidence, Long> {

}
