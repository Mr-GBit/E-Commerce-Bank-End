package com.backend.ECommerce.controller;

import com.backend.ECommerce.model.customerEntity;
import com.backend.ECommerce.service.customerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/customer")
public class customerController {
    private final customerService customerService;
    @Autowired
    public customerController(customerService customerService) {
        this.customerService = customerService;
    }
    // Basic fundamentals of GET,POST,DELETE
    @GetMapping (path = "/getCustomer")
    public ResponseEntity<List<customerEntity>> getAllCustomer(){
        return new ResponseEntity<>(customerService.getAllCustomer(), HttpStatus.OK);
    }
    @GetMapping (path = "{customerId}")
    public ResponseEntity<Optional<customerEntity>> getCustomer(@PathVariable("customerId") BigInteger customerId){
        return new ResponseEntity<>(customerService.getCustomer(customerId),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<customerEntity> registerCustomer(@RequestBody customerEntity customerEntity){
        customerEntity customer = customerService.addCustomer(customerEntity);
        return new ResponseEntity<>(customer,HttpStatus.CREATED);
    }
    @DeleteMapping(path = "{customerId}")
    public ResponseEntity<BigInteger> deleteCustomer (@PathVariable ("customerId")BigInteger customerId){
        return new ResponseEntity<>(customerService.deleteCustomer(customerId),HttpStatus.GONE);
    }

}
