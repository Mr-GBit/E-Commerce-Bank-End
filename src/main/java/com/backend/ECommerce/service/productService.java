package com.backend.ECommerce.service;

import com.backend.ECommerce.model.productEntity;
import com.backend.ECommerce.repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class productService {
    private final productRepository productRepository;
    @Autowired
    public productService(productRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<productEntity> getAllProduct() {
        return productRepository.findAll();
    }
    public Optional<productEntity> getProduct(BigInteger productId) {
        if(!productRepository.existsById(productId)){
            throw new IllegalStateException("This " + productId + " Doesn't exit");
        }
       return productRepository.findById(productId);
    }
    public productEntity addProduct(productEntity product) {
        Optional<productEntity> findbyProductName = productRepository.findByProductName(product.getProductName());
        if(findbyProductName.isPresent()){
            throw new IllegalStateException("This Product Name " + product.getProductName() + " is Taken");
        }
        productRepository.save(product);
        return product;
    }
}
