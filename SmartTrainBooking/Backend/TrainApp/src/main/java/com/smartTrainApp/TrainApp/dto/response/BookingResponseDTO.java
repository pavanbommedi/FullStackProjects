package com.smartTrainApp.TrainApp.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookingResponseDTO {

    private Long bookingId;

    private String trainName;

    private String sourceStation;

    private String destinationStation;

    private int seatsBooked;

    private String bookingStatus;
}