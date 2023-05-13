package com.example.dto.response;

import com.example.enums.ExecutionFrequency;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record HabitResponse(
        Long id,
        String name,
        String description,
        Integer goal,
        ExecutionFrequency frequency,

        Boolean isDone,
        LocalDate start_date,
        LocalDate end_date
) {

}
