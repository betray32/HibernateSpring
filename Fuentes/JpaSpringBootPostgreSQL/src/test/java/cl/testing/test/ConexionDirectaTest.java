package cl.testing.test;

import static org.junit.Assert.assertTrue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cl.testing.dao.ConexionQueryDirecta;

/**
 * Probar la conexion directa
 * 
 * @author ccontrerasc
 *
 */
@DisplayName("Pruebas para Conexiones Directas")
@SpringBootTest
class ConexionDirectaTest {

	/**
	 * LOG
	 */
	private static final Log log = LogFactory.getLog(ConexionDirectaTest.class);

	/**
	 * Conexion con las Querys
	 */
	@Autowired
	private ConexionQueryDirecta queryDirecta;

	@BeforeEach
	void setUp() throws Exception {
		log.info("-------------------------------");
		log.info("Inicializando Test para [ConexionQueryDirecta]");
	}

	@AfterEach
	void tearDown() throws Exception {
		log.info("Test Finalizado para [ConexionQueryDirecta]");
	}

	/**
	 * testConsultaQueryDirecta
	 */
	@DisplayName("Probando la Conexion Directa")
	@Test
	void testConsultaQueryDirecta() {
		log.info("Consultando Query Directa");
		assertTrue(queryDirecta.consultaQueryDirecta());
	}

	/**
	 * testConsultaQueryParam
	 */
	@DisplayName("Probando Query con Parametro")
	@Test
	void testConsultaQueryParam() {

		int idPersona = 1;

		log.info("Consultando por el id : " + idPersona);
		assertTrue(queryDirecta.consultaQueryParam(idPersona));
	}

}
