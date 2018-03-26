package com.asw;

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

import com.asw.util.PO_AddView;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InciManagerApplicationTests {

	@Test
	public void contextLoads() {
	}

	// En Windows (Debe ser la versión 46.0 y desactivar las actualizacioens
	// automáticas)):
	static String PathFirefox = "C:/Users/tinap/Downloads/Firefox46.0.win/Firefox46.win/FirefoxPortable.exe";
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

}
