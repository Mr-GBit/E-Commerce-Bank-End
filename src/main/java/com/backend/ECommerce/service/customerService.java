package com.backend.ECommerce.service;

import com.backend.ECommerce.model.customerEntity;
import com.backend.ECommerce.repository.customerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class customerService {
    private final customerRepository customerRepository;
    @Autowired
    public customerService(customerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<customerEntity> getAllCustomer() {
        return customerRepository.findAll();
    }

    public customerEntity addCustomer(customerEntity customer) {
        Optional<customerEntity> findByEmail = customerRepository.findByEmail(customer.getEmail());
        if(findByEmail.isPresent()){
            throw new IllegalStateException("EMAIL TAKEN :(");
        }
        customerRepository.save(customer);
        return customer;
    }

    public BigInteger deleteCustomer(BigInteger customerId) {
        if (customerRepository.existsById(customerId)){
            throw  new IllegalStateException("customer with id "+ customerId +" does not exist");
        }
        customerRepository.deleteById(customerId);
        return customerId;
    }

    public Optional<customerEntity> getCustomer(BigInteger customerId) {
        if(!customerRepository.existsById(customerId)){
            throw new IllegalStateException("This Customer ID " + customerId + "Does not exist");
        }
        return customerRepository.findById(customerId);
    }
}
