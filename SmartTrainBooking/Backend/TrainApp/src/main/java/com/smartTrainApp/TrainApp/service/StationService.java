package com.smartTrainApp.TrainApp.service;

import java.util.List;

import com.smartTrainApp.TrainApp.entity.Station;

public interface StationService {

    Station createStation(Station station);

    List<Station> getAllStations();

    Station getStationByCode(String code);

}
