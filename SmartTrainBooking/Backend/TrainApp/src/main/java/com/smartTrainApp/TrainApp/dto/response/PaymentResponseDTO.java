package com.smartTrainApp.TrainApp.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentResponseDTO {

    private Long paymentId;

    private double amount;

    private String status;

}