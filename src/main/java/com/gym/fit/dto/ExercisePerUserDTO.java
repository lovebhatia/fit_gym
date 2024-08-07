package com.gym.fit.dto;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.gym.fit.entity.ExerciseSetRecord;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExercisePerUserDTO {
    private Long userId;
    private String exerciseName;
    @OneToMany(mappedBy = "exerciseSet", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<ExerciseSetRecord> records;
    private LocalDate date;
}
