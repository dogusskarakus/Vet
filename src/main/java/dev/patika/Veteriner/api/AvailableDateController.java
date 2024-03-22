package dev.patika.Veteriner.api;


import dev.patika.Veteriner.Service.AvailableDateService;
import dev.patika.Veteriner.dto.request.AvailableDate.AvailableDateRequest;
import dev.patika.Veteriner.dto.response.AvailableDate.AvailableDateResponse;
import io.swagger.v3.oas.annotations.links.Link;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/availables")
public class AvailableDateController {

    private final AvailableDateService availableDateService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public AvailableDateResponse save(@RequestBody @Valid AvailableDateRequest request){
        return availableDateService.save(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)

    public AvailableDateResponse update(@PathVariable(name = "id") Long id, @RequestBody AvailableDateRequest request){

        return availableDateService.update(id, request);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AvailableDateResponse findById(@PathVariable(name = "id") Long id){
        return availableDateService.findById(id);
    }



    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable Long id){
        availableDateService.deleteById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AvailableDateResponse> findAll(){
        return availableDateService.findAll();
    }

}
