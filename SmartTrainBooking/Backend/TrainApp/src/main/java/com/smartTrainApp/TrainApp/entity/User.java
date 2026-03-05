package com.smartTrainApp.TrainApp.entity;
import com.smartTrainApp.TrainApp.entity.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity //Marks this class as a JPA Entity.
@Table(name = "users") //Specifies the database table name. 
//If you don’t use @Table, JPA uses the class name as table name by default.
@Getter //Automatically generates getters for all fields.
@Setter //Automatically generates setters.
@NoArgsConstructor //Generates a default constructor.
// JPA requires a no-argument constructor.
// Without this, Hibernate will fail.
@Builder //Enables the Builder Pattern.
@AllArgsConstructor //Generates a constructor with all fields as parameters.


public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;
    
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

     // One user can have many bookings
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Booking> bookings;

     @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // @GeneratedValue(strategy = IDENTITY) → Auto-increment

    // @Enumerated(EnumType.STRING) → Store "USER" instead of 0/1

    // @OneToMany(mappedBy="user") → Booking owns the relationship

    // FetchType.LAZY → Don’t load bookings unless needed

    // @PrePersist → Automatically sets created time
}
