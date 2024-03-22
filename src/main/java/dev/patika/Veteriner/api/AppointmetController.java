package dev.patika.Veteriner.api;


import dev.patika.Veteriner.Service.AppointmentService;
import dev.patika.Veteriner.Service.CustomerService;
import dev.patika.Veteriner.dto.request.Appointment.AppointmentRequest;
import dev.patika.Veteriner.dto.response.Appointment.AppointmentResponse;
import io.swagger.v3.oas.annotations.links.Link;
import jakarta.servlet.http.PushBuilder;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/appointments")
public class AppointmetController {

    private final AppointmentService appointmentService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public AppointmentResponse save(@RequestBody @Valid AppointmentRequest request){
        return appointmentService.save(request);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AppointmentResponse findById(@PathVariable(name =  "id") Long id){
        return appointmentService.findById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public AppointmentResponse update(@PathVariable(name = "id")Long id,@RequestBody AppointmentRequest request){
        return appointmentService.update(id,request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable Long id){
        appointmentService.deleteById(id);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AppointmentResponse> findAll(){
        return appointmentService.findAll();
    }

    @GetMapping("/find-by-date-between-and-animal-id")
    public List<AppointmentResponse> appointmentFilterAnimal(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate finishDate,
            @RequestParam long animalId
            ){
        List<AppointmentResponse> filterAppointmentsAnimal= appointmentService.findByDateRangeAndAnimal(startDate,finishDate,animalId);
        return filterAppointmentsAnimal;
    }

    @GetMapping("/find-by-date-between-and-doctor-id")
    public List<AppointmentResponse> appointmentFilterDoctor(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate finishDate,
            @RequestParam Long doctorId){

        List<AppointmentResponse> filterAppointmentDoctor= appointmentService.findByAppointmentDateBetweenAndDoctor(startDate,finishDate,doctorId);
        return filterAppointmentDoctor;

    }



}
