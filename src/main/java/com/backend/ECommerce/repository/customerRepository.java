package com.backend.ECommerce.repository;

import com.backend.ECommerce.model.customerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface customerRepository extends JpaRepository<customerEntity, BigInteger> {
    Optional<customerEntity> findByEmail(String email);
}
