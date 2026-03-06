package com.smartTrainApp.TrainApp.service;

import com.smartTrainApp.TrainApp.entity.Booking;
import com.smartTrainApp.TrainApp.entity.Payment;

public interface PaymentService {

    static boolean processPayment(Booking booking , double amount) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'processPayment'");
    }

    void refundPayment(Payment payment);

}
