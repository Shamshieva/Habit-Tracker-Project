package com.example.service;

import com.example.dto.request.UserRequest;
import com.example.dto.request.UserUpdateRequest;
import com.example.dto.response.HabitResponse;
import com.example.dto.response.HabitUserResponse;
import com.example.dto.response.SimpleResponse;
import com.example.dto.response.UserProfileResponse;

import java.util.List;

public interface UserProfileService {
    SimpleResponse save(UserRequest request);

    UserProfileResponse getUserById(Long id);

    SimpleResponse delete(Long id);

    SimpleResponse update(UserUpdateRequest request);

    List<HabitResponse> getHabits(Long id);
}
