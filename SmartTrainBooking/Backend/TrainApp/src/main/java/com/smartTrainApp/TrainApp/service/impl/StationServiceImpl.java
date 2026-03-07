package com.smartTrainApp.TrainApp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.smartTrainApp.TrainApp.dto.response.StationResponseDTO;
import com.smartTrainApp.TrainApp.entity.Station;
import com.smartTrainApp.TrainApp.mapper.StationMapper;
import com.smartTrainApp.TrainApp.repository.StationRepository;
import com.smartTrainApp.TrainApp.service.StationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StationServiceImpl implements StationService {

    private final StationRepository stationRepository;
    private StationMapper stationMapper;

    public StationResponseDTO createStation(Station station){
        stationRepository.save(station);
        return stationMapper.toDto(station);
    }

    public List<StationResponseDTO> getAllStations(){
        List<Station> stations = stationRepository.findAll();
        return stationMapper.toDtoList(stations);
    }

    public StationResponseDTO getStationByCode(String code){
        Station station = stationRepository.findByCode(code).orElseThrow(
            ()->new RuntimeException("No station found with the code")
        );
        return stationMapper.toDto(station);
    }



}
