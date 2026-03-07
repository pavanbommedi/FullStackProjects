package com.smartTrainApp.TrainApp.service.impl;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.smartTrainApp.TrainApp.dto.BookingRequest;
import com.smartTrainApp.TrainApp.dto.response.BookingResponseDTO;
import com.smartTrainApp.TrainApp.entity.Booking;
import com.smartTrainApp.TrainApp.entity.Station;
import com.smartTrainApp.TrainApp.entity.Train;
import com.smartTrainApp.TrainApp.entity.User;
import com.smartTrainApp.TrainApp.mapper.BookingMapper;
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
    private final PaymentServiceImpl paymentServiceImpl;
    private final BookingMapper bookingMapper;

    @Transactional
    // public Booking createBooking(Long userId,Long trainId , int seatCount, Long sourceStationId
    //     , Long destinationStationId, LocalDate bookingDate)
    public BookingResponseDTO createBooking(BookingRequest request){

    Long userId = request.getUserId();
    Long trainId = request.getTrainId();
    Long sourceStationId = request.getSourceStationId();
    Long destinationStationId = request.getDestinationStationId();
    int seatCount = request.getSeats();
    LocalDate bookingDate = request.getBookingDate();

    User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));

    Train train = trainRepository.findById(trainId)
            .orElseThrow(() -> new RuntimeException("Train not found"));

    if(sourceStationId.equals(destinationStationId)){
        throw new RuntimeException("Source and destination cannot be same");
    }

    Station sourceStation = stationRepository.findById(sourceStationId)
            .orElseThrow(() -> new RuntimeException("Source station not found"));

    Station destinationStation = stationRepository.findById(destinationStationId)
            .orElseThrow(() -> new RuntimeException("Destination station not found"));

    if(train.getAvailableSeats() < seatCount){
        throw new RuntimeException("Not enough seats available");
    }

    if(bookingDate.isBefore(LocalDate.now())){
        throw new RuntimeException("Booking date cannot be in the past");
    }

    // Convert DTO → Entity
    Booking booking = bookingMapper.toEntity(request);

    booking.setUser(user);
    booking.setTrain(train);
    booking.setSourceStation(sourceStation);
    booking.setDestinationStation(destinationStation);
    booking.setStatus(BookingStatus.PENDING);

    bookingRepository.save(booking);

    // Lock seats
    seatAvailabilityServiceImpl.lockSeats(trainId, seatCount);

    // Payment
    boolean paymentSuccess = paymentServiceImpl.processPayment(booking, seatCount * 100.10);

    if(!paymentSuccess){
        seatAvailabilityServiceImpl.releaseSeats(trainId, seatCount);
        booking.setStatus(BookingStatus.FAILED);
        bookingRepository.save(booking);
        throw new RuntimeException("Payment failed");
    }

    booking.setStatus(BookingStatus.CONFIRMED);

    bookingRepository.save(booking);

    // Convert Entity → Response DTO
    return bookingMapper.toDTO(booking);
}

    @Transactional
    public BookingResponseDTO cancelBooking(Long bookingId){
        Booking booking = bookingRepository.findById(bookingId).orElseThrow(
            ()-> new RuntimeException("No booking found")
        );
         if (!"CONFIRMED".equals(booking.getStatus())) {
            throw new RuntimeException("Only confirmed bookings can be cancelled");
        }
        //release seats
        seatAvailabilityServiceImpl.releaseSeats(booking.getTrain().getId(), booking.getSeatCount());

        booking.setStatus(BookingStatus.CANCELLED);

        return bookingMapper.toDTO(booking);
    }

    public BookingResponseDTO getBookingDetails(Long bookingId){
         Booking booking =  bookingRepository.findById(bookingId).orElseThrow(
            ()->new RuntimeException("Booking not found")
         );

         return bookingMapper.toDTO(booking);
    }

}
