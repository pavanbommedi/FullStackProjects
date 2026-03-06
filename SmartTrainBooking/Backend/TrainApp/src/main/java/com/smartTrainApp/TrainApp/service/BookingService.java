package com.smartTrainApp.TrainApp.service;

// import java.time.LocalDate;

import com.smartTrainApp.TrainApp.dto.BookingRequest;
import com.smartTrainApp.TrainApp.entity.Booking;

public interface BookingService {

    // Booking createBooking(Long userId,Long trainId,int seatCount,Long sourceStationIdLong
    //     , Long destinationStationId, LocalDate bookingDate);

    Booking createBooking(BookingRequest booking); //Using DTO here

    Booking cancelBooking(Long bookingId);

    Booking getBookingDetails(Long bookingId);



}
