package dev.patika.Veteriner.dto.request.Vaccine;

import dev.patika.Veteriner.entity.Animal;

import java.time.LocalDate;

public record VaccineRequest(
        String name,
        String code,
        LocalDate protectionStartDate,
        LocalDate protectionFinishDate,
        Animal animal
) {
}
