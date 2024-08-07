package com.gym.fit.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BmiRecordResponseDto {
	private Long id;
	private Long userId;
	private Double bmi;

}
