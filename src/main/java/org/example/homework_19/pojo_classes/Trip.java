package org.example.homework_19.pojo_classes;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@Entity
@Table(name = "trip")
public class Trip {
    @Id
    private int trip_number;

    @OneToMany
    private List<Company> company;

    @Column(nullable = false, name = "airplane")
    private String airplane;

    @Column(nullable = false, name = "town_from")
    private String town_from;

    @Column(nullable = false, name = "town_to")
    private String town_to;

    @Column(nullable = false, name = "time_out")
    private String time_out;

    @Column(nullable = false, name = "time_in")
    private String time_in;

}
