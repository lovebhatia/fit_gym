package com.gym.fit.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "food_items")
public class FoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String foodName;
    private int quantity;
    private double protein;
    private double carbs;
    private double fats;
    private double calories;

    @ManyToOne
    @JoinColumn(name = "meal_entry_id", nullable = false)
    private MealEntry mealEntry;
}

