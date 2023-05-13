package com.example.dto.request;

import com.example.enums.ExecutionFrequency;
import com.example.enums.MeasureType;

import java.time.LocalDate;

public record HabitSaveRequest(
        String name,
        String description,
        Integer goal,
        ExecutionFrequency frequency,
        LocalDate start_date,
        LocalDate end_date,
        MeasureType measureType
) {
}
