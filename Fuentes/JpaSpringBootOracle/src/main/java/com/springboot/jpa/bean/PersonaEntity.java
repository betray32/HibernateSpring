package com.springboot.jpa.bean;

/**
 * Persona , mapeo desde la base
 * 
 * @author ccontrerasc
 *
 */
public class PersonaEntity {

	private int IDPERSONA;
	private String NOMBRE;
	private String APELLIDO;
	private String DIRECCION;

	/** GET Y SET **/
	public int getIDPERSONA() {
		return IDPERSONA;
	}

	public void setIDPERSONA(int iDPERSONA) {
		IDPERSONA = iDPERSONA;
	}

	public String getNOMBRE() {
		return NOMBRE;
	}

	public void setNOMBRE(String nOMBRE) {
		NOMBRE = nOMBRE;
	}

	public String getAPELLIDO() {
		return APELLIDO;
	}

	public void setAPELLIDO(String aPELLIDO) {
		APELLIDO = aPELLIDO;
	}

	public String getDIRECCION() {
		return DIRECCION;
	}

	public void setDIRECCION(String dIRECCION) {
		DIRECCION = dIRECCION;
	}

	@Override
	public String toString() {
		return "Persona [IDPERSONA=" + IDPERSONA + ", NOMBRE=" + NOMBRE + ", APELLIDO=" + APELLIDO + ", DIRECCION=" + DIRECCION + "]";
	}

}
