package com.gym.fit.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "workout_plan")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WorkoutPlanperUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private int dayNumber;
	private String workouttype;
	
	@ManyToOne
	@JoinColumn(name = "workout_id", nullable = false)
	private WorkoutProgram workoutProgram;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private GymUser gymUser;
	
	@Column(nullable = false)
	private LocalDate startDate;
	
	private LocalDate endDate;
	
}
