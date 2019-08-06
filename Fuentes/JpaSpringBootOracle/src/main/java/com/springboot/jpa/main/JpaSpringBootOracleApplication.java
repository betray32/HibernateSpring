package com.springboot.jpa.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

/**
 * Launcher
 * 
 * @author ccontrerasc
 *
 */
@SpringBootApplication
@ComponentScan({ "com.springboot.jpa.dao", "com.springboot.jpa.bean", "com.springboot.jpa.main", "com.springboot.jpa.dao.legacy" })
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
