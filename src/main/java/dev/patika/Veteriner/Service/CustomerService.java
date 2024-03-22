package dev.patika.Veteriner.Service;


import dev.patika.Veteriner.Mapper.CustomerMapper;
import dev.patika.Veteriner.base.BaseService;
import dev.patika.Veteriner.dao.CustomerRepo;
import dev.patika.Veteriner.dto.request.customer.CustomerRequest;
import dev.patika.Veteriner.dto.response.customer.CustomerResponse;
import dev.patika.Veteriner.entity.Customer;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService implements BaseService<Customer, CustomerRequest, CustomerResponse> {

    private final CustomerRepo customerRepo;
    private final CustomerMapper customerMapper;

    @Override
    public CustomerResponse save(CustomerRequest request) {
        return customerMapper.asResponse(
                customerRepo.save(customerMapper.asEntity(request))
        );
    }

    @Override
    public CustomerResponse findById(long id) {
        return customerMapper.asResponse(findByIdEntity(id));
    }

    @Override
    public CustomerResponse update(Long id, CustomerRequest request) {
        Customer customer = findByIdEntity(id);
        customerMapper.update(customer,request);
        return customerMapper.asResponse(customerRepo.save(customer));
    }

    @Override
    public void deleteById(Long id) {

        Customer customer = findByIdEntity(id);
        customerRepo.delete(customer);

    }

    @Override
    public Customer findByIdEntity(Long id) {
        return customerRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Customer not found"));

    }

    @Override
    public List<CustomerResponse> findAll() {
        return customerMapper.asResponseList(customerRepo.findAll());

    }

    public List<CustomerResponse> findByName(String name){
        return customerMapper.asResponseList(customerRepo.findAllByName(name));
    }
}
