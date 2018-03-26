package com.asw.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PO_ListView extends PO_View{


	public static void fillForm(WebDriver driver, String nombreAgentep, String passwordAgentep, String tipoAgentep) {
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
		
		// Pulsar el boton de Alta.
		By boton = By.className("btn");
		driver.findElement(boton).click();
	}
}
