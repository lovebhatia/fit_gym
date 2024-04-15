package com.gym.fit.service;

import com.gym.fit.dto.JwtAuthResponse;
import com.gym.fit.dto.LoginDto;

public interface AuthService {
	JwtAuthResponse login(LoginDto loginDto);

}
