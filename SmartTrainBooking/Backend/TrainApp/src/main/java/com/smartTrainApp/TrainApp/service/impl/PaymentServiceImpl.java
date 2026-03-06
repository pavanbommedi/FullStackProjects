package com.smartTrainApp.TrainApp.service.impl;

import org.springframework.stereotype.Service;

import com.smartTrainApp.TrainApp.entity.Booking;
import com.smartTrainApp.TrainApp.entity.Payment;
import com.smartTrainApp.TrainApp.entity.enums.BookingStatus;
import com.smartTrainApp.TrainApp.repository.PaymentRepository;
import com.smartTrainApp.TrainApp.service.PaymentService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService{

    private final PaymentRepository paymentRepository;

    public boolean processPayment(Booking booking, Double amount){

        Payment payment = new Payment();

        payment.setAmount(amount);
        payment.setBooking(booking);
        payment.setStatus(BookingStatus.SUCCESS); //simulate Payment

        paymentRepository.save(payment);

        return true;



    }

    public void refundPayment(Payment payment){
        payment.setStatus(BookingStatus.REFUNDED);

        paymentRepository.save(payment);
    }

}
