package com.smartTrainApp.TrainApp.repository;

import com.smartTrainApp.TrainApp.entity.TrainStation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TrainStationRepository extends JpaRepository<TrainStation, Long> {

    List<TrainStation> findByTrainIdOrderByStopOrder(Long trainId);
}