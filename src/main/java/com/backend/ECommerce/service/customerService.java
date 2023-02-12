package com.backend.ECommerce.service;

import com.backend.ECommerce.model.customer;
import com.backend.ECommerce.repository.customerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class customerService {
    private customerRepository customerRepository;

    public customerService(customerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<customer> getCustomer() {
        return customerRepository.findAll();
    }
}
