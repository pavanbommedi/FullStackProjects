package com.smartTrainApp.TrainApp.repository;

import com.smartTrainApp.TrainApp.entity.Station;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface StationRepository extends JpaRepository<Station, Long> {

    Optional<Station> findByCode(String code);


// Yes. It will work automatically.

// You do NOT need to write JPQL or SQL.

// Spring Data JPA will generate the query automatically based on the method name.

// What Spring Does Internally

// When Spring Boot starts, Spring Data JPA reads the method name:

// findByCode

// It splits it like this:

// findBy + Code

// Spring checks your entity field:

// private String code;

// Then it automatically generates query like:

// SELECT * FROM station WHERE code = ?
}
