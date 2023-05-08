package org.example.homework_19.service;

import jakarta.persistence.TypedQuery;
import org.example.homework_19.hibernate_util.HibernateUtil;
import org.example.homework_19.pojo_classes.Trip;
import org.example.homework_19.repository.TripPer;
import org.hibernate.Session;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class TripSer implements TripPer {

    @Override
    public Trip getById(int id) {
        Session session = HibernateUtil.getSession().openSession();
        session.beginTransaction();
        Trip trip = session.get(Trip.class, id);
        session.getTransaction().commit();
        session.close();
        return trip;
    }

    @Override
    public Set<Trip> getAll() {
        Session session = HibernateUtil.getSession().openSession();
        TypedQuery<Trip> query = session.createQuery("from Trip", Trip.class);
        session.beginTransaction();
        Set<Trip> tripList = new LinkedHashSet<>(query.getResultList());
        session.getTransaction().commit();
        session.close();
        return tripList;
    }

    @Override
    public Set<Trip> get(int offset, int perPage, String sort) {
        Session session = HibernateUtil.getSession().openSession();
        String jpqlQuery = "SELECT p FROM Trip p WHERE p.id >= :offset ORDER BY p." + sort;
        session.beginTransaction();
        TypedQuery<Trip> typedQuery = session.createQuery(jpqlQuery,Trip.class);
        typedQuery.setParameter("offset", offset);
        typedQuery.setMaxResults(perPage);
        Set<Trip> passengersList = new LinkedHashSet<>(typedQuery.getResultList());
        session.getTransaction().commit();
        session.close();
        return passengersList;
    }

    @Override
    public Trip save(Trip passenger) {
        Session session = HibernateUtil.getSession().openSession();
        session.beginTransaction();
        session.persist(passenger);
        session.getTransaction().commit();
        session.close();
        return null;
    }

    @Override
    public Trip update(Trip passenger) {
        return null;
    }

    @Override
    public void delete(int passengerId) {

    }

    @Override
    public List<Trip> getTripsFrom(String city) {
        return null;
    }

    @Override
    public List<Trip> getTripsTo(String city) {
        return null;
    }
}
