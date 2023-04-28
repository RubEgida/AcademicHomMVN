package org.example.homework_19.pojo_classes;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@Data
@NoArgsConstructor
@Entity
@Table(name = "pass_in_trip")
public class PassInTrip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pass_in_trip_id;

    @OneToMany
    private List<Trip> trip_id;

    @OneToMany
    private List<Passenger> psg_id;

    @Column(nullable = false, name = "date")
    private Date date;

    @Column(nullable = false, name = "place")
    private String place;

}
