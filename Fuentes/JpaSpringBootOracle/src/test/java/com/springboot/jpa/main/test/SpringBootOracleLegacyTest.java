package com.springboot.jpa.main.test;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.jpa.bean.Persona;
import com.springboot.jpa.dao.legacy.DaoStoreProcedureLegacy;
import com.springboot.jpa.dao.legacy.GetPersonasMapper;;

/**
 * Ejecucion de pruebas
 * 
 * @author ccontrerasc
 *
 */
@SpringBootTest
class SpringBootOracleLegacyTest {

	/**
	 * LOG
	 */
	private static final Log log = LogFactory.getLog(SpringBootOracleLegacyTest.class);

	/**
	 * ConexionQueryDirecta
	 */
	@Autowired
	private DaoStoreProcedureLegacy sp;

	@BeforeEach
	void setUp() throws Exception {
		log.info("-----------------------------------------");
		log.info("Inicializando Test Oracle Legacy");
	}

	@AfterEach
	void tearDown() throws Exception {
		log.info("Finalizando Test");
	}

	/**
	 * Consultar el procedure
	 */
	@Test
	void testStoreProcedureLegacy() {
		
		log.info("Test [DaoStoreProcedureLegacy]");
		List<Persona> salida = sp.obtenerDatosPersonas(new GetPersonasMapper());
		
		assertNotNull(salida);
	}

}
