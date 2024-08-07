package com.gym.fit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gym.fit.dto.BmiRecordRequestDto;
import com.gym.fit.dto.BmiRecordResponseDto;
import com.gym.fit.entity.BMIRecord;
import com.gym.fit.repository.BmiRepository;
import com.gym.fit.service.BmiRecordPerUserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/bmi")
@AllArgsConstructor
public class BMIController {
	
	private BmiRecordPerUserService bmiRecordPerUserService;
	@Autowired
	BmiRepository bmiRepository;
	
	@PostMapping
	public ResponseEntity<BmiRecordResponseDto> createBmiRecordPerUser(@RequestBody  BmiRecordRequestDto bmiRecordRequestDto) {
		System.out.println(bmiRecordRequestDto.getBmi() + "--" + bmiRecordRequestDto.getUserId());
		return ResponseEntity.ok(bmiRecordPerUserService.createBmiRecord(bmiRecordRequestDto));
	}
	
	 @PutMapping("/{id}")
	    public ResponseEntity<BmiRecordResponseDto> updateBmiRecordPerUser(@PathVariable Long id, @RequestBody BmiRecordRequestDto bmiRecordRequestDto) {
	        System.out.println("Updating BMI record with ID: " + id);
	        return ResponseEntity.ok(bmiRecordPerUserService.updateBmiRecord(id, bmiRecordRequestDto));
	    }
	 
	 @GetMapping("/{userId}")
		public ResponseEntity<BmiRecordResponseDto> getBmiRecordPerUser(@PathVariable Long userId) {
		 BmiRecordResponseDto response = bmiRecordPerUserService.getBmiRecordPerUser(userId);
	        return ResponseEntity.ok(response);
		}

}
