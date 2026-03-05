package com.smartTrainApp.TrainApp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.smartTrainApp.TrainApp.entity.Train;
import com.smartTrainApp.TrainApp.repository.TrainRepository;
import com.smartTrainApp.TrainApp.service.TrainService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TrainServiceImpl implements TrainService {

    private final TrainRepository trainRepository;

    public Train addTrain(Train train) {

        train.setAvailableSeats(train.getTotalSeats());
        return trainRepository.save(train);
    }

    public List<Train> searchTrains(String source,String destination){

        return trainRepository.findTrainsBetweenStations(source,destination);
    }

    public Train getTrainDetails(Long Train_id){
        return trainRepository.findById(Train_id).orElseThrow(()->new RuntimeException("Train Not Found"));
    }





}
