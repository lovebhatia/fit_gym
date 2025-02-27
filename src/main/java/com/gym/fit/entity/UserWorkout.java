package com.gym.fit.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "user_workout")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserWorkout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int dayNumber;
    private String workouttype;
    @Column(nullable = false)
    private LocalDate startDate;
    private LocalDate endDate;   
    private LocalDate lastGeneratedWorkoutDate;
    
    @ManyToOne
    @JoinColumn(name = "workout_id", nullable = false)
    private WorkoutProgram workoutProgram;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private GymUser gymUser;

}
