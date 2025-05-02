package com.gym.fit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/plan1")
public class WorkoutPlanController1 {
	
	@GetMapping("/{id}")
	public void getWorkoutExercises(@PathVariable Long id) {
		System.out.println("in id");
		
	}

}
