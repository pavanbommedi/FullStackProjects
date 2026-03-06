package com.smartTrainApp.TrainApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smartTrainApp.TrainApp.entity.Booking;
import com.smartTrainApp.TrainApp.entity.Payment;
import com.smartTrainApp.TrainApp.service.PaymentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping("/pay")
    public boolean makePayment(@RequestParam Booking booking, @RequestParam Double fare){
        return paymentService.processPayment(booking, fare);
    }

    @GetMapping("/refund")
    public void refundPayment(@RequestParam Payment payment){
        paymentService.refundPayment(payment);
    }

}
