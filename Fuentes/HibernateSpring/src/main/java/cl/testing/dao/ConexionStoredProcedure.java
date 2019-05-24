package cl.testing.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cl.testing.CustomYMLFile;
import cl.testing.HibernateTestingDao;
import cl.testing.bean.Person;

/**
 * Permite conectarse hacia procedimientos almacenados
 * 
 * @author camilongo
 *
 */
@Repository
public class ConexionStoredProcedure {

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
	 * Consulta la lista de personas
	 */
	public List<Person> obtenerDatosPersonas() {

		try {

			log.info("Procediendo a obtener el detalle de los clientes");
			StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery(prop.getPROCEDURE_OBTENER_PERSONAS(), Person.class);

			@SuppressWarnings("unchecked")
			List<Person> res = storedProcedureQuery.getResultList();

			log.info("Lista consultada exitosamente");
			log.info("Recorriendo lista de salida...");
			for (Person p : res) {
				log.info("Persona : " + p);
			}

			return res;

		} catch (Exception e) {
			log.error("Error al consultar procedure [" + prop.getPROCEDURE_OBTENER_PERSONAS() + "] , Detalle > " + e.getMessage());
		}

		return null;
	}

}
