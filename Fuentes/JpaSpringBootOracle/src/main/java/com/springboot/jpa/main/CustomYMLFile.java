package com.springboot.jpa.main;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Carga de archivo YML 'application.yml'
 * 
 * @author ccontrerasc
 *
 */
@ConfigurationProperties
public class CustomYMLFile {

	private String QUERY_DIRECTA;
	private String PROCEDURE_DEVUELVE_CURSOR;

	/** GET Y SET **/
	public String getQUERY_DIRECTA() {
		return QUERY_DIRECTA;
	}

	public void setQUERY_DIRECTA(String qUERY_DIRECTA) {
		QUERY_DIRECTA = qUERY_DIRECTA;
	}

	public String getPROCEDURE_DEVUELVE_CURSOR() {
		return PROCEDURE_DEVUELVE_CURSOR;
	}

	public void setPROCEDURE_DEVUELVE_CURSOR(String pROCEDURE_DEVUELVE_CURSOR) {
		PROCEDURE_DEVUELVE_CURSOR = pROCEDURE_DEVUELVE_CURSOR;
	}

}