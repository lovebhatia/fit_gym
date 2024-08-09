package com.gym.fit.service;

import com.gym.fit.dto.JwtAuthResponse;
import com.gym.fit.dto.LoginDto;
import com.gym.fit.dto.LoginGoogleDto;

public interface AuthService {
	JwtAuthResponse login(LoginDto loginDto);

	JwtAuthResponse loginwithGoogleDto(LoginGoogleDto loginGoogleDto);

}
