package dev.patika.Veteriner.dto.response.customer;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


public record CustomerResponse(
        Long id,
        String name,

        String phone,
        String mail,
        String address,
        String city,
        LocalDateTime createdAt,
        LocalDateTime createdBy) {


}
