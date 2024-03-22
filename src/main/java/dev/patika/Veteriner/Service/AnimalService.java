package dev.patika.Veteriner.Service;

import dev.patika.Veteriner.Mapper.AnimalMapper;
import dev.patika.Veteriner.base.BaseService;
import dev.patika.Veteriner.dao.AnimalRepo;
import dev.patika.Veteriner.dto.request.animal.AnimalRequest;
import dev.patika.Veteriner.dto.response.animal.AnimalResponse;
import dev.patika.Veteriner.entity.Animal;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class AnimalService implements BaseService<Animal, AnimalRequest, AnimalResponse> {

    private final AnimalRepo animalRepo;
    private final AnimalMapper animalMapper;

    @Override
    public AnimalResponse save(AnimalRequest request) {
        return animalMapper.asResponse(animalRepo.save(animalMapper.asEntity(request)));
    }

    @Override
    public AnimalResponse findById(long id) {
        return animalMapper.asResponse(findByIdEntity(id));
    }

    @Override
    public AnimalResponse update(Long id, AnimalRequest request) {
        Animal animal = findByIdEntity(id);
        animalMapper.update(animal,request);
        return animalMapper.asResponse(animalRepo.save(animal));
    }

    @Override
    public void deleteById(Long id) {
        Animal animal = findByIdEntity(id);
        animalRepo.delete(animal);

    }

    @Override
    public Animal findByIdEntity(Long id) {

        return animalRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Animal is not found"));
    }

    @Override
    public List<AnimalResponse> findAll() {
        return animalMapper.asResponseList(animalRepo.findAll());
    }

    public List<AnimalResponse> findAnimalsByCustomer(long customerId){
        return animalMapper.asResponseList(animalRepo.findByCustomerId(customerId));
    }

    public List<AnimalResponse> findByName(String name){
        return animalMapper.asResponseList(animalRepo.findAllByName(name));
    }
}
