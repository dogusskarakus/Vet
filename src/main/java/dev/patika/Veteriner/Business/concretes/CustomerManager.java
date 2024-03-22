/*
package dev.patika.Veteriner.Business.concretes;

import dev.patika.Veteriner.Business.abstracts.ICustomerService;
import dev.patika.Veteriner.core.exception.NotFoundException;
import dev.patika.Veteriner.core.utiles.Msg;
import dev.patika.Veteriner.dao.CustomerRepo;
import dev.patika.Veteriner.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerManager implements ICustomerService {

    private final CustomerRepo customerRepo;

    public CustomerManager(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public Customer save(Customer customer) {
        return this.customerRepo.save(customer);
    }

    @Override
    public Customer get(int id) {
        return this.customerRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public Customer update(Customer customer) {
        this.get((int) customer.getId());
        return this.customerRepo.save(customer);
    }

    @Override
    public boolean delete(int id) {
        Customer customer = this.get(id);
        this.customerRepo.delete(customer);
        return true;
    }

    @Override
    public List<Customer> getCustomersByName(String name) {
        return CustomerRepo.findByName(name);
    }

}
*/
