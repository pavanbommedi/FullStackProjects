package com.smartTrainApp.TrainApp.service;

import java.util.List;

import com.smartTrainApp.TrainApp.dto.response.BookingResponseDTO;
import com.smartTrainApp.TrainApp.dto.response.TrainResponseDTO;
import com.smartTrainApp.TrainApp.entity.Train;

public interface AdminService {
    TrainResponseDTO addTrain(Train train);
    void removeTrain(Long trainId);
    List<BookingResponseDTO> getAllBookings();
    void cancelTrain(Long trainId);
}
