package com.springboot.jpa.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.jpa.bean.Persona;
import com.springboot.jpa.main.CustomYMLFile;

/**
 * Consultas para bases de datos con querys , esto incluye conexiones directas a la base de datos
 * mediante querys , ademas se explica un ejemplo de parametros
 * 
 * @author ccontrerasc
 *
 */
@Repository
public class ConexionQueryDirecta {

	/**
	 * LOG
	 */
	private static final Log log = LogFactory.getLog(ConexionQueryDirecta.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	/**
	 * Properties
	 */
	@Autowired
	private CustomYMLFile properties;

	/**
	 * Query Directa
	 */
	public boolean consultaQueryDirecta() {

		String query = properties.getQUERY_DIRECTA();
		log.info("Comenzando la ejecucion mediante Query Directa");
		log.info("Query : " + query);

		List<Persona> listaSalida = null;

		try {
			listaSalida = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Persona.class));
		} catch (Exception e) {
			log.error("Error al consultar , Detalle > " + e.getMessage());
		}

		if (listaSalida != null) {

			log.info("Lista consultada exitosamente");
			for (Persona p : listaSalida) {
				log.info("PERSON : " + p);
			}

			return true;
		} else {
			log.error("Error al consultar");
		}

		return false;
	}

}
