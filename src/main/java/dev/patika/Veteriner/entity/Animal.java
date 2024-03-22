
package dev.patika.Veteriner.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.patika.Veteriner.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "animals")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Animal extends BaseEntity {

  /*  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "animal_id", columnDefinition = "serial")
    private long id;*/

    @Column(name = "animal_name")
    private String name;


    @Column(name = "animal_species")
    private String species;


    @Column(name = "animal_breed")
    private String breed;

    @Column(name = "animal_gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;


    @Column(name = "animal_colour")
    private String colour;

    @Column(name = "animal_date")
    private LocalDate dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL)
    private List<Vaccine> vaccineList;

    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Appointment> appointments;



}

