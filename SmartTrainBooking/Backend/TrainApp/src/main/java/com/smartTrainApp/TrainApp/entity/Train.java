package com.smartTrainApp.TrainApp.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "trains")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "train_number", nullable = false, unique = true)
    private String trainNumber;

    @Column(name = "train_name", nullable = false)
    private String trainName;

    @Column(name = "total_seats", nullable = false)
    private Integer totalSeats;

    @OneToMany(mappedBy = "train", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TrainStation> trainStations;

    @OneToMany(mappedBy = "train", fetch = FetchType.LAZY)
    private List<Booking> bookings;

    @Column(name = "available_seats", nullable = false)
    private Integer availableSeats;
}


