package org.example.homework_19.mapping;

import org.example.homework_19.hibernate_util.HibernateUtil;
import org.example.homework_19.pojo_classes.Address;
import org.example.homework_19.pojo_classes.Passenger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.*;

public class Input {
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
    public static void main(String[] args) throws IOException {
        addressInput();
        passengerInput();
    }
}
