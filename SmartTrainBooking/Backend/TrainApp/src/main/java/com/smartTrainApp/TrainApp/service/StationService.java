package com.smartTrainApp.TrainApp.service;

import java.util.List;

import com.smartTrainApp.TrainApp.dto.response.StationResponseDTO;
import com.smartTrainApp.TrainApp.entity.Station;

public interface StationService {

    StationResponseDTO createStation(Station station);

    List<StationResponseDTO> getAllStations();

    StationResponseDTO getStationByCode(String code);

}
