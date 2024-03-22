package dev.patika.Veteriner.Service;


import dev.patika.Veteriner.Mapper.VaccineMapper;
import dev.patika.Veteriner.Mapper.VaccineMapperImpl;
import dev.patika.Veteriner.base.BaseEntity;
import dev.patika.Veteriner.base.BaseService;
import dev.patika.Veteriner.dao.VaccineRepo;
import dev.patika.Veteriner.dto.request.Vaccine.VaccineRequest;
import dev.patika.Veteriner.dto.response.Vaccine.VaccineResponse;
import dev.patika.Veteriner.entity.Vaccine;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class VaccineService implements BaseService<Vaccine, VaccineRequest, VaccineResponse> {

    private final VaccineRepo vaccineRepo;
    private final VaccineMapper vaccineMapper;


    @Override
    public VaccineResponse save(VaccineRequest request) {
        return vaccineMapper.asResponse(
                vaccineRepo.save(vaccineMapper.asEntity(request))
        );
    }

    @Override
    public VaccineResponse findById(long id) {
        return vaccineMapper.asResponse(findByIdEntity(id));
    }

    @Override
    public VaccineResponse update(Long id, VaccineRequest request) {
        Vaccine vaccine= findByIdEntity(id);
        vaccineMapper.update(vaccine,request);
        return vaccineMapper.asResponse(vaccineRepo.save(vaccine));


    }

    @Override
    public void deleteById(Long id) {
        Vaccine vaccine=findByIdEntity(id);
        vaccineRepo.delete(vaccine);

    }

    @Override
    public Vaccine findByIdEntity(Long id) {
        return vaccineRepo.findById(id).orElseThrow(()-> new EntityNotFoundException("Vaccine is not found"));

    }

    @Override
    public List<VaccineResponse> findAll() {
        return vaccineMapper.asResponseList(vaccineRepo.findAll());
    }

    public List<VaccineResponse> findVaccineByAnimalId(long animalId){
        return vaccineMapper.asResponseList(vaccineRepo.findAllByAnimalId(animalId));
    }

    public List<VaccineResponse> findVaccineByDateRange(LocalDate startDate, LocalDate finishDate){
        return vaccineMapper.asResponseList(
                vaccineRepo.findAllByProtectionStartDateBetween(startDate,finishDate)
        );
    }

}
