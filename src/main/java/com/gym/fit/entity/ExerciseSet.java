package com.gym.fit.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseSet {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne
	@JoinColumn(name = "exerise_per_workout_per_user_id")
	private ExercisePerWorkoutPerUser exercisePerWorkoutPerUser;
	
	@ManyToOne
	@JoinColumn(name = "exerise_per_user_id")
	private ExercisePerUser exercisePerUser;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private GymUser gymUser;
	
	private Integer reps;
	private Double weight;
	private String exerciseName;
	private int set;
	@CreationTimestamp
	private Date createdTime;
	
}
