package dev.patika.Veteriner.dto.response.Appointment;

import dev.patika.Veteriner.entity.Animal;
import dev.patika.Veteriner.entity.Doctor;

import java.time.LocalDateTime;

public record AppointmentResponse(
        Long id,
        LocalDateTime appointmentDate,
        Animal animal,
        Doctor doctor,
        LocalDateTime createdAt,
        LocalDateTime updateAt
) {
}
