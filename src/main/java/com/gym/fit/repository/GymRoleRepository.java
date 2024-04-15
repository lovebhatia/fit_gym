package com.gym.fit.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gym.fit.entity.GymRoles;

public interface GymRoleRepository extends JpaRepository<GymRoles, Long> {
	  Optional<GymRoles> findByName(String name);

}
