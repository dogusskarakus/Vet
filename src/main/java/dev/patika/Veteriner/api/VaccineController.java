
package dev.patika.Veteriner.api;
import dev.patika.Veteriner.Service.VaccineService;
import dev.patika.Veteriner.core.result.Result;
import dev.patika.Veteriner.core.result.ResultData;
import dev.patika.Veteriner.core.utiles.ResultHelper;
import dev.patika.Veteriner.dto.request.Vaccine.VaccineRequest;
import dev.patika.Veteriner.dto.response.Vaccine.VaccineResponse;
import dev.patika.Veteriner.dto.response.customer.CustomerResponse;
import dev.patika.Veteriner.entity.Customer;
import dev.patika.Veteriner.entity.Vaccine;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/vaccines")
public class VaccineController {

    private final VaccineService vaccineService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VaccineResponse save(@RequestBody @Valid VaccineRequest request){
        return vaccineService.save(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public VaccineResponse update(@PathVariable(name = "id") Long id, @RequestBody VaccineRequest request){
        return vaccineService.update(id,request);
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public VaccineResponse findById(@PathVariable(name = "id") Long id){
        return vaccineService.findById(id);
    }






    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable Long id){
        vaccineService.deleteById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<VaccineResponse> findAll(){
        return vaccineService.findAll();
    }

    @GetMapping("/find-all-by-animal-id/{animalId}")
    @ResponseStatus(HttpStatus.OK)
    public List<VaccineResponse> findAllByAnimalId(@PathVariable("animalId") Long animalId){
        return vaccineService.findVaccineByAnimalId(animalId);
    }

    @GetMapping("/find-all-vaccines-by-date-range")
    public List<VaccineResponse> getVaccinesByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate finishDate
            ){
        List<VaccineResponse>  vaccineResponseList = vaccineService.findVaccineByDateRange(startDate,finishDate);
        return vaccineResponseList;
    }


}

