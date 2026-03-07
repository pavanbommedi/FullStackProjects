package com.smartTrainApp.TrainApp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.smartTrainApp.TrainApp.dto.response.TrainResponseDTO;
import com.smartTrainApp.TrainApp.entity.Train;
import com.smartTrainApp.TrainApp.mapper.TrainMapper;
import com.smartTrainApp.TrainApp.repository.TrainRepository;
import com.smartTrainApp.TrainApp.service.TrainService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TrainServiceImpl implements TrainService {

    private final TrainRepository trainRepository;
    private final TrainMapper trainMapper;

    public TrainResponseDTO addTrain(Train train) {

        train.setAvailableSeats(train.getTotalSeats());
        trainRepository.save(train);

        return trainMapper.toDTO(train);
    }

    public List<TrainResponseDTO> searchTrains(String source,String destination){

        List<Train> trains = trainRepository.findTrainsBetweenStations(source,destination);

        return trainMapper.toDTOList(trains);
    }

    public TrainResponseDTO getTrainDetails(Long Train_id){
        Train train = trainRepository.findById(Train_id).orElseThrow(
            ()->new RuntimeException("Train Not Found"));
        return trainMapper.toDTO(train);
    }





}
