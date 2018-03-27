package com.asw.selenium;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class testSelenium {
	/**
	 * Escribe texto en un text field
	 * 
	 * @param driver
	 *            apuntando al navegador abierto actualmente
	 * @param id
	 *            id del campo de texto donde escribir
	 * @param text
	 *            texto a escribir
	 */
	public static void writeText(WebDriver driver, String name, String text) {
		WebElement webElement = driver.findElement(By.name(name));
		webElement.click();
		webElement.clear();
		webElement.sendKeys(text);
	}
	private WebDriver driver;

	private StringBuffer verificationErrors = new StringBuffer();

	private void fillForm(WebDriver driver, String userName, String password, String tipo, String nombre,
			String descripcion, String etiquetas, String propiedades) {
		writeText(driver, "nombreAgente", userName);
		writeText(driver, "passwordAgente", password);
		writeText(driver, "tipoAgente", tipo);
		writeText(driver, "name", nombre);
		writeText(driver, "description", descripcion);
		writeText(driver, "tags", etiquetas); 
		writeText(driver, "properties", propiedades);
		driver.findElement(By.id("send")).click();
	}

	private void fillLogin(WebDriver driver, String userName, String password, String tipo) {
		writeText(driver, "nombreAgente", userName);
		writeText(driver, "passwordAgente", password);
		writeText(driver, "tipoAgente", tipo);
		driver.findElement(By.id("send")).click();

	}

	@Before
	public void setUp() throws Exception {
		String baseUrl;
		driver = new HtmlUnitDriver();
		baseUrl = "http://localhost:8090/";
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.get(baseUrl + "/");
	}

	// @Test
	public void test01() {

		// En primer lugar comprobamos que somos redirigidos a la pagina correcta
		Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:8090/incidence/add");
	}

	// @Test
	public void test02() {
		// rellenamos con unos datos incorrectos
		fillForm(driver, "usuarioJuan", "12345", "Person", "Nevada", "gran nevada en el Angliru", "nieve,4x4,idiotas",
				"Frio:extremo,altitud:mucha");
		String texto = "Los datos de agente de la incidencia no son válidos";
		List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + texto + "')]"));
		assertTrue(list.size() > 0);
	}

	// @Test
	public void test03() {

		// Rellenamos el formulario con datos correctos
		fillForm(driver, "usuarioJuan", "password", "Person", "Nevada", "gran nevada en el Angliru",
				"nieve,4x4,idiotas", "Frio:extremo,altitud:mucha");
		// Comprobamos que la pagina es la correcta
		Assert.assertEquals(driver.getTitle(), "Añadiendo incidencia");
		// Comprobamos que la incidencia se añadio en la lista

		driver.navigate().to("http://localhost:8090/incidence/list");

		fillLogin(driver, "usuarioJuan", "password", "Person");
		// Comprobamos que haya el texto Nevada titulo del anterior incidencia
		List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + "Nevada" + "')]"));
		assertTrue(list.size() > 0);

	}

	// @Test
	public void test04() {
		fillLogin(driver, "usuarioJuan", "324", "Person");
		String texto = "Los datos de agente de la incidencia no son válidos";
		List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + texto + "')]"));
		assertTrue(list.size() > 0);

	}

}