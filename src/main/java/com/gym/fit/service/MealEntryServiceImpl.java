package com.gym.fit.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gym.fit.entity.GymUser;
import com.gym.fit.entity.MealEntry;
import com.gym.fit.repository.MealEntryRepository;

public class MealEntryServiceImpl implements MealEntryService {
	
	@Autowired
	MealEntryRepository mealEntryRepository;

	@Override
	public MealEntry saveMealEntry(MealEntry mealEntry) {
		return mealEntryRepository.save(mealEntry);
	}

	@Override
	public List<MealEntry> getMealEntriesByUserAndDate(GymUser user, LocalDate date) {
		return mealEntryRepository.findByUserAndDate(user, date);
	}

}
