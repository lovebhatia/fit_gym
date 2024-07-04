package com.gym.fit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gym.fit.entity.ExercisePerUser;
import com.gym.fit.entity.ExerciseSetRecord;

public interface ExerciseSetRecordRepository extends JpaRepository<ExerciseSetRecord, Long> {
    void deleteByExercisePerUser(ExercisePerUser exercisePerUser);


}
