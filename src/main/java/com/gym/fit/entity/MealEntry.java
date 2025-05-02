package com.gym.fit.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.gym.fit.MealType;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "meal_entries")
public class MealEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private GymUser user;

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private MealType mealType; // Breakfast, Lunch, Dinner, Snack 1, Snack 2, Snack 3

    @OneToMany(mappedBy = "mealEntry", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<FoodItem> foodItems;
}

