package com.gym.fit.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.fit.entity.GymRoles;
import com.gym.fit.entity.GymUser;
import com.gym.fit.repository.GymRoleRepository;
import com.gym.fit.repository.GymUserRepository;

import jakarta.transaction.Transactional;

@Service
public class AccountService {
	@Autowired
	private  GymUserRepository gymUserRepository;
	@Autowired
	private  GymRoleRepository gymRoleRepository;

	@Transactional
	public boolean deleteAccount(Long userId) {
		GymUser user = gymUserRepository.findById(userId).orElse(null);
		if (user != null) {
			int status =  gymRoleRepository.deleteGymUserRolesByUserId(userId);
			if(status != 0) {
				 gymUserRepository.delete(user);
				 return true;
			} else {
				return false;
			}
		}
		return false;
	}

}