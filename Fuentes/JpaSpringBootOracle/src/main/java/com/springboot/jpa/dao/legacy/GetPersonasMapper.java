package com.springboot.jpa.dao.legacy;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.springboot.jpa.bean.Persona;

/**
 * Mapea la salida para el procedure
 * 
 * @author ccontrerasc
 *
 */
public class GetPersonasMapper implements RowMapper<Persona> {

	/**
	 * LOG
	 */
	private static final Log log = LogFactory.getLog(DaoStoreProcedureLegacy.class);

	/**
	 * Obtener los datos de respuesta para el procedure RES_GET_BUSCAR_RESUMEN_CLIENTES
	 */
	public Persona mapper(ResultSet paramResultSet) throws SQLException {

		try {

			if (paramResultSet != null) {

				Persona o = new Persona();
				o.setIDPERSONA(paramResultSet.getInt(1));
				o.setNOMBRE(paramResultSet.getString(2));
				o.setAPELLIDO(paramResultSet.getString(3));
				o.setDIRECCION(paramResultSet.getString(4));

				return o;

			}

		} catch (Exception e) {
			log.error("Error al obtener los datos desde el ResultSet, ERROR: " + e.getMessage());
		}

		return null;
	}

}
