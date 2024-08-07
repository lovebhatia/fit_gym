package com.gym.fit.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gym.fit.dto.ExercisePerUserDTO;
import com.gym.fit.entity.ExercisePerUser;
import com.gym.fit.entity.ExerciseSetRecord;
import com.gym.fit.entity.GymUser;
import com.gym.fit.repository.ExercisePerUserRepository;
import com.gym.fit.repository.ExerciseRecordSetRepository;
import com.gym.fit.repository.ExerciseSetRecordRepository;
import com.gym.fit.repository.GymUserRepository;

@Service
public class ExercisePerUserServiceImpl implements ExercisePerUserService {
	
	@Autowired 
	GymUserRepository gymUserRepository;
	
	@Autowired
	ExercisePerUserRepository exercisePerUserRepository;
	
	@Autowired
	ExerciseRecordSetRepository exerciseRecordSetRepository;
	
	@Autowired
	ExerciseSetRecordRepository exerciseSetRecordRepository;

	@Override
	@Transactional
	public ExercisePerUser saveExercisePerUser(ExercisePerUserDTO exercisePerUserDTO) {
		System.out.println("in save exercise per user --> "+exercisePerUserDTO.getUserId());
		GymUser gymUser = gymUserRepository.findById(exercisePerUserDTO.getUserId())
				.orElseThrow(() -> new  ResourceNotFoundException("user Not found"));
		ExercisePerUser exercisePerUser = ExercisePerUser.builder()
				.gymUser(gymUser)
				.exerciseName(exercisePerUserDTO.getExerciseName())
				.build();
		System.out.println(exercisePerUserDTO.getDate());
		deleteExerciseRecordsByDateAndExerciseNameAndUserId(exercisePerUserDTO.getDate(), exercisePerUserDTO.getExerciseName(), exercisePerUserDTO.getUserId());
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

	@Override
	public List<ExercisePerUser> getExercisePerUserByUserIdAndExerciseNameAndDate(Long userId, String exerciseName, LocalDate date) {
		LocalDateTime startOfDay = date.atStartOfDay();
		LocalDateTime endOfDay = date.atTime(LocalTime.MAX);
		return exercisePerUserRepository.findByGymUserIdAndExerciseNameAndCreatedAtBetween(userId, exerciseName, startOfDay, endOfDay);

	}


	
	@Transactional
	public void deleteExerciseRecordsByDateAndExerciseNameAndUserId(LocalDate date, String exerciseName,
			Long userId) {
		System.out.println(date+"--"+exerciseName+"--"+userId);
		List<ExercisePerUser> exercisePerUsers = exercisePerUserRepository.
				findByCreatedAtAndExerciseNameAndUserId(date, exerciseName, userId);
        
        for (ExercisePerUser exercisePerUser : exercisePerUsers) {
        	System.out.println("in exercise per user");
            exerciseSetRecordRepository.deleteByExercisePerUser(exercisePerUser);
            exercisePerUserRepository.delete(exercisePerUser);
        }
    }

	public List<ExercisePerUser> getExerciseHistory(String exerciseName, Long userId) {
		Pageable pageable = PageRequest.of(0, 2); // Limiting to the last two distinct dates
        List<java.sql.Date> lastTwoDates = exercisePerUserRepository.findLastTwoDistinctDatesExcludingToday(exerciseName, userId);

		if (lastTwoDates.isEmpty()) {
			return new ArrayList<>();
		}

		return exercisePerUserRepository.findByExerciseNameAndUserIdAndDates(exerciseName, userId, lastTwoDates);
	}
		
	


}
