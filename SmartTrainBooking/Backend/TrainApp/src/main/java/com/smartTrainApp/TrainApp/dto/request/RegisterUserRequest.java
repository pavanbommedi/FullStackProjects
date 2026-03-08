package com.smartTrainApp.TrainApp.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterUserRequest {
    @NotNull
    @Size
    private String name;
    @Email
    private String email;
    @NotNull
    private String password;
}

// The User entity may contain:

// id
// role
// createdDate
// bookings

// Client should not send those.

// DTO restricts input.