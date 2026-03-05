package com.smartTrainApp.TrainApp.repository;

import com.smartTrainApp.TrainApp.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TrainRepository extends JpaRepository<Train, Long> {

    Optional<Train> findByTrainNumber(String trainNumber);

    //JPQL --See Notes.md for more details
    @Query("""
       SELECT DISTINCT t FROM Train t
       JOIN t.trainStations ts1
       JOIN t.trainStations ts2
       WHERE ts1.station.code = :source
       AND ts2.station.code = :destination
       AND ts1.stopOrder < ts2.stopOrder
       """)
List<Train> findTrainsBetweenStations(
        @Param("source") String source,
        @Param("destination") String destination
);
}