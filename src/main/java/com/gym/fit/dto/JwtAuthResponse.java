package com.gym.fit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtAuthResponse {
	private String accessToken;
	private String tokenType = "Bearer";
	private String refreshToken;
	private Long userId;
}
