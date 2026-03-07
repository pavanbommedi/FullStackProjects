package com.smartTrainApp.TrainApp.dto.request;

import lombok.Data;

@Data
public class RegisterUserRequest {

    private String name;

    private String email;

    private String password;
}

// The User entity may contain:

// id
// role
// createdDate
// bookings

// Client should not send those.

// DTO restricts input.