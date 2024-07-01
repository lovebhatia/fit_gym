package com.gym.fit.repository;

import com.gym.fit.entity.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gym.fit.dto.ExercisePerUserDTO;
import com.gym.fit.entity.ExercisePerUser;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ExercisePerUserRepository extends JpaRepository<ExercisePerUser, Long> {

    List<ExercisePerUser> findByGymUserIdAndExerciseNameAndCreatedAtBetween
            (Long gymUserId, String exerciseName, LocalDateTime startDate, LocalDateTime endDate);


}
