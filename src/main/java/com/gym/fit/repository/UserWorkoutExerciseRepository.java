package com.gym.fit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gym.fit.entity.UserWorkoutExercise;

@Repository
public interface UserWorkoutExerciseRepository extends JpaRepository<UserWorkoutExercise, Long> {


}