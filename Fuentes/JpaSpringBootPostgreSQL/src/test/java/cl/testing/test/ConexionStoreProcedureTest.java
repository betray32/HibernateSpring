package cl.testing.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cl.testing.bean.PersonEntity;
import cl.testing.dao.DaoStoreProcedureQuery;

/**
 * Permite probar procedimientos almacenados
 * 
 * @author ccontrerasc
 *
 */
@DisplayName("Pruebas para Store Procedures")
@SpringBootTest
class ConexionStoreProcedureTest {

	/**
	 * LOG
	 */
	private static final Log log = LogFactory.getLog(ConexionStoreProcedureTest.class);

	/**
	 * Conexion al procedimiento
	 */
	@Autowired
	private DaoStoreProcedureQuery sp;

	@BeforeEach
	void setUp() throws Exception {
		log.info("---------------------------------------------------");
		log.info("Inicializando Test para [Conexion Stored Procedure]");
	}

	@AfterEach
	void tearDown() throws Exception {
		log.info("Test Finalizado para [Conexion Stored Procedure]");
	}

	/**
	 * Probar la funcionalidad
	 */
	@DisplayName("SP_CURSOR SALIDA")
	@Test
	void testObtenerDatosPersonas() {

		log.info("Consultando procedimiento Obtener Personas");
		List<PersonEntity> personas = sp.obtenerDatosPersonas();

		// Validar que no sea nulo
		assertNotNull(personas);

		// Validar que contenga data
		assertFalse(personas.isEmpty());
	}

	/**
	 * Probar la funcionalidad
	 */
	@DisplayName("SP_CURSOR con Id entrada")
	@Test
	void testObtenerDatosPersonasID() {

		log.info("Consultando procedimiento Obtener Personas POR ID");

		int idCliente = 1;
		log.info("Consultando Cliente : " + idCliente);

		List<PersonEntity> personas = sp.obtenerDatosPersonasPorId(idCliente);

		// Validar que no sea nulo
		assertNotNull(personas);

		// Validar que contenga data
		assertFalse(personas.isEmpty());
	}

	/**
	 * Probar la funcionalidad
	 */
	@DisplayName("SP_ESPECIFICO Filtrado por ID")
	@Test
	void testObtenerDatosPersonasEspecifico() {

		log.info("Consultando procedimiento Obtener datos especificos x ID");

		int idCliente = 1;
		log.info("Consultando Cliente : " + idCliente);

		int salida = sp.obtenerDatosPersonaEspecifico(idCliente);

		// 1 = OK
		assertEquals(1, salida);

	}

}
