package com.smartTrainApp.TrainApp.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import org.springframework.util.RouteMatcher.Route;

@Entity
@Table(name = "stations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Station {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "station_name", nullable = false)
    private String stationName;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false, unique = true)
    private String code;

    // Routes where this station is source
    @OneToMany(mappedBy = "sourceStation", fetch = FetchType.LAZY)
    private List<Route> sourceRoutes;

    // Routes where this station is destination
    @OneToMany(mappedBy = "destinationStation", fetch = FetchType.LAZY)
    private List<Route> destinationRoutes;

    // Train mapping
    @OneToMany(mappedBy = "station", fetch = FetchType.LAZY)
    private List<TrainStation> trainStations;

}

// Route has 2 foreign keys pointing to Station

// We need 2 mappedBy references