package com.gym.fit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gym.fit.entity.WorkoutPerUser;

@Repository
public interface WorkoutPerUserRepository extends JpaRepository<WorkoutPerUser, Long> {
	
}
