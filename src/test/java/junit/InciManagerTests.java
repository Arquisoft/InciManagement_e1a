package junit;

import static org.junit.Assert.assertEquals;
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
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.asw.InciManagerApplication;

@SuppressWarnings("deprecation")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = InciManagerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@IntegrationTest({ "server.port=0" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InciManagerTests {

	@Value("${local.server.port}")
	private int port;
	String base = "http://localhost:8090/";

	private RestTemplate template = new TestRestTemplate();;

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void t1_incidenciaDatosAgenteValidos() {
		String url = base + "incidence/add";
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
	public void t1_incidenciaDatosAgenteInvalidos() {
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
		assertEquals(response.getStatusLine().getStatusCode(), 401);
	}
}
