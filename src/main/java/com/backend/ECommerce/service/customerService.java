package com.backend.ECommerce.service;

import com.backend.ECommerce.model.customerEntity;
import com.backend.ECommerce.repository.customerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class customerService {
    private final customerRepository customerRepository;

    public List<customerEntity> getAllCustomer() {
        return customerRepository.findAll();
    }

    public customerEntity addCustomer(customerEntity customer) {
        Optional<customerEntity> findByEmail = customerRepository.findByEmail(customer.getEmail());
        if(findByEmail.isPresent()){
            throw new NoSuchElementException("EMAIL TAKEN :(");
        }
        customerRepository.save(customer);
        return customer;
    }

    public BigInteger deleteCustomer(BigInteger customerId) {
        if (customerRepository.existsById(customerId)){
            throw  new NoSuchElementException("customer with id "+ customerId +" does not exist");
        }
        customerRepository.deleteById(customerId);
        return customerId;
    }

    public Optional<customerEntity> getCustomer(BigInteger customerId) {
        if(!customerRepository.existsById(customerId)){
            throw new NoSuchElementException("This Customer ID " + customerId + "Does not exist");
        }
        return customerRepository.findById(customerId);
    }

    public customerEntity updateCustomer(BigInteger customerId, customerEntity customerEntity) {
        customerEntity customer = customerRepository.findById(customerId).orElseThrow(() -> new IllegalStateException("This customer Id" + customerId + "doest not exist"));
        // Adding DTO
        return customer;
    }
}
