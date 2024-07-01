package com.gym.fit.entity;


import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseSetRecord {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "exercise_per_user_id", nullable = false)
    private ExercisePerUser exercisePerUser;

    private Integer reps;
    private Double weight;
    private int set;

    @CreationTimestamp
    private Date createdTime;

}

