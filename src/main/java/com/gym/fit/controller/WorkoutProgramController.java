package com.gym.fit.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gym.fit.dto.ErrorResponseDto;
import com.gym.fit.entity.CustomWorkout;
import com.gym.fit.entity.WorkoutProgram;
import com.gym.fit.repository.CustomWorkoutRepository;
import com.gym.fit.repository.WorkoutProgramRepository;
import com.gym.fit.repository.WorkoutProgramRepository.WorkoutProgramProjection;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;


@Tag(
		name = "CRUD Rest Operations for Workout Program",
		description = "To get data"
		)
@RestController
@RequestMapping("/api/program")
@AllArgsConstructor
public class WorkoutProgramController {
	
	@Autowired
	private WorkoutProgramRepository workoutProgramRepository;
	
	@Autowired
	private CustomWorkoutRepository customWorkoutRepository;
	
	@Operation(summary = "Get All programs",
			description = "To get all programs"
	)
	@ApiResponses({
		@ApiResponse(
				responseCode = "201",
				description = "HTTP Status Created"
				),
		@ApiResponse(
				responseCode = "500",
				description = "HTTP Status Internal Server Error",
				content  = @Content(
	                            schema = @Schema(implementation = ErrorResponseDto.class)
				)
				)
		
	})
	@GetMapping("/allPrograms")
	private ResponseEntity<?> getAllPrograms() {
		List<WorkoutProgramProjection> listPrograms = workoutProgramRepository.findAllBy();
		//listPrograms.sort(Comparator.comparingInt(WorkoutProgramProjection::getSequence));
		listPrograms.sort((wp1, wp2) -> Integer.compare(wp1.getSequence(), wp2.getSequence()));
		return new ResponseEntity<List<WorkoutProgramProjection>>(listPrograms, HttpStatus.OK);
	}
	
	@GetMapping("/customWorkout/{id}")
	private ResponseEntity<?> getCustomWorkout(@PathVariable(value = "id") Long idWorkoutProgram) {
		WorkoutProgram workoutProgram = workoutProgramRepository.findById(idWorkoutProgram)
				.orElseThrow(() -> new RuntimeException("Workout Program not Found"));
		List<CustomWorkout> customWorkouts =  customWorkoutRepository.findByWorkoutProgram(workoutProgram);
		return new ResponseEntity<List<CustomWorkout>>(customWorkouts, HttpStatus.OK);
	}
}
