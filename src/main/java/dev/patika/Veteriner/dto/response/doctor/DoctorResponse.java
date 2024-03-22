package dev.patika.Veteriner.dto.response.doctor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


public record DoctorResponse(
        Long id,
        String name,
        String phone,
        String mail,
        String address,
        String city,
        LocalDateTime createdA,
        LocalDateTime updatedAt
) {
}
