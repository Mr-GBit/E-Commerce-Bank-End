package com.backend.ECommerce.controller;

import com.backend.ECommerce.model.productEntity;
import com.backend.ECommerce.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/product")
public class productController {
    private final productService productService;
    @Autowired
    private productController(productService productService) {
        this.productService = productService;
    }
    @GetMapping(path = "/getAllProduct")
    private ResponseEntity<List<productEntity>> getAllProduct(){
        return new ResponseEntity<>(productService.getAllProduct(),HttpStatus.OK);
    }
    @GetMapping(path = "{productId}")
    private ResponseEntity<Optional<productEntity>> getProduct(@PathVariable ("productId") BigInteger productId){
        return new ResponseEntity<>(productService.getProduct(productId),HttpStatus.OK);
    }
    @PostMapping
    private ResponseEntity<productEntity> addNewProduct(@RequestBody productEntity productEntity){
        return new ResponseEntity<>(productService.addProduct(productEntity),HttpStatus.CREATED);
    }
}
