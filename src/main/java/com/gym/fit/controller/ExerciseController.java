package com.gym.fit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gym.fit.entity.CustomWorkout;
import com.gym.fit.entity.Exercise;
import com.gym.fit.entity.Workout;
import com.gym.fit.repository.CustomWorkoutRepository;
import com.gym.fit.repository.ExerciseRepository;
import com.gym.fit.repository.WorkoutRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/exercise")
@AllArgsConstructor
public class ExerciseController {
	

	
	@Autowired
	private CustomWorkoutRepository customWorkoutRepository;
	
	@Autowired 
	private WorkoutRepository workoutRepository;
	
	
	

}
