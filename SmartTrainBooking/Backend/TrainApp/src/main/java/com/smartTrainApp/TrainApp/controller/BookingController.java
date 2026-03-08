package com.smartTrainApp.TrainApp.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartTrainApp.TrainApp.dto.BookingRequest;
import com.smartTrainApp.TrainApp.dto.response.BookingResponseDTO;
import com.smartTrainApp.TrainApp.service.BookingService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public BookingResponseDTO createBooking(@Valid @RequestBody BookingRequest request){  //Using DTO here
        return bookingService.createBooking(request);
    }

    @DeleteMapping("/cancel/{bookind_id}")
    public BookingResponseDTO cancelBooking(@PathVariable @Min(value = 1, message = "Invalid booking id") Long bookingId){
        return bookingService.cancelBooking(bookingId);
    }

    @GetMapping("/{booking_id}")
    public BookingResponseDTO getBookingDetails(@PathVariable @Min(value = 1, message = "Invalid booking id") Long bookingId){
        return bookingService.getBookingDetails(bookingId);
    }


}
