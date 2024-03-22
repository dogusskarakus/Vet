package dev.patika.Veteriner.dao;

import dev.patika.Veteriner.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

    List<Customer> findAllByName(String name);

}
