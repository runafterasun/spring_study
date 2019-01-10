package annotation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "table_temp", schema = "isae")
public class Table_temp {

	@Id
	@Column(name = "id")
    private String id;
	
	@Column(name="phone")
	private Integer phone;
	
	@Column(name="rate", length = 20, nullable = true)
	private String rate;
	
	@Column(name="rate_two", length = 20, nullable = true)
	private String rate_two;
	
	@Column(name="script_date", length = 20, nullable = true)
	private String script_date;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getRate_two() {
		return rate_two;
	}

	public void setRate_two(String rate_two) {
		this.rate_two = rate_two;
	}

	public String getScript_date() {
		return script_date;
	}

	public void setScript_date(String script_date) {
		this.script_date = script_date;
	}
	
	
}
