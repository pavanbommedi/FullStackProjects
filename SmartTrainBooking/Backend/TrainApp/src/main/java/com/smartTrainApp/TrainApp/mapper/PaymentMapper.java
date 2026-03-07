package com.smartTrainApp.TrainApp.mapper;

import com.smartTrainApp.TrainApp.dto.response.PaymentResponseDTO;
import com.smartTrainApp.TrainApp.entity.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    @Mapping(source = "id",target = "paymentId")
    PaymentResponseDTO toDTO(Payment payment);
}