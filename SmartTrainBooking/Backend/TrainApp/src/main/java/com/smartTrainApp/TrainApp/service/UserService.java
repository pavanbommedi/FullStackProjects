package com.smartTrainApp.TrainApp.service;

import java.util.List;

import com.smartTrainApp.TrainApp.entity.Booking;
import com.smartTrainApp.TrainApp.entity.User;

public interface UserService {
    User registerUser(User user);

    User getUserById(Long userId);

    List<Booking> getUserBookings(Long userId);

}
