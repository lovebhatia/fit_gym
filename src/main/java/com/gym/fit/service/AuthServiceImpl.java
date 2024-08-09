package com.gym.fit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gym.fit.dto.GymUserDto;
import com.gym.fit.dto.JwtAuthResponse;
import com.gym.fit.dto.LoginDto;
import com.gym.fit.dto.LoginGoogleDto;
import com.gym.fit.entity.GymRefreshToken;
import com.gym.fit.entity.GymRoles;
import com.gym.fit.entity.GymUser;
import com.gym.fit.exception.CustomException;
import com.gym.fit.repository.GymRefreshTokenRepository;
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

	@Override
	public JwtAuthResponse login(LoginDto loginDto) {
		try {
			System.out.println("in authentication");
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				loginDto.getUsername(), loginDto.getPassword()));
		System.out.println("in login dto");
		SecurityContextHolder.getContext().setAuthentication(authentication);
		}catch (BadCredentialsException e) {
			throw new CustomException("Bad User Credentials", "USER_NOT_FOUND");
		}
		catch (Exception e) {
			System.out.println("Exception" +e.toString());
		}
		System.out.println("in this");
		GymRefreshToken gymRefreshToken = new GymRefreshToken();
		UserDetails userdetails = customUserDetailsService.loadUserByUsername(loginDto.getUsername());
		String token = jwtTokenProvider.generateToken(userdetails);
		String refreshToken = jwtTokenProvider.generateRefreshToken(userdetails);
		JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
		jwtAuthResponse.setAccessToken(token);
		jwtAuthResponse.setRefreshToken(refreshToken);
		String usernameOrEmail = userdetails.getUsername();
		GymUser gymUser = gymUserRepository.findByUsernameOrEmail(usernameOrEmail,usernameOrEmail).get();
		gymRefreshToken.setGymUser(gymUser);
		jwtAuthResponse.setUserId(gymUser.getId());
		gymRefreshToken.setRefreshToken(refreshToken);
		gymRefreshTokenRepository.save(gymRefreshToken);
		return jwtAuthResponse;
	}
	
	@Override
	public JwtAuthResponse loginwithGoogleDto(LoginGoogleDto loginGoogleDto) {
		
		 UserDetails userDetails = customUserDetailsService.loadUserByUsername(loginGoogleDto.getEmail());
		    if (userDetails == null) {
		    	GymUser newUser = new GymUser();
		    	newUser.setUsername(newUser.getUsername());
		   		newUser.setEmail(newUser.getEmail());
		   		newUser.setMobileNumber(newUser.getMobileNumber());
		   		GymRoles gymRoles = new GymRoles();
		   		gymRoles.setName("ROLE_USER");
	    		gymUserRepository.save(newUser);
		    }
		    
		UserDetails userDetailsafterRegistration = customUserDetailsService.loadUserByUsername(loginGoogleDto.getEmail());
		
		String token = jwtTokenProvider.generateToken(userDetailsafterRegistration);
		String refreshToken = jwtTokenProvider.generateRefreshToken(userDetailsafterRegistration);
		
		JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
		jwtAuthResponse.setAccessToken(token);
		jwtAuthResponse.setRefreshToken(refreshToken);
		
		GymRefreshToken gymRefreshToken = new GymRefreshToken();
		String usernameOrEmail = userDetailsafterRegistration.getUsername();
		GymUser gymUser = gymUserRepository.findByUsernameOrEmail(usernameOrEmail,usernameOrEmail).get();
		gymRefreshToken.setGymUser(gymUser);
		jwtAuthResponse.setUserId(gymUser.getId());
		gymRefreshToken.setRefreshToken(refreshToken);
		gymRefreshTokenRepository.save(gymRefreshToken);
		    
		return jwtAuthResponse;
	}
}
