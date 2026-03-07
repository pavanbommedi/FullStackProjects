package com.smartTrainApp.TrainApp.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.smartTrainApp.TrainApp.dto.response.StationResponseDTO;
import com.smartTrainApp.TrainApp.entity.Station;

@Mapper(componentModel = "spring")
public interface StationMapper {
    @Mapping(source = "stationName",target = "name" )
    StationResponseDTO toDto(Station station);
    List<StationResponseDTO> toDtoList(List<Station> stations);

}
