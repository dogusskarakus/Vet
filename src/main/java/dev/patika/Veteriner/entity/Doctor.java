
package dev.patika.Veteriner.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.patika.Veteriner.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "doctors")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Doctor extends BaseEntity {

   /* @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id", columnDefinition = "serial")
    private long id;*/

    @Column(name = "doctor_name")
    private String name;


    @Column(name = "doctor_phone")
    private String phone;


    @Column(name = "doctor_mail")
    private String mail;


    @Column(name = "doctor_address")
    private String address;


    @Column(name = "doctor_city")
    private String city;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<AvailableDate> availableDates;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Appointment> appointments;

    





}

