package com.demo.dto;

import com.demo.entity.Role;

import lombok.Data;

@Data
public class UserRequestDto {

	private String email;
	
	private String password;
	
	private Role role;
}
