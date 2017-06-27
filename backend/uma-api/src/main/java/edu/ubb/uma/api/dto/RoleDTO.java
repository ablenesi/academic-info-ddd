package edu.ubb.uma.api.dto;

public class RoleDTO {

	private Long id;
	private String role;
	private String description;
	
	public RoleDTO(){
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "RoleDTO [id=" + id + ", role=" + role + ", description=" + description + "]";
	}	
}
