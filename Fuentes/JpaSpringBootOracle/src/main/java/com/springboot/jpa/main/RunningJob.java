package com.springboot.jpa.main;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Repository;

import com.springboot.jpa.dao.ConexionQueryDirecta;

/**
 * Permite ejecutar una accion automatica al iniciar el proceso
 * 
 * @author ccontrerasc
 *
 */
@Repository
public class RunningJob implements CommandLineRunner {

	/**
	 * LOG
	 */
	private static final Log log = LogFactory.getLog(RunningJob.class);

	/**
	 * Ejecucion automatica
	 */
	@Override
	public void run(String... args) throws Exception {

		log.info("Run Automatico desde [CommandLineRunner]");

	}

}
