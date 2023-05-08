package org.example.homework_19.service;

import jakarta.persistence.TypedQuery;
import org.example.homework_19.hibernate_util.HibernateUtil;
import org.example.homework_19.pojo_classes.Company;
import org.example.homework_19.repository.CompanyPer;
import org.hibernate.Session;
import java.util.LinkedHashSet;
import java.util.Set;

public class CompanySer implements CompanyPer {
    @Override
    public Company getById(int id) {
        Session session = HibernateUtil.getSession().openSession();
        session.beginTransaction();
        Company company = session.get(Company.class, id);
        session.getTransaction().commit();
        session.close();
        return company;
    }

    @Override
    public Set<Company> getAll() {
        Session session = HibernateUtil.getSession().openSession();
        TypedQuery<Company> query = session.createQuery("from Company", Company.class);
        session.beginTransaction();
        Set<Company> companyList = new LinkedHashSet<>(query.getResultList());
        session.getTransaction().commit();
        session.close();
        return companyList;
    }

    @Override
    public Set<Company> get(int offset, int perPage, String sort) {
        Session session = HibernateUtil.getSession().openSession();
        String jpqlQuery = "SELECT p FROM Company p WHERE p.id >= :offset ORDER BY p." + sort;
        session.beginTransaction();
        TypedQuery<Company> typedQuery = session.createQuery(jpqlQuery,Company.class);
        typedQuery.setParameter("offset", offset);
        typedQuery.setMaxResults(perPage);
        Set<Company> passengersList = new LinkedHashSet<>(typedQuery.getResultList());
        session.getTransaction().commit();
        session.close();
        return passengersList;
    }

    @Override
    public Company save(Company passenger) {
        Session session = HibernateUtil.getSession().openSession();
        session.beginTransaction();
        session.persist(passenger);
        session.getTransaction().commit();
        session.close();
        return null;
    }

    @Override
    public Company update(Company passenger) {
        return null;
    }

    @Override
    public void delete(int passengerId) {

    }
}
