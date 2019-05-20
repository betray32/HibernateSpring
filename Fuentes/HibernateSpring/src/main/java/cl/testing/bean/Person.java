package cl.testing.bean;

/**
 * Person , mapeo desde la base
 * 
 * @author ccontrerasc
 *
 */
public class Person {

	private int id;
	private String first_name;
	private String last_name;
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
