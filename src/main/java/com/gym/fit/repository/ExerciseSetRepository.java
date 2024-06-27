package com.gym.fit.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gym.fit.entity.ExerciseSet;
import com.gym.fit.entity.GymUser;

@Repository
public interface ExerciseSetRepository extends JpaRepository<ExerciseSet, Long> {
	
	@Query("SELECT e FROM ExerciseSet e WHERE e.gymUser.id = :userId AND DATE(e.createdTime) = DATE(:date)")
    List<ExerciseSet> findByUserIdAndDate(@Param("userId") Long userId, @Param("date") Date date);
}
