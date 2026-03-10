// package com.smartTrainApp.TrainApp.service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;

// import com.smartTrainApp.TrainApp.entity.User;
// import com.smartTrainApp.TrainApp.repository.UserRepository;
// import com.smartTrainApp.TrainApp.service.impl.CustomUserDetails;

// @Service
// public class CustomUserDetailsService 
//         implements org.springframework.security.core.userdetails.UserDetailsService {

//     @Autowired
//     private UserRepository repo;

//     @Override
//     public UserDetails loadUserByUsername(String username)
//             throws UsernameNotFoundException {

//         User user = repo.findByUsername(username)
//                 .orElseThrow(() ->
//                         new UsernameNotFoundException("User not found"));

//         return new CustomUserDetails(user);
//     }
// }