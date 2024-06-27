package com.gym.fit.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gym.fit.dto.ExerciseSetDTO;
import com.gym.fit.entity.ExercisePerUser;
import com.gym.fit.entity.ExerciseSet;
import com.gym.fit.repository.ExercisePerUserRepository;
import com.gym.fit.repository.ExerciseSetRepository;

@RestController
@RequestMapping("/api/exercise-sets")
public class ExerciseSetController {
	
	@Autowired
	private ExerciseSetRepository exerciseSetRepository;
	
	@Autowired
	private ExercisePerUserRepository exercisePerUserRepository;
	
	@PostMapping
	public ResponseEntity<List<ExerciseSet>> createExerciseSet(@RequestBody ExerciseSetDTO exerciseSetDTO) {
	   // ExercisePerUser exercisePerUser = exercisePerUserRepository.findById(exerciseSetDTO.getExercisePerUserId())
	     //       .orElseThrow(() -> new ResourceNotFoundException("Exercise per user not found"));
	   

	    System.out.println("exercise set " + exerciseSetDTO);
	    List<ExerciseSet> exerciseSets = exerciseSetDTO.getRecords().stream().map(record -> {
	        return ExerciseSet.builder()
	                //.exercisePerUser(exercisePerUser)
	                .reps(record.getReps())
	                .weight(record.getWeight())
	                .set(record.getIndex())
	                .exerciseName(exerciseSetDTO.getExerciseName())
	                .build();
	    }).collect(Collectors.toList());
		
	    List<ExerciseSet> savedExerciseSets = exerciseSetRepository.saveAll(exerciseSets);
	    return ResponseEntity.ok(savedExerciseSets);
	}

}
