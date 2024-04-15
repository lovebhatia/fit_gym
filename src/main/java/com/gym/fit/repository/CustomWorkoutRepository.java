package com.gym.fit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gym.fit.entity.CustomWorkout;
import com.gym.fit.entity.WorkoutProgram;

@Repository
public interface CustomWorkoutRepository extends JpaRepository<CustomWorkout, Long> {
	List<CustomWorkout> findByWorkoutProgram(WorkoutProgram workoutProgram);
	
	interface CustomWorkoutProjection {
		int getId();
		String getCustomWorkoutName();
		String getImageName();
		int getSequence();
		
	}
}
