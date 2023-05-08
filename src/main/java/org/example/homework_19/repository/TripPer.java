package org.example.homework_19.repository;

import org.example.homework_19.pojo_classes.Trip;

import java.util.List;

public interface TripPer extends GeneralPer<Trip>{
    List<Trip> getTripsFrom(String city);
    List<Trip> getTripsTo(String city);


}
