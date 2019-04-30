package cl.testing;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.procedure.ProcedureOutputs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Repository;

import cl.testing.bean.BeanSalidaProcedure;

/**
 * HibernateTestingDao
 * 
 * @author ccontrerasc
 *
 */
@Repository
public class HibernateTestingDao implements CommandLineRunner {

	/**
	 * LOG
	 */
	private static final Log log = LogFactory.getLog(HibernateTestingDao.class);

	/**
	 * Conector con la base de datos
	 */
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Properties
	 */
	@Autowired
	private CustomYMLFile properties;

	/**
	 * Ejecucion automatica
	 */
	@Override
	public void run(String... args) throws Exception {

		log.info("Iniciando la Ejecucion");

		//procedureSalidaCursor();
		procedureSalidaMixta();

		log.info("La ejecucion del proceso ha finalizado");

	}

	/**
	 * Salida Cursor
	 */
	private void procedureSalidaCursor() {

		log.info("Conectando al procedure : " + properties.getProcedureSalidaCursor());

		try {

			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			java.sql.Date fechaQuery = new java.sql.Date(df.parse("2017-07-17").getTime());

			StoredProcedureQuery query = entityManager
					/*
					 * Procedure a llamar
					 */
					.createStoredProcedureQuery(properties.getProcedureSalidaCursor())
					/*
					 * Entradas
					 */
					.registerStoredProcedureParameter(1, Date.class, ParameterMode.IN)
					.registerStoredProcedureParameter(2, String.class, ParameterMode.IN)
					/*
					 * Salidas
					 */
					.registerStoredProcedureParameter(3, Void.class, ParameterMode.REF_CURSOR)

					/*
					 * Parametros de entrada
					 */
					.setParameter(1, fechaQuery) // FECHA
					.setParameter(2, "77647538"); // RUT

			log.info("Ejecutando Procedure");
			query.execute();
			log.info("Procedure Ejecutado");

			@SuppressWarnings("unchecked")
			List<Object[]> cursorOut = query.getResultList();

			log.info("Parametros obtenidos correctamente");

		} catch (Exception e) {
			log.error("Error al consultar BD , Detalle > ", e);
		}
	}

	/**
	 * Salidas Aisladas
	 */
	private void procedureSalidasAisladas() {

		log.info("Conectando al procedure : " + properties.getProcedureSalidasIndependientes());

		try {

			StoredProcedureQuery query = entityManager
					/*
					 * Procedure a llamar
					 */
					.createStoredProcedureQuery(properties.getProcedureSalidasIndependientes())
					/*
					 * Entradas
					 */
					.registerStoredProcedureParameter(1, String.class, ParameterMode.IN)
					/*
					 * Salidas
					 */
					.registerStoredProcedureParameter(2, String.class, ParameterMode.OUT)
					.registerStoredProcedureParameter(3, String.class, ParameterMode.OUT)
					.registerStoredProcedureParameter(4, String.class, ParameterMode.OUT)
					.registerStoredProcedureParameter(5, String.class, ParameterMode.OUT)

					/*
					 * Parametros de entrada
					 */
					.setParameter(1, null);

			log.info("Ejecutando Procedure");
			query.execute();
			log.info("Procedure Ejecutado");

			String DIR_ARCHIVO = (String) query.getOutputParameterValue(2);
			String DIR_RUTA_ORIGEN = (String) query.getOutputParameterValue(3);
			String DIR_IP_DESTINO = (String) query.getOutputParameterValue(4);
			String DIR_DESTINO = (String) query.getOutputParameterValue(5);

			log.info("Datos Salida");
			log.info(" Campo: DIR_ARCHIVO , VALOR : " + DIR_ARCHIVO);
			log.info(" Campo: DIR_RUTA_ORIGEN , VALOR : " + DIR_RUTA_ORIGEN);
			log.info(" Campo: DIR_IP_DESTINO , VALOR : " + DIR_IP_DESTINO);
			log.info(" Campo: DIR_DESTINO , VALOR : " + DIR_DESTINO);

			log.info("Parametros obtenidos correctamente");

		} catch (Exception e) {
			log.error("Error al consultar BD , Detalle > ", e);
		}
	}

	/**
	 * Salida Mixta
	 */
	private void procedureSalidaMixta() {

		log.info("Conectando al procedure : " + properties.getProcedureSalidaMixta());

		try {

			StoredProcedureQuery query = entityManager
					/*
					 * Procedure a llamar
					 */
					.createStoredProcedureQuery(properties.getProcedureSalidaMixta())
					/*
					 * Entradas
					 */
					.registerStoredProcedureParameter(1, String.class, ParameterMode.IN)
					/*
					 * Salidas
					 */
					.registerStoredProcedureParameter(2, Integer.class, ParameterMode.OUT)
					.registerStoredProcedureParameter(3, String.class, ParameterMode.OUT)
					.registerStoredProcedureParameter(4, Void.class, ParameterMode.REF_CURSOR)

					/*
					 * Parametros de entrada
					 */
					.setParameter(1, "codigoAplicacion"); // P_NOMBREPARAMETRO

			log.info("Ejecutando Procedure");
			query.execute();
			log.info("Procedure Ejecutado");

	
			String P_CODIGOERROR = (String) query.getOutputParameterValue(2);
			String P_DESCERROR = (String) query.getOutputParameterValue(3);
			
			@SuppressWarnings("unchecked")
			List<Object[]> cursorOut = query.getResultList();

			log.info("Parametros obtenidos correctamente");

		} catch (Exception e) {
			log.error("Error al consultar BD , Detalle > ", e);
		}
	}

}
