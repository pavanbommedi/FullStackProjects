package com.smartTrainApp.TrainApp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smartTrainApp.TrainApp.dto.response.TrainResponseDTO;
import com.smartTrainApp.TrainApp.entity.Train;
import com.smartTrainApp.TrainApp.service.TrainService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/trains")
@RequiredArgsConstructor
public class TrainController {

    private final TrainService trainService;

    @PostMapping
    public TrainResponseDTO addTrain(@RequestBody Train train){
        return trainService.addTrain(train);
    }

    @GetMapping("/search")
    //http://localhost:8080/trains/search?source=HYD&destination=BLR
    public List<TrainResponseDTO> searchTrains(@RequestParam String source, @RequestParam String destination){
        return trainService.searchTrains(source, destination);
    }

    @GetMapping("/{id}")
    public TrainResponseDTO getTrainById(@PathVariable Long id){
        return trainService.getTrainDetails(id);
    }





}
