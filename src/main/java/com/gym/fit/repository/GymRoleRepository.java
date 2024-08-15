package com.gym.fit.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gym.fit.entity.GymRoles;

@Repository
public interface GymRoleRepository extends JpaRepository<GymRoles, Long> {
	  Optional<GymRoles> findByName(String name);

}
