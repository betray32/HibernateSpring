package cl.testing.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cl.testing.dao.DaoJdbcTemplateProcedure;

/**
 * Permite probar procedimientos almacenados
 * 
 * @author ccontrerasc
 *
 */
@DisplayName("Pruebas para Store Procedures con el objeto JDBC Template")
@SpringBootTest
class ConexionStoreProcedureJdbcTest {

	/**
	 * LOG
	 */
	private static final Log log = LogFactory.getLog(ConexionStoreProcedureJdbcTest.class);

	/**
	 * Conexion al procedimiento
	 */
	@Autowired
	private DaoJdbcTemplateProcedure sp;

	@BeforeEach
	void setUp() throws Exception {
		log.info("-------------------------------");
		log.info("Inicializando Test para [Conexion Stored Procedure JDBC]");
	}

	@AfterEach
	void tearDown() throws Exception {
		log.info("Test Finalizado para [Conexion Stored Procedure JDBC]");
	}

	/**
	 * Probar la funcionalidad
	 */
	@DisplayName("Prueba Query Solo Cursor")
	@Test
	void testObtenerDatosPersonas() {

		log.info("Consultando procedimiento Obtener Personas JDBC");
		sp.obtenerDatosPersonasJDBC();

	}

	/**
	 * Probar la funcionalidad
	 */
	@DisplayName("Prueba Query Solo Cursor con ID Parametro")
	@Test
	void testObtenerDatosPersonasID() {

		log.info("Consultando procedimiento Obtener Personas por ID [JDBC]");

		int idPersonaTest = 1;
		log.info("ID TEST : " + idPersonaTest);
		sp.obtenerDatosPersonasJDBCParam(idPersonaTest);

	}

}
