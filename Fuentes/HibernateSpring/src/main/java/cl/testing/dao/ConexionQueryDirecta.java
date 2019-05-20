package cl.testing.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cl.testing.CustomYMLFile;
import cl.testing.HibernateTestingDao;
import cl.testing.bean.Person;

/**
 * Consultas para bases de datos con querys
 * 
 * @author ccontrerasc
 *
 */
@Repository
public class ConexionQueryDirecta {

	/**
	 * LOG
	 */
	private static final Log log = LogFactory.getLog(HibernateTestingDao.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	/**
	 * Properties
	 */
	@Autowired
	private CustomYMLFile properties;

	/**
	 * Query Directa
	 */
	public void consultaQueryDirecta() {

		String query = properties.getQUERY_DIRECTA();
		log.info("Comenzando la ejecucion mediante Query directa");
		log.info("Query : " + query);

		List<Person> listaSalida = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Person.class));
		log.info("Lista consultada exitosamente");
		if (listaSalida != null) {
			for (Person p : listaSalida) {
				log.info("PERSON : " + p);
			}
		}
	}

	/**
	 * Query con parametro
	 */
	public void consultaQueryParam() {

		String query = properties.getQUERY_PARAM();
		log.info("Comenzando la ejecucion mediante Query directa");
		log.info("Query : " + query);

		List<Person> listaSalida = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Person.class));
		log.info("Lista consultada exitosamente");
		if (listaSalida != null) {
			for (Person p : listaSalida) {
				log.info("PERSON : " + p);
			}
		}

	}

}