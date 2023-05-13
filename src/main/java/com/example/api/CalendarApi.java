package com.example.api;

import com.example.dto.response.CalendarResponse;
import com.example.service.CalendarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/calendars")
@Tag(name = "Calendar", description = "API endpoints for calendar")
public class CalendarApi {
    private final CalendarService calendarService;

    @GetMapping("/{userId}")
    @Operation(summary = "The Calendar get with name ",
            description = "Calendar with user id"
    )
    public CalendarResponse getCalendarByUserId(@PathVariable Long userId){
        return calendarService.getCalendarByUserId(userId);
    }

//    @GetMapping
//    @Operation(summary = "Get all Calendars with users method ",
//            description = "Calendar with users"
//    )
//    public List<CalendarResponse> getCalendars(){
//        return calendarService.findAll();
//    }

}
