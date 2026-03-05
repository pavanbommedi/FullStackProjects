package com.smartTrainApp.TrainApp.repository;

import com.smartTrainApp.TrainApp.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route, Long> {
}