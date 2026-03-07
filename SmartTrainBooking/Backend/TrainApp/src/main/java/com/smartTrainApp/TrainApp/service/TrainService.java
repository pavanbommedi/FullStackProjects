package com.smartTrainApp.TrainApp.service;

import java.util.List;

import com.smartTrainApp.TrainApp.dto.response.TrainResponseDTO;
import com.smartTrainApp.TrainApp.entity.Train;

public interface TrainService {

    TrainResponseDTO addTrain(Train train);

    List<TrainResponseDTO> searchTrains(String source,String destination);

    TrainResponseDTO getTrainDetails(Long train_id);

}
