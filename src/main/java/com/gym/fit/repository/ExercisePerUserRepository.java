package com.gym.fit.repository;

import com.gym.fit.entity.Exercise;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gym.fit.dto.ExercisePerUserDTO;
import com.gym.fit.entity.ExercisePerUser;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ExercisePerUserRepository extends JpaRepository<ExercisePerUser, Long> {

    List<ExercisePerUser> findByGymUserIdAndExerciseNameAndCreatedAtBetween
            (Long gymUserId, String exerciseName, LocalDateTime startDate, LocalDateTime endDate);
    
    void deleteByGymUserIdAndExerciseNameAndCreatedAtBetween(
            Long gymUserId, String exerciseName, LocalDateTime startDate, LocalDateTime endDate);
    
    @Query("SELECT e FROM ExercisePerUser e WHERE FUNCTION('DATE', e.createdAt) = :date AND e.exerciseName = :exerciseName AND e.gymUser.id = :userId")
    List<ExercisePerUser> findByCreatedAtAndExerciseNameAndUserId(@Param("date") LocalDate date, @Param("exerciseName") String exerciseName, @Param("userId") Long userId);

    @Query("SELECT DISTINCT FUNCTION('DATE', e.createdAt) FROM ExercisePerUser e WHERE e.exerciseName = :exerciseName AND e.gymUser.id = :userId ORDER BY FUNCTION('DATE', e.createdAt) DESC")
    List<LocalDate> findLastTwoDistinctDates(@Param("exerciseName") String exerciseName, @Param("userId") Long userId, Pageable pageable);

    @Query("SELECT e FROM ExercisePerUser e WHERE DATE(e.createdAt) IN :dates AND e.exerciseName = :exerciseName AND e.gymUser.id = :userId")
    List<ExercisePerUser> findByExerciseNameAndUserIdAndDates(@Param("exerciseName") String exerciseName, @Param("userId") Long userId, @Param("dates") List<LocalDate> dates);



}
