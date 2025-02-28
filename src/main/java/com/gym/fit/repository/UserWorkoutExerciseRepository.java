package com.gym.fit.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gym.fit.entity.Exercise;
import com.gym.fit.entity.UserWorkoutExercise;

@Repository
public interface UserWorkoutExerciseRepository extends JpaRepository<UserWorkoutExercise, Long> {
	List<UserWorkoutExercise> findByUserWorkout_GymUser_IdAndUserWorkout_WorkoutProgram_IdAndWorkoutDate(
            Long userId, Long workoutProgramId, LocalDate workoutDate);
	
	 @Query("SELECT uwe.exercise FROM UserWorkoutExercise uwe " +
	           "WHERE uwe.userWorkout.gymUser.id = :userId " +
	           "AND uwe.userWorkout.workoutProgram.id = :workoutProgramId " +
	           "AND uwe.workoutDate = :date")
	    List<Exercise> findExercisesByUserWorkoutAndDate(
	            @Param("userId") Long userId,
	            @Param("workoutProgramId") Long workoutProgramId,
	            @Param("date") LocalDate date);
}