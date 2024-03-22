
package dev.patika.Veteriner.api;




import dev.patika.Veteriner.Service.DoctorService;
import dev.patika.Veteriner.core.result.Result;
import dev.patika.Veteriner.core.result.ResultData;
import dev.patika.Veteriner.core.utiles.ResultHelper;
import dev.patika.Veteriner.dto.request.doctor.DoctorRequest;
import dev.patika.Veteriner.dto.response.customer.CustomerResponse;
import dev.patika.Veteriner.dto.response.doctor.DoctorResponse;
import dev.patika.Veteriner.entity.Customer;
import dev.patika.Veteriner.entity.Doctor;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DoctorResponse save(@RequestBody @Valid DoctorRequest request){
        return doctorService.save(request);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public DoctorResponse update(@PathVariable(name = "id")long id, @RequestBody DoctorRequest request){
        return doctorService.update(id,request);
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DoctorResponse findById(@PathVariable(name = "id")long id){
        return doctorService.findById(id);
    }




    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable long id){
        doctorService.deleteById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<DoctorResponse> findAll(){
        return doctorService.findAll();
    }
}

