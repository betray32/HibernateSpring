package cl.testing.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Person , mapeo desde la base
 * 
 * @author ccontrerasc
 *
 */
@Entity
public class Person {

	@Id
	@Column
	private int id;
	
	@Column
	private String first_name;
	
	@Column
	private String last_name;
	
	@Column
	private String address;

	/** GET Y SET **/
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", address=" + address + "]";
	}

}
