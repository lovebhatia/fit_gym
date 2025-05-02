package com.gym.fit.service;

import java.time.LocalDate;
import java.util.List;

import com.gym.fit.entity.GymUser;
import com.gym.fit.entity.MealEntry;

public interface MealEntryService {
	MealEntry saveMealEntry(MealEntry mealEntry);
	List<MealEntry> getMealEntriesByUserAndDate(GymUser gymUser, LocalDate date);
	//void deleteMealEntry(Long id);

}
