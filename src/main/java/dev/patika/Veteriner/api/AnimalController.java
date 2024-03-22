
package dev.patika.Veteriner.api;


import dev.patika.Veteriner.Service.AnimalService;
import dev.patika.Veteriner.core.result.Result;
import dev.patika.Veteriner.core.result.ResultData;
import dev.patika.Veteriner.core.utiles.ResultHelper;
import dev.patika.Veteriner.dto.request.animal.AnimalRequest;
import dev.patika.Veteriner.dto.response.animal.AnimalResponse;
import dev.patika.Veteriner.dto.response.customer.CustomerResponse;
import dev.patika.Veteriner.entity.Animal;
import dev.patika.Veteriner.entity.Customer;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/animals")
public class AnimalController {

    private final AnimalService animalService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AnimalResponse> save(@RequestBody @Valid AnimalRequest request){
        return new ResponseEntity<>(animalService.save(request), HttpStatus.BAD_REQUEST);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public AnimalResponse update(@PathVariable(name = "id")long id, @RequestBody AnimalRequest request){
        return animalService.update(id,request);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AnimalResponse findById(@PathVariable(name = "id") long id){
        return animalService.findById(id);
    }




    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable long id){
        animalService.deleteById(id);
    }

    @GetMapping("/find-all-by-customer-id/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public List<AnimalResponse> findAllByCustomerId(@PathVariable("customerId") Long customerId){
        return animalService.findAnimalsByCustomer(customerId);
    }
    @GetMapping("/find-by-name")
    @ResponseStatus(HttpStatus.OK)
    public List<AnimalResponse> findByName(@RequestParam String name,@RequestParam String breed){
        return animalService.findByName(name);
    }


}

