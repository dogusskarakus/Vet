
package dev.patika.Veteriner.api;



import dev.patika.Veteriner.Service.CustomerService;
import dev.patika.Veteriner.core.result.Result;
import dev.patika.Veteriner.core.result.ResultData;
import dev.patika.Veteriner.core.utiles.ResultHelper;
import dev.patika.Veteriner.dto.request.customer.CustomerRequest;

import dev.patika.Veteriner.dto.response.customer.CustomerResponse;
import dev.patika.Veteriner.entity.Customer;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponse save(@RequestBody @Valid CustomerRequest request){
        return customerService.save(request);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponse update(@PathVariable(name = "id") Long id, @RequestBody CustomerRequest request) {
        return customerService.update(id, request);
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponse findById(@PathVariable(name = "id") Long id){
        return customerService.findById(id);
    }






    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable Long id) {
        customerService.deleteById(id);
    }


    @GetMapping("/filter")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerResponse> findAll() {
        return customerService.findAll();
    }

    @GetMapping("/find-by-name")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerResponse> findByName(@RequestParam String name) {
        return customerService.findByName(name);
    }





}

