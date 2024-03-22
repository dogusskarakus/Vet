package dev.patika.Veteriner.Mapper;

import dev.patika.Veteriner.dto.request.Appointment.AppointmentRequest;
import dev.patika.Veteriner.dto.response.Appointment.AppointmentResponse;
import dev.patika.Veteriner.entity.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface AppointmentMapper {

    Appointment asEntity(AppointmentRequest request);
    AppointmentResponse asResponse(Appointment appointment);
    void update(@MappingTarget Appointment appointment, AppointmentRequest request);
    List<AppointmentResponse> asResponseList(List<Appointment> appointments);

}
