package com.smartTrainApp.TrainApp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartTrainApp.TrainApp.entity.Station;
import com.smartTrainApp.TrainApp.service.StationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/stations")
@RequiredArgsConstructor
public class StationController {

    private final StationService stationService;

    @PostMapping
    public Station createStation(@RequestBody Station station){
        return stationService.createStation(station);
    }

    @GetMapping
    public List<Station> getAllStations(){
        return stationService.getAllStations();
    }

    @GetMapping("/{code}")
    public Station getStationByCode(@PathVariable String code){
        return stationService.getStationByCode(code);
    }
}
