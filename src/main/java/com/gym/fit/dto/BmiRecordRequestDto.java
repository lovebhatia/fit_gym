package com.gym.fit.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BmiRecordRequestDto {
	private Long userId;
	private Double bmi;
	

}
