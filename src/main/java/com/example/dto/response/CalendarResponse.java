package com.example.dto.response;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record CalendarResponse(
        Long id,
        String userFullName,
        String icon,
        LocalDate startDate,
        LocalDate endDate,
        List<HabitCalendarResponse> habitCalendarResponses
) {
}
