package com.backend.ECommerce.repository;

import com.backend.ECommerce.model.productEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface productRepository extends JpaRepository <productEntity, BigInteger> {
    Optional<productEntity> findByProductName (String productName);
}
