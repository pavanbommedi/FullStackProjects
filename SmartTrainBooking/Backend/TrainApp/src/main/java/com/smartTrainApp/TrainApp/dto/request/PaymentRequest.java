package com.smartTrainApp.TrainApp.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PaymentRequest {
     @NotNull(message = "booking id is required")
    private Long bookingId;

    private double amount;
}