package com.springboot.jpa.bean;

/**
 * Persona , mapeo desde la base
 * 
 * @author ccontrerasc
 *
 */
public class Persona {

	private int IDPERSONA;
	private String NOMBRE;
	private String APELLIDO;
	private String DIRECCION;

	/**
	 * Default constructor
	 */
	public Persona() {
		
	}
	
	/**
	 * Constructor
	 * 
	 * @param iDPERSONA
	 * @param nOMBRE
	 * @param aPELLIDO
	 * @param dIRECCION
	 */
	public Persona(int iDPERSONA, String nOMBRE, String aPELLIDO, String dIRECCION) {
		super();
		IDPERSONA = iDPERSONA;
		NOMBRE = nOMBRE;
		APELLIDO = aPELLIDO;
		DIRECCION = dIRECCION;
	}

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
