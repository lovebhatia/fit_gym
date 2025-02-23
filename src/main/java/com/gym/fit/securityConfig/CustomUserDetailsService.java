package com.gym.fit.securityConfig;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gym.fit.dto.GymUserDto;
import com.gym.fit.entity.GymUser;
import com.gym.fit.exception.CustomException;
import com.gym.fit.repository.GymUserRepository;

import lombok.AllArgsConstructor;



@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private GymUserRepository gymUserRepository;
	@Autowired
	private PasswordEncoder bcryptEncoder;
	@Override
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		GymUser gymUser = gymUserRepository.findByUsernameOrEmail(usernameOrEmail,usernameOrEmail)
				.orElseThrow(() -> new UsernameNotFoundException("User not exists by Username or email"));
		Set<GrantedAuthority> authorities = gymUser.getGymRoles().stream()
                .map((role) -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toSet());
		return new User(
                usernameOrEmail,
                gymUser.getPassword(),
                authorities
        );
	}
	public UserDetails loadUserByUsernameGoogle(String usernameOrEmail) throws UsernameNotFoundException {
		GymUser gymUser = gymUserRepository.findByUsernameOrEmail(usernameOrEmail,usernameOrEmail)
				.orElseThrow(() -> new UsernameNotFoundException("User not exists by Username or email"));
		Set<GrantedAuthority> authorities = gymUser.getGymRoles().stream()
                .map((role) -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toSet());
		return new User(
                usernameOrEmail,
                gymUser.getPassword(),
                authorities
        );
	}
	
	public ResponseEntity<?> save(GymUserDto user) {
		 if (gymUserRepository.existsByUsername(user.getUsername())) {
			 System.out.println("in exist");
			 return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
					 Map.of("message", "User Already Exists", "code", "USER_ALREADY_EXISTS")
			 );		    }

		    // Check if the email already exists
		    if (gymUserRepository.existsByEmail(user.getEmail())) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
						Map.of("message", "Email Already Exists", "code", "EMAIL_ALREADY_EXISTS")
				);			    }
		GymUser newUser = new GymUser();
		newUser.setUsername(user.getUsername());
		newUser.setEmail(user.getEmail());
		newUser.setMobileNumber(user.getMobileNumber());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setConfirmPassword(user.getConfirmPassword());
		newUser.setGymRoles(user.getGymRoles());
		return ResponseEntity.ok(gymUserRepository.save(newUser));
	}
}
