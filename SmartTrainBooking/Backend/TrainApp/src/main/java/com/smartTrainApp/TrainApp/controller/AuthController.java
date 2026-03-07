package com.smartTrainApp.TrainApp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartTrainApp.TrainApp.dto.request.RegisterUserRequest;
import com.smartTrainApp.TrainApp.dto.response.UserResponseDTO;
import com.smartTrainApp.TrainApp.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    @PostMapping("/register")
    public UserResponseDTO registerUser(@RequestBody RegisterUserRequest request){
        return userService.registerUser(request);
    }
    //Login

    //JWT


}
