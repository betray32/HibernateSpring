package cl.testing;

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
		SpringApplication.run(HibernateSpringApplication.class, args);
	}

}
