package com.example.dto.response;

import com.example.enums.ExecutionFrequency;
import lombok.Builder;

@Builder
public record HabitCalendarResponse(
        String name,
        String description,
        Integer goal,
        ExecutionFrequency frequency,
        Boolean isDone
) {
}
