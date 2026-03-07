package com.smartTrainApp.TrainApp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.smartTrainApp.TrainApp.dto.request.RegisterUserRequest;
import com.smartTrainApp.TrainApp.dto.response.UserResponseDTO;
import com.smartTrainApp.TrainApp.entity.User;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {


    User toEntity(RegisterUserRequest request);

    UserResponseDTO toDto(User user);
}