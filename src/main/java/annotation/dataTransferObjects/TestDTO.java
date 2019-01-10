package annotation.dataTransferObjects;

import org.springframework.hateoas.ResourceSupport;


public class TestDTO extends ResourceSupport{
	
	private String firstname;
	private String lastname;
	private Integer ids;
	
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Integer getIds() {
		return ids;
	}
	public void setId(Integer ids) {
		this.ids = ids;
	}
	
	
	
}
