package org.example.homework_19.pojo_classes;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "passenger")
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int passenger_id;

    @Column(nullable = false, name = "passenger_name")
    private String passenger_name;

    @Column(nullable = false, name = "passenger_phone")
    private String passenger_phone;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

}
