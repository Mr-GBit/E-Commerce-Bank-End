package com.backend.ECommerce.repository;

import com.backend.ECommerce.model.customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
@Repository
public interface customerRepository extends JpaRepository<customer, BigInteger> {
}
