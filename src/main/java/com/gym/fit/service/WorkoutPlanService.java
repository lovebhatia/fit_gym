package com.gym.fit.service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gym.fit.entity.Exercise;
import com.gym.fit.entity.GymUser;
import com.gym.fit.entity.UserWorkout;
import com.gym.fit.entity.UserWorkoutExercise;
import com.gym.fit.entity.WorkoutProgram;
import com.gym.fit.repository.ExerciseRepository;
import com.gym.fit.repository.GymUserRepository;
import com.gym.fit.repository.UserWorkoutExerciseRepository;
import com.gym.fit.repository.UserWorkoutRepository;
import com.gym.fit.repository.WorkoutProgramRepository;

@Service
public class WorkoutPlanService {
	
	@Autowired
	private UserWorkoutRepository userWorkoutRepository;
	
	@Autowired
	private UserWorkoutExerciseRepository userWorkoutExerciseRepository;
	
	@Autowired
	private WorkoutProgramRepository workoutProgramRepository;
	
	@Autowired
	private ExerciseRepository exerciseRepository;
	
	@Autowired
	private GymUserRepository gymUserRepository;
	
	public ResponseEntity<?> generateWorkoutPlan(Long userId, Long WorkoutProgramId) {
		int days = 7;
		WorkoutProgram workoutProgram = workoutProgramRepository.findById(WorkoutProgramId)
				.orElseThrow(() -> new RuntimeException("Workout program Not Found"));
		GymUser gymUser = gymUserRepository.findById(userId)
				.orElseThrow(() -> new RuntimeException("Gym User not Found"));
		
		//save user Workout Program
		LocalDate startDate = LocalDate.now();
		UserWorkout userWorkout = new UserWorkout();
		userWorkout.setGymUser(gymUser);
		userWorkout.setWorkoutProgram(workoutProgram);
		userWorkout.setStartDate(startDate);
		userWorkout = userWorkoutRepository.save(userWorkout);
		
		//Generate exercises for the next 7 days
		System.out.println("Saving user Workout");
		distributeExercise(userWorkout, startDate, days);
		return ResponseEntity.ok("Workout plan generated successfully");
	}
	
	private ResponseEntity<?> distributeExercise(UserWorkout userWorkout, LocalDate startDate, int days) {
		System.out.println("in  distribute exercise");
		for(int i = 0; i < days; i++) {
			LocalDate workoutDate = startDate.plusDays(i);
			List<Exercise> selectedExercises = selectedExercisesForDay(userWorkout, i);
			System.out.println("in  distribute exercise -- 1");
			for(Exercise exercise : selectedExercises) {
				UserWorkoutExercise userWorkoutExercise = new UserWorkoutExercise();
				userWorkoutExercise.setUserWorkout(userWorkout);
				userWorkoutExercise.setExercise(exercise);
				userWorkoutExercise.setWorkoutDate(workoutDate);
				userWorkoutExerciseRepository.save(userWorkoutExercise);
			}
		}
		return ResponseEntity.ok(userWorkout);
	}
	
	private List<Exercise> selectedExercisesForDay(UserWorkout userWorkout, int day) {
		System.out.println(userWorkout.getWorkoutProgram() .getWorkoutProgramName());
		if(userWorkout.getWorkoutProgram() .getWorkoutProgramName().equals("Upper/Lower Split")) {
			System.out.println("in  distribute exercise -- 2");
			List<Exercise> generatedExercises = generateUpperLowerSplitExercises(day);
			List<Exercise> upperLowerSplitExercises =  getRandomExercise(generatedExercises, 8);
			return upperLowerSplitExercises;
		}
		return null;
	}
	
	private List<Exercise> getRandomExercise(List<Exercise> exercises, int count) {
		Collections.shuffle(exercises);
		return exercises.subList(0, Math.min(count, exercises.size()));
	}
	
	
	public List<Exercise> generateUpperLowerSplitExercises(int day) {
		List<String> upperLowerSplit = null;
		List<Exercise> exercises = null;
		try{
			if(day % 2 == 0) {
				System.out.println("in  distribute exercise -- 3");
				upperLowerSplit = //exerciseRepository.findExercisesByWorkoutNames(
					Arrays.asList("Chest", "Back", "Biceps", "Triceps", "Shoulders"); 
				for(String group : upperLowerSplit) {
					exercises = exerciseRepository.findExercisesByWorkoutNames(Collections.singletonList(group));
					exercises.addAll(getRandomExercise(exercises,2 ));
				}
			} else {
				System.out.println("in  distribute exercise -- 4");
				upperLowerSplit = //exerciseRepository.findExercisesByWorkoutNames(
					Arrays.asList("Legs", "Hamstring", "Glutes");
				for(String group : upperLowerSplit) {
					exercises = exerciseRepository.findExercisesByWorkoutNames(Collections.singletonList(group));
					exercises.addAll(getRandomExercise(exercises,2 ));
				}
			}
		}catch(Exception e) {
			System.out.println("Exception in generateUpperLowerSplit :" +e.toString());
		}
		return exercises;
	}
}
