package org.example.homework_19.pojo_classes;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@Data
@NoArgsConstructor
@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int company_id;

    @Column(nullable = false, name = "company_name")
    private String company_name;

    @Column(nullable = false, name = "founding_date")
    private Date founding_date;

}
