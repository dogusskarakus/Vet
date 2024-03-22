package dev.patika.Veteriner.Mapper;

import dev.patika.Veteriner.dto.request.doctor.DoctorRequest;
import dev.patika.Veteriner.dto.response.doctor.DoctorResponse;
import dev.patika.Veteriner.entity.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;
@Mapper
public interface DoctorMapper {

    Doctor asEntity(DoctorRequest request);
    DoctorResponse asResponse(Doctor doctor);
    void update(@MappingTarget Doctor doctor, DoctorRequest request);
    List<DoctorResponse> asResponseList(List<Doctor> doctorList);
}
