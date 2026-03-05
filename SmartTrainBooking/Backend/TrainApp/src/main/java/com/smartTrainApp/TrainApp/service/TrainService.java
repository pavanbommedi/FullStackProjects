package com.smartTrainApp.TrainApp.service;

import java.util.List;

import com.smartTrainApp.TrainApp.entity.Train;

public interface TrainService {

    Train addTrain(Train train);

    List<Train> searchTrains(String source,String destination);

    Train getTrainDetails(Long train_id);

}
