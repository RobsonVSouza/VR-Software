package com.vrSolutions.rentalsCar.controllers;

import com.vrSolutions.rentalsCar.dto.RentalDto;
import com.vrSolutions.rentalsCar.service.RentalService;
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
@RequestMapping("/rental")
public class RentalController {

    @Autowired
    private RentalService rentalService;

    @PostMapping
    public ResponseEntity<RentalDto> save(@RequestBody @Valid RentalDto brandDto){
        return ResponseEntity.status(HttpStatus.OK).body(rentalService.save(brandDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RentalDto> update(@PathVariable Long id,
            @RequestBody @Valid RentalDto rentalDto){
        return ResponseEntity.status(HttpStatus.OK).body(rentalService.update(id, rentalDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RentalDto> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(rentalService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<RentalDto>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(rentalService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        rentalService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
