package cl.bancoconsorcio.apis.dao.mappers.schema;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase para el transformar los ResultSet en los VO correspondientes
 * 
 * @author Banco Consorcio
 *
 * @param <T>
 */
public interface RowMapper<T> {

	/**
	 * Toma el ResultSet y lo transforma en T
	 * 
	 * @param paramResultSet
	 * @return
	 * @throws SQLException
	 */
	public abstract T mapper(ResultSet paramResultSet) throws SQLException;
}
