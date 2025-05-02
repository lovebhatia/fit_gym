package com.gym.fit.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gym.fit.entity.MealEntry;
import com.gym.fit.service.MealEntryService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/meal-entry")
@RequiredArgsConstructor
public class MealEntryController {
	
	private final MealEntryService mealEntryService;
	
	@PostMapping("/{userId}")
	public ResponseEntity<MealEntry> saveMealEntry(@PathVariable Long userId, @RequestBody MealEntry mealEntry) {
		MealEntry savedMealEntry = mealEntryService.saveMealEntry(mealEntry);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedMealEntry);
	}
	
}
