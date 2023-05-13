package com.example.service.impl;

import com.example.dto.response.CalendarResponse;
import com.example.exceptions.NotFoundException;
import com.example.repository.CalendarRepository;
import com.example.service.CalendarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalendarServiceImpl implements CalendarService {
    private final CalendarRepository calendarRepository;
    @Override
    public CalendarResponse getCalendarByUserId(Long userId) {
        return calendarRepository.getByUserId(userId)
                .orElseThrow(()-> new NotFoundException("Not found!"));
    }

//    @Override
//    public List<CalendarResponse> findAll() {
//        return calendarRepository.getAll();
//    }
}
