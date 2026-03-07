package com.smartTrainApp.TrainApp.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StationResponseDTO {

    private Long id;

    private String name;

    private String code;

    private String city;
}