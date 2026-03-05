package com.smartTrainApp.TrainApp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.smartTrainApp.TrainApp.entity.Booking;
import com.smartTrainApp.TrainApp.entity.User;
import com.smartTrainApp.TrainApp.repository.BookingRepository;
import com.smartTrainApp.TrainApp.repository.UserRepository;
import com.smartTrainApp.TrainApp.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final BookingRepository bookingRepository;
    //@RequiredArgsConstructor generates constructor for:

    // All final fields

    // All @NonNull fields

    // So if fields are not final, Lombok won’t generate constructor.

    public User registerUser(User user){
        if(userRepository.findByEmail(user.getEmail()).isPresent()){
            throw new RuntimeException("Email already registered");
        }
        return userRepository.save(user);
    }

    public User getUserById(Long userId){
        return userRepository.findById(userId)
        .orElseThrow(()->new RuntimeException("user not found"));
    }
     public List<Booking> getUserBookings(Long userId) {

        return bookingRepository.findByUserId(userId);
    }

  



  

}
