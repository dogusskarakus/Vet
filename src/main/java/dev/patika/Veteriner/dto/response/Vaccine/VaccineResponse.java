package dev.patika.Veteriner.dto.response.Vaccine;


import dev.patika.Veteriner.entity.Animal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;


public record VaccineResponse(
        Long id,
        String name,
        String code,
        LocalDate protectionStartDate,
        LocalDate protectionFinishDate,
        Animal animal,
        LocalDateTime createdAt,
        LocalDateTime createdBy
) {



}
