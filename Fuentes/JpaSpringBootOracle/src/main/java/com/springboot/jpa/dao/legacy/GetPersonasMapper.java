package com.springboot.jpa.dao.legacy;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.springboot.jpa.bean.ListadoMaestroNotificaciones;

/**
 * Mapea la salida para el procedure
 * 
 * @author ccontrerasc
 *
 */
public class GetPersonasMapper implements RowMapper<ListadoMaestroNotificaciones> {

	/**
	 * LOG
	 */
	private static final Log log = LogFactory.getLog(GetPersonasMapper.class);

	/**
	 * Obtener los datos de respuesta para el procedure
	 * SPCTC_PAC_TC_ESTADO_LST
	 */
	public ListadoMaestroNotificaciones mapper(ResultSet rs) throws SQLException {

		try {

			if (rs != null) {

				ListadoMaestroNotificaciones bean = new ListadoMaestroNotificaciones();
				bean.setCtr_id(rs.getString("ctr_id"));
				bean.setCtr_id_proceso(rs.getString("ctr_id_proceso"));
				bean.setCtr_fechcon(rs.getDate("ctr_fechcon"));
				bean.setCtr_codusr(rs.getString("ctr_codusr"));
				bean.setCtr_numtra(rs.getString("ctr_numtra"));
				bean.setCtr_sec(rs.getString("ctr_sec"));
				bean.setCtr_codmod(rs.getString("ctr_codmod"));
				bean.setCtr_codpro(rs.getString("ctr_codpro"));
				bean.setCtr_codtip(rs.getString("ctr_codtip"));
				bean.setCtr_codmon(rs.getString("ctr_codmon"));
				bean.setCtr_codtra(rs.getString("ctr_codtra"));
				bean.setCtr_rubro(rs.getString("ctr_rubro"));
				bean.setCtr_fechavig(rs.getDate("ctr_fechavig"));
				bean.setCtr_fechor(rs.getDate("ctr_fechor"));
				bean.setCtr_val(rs.getString("ctr_val"));
				bean.setCtr_saldo_efectivo(rs.getString("ctr_saldo_efectivo"));
				bean.setCtr_tipo_tra(rs.getString("ctr_tipo_tra"));
				bean.setCtr_num_cue(rs.getString("ctr_num_cue"));
				bean.setCtr_request(rs.getString("ctr_request"));
				bean.setCtr_estado(rs.getString("ctr_estado"));
				bean.setCtr_fecha_proceso(rs.getDate("ctr_fecha_proceso"));

				return bean;

			}

		} catch (Exception e) {
			log.error("Error al obtener los datos desde el ResultSet, ERROR: " + e.getMessage());
		}

		return null;
	}

}
