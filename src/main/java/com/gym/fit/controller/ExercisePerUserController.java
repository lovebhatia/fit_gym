package com.gym.fit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gym.fit.dto.ExercisePerUserDTO;
import com.gym.fit.entity.ExercisePerUser;
import com.gym.fit.service.ExercisePerUserService;

@RestController
@RequestMapping("/api/exercises")
public class ExercisePerUserController {
	
	ExercisePerUserService exercisePerUserService;
	
	@PostMapping("/save-exercise-per-user")
	public ResponseEntity<ExercisePerUser> createExercisePerUser(@RequestBody ExercisePerUserDTO exercisePerUserDTO) {
		return ResponseEntity.ok(exercisePerUserService.saveExercisePerUser(exercisePerUserDTO));
	}
}
