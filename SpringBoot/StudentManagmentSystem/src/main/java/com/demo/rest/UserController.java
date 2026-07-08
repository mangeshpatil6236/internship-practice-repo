package com.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.LoginRequestDto;
import com.demo.dto.UserRequestDto;
import com.demo.dto.UserResponseDto;
import com.demo.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<UserResponseDto> register(@RequestBody UserRequestDto user){
		
		UserResponseDto register = userService.register(user);
		
		return new ResponseEntity<>(register, HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequestDto dto){
		
		String login = userService.login(dto);
		return new ResponseEntity<>(login, HttpStatus.OK);
	}
	
	@PostMapping("/logout")
	public ResponseEntity<?> logout(){
		return ResponseEntity.ok("Logout Successfull");
	}
}
