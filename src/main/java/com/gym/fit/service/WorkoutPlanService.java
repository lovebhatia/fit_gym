package com.gym.fit.service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	int days = 7;
	
	public void generateWorkoutPlan(Long userId, Long WorkoutProgramId, LocalDate startDate) {
		WorkoutProgram workoutProgram = workoutProgramRepository.findById(WorkoutProgramId)
				.orElseThrow(() -> new RuntimeException("Workout program Not Found"));
		GymUser gymUser = gymUserRepository.findById(userId)
				.orElseThrow(() -> new RuntimeException("Gym User not Found"));
		
		//save user Workout Program
		
		UserWorkout userWorkout = new UserWorkout();
		userWorkout.setGymUser(gymUser);
		userWorkout.setWorkoutProgram(workoutProgram);
		userWorkout.setStartDate(startDate);
		userWorkout = userWorkoutRepository.save(userWorkout);
		
		//Generate exercises for the next 7 days
		distributeExercise(userWorkout, startDate, days);
	}
	
	private void distributeExercise(UserWorkout userWorkout, LocalDate startDate, int days) {
		for(int i = 0; i < days; i++) {
			LocalDate workouDate = startDate.plusDays(i);
			List<Exercise> selectedExercises = selectedExercisesForDay(userWorkout, i);
			for(Exercise exercise : selectedExercises) {
				UserWorkoutExercise userWorkoutExercise = new UserWorkoutExercise();
				userWorkoutExercise.setUserWorkout(userWorkout);
				userWorkoutExercise.setExercise(exercise);
				userWorkoutExercise.setWorkoutDate(workouDate);
				userWorkoutExerciseRepository.save(userWorkoutExercise);
			}
		}
	}
	
	private List<Exercise> selectedExercisesForDay(UserWorkout userWorkout, int day) {
		if(userWorkout.getWorkoutProgram() .getWorkoutProgramName()== "upper/lower split") {
			List<Exercise> upperLowerSplitExercise = generateupperLowerSplitExercises(day);
			return upperLowerSplitExercise;
		}
		return null;
	}
	
	
	public List<Exercise> generateupperLowerSplitExercises(int day) {
		List<Exercise> upperLowerSplit = null;
		if(day % 2 == 0) {
			upperLowerSplit = exerciseRepository.findExercisesByWorkoutNames(
				Arrays.asList("Chest", "Back", "Biceps", "Triceps", "Shoulders")); 
		} else {
			upperLowerSplit = exerciseRepository.findExercisesByWorkoutNames(
	            Arrays.asList("Legs", "Hamstring", "Glutes"));
		}
		return upperLowerSplit;
	}
}
