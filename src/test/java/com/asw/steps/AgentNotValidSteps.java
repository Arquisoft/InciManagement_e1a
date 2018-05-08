package com.asw.steps;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import cucumber.api.PendingException;
import cucumber.api.java.en.When;
import cucumber.api.java.es.Entonces;

public class AgentNotValidSteps {


	HttpResponse response = null;
	
	@When("^me identifico como usuario invalido \"([^\"]*)\", contraseña \"([^\"]*)\" y tipo \"([^\"]*)\"$")
	public void me_identifico_usuario_invalido_como_contraseña_y_tipo(String arg1, String arg2, String arg3) throws Throwable {

		String url = "http://34.214.22.214:8080/incidence/list";
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);
		post.setHeader("User-Agent", "Mozilla/5.0");
		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("nombreAgente", arg1));
		urlParameters.add(new BasicNameValuePair("passwordAgente", arg2));
		urlParameters.add(new BasicNameValuePair("tipoAgente", arg3));
		try {
			post.setEntity(new UrlEncodedFormEntity(urlParameters));
			response = client.execute(post);
		} catch (IOException e) {

		}
	}


	@Entonces("^se muestra un error$")
	public void se_muestra_un_error() throws Throwable {
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			System.out.println(result.toString());
			assertTrue(result.toString().contains("Los datos de agente de la incidencia no son válidos, "
					+ "no se podrá procesar la incidencia"));
		}
	

}
