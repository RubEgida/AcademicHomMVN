package org.example.homework_19.mapping;

import org.example.homework_19.hibernate_util.HibernateUtil;
import org.example.homework_19.pojo_classes.*;
import org.example.homework_19.service.CompanySer;
import org.example.homework_19.service.PassengerSer;
import org.example.homework_19.service.TripSer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.io.*;
import java.sql.Date;
import java.util.Calendar;

public class Input {
    private static final CompanySer COMPANY_SER = new CompanySer();
    private static final PassengerSer PASSENGER_SER = new PassengerSer();
    private static final TripSer TRIP_SER = new TripSer();

    private static void addressInput() throws IOException {
        Session session = HibernateUtil.getSession().openSession();
        Transaction transaction = session.beginTransaction();

        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\HP\\IdeaProjects" +
                                                                            "\\HomeworksJavaAcademic" +
                                                                            "\\src\\main\\resources" +
                                                                            "\\txt_files\\passengers.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            Address address = new Address();
            address.setCountry(parts[2]);
            address.setCity(parts[3]);

            session.persist(address);
        }

        transaction.commit();
        session.close();
    }

    private static void passengerInput() throws IOException {
        Session session = HibernateUtil.getSession().openSession();
        Transaction transaction = session.beginTransaction();

        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\HP\\IdeaProjects" +
                                                                            "\\HomeworksJavaAcademic" +
                                                                            "\\src\\main\\resources" +
                                                                            "\\txt_files\\passengers.txt"));
        String line;
        int id = 1;
        while ((line = reader.readLine()) != null) {
            Address address = session.get(Address.class, id);
            String[] parts = line.split(",");
            Passenger passenger = new Passenger();
            passenger.setPassenger_name(parts[0]);
            passenger.setPassenger_phone(parts[1]);
            passenger.setAddress(address);

            session.persist(passenger);
            id++;
        }

        transaction.commit();
        session.close();
    }

    private static void companyInput() throws IOException {
        Session session = HibernateUtil.getSession().openSession();
        Transaction transaction = session.beginTransaction();

        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\HP\\IdeaProjects" +
                                                                            "\\HomeworksJavaAcademic" +
                                                                            "\\src\\main\\resources" +
                                                                            "\\txt_files\\companies.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            Company company = new Company();
            company.setCompany_name(parts[0]);
            Calendar calendar = Calendar.getInstance();
            parts = parts[1].split("/");
            int[] nums = {Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2])};
            calendar.set(nums[2], nums[0]-1, nums[1]);
            company.setFounding_date(new Date(calendar.getTime().getTime()));

            session.persist(company);
        }

        transaction.commit();
        session.close();
    }

    private static void tripInput() throws IOException {
        Session session = HibernateUtil.getSession().openSession();
        Transaction transaction = session.beginTransaction();

        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\HP\\IdeaProjects" +
                "\\HomeworksJavaAcademic" +
                "\\src\\main\\resources" +
                "\\txt_files\\trip.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            Trip company = new Trip();
            int a = Integer.decode(parts[0]);
            company.setTrip_number(a);
            company.setCompany(COMPANY_SER.getById(Integer.decode(parts[1])));
            company.setAirplane(parts[2]);
            company.setTown_from(parts[3]);
            company.setTown_to(parts[4]);
            company.setTime_out(parts[5]);
            company.setTime_in(parts[6]);
            session.persist(company);
        }

        transaction.commit();
        session.close();
    }

    private static void pass_in_tripInput() throws IOException {
        Session session = HibernateUtil.getSession().openSession();
        Transaction transaction = session.beginTransaction();

        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\HP\\IdeaProjects" +
                "\\HomeworksJavaAcademic" +
                "\\src\\main\\resources" +
                "\\txt_files\\pass_in_trip.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            PassInTrip company = new PassInTrip();
            company.setTrip_id(TRIP_SER.getById(Integer.parseInt(parts[0])));
            company.setPsg_id(PASSENGER_SER.getById(Integer.parseInt(parts[1])));
            company.setDate(parts[2]);
            company.setPlace(parts[3]);
            session.persist(company);
        }

        transaction.commit();
        session.close();
    }

    public static void main(String[] args) throws IOException {
        addressInput();
        passengerInput();
        companyInput();
        tripInput();
        pass_in_tripInput();
    }
}
