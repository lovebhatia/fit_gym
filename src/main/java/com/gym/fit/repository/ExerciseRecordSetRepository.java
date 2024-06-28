package com.gym.fit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gym.fit.entity.ExerciseSetRecord;

public interface ExerciseRecordSetRepository extends JpaRepository<ExerciseSetRecord, Long> {

}
