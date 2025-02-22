package com.gym.fit.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	//private static final Logger logger = LoggerFactory.getLogger(WorkoutPlanService.class);
	
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
		
		LocalDate startDate = LocalDate.now();
		UserWorkout userWorkout = new UserWorkout();
		userWorkout.setGymUser(gymUser);
		userWorkout.setWorkoutProgram(workoutProgram);
		userWorkout.setStartDate(startDate);
		userWorkout = userWorkoutRepository.save(userWorkout);
		distributeExercise(userWorkout, startDate, days);
		return ResponseEntity.ok("Workout plan generated successfully");
	}
	
	private ResponseEntity<?> distributeExercise(UserWorkout userWorkout, LocalDate startDate, int days) {
		for(int i = 0; i < 7; i++) {
			List<Exercise> selectedExercises = selectedExercisesForDay(userWorkout, i);
			LocalDate workoutDate = startDate.plusDays(i);
			//logger.info("selected Exercise size --> " + selectedExercises.size());
			System.out.println("Workout date before saving UserWorkout Exercise" + workoutDate + " ----- "+i);
			for(Exercise exercise : selectedExercises) {
				System.out.println("Workout date in loop- "+workoutDate);
				UserWorkoutExercise userWorkoutExercise = new UserWorkoutExercise();
				userWorkoutExercise.setUserWorkout(userWorkout);
				userWorkoutExercise.setExercise(exercise);
				userWorkoutExercise.setWorkoutDate(workoutDate);
				userWorkoutExercise.setExerciseName(exercise.getExerciseName());
				userWorkoutExercise.setWorkoutName(exercise.getWorkoutName());
				userWorkoutExerciseRepository.save(userWorkoutExercise);
			}
		}
		return ResponseEntity.ok(userWorkout);
	}
	
	private List<Exercise> selectedExercisesForDay(UserWorkout userWorkout, int day) {
		if(userWorkout.getWorkoutProgram() .getWorkoutProgramName().equals("Upper/Lower Split")) {
			List<Exercise> generatedExercises = generateUpperLowerSplitExercises(day);
			List<Exercise> upperLowerSplitExercises =  getRandomExercise(generatedExercises, 15);
			return upperLowerSplitExercises;
		}
		return null;
	}
	
	public List<Exercise> generateUpperLowerSplitExercises(int day) {
		List<String> upperLowerSplit = null;
		List<Exercise> exercises = new ArrayList<Exercise>();
		try{
			if(day % 2 == 0) {
				System.out.println("in  distribute exercise -- 3");
				upperLowerSplit = Arrays.asList("Chest", "Back", "Biceps", "Triceps", "Shoulder"); 
				for(String group : upperLowerSplit) {
					List<Exercise> groupExercises = exerciseRepository.findExercisesByWorkoutNames(Collections.singletonList(group));
					exercises.addAll(getRandomExercise(groupExercises,3));
				}
			} else {
				System.out.println("in  distribute exercise -- 4");
				upperLowerSplit = Arrays.asList("Legs", "Hamstring", "Glutes");
				for(String group : upperLowerSplit) {
					List<Exercise> groupExercises = exerciseRepository.findExercisesByWorkoutNames(Collections.singletonList(group));
					exercises.addAll(getRandomExercise(groupExercises,3));
				}
			}
		}catch(Exception e) {
			System.out.println("Exception in generateUpperLowerSplit :" +e.toString());
		}
		return exercises;
	}
	
	private List<Exercise> getRandomExercise(List<Exercise> exercises, int count) {
		Collections.shuffle(exercises);
		return exercises.subList(0, Math.min(count, exercises.size()));
	}
}
