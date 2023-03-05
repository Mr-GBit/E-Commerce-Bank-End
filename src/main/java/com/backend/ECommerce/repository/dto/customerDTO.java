package com.backend.ECommerce.repository.dto;

import java.math.BigInteger;
import java.time.LocalDate;

public record customerDTO (
        BigInteger id,
        String first_name,
        String middle_name,
        String last_name,
        String email,
        LocalDate birth_date,
        String gender,
        String status
){

}
