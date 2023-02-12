package com.backend.ECommerce;

import com.backend.ECommerce.model.customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.backend.ECommerce.repository.customerRepository;

import java.time.LocalDate;
import java.time.Month;

@Configuration
public class config {

    @Bean
    CommandLineRunner commandLineRunner (customerRepository customerRepository){
        return args -> {
           customer cus1 =  new customer("fName","","lName","email@email.com", LocalDate.of(2000, Month.JANUARY,5),"ACTIVE");
            customerRepository.save(cus1);
        };
    }
}
