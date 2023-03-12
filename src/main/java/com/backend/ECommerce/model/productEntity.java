package com.backend.ECommerce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Clob;

@Entity
@Getter
@Setter
@ToString
@Table (name = "product_tbl")
public class productEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private BigInteger id;
    @Column (name = "product_code")
    private String productCode;
    @Column (name = "product_name")
    private String productName;
    @Column (name = "description")
    private String description;
    @Column ( name = "size")
    private String size;
    @Column ( name = "quantity")
    private int quantity;
    @Column ( name = "Category")
    private String category;
    @Column (name = "price")
    private BigDecimal price;
//    @Column (name = "product_photo")
//    private Clob productPhoto;
    @Column (name = "status")
    private String status;

}
