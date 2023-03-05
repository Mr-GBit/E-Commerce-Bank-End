package com.backend.ECommerce.repository.dto;

import com.backend.ECommerce.model.customerEntity;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class customerDTOMapper implements Function<customerEntity,customerDTO> {
    @Override
    public customerDTO apply(customerEntity customerEntity) {
        return new customerDTO(
                customerEntity.getId(),
                customerEntity.getFirst_name(),
                customerEntity.getMiddle_name(),
                customerEntity.getLast_name(),
                customerEntity.getEmail(),
                customerEntity.getBirth_date(),
                customerEntity.getGender(),
                customerEntity.getStatus()
        );
        // this get all except for password and created and modified date time
    }
}
