package com.gym.fit.service;

import com.gym.fit.dto.JwtAuthResponse;

public interface GymRefreshTokenService {
	JwtAuthResponse createRefreshOrAccessToken(String refreshToken);
}
