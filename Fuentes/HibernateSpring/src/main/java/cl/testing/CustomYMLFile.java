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

	private String ProcedureSalidasIndependientes;
	private String ProcedureSalidaCursor;
	private String ProcedureSalidaMixta;

	/**
	 * Accesos
	 * 
	 * @return
	 */
	public String getProcedureSalidasIndependientes() {
		return ProcedureSalidasIndependientes;
	}

	public void setProcedureSalidasIndependientes(String procedureSalidasIndependientes) {
		ProcedureSalidasIndependientes = procedureSalidasIndependientes;
	}

	public String getProcedureSalidaCursor() {
		return ProcedureSalidaCursor;
	}

	public void setProcedureSalidaCursor(String procedureSalidaCursor) {
		ProcedureSalidaCursor = procedureSalidaCursor;
	}

	public String getProcedureSalidaMixta() {
		return ProcedureSalidaMixta;
	}

	public void setProcedureSalidaMixta(String procedureSalidaMixta) {
		ProcedureSalidaMixta = procedureSalidaMixta;
	}

}