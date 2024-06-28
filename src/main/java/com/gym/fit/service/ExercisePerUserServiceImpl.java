package com.gym.fit.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.gym.fit.dto.ExercisePerUserDTO;
import com.gym.fit.entity.ExercisePerUser;
import com.gym.fit.entity.ExerciseSetRecord;
import com.gym.fit.entity.GymUser;
import com.gym.fit.repository.ExercisePerUserRepository;
import com.gym.fit.repository.ExerciseRecordSetRepository;
import com.gym.fit.repository.GymUserRepository;

@Service
public class ExercisePerUserServiceImpl implements ExercisePerUserService {
	
	@Autowired 
	GymUserRepository gymUserRepository;
	
	@Autowired
	ExercisePerUserRepository exercisePerUserRepository;
	
	@Autowired
	ExerciseRecordSetRepository exerciseRecordSetRepository;

	@Override
	public ExercisePerUser saveExercisePerUser(ExercisePerUserDTO exercisePerUserDTO) {
		System.out.println("in save exercise per user --> "+exercisePerUserDTO.getUserId());
		GymUser gymUser = gymUserRepository.findById(exercisePerUserDTO.getUserId())
				.orElseThrow(() -> new  ResourceNotFoundException("user Not found"));
		ExercisePerUser exercisePerUser = ExercisePerUser.builder()
				.gymUser(gymUser)
				.exerciseName(exercisePerUserDTO.getExerciseName())
				.build();
		ExercisePerUser savedExercisePerUser = exercisePerUserRepository.save(exercisePerUser);
		
		List<ExerciseSetRecord> exerciseRecords = exercisePerUserDTO.getRecords().stream().map(recordDTO -> {
			ExerciseSetRecord record = ExerciseSetRecord.builder()
                    .exercisePerUser(savedExercisePerUser)
                    .reps(recordDTO.getReps())
                    .weight(recordDTO.getWeight())
                    .set(recordDTO.getSet())
                    .build();
            return record;
        }).collect(Collectors.toList());

		exerciseRecordSetRepository.saveAll(exerciseRecords);
		return savedExercisePerUser;
	}

}
