package com.vrSolutions.rentalsCar.controllers;

import com.vrSolutions.rentalsCar.dto.SpecificationDto;
import com.vrSolutions.rentalsCar.service.SpecificationService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/specification")
public class SpecificationController {

    @Autowired
    private SpecificationService specificationService;

    @PostMapping
    public ResponseEntity<SpecificationDto> save(@RequestBody @Valid SpecificationDto specificationDto){
        return ResponseEntity.status(HttpStatus.OK).body(specificationService.save(specificationDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SpecificationDto> update(@PathVariable Long id,
            @RequestBody @Valid SpecificationDto specificationDto){
        return ResponseEntity.status(HttpStatus.OK).body(specificationService.update(id, specificationDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpecificationDto> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(specificationService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<SpecificationDto>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(specificationService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        specificationService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
