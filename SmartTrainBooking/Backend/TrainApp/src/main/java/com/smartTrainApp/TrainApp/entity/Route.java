package com.smartTrainApp.TrainApp.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "routes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "source_station_id", nullable = false)
    private Station sourceStation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "destination_station_id", nullable = false)
    private Station destinationStation;

    @Column(nullable = false)
    private Integer distance;

    @Column(name = "travel_time", nullable = false)
    private Integer travelTime;

    
}

// Why LAZY?

// If you fetch 100 routes,
// you don’t want 100 station objects loaded automatically.

// Lazy improves performance.
