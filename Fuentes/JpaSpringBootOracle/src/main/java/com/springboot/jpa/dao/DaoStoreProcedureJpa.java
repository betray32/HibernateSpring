package com.springboot.jpa.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.springboot.jpa.bean.ListadoMaestroNotificaciones;
import com.springboot.jpa.bean.Persona;
import com.springboot.jpa.main.CustomYMLFile;

/**
 * Conexiones con procedimientos almacenados Oracle
 * 
 * @author camilongo
 *
 */
@Repository
public class DaoStoreProcedureJpa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -483131550552335272L;

	/**
	 * LOG
	 */
	private static final Log log = LogFactory.getLog(DaoStoreProcedureJpa.class);

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
	private JdbcTemplate jdbcTemplate;

	/**
	 * Consulta la lista de personas , este procedimiento no tiene parametros de
	 * entrada ni de salida y devuelve un cursor
	 */
	public List<Persona> obtenerDatosPersonas() {

		try {

			log.info("Procediendo a obtener el detalle de los clientes");
			StoredProcedureQuery storedProcedureQuery = entityManager
					.createStoredProcedureQuery(prop.getPROCEDURE_DEVUELVE_CURSOR())
					.registerStoredProcedureParameter(1, Class.class, ParameterMode.REF_CURSOR);

			@SuppressWarnings("unchecked")
			List<Persona> result = storedProcedureQuery.getResultList();

			log.info("Lista consultada exitosamente");

			return result;

		} catch (Exception e) {
			log.error("Error al consultar procedure [" + prop.getPROCEDURE_DEVUELVE_CURSOR() + "] , Detalle > " + e.getMessage());
		}

		return null;
	}

	/**
	 * Consultar SP - Funciona
	 * 
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public  List<ListadoMaestroNotificaciones> jdbcTemplateQuery() {
		
		jdbcTemplate.setResultsMapCaseInsensitive(true);

		SimpleJdbcCall simpleJdbcCallRefCursor = new SimpleJdbcCall(jdbcTemplate)
				.withCatalogName("PKGBC_NOTIFICACIONES")
				.withProcedureName("SP_GET_BLOQUE")
				.returningResultSet("OUT_ESTADO", BeanPropertyRowMapper.newInstance(ListadoMaestroNotificaciones.class));

		SqlParameterSource paramaters = new MapSqlParameterSource().addValue("P_ESTADO", 1);

		log.info("Ejecutando SP...");
		Map out = simpleJdbcCallRefCursor.execute(paramaters);
		log.info("Procedure Ejecutado Correctamente");
		
		List<ListadoMaestroNotificaciones> res = (List) out.get("OUT_ESTADO");
		if ( res != null) {
			log.info("Lista de Salida Obtenida Exitosamente");
			return res;
		}
		
		return res;
	}

}
