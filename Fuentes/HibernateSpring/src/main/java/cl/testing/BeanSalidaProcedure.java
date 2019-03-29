package cl.testing;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * Salida del procedure
 * 
 * @author ccontrerasc
 *
 */
public class BeanSalidaProcedure implements Serializable {

	/**
	 * UID
	 */
	private static final long serialVersionUID = 2295316242721511371L;

	private String MONTO_ACTUAL;
	private String GRUPO;
	private String MONTO_ANTERIOR;
	private String DIFERENCIA;
	private String GRUPO_ID;

	/** GET Y SET **/
	public String getMONTO_ACTUAL() {
		return MONTO_ACTUAL;
	}

	public void setMONTO_ACTUAL(String mONTO_ACTUAL) {
		MONTO_ACTUAL = mONTO_ACTUAL;
	}

	public String getGRUPO() {
		return GRUPO;
	}

	public void setGRUPO(String gRUPO) {
		GRUPO = gRUPO;
	}

	public String getMONTO_ANTERIOR() {
		return MONTO_ANTERIOR;
	}

	public void setMONTO_ANTERIOR(String mONTO_ANTERIOR) {
		MONTO_ANTERIOR = mONTO_ANTERIOR;
	}

	public String getDIFERENCIA() {
		return DIFERENCIA;
	}

	public void setDIFERENCIA(String dIFERENCIA) {
		DIFERENCIA = dIFERENCIA;
	}

	public String getGRUPO_ID() {
		return GRUPO_ID;
	}

	public void setGRUPO_ID(String gRUPO_ID) {
		GRUPO_ID = gRUPO_ID;
	}

	@Override
	public String toString() {
		return "BeanSalidaProcedure [MONTO_ACTUAL=" + MONTO_ACTUAL + ", GRUPO=" + GRUPO + ", MONTO_ANTERIOR=" + MONTO_ANTERIOR + ", DIFERENCIA=" + DIFERENCIA
				+ ", GRUPO_ID=" + GRUPO_ID + "]";
	}

}
