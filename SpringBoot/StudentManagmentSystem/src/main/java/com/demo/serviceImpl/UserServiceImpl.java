package com.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.dto.LoginRequestDto;
import com.demo.dto.UserRequestDto;
import com.demo.dto.UserResponseDto;
import com.demo.entity.User;
import com.demo.repository.UserRepository;
import com.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{

    private final AuthenticationManager authenticationManager;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	BCryptPasswordEncoder encoder;

    UserServiceImpl(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

	@Override
	public UserResponseDto register(UserRequestDto dto) {
		
		User user = new User();
		
		user.setEmail(dto.getEmail());
		user.setPassword(encoder.encode(dto.getPassword()));
		user.setRole(dto.getRole());
		
		User save = userRepo.save(user);
		
		UserResponseDto responseDto = new UserResponseDto();
		responseDto.setEmail(save.getEmail());
		responseDto.setId(save.getId());
		responseDto.setRole(save.getRole());
		
		return responseDto;
	}


	@Override
	public String login(LoginRequestDto dto) {
		// TODO Auto-generated method stub
		
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							dto.getEmail(),
							dto.getPassword()
							)
					);
			
			return "Login Successfull";
		} catch (BadCredentialsException e) {
			// TODO: handle exception
			throw new RuntimeException("Invalid Email or Password");
		}
	}

}
