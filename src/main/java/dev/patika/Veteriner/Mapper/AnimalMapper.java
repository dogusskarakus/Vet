package dev.patika.Veteriner.Mapper;

import dev.patika.Veteriner.dto.request.animal.AnimalRequest;
import dev.patika.Veteriner.dto.response.animal.AnimalResponse;
import dev.patika.Veteriner.entity.Animal;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

@Mapper
public interface AnimalMapper {

    Animal asEntity(AnimalRequest request);
    AnimalResponse asResponse(Animal animal);
    void update(@MappingTarget Animal animal, AnimalRequest request);
    List<AnimalResponse> asResponseList(List<Animal> animalList);

}
