package com.springboot.jpa.bean;

import java.sql.Date;

/**
 * Listado obtenido desde la BD
 * 
 * @author ccontrerasc
 *
 */
public class ListadoMaestroNotificaciones {

	private String ctr_id;
	private String ctr_id_proceso;
	private Date ctr_fechcon;
	private String ctr_codusr;
	private String ctr_numtra;
	private String ctr_sec;
	private String ctr_codmod;
	private String ctr_codpro;
	private String ctr_codtip;
	private String ctr_codmon;
	private String ctr_codtra;
	private String ctr_rubro;
	private Date ctr_fechavig;
	private Date ctr_fechor;
	private String ctr_val;
	private String ctr_saldo_efectivo;
	private String ctr_tipo_tra;
	private String ctr_num_cue;
	private String ctr_request;
	private String ctr_estado;
	private Date ctr_fecha_proceso;

	/** GET Y SET **/
	public String getCtr_id() {
		return ctr_id;
	}

	public void setCtr_id(String ctr_id) {
		this.ctr_id = ctr_id;
	}

	public String getCtr_id_proceso() {
		return ctr_id_proceso;
	}

	public void setCtr_id_proceso(String ctr_id_proceso) {
		this.ctr_id_proceso = ctr_id_proceso;
	}

	public Date getCtr_fechcon() {
		return ctr_fechcon;
	}

	public void setCtr_fechcon(Date ctr_fechcon) {
		this.ctr_fechcon = ctr_fechcon;
	}

	public String getCtr_codusr() {
		return ctr_codusr;
	}

	public void setCtr_codusr(String ctr_codusr) {
		this.ctr_codusr = ctr_codusr;
	}

	public String getCtr_numtra() {
		return ctr_numtra;
	}

	public void setCtr_numtra(String ctr_numtra) {
		this.ctr_numtra = ctr_numtra;
	}

	public String getCtr_sec() {
		return ctr_sec;
	}

	public void setCtr_sec(String ctr_sec) {
		this.ctr_sec = ctr_sec;
	}

	public String getCtr_codmod() {
		return ctr_codmod;
	}

	public void setCtr_codmod(String ctr_codmod) {
		this.ctr_codmod = ctr_codmod;
	}

	public String getCtr_codpro() {
		return ctr_codpro;
	}

	public void setCtr_codpro(String ctr_codpro) {
		this.ctr_codpro = ctr_codpro;
	}

	public String getCtr_codtip() {
		return ctr_codtip;
	}

	public void setCtr_codtip(String ctr_codtip) {
		this.ctr_codtip = ctr_codtip;
	}

	public String getCtr_codmon() {
		return ctr_codmon;
	}

	public void setCtr_codmon(String ctr_codmon) {
		this.ctr_codmon = ctr_codmon;
	}

	public String getCtr_codtra() {
		return ctr_codtra;
	}

	public void setCtr_codtra(String ctr_codtra) {
		this.ctr_codtra = ctr_codtra;
	}

	public String getCtr_rubro() {
		return ctr_rubro;
	}

	public void setCtr_rubro(String ctr_rubro) {
		this.ctr_rubro = ctr_rubro;
	}

	public Date getCtr_fechavig() {
		return ctr_fechavig;
	}

	public void setCtr_fechavig(Date ctr_fechavig) {
		this.ctr_fechavig = ctr_fechavig;
	}

	public Date getCtr_fechor() {
		return ctr_fechor;
	}

	public void setCtr_fechor(Date ctr_fechor) {
		this.ctr_fechor = ctr_fechor;
	}

	public String getCtr_val() {
		return ctr_val;
	}

	public void setCtr_val(String ctr_val) {
		this.ctr_val = ctr_val;
	}

	public String getCtr_saldo_efectivo() {
		return ctr_saldo_efectivo;
	}

	public void setCtr_saldo_efectivo(String ctr_saldo_efectivo) {
		this.ctr_saldo_efectivo = ctr_saldo_efectivo;
	}

	public String getCtr_tipo_tra() {
		return ctr_tipo_tra;
	}

	public void setCtr_tipo_tra(String ctr_tipo_tra) {
		this.ctr_tipo_tra = ctr_tipo_tra;
	}

	public String getCtr_num_cue() {
		return ctr_num_cue;
	}

	public void setCtr_num_cue(String ctr_num_cue) {
		this.ctr_num_cue = ctr_num_cue;
	}

	public String getCtr_request() {
		return ctr_request;
	}

	public void setCtr_request(String ctr_request) {
		this.ctr_request = ctr_request;
	}

	public String getCtr_estado() {
		return ctr_estado;
	}

	public void setCtr_estado(String ctr_estado) {
		this.ctr_estado = ctr_estado;
	}

	public Date getCtr_fecha_proceso() {
		return ctr_fecha_proceso;
	}

	public void setCtr_fecha_proceso(Date ctr_fecha_proceso) {
		this.ctr_fecha_proceso = ctr_fecha_proceso;
	}

	@Override
	public String toString() {
		return "ListadoMaestroNotificaciones [ctr_id=" + ctr_id + ", ctr_id_proceso=" + ctr_id_proceso
				+ ", ctr_fechcon=" + ctr_fechcon + ", ctr_codusr=" + ctr_codusr + ", ctr_numtra=" + ctr_numtra
				+ ", ctr_tipo_tra=" + ctr_tipo_tra + ", ctr_num_cue=" + ctr_num_cue + ", ctr_estado=" + ctr_estado
				+ "]";
	}

}
