package com.smartTrainApp.TrainApp.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TrainResponseDTO {

    private Long id;

    private String trainNumber;

    private String trainName;

    private int totalSeats;

    private int availableSeats;
}