package dev.patika.Veteriner.Service;

import dev.patika.Veteriner.Mapper.AvailableDateMapper;
import dev.patika.Veteriner.base.BaseService;
import dev.patika.Veteriner.dao.AvailableDateRepo;
import dev.patika.Veteriner.dto.request.AvailableDate.AvailableDateRequest;
import dev.patika.Veteriner.dto.response.AvailableDate.AvailableDateResponse;
import dev.patika.Veteriner.entity.AvailableDate;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AvailableDateService implements BaseService<AvailableDate, AvailableDateRequest, AvailableDateResponse> {

    private final AvailableDateRepo availableDateRepo;
    private final AvailableDateMapper availableDateMapper;

    @Override
    public AvailableDateResponse save(AvailableDateRequest request) {

        return availableDateMapper.asResponse(availableDateMapper.asEntity(request));
    }

    @Override
    public AvailableDateResponse findById(long id) {
        return availableDateMapper.asResponse(findByIdEntity(id));
    }

    @Override
    public AvailableDateResponse update(Long id, AvailableDateRequest request) {

        AvailableDate availableDate = findByIdEntity(id);
        availableDateMapper.update(availableDate, request);
        return availableDateMapper.asResponse(availableDateRepo.save(availableDate));

    }

    @Override
    public void deleteById(Long id) {

        AvailableDate availableDate= findByIdEntity(id);
        availableDateRepo.delete(availableDate);

    }

    @Override
    public AvailableDate findByIdEntity(Long id) {

        return availableDateRepo.findById(id).orElseThrow(()-> new EntityNotFoundException("date is not found"));
    }

    @Override
    public List<AvailableDateResponse> findAll() {

        return availableDateMapper.asResponseList(availableDateRepo.findAll());
    }
    public Optional<AvailableDate> findByAvailableDateAndDoctorId(LocalDate availableDate, Long id){
        return this.availableDateRepo.findByAvailableDateAndDoctorId(availableDate,id);
    }
}
