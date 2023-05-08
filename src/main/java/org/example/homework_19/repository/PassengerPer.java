package org.example.homework_19.repository;

import org.example.homework_19.pojo_classes.Passenger;
import org.example.homework_19.pojo_classes.Trip;

import java.util.List;

public interface PassengerPer extends GeneralPer<Passenger>{
    List<Passenger> getPassengersOfTrip(long tripNumber);
    void registerTrip(Trip trip, Passenger passenger);
    void cancelTrip(long passengerId, long tripNumber);

}
