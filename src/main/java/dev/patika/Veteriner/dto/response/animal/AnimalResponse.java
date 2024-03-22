package dev.patika.Veteriner.dto.response.animal;


import dev.patika.Veteriner.entity.Customer;
import dev.patika.Veteriner.entity.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record AnimalResponse(

        Long id,
        String name,
        String species,
        String breed,
        String colour,
        Gender gender,

        LocalDate dateOfBirth,
        Customer customer,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}