package com.smartTrainApp.TrainApp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartTrainApp.TrainApp.dto.response.StationResponseDTO;
import com.smartTrainApp.TrainApp.entity.Station;
import com.smartTrainApp.TrainApp.service.StationService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/stations")
@RequiredArgsConstructor
public class StationController {

    private final StationService stationService;

    @PostMapping
    public StationResponseDTO createStation(@Valid @RequestBody Station station){
        return stationService.createStation(station);
    }

    @GetMapping
    public List<StationResponseDTO> getAllStations(){
        return stationService.getAllStations();
    }

    @GetMapping("/{code}")
    public StationResponseDTO getStationByCode(@PathVariable @Min(value = 1, message = "Invalid code") String code){
        return stationService.getStationByCode(code);
    }
}
