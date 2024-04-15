package com.gym.fit.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gym.fit.entity.WorkoutProgram;
import com.gym.fit.repository.WorkoutRepository.WorkoutProjection;

public interface WorkoutProgramRepository extends JpaRepository<WorkoutProgram, Long> {
	
	List<WorkoutProgramProjection> findAllBy();

	
	interface WorkoutProgramProjection {
        Long getId();
        String getWorkoutProgramName();
        Date getCreatedTime();
        String getImageName();
        String getLevel();
        String getMainGoal();
        String getDaysPerWeek();
        String getDurationRange();
        String getDescription();
        Double getRating();
        String getIcon();
        int getSequence();
        
    }

}
