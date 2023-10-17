package com.project.crudspring.enums;

public enum UsersRoleEnum {
	
	ADMIN("admin"),
	USER("user");
	
	private String role;
	
	UsersRoleEnum(String role){
		this.role = role;
	}
	
	public String getRole() {
		return role;
	}
}
