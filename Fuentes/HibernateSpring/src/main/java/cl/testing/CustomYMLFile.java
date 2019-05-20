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

}