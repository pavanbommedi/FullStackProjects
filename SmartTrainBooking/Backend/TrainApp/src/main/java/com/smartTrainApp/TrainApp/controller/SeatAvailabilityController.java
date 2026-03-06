package com.smartTrainApp.TrainApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smartTrainApp.TrainApp.service.SeatAvailabilityService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/seats")
@RequiredArgsConstructor
public class SeatAvailabilityController {

    private final SeatAvailabilityService seatAvailabilityService;

    @GetMapping("/check")
    public boolean checkAvailability(@RequestParam Long trainId,@RequestParam int seatCount){
        return seatAvailabilityService.checkAvailability(trainId, seatCount);
    }

    @GetMapping("/lock")
    public void lockSeats(@RequestParam Long trainId,@RequestParam int seatCount){
        seatAvailabilityService.lockSeats(trainId, seatCount);
    }

    @GetMapping("relase")
    public void releaseSeats(@RequestParam Long trainId,@RequestParam int seatCount){
        seatAvailabilityService.releaseSeats(trainId, seatCount);
    }

}
