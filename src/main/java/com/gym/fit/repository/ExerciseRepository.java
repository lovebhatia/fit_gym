package com.gym.fit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gym.fit.entity.Exercise;
import com.gym.fit.entity.Workout;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
		List<Exercise> findByWorkouts(Workout workout);
}
