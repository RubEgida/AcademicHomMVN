package org.example.homework_19.pojo_classes;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "pass_in_trip")
public class PassInTrip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pass_in_trip_id;

    @ManyToOne
    private Trip trip_id;

    @ManyToOne
    private Passenger psg_id;

    @Column(nullable = false, name = "date")
    private String date;

    @Column(nullable = false, name = "place")
    private String place;

}
