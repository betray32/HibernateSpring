package cl.testing.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cl.testing.CustomYMLFile;
import cl.testing.HibernateTestingDao;
import cl.testing.bean.PersonEntity;

/**
 * Conexiones con procedimientos almacenados PostGres
 * 
 * @author camilongo
 *
 */
@Repository
public class DaoStoreProcedureQuery {

	/**
	 * LOG
	 */
	private static final Log log = LogFactory.getLog(HibernateTestingDao.class);

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
	public List<PersonEntity> obtenerDatosPersonas() {

		try {

			log.info("Procediendo a obtener el detalle de los clientes");
			StoredProcedureQuery storedProcedureQuery = entityManager
					
					// Definicion
					.createStoredProcedureQuery(prop.getPROCEDURE_OBTENER_PERSONAS(), PersonEntity.class);

			@SuppressWarnings("unchecked")
			List<PersonEntity> res = storedProcedureQuery.getResultList();

			log.info("Lista consultada exitosamente");
			log.info("Recorriendo lista de salida...");
			for (PersonEntity p : res) {
				log.info("Persona : " + p);
			}

			return res;

		} catch (Exception e) {
			log.error("Error al consultar procedure [" + prop.getPROCEDURE_OBTENER_PERSONAS() + "] , Detalle > " + e.getMessage());
		}

		return null;
	}

	/**
	 * Permite consultar un procedimiento que devuelve un cursor y recibe un parametro de entrada que es
	 * el id del cliente a obtener
	 * 
	 * @param idCliente
	 * @return
	 */
	public List<PersonEntity> obtenerDatosPersonasPorId(int idCliente) {

		try {

			log.info("Procediendo a obtener el detalle de los clientes filtrando por ID");
			StoredProcedureQuery storedProcedureQuery = entityManager
					
					// Definicion
					.createStoredProcedureQuery(prop.getPROCEDURE_OBTENER_PERSONA_ID(), PersonEntity.class)

					// Entradas
					.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN)

					// Parametros
					.setParameter(1, idCliente);

			@SuppressWarnings("unchecked")
			List<PersonEntity> res = storedProcedureQuery.getResultList();

			log.info("Lista consultada exitosamente");
			log.info("Recorriendo lista de salida...");
			for (PersonEntity p : res) {
				log.info("Persona : " + p);
			}

			return res;

		} catch (Exception e) {
			log.error("Error al consultar procedure [" + prop.getPROCEDURE_OBTENER_PERSONA_ID() + "] , Detalle > " + e.getMessage());
		}

		return null;
	}

	/**
	 * Obtener el nombre y direccion como parametros separados, dependiendo del id del cliente
	 * 
	 * @param idCliente
	 * @return
	 */
	public int obtenerDatosPersonaEspecifico(int idCliente) {

		try {

			log.info("Procediendo a obtener salidas especificas para la persona");
			StoredProcedureQuery storedProcedureQuery = entityManager
					
					// Definicion
					.createStoredProcedureQuery(prop.getPROCEDURE_OBTENER_DATOS_UNICOS())

					// Entradas
					.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN)

					// Salidas
					.registerStoredProcedureParameter(2, String.class, ParameterMode.OUT)
					.registerStoredProcedureParameter(3, String.class, ParameterMode.OUT)

					// Parametros
					.setParameter(1, idCliente);

			log.info("Ejecutando Procedimiento...");
			storedProcedureQuery.execute();
			log.info("Procedimiento ejecutado");

			// Obtener los datos de salida
			String nombre = (String) storedProcedureQuery.getOutputParameterValue(2);
			String direccion = (String) storedProcedureQuery.getOutputParameterValue(3);

			log.info("SALIDA: Nombre = " + nombre + " , Direccion = " + direccion);
			return 1;

		} catch (Exception e) {
			log.error("Error al consultar procedure [" + prop.getPROCEDURE_OBTENER_PERSONA_ID() + "] , Detalle > " + e.getMessage());
		}
		
		return 0;

	}

}
