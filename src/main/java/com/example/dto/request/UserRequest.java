package com.example.dto.request;

import com.example.validation.PasswordValid;
import jakarta.validation.constraints.*;

public record UserRequest(
        String fullName,
        String icon,
        String email,
        String password ) {
}
