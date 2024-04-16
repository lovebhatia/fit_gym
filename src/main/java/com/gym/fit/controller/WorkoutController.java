package com.gym.fit.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gym.fit.dto.WorkoutPerUserDto;
import com.gym.fit.entity.Exercise;
import com.gym.fit.entity.GymUser;
import com.gym.fit.entity.Workout;
import com.gym.fit.entity.WorkoutPerUser;
import com.gym.fit.repository.ExerciseRepository;
import com.gym.fit.repository.GymUserRepository;
import com.gym.fit.repository.WorkoutPerUserRepository;
import com.gym.fit.repository.WorkoutRepository;
import com.gym.fit.repository.WorkoutRepository.WorkoutProjection;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("api/workout")
public class WorkoutController {
	
	@Autowired
	private GymUserRepository gymUserRepository;
	
	@Autowired
	private WorkoutPerUserRepository workoutPerUserRepository;
	
	@Autowired
	private WorkoutRepository workoutRepository;
	
	@Autowired
	private ExerciseRepository exerciseRepository;
	
	@Value("${build.version}")
	private String buildVersion;
	
	
	
	@PostMapping("/save/{id}")
	public ResponseEntity<?> saveWorkoutPerUser(@RequestBody WorkoutPerUserDto workoutPerUserDto, 
			@PathVariable(value = "id") Long userId ) {
		System.out.println("in api");
		GymUser gymUser = gymUserRepository.findById(userId)
	            .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
		WorkoutPerUser workoutPerUser = new WorkoutPerUser();
		workoutPerUser.setWorkoutName(workoutPerUserDto.getWorkoutName());
		workoutPerUser.setGymUser(gymUser);
		workoutPerUserRepository.save(workoutPerUser);
		return ResponseEntity.ok().build();
	}

	
	@GetMapping("/allWorkouts")
	public ResponseEntity<List<WorkoutProjection>> getWorkout() {
		List<WorkoutProjection> listWorkout = workoutRepository.findAllBy();
		return new ResponseEntity<List<WorkoutProjection>>(listWorkout, HttpStatus.OK);
	}
	
	 @GetMapping("workout/{workoutId}/exercises")
	    public ResponseEntity<?> getExercisesByWorkoutId(@PathVariable(value = "workoutId") Long idWorkout) {
	        Workout workout = workoutRepository.findById(idWorkout)
	                .orElseThrow(() -> new RuntimeException("Workout not found"));

	        List<Exercise> exercises = workout.getExercises();

	        return ResponseEntity.status(HttpStatus.OK).body(exercises);
	    }
	 
	 @GetMapping("/build-info")
	 public ResponseEntity<?> getBuildInfo() {
		 return ResponseEntity.status(HttpStatus.OK).body(buildVersion);
	 }
	
	/*
	@GetMapping("/exercise/{id}")
	public ResponseEntity<List<Exercise>> getExercisePerWorkout(@PathVariable(value = "id") Long workoutId) {
		Workout workout = workoutRepository.findById(workoutId).
				orElseThrow(() -> new RuntimeException("Workout Not found"));
		List<Exercise> listExercise = exerciseRepository.findByWorkout(workout);
		return new ResponseEntity<List<Exercise>>(listExercise, HttpStatus.OK);	
	}
	*/
	
}
