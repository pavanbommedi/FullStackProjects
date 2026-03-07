package com.smartTrainApp.TrainApp.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.smartTrainApp.TrainApp.dto.BookingRequest;
import com.smartTrainApp.TrainApp.dto.response.BookingResponseDTO;
import com.smartTrainApp.TrainApp.entity.Booking;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookingMapper {

    @Mapping(source = "id", target = "bookingId")
    @Mapping(source = "train.trainName", target = "trainName")
    @Mapping(source = "sourceStation.code", target = "sourceStation")
    @Mapping(source = "destinationStation.code", target = "destinationStation")
    @Mapping(source = "seatCount", target = "seatsBooked")
    @Mapping(source = "status", target = "bookingStatus")
    BookingResponseDTO toDTO(Booking booking);

    List<BookingResponseDTO> toDTOList(List<Booking> bookings);

    Booking toEntity(BookingRequest request);
}
