package com.springboot.jpa.main.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.jpa.dao.ConexionQueryDirecta;
import com.springboot.jpa.dao.DaoStoreProcedureJpa;

/**
 * Ejecucion de pruebas
 * 
 * @author ccontrerasc
 *
 */
@SpringBootTest
class SpringBootOracleTest {

	/**
	 * LOG
	 */
	private static final Log log = LogFactory.getLog(SpringBootOracleTest.class);

	/**
	 * ConexionQueryDirecta
	 */
	@Autowired
	private ConexionQueryDirecta query;
	
	@Autowired
	private DaoStoreProcedureJpa sp;

	@BeforeEach
	void setUp() throws Exception {
		log.info("-----------------------------------------");
		log.info("Inicializando Test Oracle");
	}

	@AfterEach
	void tearDown() throws Exception {
		log.info("Finalizando Test");
	}

	/**
	 * Consultar mediante query directo
	 */
	@Test
	void testQueryDirecta() {
		log.info("Test [testQueryDirecta]");
		assertTrue(query.consultaQueryDirecta());
	}
	
	/**
	 * Consultar el procedure
	 */
	@Test
	void testStoreProcedure() {
		log.info("Test [testStoreProcedure]");
		assertNotNull(sp.obtenerDatosPersonas());
	}

}
