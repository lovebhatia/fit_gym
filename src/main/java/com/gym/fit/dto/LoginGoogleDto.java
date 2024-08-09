package com.gym.fit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginGoogleDto {
	private String email;
	private String displayName;
	private boolean loginWithGoogle;
}
