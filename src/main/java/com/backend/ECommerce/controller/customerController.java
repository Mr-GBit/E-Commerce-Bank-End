package com.backend.ECommerce.controller;

import com.backend.ECommerce.model.customer;
import com.backend.ECommerce.service.customerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(path = "/customer")
public class customerController {
    private customerService customerService;
    @Autowired
    public customerController(customerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping (path = "/getCustomer")
    public List<customer> getCustomer(){
        return customerService.getCustomer();
    }
}
