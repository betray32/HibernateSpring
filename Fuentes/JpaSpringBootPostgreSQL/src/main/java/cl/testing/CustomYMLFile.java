package cl.testing;

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
	private String QUERY_PARAM;

	private String PROCEDURE_OBTENER_PERSONAS;
	private String PROCEDURE_OBTENER_PERSONA_ID;
	private String PROCEDURE_OBTENER_DATOS_UNICOS;

	/** GET Y SET **/
	public String getPROCEDURE_OBTENER_PERSONAS() {
		return PROCEDURE_OBTENER_PERSONAS;
	}

	public void setPROCEDURE_OBTENER_PERSONAS(String pROCEDURE_OBTENER_PERSONAS) {
		PROCEDURE_OBTENER_PERSONAS = pROCEDURE_OBTENER_PERSONAS;
	}

	public String getQUERY_DIRECTA() {
		return QUERY_DIRECTA;
	}

	public void setQUERY_DIRECTA(String qUERY_DIRECTA) {
		QUERY_DIRECTA = qUERY_DIRECTA;
	}

	public String getQUERY_PARAM() {
		return QUERY_PARAM;
	}

	public void setQUERY_PARAM(String qUERY_PARAM) {
		QUERY_PARAM = qUERY_PARAM;
	}

	public String getPROCEDURE_OBTENER_PERSONA_ID() {
		return PROCEDURE_OBTENER_PERSONA_ID;
	}

	public void setPROCEDURE_OBTENER_PERSONA_ID(String pROCEDURE_OBTENER_PERSONA_ID) {
		PROCEDURE_OBTENER_PERSONA_ID = pROCEDURE_OBTENER_PERSONA_ID;
	}

	public String getPROCEDURE_OBTENER_DATOS_UNICOS() {
		return PROCEDURE_OBTENER_DATOS_UNICOS;
	}

	public void setPROCEDURE_OBTENER_DATOS_UNICOS(String pROCEDURE_OBTENER_DATOS_UNICOS) {
		PROCEDURE_OBTENER_DATOS_UNICOS = pROCEDURE_OBTENER_DATOS_UNICOS;
	}

}