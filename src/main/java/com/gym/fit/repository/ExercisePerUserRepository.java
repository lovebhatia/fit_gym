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

    @Query(value = "SELECT DISTINCT created_date FROM (SELECT DATE(created_at) as created_date FROM exercise_per_user WHERE exercise_name = :exerciseName AND user_id = :userId AND DATE(created_at) != CURRENT_DATE GROUP BY created_date ORDER BY created_date DESC) subquery LIMIT 1", nativeQuery = true)
    List<java.sql.Date> findLastTwoDistinctDatesExcludingToday(@Param("exerciseName") String exerciseName, @Param("userId") Long userId);
    
    @Query("SELECT e FROM ExercisePerUser e JOIN FETCH e.exerciseSetRecords WHERE FUNCTION('DATE', e.createdAt) IN :dates AND e.exerciseName = :exerciseName AND e.gymUser.id = :userId ORDER BY e.createdAt DESC")
    List<ExercisePerUser> findByExerciseNameAndUserIdAndDates(@Param("exerciseName") String exerciseName, @Param("userId") Long userId, @Param("dates") List<java.sql.Date> dates);



}
