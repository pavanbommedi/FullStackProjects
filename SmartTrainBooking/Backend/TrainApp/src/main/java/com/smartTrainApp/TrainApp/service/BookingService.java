package com.smartTrainApp.TrainApp.service;

// import java.time.LocalDate;

import com.smartTrainApp.TrainApp.dto.BookingRequest;
import com.smartTrainApp.TrainApp.dto.response.BookingResponseDTO;

public interface BookingService {

    // Booking createBooking(Long userId,Long trainId,int seatCount,Long sourceStationIdLong
    //     , Long destinationStationId, LocalDate bookingDate);

    BookingResponseDTO createBooking(BookingRequest booking); //Using DTO here

    BookingResponseDTO cancelBooking(Long bookingId);

    BookingResponseDTO getBookingDetails(Long bookingId);



}
