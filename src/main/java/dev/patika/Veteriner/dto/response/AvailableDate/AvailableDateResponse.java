package dev.patika.Veteriner.dto.response.AvailableDate;

import dev.patika.Veteriner.entity.Doctor;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record AvailableDateResponse(

        Long id,
        LocalDate availableDate,
        Doctor doctor,
        LocalDateTime createdAt,
        LocalDateTime updatedAt

) {
}
