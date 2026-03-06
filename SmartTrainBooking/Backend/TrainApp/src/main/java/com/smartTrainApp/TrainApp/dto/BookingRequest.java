package com.smartTrainApp.TrainApp.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class BookingRequest {

    private Long userId;
    private Long trainId;
    private Long sourceStationId;
    private Long destinationStationId;
    private int seats;
    private LocalDate bookingDate;

}
