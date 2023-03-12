package com.backend.ECommerce.service;

import com.backend.ECommerce.model.productEntity;
import com.backend.ECommerce.repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

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
        Optional<productEntity> findByProductName = productRepository.findByProductName(product.getProductName());
        if(findByProductName.isPresent()){
            throw new IllegalStateException("This Product Name " + product.getProductName() + " is Taken");
        }
        product.setProductCode(UUID.randomUUID().toString()); // generate UUID as Temp productCode
        productRepository.save(product);
        return product;
    }
    public productEntity updateProduct(BigInteger productId, productEntity productEntity) {
        productEntity product = productRepository.findById(productId).orElseThrow(()-> new IllegalStateException("This Product ID: " + productId + "Does not Exist"));
        if(productEntity.getProductName() != null && productEntity.getProductName().length() > 0) {
            product.setProductName(productEntity.getProductName());
        }
        if(productEntity.getDescription() != null && productEntity.getDescription().length() > 0) {
            product.setDescription(productEntity.getDescription());
        }
        if(productEntity.getPrice() != null) {
            product.setPrice(productEntity.getPrice());
        }
        if(productEntity.getQuantity() !=0) {
            product.setQuantity(productEntity.getQuantity());
        }
        return productEntity;
    }
    public BigInteger deleteProduct(BigInteger productId) {
        if(!productRepository.existsById(productId)){
            throw new IllegalStateException("This Product ID " + productId + " does not exist");
        }
        productRepository.deleteById(productId);
        return productId;
    }
}
