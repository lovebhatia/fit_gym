package com.gym.fit.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gym.fit.entity.Workout;

@Repository
public interface WorkoutRepository extends CrudRepository<Workout, Long> {
	List<WorkoutProjection> findAllBy();
	
	
	interface WorkoutProjection {
        Long getId();
        String getWorkout();
        Date getcreatedTime();
        String getShowSequence();
        String getImageName();
    }
	
}
