package com.smartTrainApp.TrainApp.service.impl;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.smartTrainApp.TrainApp.entity.Booking;
import com.smartTrainApp.TrainApp.entity.Station;
import com.smartTrainApp.TrainApp.entity.Train;
import com.smartTrainApp.TrainApp.entity.User;
import com.smartTrainApp.TrainApp.repository.BookingRepository;
import com.smartTrainApp.TrainApp.repository.StationRepository;
import com.smartTrainApp.TrainApp.repository.TrainRepository;
import com.smartTrainApp.TrainApp.repository.UserRepository;
import com.smartTrainApp.TrainApp.service.BookingService;
import com.smartTrainApp.TrainApp.service.BookingStatus;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService{

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final TrainRepository trainRepository;
    private final SeatAvailabilityServiceImpl seatAvailabilityServiceImpl;
    private final StationRepository stationRepository;

    @Transactional
    public Booking createBooking(Long userId,Long trainId , int seatCount, Long sourceStationId
        , Long destinationStationId, LocalDate bookingDate){
        User user = userRepository.findById(userId).orElseThrow(
            ()-> new RuntimeException("user not founc")
        );

        Train train = trainRepository.findById(trainId).orElseThrow(
            ()->new RuntimeException("Train not found")
        );

        if(sourceStationId.equals(destinationStationId)){
            throw new RuntimeException("Source and destination are same");
        }

        Station sourceStation = stationRepository.findById(sourceStationId).orElseThrow(
            () -> new RuntimeException("Source station not founc")
        );

        Station destinationStation = stationRepository.findById(destinationStationId).orElseThrow(
            () -> new RuntimeException("destination station not founc")
        );
        
        if (train.getAvailableSeats() < seatCount) {
            throw new RuntimeException("Not enough seats available");
        }

          // Validate Date
        if (bookingDate.isBefore(LocalDate.now())) {
            throw new RuntimeException("Booking date cannot be in the past");
        }

        // Create Booking (PENDING)
        Booking booking = Booking.builder()
                .user(user)
                .train(train)
                .sourceStation(sourceStation)
                .destinationStation(destinationStation)
                .bookingDate(bookingDate)
                .seatCount(seatCount)
                .status(BookingStatus.PENDING).build();

        bookingRepository.save(booking);

        //lock the seats
        seatAvailabilityServiceImpl.lockSeats(trainId,seatCount);

        //ProcessPayment
        boolean paymentSucces = paymentService.processPayment(seatCount*100);

        if(!paymentSucces){
            seatAvailabilityServiceImpl.releaseSeats(trainId, seatCount);
            booking.setStatus(BookingStatus.FAILED);
            throw new RuntimeException("Payment failed");
        }

        booking.setStatus(BookingStatus.CONFIRMED);

    }

    @Transactional
    public Booking cancelBooking(Long bookingId){
        Booking booking = bookingRepository.findById(bookingId).orElseThrow(
            ()-> new RuntimeException("No booking found")
        );
         if (!"CONFIRMED".equals(booking.getStatus())) {
            throw new RuntimeException("Only confirmed bookings can be cancelled");
        }
        //release seats
        seatAvailabilityServiceImpl.releaseSeats(booking.getTrain().getId(), booking.getSeatCount());

        booking.setStatus(BookingStatus.CANCELLED);

        return booking;
    }

    public Booking getBookingDetails(Long bookingId){
         return bookingRepository.findById(bookingId).orElseThrow(
            ()->new RuntimeException("Booking not found")
         );
    }

}
