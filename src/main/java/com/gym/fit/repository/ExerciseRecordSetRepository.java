package com.gym.fit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gym.fit.entity.ExerciseSetRecord;

@Repository
public interface ExerciseRecordSetRepository extends JpaRepository<ExerciseSetRecord, Long> {

}
