package com.gym.fit;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.gym.fit.entity.FoodItem;
import com.gym.fit.entity.GymUser;
import com.gym.fit.entity.MealEntry;
import com.gym.fit.repository.MealEntryRepository;
import com.gym.fit.service.MealEntryServiceImpl;

@ExtendWith(MockitoExtension.class)
public class MealEntryServiceTest {
	
	@Mock
	private MealEntryRepository mealEntryRepository;
	
	//@InjectMocks
	//private MealEntryServiceImpl mealEntryServiceImpl;
	
	private GymUser gymUser;
	private MealEntry mealEntry;
	private FoodItem foodItem;
	
	@BeforeEach
	void setUp() {
		gymUser = GymUser.builder()
				.id(1L)
				.username("lovebhatia")
				.email("love@example.com")
				.build();
		
		foodItem = FoodItem.builder()
				.id(1L)
				.foodName("Oats")
				.quantity(100)
				.protein(10.0)
				.carbs(50.0)
				.calories(300)
				.build();
		
		mealEntry = MealEntry.builder()
				.id(1L)
				.user(gymUser)
				.date(LocalDate.of(2025, 3, 8))
				.foodItems(Set.of(foodItem))
				//.mealType(MealType.BREAKFAST)
				.build();
	}
	
	@Test
	void testSaveMealEntry() {
		when(mealEntryRepository.save(any(MealEntry.class))).thenReturn(mealEntry);
		//MealEntry savedMealEntry = mealEntryServiceImpl.saveMealEntry(mealEntry);
	}
	

}
