package com.asw.services;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.asw.entities.Incidence;

@Service
public class AgentsService {

	public boolean checkAgent(Incidence incidence) {
		return checkAgent(incidence.getNombreAgente(), incidence.getPasswordAgente(), incidence.getTipoAgente());
	}

	public String getLocation(Incidence incidence) {
		RestTemplate template = new RestTemplate();
		ResponseEntity<String> response = template.postForEntity("http://34.210.218.163:8090/agent",
				new PeticionInfoREST(incidence.getNombreAgente(), incidence.getPasswordAgente(),
						incidence.getTipoAgente()),
				String.class);
		try {
			JSONObject jsonObject = (JSONObject) new JSONParser().parse(response.getBody());
			return (String) jsonObject.get("location");
		} catch (ParseException e) {
			return null;
		}
	}

	public boolean checkAgent(String agentName, String password, String kind) {
		RestTemplate template = new RestTemplate();
		try {
			template.postForEntity("http://34.210.218.163:8090/agent", new PeticionInfoREST(agentName, password, kind),
					String.class);
			return true;
		} catch (HttpClientErrorException e) {
			return false;
		}
	}

}
