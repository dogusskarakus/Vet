package dev.patika.Veteriner.entity;

import dev.patika.Veteriner.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import javax.print.Doc;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "availableDates")
@Getter
@Setter
@Builder

public class AvailableDate extends BaseEntity {

    @Column(name = "available")
    private LocalDate availableDate;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;




}
