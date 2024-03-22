package dev.patika.Veteriner.Mapper;

import dev.patika.Veteriner.dto.request.Vaccine.VaccineRequest;
import dev.patika.Veteriner.dto.response.Vaccine.VaccineResponse;
import dev.patika.Veteriner.entity.Vaccine;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface VaccineMapper {

    Vaccine asEntity(VaccineRequest request);
    VaccineResponse asResponse(Vaccine vaccine);
    void update(@MappingTarget Vaccine vaccine, VaccineRequest request);
    List<VaccineResponse> asResponseList(List<Vaccine> vaccineList);
}
