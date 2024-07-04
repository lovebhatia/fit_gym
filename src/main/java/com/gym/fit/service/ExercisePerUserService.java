package com.gym.fit.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gym.fit.dto.ExercisePerUserDTO;
import com.gym.fit.entity.ExercisePerUser;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


public interface ExercisePerUserService   {
	ExercisePerUser saveExercisePerUser(ExercisePerUserDTO exercisePerUserDTO);
	List<ExercisePerUser> getExercisePerUserByUserIdAndExerciseNameAndDate
			(Long userId, String exerciseName, LocalDate date);
	 //void updateExerciseSets
	 	//		(Long gymUserId, String exerciseName, LocalDateTime date, List<ExercisePerUser> newRecords);
	@Transactional
	 void deleteExerciseRecordsByDateAndExerciseNameAndUserId(LocalDate date, String exerciseName, Long userId);



}
