package com.gym.fit.service;


import org.springframework.stereotype.Service;

import com.gym.fit.dto.ExercisePerUserDTO;
import com.gym.fit.entity.ExercisePerUser;



public interface ExercisePerUserService   {
	ExercisePerUser saveExercisePerUser(ExercisePerUserDTO exercisePerUserDTO);

	
}
