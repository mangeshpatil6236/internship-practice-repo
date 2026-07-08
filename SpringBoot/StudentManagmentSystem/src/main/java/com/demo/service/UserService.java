package com.demo.service;

import com.demo.dto.LoginRequestDto;
import com.demo.dto.UserRequestDto;
import com.demo.dto.UserResponseDto;


public interface UserService {

	UserResponseDto register(UserRequestDto dto);
	
	String login(LoginRequestDto dto);
}
