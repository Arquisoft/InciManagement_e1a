package com.asw.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import com.asw.entities.Incidence;

@Service
public class AgentsService {

	public boolean checkAgent(String nombreAgente, String password, String tipo) {
		RestTemplate template = new RestTemplate();
		try {
			template.postForEntity("http://34.210.218.163:8090/agent",
					new PeticionInfoREST(nombreAgente, password, tipo), String.class);
			return true;
		} catch (HttpClientErrorException e) {
			return false;
		}
	}

}
