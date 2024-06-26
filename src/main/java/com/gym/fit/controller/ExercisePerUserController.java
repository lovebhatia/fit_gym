package com.gym.fit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gym.fit.dto.ExercisePerUserDTO;
import com.gym.fit.entity.ExercisePerUser;
import com.gym.fit.entity.GymUser;
import com.gym.fit.repository.ExercisePerUserRepository;
import com.gym.fit.repository.GymUserRepository;

@RestController
@RequestMapping("/api/exercises")
public class ExercisePerUserController {
	
	@Autowired
	private ExercisePerUserRepository exercisePerUserRepository;
	
	@Autowired
	GymUserRepository gymUserRepository;
	
	@PostMapping("/save-exercise-per-user")
	public ResponseEntity<ExercisePerUser> createExercisePerUser(@RequestBody ExercisePerUserDTO exercisePerUserDTO) {
		System.out.println("in save exercise per user --> "+exercisePerUserDTO.getId());
		GymUser gymUser = gymUserRepository.findById(exercisePerUserDTO.getId())
				.orElseThrow(() -> new  ResourceNotFoundException("user Not found"));
		ExercisePerUser exercisePerUser = ExercisePerUser.builder()
				.gymUser(gymUser)
				.exerciseName(exercisePerUserDTO.getExerciseName())
				.build();
		ExercisePerUser savedExercisePerUser = exercisePerUserRepository.save(exercisePerUser);
		return ResponseEntity.ok(savedExercisePerUser);
	}
	
	
	
	

}
