package com.gym.fit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gym.fit.entity.Exercise;
import com.gym.fit.entity.Workout;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
		List<Exercise> findByWorkouts(Workout workout);
		@Query("SELECT e FROM Exercise e JOIN WorkoutExercise we ON e.id = we.exercise.id " +
		           "JOIN WorkoutProgram w ON we.workoutProgram.id = w.id " +
		           "WHERE w.workoutName IN :workoutNames")
		    List<Exercise> findExercisesByWorkoutNames(@Param("workoutNames") List<String> workoutNames);
}
