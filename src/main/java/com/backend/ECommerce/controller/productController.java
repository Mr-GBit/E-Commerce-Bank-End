package com.backend.ECommerce.controller;
import com.backend.ECommerce.model.productEntity;
import com.backend.ECommerce.service.productService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/product")
@AllArgsConstructor
public class productController{
    private final productService productService;

    @GetMapping(path = "/getAllProduct")
    private ResponseEntity<List<productEntity>> getAllProduct(){
        return new ResponseEntity<>(productService.getAllProduct(),HttpStatus.OK);
    }
    @GetMapping(path = "{productId}")
    private ResponseEntity<Optional<productEntity>> getProduct(@PathVariable ("productId") BigInteger productId){
        return new ResponseEntity<>(productService.getProduct(productId),HttpStatus.OK);
    }
    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    private ResponseEntity<productEntity> addNewProduct(@RequestBody productEntity productEntity , @RequestPart("photoImage")MultipartFile multipartFile){
        return new ResponseEntity<>(productService.addProduct(productEntity,multipartFile),HttpStatus.CREATED);
    }
    @PutMapping(path = "{productId}")
    private ResponseEntity<productEntity> updateProduct (@PathVariable ("productId") BigInteger productId, @RequestBody productEntity product){
        return new ResponseEntity<>(productService.updateProduct(productId,product),HttpStatus.OK);
    }
    @DeleteMapping(path = "{productId}")
    public ResponseEntity<BigInteger> deleteCustomer (@PathVariable ("productId")BigInteger productId){
        return new ResponseEntity<>(productService.deleteProduct(productId),HttpStatus.GONE);
    }
}
