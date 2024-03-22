package dev.patika.Veteriner.dto.request.animal;

import dev.patika.Veteriner.entity.Customer;
import dev.patika.Veteriner.entity.Gender;

import java.time.LocalDate;

public record AnimalRequest(
        String name,
        String species,
        String breed,
        String colour,
        Gender gender,
        LocalDate dateOfBirth,
        Customer customer

) {
}