package dev.patika.Veteriner.dao;

import dev.patika.Veteriner.entity.AvailableDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface AvailableDateRepo extends JpaRepository<AvailableDate, Long> {

    Optional<AvailableDate> findByAvailableDateAndDoctorId(LocalDate datetime, Long id);
}
