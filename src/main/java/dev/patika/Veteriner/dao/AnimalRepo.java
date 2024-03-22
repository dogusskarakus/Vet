
package dev.patika.Veteriner.dao;

import dev.patika.Veteriner.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepo extends JpaRepository<Animal, Long> {

    List<Animal> findByCustomerId(long customerId);
    List<Animal> findAllByName(String name);
}

