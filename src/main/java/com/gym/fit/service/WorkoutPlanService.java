package com.gym.fit.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    private static final Logger logger = LoggerFactory.getLogger(WorkoutPlanService.class);

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
        Set<DayOfWeek> restDays = new HashSet<DayOfWeek>();
        restDays.add(DayOfWeek.SATURDAY);
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
        distributeExercise(userWorkout, startDate, days, restDays);
        return ResponseEntity.ok("Workout plan generated successfully");
    }

    private ResponseEntity<?> distributeExercise(UserWorkout userWorkout, LocalDate startDate, int days, Set<DayOfWeek> restDays) {
    	 int workoutCount = 0; // Ensures exactly 'days' workouts are assigned

    	    for (int i = 0; workoutCount < days; i++) { // Continue until required workout days are assigned
    	        LocalDate workoutDate = startDate.plusDays(i);
    	        DayOfWeek dayOfWeek = workoutDate.getDayOfWeek();

    	        if (restDays.contains(dayOfWeek)) {
    	            // Skip rest days (e.g., weekends)
    	            logger.info("Skipping rest day: " + workoutDate + " (" + dayOfWeek + ")");
    	            continue;
    	        }

    	        List<Exercise> selectedExercises = selectedExercisesForDay(userWorkout, workoutCount);
    	        logger.info("Selected Exercise size --> " + selectedExercises.size());

    	        List<UserWorkoutExercise> userWorkoutExercises = new ArrayList<>();
    	        for (Exercise exercise : selectedExercises) {
    	            UserWorkoutExercise userWorkoutExercise = new UserWorkoutExercise();
    	            userWorkoutExercise.setUserWorkout(userWorkout);
    	            userWorkoutExercise.setExercise(exercise);
    	            userWorkoutExercise.setWorkoutDate(workoutDate);
    	            userWorkoutExercise.setWorkoutDay(dayOfWeek.toString()); // Save day of the week
    	            userWorkoutExercise.setExerciseName(exercise.getExerciseName());
    	            userWorkoutExercise.setWorkoutName(exercise.getWorkoutName());
    	            userWorkoutExercises.add(userWorkoutExercise);
    	        }

    	        // Save all exercises in bulk for better performance
    	        userWorkoutExerciseRepository.saveAll(userWorkoutExercises);

    	        workoutCount++; // Increase only when a valid workout day is assigned
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