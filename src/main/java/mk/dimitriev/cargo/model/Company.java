package mk.dimitriev.cargo.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Company {

	@Id
	@GeneratedValue
	private Long id;
	
	private String companyName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	
}
