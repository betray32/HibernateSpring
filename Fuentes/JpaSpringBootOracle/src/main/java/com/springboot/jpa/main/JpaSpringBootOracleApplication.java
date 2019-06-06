package com.springboot.jpa.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Launcher
 * 
 * @author ccontrerasc
 *
 */
@SpringBootApplication
@EnableConfigurationProperties(CustomYMLFile.class)
public class JpaSpringBootOracleApplication {

	/**
	 * Main Method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(JpaSpringBootOracleApplication.class, args);
	}

}
