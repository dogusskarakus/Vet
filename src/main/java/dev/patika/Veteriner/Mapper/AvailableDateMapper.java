package dev.patika.Veteriner.Mapper;

import dev.patika.Veteriner.dto.request.AvailableDate.AvailableDateRequest;
import dev.patika.Veteriner.dto.response.AvailableDate.AvailableDateResponse;
import dev.patika.Veteriner.entity.AvailableDate;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

@Mapper
public interface AvailableDateMapper {

    AvailableDate asEntity(AvailableDateRequest request);

    AvailableDateResponse asResponse(AvailableDate availableDate);

    void update(@MappingTarget AvailableDate availableDate, AvailableDateRequest request);

    List<AvailableDateResponse> asResponseList(List<AvailableDate> availableDates);
}
