package com.project.crudspring.dtos;

import com.project.crudspring.enums.UsersRoleEnum;

import lombok.Data;

@Data
public class RegisterDTO {

	private String login;
	private String password;
	private UsersRoleEnum role;
}
