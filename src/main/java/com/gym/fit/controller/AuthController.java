package com.gym.fit.controller;

import java.util.HashSet;
import java.util.Set;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gym.fit.dto.GymUserDto;
import com.gym.fit.dto.JwtAuthResponse;
import com.gym.fit.dto.LoginDto;
import com.gym.fit.dto.LoginGoogleDto;
import com.gym.fit.dto.RefreshAccessTokenRequest;
import com.gym.fit.entity.GymRoles;
import com.gym.fit.repository.GymRoleRepository;
import com.gym.fit.securityConfig.CustomUserDetailsService;
import com.gym.fit.service.AuthService;
import com.gym.fit.service.GymRefreshTokenService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
	
	private AuthService authService;
	private CustomUserDetailsService customUserDetailsService;
	private GymRoleRepository gymRoleRepository;
	private GymRefreshTokenService gymRefreshTokenService;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
		// Call the login method from the service layer
		ResponseEntity<?> response = authService.login(loginDto);
		// Return the response from the service directly
		return response;
	}
	
	@PostMapping("/login-with-google")
	public ResponseEntity<JwtAuthResponse> loginWithGoogle(@RequestBody LoginGoogleDto loginGoogleDto) {
		JwtAuthResponse jwtAuthResponse = authService.loginwithGoogleDto(loginGoogleDto);
		System.out.println("in login api");
		return new ResponseEntity<JwtAuthResponse>(jwtAuthResponse, HttpStatus.OK);
	}
	
	
	@PostMapping("/register")
	public ResponseEntity<?> saveUser(@RequestBody GymUserDto user) throws Exception {
		Set<GymRoles> strRoles = user.getGymRoles();
		System.out.println(strRoles);
		Set<GymRoles> setGymRoles = new HashSet<GymRoles>();
		strRoles.forEach(role -> {
			GymRoles gymRoles = gymRoleRepository.findByName(role.getName())
					.orElseThrow(() -> new RuntimeException("Role not found"));
			setGymRoles.add(gymRoles);
		});
		/*
		if(strRoles == null) {
			GymRoles gymUserRole = gymRoleRepository.findByName("ROLE_USER")
					.orElseThrow(() -> new RuntimeException("Error: Role is not found"));
			setGymRoles.add(gymUserRole);
		} else {
			strRoles.forEach(role -> {
				GymRoles gymRoles = gymRoleRepository.findByName(role)
						.orElseThrow(() -> new RuntimeException("Role not found"));
				setGymRoles.add(gymRoles);
			});
		}
		*/
		//user.setRoles(setGymRoles);
		user.setGymRoles(setGymRoles);	
		return ResponseEntity.ok(customUserDetailsService.save(user));
	}
	
	@PostMapping("/accessRefresh")
	public ResponseEntity<JwtAuthResponse> getAccessRefreshToken(@RequestBody RefreshAccessTokenRequest refreshToken) {
		System.out.println(refreshToken.getRefreshToken());
		JwtAuthResponse jwtAuthResponse = gymRefreshTokenService.createRefreshOrAccessToken(refreshToken.getRefreshToken());
		return new ResponseEntity<JwtAuthResponse>(jwtAuthResponse, HttpStatus.OK);
	}
}
