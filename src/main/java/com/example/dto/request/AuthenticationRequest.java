package com.example.dto.request;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationRequest(
        @NotBlank(message = "Email cannot be empty!")
        String email,
        @NotBlank(message = "Password cannot be empty!")
        String password
) {
}
