package dev.patika.Veteriner.Service;

import dev.patika.Veteriner.Mapper.AppointmentMapper;
import dev.patika.Veteriner.base.BaseService;
import dev.patika.Veteriner.dao.AppointmentRepo;
import dev.patika.Veteriner.dto.request.Appointment.AppointmentRequest;
import dev.patika.Veteriner.dto.response.Appointment.AppointmentResponse;
import dev.patika.Veteriner.entity.Appointment;
import dev.patika.Veteriner.entity.AvailableDate;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class AppointmentService implements BaseService<Appointment, AppointmentRequest, AppointmentResponse> {

    private final AppointmentRepo appointmentRepo;
    private final AppointmentMapper appointmentMapper;
    private final AvailableDateService availableDateService;

    @Override
    public AppointmentResponse save(AppointmentRequest request) {
        if (request.appointmentDate().getMinute() !=0){
            throw new RuntimeException("Saat başı randevu");
        }
        Optional<Appointment> appointmentExist= appointmentRepo.findByAppointmentDateAndAnimalIdAndDoctorId(request.appointmentDate(),request.animal().getId(),request.doctor().getId());
        if (appointmentExist.isPresent()){
            throw new RuntimeException("Bu randevu sistemde mevcut");
        }

        Optional<Appointment> appointmentExists = appointmentRepo.findByDoctorIdAndAppointmentDate(request.doctor().getId(),request.appointmentDate());
        if (appointmentExists.isPresent()){
            throw new RuntimeException("Seçmiş olduğunuz randevu saatinde doktor müsait değil");
        }

        Optional<AvailableDate> availableDateExist= availableDateService.findByAvailableDateAndDoctorId(request.appointmentDate().toLocalDate(), request.doctor().getId());
        if (appointmentExists.isEmpty()){
            throw new RuntimeException("Doctorun tatil günü");
        }

        return appointmentMapper.asResponse(
                appointmentRepo.save(appointmentMapper.asEntity(request))
        );

    }

    @Override
    public AppointmentResponse findById(long id) {

        return appointmentMapper.asResponse(findByIdEntity(id));
    }

    @Override
    public AppointmentResponse update(Long id, AppointmentRequest request) {

        Appointment appointment= findByIdEntity(id);
        appointmentMapper.update(appointment,request);
        return appointmentMapper.asResponse(appointmentRepo.save(appointment));
    }

    @Override
    public void deleteById(Long id) {

        Appointment appointment = findByIdEntity(id);
        appointmentRepo.delete(appointment);

    }

    @Override
    public Appointment findByIdEntity(Long id) {

        return appointmentRepo.findById(id).orElseThrow(()-> new EntityNotFoundException("appointment is not Found"));
    }

    @Override
    public List<AppointmentResponse> findAll() {

        return appointmentMapper.asResponseList(appointmentRepo.findAll());
    }
    public List<AppointmentResponse> findByDateRangeAndAnimal(LocalDate startDate, LocalDate finishDate, Long animalId){
        if (startDate.isAfter(finishDate)){
            throw new IllegalArgumentException("Geçerli bir başlangıç tarihi giriniz :");
        }

        List<Appointment> appointments = appointmentRepo.findByAppointmentDateBetweenAndAnimalId(startDate.atStartOfDay(),finishDate.plusDays(1).atStartOfDay(), animalId);
        return appointmentMapper.asResponseList(appointments);
    }

    public List<AppointmentResponse> findByAppointmentDateBetweenAndDoctor(LocalDate startDate, LocalDate finishDate, Long doctorId){
        if (startDate.isAfter(finishDate)){
            throw new IllegalArgumentException("Geçerli bir başlangıç tarihi giriniz :");
        }

        List<Appointment> appointments = appointmentRepo.findByAppointmentDateBetweenAndDoctorId(startDate.atStartOfDay(), finishDate.plusDays(1).atStartOfDay(),doctorId );
        return appointmentMapper.asResponseList(appointments);
    }




}
