package com.smartTrainApp.TrainApp.dto.request;

import java.time.LocalDate;

import lombok.Data;
@Data
public class BookingRequest {

    private Long userId;
    private Long trainId;
    private Long sourceStationId;
    private Long destinationStationId;
    private int seats;
    private LocalDate bookingDate;

}
