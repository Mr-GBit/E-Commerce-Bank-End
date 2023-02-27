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

    public List<customerEntity> getCustomer() {
        return customerRepository.findAll();
    }

    public void addCustomer(customerEntity customer) {
        Optional<customerEntity> findByEmail = customerRepository.findByEmail(customer.getEmail());
        if(findByEmail.isPresent()){
            throw new IllegalStateException("EMAIL TAKEN :(");
        }
        customerRepository.save(customer);
    }

    public void deleteCustomer(BigInteger customerId) {
        boolean exit = customerRepository.existsById(customerId);
        if (!exit){
            throw  new IllegalStateException("customer with id "+ customerId +" does not exist");
        }
        customerRepository.deleteById(customerId);
    }
}
