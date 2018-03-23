package com.asw.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import com.asw.entities.Incidence;

@Service
public class AgentsService {

	public boolean checkAgent(Incidence incidence) {
		RestTemplate template = new RestTemplate();
		try {
			template.postForEntity("http://34.210.218.163:8090/agent", new PeticionInfoREST(incidence.getNombreAgente(),
					incidence.getPasswordAgente(), incidence.getTipoAgente()), String.class);
			return true;
		} catch (HttpClientErrorException e) {
			return false;
		}
	}

}
