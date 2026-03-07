package com.smartTrainApp.TrainApp.service;

import java.util.List;

import com.smartTrainApp.TrainApp.dto.request.RegisterUserRequest;
import com.smartTrainApp.TrainApp.dto.response.BookingResponseDTO;
import com.smartTrainApp.TrainApp.dto.response.UserResponseDTO;

public interface UserService {
    UserResponseDTO registerUser(RegisterUserRequest user);

    UserResponseDTO getUserById(Long userId);

    List<BookingResponseDTO> getUserBookings(Long userId);

}
