package com.gym.fit.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.time.LocalDate;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gym.fit.MealType;
import com.gym.fit.entity.FoodItem;
import com.gym.fit.entity.GymUser;
import com.gym.fit.entity.MealEntry;
import com.gym.fit.securityConfig.JwtAuthenticationFilter;
import com.gym.fit.securityConfig.JwtTokenProvider;
import com.gym.fit.service.MealEntryService;

@WebMvcTest(controllers = MealEntryController.class)
@AutoConfigureMockMvc(addFilters = false) 
class MealEntryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper; // This is Spring Boot's default and smart ObjectMapper

    @MockBean
    private MealEntryService mealEntryService;
    
    @MockBean
    private JwtTokenProvider jwtTokenProvider;

    private GymUser gymUser;
    private MealEntry mealEntry;
    private FoodItem foodItem;

    @BeforeEach
    void setup() {
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
                .mealType(MealType.BREAKFAST)
                .build();
    }

    @Test
    void testSaveMealEntry() throws Exception {
        Long userId = 1L;

        when(mealEntryService.saveMealEntry(mealEntry)).thenReturn(mealEntry);

        mockMvc.perform(post("/api/meal-entry/{userId}", userId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(mealEntry))) // 👍 Spring's pre-configured smart mapper
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.mealType").value("BREAKFAST"))
                .andExpect(jsonPath("$.foodItems[0].foodName").value("Oats")); // Use actual JSON property name
    }
}

