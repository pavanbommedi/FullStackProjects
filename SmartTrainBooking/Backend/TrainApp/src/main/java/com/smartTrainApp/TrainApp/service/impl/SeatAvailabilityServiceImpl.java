package com.smartTrainApp.TrainApp.service.impl;

import org.springframework.stereotype.Service;

import com.smartTrainApp.TrainApp.entity.Train;
import com.smartTrainApp.TrainApp.exception.CustomExceptions.ResourceNotFoundException;
import com.smartTrainApp.TrainApp.exception.CustomExceptions.UnAvailableSeatsException;
import com.smartTrainApp.TrainApp.repository.TrainRepository;
import com.smartTrainApp.TrainApp.service.SeatAvailabilityService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SeatAvailabilityServiceImpl implements SeatAvailabilityService {

    private final TrainRepository trainRepository;

    public boolean checkAvailability(Long train_id,int seatCount){
        Train train = trainRepository.findById(train_id).orElseThrow(
                ()->new ResourceNotFoundException("Train not found "+train_id));

        int availableSeats = train.getAvailableSeats();
        if(availableSeats<seatCount) throw new UnAvailableSeatsException("Seats not available");

        return availableSeats>=seatCount;
    }

     @Transactional
    public void lockSeats(Long trainId, int seatCount) {

        Train train = trainRepository.findById(trainId)
                .orElseThrow(() -> new ResourceNotFoundException("Train not found "+trainId));

        if (train.getAvailableSeats() < seatCount) {
            throw new UnAvailableSeatsException("Seats not available");
        }

        train.setAvailableSeats(
                train.getAvailableSeats() - seatCount
        );
    }

     @Transactional
    public void releaseSeats(Long trainId, int seatCount) {

        Train train = trainRepository.findById(trainId)
                .orElseThrow(() -> new ResourceNotFoundException("Train not found "+trainId));

       

        train.setAvailableSeats(
                train.getAvailableSeats() + seatCount
        );
    }

}
