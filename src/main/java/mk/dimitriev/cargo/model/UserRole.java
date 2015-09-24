package mk.dimitriev.cargo.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class UserRole {

	@Id
	@GeneratedValue
	private Long id;
	
	private String roleName;
	
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
