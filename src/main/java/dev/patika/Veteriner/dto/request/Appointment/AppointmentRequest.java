package dev.patika.Veteriner.dto.request.Appointment;

import dev.patika.Veteriner.entity.Animal;
import dev.patika.Veteriner.entity.Doctor;

import java.time.LocalDateTime;

public record AppointmentRequest
        (LocalDateTime appointmentDate,
         Animal animal,
         Doctor doctor) {
}
