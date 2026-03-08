package com.smartTrainApp.TrainApp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.smartTrainApp.TrainApp.dto.request.RegisterUserRequest;
import com.smartTrainApp.TrainApp.dto.response.BookingResponseDTO;
import com.smartTrainApp.TrainApp.dto.response.UserResponseDTO;
import com.smartTrainApp.TrainApp.entity.Booking;
import com.smartTrainApp.TrainApp.entity.User;
import com.smartTrainApp.TrainApp.exception.CustomExceptions.EmailAlreadyRegisteredException;
import com.smartTrainApp.TrainApp.exception.CustomExceptions.ResourceNotFoundException;
import com.smartTrainApp.TrainApp.mapper.BookingMapper;
import com.smartTrainApp.TrainApp.mapper.UserMapper;
import com.smartTrainApp.TrainApp.repository.BookingRepository;
import com.smartTrainApp.TrainApp.repository.UserRepository;
import com.smartTrainApp.TrainApp.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final BookingRepository bookingRepository;
    private final UserMapper userMapper;
    private final BookingMapper bookingMapper;
    //@RequiredArgsConstructor generates constructor for:

    // All final fields

    // All @NonNull fields

    // So if fields are not final, Lombok won’t generate constructor.

    public UserResponseDTO registerUser(RegisterUserRequest request){
        User user = userMapper.toEntity(request);
        if(userRepository.findByEmail(user.getEmail()).isPresent()){
            throw new EmailAlreadyRegisteredException("Email already registered");
        }
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    public UserResponseDTO getUserById(Long userId){
        User user = userRepository.findById(userId)
        .orElseThrow(()->new ResourceNotFoundException("user not found "+userId));

        return userMapper.toDto(user);
    }
     public List<BookingResponseDTO> getUserBookings(Long userId) {

        List<Booking> booking  = bookingRepository.findByUserId(userId);

        return bookingMapper.toDTOList(booking);
    }

  



  

}
