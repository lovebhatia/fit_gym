package com.gym.fit.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gym.fit.entity.BMIRecord;
import com.gym.fit.entity.GymUser;

@Repository
public interface BmiRepository extends JpaRepository<BMIRecord, Long> {
    List<BMIRecord> findByUserId(Long userId);
    Optional<BMIRecord> findFirstByUserOrderByDateDesc(GymUser gymUser);

	
}
