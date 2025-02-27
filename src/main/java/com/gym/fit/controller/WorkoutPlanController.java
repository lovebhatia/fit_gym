package com.gym.fit.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gym.fit.entity.UserWorkoutExercise;
import com.gym.fit.repository.UserWorkoutExerciseRepository;
import com.gym.fit.service.WorkoutPlanService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("api/plan")
public class WorkoutPlanController {

    private final WorkoutPlanService workoutPlanService;
    
    private UserWorkoutExerciseRepository userWorkoutExerciseRepository;

    public WorkoutPlanController(WorkoutPlanService workoutPlanService, 
    		UserWorkoutExerciseRepository userWorkoutExerciseRepository) {
        this.workoutPlanService = workoutPlanService;
        this.userWorkoutExerciseRepository = userWorkoutExerciseRepository;
    }

    @PostMapping("/{id}")
    private ResponseEntity<?> createWorkoutPlan(@PathVariable(value = "id") Long idWorkoutPlan, @RequestParam Long userId) {
        return workoutPlanService.generateWorkoutPlan(userId, idWorkoutPlan);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getExercisePerUserWorkout(@PathVariable(value = "id") Long idWorkoutPlan, @RequestParam Long userId) {
        System.out.println("In Plan Controller");
        return workoutPlanService.generateWorkoutPlan(userId, idWorkoutPlan);
    }
    
    @GetMapping("/user/{userId}/workout/{workoutProgramId}/exercises/{date}")
    public ResponseEntity<List<UserWorkoutExercise>> getExercisesForUserWorkoutByDate(
            @PathVariable("userId") Long userId,  // Ensure path variable names match
            @PathVariable("workoutProgramId") Long workoutProgramId,
            @PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
    	
    	System.out.println(date+"--"+ userId + "---"+workoutProgramId);
    	List<UserWorkoutExercise> exercises = userWorkoutExerciseRepository
                .findByUserWorkout_GymUser_IdAndUserWorkout_WorkoutProgram_IdAndWorkoutDate(userId, workoutProgramId, date);

        if (exercises.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exercises);
        }
        
        return ResponseEntity.ok(exercises);
    	
    }


}