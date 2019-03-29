package cl.testing;

import java.sql.Date;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Repository;

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
		
		/*
		 * Permite invocar a un procedimiento que retorna campos aislados de salida, sin cursores
		 */
		//procedureSalidasAisladas();
		
		/*
		 * Salida cursor
		 */
		//procedureSalidaCursor();
		
		/*
		 * Salida mixta
		 */
		//procedureSalidaMixta();
		
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
					.createStoredProcedureQuery(properties.getProcedureSalidaCursor(), BeanSalidaProcedure.class)
					/*
					 * Entradas
					 */
					.registerStoredProcedureParameter(1, Date.class, ParameterMode.IN)
					.registerStoredProcedureParameter(2, String.class, ParameterMode.IN)
					/*
					 * Salidas
					 */
					.registerStoredProcedureParameter(3, ResultSet.class, ParameterMode.REF_CURSOR)

					/*
					 * Parametros de entrada
					 */
					.setParameter(1, fechaQuery)
					.setParameter(2, "77647538");

			log.info("Ejecutando Procedure");
			query.execute();
			log.info("Procedure Ejecutado");

			List<BeanSalidaProcedure> listaSalida = query.getResultList();
			

			log.info("Parametros obtenidos correctamente");

		} catch (Exception e) {
			log.error("Error al consultar BD , Detalle > ", e);
		}
	}

	/**
	 * Ejemplo de invocacion con salidas aisladas
	 * 
	 * Detalle log salida:
	 * 
	 * 2019-03-13 11:58:37 INFO  c.t.HibernateTestingDao:70 - Conectando al procedure : XMBC_BPERSONA.PKG_CNS_INTERFAZFISA_GL_CCP.SPCNS_GL_DATOS_ARCHIVO
 	 * 2019-03-13 11:58:37 INFO  c.t.HibernateTestingDao:95 - Ejecutando Procedure
 	 * Hibernate: {call XMBC_BPERSONA.PKG_CNS_INTERFAZFISA_GL_CCP.SPCNS_GL_DATOS_ARCHIVO(?,?,?,?,?)}
	 * 2019-03-13 11:58:37 INFO  c.t.HibernateTestingDao:97 - Procedure Ejecutado
	 * 2019-03-13 11:58:37 INFO  c.t.HibernateTestingDao:104 - Datos Salida
	 * 2019-03-13 11:58:37 INFO  c.t.HibernateTestingDao:105 -  Campo: DIR_ARCHIVO , VALOR : CTACTEP0919.TXT
	 * 2019-03-13 11:58:37 INFO  c.t.HibernateTestingDao:106 -  Campo: DIR_RUTA_ORIGEN , VALOR : /data3/usuariosftp/ftp_fisa/utl_filedir
	 * 2019-03-13 11:58:37 INFO  c.t.HibernateTestingDao:107 -  Campo: DIR_IP_DESTINO , VALOR : 10.250.12.60
	 * 2019-03-13 11:58:37 INFO  c.t.HibernateTestingDao:108 -  Campo: DIR_DESTINO , VALOR : /u02/apps/applprod/product/xxbm/12.0.0/interfaces/gl/entrada
	 * 2019-03-13 11:58:37 INFO  c.t.HibernateTestingDao:110 - Parametros obtenidos correctamente
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
					.createStoredProcedureQuery(properties.getProcedureSalidaMixta() , BeanSalidaProcedure.class)
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
					.setParameter(1, "codigoAplicacion");

			log.info("Ejecutando Procedure");
			query.execute();
			log.info("Procedure Ejecutado");

			List<BeanSalidaProcedure> listaSalida =query.getResultList();
			
			String P_CODIGOERROR = (String) query.getOutputParameterValue(2);
			String P_DESCERROR = (String) query.getOutputParameterValue(3);
			


			log.info("Parametros obtenidos correctamente");

		} catch (Exception e) {
			log.error("Error al consultar BD , Detalle > ", e);
		}
	}

}
