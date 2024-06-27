package com.gym.fit.dto;

import java.util.List;

import lombok.Data;

@Data
public class ExerciseSetDTO {
	
	private Long exercisePerUserId;
    private String exerciseName;
    private List<ExerciseRecordDTO> records;  
}
