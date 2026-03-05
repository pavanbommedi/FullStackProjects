package com.smartTrainApp.TrainApp.repository;
import com.smartTrainApp.TrainApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long>{
    Optional<User> findByEmail(String email);


}

//Optional is used to avoid NullPointerException and to explicitly
//  handle cases where the entity may not exist
//  in the database. It makes the API safer and more expressive.