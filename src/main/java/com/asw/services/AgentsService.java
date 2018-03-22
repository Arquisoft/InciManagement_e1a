package com.asw.services;

import org.springframework.stereotype.Service;

import com.asw.entities.Agent;

@Service
public class AgentsService {
	
	public boolean sendAgent(Agent agente) {
		String json="{login:"+ agente.getEmail()+", password:"+ agente.getPassword()+", kind:" +agente.getKind()+"}";
		
//        if(!respuesta)
//			return false;
		return true;
	}


}
