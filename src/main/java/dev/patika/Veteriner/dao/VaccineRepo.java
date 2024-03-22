
package dev.patika.Veteriner.dao;

import dev.patika.Veteriner.entity.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VaccineRepo extends JpaRepository<Vaccine, Long> {

    List<Vaccine> findAllByAnimalId(Long animalId);

    List<Vaccine> findAllByProtectionStartDateBetween(LocalDate startDate, LocalDate finishDate);

}

