package com.springboot.jpa.dao.legacy;

/**
 * Data de conexion para conexiones legacy
 * 
 * @author ccontrerasc
 *
 */
public class DataConexion {

	private String url;
	private String user;
	private String pass;

	/** GET Y SET **/
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "DataConexion [url=" + url + ", user=" + user + ", pass=" + pass + "]";
	}

}
