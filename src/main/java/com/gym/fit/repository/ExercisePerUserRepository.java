package com.gym.fit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gym.fit.entity.ExercisePerUser;

@Repository
public interface ExercisePerUserRepository extends JpaRepository<ExercisePerUser, Long> {

}
