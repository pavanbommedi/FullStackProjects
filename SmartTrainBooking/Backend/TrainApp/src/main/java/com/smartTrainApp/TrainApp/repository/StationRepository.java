package com.smartTrainApp.TrainApp.repository;

import com.smartTrainApp.TrainApp.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface StationRepository extends JpaRepository<Station, Long> {

    Optional<Station> findByCode(String code);
}