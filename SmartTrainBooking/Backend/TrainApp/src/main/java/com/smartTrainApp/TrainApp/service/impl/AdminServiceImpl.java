package com.smartTrainApp.TrainApp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.smartTrainApp.TrainApp.dto.response.BookingResponseDTO;
import com.smartTrainApp.TrainApp.dto.response.TrainResponseDTO;
import com.smartTrainApp.TrainApp.entity.Booking;
import com.smartTrainApp.TrainApp.entity.Train;
import com.smartTrainApp.TrainApp.mapper.BookingMapper;
import com.smartTrainApp.TrainApp.mapper.TrainMapper;
import com.smartTrainApp.TrainApp.repository.BookingRepository;
import com.smartTrainApp.TrainApp.repository.TrainRepository;
import com.smartTrainApp.TrainApp.service.AdminService;
import com.smartTrainApp.TrainApp.service.BookingStatus;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final TrainRepository trainRepository;
    private final BookingRepository bookingRepository ;

    private final TrainMapper trainMapper;
    private final BookingMapper bookingMapper;
    
    public TrainResponseDTO addTrain(Train train){

        trainRepository.save(train);
        return trainMapper.toDTO(train);


        
    }

    public void removeTrain(Long trainId){
        Train train = trainRepository.findById(trainId).orElseThrow(
            ()->new RuntimeException("Train not found")
        );
        trainRepository.delete(train);
    }

    public List<BookingResponseDTO> getAllBookings(){
        List<Booking> bookings =  bookingRepository.findAll();
        return bookingMapper.toDTOList(bookings);
        
    }
    @Transactional
    public void cancelTrain(Long trainId){
        // Train train = trainRepository.findById(trainId).orElseThrow(
        //     ()->new RuntimeException("Train not found")
        // );

        List<Booking> bookings = bookingRepository.findByTrainId(trainId);

        for(Booking booking : bookings) booking.setStatus(BookingStatus.CANCELLED);

        //Refund Amount


    }



}
