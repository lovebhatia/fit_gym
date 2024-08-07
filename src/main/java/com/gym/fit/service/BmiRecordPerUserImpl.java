package com.gym.fit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.gym.fit.dto.BmiRecordRequestDto;
import com.gym.fit.dto.BmiRecordResponseDto;
import com.gym.fit.entity.BMIRecord;
import com.gym.fit.entity.GymUser;
import com.gym.fit.repository.BmiRepository;
import com.gym.fit.repository.GymUserRepository;

@Service
public class BmiRecordPerUserImpl implements BmiRecordPerUserService {
	
	@Autowired
	GymUserRepository gymUserRepository;
	
	@Autowired
	BmiRepository bmiRepository;

	@Override
	public BmiRecordResponseDto createBmiRecord(BmiRecordRequestDto bmiRecordRequestDto) {
		GymUser gymUser = gymUserRepository.findById(bmiRecordRequestDto.getUserId())
				.orElseThrow(() -> new  ResourceNotFoundException("user Not found"));
		BMIRecord bmiRecord = BMIRecord.builder()
				.user(gymUser)
				.bmi(bmiRecordRequestDto.getBmi())
				.build();
		BMIRecord saveBmiRecord = bmiRepository.save(bmiRecord);
		 BmiRecordResponseDto bmiRecordResponseDto = BmiRecordResponseDto.builder()
	        		.bmi(bmiRecordRequestDto.getBmi())
	        		.userId(bmiRecordRequestDto.getUserId())
	        		.id(saveBmiRecord.getId())
	        		.build();
		return bmiRecordResponseDto;
	}
	@Override
	    public BmiRecordResponseDto updateBmiRecord(Long id, BmiRecordRequestDto bmiRecordRequestDto) {
	        BMIRecord existingRecord = bmiRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("BMI record not found"));
	        
	        GymUser gymUser = gymUserRepository.findById(bmiRecordRequestDto.getUserId())
	                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

	        existingRecord.setUser(gymUser);
	        existingRecord.setBmi(bmiRecordRequestDto.getBmi());
	        
	        BmiRecordResponseDto bmiRecordResponseDto = BmiRecordResponseDto.builder()
	        		.bmi(bmiRecordRequestDto.getBmi())
	        		.userId(bmiRecordRequestDto.getUserId())
	        		.id(existingRecord.getId())
	        		.build();
	        
	        bmiRepository.save(existingRecord);	        
	        return bmiRecordResponseDto;
	    }
	@Override
	public BmiRecordResponseDto getBmiRecordPerUser(Long userId) {
		GymUser gymUser = gymUserRepository.findById(userId)
				.orElseThrow(() -> new  ResourceNotFoundException("user Not found"));
		BMIRecord bmiRecord = bmiRepository.findFirstByUserOrderByDateDesc(gymUser)
	            .orElseThrow(() -> new ResourceNotFoundException("BMI record not found"));
	    return new BmiRecordResponseDto(bmiRecord.getId(),gymUser.getId(), bmiRecord.getBmi());

	}
	
	

}
