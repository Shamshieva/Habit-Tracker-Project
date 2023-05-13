package com.example.dto.request;

public record UserUpdateRequest (
        Long id,
        String fullName,
        String icon
){
}
