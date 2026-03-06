package com.smartTrainApp.TrainApp.service;

import java.util.List;

import com.smartTrainApp.TrainApp.entity.Booking;
import com.smartTrainApp.TrainApp.entity.Train;

public interface AdminService {
    Train addTrain(Train train);
    void removeTrain(Long trainId);
    List<Booking> getAllBookings();
    void cancelTrain(Long trainId);
}
