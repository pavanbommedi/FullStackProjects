package com.smartTrainApp.TrainApp.service;

public interface SeatAvailabilityService {

    boolean checkAvailability(Long train_id,int seatCount);

    void lockSeats(Long train_id,int seatCount);

    void releaseSeats(Long train_id,int seatCount);

}
