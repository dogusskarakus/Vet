package dev.patika.Veteriner.Service;


import dev.patika.Veteriner.Mapper.DoctorMapper;
import dev.patika.Veteriner.base.BaseService;
import dev.patika.Veteriner.dao.DoctorRepo;
import dev.patika.Veteriner.dto.request.doctor.DoctorRequest;
import dev.patika.Veteriner.dto.response.doctor.DoctorResponse;
import dev.patika.Veteriner.entity.Doctor;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DoctorService implements BaseService<Doctor, DoctorRequest, DoctorResponse> {
    private final DoctorRepo doctorRepo;
    private final DoctorMapper doctorMapper;

    @Override
    public DoctorResponse save(DoctorRequest request) {
        return doctorMapper.asResponse(
                doctorRepo.save(doctorMapper.asEntity(request))
        );
    }

    @Override
    public DoctorResponse findById(long id) {
        return doctorMapper.asResponse(findByIdEntity(id));
    }

    @Override
    public DoctorResponse update(Long id, DoctorRequest request) {
        Doctor doctor = findByIdEntity(id);
        doctorMapper.update(doctor,request);
        return doctorMapper.asResponse(doctorRepo.save(doctor));
    }

    @Override
    public void deleteById(Long id) {
        Doctor doctor= findByIdEntity(id);
        doctorRepo.delete(doctor);

    }

    @Override
    public Doctor findByIdEntity(Long id) {
        return doctorRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("doctor is not found"));
    }

    @Override
    public List<DoctorResponse> findAll() {
        return doctorMapper.asResponseList(doctorRepo.findAll());
    }
}
