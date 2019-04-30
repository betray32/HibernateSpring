package cl.testing.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * BeanSalidaProcedure
 * 
 * @author ccontrerasc
 *
 */
@Entity
public class BeanSalidaProcedure {

	@Id
	private int GRUPO_ID;
	private int DIFERENCIA;
	private int MONTO_ANTERIOR;
	private String GRUPO;
	private String MONTO_ACTUAL;

	/** GET Y SET **/
	public int getGRUPO_ID() {
		return GRUPO_ID;
	}

	public void setGRUPO_ID(int gRUPO_ID) {
		GRUPO_ID = gRUPO_ID;
	}

	public int getDIFERENCIA() {
		return DIFERENCIA;
	}

	public void setDIFERENCIA(int dIFERENCIA) {
		DIFERENCIA = dIFERENCIA;
	}

	public int getMONTO_ANTERIOR() {
		return MONTO_ANTERIOR;
	}

	public void setMONTO_ANTERIOR(int mONTO_ANTERIOR) {
		MONTO_ANTERIOR = mONTO_ANTERIOR;
	}

	public String getGRUPO() {
		return GRUPO;
	}

	public void setGRUPO(String gRUPO) {
		GRUPO = gRUPO;
	}

	public String getMONTO_ACTUAL() {
		return MONTO_ACTUAL;
	}

	public void setMONTO_ACTUAL(String mONTO_ACTUAL) {
		MONTO_ACTUAL = mONTO_ACTUAL;
	}

}