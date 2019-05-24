package cl.testing.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cl.testing.bean.Person;
import cl.testing.dao.ConexionStoredProcedure;

/**
 * Permite probar procedimientos almacenados
 * @author ccontrerasc
 *
 */
@DisplayName("Pruebas para Store Procedures")
@SpringBootTest
class ConexionStoreProcedureTest {
	
	/**
	 * LOG
	 */
	private static final Log log = LogFactory.getLog(ConexionDirectaTest.class);
	
	/**
	 * Conexion al procedimiento
	 */
	@Autowired
	private ConexionStoredProcedure sp;

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
	 * Probar la funcionalidad
	 */
	@DisplayName("Prueba Query Solo Cursor")
	@Test
	void testObtenerDatosPersonas() {
		
		log.info("Consultando procedimiento Obtener Personas");
		List<Person> personas = sp.obtenerDatosPersonas();
		
		// Validar que no sea nulo
		assertNotNull(personas);
		
		// Validar que contenga data
		assertFalse(personas.isEmpty());
	}

}
