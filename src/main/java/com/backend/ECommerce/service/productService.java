package com.backend.ECommerce.service;

import com.backend.ECommerce.model.productEntity;
import com.backend.ECommerce.repository.productRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.math.BigInteger;
import java.sql.Blob;
import java.util.Base64;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class productService {
    private final productRepository productRepository;

    public List<productEntity> getAllProduct() {
        return productRepository.findAll();
    }
    public Optional<productEntity> getProduct(BigInteger productId) {
        if(!productRepository.existsById(productId)){
            throw new IllegalStateException("This " + productId + " Doesn't exit");
        }
       return productRepository.findById(productId);
    }
    public productEntity addProduct(productEntity product, MultipartFile multipartFile) {
        Optional<productEntity> findByProductName = productRepository.findByProductName(product.getProductName());
        Blob blob;
        if(findByProductName.isPresent()){
            throw new IllegalStateException("This Product Name " + product.getProductName() + " is Taken");
        }
        try {
            byte [] productFile = Base64.getEncoder().encode(multipartFile.getBytes());
            blob = new SerialBlob(productFile);
            product.setProductPhoto(blob);
        } catch (Exception e) {
            log.error(String.valueOf(e));
        }
        product.setProductCode(UUID.randomUUID().toString()); // generate UUID as Temp productCode
        productRepository.save(product);
        return product;
    }
    public productEntity updateProduct(BigInteger productId, productEntity productEntity, MultipartFile multipartFile) {
        productEntity product = productRepository.findById(productId).orElseThrow(()-> new IllegalStateException("This Product ID: " + productId + "Does not Exist"));
        Blob blob;
        if(productEntity.getProductName() != null &&
                productEntity.getProductName().length() > 0 &&
                !Objects.equals(product.getProductName(),productEntity.getProductName())){
            product.setProductName(productEntity.getProductName());
        }
        if(productEntity.getDescription() != null &&
                productEntity.getDescription().length() > 0 &&
                !Objects.equals(product.getDescription(),productEntity.getDescription())){
            product.setDescription(productEntity.getDescription());
        }
        if(productEntity.getPrice() != null &&
                !Objects.equals(product.getPrice(),productEntity.getPrice())){
            product.setPrice(productEntity.getPrice());
        }
        if(productEntity.getQuantity() != 0 &&
                !Objects.equals(product.getQuantity(),productEntity.getQuantity())){
            product.setQuantity(productEntity.getQuantity());
        }
        if(productEntity.getProductPhoto() !=null &&
                !Objects.equals(product.getProductPhoto(),productEntity.getProductPhoto())){
            try {
                byte [] productFile = Base64.getEncoder().encode(multipartFile.getBytes());
                blob = new SerialBlob(productFile);
                product.setProductPhoto(blob);
            } catch (Exception e) {
                log.error(String.valueOf(e));
            }
        }
        productRepository.save(product);
        return product;
    }
    public BigInteger deleteProduct(BigInteger productId) {
        if(!productRepository.existsById(productId)){
            throw new IllegalStateException("This Product ID " + productId + " does not exist");
        }
        productRepository.deleteById(productId);
        return productId;
    }
}
