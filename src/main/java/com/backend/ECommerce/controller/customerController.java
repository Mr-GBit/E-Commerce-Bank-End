package com.backend.ECommerce.controller;

import com.backend.ECommerce.model.customerEntity;
import com.backend.ECommerce.service.customerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping(path = "/customer")
public class customerController {
    private final customerService customerService;
    @Autowired
    public customerController(customerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping (path = "/getCustomer")
    public List<customerEntity> getCustomer(){
        return customerService.getCustomer();
    }
    @PostMapping
    public void registerCustomer(@RequestBody customerEntity customerEntity){
        customerService.addCustomer(customerEntity);
    }
    @DeleteMapping(path = "{customerId}")
    public void deleteCustomer (@PathVariable ("customerId")BigInteger customerId){
        customerService.deleteCustomer(customerId);
    }
}
