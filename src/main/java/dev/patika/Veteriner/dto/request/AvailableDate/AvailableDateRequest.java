package dev.patika.Veteriner.dto.request.AvailableDate;

import dev.patika.Veteriner.entity.Doctor;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record AvailableDateRequest(
        LocalDate availableDate,
        Doctor doctor
) {
}
