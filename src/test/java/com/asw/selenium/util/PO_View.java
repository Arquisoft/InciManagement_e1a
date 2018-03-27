package com.asw.selenium.util;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PO_View {

	protected static int timeout = 2;

	/**
	 * Espera por la visibilidad de un elemento/s en la vista actualmente cargandose
	 * en driver..
	 * 
	 * @param driver:
	 *            apuntando al navegador abierto actualmente.
	 * @param type:
	 * @param text:
	 * @return Se retornará la lista de elementos resultantes de la búsqueda.
	 */
	static public List<WebElement> checkElement(WebDriver driver, String type, String text) {
		List<WebElement> elementos = SeleniumUtils.EsperaCargaPagina(driver, type, text, getTimeout());
		return elementos;
	}

	public static int getTimeout() {
		return timeout;
	}

	public static void setTimeout(int timeout) {
		PO_View.timeout = timeout;
	}
}
