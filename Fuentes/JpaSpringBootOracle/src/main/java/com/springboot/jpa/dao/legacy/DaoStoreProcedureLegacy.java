package com.springboot.jpa.dao.legacy;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.jpa.main.CustomYMLFile;

/**
 * Conexiones con procedimientos almacenados PostPracle
 * 
 * @author camilongo
 *
 */
@Repository
public class DaoStoreProcedureLegacy {

	/**
	 * LOG
	 */
	private static final Log log = LogFactory.getLog(DaoStoreProcedureLegacy.class);

	/**
	 * Maneja las conexiones a bases de datos
	 */
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Properties
	 * 
	 * @return
	 */
	@Autowired
	private CustomYMLFile prop;

	@Autowired
	private org.springframework.core.env.Environment env;

	/*****************
	 * Mensajes
	 */
	private static final String PROCEDURE = "Procedure > ";
	private static final String PROCEDIMIENTO_CONSULTADO_EXITOSAMENTE = "Procedimiento consultado exitosamente";
	private static final String CONEXION_CERRADA_EXITOSAMENTE = "Conexion Cerrada Exitosamente";
	private static final String PROCEDURE_EJECUTADO_OK = "Procedure ejecutado OK";
	private static final String EJECUTANDO_PROCEDURE = "Ejecutando Procedure...";
	private static final String SETEANDO_PARAMETROS = "Seteando Parametros...";
	private static final String CONEXION_OK = "Conexion OK";
	private static final String ERROR_CONSULTAR_EXCEPCION = "Ha ocurrido un problema al consultar, Detalle > ";
	private static final String CONECTANDO_ORACLE = "Conectando al recurso DataSource DB Oracle indicada > ";
	private static final String ERROR_CERRAR_CONEXIONES = "Ha ocurrido un problema al cerrar la conexion, Detalle > ";
	private static final String CONECTANDO_PROCEDURE = "Conectando al Procedure indicado > ";

	/**
	 * Consulta la lista de personas , este procedimiento no tiene parametros de entrada ni de salida y
	 * devuelve un cursor
	 */
	public <T> List<T> obtenerDatosPersonas(RowMapper<T> rowMapper) {

		try {

			// Generacion de Objetos
			List<T> models = new ArrayList<>();
			Connection dbConexion = null;
			CallableStatement dbComando = null;
			ResultSet dbResultados = null;

			// Data de conexion
			String urlConexion = env.getProperty("spring.datasource.url");
			String procedure = prop.getPROCEDURE_DEVUELVE_CURSOR();
			/****************************************************/

			try {

				log.info(CONECTANDO_ORACLE + urlConexion);
				dbConexion = DriverManager.getConnection(urlConexion);
				log.info(CONEXION_OK);

				log.info(CONECTANDO_PROCEDURE + procedure);
				procedure = DiccionarioProcedimientos.armarProcedure(procedure, 1);
				dbComando = dbConexion.prepareCall(procedure);
				log.info(PROCEDURE + procedure);

				log.info(SETEANDO_PARAMETROS);
				dbComando.registerOutParameter(1, ConstantesBD.ORACLE_CURSOR_CODE);

				log.info(EJECUTANDO_PROCEDURE);
				dbComando.execute();
				log.info(PROCEDURE_EJECUTADO_OK);

				dbResultados = (ResultSet) dbComando.getObject(1);

				if (dbResultados == null) {
					log.info("Procedure no retorna resultado: " + procedure);
				} else {

					while (dbResultados.next()) {
						T model = rowMapper.mapper(dbResultados);
						models.add(model);
					}

					log.info(PROCEDIMIENTO_CONSULTADO_EXITOSAMENTE);

				}

			} catch (Exception e) {
				log.error(ERROR_CONSULTAR_EXCEPCION + e.getMessage());

			} finally {
				try {
					cerrarConexion(dbConexion, dbComando, dbResultados);
					log.info(CONEXION_CERRADA_EXITOSAMENTE);
				} catch (SQLException e) {
					log.error(ERROR_CERRAR_CONEXIONES + e.getMessage());
				}
			}

			/****************************************************/

		} catch (Exception e) {
			log.error("Error al consultar procedure [" + prop.getPROCEDURE_DEVUELVE_CURSOR() + "] , Detalle > " + e.getMessage());
		}

		return null;
	}

	/**
	 * Permite cerrar las conexiones
	 * 
	 * @param dbConexion
	 * @param dbComando
	 * @param dbResultados
	 * @throws SQLException
	 */
	private void cerrarConexion(Connection dbConexion, CallableStatement dbComando, ResultSet dbResultados) throws SQLException {
		if (dbResultados != null) {
			dbResultados.close();
		}

		if (dbComando != null) {
			dbComando.close();
		}

		if (dbConexion != null) {
			dbConexion.close();
		}
	}

}
