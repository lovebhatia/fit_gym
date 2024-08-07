package com.gym.fit.service;

import com.gym.fit.dto.BmiRecordRequestDto;
import com.gym.fit.dto.BmiRecordResponseDto;
import com.gym.fit.entity.BMIRecord;

public interface BmiRecordPerUserService {
	BmiRecordResponseDto createBmiRecord(BmiRecordRequestDto bmiRecordRequestDto);
	BmiRecordResponseDto updateBmiRecord(Long id, BmiRecordRequestDto bmiRecordRequestDto);
	BmiRecordResponseDto getBmiRecordPerUser(Long userId);

}
