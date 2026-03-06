package com.smartTrainApp.TrainApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartTrainApp.TrainApp.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment , Long> {

}
