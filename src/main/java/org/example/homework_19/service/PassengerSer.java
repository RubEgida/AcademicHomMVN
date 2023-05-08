package org.example.homework_19.service;

import jakarta.persistence.TypedQuery;
import org.example.homework_19.hibernate_util.HibernateUtil;
import org.example.homework_19.pojo_classes.Address;
import org.example.homework_19.pojo_classes.Passenger;
import org.example.homework_19.pojo_classes.Trip;
import org.example.homework_19.repository.PassengerPer;
import org.hibernate.Session;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class PassengerSer implements PassengerPer {
    @Override
    public Passenger getById(int id) {
        Session session = HibernateUtil.getSession().openSession();
        session.beginTransaction();
        Passenger passenger = session.get(Passenger.class, id);
        session.getTransaction().commit();
        session.close();
        return passenger;
    }

    @Override
    public Set<Passenger> getAll() {
        Session session = HibernateUtil.getSession().openSession();
        TypedQuery<Passenger> query = session.createQuery("from Passenger", Passenger.class);
        session.beginTransaction();
        Set<Passenger> passengersList = new LinkedHashSet<>(query.getResultList());
        session.getTransaction().commit();
        session.close();
        return passengersList;
    }

    @Override
    public Set<Passenger> get(int offset, int perPage, String sort) {
        Session session = HibernateUtil.getSession().openSession();
        String jpqlQuery = "SELECT p FROM Passenger p WHERE p.id >= :offset ORDER BY p." + sort;
        session.beginTransaction();
        TypedQuery<Passenger> typedQuery = session.createQuery(jpqlQuery,Passenger.class);
        typedQuery.setParameter("offset", offset);
        typedQuery.setMaxResults(perPage);
        Set<Passenger> passengersList = new LinkedHashSet<>(typedQuery.getResultList());
        session.getTransaction().commit();
        session.close();
        return passengersList;
    }

    @Override
    public Passenger save(Passenger passenger) {
        Session session = HibernateUtil.getSession().openSession();
        session.beginTransaction();
        passenger.setAddress(session.get(Address.class, passenger.getAddress().getAddress_id()));
        session.persist(passenger);
        session.getTransaction().commit();
        session.close();
        return passenger;
    }

    @Override
    public Passenger update(Passenger passenger) {
        return null;
    }

    @Override
    public void delete(int passengerId) {
        Session session = HibernateUtil.getSession().openSession();
        session.beginTransaction();
        session.remove(getById(passengerId));
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Passenger> getPassengersOfTrip(long tripNumber) {
        return null;
    }

    @Override
    public void registerTrip(Trip trip, Passenger passenger) {

    }

    @Override
    public void cancelTrip(long passengerId, long tripNumber) {

    }
}
