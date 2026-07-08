package com.demo.dto;

import com.demo.entity.Role;

import lombok.Data;

@Data
public class UserResponseDto {

	private Integer id;
	
	private String email;
	
	private Role role;
}
