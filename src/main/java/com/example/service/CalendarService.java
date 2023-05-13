package com.example.service;

import com.example.dto.response.CalendarResponse;

public interface CalendarService {

    CalendarResponse getCalendarByUserId(Long userId);

//    List<CalendarResponse> findAll();
}