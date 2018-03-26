package com.asw.util;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PO_AddView extends PO_View {
	static public void fillForm(WebDriver driver, String nombreAgentep, String passwordAgentep, String tipoAgentep, String namep,
			String descriptionp, String tagsp, String propertiesp) {
		WebElement email = driver.findElement(By.name("nombreAgente"));
		email.click();
		email.clear();
		email.sendKeys(nombreAgentep);
		
		WebElement passwordAgente = driver.findElement(By.name("passwordAgente"));
		passwordAgente.click();
		passwordAgente.clear();
		passwordAgente.sendKeys(passwordAgentep);
		
		WebElement tipoAgente = driver.findElement(By.name("tipoAgente"));
		tipoAgente.click();
		tipoAgente.clear();
		tipoAgente.sendKeys(tipoAgentep);
		
		WebElement name = driver.findElement(By.name("name"));
		name.click();
		name.clear();
		name.sendKeys(namep);
		
		WebElement description = driver.findElement(By.name("description"));
		description.click();
		description.clear();
		description.sendKeys(descriptionp);
		
		WebElement tags = driver.findElement(By.name("etiquetas"));
		tags.click();
		tags.clear();
		tags.sendKeys(tagsp);
		
		WebElement properties = driver.findElement(By.name("properties"));
		properties.click();
		properties.clear();
		properties.sendKeys(propertiesp);
		
		
		// Pulsar el boton de Alta.
		By boton = By.className("btn");
		driver.findElement(boton).click();
	}
}
