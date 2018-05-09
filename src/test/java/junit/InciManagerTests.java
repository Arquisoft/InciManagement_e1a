package junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.asw.InciManagerApplication;
import com.asw.entities.Incidence;
import com.asw.entities.IncidenceState;
import com.asw.services.IncidencesService;

@SuppressWarnings("deprecation")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = InciManagerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@IntegrationTest({ "server.port=0" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InciManagerTests {

	@Value("${local.server.port}")
	public int port;
	private String base = "http://34.214.22.214:8080";

	@Autowired
	IncidencesService inciServ;


	@Test
	public void t1IncidenciaDatosAgenteInvalidos() {
		String url = base + "incidence/add";
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);
		HttpResponse response = null;
		post.setHeader("User-Agent", "Mozilla/5.0");
		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("nombreAgente", "XXX"));
		urlParameters.add(new BasicNameValuePair("passwordAgente", "password"));
		urlParameters.add(new BasicNameValuePair("tipoAgente", "Person"));
		urlParameters.add(new BasicNameValuePair("name", "Fuego!"));
		urlParameters.add(new BasicNameValuePair("description", "Fuego en el monte de Terverga"));
		urlParameters.add(new BasicNameValuePair("etiquetas", "fuego, emergencia, daños"));
		urlParameters.add(new BasicNameValuePair("properties", "temperatura:alta, viente:fuerte"));
		try {
			post.setEntity(new UrlEncodedFormEntity(urlParameters));
			response = client.execute(post);
		} catch (IOException e) {
			fail();
		}
		assertEquals(response.getStatusLine().getStatusCode(), 403);
	}

	@Test
	public void t2ncidenciaDatosAgenteValidos() {
		String url = base + "/incidence/add";
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);
		HttpResponse response = null;
		post.setHeader("User-Agent", "Mozilla/5.0");
		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("nombreAgente", "usuarioJuan"));
		urlParameters.add(new BasicNameValuePair("passwordAgente", "password"));
		urlParameters.add(new BasicNameValuePair("tipoAgente", "Person"));
		urlParameters.add(new BasicNameValuePair("name", "Fuego!"));
		urlParameters.add(new BasicNameValuePair("description", "Fuego en el monte de Terverga"));
		urlParameters.add(new BasicNameValuePair("etiquetas", "fuego, emergencia, daños"));
		urlParameters.add(new BasicNameValuePair("properties", "temperatura:alta, viente:fuerte"));
		try {
			post.setEntity(new UrlEncodedFormEntity(urlParameters));
			response = client.execute(post);
		} catch (IOException e) {
			fail();
		}
		assertTrue(response.getStatusLine().getStatusCode() == 200);
	}
	
	

	@Test
	public void t4IncidenciaModel() {
		
		Incidence i = new Incidence("AgentePrueba","password","Person" ,"incidencia 1", "descripción de la incidencia", "prueba,incidence",
				"prueba:primera modelo:incidencia");

		i.setPasswordAgente("pass");
		i.setNombreAgente("Agente@gmail.com");

		
		assert i.getNombreAgente().equals("Agente@gmail.com");
		assert i.getPasswordAgente().equals("pass");
		assertNull( i.getLocation());
		assert i.getTipoAgente().equals("Person");
		
		
		
		assert i.getName().equals("incidencia 1");
		assert i.getDescription().equals("descripción de la incidencia");

		assert i.getEtiquetas().equals("prueba,incidence");
		assert i.getProperties().equals("prueba:primera modelo:incidencia");
		
		i.setDescripcion("nueva descripcion");
		i.setEtiquetas("et1 , et2, et3");
		i.setLocation("La calle ");
		i.setProperties("frio:alto, humedad:alta");
		
		assert i.getDescription().equals("nueva descripcion");
		assert i.getEtiquetas().equals("et1 , et2, et3");
		i.addTags("et4");
		assertEquals( i.getEtiquetas() ,"et1,et2,et3,et4");
		assert i.getProperties().equals("frio:alto, humedad:alta");
		i.addProperties("viento:suave");
		assert i.getProperties().equals("frio:alto,humedad:alta,viento:suave");
		 i.addComments("comentario 1");
		 i.addComments("comentario 2");

		 asserTrue( i.getComments().equals("comentario 1,comentario2"));
		 assert i.getCommentList().size()==2;
		 i.deleteComment("comentario 1");
		 asserTrue( i.getComments().equals("comentario 1"));
		 assert i.getCommentList().size()==1;
		
		 
		inciServ.addIncidence(i);
		i.getState().equals(IncidenceState.OPENED);
		inciServ.processIncidence(i); 
		i.getState().equals(IncidenceState.IN_PROCESS);
		inciServ.cancelIncidence(i);
		i.getState().equals(IncidenceState.CANCELED);	
		inciServ.closeIncidence(i);
		i.getState().equals(IncidenceState.CLOSED);	
		
		Incidence i2 = new Incidence("AgentePrueba","password","Person" ,"incidencia 1", "descripción de la incidencia", "prueba,incidence",
				"prueba:primera modelo:incidencia");
		
		assertFalse(i2.equals(i));
		
			

		
			
		

	}

	private void asserTrue(boolean equals) {
		// TODO Auto-generated method stub
		
	}

}
