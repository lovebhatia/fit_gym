package com.gym.fit.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gym.fit.entity.GymUser;
import com.gym.fit.entity.MealEntry;

@Repository
public interface MealEntryRepository extends JpaRepository<MealEntry, Long> {
	
	List<MealEntry> findByUserAndDate(GymUser user, LocalDate date);
	//MealEntry findByuserIdAndDateAndMealtype(Long userId, LocalDate date, String mealtype);

}
