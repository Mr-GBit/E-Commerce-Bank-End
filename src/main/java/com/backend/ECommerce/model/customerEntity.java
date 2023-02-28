package com.backend.ECommerce.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@Table (name = "customer_tbl" ,
        uniqueConstraints={@UniqueConstraint(columnNames={"email"})})
public class customerEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private BigInteger id;
    @Column (name = "first_name", nullable = false)
    private String first_name;
    @Column (name = "middle_name")
    private String middle_name;
    @Column(name = "last_name",nullable = false)
    private String last_name;
    @Column (name = "email",nullable = false)
    private String email;
    @Column (name = "password",nullable = false)
    private String password;
    @Column (name = "birth_date")
    private LocalDate birth_date;
    @Column(name = "created_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Timestamp created_datetime;
    @Column (name = "modified_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Timestamp modified_datetime;
    @Column (name = "status")
    private String status;
}
