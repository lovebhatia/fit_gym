package com.gym.fit.service;


import org.springframework.stereotype.Service;

import com.gym.fit.dto.ExercisePerUserDTO;
import com.gym.fit.entity.ExercisePerUser;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


public interface ExercisePerUserService   {
	ExercisePerUser saveExercisePerUser(ExercisePerUserDTO exercisePerUserDTO);
	List<ExercisePerUser> getExercisePerUserByUserIdAndExerciseNameAndDate
			(Long userId, String exerciseName, LocalDate date);




}
