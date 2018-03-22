package com.asw.repositories;

import org.springframework.data.repository.CrudRepository;

import com.asw.entities.Agent;

public interface AgentsRepository extends CrudRepository<Agent, Long>{

	public Agent findByEmail(String email);

}
