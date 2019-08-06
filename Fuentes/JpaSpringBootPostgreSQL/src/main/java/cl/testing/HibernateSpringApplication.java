package cl.testing;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(CustomYMLFile.class)
public class HibernateSpringApplication {

	/**
	 * Launcher
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Inicializando SpringBoot JPA PostgreSQL , Date : " + new Date());
		SpringApplication.run(HibernateSpringApplication.class, args);
	}

}
