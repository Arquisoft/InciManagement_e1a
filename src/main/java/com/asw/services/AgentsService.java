package com.asw.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.asw.entities.Incidence;

@Service
public class AgentsService {

	/**
	 * Pasar a un archivo aparte
	 * 
	 * @author UO250687
	 *
	 */
	public class PeticionInfoREST {

		private String login;
		private String password;
		private String kind;

		public PeticionInfoREST() {
		}

		public PeticionInfoREST(String login, String password, String kind) {
			this.login = login;
			this.password = password;
			this.kind = kind;
		}

		public String getKind() {
			return kind;
		}

		public String getLogin() {
			return login;
		}

		public String getPassword() {
			return password;
		}

		public void setKind(String kind) {
			this.kind = kind;
		}

		public void setLogin(String login) {
			this.login = login;
		}

		public void setPassword(String password) {
			this.password = password;
		}
	}

	public boolean checkAgent(Incidence incidence) {
		RestTemplate template = new RestTemplate();
		try {
			template.postForEntity("http://localhost:8090/agent", new PeticionInfoREST(incidence.getNombreAgente(),
					incidence.getPasswordAgente(), incidence.getTipoAgente()), String.class);
			return true;
		} catch (HttpClientErrorException e) {
			return false;
		}
	}

}
