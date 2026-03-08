package com.smartTrainApp.TrainApp.dto.request;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BookingRequest {

    @NotNull(message = "Train id is required")
    private Long trainId;

    @NotNull(message = "Source station is required")
    private Long sourceStationId;

    @NotNull(message = "Destination station is required")
    private Long destinationStationId;

    @NotNull(message = "Booking date is required")
    @FutureOrPresent(message = "Booking date cannot be in the past")
    private LocalDate bookingDate;

    @Min(value = 1, message = "At least 1 seat must be booked")
    private Integer seatCount;
}