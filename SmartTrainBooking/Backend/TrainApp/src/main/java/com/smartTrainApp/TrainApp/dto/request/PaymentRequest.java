package com.smartTrainApp.TrainApp.dto.request;

import lombok.Data;

@Data
public class PaymentRequest {

    private Long bookingId;

    private double amount;
}