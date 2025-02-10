package com.gym.fit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gym.fit.service.WorkoutPlanService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
@RequestMapping("api/plan")
public class WorkoutPlanController {

    private final WorkoutPlanService workoutPlanService;

    @Autowired
    public WorkoutPlanController(WorkoutPlanService workoutPlanService) {
        this.workoutPlanService = workoutPlanService;
    }

    @PostMapping("/{id}")
    private ResponseEntity<?> createWorkoutPlan(@PathVariable(value = "id") Long idWorkoutPlan, @RequestParam Long userId) {
        return workoutPlanService.generateWorkoutPlan(userId, idWorkoutPlan);
    } 

    @GetMapping("/{id}")
    public ResponseEntity<?> getExercisePerUserWorkout(@PathVariable(value = "id") Long idWorkoutPlan, @RequestParam Long userId) {
       return workoutPlanService.generateWorkoutPlan(userId, idWorkoutPlan);
    }
    
    
}
