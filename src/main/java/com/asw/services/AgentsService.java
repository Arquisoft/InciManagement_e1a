package com.asw.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asw.entities.Agent;
import com.asw.repositories.AgentsRepository;

@Service
public class AgentsService {

	@Autowired
	AgentsRepository agentsRepository;
	
	public Agent getAgentByEmail(String email) {
		return agentsRepository.findByEmail(email);
	}

}
