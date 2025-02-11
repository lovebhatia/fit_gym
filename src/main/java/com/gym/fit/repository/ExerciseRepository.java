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
		@Query(value = "SELECT e.* FROM Exercise e JOIN workout_exercises we ON e.id = we.exercise_id " +
		           "JOIN workout w ON w.id = we.workout_id " +
		           "WHERE w.workout IN (:workoutNames)", nativeQuery = true)
		    List<Exercise> findExercisesByWorkoutNames(@Param("workoutNames") List<String> workoutNames);
}
