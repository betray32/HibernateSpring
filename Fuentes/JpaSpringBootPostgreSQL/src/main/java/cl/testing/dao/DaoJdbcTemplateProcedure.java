package cl.testing.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import cl.testing.CustomYMLFile;
import cl.testing.HibernateTestingDao;

/**
 * Permite conectarse hacia procedimientos almacenados
 * 
 * @author camilongo
 *
 */
@Repository
public class DaoJdbcTemplateProcedure {

	/**
	 * LOG
	 */
	private static final Log log = LogFactory.getLog(HibernateTestingDao.class);

	/**
	 * JDBC Template
	 */
	@Autowired
	private JdbcTemplate jdbcTemplate;

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
	public void obtenerDatosPersonasJDBC() {

		try {

			log.info("Consultando la data de todos los clientes");
			log.info("Procediendo a realizar la consulta con el objeto [JdbcTemplate]");
			SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName(prop.getPROCEDURE_OBTENER_PERSONAS());

			log.info("Consultando");
			Map<String, Object> outputMap = jdbcCall.execute();
			log.info("Lista consultada exitosamente");

			for (Map.Entry<String, Object> entry : outputMap.entrySet()) {

				log.info("KEY : " + entry.getKey());
				log.info("VALUE : " + entry.getValue());

			}

		} catch (Exception e) {
			log.error("Error al consultar procedure [" + prop.getPROCEDURE_OBTENER_PERSONAS() + "] , Detalle > " + e.getMessage());
		}

	}

	/**
	 * Consulta la lista de personas , este procedimiento no tiene parametros de entrada ni de salida y
	 * devuelve un cursor
	 */
	public void obtenerDatosPersonasJDBCParam(int idPersona) {

		try {

			log.info("Consultando la data de todos los clientes");
			log.info("Procediendo a realizar la consulta con el objeto [JdbcTemplate]");

			// Inicializacion
			SimpleJdbcCall query = new SimpleJdbcCall(jdbcTemplate).withProcedureName(prop.getPROCEDURE_OBTENER_PERSONA_ID());

			// Parametro de entrada
			SqlParameter params = new SqlParameter("idregistro", java.sql.Types.INTEGER);
			query.addDeclaredParameter(params);

			Map<String, Integer> callParams = new HashMap<String, Integer>();
			callParams.put("idregistro", idPersona);

			// Ejemplo de Param Salida
			// query.addDeclaredParameter(new SqlOutParameter("outParam1",OracleTypes.VARCHAR)); // Ejemplo

			log.info("Consultando");
			Map<String, Object> outputMap = query.execute(callParams);
			log.info("Lista consultada exitosamente");

			for (Map.Entry<String, Object> entry : outputMap.entrySet()) {

				log.info("KEY : " + entry.getKey());
				log.info("VALUE : " + entry.getValue());

			}

		} catch (Exception e) {
			log.error("Error al consultar procedure [" + prop.getPROCEDURE_OBTENER_PERSONAS() + "] , Detalle > " + e.getMessage());
		}

	}

}
