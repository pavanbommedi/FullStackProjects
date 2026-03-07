package com.smartTrainApp.TrainApp.mapper;

import com.smartTrainApp.TrainApp.dto.response.TrainResponseDTO;
import com.smartTrainApp.TrainApp.entity.Train;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TrainMapper {

    TrainResponseDTO toDTO(Train train);

    List<TrainResponseDTO> toDTOList(List<Train> trains);
}