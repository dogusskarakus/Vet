package dev.patika.Veteriner.dto.request.doctor;

public record DoctorRequest(

        String name,
        String phone,
        String mail,
        String address,
        String city
) {
}
