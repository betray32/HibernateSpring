package com.springboot.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.jpa.bean.Persona;
import com.springboot.jpa.bean.PersonaEntity;
import com.springboot.jpa.main.CustomYMLFile;

/**
 * Conexiones con procedimientos almacenados PostGres
 * 
 * @author camilongo
 *
 */
@Repository
public class DaoStoreProcedureProcedure {

	/**
	 * LOG
	 */
	private static final Log log = LogFactory.getLog(DaoStoreProcedureProcedure.class);

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

	/**
	 * Consulta la lista de personas , este procedimiento no tiene parametros de entrada ni de salida y
	 * devuelve un cursor
	 */
	public List<Persona> obtenerDatosPersonas() {

		try {

			log.info("Procediendo a obtener el detalle de los clientes");
			StoredProcedureQuery storedProcedureQuery = entityManager

					// Definicion
					.createStoredProcedureQuery(prop.getPROCEDURE_DEVUELVE_CURSOR())
					.registerStoredProcedureParameter(
						    1,
						    Class.class,
						    ParameterMode.REF_CURSOR
						);

			@SuppressWarnings("unchecked")
			List<PersonaEntity> res = storedProcedureQuery.getResultList();

			log.info("Lista consultada exitosamente");
			log.info("Recorriendo lista de salida...");
			
			
	
		} catch (Exception e) {
			log.error("Error al consultar procedure [" + prop.getPROCEDURE_DEVUELVE_CURSOR() + "] , Detalle > " + e.getMessage());
		}

		return null;
	}

}
