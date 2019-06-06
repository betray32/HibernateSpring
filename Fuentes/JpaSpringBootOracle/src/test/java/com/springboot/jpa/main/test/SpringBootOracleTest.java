package com.springboot.jpa.main.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Ejecucion de pruebas
 * 
 * @author ccontrerasc
 *
 */
@SpringBootTest
class SpringBootOracleTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		System.out.println("Hola");
	}

}
