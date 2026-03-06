package com.smartTrainApp.TrainApp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartTrainApp.TrainApp.entity.Booking;
import com.smartTrainApp.TrainApp.entity.Station;
import com.smartTrainApp.TrainApp.entity.Train;
import com.smartTrainApp.TrainApp.service.AdminService;
import com.smartTrainApp.TrainApp.service.StationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final StationService stationService;
    private final AdminService adminService;


    @PostMapping("/train")
    public Train addTrain(@RequestBody Train train) {
        return adminService.addTrain(train);
    }

    @PostMapping("/station")
    public Station addStation(@RequestBody Station station) {
        return stationService.createStation(station);
    }

    @DeleteMapping("/train/{trainId}")
    public void removeTrain(@PathVariable Long trainId){
        adminService.removeTrain(trainId);
    }

    @GetMapping("/bookings")
    public List<Booking> getAllBookings(){
        return adminService.getAllBookings();
    }

    @GetMapping("/train/{trainId}/cancel")
    public void cancelTrain(Long trainId){
        adminService.cancelTrain(trainId);
    }




}