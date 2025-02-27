package com.gym.fit.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gym.fit.entity.UserWorkoutExercise;

@Repository
public interface UserWorkoutExerciseRepository extends JpaRepository<UserWorkoutExercise, Long> {
	List<UserWorkoutExercise> findByUserWorkout_GymUser_IdAndUserWorkout_WorkoutProgram_IdAndWorkoutDate(
            Long userId, Long workoutProgramId, LocalDate workoutDate);
}