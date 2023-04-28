package org.example.homework_19.pojo_classes;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int address_id;
    @Column(nullable = false, name = "country")
    private String country;
    @Column(nullable = false, name = "city")
    private String city;

}
