package dev.patika.Veteriner.Mapper;

import dev.patika.Veteriner.dto.request.animal.AnimalRequest;
import dev.patika.Veteriner.dto.request.customer.CustomerRequest;
import dev.patika.Veteriner.dto.response.animal.AnimalResponse;
import dev.patika.Veteriner.dto.response.customer.CustomerResponse;
import dev.patika.Veteriner.entity.Animal;
import dev.patika.Veteriner.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface CustomerMapper {

    Customer asEntity(CustomerRequest request);
    CustomerResponse asResponse(Customer customer);
    void update(@MappingTarget Customer customer, CustomerRequest request);
    List<CustomerResponse> asResponseList(List<Customer> customerList);
}
