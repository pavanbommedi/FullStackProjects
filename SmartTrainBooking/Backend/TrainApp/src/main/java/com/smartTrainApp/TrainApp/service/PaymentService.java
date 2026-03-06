package com.smartTrainApp.TrainApp.service;

import com.smartTrainApp.TrainApp.entity.Booking;
import com.smartTrainApp.TrainApp.entity.Payment;

public interface PaymentService {
    boolean processPayment(Booking booking, Double amount);

    void refundPayment(Payment payment);

}
