package com.smartTrainApp.TrainApp;

// import java.time.LocalDateTime;

// import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.Bean;

// import com.smartTrainApp.TrainApp.entity.User;
// import com.smartTrainApp.TrainApp.entity.enums.Role;
// import com.smartTrainApp.TrainApp.repository.UserRepository;

@SpringBootApplication
public class TrainAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainAppApplication.class, args);
	}
//CommandLineRunner for testing Repositories
// 	@Bean
// public CommandLineRunner testRepository(UserRepository userRepository) {
//     return args -> {

//        User user = User.builder()
//         .name("Admin")
//         .email("admin@gmail.com")
//         .password("admin123") 
//         .role(Role.ADMIN)
//         .createdAt(LocalDateTime.now())
//         .build();

//         userRepository.save(user);

//         System.out.println("User saved successfully!");

//         userRepository.findAll().forEach(System.out::println);
//     };
}

