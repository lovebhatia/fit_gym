package com.gym.fit.dto;

import lombok.Data;

@Data
public class ExerciseSetDTO {
	
	 private Long exercisePerUserId;
	 private Integer reps;
	 private Double weight;
	 private int sets;  
}
