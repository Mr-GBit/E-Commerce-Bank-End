package com.backend.ECommerce.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Table (name = "customer_tbl")
public class customer {
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
    @Column (name = "birth_date")
    private LocalDate birth_date;
    @Column(name = "created_date_time")
    @CreationTimestamp
    private Timestamp created_datetime;
    @Column (name = "modified_date_time")
    @UpdateTimestamp
    private Timestamp modified_datetime;
    @Column (name = "status")
    private String status;
    public customer(){

    }
    public customer(BigInteger id) {
        this.id = id;
    }

    public customer(String first_name, String middle_name, String last_name, String email, LocalDate birth_date, String status) {
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.email = email;
        this.birth_date = birth_date;
        this.status = status;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(LocalDate birth_date) {
        this.birth_date = birth_date;
    }

    public Timestamp getCreated_datetime() {
        return created_datetime;
    }

    public void setCreated_datetime(Timestamp created_datetime) {
        this.created_datetime = created_datetime;
    }

    public Timestamp getModified_datetime() {
        return modified_datetime;
    }

    public void setModified_datetime(Timestamp modified_datetime) {
        this.modified_datetime = modified_datetime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "customer{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", middle_name='" + middle_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", birth_date=" + birth_date +
                ", created_datetime=" + created_datetime +
                ", modified_datetime=" + modified_datetime +
                ", status='" + status + '\'' +
                '}';
    }
}
