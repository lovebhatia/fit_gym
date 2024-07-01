package com.gym.fit.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gym.fit.dto.ExercisePerUserDTO;
import com.gym.fit.entity.ExercisePerUser;
import com.gym.fit.service.ExercisePerUserService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ExercisePerUserController {
	
	private ExercisePerUserService exercisePerUserService;
	
	@PostMapping("/save-exercise-per-user")
	public ResponseEntity<ExercisePerUser> createExercisePerUser(@RequestBody ExercisePerUserDTO exercisePerUserDTO) {
		return ResponseEntity.ok(exercisePerUserService.saveExercisePerUser(exercisePerUserDTO));
	}

	@GetMapping("/exercise-per-user")
	public ResponseEntity<List<ExercisePerUser>> getExercisePerUser(
			@RequestParam Long userId,
			@RequestParam String exerciseName,
			@RequestParam LocalDate date) {
		System.out.println("in the method");
		List<ExercisePerUser> exercises = exercisePerUserService.getExercisePerUserByUserIdAndExerciseNameAndDate(userId, exerciseName, date);
		
		return ResponseEntity.ok(exercises);
	}

}
