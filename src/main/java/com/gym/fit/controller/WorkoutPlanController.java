package com.gym.fit.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gym.fit.service.WorkoutPlanService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("api/plan")
public class WorkoutPlanController {

    private final WorkoutPlanService workoutPlanService;

    public WorkoutPlanController(WorkoutPlanService workoutPlanService) {
        this.workoutPlanService = workoutPlanService;
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


}