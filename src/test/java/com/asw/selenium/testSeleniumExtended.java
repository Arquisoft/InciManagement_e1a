package com.asw.selenium;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.asw.selenium.util.PO_AddView;
import com.asw.selenium.util.PO_ListView;

@RunWith(SpringRunner.class)
@SpringBootTest
public class testSeleniumExtended {

	@Test
	public void contextLoads() {
	}

	// En Windows (Debe ser la versión 46.0 y desactivar las actualizacioens
	// automáticas)):
	static String PathFirefox = "C:\\Users\\darid\\Desktop\\Firefox46.win\\FirefoxPortable.exe";
	// Común a Windows y a MACOSX
	static WebDriver driver = getDriver(PathFirefox);
	static String URL = "http://localhost:8090";

	public static WebDriver getDriver(String PathFirefox) {
		// Firefox (Versión 46.0) sin geckodriver para Selenium 2.x.
		System.setProperty("webdriver.firefox.bin", PathFirefox);
		WebDriver driver = new FirefoxDriver();
		return driver;
	}

	// Antes de cada prueba se navega al URL home de la aplicaciónn
	@Before
	public void setUp() {
		driver.navigate().to(URL);
	}

	// Antes de la primera prueba
	@BeforeClass
	static public void begin() {
	}

	// Después de cada prueba se borran las cookies del navegador
	@After
	public void tearDown() {
		driver.manage().deleteAllCookies();
	}

	// Al finalizar la última prueba
	@AfterClass
	static public void end() {
		// Cerramos el navegador al finalizar las pruebas
		// driver.quit();
		driver.close();
	}
	
	@Test
	public void testAdd() {
		PO_AddView.fillForm(driver, "usuarioJuan", "password", "Person", "inci", "ojioj", "joij", "jdoiw:iwi");
		PO_AddView.checkElement(driver, "text", "Incidencia enviada");
	}
	
	@Test
	public void testAddFailBadPassword() {
		PO_AddView.fillForm(driver, "usuarioJuan", "pass", "Person", "inci", "ojioj", "joij", "jdoiw:iwi");
		PO_AddView.checkElement(driver, "text", "Error 401");
	}
	
	
	@Test
	public void testList() {
		driver.navigate().to("http://localhost:8090/incidence/list");
		PO_ListView.fillForm(driver, "usuarioJuan", "password", "Person");
		PO_ListView.checkElement(driver, "text", "Mis incidencias");
	}

	@Test
	public void testListBadPassword() {
		driver.navigate().to("http://localhost:8090/incidence/list");
		PO_ListView.fillForm(driver, "usuarioJuan", "pass", "Person");
		PO_ListView.checkElement(driver, "text", "Error 401");
	}
}