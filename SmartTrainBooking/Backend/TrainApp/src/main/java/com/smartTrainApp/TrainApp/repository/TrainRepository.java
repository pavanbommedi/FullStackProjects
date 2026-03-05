package com.smartTrainApp.TrainApp.repository;

import com.smartTrainApp.TrainApp.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TrainRepository extends JpaRepository<Train, Long> {

    Optional<Train> findByTrainNumber(String trainNumber);
}