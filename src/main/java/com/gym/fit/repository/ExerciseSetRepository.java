package com.gym.fit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gym.fit.entity.ExerciseSet;

@Repository
public interface ExerciseSetRepository extends JpaRepository<ExerciseSet, Long> {

}
