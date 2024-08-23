package com.gym.fit.service;

import com.gym.fit.dto.JwtAuthResponse;
import com.gym.fit.dto.LoginDto;
import com.gym.fit.dto.LoginGoogleDto;
import org.springframework.http.ResponseEntity;

public interface AuthService {
	ResponseEntity<?> login(LoginDto loginDto);

	JwtAuthResponse loginwithGoogleDto(LoginGoogleDto loginGoogleDto);

}
