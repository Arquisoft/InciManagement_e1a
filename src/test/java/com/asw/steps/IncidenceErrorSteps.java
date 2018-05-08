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
import cucumber.api.java.en.Given;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

public class IncidenceErrorSteps {

	HttpResponse response = null;
	
	@Dado("^una incidencia erronea enviada con: nombreAgente \"([^\"]*)\", password \"([^\"]*)\", tipoAgente \"([^\"]*)\", "
			+ "name \"([^\"]*)\", description \"([^\"]*)\", etiquetas \"([^\"]*)\", porperties \"([^\"]*)\"$")
	public void una_incidencia_erronea_enviada_con_nombreAgente_password_tipoAgente_name_description_etiquetas_porperties(
			String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7)
			throws Throwable {
		String url = "http://34.214.22.214:8080/incidence/add";
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);
		post.setHeader("User-Agent", "Mozilla/5.0");
		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("nombreAgente", arg1));
		urlParameters.add(new BasicNameValuePair("passwordAgente", arg2));
		urlParameters.add(new BasicNameValuePair("tipoAgente", arg3));
		urlParameters.add(new BasicNameValuePair("name", arg3));
		urlParameters.add(new BasicNameValuePair("description", arg4));
		urlParameters.add(new BasicNameValuePair("etiquetas", arg5));
		urlParameters.add(new BasicNameValuePair("properties", arg6));
		try {
			post.setEntity(new UrlEncodedFormEntity(urlParameters));
			client.execute(post);
		} catch (IOException e) {
		}
	}
	
	@Entonces("^el sistema muestra en pantalla un error$")
	public void el_sistema_muestra_en_pantalla_un_error() throws Throwable {
		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		System.out.println(result.toString());
		assertTrue(result.toString().contains("Los datos de agente de la incidencia"
				+ " no son válidos, no se podrá procesar la incidencia"));
	}

	

}
