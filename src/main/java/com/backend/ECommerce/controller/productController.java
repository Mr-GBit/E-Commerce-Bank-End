package com.backend.ECommerce.controller;

import com.backend.ECommerce.model.productEntity;
import com.backend.ECommerce.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping(path = "/product")
public class productController {
    private final productService productService;
    @Autowired
    public productController(productService productService) {
        this.productService = productService;
    }
    @GetMapping(path = "/getAllProduct")
    public List<productEntity> getAllProduct(){
        return productService.getAllProduct();
    }
    @GetMapping(path = "{productId}")
    public void getProduct(@PathVariable ("productId") BigInteger productId){
        productService.getProduct(productId);
    }
}
