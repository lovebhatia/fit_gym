package com.gym.fit.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gym.fit.entity.GymRoles;

@Repository
public interface GymRoleRepository extends JpaRepository<GymRoles, Long> {
	  Optional<GymRoles> findByName(String name);
	  @Modifying
	  @Query(value = "DELETE FROM gym_user_gym_roles WHERE user_id = :userId", nativeQuery = true)
	  int deleteGymUserRolesByUserId(@Param("userId") Long userId);
	  

}