package com.smartTrainApp.TrainApp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.smartTrainApp.TrainApp.entity.Station;
import com.smartTrainApp.TrainApp.repository.StationRepository;
import com.smartTrainApp.TrainApp.service.StationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StationServiceImpl implements StationService {

    private final StationRepository stationRepository;

    public Station createStation(Station station){
        return stationRepository.save(station);
    }

    public List<Station> getAllStations(){
        return stationRepository.findAll();
    }

    public Station getStationByCode(String code){
        return stationRepository.findByCode(code).orElseThrow(
            ()->new RuntimeException("No station found with the code")
        );
    }



}
