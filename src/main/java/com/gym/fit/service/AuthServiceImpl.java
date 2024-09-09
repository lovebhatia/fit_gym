package com.gym.fit.service;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gym.fit.dto.JwtAuthResponse;
import com.gym.fit.dto.LoginDto;
import com.gym.fit.dto.LoginGoogleDto;
import com.gym.fit.entity.GymRefreshToken;
import com.gym.fit.entity.GymRoles;
import com.gym.fit.entity.GymUser;
import com.gym.fit.repository.GymRefreshTokenRepository;
import com.gym.fit.repository.GymRoleRepository;
import com.gym.fit.repository.GymUserRepository;
import com.gym.fit.securityConfig.CustomUserDetailsService;
import com.gym.fit.securityConfig.JwtTokenProvider;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	@Autowired
	private GymRefreshTokenRepository gymRefreshTokenRepository;
	@Autowired
	private GymUserRepository gymUserRepository;
	@Autowired
	private GymRoleRepository gymRoleRepository;
	@Autowired
	private PasswordEncoder bcryptEncoder;


	@Override
	public ResponseEntity<?> login(LoginDto loginDto) {
		try {
			Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					loginDto.getUsername(), loginDto.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);

			// Generate tokens and other logic
			GymRefreshToken gymRefreshToken = new GymRefreshToken();
			UserDetails userdetails = customUserDetailsService.loadUserByUsername(loginDto.getUsername());
			String token = jwtTokenProvider.generateToken(userdetails);
			String refreshToken = jwtTokenProvider.generateRefreshToken(userdetails);
			JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
			jwtAuthResponse.setAccessToken(token);
			jwtAuthResponse.setRefreshToken(refreshToken);
			String usernameOrEmail = userdetails.getUsername();
			GymUser gymUser = gymUserRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail).get();
			gymRefreshToken.setGymUser(gymUser);
			jwtAuthResponse.setUserId(gymUser.getId());
			gymRefreshToken.setRefreshToken(refreshToken);
			gymRefreshTokenRepository.save(gymRefreshToken);

			return ResponseEntity.ok(jwtAuthResponse);

		} catch (BadCredentialsException e) {
			// Return a structured JSON error response
			System.out.println("in login error");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
					Map.of("message", "Bad User Credentials", "code", "USER_NOT_FOUND")
			);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
					Map.of("message", "An unexpected error occurred", "details", e.getMessage())
			);
		}
	}


	@Override
	public JwtAuthResponse loginwithGoogleDto(LoginGoogleDto loginGoogleDto) {
	    System.out.println("in 111");
	    JwtAuthResponse jwtAuthResponse = null;
	    UserDetails userDetails;
	    try {
	       try {
	          userDetails = customUserDetailsService.loadUserByUsername(loginGoogleDto.getUsername());
	       } catch (UsernameNotFoundException e) {
	          // Handle case where user does not exist
	          userDetails = null;
	       }
	       if (userDetails == null) {
	          createUser(loginGoogleDto);
	       }

	       UserDetails userDetailsAfterRegistration = customUserDetailsService.loadUserByUsernameGoogle(loginGoogleDto.getUsername());
	    
	       String token = jwtTokenProvider.generateToken(userDetailsAfterRegistration);
	       String refreshToken = jwtTokenProvider.generateRefreshToken(userDetailsAfterRegistration);

	       jwtAuthResponse = new JwtAuthResponse();
	       jwtAuthResponse.setAccessToken(token);
	       jwtAuthResponse.setRefreshToken(refreshToken);

	       GymRefreshToken gymRefreshToken = new GymRefreshToken();
	       String usernameOrEmail = userDetailsAfterRegistration.getUsername();
	       GymUser gymUser = gymUserRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail).get();

	       gymRefreshToken.setGymUser(gymUser);
	       jwtAuthResponse.setUserId(gymUser.getId());
	       gymRefreshToken.setRefreshToken(refreshToken);
	       gymRefreshTokenRepository.save(gymRefreshToken);
	    }catch (Exception e) {
	       System.out.println("Exception --"+e.toString());
	    }
	    return jwtAuthResponse;
	}
	
	public void createUser(LoginGoogleDto loginGoogleDto) {
	    GymUser newUser = new GymUser();
	    System.out.println(loginGoogleDto.getUsername() + "--" + loginGoogleDto.getEmail());
	    newUser.setUsername(loginGoogleDto.getUsername());
	    newUser.setEmail(loginGoogleDto.getEmail());
	    newUser.setPassword(bcryptEncoder.encode("System123#"));
		newUser.setConfirmPassword(bcryptEncoder.encode("System123#"));

	    Set<GymRoles> strRoles = new HashSet<>();
	    GymRoles gymRole = new GymRoles();
	    gymRole.setName("ROLE_USER");
	    strRoles.add(gymRole); // Add the GymRoles object, not the HashSet

	    Set<GymRoles> setGymRoles = new HashSet<>();
	    strRoles.forEach(role -> {
	        GymRoles gymRoles = gymRoleRepository.findByName(role.getName())
	                .orElseThrow(() -> new RuntimeException("Role not found"));
	        setGymRoles.add(gymRoles);
	    });
	    newUser.setGymRoles(setGymRoles);

	    gymUserRepository.save(newUser);
	}

}
